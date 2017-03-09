package com.cc.company.service;

import com.cc.company.domain.Article;
import com.cc.company.domain.PageBean;

public interface ArticleService {

	public PageBean<Article> findArticleByPage(int pageCode, int pageSize);

	public boolean addArticle(Article article);

	public Article getArticleById(Article article);

	public Article updateArticle(Article updateArticle);

	public boolean deleteArticle(Article article);

	public PageBean<Article> queryArticle(Article article, int pageCode,
			int pageSize);

	public Article getNewArticle();

}
