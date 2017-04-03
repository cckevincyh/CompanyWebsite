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
                <script src="${pageContext.request.contextPath}/js/contact.js"></script>
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
    		<li><a href="${pageContext.request.contextPath}/productInfoAction_findProductInfoByPage.action">企业产品</a></li>
      		<li class="active"><a href="${pageContext.request.contextPath}/contact.jsp">联系我们</a></li>
        </ul>
           
        
    </div> 
</nav>
           
	
		<div class="container" >			
			
			<div class="row">
			
			<div class="page-header">
  			  <h1>联系我们	  
  			  </h1>
  			   
		</div>
			
			
			<div class="col-lg-12">
				
					
					<br>
					<div class="col-lg-3"></div>
					<div class="col-lg-8">
					  <form class="form-horizontal" method="post" style="align-content: center">
                                    <div class="col-lg-8 form-group" >
                                        <label class="col-lg-4 control-label" for="query_ano">姓名</label>
                                        <div class="col-lg-8">
                                            <input class="form-control"  type="text" id="name">
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
                                     <div class="col-lg-8 form-group" >
                                        <label class="col-lg-4 control-label" for="query_ano">联系电话</label>
                                        <div class="col-lg-8">
                                            <input class="form-control"  type="text" id="phone">
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
                                     <div class="col-lg-8 form-group" >
                                        <label class="col-lg-4 control-label" for="query_ano">邮箱</label>
                                        <div class="col-lg-8">
                                            <input class="form-control"  type="text" id="email">
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
                					<div class="col-lg-8 form-group" >
                                        <label class="col-lg-4 control-label" for="query_ano">留言内容</label>
                                        <div class="col-lg-8">
                                           <textarea class="form-control" id="content" rows="5"  placeholder="留言内容"></textarea>
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-8 form-group" >
                                        <label class="col-lg-10 control-label" for="query_ano"></label>
                                        <button type="button" class="btn btn-primary" id="commit">提交</button>
                                    </div>
                                    
                                </form>
					</div>
					
					
				
			
				
			
					
		</div>
		
		
		   <div class="modal fade" id="modal_info" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
				    <div class="modal-dialog" role="document">
				        <div class="modal-content">
				            <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				                <h4 class="modal-title" id="infoModalLabel">提示</h4>
				            </div>
				            <div class="modal-body">
				                <div class="row">
				                    <div class="col-lg-12" id="div_info"></div>
				                </div>
				            </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-default" id="btn_info_close" data-dismiss="modal">关闭</button>
				            </div>
				        </div>
				    </div>
				</div>

 </div>
</div>

</body>
</html>