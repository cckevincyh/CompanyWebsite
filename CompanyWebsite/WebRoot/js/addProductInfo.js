
$(function () {
	

    $('#addProductInfo').click(function () {

	var postdata = "pname="+$.trim($("#addName").val())+"&pdesc="+ $.trim($("#addDesc").val())+"&img="+ $.trim($("#addImg").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/productInfoManageAction_addProductInfo.action',
				params: postdata,
	    		callback:function(data) {
					if (data == 1) {
						$("#addModal").modal("hide");//关闭模糊框		
						showInfo("添加成功");	

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










function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


