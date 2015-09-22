package edu.starterkit.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import edu.starterkit.exception.BookNotNullIdException;
import edu.starterkit.to.IdAware;

@Interceptor
@NullableId
public class BookDaoAdvisor {

	@AroundInvoke
	public Object aroundInvokeMethod(InvocationContext context) throws Exception {
		checkNotNullId(context.getParameters()[0]);
		Object result = context.proceed();
		return result;
	}

	private void checkNotNullId(Object o) {
		if (o instanceof IdAware && ((IdAware) o).getId() != null) {
			throw new BookNotNullIdException();
		}
	}
}
