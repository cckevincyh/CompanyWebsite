package com.cc.company.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.cc.company.domain.PageBean;
import com.cc.company.domain.ProductInfo;
import com.cc.company.service.ProductInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class ProductInfoManageAction extends ActionSupport {

	private ProductInfoService productInfoService;

	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	private String pname;
	private String pdesc;
	private String img;
	private int pageCode;
	private int id;
	
	
	
	
	
	
	
	public void setId(int id) {
		this.id = id;
	}




	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}




	public void setPname(String pname) {
		this.pname = pname;
	}




	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}




	public void setImg(String img) {
		this.img = img;
	}




	public String addProductInfo(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setPname(pname);
		productInfo.setPdesc(pdesc);
		productInfo.setImg(img);
		int success = 0;
		boolean b = productInfoService.addProductInfo(productInfo);
		if (b) {
			success = 1;
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);// 向浏览器响应是否成功的状态码
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		int pageSize = 5;

		PageBean<ProductInfo> pb = productInfoService.findProductInfoByPage(pageCode, pageSize);
		if (pb != null) {
			pb.setUrl("findProductInfoByPage.action?");
		}
		// 存入request域中
		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}
	
	
	
	
	public String getProductInfo(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		ProductInfo productInfo = new ProductInfo();
		productInfo.setPid(id);
		ProductInfo newproductInfo = productInfoService.getProductInfo(productInfo);
		JSONObject jsonObject = JSONObject.fromObject(newproductInfo);
		try {
			response.getWriter().print(jsonObject);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	public String updateProductInfo(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setPid(id);
		ProductInfo updateProductInfo = productInfoService.getProductInfo(productInfo);
		updateProductInfo.setPname(pname);
		updateProductInfo.setPdesc(pdesc);
		updateProductInfo.setImg(img);
		ProductInfo newProductInfo = productInfoService.updateProductInfo(updateProductInfo);
		int success = 0;
		if(newProductInfo!=null){
			success = 1;
			//由于是转发并且js页面刷新,所以无需重查
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	
	public String deleteProductInfo(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setPid(id);
		boolean deleteNotice = productInfoService.deleteProductInfo(productInfo);
		int success = 0;
		if(deleteNotice){
			success = 1;
			//由于是转发并且js页面刷新,所以无需重查
		}
		try {
			ServletActionContext.getResponse().getWriter().print(success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
		
		return null;
	}
	
	
	public String queryProductInfo(){
		//获取页面传递过来的当前页码数
		if(pageCode==0){
			pageCode = 1;
		}
		//给pageSize,每页的记录数赋值
		int pageSize = 5;
		PageBean<ProductInfo> pb = null;
		if("".equals(pname.trim())){
			pb = productInfoService.findProductInfoByPage(pageCode, pageSize);
		}else{
			ProductInfo productInfo = new ProductInfo();
			productInfo.setPname(pname.trim());
			pb = productInfoService.queryProductInfo(productInfo,pageCode,pageSize);
			
		}
		if(pb!=null){
			pb.setUrl("queryProductInfo.action?pname="+pname.trim()+"&");
		}

		ServletActionContext.getRequest().setAttribute("pb", pb);
		return "success";
	}
	
	
}
