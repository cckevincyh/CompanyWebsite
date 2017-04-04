/**
 * 点击修改按钮之后ajax提交数据修改密码
 * @param {Object} '#update_adminPwd'
 */
$(function () {
	
	
    $('#update_userPwd').click(function () {

	var postdata = "oldPwd="+$.trim($("#oldPwd").val())+"&newPwd="+ $.trim($("#newPwd").val())+"&confirmPwd="+ $.trim($("#confirmPwd").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'user/userAction_userPwd.action',
				params: postdata,
	    		callback:function(data) {
					if (data == 1) {
						$("#updatepwd").modal("hide");//关闭模糊框		
						showInfo("修改成功");	

	                    
	                }else if (data == 0) {
	                    showInfo("确认密码不一致");
	                }else if(data == -1){
						 showInfo("原密码错误");
					}else{
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



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}