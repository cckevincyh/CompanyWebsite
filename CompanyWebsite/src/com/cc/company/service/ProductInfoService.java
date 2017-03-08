package com.cc.company.service;

import com.cc.company.domain.PageBean;
import com.cc.company.domain.ProductInfo;

public interface ProductInfoService {

	public boolean addProductInfo(ProductInfo productInfo);

	public PageBean<ProductInfo> findProductInfoByPage(int pageCode,
			int pageSize);

	public ProductInfo getProductInfo(ProductInfo productInfo);

	public ProductInfo updateProductInfo(ProductInfo updateProductInfo);

	public boolean deleteProductInfo(ProductInfo productInfo);

	public PageBean<ProductInfo> queryProductInfo(ProductInfo productInfo,
			int pageCode, int pageSize);

}
