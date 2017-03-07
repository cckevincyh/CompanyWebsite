package com.cc.company.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.Notice;
import com.cc.company.domain.PageBean;
import com.cc.company.service.NoticeService;
import com.opensymphony.xwork2.ActionSupport;

public class NoticeManageAction extends ActionSupport {

	private NoticeService noticeService;

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	private int pageCode;// 当前页数
	private String title;
	private String content;
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public String findNoticeByPage() {
		// 获取页面传递过来的当前页码数
		if (pageCode == 0) {
			pageCode = 1;
		}
		// 给pageSize,每页的记录数赋值
		int pageSize = 5;

		PageBean<Notice> pb = noticeService
				.findNoticeByPage(pageCode, pageSize);
		if (pb != null) {
			pb.setUrl("findNoticeByPage.action?");
		}
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}

	public String addNotice() {
		Notice notice = new Notice();
		notice.setNtitle(title);
		notice.setNcontent(content);
		Date date = new Date(System.currentTimeMillis());
		notice.setNtime(date);
		int success = 0;
		boolean b = noticeService.addNotice(notice);
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

	public String updateNotice() {
		Notice notice = new Notice();
		notice.setNid(id);
		Notice updateNotice = noticeService.getNoticeById(notice);
		updateNotice.setNtitle(title);
		updateNotice.setNcontent(content);

		Notice newNotice = noticeService.updateNotice(updateNotice);
		int success = 0;
		if(newNotice!=null){
			success = 1;
			//由于是转发并且js页面刷新,所以无需重查
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	
	
	public String deleteNotice(){
		Notice notice = new Notice();
		notice.setNid(id);
		boolean deleteNotice = noticeService.deleteNotice(notice);
		int success = 0;
		if(deleteNotice){
			success = 1;
			//由于是转发并且js页面刷新,所以无需重查
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		
		return null;
	}

}
