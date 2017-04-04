package com.cc.company.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cc.company.domain.User;



public class UserFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		//从session中获取用户对象
		Object obj =  session.getAttribute("user");
		if(obj!=null && obj instanceof User){
			//用户为管理员,放行
			chain.doFilter(request, response);
			
		}else{
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}