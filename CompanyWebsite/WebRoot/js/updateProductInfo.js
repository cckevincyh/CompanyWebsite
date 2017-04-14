

$(function () {
	

    $('#updateProductInfo').click(function () {
    	
    	if(!validUpdateProductInfo()){
    		return ;
    	}
    	
    	
	var postdata = "id="+$.trim($("#updateId").val())+"&pname="+$.trim($("#updateName").val())+"&pdesc="+ $.trim($("#updateDesc").val())+"&img="+ $.trim($("#updateImg").val());
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/productInfoManageAction_updateProductInfo.action',
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



function validUpdateProductInfo() {
    var flag = true;


    var name = $.trim($("#updateName").val());
    var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");	
    if (name == "") {
        $('#updateName').parent().addClass("has-error");
        $('#updateName').next().text("请输入产品名称");
        $("#updateName").next().show();
        flag = false;
    }else if(!reg.test(name)){
		$('#updateName').parent().addClass("has-error");
        $('#updateName').next().text("产品名称必须为中文");
        $("#updateName").next().show();
        flag = false;
	}else {
        $('#updateName').parent().removeClass("has-error");
        $('#updateName').next().text("");
        $("#updateName").next().hide();
    }
	
    
    var desc = $.trim($("#updateDesc").val());
    if (desc == "") {
        $('#updateDesc').parent().addClass("has-error");
        $('#updateDesc').next().text("请输入产品描述");
        $("#updateDesc").next().show();
        flag = false;
    }else {
        $('#updateDesc').parent().removeClass("has-error");
        $('#updateDesc').next().text("");
        $("#updateDesc").next().hide();
    }
    
    
    var upload = $.trim($("#updateUpload").val());
    if (upload == "") {
        $('#updateUpload').parent().addClass("has-error");
        $('#updateUpload').next().text("请选择图片");
        $("#updateUpload").next().show();
        flag = false;
    } else {
        $('#updateUpload').parent().removeClass("has-error");
        $('#updateUpload').next().text("");
        $("#updateUpload").next().hide();
    }
	

	
    return flag;
}


function updateProductInfo(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'admin/productInfoManageAction_getProductInfo.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#updateId").val(data.pid);
					$("#updateName").val(data.pname);
					$("#updateDesc").val(data.pdesc);
								
				}
			}
			   
    	);
			

}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}


