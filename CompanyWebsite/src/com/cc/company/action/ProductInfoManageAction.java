package com.cc.company.action;

import com.cc.company.service.ProductInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class ProductInfoManageAction extends ActionSupport {

	private ProductInfoService productInfoService;

	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

}
