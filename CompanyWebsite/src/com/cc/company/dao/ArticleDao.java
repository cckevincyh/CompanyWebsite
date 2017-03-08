package com.cc.company.dao;

import com.cc.company.domain.Article;
import com.cc.company.domain.PageBean;

public interface ArticleDao {

	public PageBean<Article> findArticleByPage(int pageCode, int pageSize);

	public boolean addArticle(Article article);

	public Article getArticleById(Article article);

	public Article updateArticle(Article updateArticle);

	public boolean deleteArticle(Article article);

	public PageBean<Article> queryArticle(Article article, int pageCode,
			int pageSize);

}
