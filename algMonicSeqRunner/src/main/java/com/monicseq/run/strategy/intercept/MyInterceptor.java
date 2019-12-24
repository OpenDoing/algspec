package com.monicseq.run.strategy.intercept;

import com.monicseq.run.strategy.info.ConfigInfo;
import com.monicseq.run.strategy.info.StateInfo;
import com.monicseq.run.strategy.invoke.Invocation;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求拦截器，实现调度中心的作用
 *
 * @author Duyining
 * @date 2019/12/19
 */
@Slf4j
public class MyInterceptor implements Interceptor {

	private static MyInterceptor myInterceptor = null;
	/**
	 * 内部类，保存url的一些相关数据
	 */
	private static TempUrl turl = new TempUrl();
	/**
	 * 保存服务请求的所有状态信息
	 * key为URL  value为URL当前服务的状态信息
	 * 每一次URL调用都会实时更新map的数据
	 */
	private static Map<String,StateInfo> map = new HashMap<>(16);
	private MyInterceptor() {}

	/**
	 * 	单例模式  确保拦截器生成的实例全局唯一
	 *
	 */
	public static MyInterceptor getInstance(){
		if (myInterceptor==null){
			synchronized (MyInterceptor.class){
				if (myInterceptor==null){
					myInterceptor = new MyInterceptor();
				}
			}
		}
		return myInterceptor;
	}



	@Override
	public boolean before() {
		System.out.println("before ......");
		turl.setStart(System.currentTimeMillis());
		return true;
	}

	@Override
	public boolean useAround() {
		return true;
	}

	@Override
	public void after() {
		System.out.println("after ......");
//		int upTimes = new ConfigInfo().getRecent();

	}


	@Override
	public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
		turl.setInvocation(invocation);
//		turl.setStart(System.currentTimeMillis());
//		log.info("param:{} method:{} target:{}", invocation.getParams(), invocation.getMethod(),invocation.getTarget());
		String url = invocation.getParams()[0].toString();
		turl.setUrl(url);
		Object obj = invocation.proceed();
//		long end = System.currentTimeMillis();
//		long time = end - begin;
//		System.out.println("总耗时：" + time + "ms");
//		setTimeParam(url,map,time);
		return obj;
	}

	/**
	 * 设置吞吐量
	 * @param url 服务请求地址
	 * @param map 服务状态信息
	 */
	private void setPutParam(String url, Map<String, StateInfo> map) {
		List<Long> tlist = map.get(url).getResTime();
		int up = ConfigInfo.RECENT;
		int count = 0;
		long sum = 0;
		String result = "";
		// 只取最近若干次的时间做吞吐量计算，若干次数据从配置文件中读取
		if (tlist.size() > up){
			for (int i = tlist.size()-1;i>=tlist.size()-up;i--){
				sum+=tlist.get(i);
				//格式化小数
				DecimalFormat df = new DecimalFormat("0.000000");
				//返回的是String类型
				result = df.format((double) up/sum);
			}
		} else {
			for (long l:tlist){
				sum+=l;
				//格式化小数
				DecimalFormat df = new DecimalFormat("0.000000");
				//返回的是String类型
				result = df.format((double) tlist.size()/sum);
			}
		}
		// *1000是因为吞吐量算的是秒级别的数据
		map.get(url).setThroughput(Double.parseDouble(result)*1000);
		log.info("url：{} 当前吞吐量：{}",url,map.get(url).getThroughput());
	}

	/**
	 * 设置服务状态信息中的响应时间
	 * @param url 服务请求地址
	 * @param map 服务状态信息
	 * @param time 响应时间
	 */
	private void setTimeParam(String url, Map<String, StateInfo> map, long time) {
		if (map.get(url)==null){
			StateInfo stateInfo = new StateInfo();
			if (stateInfo.getResTime()==null){
				List<Long> longs = new ArrayList<>();
				longs.add(time);
				stateInfo.setResTime(longs);
				map.put(url, stateInfo);
			}
		}else {
			map.get(url).getResTime().add(time);
		}
		log.info("url:{} 执行时间：{} ", url, time);
	}

	@Override
	public void afterReturning() {
		System.out.println("服务请求执行成功");
		turl.setEnd(System.currentTimeMillis());
		setTimeParam(turl.getUrl(),map,turl.getEnd()-turl.getStart());
		// 更新计算吞吐量,吞吐量定义为请求成功返回
		setPutParam(turl.getUrl(),map);
		// 重置已重发次数
		map.get(turl.getUrl()).setAlrtimes(0);
		log.info("map:{}", map);
	}

	@Override
	public String afterThrowing(Invocation invocation) throws InvocationTargetException, IllegalAccessException, InterruptedException {
		System.out.println("服务请求出现了意外");
		//URL 为空时的处理逻辑
        if (map.get(turl.getUrl())==null){
            StateInfo stateInfo = new StateInfo();
            // 显示标明为1 因为这是该URL第一次出现问题
            stateInfo.setAlrtimes(1);
            map.put(turl.getUrl(), stateInfo);
        } else {
            int already = map.get(turl.getUrl()).getAlrtimes();
            map.get(turl.getUrl()).setAlrtimes(already+1);
        }
        if (map.get(turl.getUrl()).getAlrtimes() < ConfigInfo.MAXTIMES){
            // 程序虽然出了问题，可能为临时性故障
            // 重试次数没有达到阈值，可以采用重试策略
            System.out.println("excep:" + invocation.getParams()[0].toString());
//            myInterceptor.around(invocation);
            return "RETRY";
        } else if (map.get(turl.getUrl()).getReject() > ConfigInfo.MAXREJECT){
            // 超过了定义的重试阈值，并且还高于定义的拒绝访问率阈值，
            // 程序彻底崩了，采用队列缓存策略
            log.error("请求出错url:{}", turl.getUrl());
            return "QUEUECATCH";
        } else {
            // 流量控制，限制发送速率
            Thread.sleep(1000);
            myInterceptor.around(turl.getInvocation());
        }
		return "";
	}

	/**
	 * 内部类
	 */
	static class TempUrl{
		private String url;
		private long start;
		private long end;
		private Invocation invocation;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public long getStart() {
			return start;
		}

		public void setStart(long start) {
			this.start = start;
		}

		public long getEnd() {
			return end;
		}

		public void setEnd(long end) {
			this.end = end;
		}

		public Invocation getInvocation() {
			return invocation;
		}

		public void setInvocation(Invocation invocation) {
			this.invocation = invocation;
		}
	}

}
