package edu.starterkit.aop;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
@Logging
public class BookDaoLogger {
	private final static Logger LOGGER = Logger.getLogger(BookDaoLogger.class.getName()); 
	
	@AroundInvoke
	public Object aroundInvokeMethod(InvocationContext context) throws Exception {
		LOGGER.log(Level.INFO, "Method : " + context.getMethod());
		LOGGER.log(Level.INFO, "Parameters : " + context.getParameters());
		Object result = context.proceed();
		LOGGER.log(Level.INFO, "Result : " + result);
		return result;
	}
}
