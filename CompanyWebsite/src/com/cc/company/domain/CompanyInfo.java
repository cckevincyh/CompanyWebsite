package com.cc.company.domain;

public class CompanyInfo {

	private Integer cid;
	private String phone;
	private String location;
	private String email;
	private String cdesc;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	@Override
	public String toString() {
		return "CompanyInfo [cid=" + cid + ", phone=" + phone + ", location="
				+ location + ", email=" + email + ", cdesc=" + cdesc + "]";
	}

}
