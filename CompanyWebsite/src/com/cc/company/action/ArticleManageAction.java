package com.cc.company.action;

import com.cc.company.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleManageAction extends ActionSupport {

	private ArticleService articleService;

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
