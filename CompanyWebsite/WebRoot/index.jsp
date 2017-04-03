<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
       <script src="${pageContext.request.contextPath}/js/getProductImg.js"></script>
         <script src="${pageContext.request.contextPath}/js/notice.js"></script>
         <script src="${pageContext.request.contextPath}/js/article.js"></script>
         <script src="${pageContext.request.contextPath}/js/info.js"></script>
</head>



<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/other.js"></script>



<body class="bootstrap-admin-with-small-navbar">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation"> 
    <div class="container-fluid"> 
        <div class="navbar-header"> 
            <a class="navbar-brand" href="#">企业网站 </a> 
        </div>
        
          <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/noticeAction_findNoticeByPage.action">企业公告</a></li>
            <li><a href="${pageContext.request.contextPath}/articleAction_findArticleByPage.action">企业新闻</a></li>
    		<li><a href="${pageContext.request.contextPath}/productInfoAction_findProductInfoByPage.action">企业产品</a></li>
      		<li><a href="${pageContext.request.contextPath}/contact.jsp">联系我们</a></li>
        </ul>
           
     
    </div> 
</nav>
           
	
		<div class="container">			
			
			<div class="row">
			
			<div class="col-lg-12">
				<div id="myCarousel" class="carousel slide" style="height: 600px;background: #505050"">
							 <!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>   
						
						 <!-- 轮播（Carousel）项目 -->
							<input type="hidden" value="<%=basePath%>" id="BasePath"/>
								<div class="carousel-inner">
									<div class="item active">
										<img src="${pageContext.request.contextPath}/img/notfound.jpg" alt="First slide" class="img-responsive center-block" id="img1" onclick="javascript:show()">
										 <div class="carousel-caption"><p id="p1"></p></div>
									</div>
									<div class="item">
										<img src="${pageContext.request.contextPath}/img/notfound.jpg" alt="Second slide" class="img-responsive center-block" id="img2" onclick="javascript:show()">
										 <div class="carousel-caption"><p id="p2"></p></div>
									</div>
									<div class="item">
										<img src="${pageContext.request.contextPath}/img/notfound.jpg" alt="Third slide" class="img-responsive center-block" id="img3" onclick="javascript:show()">
										 <div class="carousel-caption"><p id="p3"></p></h1></div>
									</div>
								</div>

							<!-- 轮播（Carousel）导航 -->
							<a class="carousel-control left" href="#myCarousel" 
								data-slide="prev">&lsaquo;
							</a>
							<a class="carousel-control right" href="#myCarousel" 
								data-slide="next">&rsaquo;
							</a>
				</div>
			</div>
			
				<div class="col-lg-12"></div>
			
					 <div class="col-lg-12">
						<div class="jumbotron">
							<div class="container">
								<h1 style="font-weight:bold;">企业公告</h1>
								<p id="noticeTitle"></p>
								<p id="noticeContent"></p>
								<p><a class="btn btn-primary btn-lg" role="button" href="${pageContext.request.contextPath}/noticeAction_findNoticeByPage.action">
									查看更多</a>
								</p>
							</div>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="jumbotron">
							<div class="container">
									<h1 style="font-weight:bold;">企业新闻</h1>
									<p id="articleTitle"></p>
									<p id="articleContent"></p>
									<p><a class="btn btn-primary btn-lg" role="button" href="${pageContext.request.contextPath}/articleAction_findArticleByPage.action">
										查看更多</a>
									</p>
							</div>
						</div>
					</div>
			
			
			
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">企业信息</div>
					<div class="panel-body">
						<p>
							基本企业信息
						</p>
					</div>
					<ul class="list-group">
						<li class="list-group-item">企业联系方式：<p id="phone"></p></li>
						<li class="list-group-item">企业邮箱：<p id="email"></p></li>
						<li class="list-group-item">企业地址：<p id="location"></p></li>
						<li class="list-group-item">企业描述：<p id="cdesc"></p></li>
					</ul>
				</div>
	
		</div>

 </div>
</div>

</body>
</html>