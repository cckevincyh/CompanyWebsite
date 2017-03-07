package com.cc.company.service.impl;

import com.cc.company.dao.NoticeDao;
import com.cc.company.domain.Notice;
import com.cc.company.domain.PageBean;
import com.cc.company.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao;

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public PageBean<Notice> findNoticeByPage(int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return noticeDao.findNoticeByPage(pageCode, pageSize);
	}

	@Override
	public boolean addNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.addNotice(notice);
	}

	@Override
	public Notice getNoticeById(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeById(notice);
	}

}
