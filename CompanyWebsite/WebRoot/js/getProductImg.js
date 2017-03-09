
$(function () {
	var basePath = $("#BasePath").val();
		ajax(
    		  {	 
	    		url:'productInfoAction_getProductImg.action',
				type:"json",
	    		callback:function(data) {
					if(data[0]!=undefined){
						$("#img1").attr("src",basePath+data[0].img);
						$("#p1").html("<h1>"+data[0].pname+"</h1>");
					}
					if(data[1]!=undefined){
						$("#img2").attr("src",basePath+data[1].img);
						$("#p2").html("<h1>"+data[1].pname+"</h1>");

					}
					if(data[2]!=undefined){
						$("#img2").attr("src",basePath+data[2].img);
						$("#p3").html("<h1>"+data[2].pname+"</h1>");
					}
					
				}
			}
			   
    	);

});







