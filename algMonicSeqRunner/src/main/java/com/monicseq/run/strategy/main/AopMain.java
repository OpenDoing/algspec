package com.monicseq.run.strategy.main;

import com.monicseq.run.request.HttpRequest;
import com.monicseq.run.request.method.GetRequest;
import com.monicseq.run.strategy.intercept.MyInterceptor;
import com.monicseq.run.strategy.proxy.ProxyBean;

import java.text.DecimalFormat;
import java.util.HashMap;

public class AopMain {

	public static void main(String[] args) throws InterruptedException {
		DecimalFormat df = new DecimalFormat("0.0000");
		//返回的是String类型
		String result = df.format((double) 1/0.485);
		System.out.println(result);
		testProxy();
	}
	
	private static void testProxy() throws InterruptedException {
		HttpRequest helloService = new GetRequest();
		HttpRequest proxy = (HttpRequest) ProxyBean.getProxyBean(helloService, MyInterceptor.getInstance());
		HashMap hashMap = new HashMap(1);
		hashMap.put("id", 1);
		HashMap hashMap2 = new HashMap(1);
		hashMap2.put("id", 2);
		for (int i = 0;i<20;i++){
			proxy.sendRequest("http://47.100.124.249:8001/array",hashMap);
			Thread.sleep(1000);
			proxy.sendRequest("http://47.100.124.249:8001/array/min",hashMap2);
		}
	}

}
