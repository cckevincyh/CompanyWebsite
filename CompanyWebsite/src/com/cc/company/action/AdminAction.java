package com.cc.company.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.Admin;
import com.cc.company.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	private String adminName;
	private String pwd;
	private String oldPwd;
	private String newPwd;
	private String confirmPwd;

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Ajax异步请求获得登录许可
	 * 
	 * @return 返回登录状态
	 */
	public String login() {
		// 管理员
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		admin.setPwd(pwd);
		Admin newAdmin = adminService.getAdmin(admin);
		int login = 1;
		if (newAdmin == null) {
			// 用户名不存在
			login = -1;
		} else if (!newAdmin.getPwd().equals(admin.getPwd())) {
			// 密码不正确
			login = -2;
		} else {
			// 存储入session
			ServletActionContext.getContext().getSession().put("admin", newAdmin);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(login);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}

	/**
	 * 退出登录
	 */
	public String logout() {
		ServletActionContext.getContext().getSession().remove("admin");
		return "logout";
	}

	/**
	 * 管理员密码修改
	 * 
	 * @return
	 */
	public String adminPwd() {
		Admin admin = (Admin) ServletActionContext.getContext().getSession()
				.get("admin");
		int state = -1;// 原密码错误
		// 取出原密码进行比对
		if (admin.getPwd().equals(oldPwd)) {
			if (newPwd.equals(confirmPwd)) {
				state = 1;// 修改成功
				admin.setPwd(newPwd);
				admin = adminService.updateAdminPwd(admin);
				// 重新存入session
				ServletActionContext.getContext().getSession()
						.put("admin", admin);
			} else {
				state = 0;// 确认密码不一致
			}
		}
		try {
			ServletActionContext.getResponse().getWriter().print(state);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
}
