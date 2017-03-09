
$(function () {

		ajax(
    		  {	 
	    		url:'articleAction_getNewArticle',
				type:"json",
	    		callback:function(data) {
					if(data!=undefined)
						$("#articleTitle").html("<h2 style='font-weight:bold;'>"+data.atitle+"</h2>");
						$("#articleContent").html(data.acontent);
					}		
				}
			
			   
    	);

});



