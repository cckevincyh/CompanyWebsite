<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN" class="ax-vertical-centered">
<head>
	<meta charset="UTF-8">
	<title>企业网站</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap-dropdown.min.js"></script>
               <script src="${pageContext.request.contextPath}/ajax-lib/ajaxutils.js"></script>
</head>



<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>




<body class="bootstrap-admin-with-small-navbar">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation"> 
    <div class="container-fluid"> 
        <div class="navbar-header"> 
            <a class="navbar-brand" href="#">企业网站 </a> 
        </div>
        
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/noticeAction_findNoticeByPage.action">企业公告</a></li>
            <li><a href="${pageContext.request.contextPath}/articleAction_findArticleByPage.action">企业新闻</a></li>
    		<li class="active"><a href="${pageContext.request.contextPath}/productInfoAction_findProductInfoByPage.action">企业产品</a></li>
      		<li><a href="${pageContext.request.contextPath}/contact.jsp">联系我们</a></li>
        </ul>
           
        
    </div> 
</nav>
           
	
		<div class="container">			
			
			<div class="row">
			
			<div class="page-header">
  			  <h1>企业产品
      		<div class="pull-right">
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="搜索企业产品名称">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
  			  </div>
  	 	 </h1>
		</div>
			
			
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">企业产品介绍</h3>
					</div>
					<table class="table">
						<th width="200">图片</th>
						<th width="200">产品名称</th>
						<th>产品简介 </th>
						<!---在此插入信息-->
                            <s:if test="#request.pb.beanList!=null">
                            <s:iterator value="#request.pb.beanList" var="product">
                             <tbody>
                             		<td><img src='${pageContext.request.contextPath}/<s:property value="#product.img"/>' class="img-rounded" width="100" height="100"></td>
	                         	   <td><s:property value="#product.pname"/></td>
	                         	   <td><s:property value="#product.pdesc"/></td>
	                            </tbody>
                            </s:iterator>
                            </s:if>
                            <s:else>
                            	<tbody>
	                         	   	<td>暂无数据</td>
	                                <td>暂无数据</td>    
	                                <td>暂无数据</td>                                   
                          	  </tbody>
                            </s:else>
					</table>
				</div>
			
				
				<s:if test="#request.pb!=null">
					                    
					                    		   <%-- 定义页码列表的长度，5个长 --%>
								   <c:choose>
									<%-- 第一条：如果总页数<=5，那么页码列表为1 ~ totaPage 从第一页到总页数--%>
									<%--如果总页数<=5的情况 --%>
									  <c:when test="${pb.totaPage <= 5 }">
									    <c:set var="begin" value="1"/>
									    <c:set var="end" value="${pb.totaPage }"/>
									  </c:when>
									  <%--总页数>5的情况 --%>
									  <c:otherwise>
										  	<%-- 第二条：按公式计算，让列表的头为当前页-2；列表的尾为当前页+2 --%>
										  	<c:set var="begin" value="${pb.pageCode-2 }"/>
										    <c:set var="end" value="${pb.pageCode+2 }"/>
										    
										    <%-- 第三条：第二条只适合在中间，而两端会出问题。这里处理begin出界！ --%>
										    <%-- 如果begin<1，那么让begin=1，相应end=5 --%>
										    <c:if test="${begin<1 }">
										    	<c:set var="begin" value="1"/>
										    	<c:set var="end" value="5"/>
										    </c:if>
										    <%-- 第四条：处理end出界。如果end>tp，那么让end=tp，相应begin=tp-4 --%>
										    <c:if test="${end>pb.totaPage }">
										    	<c:set var="begin" value="${pb.totaPage-4 }"/>
										    	<c:set var="end" value="${pb.totaPage }"/>
										    </c:if>
									  </c:otherwise>
								</c:choose>
                    
                        
                        <div class="pull-right"><!--右对齐--->
                           <ul class="pagination">
                           <li class="disabled"><a href="#">第<s:property value="#request.pb.pageCode"/>页/共<s:property value="#request.pb.totaPage"/>页</a></li>
                           <li><a href="${pageContext.request.contextPath}/productInfoAction_${pb.url }pageCode=1">首页</a></li>
                           <li><a href="${pageContext.request.contextPath}/productInfoAction_${pb.url }pageCode=${pb.pageCode-1 }">&laquo;</a></li><!-- 上一页 -->
                           <%-- 循环显示页码列表 --%>
								<c:forEach begin="${begin }" end="${end }" var="i">
								  <c:choose>
								  <%--如果是当前页则设置无法点击超链接 --%>
								  	<c:when test="${i eq pb.pageCode }">							  	
								  			<li class="active"><a>${i }</a><li>							 
								  	</c:when>
								  	<c:otherwise>
								  		<li><a href="${pageContext.request.contextPath}/productInfoAction_${pb.url }pageCode=${i}">${i}</a></li>
								  	</c:otherwise>
								  </c:choose>
								</c:forEach>
				        	   <%--如果当前页数没到总页数，即没到最后一页,则需要显示下一页 --%>
							  <c:if test="${pb.pageCode < pb.totaPage }">
								  <li><a href="${pageContext.request.contextPath}/productInfoAction_${pb.url }pageCode=${pb.pageCode+1}">&raquo;</a></li>
							</c:if>
							<%--否则显示尾页 --%>
							<li><a href="${pageContext.request.contextPath}/productInfoAction_${pb.url }pageCode=${pb.totaPage}">尾页</a></li>
							</ul>
                           </div>
                    </s:if>           
					
		</div>

 </div>
</div>





</body>
</html>