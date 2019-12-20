package com.monicseq.run.strategy.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 方法调用
 *
 * @author Duyining
 * @date 2019/12/19
 */
public class Invocation {

	private Object[] params;
	private Method method;
	private Object target;
	
	public Invocation(Object target, Method method, Object[] params) {
		this.target = target;
		this.method = method;
		this.params = params;
	}
	
	public Object proceed() throws InvocationTargetException, IllegalAccessException {
		return method.invoke(target, params);
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	
}
