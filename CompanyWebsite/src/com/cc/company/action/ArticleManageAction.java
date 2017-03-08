package com.cc.company.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.Article;
import com.cc.company.domain.PageBean;
import com.cc.company.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleManageAction extends ActionSupport {

	private ArticleService articleService;

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	private int pageCode;
	
	private String title;
	private String content;
	private int id;
	private String articleInfo;
	
	
	

	
	public void setTitle(String title) {
		this.title = title;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public void setId(int id) {
		this.id = id;
	}




	public void setArticleInfo(String articleInfo) {
		this.articleInfo = articleInfo;
	}




	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}




	public String findArticleByPage(){
		// 获取页面传递过来的当前页码数
		if (pageCode == 0) {
			pageCode = 1;
		}
		// 给pageSize,每页的记录数赋值
		int pageSize = 5;

		PageBean<Article> pb = articleService.findArticleByPage(pageCode, pageSize);
		if (pb != null) {
			pb.setUrl("findArticleByPage.action?");
		}
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}
	
	
	public String addArticle(){
		Article article = new Article();
		article.setAtitle(title);
		article.setAcontent(content);
		Date date = new Date(System.currentTimeMillis());
		article.setAtime(date);
		int success = 0;
		boolean b = articleService.addArticle(article);
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
	
	
	public String getArticle(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Article article = new Article();
		article.setAid(id);
		Article newArticle = articleService.getArticleById(article);
		JSONObject jsonObject = JSONObject.fromObject(newArticle);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	public String updateArticle(){
		Article article = new Article();
		article.setAid(id);
		Article updateArticle = articleService.getArticleById(article);
		updateArticle.setAtitle(title);
		updateArticle.setAcontent(content);

		Article newArticle = articleService.updateArticle(updateArticle);
		int success = 0;
		if(newArticle!=null){
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
	
	
	
	
	
	public String deleteArticle(){
		Article article = new Article();
		article.setAid(id);
		boolean deleteNotice = articleService.deleteArticle(article);
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
	
	
	public String queryArticle(){
		//获取页面传递过来的当前页码数
		if(pageCode==0){
			pageCode = 1;
		}
		//给pageSize,每页的记录数赋值
		int pageSize = 5;
		PageBean<Article> pb = null;
		if("".equals(articleInfo.trim())){
			pb = articleService.findArticleByPage(pageCode,pageSize);
		}else{
			Article article = new Article();
			article.setAtitle(articleInfo.trim());
			pb = articleService.queryArticle(article,pageCode,pageSize);
			
		}
		if(pb!=null){
			pb.setUrl("queryArticle.action?articleInfo="+articleInfo.trim()+"&");
		}

		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}
	
}
