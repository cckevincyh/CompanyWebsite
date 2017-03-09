
function getArticle(id){
	ajax(
    		  {
			  	method:'POST',
	    		url:'articleAction_getArticle.action',
				params: "id=" + id,
				type:"json",
	    		callback:function(data) {
					$("#findTitle").val(data.atitle);
					$("#findContent").val(data.acontent);
								
				}
			}
			   
    	);
			

}

