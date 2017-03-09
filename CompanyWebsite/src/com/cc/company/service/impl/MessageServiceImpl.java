package com.cc.company.service.impl;

import com.cc.company.dao.MessageDao;
import com.cc.company.domain.Message;
import com.cc.company.domain.PageBean;
import com.cc.company.service.MessageService;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public PageBean<Message> findMessageByPage(int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return messageDao.findMessageByPage(pageCode,pageSize);
	}

	@Override
	public Message getMessageById(Message message) {
		// TODO Auto-generated method stub
		return messageDao.getMessageById(message);
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDao.addMessage(message);
	}

}
