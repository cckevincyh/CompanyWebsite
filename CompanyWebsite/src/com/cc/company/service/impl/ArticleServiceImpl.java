package com.cc.company.service.impl;

import com.cc.company.dao.ArticleDao;
import com.cc.company.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
