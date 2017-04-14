
$(function () {
	

    $('#commit').click(function () {
    	
    	if(!validMessage()){
    		return ;
    	}
    	
    	
	var postdata = "phone="+$.trim($("#phone").val())+"&email="+ $.trim($("#email").val())+"&name="+ $.trim($("#name").val())+"&content="+ $.trim($("#content").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'messageAction_addMessage.action',
				params: postdata,
	    		callback:function(data) {
					if (data == 1) {
						$("#addModal").modal("hide");//关闭模糊框		
						showInfo("提交成功");	

	                }else {
						$("#addModal").modal("hide");//关闭模糊框
						showInfo("提交失败");
					}
								
				}
			}
			   
    	);
			
		
	});
	
		$('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
       		 location.reload();  	//刷新当前页面
    	});
	
	

});





function validMessage() {
    var flag = true;


    var phone = $.trim($("#phone").val());
	if(phone == ""){
		 $('#phone').parent().addClass("has-error");
        $('#phone').next().text("请输入联系号码");
        $("#phone").next().show();
        flag = false;
	}else if(!(/^1[34578]\d{9}$/.test(phone))){ 
		//电话号码格式的校验
         $('#phone').parent().addClass("has-error");
        $('#phone').next().text("手机号码有误");
        $("#phone").next().show();  
        flag = false;
    }else {
        $('#phone').parent().removeClass("has-error");
        $('#phone').next().text("");
        $("#phone").next().hide();
    } 
	
    
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var email = $.trim($("#email").val());
	if(email == ""){
		 $('#email').parent().addClass("has-error");
        $('#email').next().text("请输入邮箱");
        $("#email").next().show();
        flag = false;
	}else if(!reg.test(email)){ 
		//email格式的校验
         $('#email').parent().addClass("has-error");
        $('#email').next().text("邮箱格式有误");
        $("#email").next().show();  
        flag = false;
    }else {
        $('#email').parent().removeClass("has-error");
        $('#email').next().text("");
        $("#email").next().hide();
    } 
    
    
	  var name = $.trim($("#name").val());
	    var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");	
	    if (name == "") {
	        $('#name').parent().addClass("has-error");
	        $('#name').next().text("请输入姓名");
	        $("#name").next().show();
	        flag = false;
	    }else if(!reg.test(name)){
			$('#name').parent().addClass("has-error");
	        $('#name').next().text("姓名必须为中文");
	        $("#name").next().show();
	        flag = false;
		}else {
	        $('#name').parent().removeClass("has-error");
	        $('#name').next().text("");
	        $("#name").next().hide();
	    }
	
    var content = $.trim($("#content").val());
    if (content == "") {
        $('#content').parent().addClass("has-error");
        $('#content').next().text("请输入留言内容");
        $("#content").next().show();
        flag = false;
    } else {
        $('#content').parent().removeClass("has-error");
        $('#content').next().text("");
        $("#content").next().hide();
    }
	
    return flag;
}







function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


