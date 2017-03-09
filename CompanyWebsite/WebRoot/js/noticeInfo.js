function getNotice(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'noticeAction_getNotice.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#findTitle").val(data.ntitle);
					$("#findContent").val(data.ncontent);
								
				}
			}
			   
    	);
			

}