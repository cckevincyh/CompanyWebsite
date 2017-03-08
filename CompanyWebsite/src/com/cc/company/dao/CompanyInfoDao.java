package com.cc.company.dao;

import com.cc.company.domain.CompanyInfo;

public interface CompanyInfoDao {

	public CompanyInfo getCompanyInfo(CompanyInfo companyInfo);

	public boolean addCompanyInfo(CompanyInfo companyInfo);

	public CompanyInfo updateCompanyInfo(CompanyInfo companyInfo);

}
