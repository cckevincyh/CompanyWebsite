package com.cc.company.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.Message;
import com.cc.company.domain.PageBean;
import com.cc.company.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;

public class MessageManageAction extends ActionSupport {

	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	private int pageCode;
	private int id;
	
	
	
	
	public void setId(int id) {
		this.id = id;
	}



	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}



	public String findMessageByPage(){
		// 获取页面传递过来的当前页码数
		if (pageCode == 0) {
			pageCode = 1;
		}
		// 给pageSize,每页的记录数赋值
		int pageSize = 10;

		PageBean<Message> pb = messageService.findMessageByPage(pageCode, pageSize);
		if (pb != null) {
			pb.setUrl("findMessageByPage.action?");
		}
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}
	
	public String getMessage(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Message message = new Message();
		message.setMid(id);
		Message newMessage = messageService.getMessageById(message);
		JSONObject jsonObject = JSONObject.fromObject(newMessage);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
}
