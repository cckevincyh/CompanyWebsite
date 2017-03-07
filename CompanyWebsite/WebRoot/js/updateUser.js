

$(function () {
	

    $('#updateUser').click(function () {
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


