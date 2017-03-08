package com.cc.company.dao;

import com.cc.company.domain.Message;
import com.cc.company.domain.PageBean;

public interface MessageDao {

	public PageBean<Message> findMessageByPage(int pageCode, int pageSize);

	public Message getMessageById(Message message);

}
