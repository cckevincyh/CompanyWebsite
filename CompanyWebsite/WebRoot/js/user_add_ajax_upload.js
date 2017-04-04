$(document).ready(function(){
    //解决file的change事件只能执行一次的问题
    $(document).on('change','#addUpload',function(){
        ajaxFileUpload1();
    });
});
//上传图片的方法，
function ajaxFileUpload1(){
    //获得basePath
    basePath=$('#addBasePath').val();
    //调用ajaxfileupload.js中的方法
    $.ajaxFileUpload({
        url:'user/fileUploadAction_fileUpload.action',//上传图片要提交到的action
        secureuri:false,//是否用安全提交，默认为false
        fileElementId:'addUpload',//file选择文件的框的id
        dataType:'json',//数据返回格式，如果用json，需要修改ajaxfileupload.js中的内容 eval("data = " + data ); -->data = jQuery.parseJSON(jQuery(data).text());
        success: function (data){
            //获得json格式数据的值，并转换显示图片在页面上
            $("#img1").attr("src",basePath+data.path);
            $("#addImg").val(data.path);
        }
    });
}