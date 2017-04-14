$(function () {

    $('#regist_submit').click(function () {
		
		if(!validRegist()){
			return ;
		}
		
	var postdata = "username="+$.trim($("#username").val())+"&pwd="+ $.trim($("#pwd").val())+"&vcode="+ $.trim($("#vCode").val());
	ajax(
			
    		  {
			  	method:'POST',
	    		url:'userAction_regist.action',
				params: postdata,
	    		callback:function(data) {
					if(data==1){
						 window.location.href = "successRegister.jsp";//注册成功
					}else if(data==0){
						showInfo("注册失败");
					}else if(data==-1){
						showInfo("验证码错误");
					}else if(data==-2){
						showInfo("用户名已存在");
					}
					
								
				}
			}
			   
    	);
			
		
	});
   
	
		
		
		var alert = $('.alert');
	    var formWidth = $('.bootstrap-admin-login-form').innerWidth();
	    var alertPadding = parseInt($('.alert').css('padding'));
	    if (isNaN(alertPadding)) {
	        alertPadding = parseInt($(alert).css('padding-left'));
	    }
	    $('.alert').width(formWidth - 2 * alertPadding);

});




function validRegist() {
    var flag = true;

    var username = $.trim($("#username").val());
    if (username == "") {
        $('#username').parent().addClass("has-error");
        $('#username').next().text("请输入账号");
        $("#username").next().show();
        flag = false;
    } else if (username.length<2 || username.length > 15) {
        $("#username").parent().addClass("has-error");
        $("#username").next().text("账号长度必须在2~15之间");
        $("#username").next().show();
        flag = false;
    } else {
        $('#username').parent().removeClass("has-error");
        $('#username').next().text("");
        $("#username").next().hide();
    }

    var password = $.trim($("#pwd").val());
    if (password == "") {
        $('#pwd').parent().addClass("has-error");
        $('#pwd').next().text("请输入密码");
        $("#pwd").next().show();
        flag = false;
    } else if (password.length<3||password.length > 15) {
        $("#pwd").parent().addClass("has-error");
        $("#pwd").next().text("密码长度必须在3~15之间");
        $("#pwd").next().show();
        flag = false;
    } else {
        $('#pwd').parent().removeClass("has-error");
        $('#pwd').next().text("");
        $("#pwd").next().hide();
    }
	
	
	var confirmPwd = $.trim($("#cpwd").val());
    if (confirmPwd == "") {
        $('#cpwd').parent().addClass("has-error");
        $('#cpwd').next().text("请输入确认密码");
        $("#cpwd").next().show();
        flag = false;
    } else if (confirmPwd.length<3 || confirmPwd.length > 15) {
        $("#cpwd").parent().addClass("has-error");
        $("#cpwd").next().text("密码长度必须在3~15之间");
        $("#cpwd").next().show();
        flag = false;
    }else if (confirmPwd!=password) {
        $("#cpwd").parent().addClass("has-error");
        $("#cpwd").next().text("确认密码不一致");
        $("#cpwd").next().show();
        flag = false;
    } else {
        $('#cpwd').parent().removeClass("has-error");
        $('#cpwd').next().text("");
        $("#cpwd").next().hide();
    }
	
	
	var vCode = $.trim($("#vCode").val());
    if (vCode == "") {
        $('#Code').parent().addClass("has-error");
        $('#Code').next().text("请输入验证码");
        $("#Code").next().show();
        flag = false;
    } else if (vCode.length!=4) {
        $("#Code").parent().addClass("has-error");
        $("#Code").next().text("验证码长度必须为4");
        $("#Code").next().show();
        flag = false;
    } else {
        $('#Code').parent().removeClass("has-error");
        $('#Code').next().text("");
        $("#Code").next().hide();
    }
	
    return flag;
}


//点击切换验证码
function _change() {
	/*
	1. 获取<img>元素
	*/
	var ele = document.getElementById("vCode_img");
	ele.src = "userAction_getVerifyCode.action?cairou=" + new Date().getTime();
	
}


function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}