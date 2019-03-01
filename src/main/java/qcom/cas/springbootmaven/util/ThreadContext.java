package qcom.cas.springbootmaven.util;

import qcom.cas.springbootmaven.Model.User;

public class ThreadContext {
	
	private User user;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
