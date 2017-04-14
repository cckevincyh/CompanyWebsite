
$(function () {
	

    $('#addProductInfo').click(function () {

    	if(!validAddProductInfo()){
    		return ;
    	}
	var postdata = "pname="+$.trim($("#addName").val())+"&pdesc="+ $.trim($("#addDesc").val())+"&img="+ $.trim($("#addImg").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/productInfoManageAction_addProductInfo.action',
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



function validAddProductInfo() {
    var flag = true;


    var name = $.trim($("#addName").val());
    var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");	
    if (name == "") {
        $('#addName').parent().addClass("has-error");
        $('#addName').next().text("请输入产品名称");
        $("#addName").next().show();
        flag = false;
    }else if(!reg.test(name)){
		$('#addName').parent().addClass("has-error");
        $('#addName').next().text("产品名称必须为中文");
        $("#addName").next().show();
        flag = false;
	}else {
        $('#addName').parent().removeClass("has-error");
        $('#addName').next().text("");
        $("#addName").next().hide();
    }
	
    
    var desc = $.trim($("#addDesc").val());
    if (desc == "") {
        $('#addDesc').parent().addClass("has-error");
        $('#addDesc').next().text("请输入产品描述");
        $("#addDesc").next().show();
        flag = false;
    }else {
        $('#addDesc').parent().removeClass("has-error");
        $('#addDesc').next().text("");
        $("#addDesc").next().hide();
    }
    
    
    var upload = $.trim($("#addUpload").val());
    if (upload == "") {
        $('#addUpload').parent().addClass("has-error");
        $('#addUpload').next().text("请选择图片");
        $("#addUpload").next().show();
        flag = false;
    } else {
        $('#addUpload').parent().removeClass("has-error");
        $('#addUpload').next().text("");
        $("#addUpload").next().hide();
    }
	

	
    return flag;
}






function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


