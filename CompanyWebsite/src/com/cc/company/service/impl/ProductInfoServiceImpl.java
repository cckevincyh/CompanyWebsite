package com.cc.company.service.impl;

import java.util.List;

import com.cc.company.dao.ProductInfoDao;
import com.cc.company.domain.PageBean;
import com.cc.company.domain.ProductInfo;
import com.cc.company.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {

	private ProductInfoDao productInfoDao;

	public void setProductInfoDao(ProductInfoDao productInfoDao) {
		this.productInfoDao = productInfoDao;
	}

	@Override
	public boolean addProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		return productInfoDao.addProductInfo(productInfo);
	}

	@Override
	public PageBean<ProductInfo> findProductInfoByPage(int pageCode,
			int pageSize) {
		// TODO Auto-generated method stub
		return productInfoDao.findProductInfoByPage(pageCode,pageSize);
	}

	@Override
	public ProductInfo getProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		return productInfoDao.getProductInfo(productInfo);
	}

	@Override
	public ProductInfo updateProductInfo(ProductInfo updateProductInfo) {
		// TODO Auto-generated method stub
		return productInfoDao.updateProductInfo(updateProductInfo);
	}

	@Override
	public boolean deleteProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		return productInfoDao.deleteProductInfo(productInfo);
	}

	@Override
	public PageBean<ProductInfo> queryProductInfo(ProductInfo productInfo,
			int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return productInfoDao.queryProductInfo(productInfo,pageCode,pageSize);
	}

	@Override
	public List<ProductInfo> getProductImg(int size) {
		// TODO Auto-generated method stub
		return productInfoDao.getProductImg(size);
	}

}
