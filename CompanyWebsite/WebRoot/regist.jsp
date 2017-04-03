<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="bootstrap-admin-vertical-centered">
<head>
	<meta charset="UTF-8">
	<title>企业网站后台</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/jQuery/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/ajax-lib/ajaxutils.js"></script>
         <script src="${pageContext.request.contextPath}/js/regist.js"></script>
</head>

<style type="text/css">
        .alert{
            margin: 0 auto 20px;
            text-align: center;
        }
    </style>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<body class="bootstrap-admin-without-padding">
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="alert alert-info">
                <a class="close" data-dismiss="alert" href="#">&times;</a>
                欢迎注册企业会员
            </div>
            <form class="bootstrap-admin-login-form">
             <div class="col-lg-12">
                <div class="form-group">
                    <label class="control-label" for="username">账&nbsp;号</label>
                    <input type="text" class="form-control" id="username" placeholder="会员用户名"/>
                    <label class="control-label" for="username" style="display:none;"></label>
                </div>
                <div class="form-group">
                    <label class="control-label" for="pwd">密&nbsp;码</label>
                    <input type="password" class="form-control" id="pwd" placeholder="密码"/>
                    <label class="control-label" for="pwd" style="display:none;"></label>
                </div>
                <div class="form-group">
                    <label class="control-label" for="cpwd">确&nbsp;认&nbsp;密&nbsp;码</label>
                    <input type="password" class="form-control" id="cpwd" placeholder="密码"/>
                    <label class="control-label" for="cpwd" style="display:none;"></label>
                </div>
                 </div>
                <div class="col-lg-6">
                <div class="form-group">
                    <input type="text" class="form-control" id="vCode" placeholder="验证码"/>
                    <label class="control-label" for="vCode" style="display:none;"></label>
                </div>
                </div>
                 <div class="col-lg-6">
                <div class="form-group">
                    <img src="${pageContext.request.contextPath}/userAction_getVerifyCode.action" id="vCode_img" width="140" height="39" alt="验证码" title="看不清可单击图片刷新" onClick="javascript:_change()" style="cursor:hand"/>
                </div>
                </div>
                &nbsp;&nbsp;&nbsp;
                <input type="button" class="btn btn-lg btn-primary" id="regist_submit" value="注&nbsp;&nbsp;&nbsp;&nbsp;册"/>
            	<a href="${pageContext.request.contextPath}/userLogin.jsp">已经是会员?去登录</a>
                </div>
            </form>
        </div>
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
</body>
</html>