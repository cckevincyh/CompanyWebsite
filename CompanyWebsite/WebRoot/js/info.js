
$(function () {

		ajax(
    		  {	 
	    		url:'infoAction_getInfo.action',
				type:"json",
	    		callback:function(data) {
					if(data!=undefined)
						$("#phone").html(data.phone);
						$("#email").html(data.email);
						$("#location").html(data.location);
						$("#cdesc").html(data.cdesc);
					}		
				}
			
			   
    	);

});



