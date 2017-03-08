package com.cc.company.service;

import com.cc.company.domain.CompanyInfo;

public interface CompanyInfoService {

	public CompanyInfo getCompanyInfo(CompanyInfo companyInfo);

	public boolean addCompanyInfo(CompanyInfo companyInfo);

	public CompanyInfo updateCompanyInfo(CompanyInfo companyInfo);

}
