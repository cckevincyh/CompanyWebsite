package com.cc.company.dao;

import java.util.List;

import com.cc.company.domain.PageBean;
import com.cc.company.domain.ProductInfo;

public interface ProductInfoDao {

	public boolean addProductInfo(ProductInfo productInfo);

	public PageBean<ProductInfo> findProductInfoByPage(int pageCode,
			int pageSize);

	public ProductInfo getProductInfo(ProductInfo productInfo);

	public ProductInfo updateProductInfo(ProductInfo updateProductInfo);

	public boolean deleteProductInfo(ProductInfo productInfo);

	public PageBean<ProductInfo> queryProductInfo(ProductInfo productInfo,
			int pageCode, int pageSize);

	public List<ProductInfo> getProductImg(int size);

}
