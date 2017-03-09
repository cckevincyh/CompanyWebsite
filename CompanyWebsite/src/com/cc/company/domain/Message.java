package com.cc.company.domain;

import java.util.Date;

public class Message {

	private Integer mid;
	private String mcontent;
	private Date mtime;
	private String name;
	private String phone;
	private String email;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public Message(String mcontent, Date mtime, String name, String phone,
			String email) {
		super();
		this.mcontent = mcontent;
		this.mtime = mtime;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Message() {

	}
	
	

	
}
