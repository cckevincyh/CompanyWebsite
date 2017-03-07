package com.cc.company.service;

import com.cc.company.domain.Notice;
import com.cc.company.domain.PageBean;

public interface NoticeService {

	public PageBean<Notice> findNoticeByPage(int pageCode, int pageSize);

	public boolean addNotice(Notice notice);

	public Notice getNoticeById(Notice notice);

	public Notice updateNotice(Notice updateNotice);

	public boolean deleteNotice(Notice notice);

	public PageBean<Notice> queryNotice(Notice notice, int pageCode,
			int pageSize);

}
