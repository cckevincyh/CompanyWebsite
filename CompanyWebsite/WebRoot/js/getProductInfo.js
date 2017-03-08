

$(function () {
	

	
		$('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
       		 location.reload();  	//刷新当前页面
    	});
	
	

});





function getProductInfo(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/productInfoManageAction_getProductInfo.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#findName").val(data.pname);
					$("#findDesc").val(data.pdesc);
								
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


