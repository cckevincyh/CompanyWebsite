
$(function () {
	

    $('#btn_add').click(function () {
	var postdata = "phone="+$.trim($("#phone").val())+"&email="+ $.trim($("#email").val())+"&location="+ $.trim($("#location").val())+"&cdesc="+ $.trim($("#cdesc").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'user/companyInfoAction_addCompanyInfo.action',
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










function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


