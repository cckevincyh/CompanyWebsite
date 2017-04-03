
$(function () {
	

    $('#addArticle').click(function () {
    	   //encodeURIComponent() 函数可把字符串作为 URI 组件进行编码。
//    	该方法不会对 ASCII 字母和数字进行编码，也不会对这些 ASCII 标点符号进行编码： - _ . ! ~ * ' ( ) 。
//    	其他字符（比如 ：;/?:@&=+$,# 这些用于分隔 URI 组件的标点符号），都是由一个或多个十六进制的转义序列替换的。
	var postdata = "title="+$.trim($("#addTitle").val())+"&content="+  encodeURIComponent($.trim($("#addContent").val()));
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/articleManageAction_addArticle.action',
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


