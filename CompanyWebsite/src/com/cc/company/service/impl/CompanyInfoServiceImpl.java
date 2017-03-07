package com.cc.company.service.impl;

import com.cc.company.dao.CompanyInfoDao;
import com.cc.company.service.CompanyInfoService;

public class CompanyInfoServiceImpl implements CompanyInfoService {

	private CompanyInfoDao companyInfoDao;

	public void setCompanyInfoDao(CompanyInfoDao companyInfoDao) {
		this.companyInfoDao = companyInfoDao;
	}

}
