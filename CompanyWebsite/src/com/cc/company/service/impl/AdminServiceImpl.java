package com.cc.company.service.impl;

import com.cc.company.dao.AdminDao;
import com.cc.company.domain.Admin;
import com.cc.company.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin getAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.getAdmin(admin);
	}

	@Override
	public Admin updateAdminPwd(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.updateAdminPwd(admin);
	}

}
