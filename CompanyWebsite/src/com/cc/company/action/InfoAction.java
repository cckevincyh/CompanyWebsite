package com.cc.company.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.CompanyInfo;
import com.cc.company.service.CompanyInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class InfoAction extends ActionSupport{

	private CompanyInfoService companyInfoService;

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}
	
	public String getInfo(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCid(1);
		CompanyInfo companyInfo2 = companyInfoService.getCompanyInfo(companyInfo);
		JSONObject jsonObject = JSONObject.fromObject(companyInfo2);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
}
