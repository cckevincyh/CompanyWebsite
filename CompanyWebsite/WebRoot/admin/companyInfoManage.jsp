<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="ax-vertical-centered">
<head>
	<meta charset="UTF-8">
	<title>企业网站后台</title>
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
           
             <script src="${pageContext.request.contextPath}/js/adminUpdatePwd.js"></script>
        
             <script src="${pageContext.request.contextPath}/js/companyInfo.js"></script>
        
</head>



<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<body class="bootstrap-admin-with-small-navbar">
    <nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="collapse navbar-collapse main-navbar-collapse">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/admin.jsp"><strong>欢迎进入企业网站后台</strong></a>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown"> <i class="glyphicon glyphicon-user"></i> 欢迎您， <s:property value="#session.admin.adminName"/> <i class="caret"></i></a>
                            
                                 <ul class="dropdown-menu">
                                    <li><a href="#updatepwd" data-toggle="modal">修改密码</a></li>
                                     <li role="presentation" class="divider"></li>
                                    <li><a href="${pageContext.request.contextPath}/adminAction_logout.action">退出</a></li>
                                </ul>
                                
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>

    <div class="container">
        <!-- left, vertical navbar & content -->
        <div class="row">
            <!-- left, vertical navbar -->
            <div class="col-md-2 bootstrap-admin-col-left">
                <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                	 <li>
                        <a href="${pageContext.request.contextPath}/admin/userManageAction_findUserByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 会员管理</a>
                    </li> 
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/noticeManageAction_findNoticeByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 企业公告管理</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/articleManageAction_findArticleByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 企业新闻管理</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath}/admin/productInfoManageAction_findProductInfoByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 企业产品管理</a>
                    </li>
                    
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/admin/companyInfoAction_getCompanyInfo.action"><i class="glyphicon glyphicon-chevron-right"></i> 企业信息管理</a>
                    </li>
                     <li>
                        <a href="${pageContext.request.contextPath}/admin/messageManageAction_findMessageByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 留言管理</a>
                    </li>
                   
                </ul>
            </div>

           <!-- content -->
            <div class="col-md-10">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">企业信息</div>
                            </div>
                            <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                                <form class="form-horizontal">
                                    <div class="col-lg-9 form-group">
                                        <label class="col-lg-4 control-label" for="query_ano">企业联系方式</label>
                                        <div class="col-lg-8">
                                            <input class="form-control"  type="text" id="phone" name="phone" value="<s:property value="#request.info.phone"/>">
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
                                     <div class="col-lg-9 form-group">
                                        <label class="col-lg-4 control-label" for="query_ano">企业邮箱</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" type="text" id="email" name="email" value="<s:property value="#request.info.email"/>">
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
                                     <div class="col-lg-9 form-group">
                                        <label class="col-lg-4 control-label" for="query_ano">企业位置</label>
                                        <div class="col-lg-8">
                                            <input class="form-control"  type="text" id="location" name="location" value="<s:property value="#request.info.location"/>">
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
                                    <div class="col-lg-9 form-group">
                                        <label class="col-lg-4 control-label" for="query_ano">企业描述</label>
                                        <div class="col-lg-8">
                                            <input class="form-control"  type="text" id="cdesc" name="cdesc" value="<s:property value="#request.info.cdesc"/>">
                                            <label class="control-label" for="query_ano" style="display: none;"></label>
                                        </div>
                                    </div>
               
                                    <div class="col-lg-1 form-group">
                                        <button type="button" class="btn btn-primary" id="btn_add">提交</button>          
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
               
            </div>
        </div>
    </div>
    
    

 
    
    <!------------------------------修改密码模糊框-------------------------------->  
                 
                   <form class="form-horizontal">   <!--保证样式水平不混乱-->                  
                                     <!-- 模态框（Modal） -->
				<div class="modal fade" id="updatepwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
									修改密码
								</h4>
							</div>
							
							<div class="modal-body">
							 
								<!--正文-->
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">原密码</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" id="oldPwd"  placeholder="请输入原密码">
												
								</div>
							</div>	
							
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">新密码</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" id="newPwd"  placeholder="请输入新密码">
												
								</div>
							</div>	
							
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">确认密码</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" id="confirmPwd"  placeholder="请输入确认密码">
												
								</div>
							</div>	
								<!--正文-->
								
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<button type="button" class="btn btn-primary" id="update_adminPwd">
									修改
								</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>

				</form>	
                                   <!-------------------------------------------------------------->
                                   
                                   
                                   
                                   
                                   
                                   
                      
    
    
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
