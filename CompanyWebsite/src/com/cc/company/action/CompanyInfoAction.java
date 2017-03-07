package com.cc.company.action;

import com.cc.company.service.CompanyInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyInfoAction extends ActionSupport {

	private CompanyInfoService companyInfoService;

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

}
