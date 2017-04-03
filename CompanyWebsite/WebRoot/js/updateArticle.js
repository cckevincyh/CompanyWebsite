

$(function () {
	

    $('#updateArticle').click(function () {
   //encodeURIComponent() 函数可把字符串作为 URI 组件进行编码。
//    	该方法不会对 ASCII 字母和数字进行编码，也不会对这些 ASCII 标点符号进行编码： - _ . ! ~ * ' ( ) 。
//    	其他字符（比如 ：;/?:@&=+$,# 这些用于分隔 URI 组件的标点符号），都是由一个或多个十六进制的转义序列替换的。
	var postdata = "id="+$.trim($("#updateId").val())+"&title="+$.trim($("#updateTitle").val())+"&content="+ encodeURIComponent(updateEditor.html());//updateEditor.html()获取KindEditor的html文本，解决无法读取内容的问题
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
       	   // 关闭Dialog前移除编辑器
 		 //   KindEditor.remove('#content');
    	});
		

});



//加入在线编辑器
var updateEditor;
KindEditor.ready(function(K) {
	//在当前网页中，查找<textarea id = "updateContent"></textarea>，并替换成kindeditor编辑器。
	updateEditor = K.create('textarea[id="updateContent"]', {
		allowFileManager : true ,  //是否允许上传文件
		resizeType:0, //1只能拖动高度，0不能拖动
		allowImageUpload:true,//允许上传图片
        allowFileManager:true, //允许对上传图片进行管理
        uploadJson : '../js/editor/jsp/upload_json.jsp',  
        fileManagerJson : '../js/editor/file_manager_json.jsp', 
		afterCreate : function() {//获取 KindEditor里面的内容
         this.sync(); 
        }, 
        afterBlur:function(){ //获取 KindEditor里面的内容
            this.sync(); 
        },
        items:[
               'source', '|', 'undo', 'redo', '|', 'preview',  'cut', 'copy', 'paste',
                '|', 'justifyleft', 'justifycenter', 'justifyright',
               'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
               'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
               'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
               'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 
                'table', 'hr', 'emoticons',  '|'
       ]
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
				//	$("#updateContent").val(data.acontent);//无法设置内容
					updateEditor.html(data.acontent);		//	给在线编辑器设置内容
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


