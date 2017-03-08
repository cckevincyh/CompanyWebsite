

$(function () {
	

    $('#updateProductInfo').click(function () {
	var postdata = "id="+$.trim($("#updateId").val())+"&pname="+$.trim($("#updateName").val())+"&pdesc="+ $.trim($("#updateDesc").val())+"&img="+ $.trim($("#updateImg").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/productInfoManageAction_updateProductInfo.action',
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





function updateProductInfo(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/productInfoManageAction_getProductInfo.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#updateId").val(data.pid);
					$("#updateName").val(data.pname);
					$("#updateDesc").val(data.pdesc);
								
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


