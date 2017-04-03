package com.cc.company.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.PageBean;
import com.cc.company.domain.User;
import com.cc.company.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserManageAction extends ActionSupport {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String username;
	private String pwd;
	private int pageCode;// 当前页数
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String addUser() {

		User user = new User();
		user.setUsername(username);
		User user2 = userService.getUserByUserName(user);
		int success = 0;
		if (user2 != null) {
			success = -1;
		} else {
			user.setPwd(pwd);
			user.setState(1);//设置会员状态为审核通过的
			boolean b = userService.addUser(user);
			if (!b) {
				success = 0;
			} else {
				success = 1;
				// 由于是转发并且js页面刷新,所以无需重查
			}
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);// 向浏览器响应是否成功的状态码
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}

	public String findUserByPage() {
		// 获取页面传递过来的当前页码数
		if (pageCode == 0) {
			pageCode = 1;
		}
		// 给pageSize,每页的记录数赋值
		int pageSize = 5;

		PageBean<User> pb = userService.findUserByPage(pageCode, pageSize);
		if (pb != null) {
			pb.setUrl("findUserByPage.action?");
		}
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}

	public String getUser() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		User user = new User();
		user.setUserId(id);
		User newUser = userService.getUserById(user);
		JSONObject jsonObject = JSONObject.fromObject(newUser);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}

	public String updateUser() {
		User user = new User();
		user.setUserId(id);
		User updateUser = userService.getUserById(user);
		updateUser.setUsername(username);
		updateUser.setPwd(pwd);
		User newUser = userService.updateUser(updateUser);
		int success = 0;
		if (newUser != null) {
			success = 1;
			// 由于是转发并且js页面刷新,所以无需重查
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}

	public String deleteUser() {
		User user = new User();
		user.setUserId(id);
		boolean deleteUser = userService.deleteUser(user);
		int success = 0;
		if (deleteUser) {
			success = 1;
			// 由于是转发并且js页面刷新,所以无需重查
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

		return null;
	}

	public String queryUser() {
		// 获取页面传递过来的当前页码数
		if (pageCode == 0) {
			pageCode = 1;
		}
		// 给pageSize,每页的记录数赋值
		int pageSize = 5;
		PageBean<User> pb = null;
		if ("".equals(username)) {
			pb = userService.findUserByPage(pageCode, pageSize);
		} else {
			User user = new User();
			user.setUsername(username.trim());
			pb = userService.queryUser(user, pageCode, pageSize);

		}
		if (pb != null) {
			pb.setUrl("queryUser.action?username=" + username.trim() + "&");
		}

		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";

	}
}
