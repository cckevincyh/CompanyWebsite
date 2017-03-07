

$(function () {
	

	
		$('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
       		 location.reload();  	//刷新当前页面
    	});
	
	

});





function getNotice(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/noticeManageAction_getNotice.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#findTitle").val(data.ntitle);
					$("#findContent").val(data.ncontent);
								
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


