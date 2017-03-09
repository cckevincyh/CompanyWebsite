package com.cc.company.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.Message;
import com.cc.company.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport {

	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	private String name;
	private String email;
	private String phone;
	private String content;
	
	
	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String addMessage(){
		Date time = new Date(System.currentTimeMillis()); 
		Message message = new Message(content, time, name, phone, email);
		boolean b = messageService.addMessage(message);
		int success = 0;
		if (b) {
			success = 1;
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);// 向浏览器响应是否成功的状态码
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
}
