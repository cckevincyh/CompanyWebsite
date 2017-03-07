package com.cc.company.action;

import com.cc.company.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
