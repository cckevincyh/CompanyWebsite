
$(function () {
	

    $('#addUser').click(function () {

    	
    	if(!validAddUser()){
    		return ;
    	}
    	
	var postdata = "username="+$.trim($("#addUsername").val())+"&pwd="+ $.trim($("#addPwd").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/userManageAction_addUser.action',
				params: postdata,
	    		callback:function(data) {
					if (data == 1) {
						$("#addModal").modal("hide");//关闭模糊框		
						showInfo("添加成功");	

	                }else if (data == -1) {
						$("#addModal").modal("hide");//关闭模糊框		
						showInfo("该会员已存在");	
					}else {
						$("#addModal").modal("hide");//关闭模糊框
						showInfo("添加失败");
					}
								
				}
			}
			   
    	);
			
		
	});
	
		$('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
       		 location.reload();  	//刷新当前页面
    	});
	
	

});






function validAddUser() {
    var flag = true;



    
	  var name = $.trim($("#addUsername").val());
	    if (name == "") {
	        $('#addUsername').parent().addClass("has-error");
	        $('#addUsername').next().text("请输入会员用户名");
	        $("#addUsername").next().show();
	        flag = false;
	    }else {
	        $('#addUsername').parent().removeClass("has-error");
	        $('#addUsername').next().text("");
	        $("#addUsername").next().hide();
	    }
	
    var pwd = $.trim($("#addPwd").val());
    if (pwd == "") {
        $('#addPwd').parent().addClass("has-error");
        $('#addPwd').next().text("请输入密码");
        $("#addPwd").next().show();
        flag = false;
    } else if (pwd.length<3 || pwd.length > 15) {
        $("#addPwd").parent().addClass("has-error");
        $("#addPwd").next().text("密码长度必须在3~15之间");
        $("#addPwd").next().show();
        flag = false;
    } else {
        $('#addPwd').parent().removeClass("has-error");
        $('#addPwd').next().text("");
        $("#addPwd").next().hide();
    }
    
    return flag;
}







function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


