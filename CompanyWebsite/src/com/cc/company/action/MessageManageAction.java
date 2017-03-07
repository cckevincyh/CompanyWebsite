package com.cc.company.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.cc.company.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;

public class MessageManageAction extends ActionSupport {

	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
