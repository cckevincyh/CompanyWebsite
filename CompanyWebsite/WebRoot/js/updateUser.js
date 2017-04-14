

$(function () {
	

    $('#updateUser').click(function () {
    	
    	if(!validUpdateUser()){
    		return ;
    	}
    	
	var postdata = "id="+$.trim($("#updateId").val())+"&username="+$.trim($("#updateUsername").val())+"&pwd="+ $.trim($("#updatePwd").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/userManageAction_updateUser.action',
				params: postdata,
	    		callback:function(data) {
					if (data == 1) {
						$("#updateModal").modal("hide");//关闭模糊框		
						showInfo("修改成功");	

	                }else {
						$("#updateinfo").modal("hide");//关闭模糊框
	                    showInfo("修改失败");
	                }
								
				}
			}
			   
    	);
			
		
	});
	
		$('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
       		 location.reload();  	//刷新当前页面
    	});
	
	

});






function validUpdateUser() {
    var flag = true;



    
	  var name = $.trim($("#updateUsername").val());
	    if (name == "") {
	        $('#updateUsername').parent().addClass("has-error");
	        $('#updateUsername').next().text("请输入会员用户名");
	        $("#updateUsername").next().show();
	        flag = false;
	    }else {
	        $('#updateUsername').parent().removeClass("has-error");
	        $('#updateUsername').next().text("");
	        $("#updateUsername").next().hide();
	    }
	
    var pwd = $.trim($("#updatePwd").val());
    if (pwd == "") {
        $('#updatePwd').parent().addClass("has-error");
        $('#updatePwd').next().text("请输入密码");
        $("#updatePwd").next().show();
        flag = false;
    } else if (pwd.length<3 || pwd.length > 15) {
        $("#updatePwd").parent().addClass("has-error");
        $("#updatePwd").next().text("密码长度必须在3~15之间");
        $("#updatePwd").next().show();
        flag = false;
    } else {
        $('#updatePwd').parent().removeClass("has-error");
        $('#updatePwd').next().text("");
        $("#updatePwd").next().hide();
    }
    
    return flag;
}


function updateUser(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/userManageAction_getUser.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#updateId").val(data.userId);
					$("#updateUsername").val(data.username);
					$("#updatePwd").val(data.pwd);
								
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


