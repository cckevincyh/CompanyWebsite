package com.cc.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.cc.company.domain.PageBean;
import com.cc.company.domain.ProductInfo;
import com.cc.company.service.ProductInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class ProductInfoAction extends ActionSupport{

	private ProductInfoService productInfoService;

	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	private int pageCode;
	
	
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}


	public String getProductImg(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		int size = 3;
		List<ProductInfo> infos = productInfoService.getProductImg(size);
		String json = JSONArray.fromObject(infos).toString();//List------->JSONArray
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	public String findProductInfoByPage(){
		// 获取页面传递过来的当前页码数
		if (pageCode == 0) {
			pageCode = 1;
		}
		// 给pageSize,每页的记录数赋值
		int pageSize = 10;

		PageBean<ProductInfo> pb = productInfoService.findProductInfoByPage(pageCode, pageSize);
		if (pb != null) {
			pb.setUrl("findProductInfoByPage.action?");
		}
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}
	
}
