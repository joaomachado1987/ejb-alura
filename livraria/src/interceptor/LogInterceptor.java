package interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@AroundInvoke
	public Object interceptor(InvocationContext context ) throws Exception {
		long millis = System.currentTimeMillis();
		
		Object o = context.proceed();
		
		String metohd = context.getMethod().getName();
		String clazz = context.getClass().getSimpleName();
		
		System.out.println("Tempo gasto no método " + metohd + " da classe " + clazz + " :" + (System.currentTimeMillis() - millis));
		
		return o;
	}
}
