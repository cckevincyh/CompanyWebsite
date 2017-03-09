package com.cc.company.service.impl;

import com.cc.company.dao.ArticleDao;
import com.cc.company.domain.Article;
import com.cc.company.domain.PageBean;
import com.cc.company.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public PageBean<Article> findArticleByPage(int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return articleDao.findArticleByPage(pageCode,pageSize);
	}

	@Override
	public boolean addArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.addArticle(article);
	}

	@Override
	public Article getArticleById(Article article) {
		// TODO Auto-generated method stub
		return articleDao.getArticleById(article);
	}

	@Override
	public Article updateArticle(Article updateArticle) {
		// TODO Auto-generated method stub
		return articleDao.updateArticle(updateArticle);
	}

	@Override
	public boolean deleteArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.deleteArticle(article);
	}

	@Override
	public PageBean<Article> queryArticle(Article article, int pageCode,
			int pageSize) {
		// TODO Auto-generated method stub
		return articleDao.queryArticle(article,pageCode,pageSize);
	}

	@Override
	public Article getNewArticle() {
		// TODO Auto-generated method stub
		return articleDao.getNewArticle();
	}

}
