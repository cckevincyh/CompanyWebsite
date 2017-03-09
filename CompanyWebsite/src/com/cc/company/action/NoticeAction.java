package com.cc.company.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.cc.company.domain.Notice;
import com.cc.company.domain.PageBean;
import com.cc.company.service.NoticeService;
import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport{
	
	private NoticeService noticeService;

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	private int pageCode;
	private int id;
	
	
	
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public String getNewNotice(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Notice notice = noticeService.getNewNotice();
		JSONObject jsonObject = JSONObject.fromObject(notice);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	public String findNoticeByPage() {
		// 获取页面传递过来的当前页码数
		if (pageCode == 0) {
			pageCode = 1;
		}
		// 给pageSize,每页的记录数赋值
		int pageSize = 10;

		PageBean<Notice> pb = noticeService
				.findNoticeByPage(pageCode, pageSize);
		if (pb != null) {
			pb.setUrl("findNoticeByPage.action?");
		}
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}
	
	public String getNotice() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Notice notice = new Notice();
		notice.setNid(id);
		Notice newNotice = noticeService.getNoticeById(notice);
		JSONObject jsonObject = JSONObject.fromObject(newNotice);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}

}
