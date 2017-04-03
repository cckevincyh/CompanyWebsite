//加入在线编辑器
var editor;
KindEditor.ready(function(K) {
	//在当前网页中，查找<textarea id = "findContent"></textarea>，并替换成kindeditor编辑器。
	editor = K.create('textarea[id="findContent"]', {
		allowFileManager : true ,  //是否允许上传文件
		resizeType:0, //1只能拖动高度，0不能拖动
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
	editor.readonly(true);//设置只读true
});

function getArticle(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'articleAction_getArticle.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#findTitle").val(data.atitle);
					//$("#findContent").val(data.acontent);
					editor.html(data.acontent);		//	给在线编辑器设置内容		
				}
			}
			   
    	);
			

}

