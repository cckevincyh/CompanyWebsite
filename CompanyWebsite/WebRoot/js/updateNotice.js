

$(function () {
	

    $('#updateNotice').click(function () {
    	
    	if(!validUpdateNotice()){
    		return ;
    	}
    	
	var postdata = "id="+$.trim($("#updateId").val())+"&title="+$.trim($("#updateTitle").val())+"&content="+ encodeURIComponent(updateEditor.html());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/noticeManageAction_updateNotice.action',
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



function updateNotice(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/noticeManageAction_getNotice.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#updateId").val(data.nid);
					$("#updateTitle").val(data.ntitle);
				//	$("#updateContent").val(data.ncontent);
					updateEditor.html(data.ncontent);		//	给在线编辑器设置内容			
				}
			}
			   
    	);
			

}

function validUpdateNotice() {
    var flag = true;

    var title = $.trim($("#updateTitle").val());

    if (title == "") {
        $('#updateTitle').parent().addClass("has-error");
        $('#updateTitle').next().text("请输入公告标题");
        $("#updateTitle").next().show();
        flag = false;
    }else {
        $('#updateTitle').parent().removeClass("has-error");
        $('#updateTitle').next().text("");
        $("#updateTitle").next().hide();
    }
	
    
    var content = updateEditor.html();
    if (content == "") {
        $('#updateContent').parent().addClass("has-error");
        $('#updateContent').next().text("请输入公告内容");
        $("#updateContent").next().show();
        flag = false;
    }else {
        $('#updateContent').parent().removeClass("has-error");
        $('#updateContent').next().text("");
        $("#updateContent").next().hide();
    }
    
    
 

	
    return flag;
}

function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


