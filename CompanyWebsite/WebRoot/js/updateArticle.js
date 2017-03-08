

$(function () {
	

    $('#updateArticle').click(function () {
	var postdata = "id="+$.trim($("#updateId").val())+"&title="+$.trim($("#updateTitle").val())+"&content="+ $.trim($("#updateContent").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/articleManageAction_updateArticle.action',
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





function updateArticle(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/articleManageAction_getArticle.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#updateId").val(data.aid);
					$("#updateTitle").val(data.atitle);
					$("#updateContent").val(data.acontent);
								
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


