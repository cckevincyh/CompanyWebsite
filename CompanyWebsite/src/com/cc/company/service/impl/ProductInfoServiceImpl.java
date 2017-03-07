package com.cc.company.service.impl;

import com.cc.company.dao.ProductInfoDao;
import com.cc.company.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {

	private ProductInfoDao productInfoDao;

	public void setProductInfoDao(ProductInfoDao productInfoDao) {
		this.productInfoDao = productInfoDao;
	}

}
