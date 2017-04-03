//加入在线编辑器
var editor;
KindEditor.ready(function(K) {
	//在当前网页中，查找<textarea id = "findContent"></textarea>，并替换成kindeditor编辑器。
	editor = K.create('textarea[id="findContent"]', {
		allowFileManager : true ,  //是否允许上传文件
		resizeType:0, //1只能拖动高度，0不能拖动
	   fullscreenShortcut:true,
        readonlyMode : true,//初始化设置为只读模式
		afterCreate : function() {//获取 KindEditor里面的内容
         this.sync(); 
        }, 
        afterBlur:function(){ //获取 KindEditor里面的内容
            this.sync(); 
        },
        items:[
               //设置无功能
       ]
        
	});
	//editor.readonly(true);//设置只读true
});


function getNotice(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'noticeAction_getNotice.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#findTitle").val(data.ntitle);
				//	$("#findContent").val(data.ncontent);
					editor.html(data.ncontent);		//	给在线编辑器设置内容			
				}
			}
			   
    	);
			

}