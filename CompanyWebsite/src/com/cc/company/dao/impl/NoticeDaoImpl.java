package com.cc.company.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cc.company.dao.NoticeDao;
import com.cc.company.domain.Notice;
import com.cc.company.domain.PageBean;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

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
	public PageBean<Notice> findNoticeByPage(int pageCode, int pageSize) {
		PageBean<Notice> pb = new PageBean<Notice>(); // pageBean对象，用于分页
		// 根据传入的pageCode当前页码和pageSize页面记录数来设置pb对象
		pb.setPageCode(pageCode);// 设置当前页码
		pb.setPageSize(pageSize);// 设置页面记录数
		List noticeList = null;
		try {
			String sql = "SELECT count(*) FROM Notice";
			List list = this.getSession().createQuery(sql).list();
			int totalRecord = Integer.parseInt(list.get(0).toString()); // 得到总记录数
			pb.setTotalRecord(totalRecord); // 设置总记录数
			this.getSession().close();

			// 不支持limit分页
			String hql = "from Notice";
			// 分页查询
			noticeList = doSplitPage(hql, pageCode, pageSize);
		} catch (Throwable e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		if (noticeList != null && noticeList.size() > 0) {
			pb.setBeanList(noticeList);
			return pb;
		}
		return null;
	}

	@Override
	public boolean addNotice(Notice notice) {
		boolean b = true;
		try {
			this.getHibernateTemplate().clear();
			this.getHibernateTemplate().save(notice);
			this.getHibernateTemplate().flush();
		} catch (Throwable e1) {
			b = false;
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}
		return b;
	}

	@Override
	public Notice getNoticeById(Notice notice) {
		String hql = "from Notice n where n.nid=? ";
		List list = this.getHibernateTemplate().find(hql, notice.getNid());
		if (list != null && list.size() > 0) {
			return (Notice) list.get(0);
		}
		return null;
	}

}
