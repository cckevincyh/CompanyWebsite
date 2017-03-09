package com.cc.company.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.Article;
import com.cc.company.domain.PageBean;
import com.cc.company.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport{
	private ArticleService articleService;

	private int id;
	private int pageCode;
	
	
	
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public String getNewArticle(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Article article = articleService.getNewArticle();
		JSONObject jsonObject = JSONObject.fromObject(article);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
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
}
