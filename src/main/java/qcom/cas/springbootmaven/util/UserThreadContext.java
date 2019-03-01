package qcom.cas.springbootmaven.util;

public class UserThreadContext {
	
	
	private static final ThreadLocal<ThreadContext> CONTEXT = new ThreadLocal<ThreadContext>() {
		@Override
		protected ThreadContext initialValue() {
			return new ThreadContext();
		}
	};
	
	public static ThreadContext get() {
		return CONTEXT.get();
	}
}
