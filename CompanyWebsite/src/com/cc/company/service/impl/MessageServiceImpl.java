package com.cc.company.service.impl;

import com.cc.company.dao.MessageDao;
import com.cc.company.service.MessageService;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}
