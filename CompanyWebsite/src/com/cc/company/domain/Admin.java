package com.cc.company.domain;

public class Admin {

	private String adminName;
	private String pwd;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Admin(String adminName, String pwd) {
		super();
		this.adminName = adminName;
		this.pwd = pwd;
	}

	public Admin() {

	}

}
