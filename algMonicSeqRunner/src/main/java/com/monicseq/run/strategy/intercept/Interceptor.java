package com.monicseq.run.strategy.intercept;

import com.monicseq.run.strategy.invoke.Invocation;
import java.lang.reflect.InvocationTargetException;
/**
 * 拦截器接口
 *
 * @author Duyining
 * @date 2019/12/19
 */
public interface Interceptor {
	/**
	 * 被代理方法之前执行的方法，if true then 使用动态代理替换原有方法的逻辑
	 * else 不改变原有代码的方法
	 * @return bool 开启环绕通知arond的开关
	 */
	boolean before();

	/**
	 * 被代理方法完成之后执行的方法
	 */
	void after();
	/**
	 * 取代原有事件方法
	 * @param invocation -- 回调参数，可以通过它的proceed方法，回调原有事件
	 * @return 原有事件返回对象
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 	是否返回方法。被代理方法没有发生异常执行
	 */
	void afterReturning();

	/**
	 * 事后异常方法，当事件发生异常后执行
	 */
	String afterThrowing(Invocation invocation) throws InvocationTargetException, IllegalAccessException, InterruptedException;

	/**
	 * 是否使用around方法取代原有方法
	 * @return bool
	 */
	boolean useAround();
	
}
