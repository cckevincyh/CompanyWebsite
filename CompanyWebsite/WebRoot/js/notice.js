
$(function () {

		ajax(
    		  {	 
	    		url:'noticeAction_getNewNotice.action',
				type:"json",
	    		callback:function(data) {
					if(data!=undefined)
						$("#noticeTitle").html("<h2 style='font-weight:bold;'>"+data.ntitle+"</h2>");
						
					}		
				}
			
			   
    	);

});



