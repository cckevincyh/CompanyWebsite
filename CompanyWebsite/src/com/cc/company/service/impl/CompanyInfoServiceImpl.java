package com.cc.company.service.impl;

import com.cc.company.dao.CompanyInfoDao;
import com.cc.company.domain.CompanyInfo;
import com.cc.company.service.CompanyInfoService;

public class CompanyInfoServiceImpl implements CompanyInfoService {

	private CompanyInfoDao companyInfoDao;

	public void setCompanyInfoDao(CompanyInfoDao companyInfoDao) {
		this.companyInfoDao = companyInfoDao;
	}

	@Override
	public CompanyInfo getCompanyInfo(CompanyInfo companyInfo) {
		// TODO Auto-generated method stub
		return companyInfoDao.getCompanyInfo(companyInfo);
	}

	@Override
	public boolean addCompanyInfo(CompanyInfo companyInfo) {
		// TODO Auto-generated method stub
		return companyInfoDao.addCompanyInfo(companyInfo);
	}

	@Override
	public CompanyInfo updateCompanyInfo(CompanyInfo companyInfo) {
		// TODO Auto-generated method stub
		return companyInfoDao.updateCompanyInfo(companyInfo);
	}

}
