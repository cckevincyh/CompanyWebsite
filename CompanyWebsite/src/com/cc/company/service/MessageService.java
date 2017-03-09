package com.cc.company.service;

import com.cc.company.domain.Message;
import com.cc.company.domain.PageBean;

public interface MessageService {

	public PageBean<Message> findMessageByPage(int pageCode, int pageSize);

	public Message getMessageById(Message message);

	public boolean addMessage(Message message);

}
