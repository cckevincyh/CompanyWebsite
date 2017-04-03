$(function () {

    $('#regist_submit').click(function () {
		
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