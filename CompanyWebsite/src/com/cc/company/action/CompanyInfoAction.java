package com.cc.company.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.CompanyInfo;
import com.cc.company.service.CompanyInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyInfoAction extends ActionSupport {

	private CompanyInfoService companyInfoService;

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	
	
	private String phone;
	private String email;
	private String location;
	private String cdesc;
	
	
	
	
	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public void setLocation(String location) {
		this.location = location;
	}






	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}






	public String addCompanyInfo(){
		//先查询是否存在企业信息
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCid(1);
		CompanyInfo newCompanyInfo = companyInfoService.getCompanyInfo(companyInfo);
		companyInfo.setEmail(email);
		companyInfo.setCdesc(cdesc);
		companyInfo.setLocation(location);
		companyInfo.setPhone(phone);
		System.out.println(companyInfo);
		int success = 0;
		if(newCompanyInfo==null){
			//需要新添加
			boolean b = companyInfoService.addCompanyInfo(companyInfo);
			if(b){
				success = 1;
			}
		}else{
			//需要修改
			CompanyInfo updateCompanyInfo = companyInfoService.updateCompanyInfo(companyInfo);
			if(updateCompanyInfo!=null){
				success = 1;
			}
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	
	public String getCompanyInfo(){
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCid(1);
		CompanyInfo newCompanyInfo = companyInfoService.getCompanyInfo(companyInfo);
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("info", newCompanyInfo);
		return "success";
	}
	
	
}
