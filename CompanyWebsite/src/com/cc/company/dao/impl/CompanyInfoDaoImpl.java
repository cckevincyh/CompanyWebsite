package com.cc.company.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cc.company.dao.CompanyInfoDao;
import com.cc.company.domain.CompanyInfo;

public class CompanyInfoDaoImpl extends HibernateDaoSupport implements
		CompanyInfoDao {

	@Override
	public CompanyInfo getCompanyInfo(CompanyInfo companyInfo) {
		String hql = "from CompanyInfo c where c.cid=? ";
		List list = this.getHibernateTemplate().find(hql, companyInfo.getCid());
		if (list != null && list.size() > 0) {
			return (CompanyInfo) list.get(0);
		}
		return null;
	}

	@Override
	public boolean addCompanyInfo(CompanyInfo companyInfo) {
		boolean b = true;
		try {
			this.getHibernateTemplate().clear();
			this.getHibernateTemplate().save(companyInfo);
			this.getHibernateTemplate().flush();
		} catch (Throwable e1) {
			b = false;
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return b;
	}

	@Override
	public CompanyInfo updateCompanyInfo(CompanyInfo companyInfo) {
		CompanyInfo newCompanyInfo = null;
		try{
			this.getHibernateTemplate().clear();
			//将传入的detached(分离的)状态的对象的属性复制到持久化对象中，并返回该持久化对象
			newCompanyInfo = (CompanyInfo) this.getHibernateTemplate().merge(companyInfo);
			this.getHibernateTemplate().flush();
		}catch (Throwable e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return newCompanyInfo;
	}

}
