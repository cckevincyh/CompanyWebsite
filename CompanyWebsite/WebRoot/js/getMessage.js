

$(function () {
	

	
		$('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
       		 location.reload();  	//刷新当前页面
    	});
	
	

});





function getMessage(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/messageManageAction_getMessage.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#findName").val(data.name);
					$("#findPhone").val(data.phone);
					$("#findEmail").val(data.email);
					$("#findContent").val(data.mcontent);
								
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


