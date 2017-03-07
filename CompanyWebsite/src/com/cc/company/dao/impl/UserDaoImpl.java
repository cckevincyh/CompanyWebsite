package com.cc.company.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cc.company.dao.UserDao;
import com.cc.company.domain.PageBean;
import com.cc.company.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUserByUserName(User user) {
		String hql = "from User u where u.username=?";
		List list = this.getHibernateTemplate().find(hql, user.getUsername());
		if (list != null && list.size() > 0) {
			return (User) list.get(0);
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		boolean b = true;
		try {
			this.getHibernateTemplate().clear();
			this.getHibernateTemplate().save(user);
			this.getHibernateTemplate().flush();
		} catch (Throwable e1) {
			b = false;
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return b;
	}

	/**
	 * 
	 * @param hql传入的hql语句
	 * @param pageCode当前页
	 * @param pageSize每页显示大小
	 * @return
	 */
	public List doSplitPage(final String hql, final int pageCode,
			final int pageSize) {
		// 调用模板的execute方法，参数是实现了HibernateCallback接口的匿名类，
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					// 重写其doInHibernate方法返回一个object对象，
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// 创建query对象
						Query query = session.createQuery(hql);
						// 返回其执行了分布方法的list
						return query.setFirstResult((pageCode - 1) * pageSize)
								.setMaxResults(pageSize).list();

					}

				});

	}

	@Override
	public PageBean<User> findUserByPage(int pageCode, int pageSize) {
		PageBean<User> pb = new PageBean<User>(); // pageBean对象，用于分页
		// 根据传入的pageCode当前页码和pageSize页面记录数来设置pb对象
		pb.setPageCode(pageCode);// 设置当前页码
		pb.setPageSize(pageSize);// 设置页面记录数
		List adminList = null;
		try {
			String sql = "SELECT count(*) FROM User";
			List list = this.getSession().createQuery(sql).list();
			int totalRecord = Integer.parseInt(list.get(0).toString()); // 得到总记录数
			pb.setTotalRecord(totalRecord); // 设置总记录数
			this.getSession().close();

			// 不支持limit分页
			String hql = "from User";
			// 分页查询
			adminList = doSplitPage(hql, pageCode, pageSize);
		} catch (Throwable e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		if (adminList != null && adminList.size() > 0) {
			pb.setBeanList(adminList);
			return pb;
		}
		return null;
	}

	@Override
	public User getUserById(User user) {
		String hql = "from User u where u.userId=? ";
		List list = this.getHibernateTemplate().find(hql, user.getUserId());
		if (list != null && list.size() > 0) {
			return (User) list.get(0);
		}
		return null;
	}

	@Override
	public User updateUser(User updateUser) {
		User newUser = null;
		try {
			this.getHibernateTemplate().clear();
			// 将传入的detached(分离的)状态的对象的属性复制到持久化对象中，并返回该持久化对象
			newUser = (User) this.getHibernateTemplate().merge(updateUser);
			this.getHibernateTemplate().flush();
		} catch (Throwable e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return newUser;
	}

	@Override
	public boolean deleteUser(User user) {
		boolean b = true;
		try {
			this.getHibernateTemplate().clear();
			this.getHibernateTemplate().delete(user);
			this.getHibernateTemplate().flush();
		} catch (Throwable e1) {
			b = false;
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return b;
	}

	@Override
	public PageBean<User> queryUser(User user, int pageCode, int pageSize) {
		PageBean<User> pb = new PageBean<User>(); // pageBean对象，用于分页
		// 根据传入的pageCode当前页码和pageSize页面记录数来设置pb对象
		pb.setPageCode(pageCode);// 设置当前页码
		pb.setPageSize(pageSize);// 设置页面记录数

		StringBuilder sb = new StringBuilder();
		StringBuilder sb_sql = new StringBuilder();
		String sql = "SELECT count(*) FROM User u where 1=1 ";
		String hql = "from User u where 1=1";
		sb.append(hql);
		sb_sql.append(sql);
		if (!"".equals(user.getUsername().trim())) {
			sb.append(" and u.username like '%" + user.getUsername() + "%'");
			sb_sql.append(" and u.username like '%" + user.getUsername() + "%'");
		}

		try {

			List list = this.getSession().createQuery(sb_sql.toString()).list();
			int totalRecord = Integer.parseInt(list.get(0).toString()); // 得到总记录数
			pb.setTotalRecord(totalRecord); // 设置总记录数
			this.getSession().close();

			List<User> userList = doSplitPage(sb.toString(), pageCode, pageSize);
			if (userList != null && userList.size() > 0) {
				pb.setBeanList(userList);
				return pb;
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return null;
	}

}
