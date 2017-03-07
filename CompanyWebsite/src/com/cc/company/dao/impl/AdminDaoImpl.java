package com.cc.company.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cc.company.dao.AdminDao;
import com.cc.company.domain.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Override
	public Admin getAdmin(Admin admin) {
		String hql = "from Admin a where a.adminName=?";
		List list = this.getHibernateTemplate().find(hql, admin.getAdminName());
		if (list != null && list.size() > 0) {
			return (Admin) list.get(0);
		}
		return null;
	}

	@Override
	public Admin updateAdminPwd(Admin admin) {
		Admin newAdmin = null;
		try {
			this.getHibernateTemplate().clear();
			// 将传入的detached(分离的)状态的对象的属性复制到持久化对象中，并返回该持久化对象
			newAdmin = (Admin) this.getHibernateTemplate().merge(admin);
			this.getHibernateTemplate().flush();
		} catch (Throwable e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return newAdmin;
	}

}
