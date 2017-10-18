$(document).ready(function(){
	$(".hoverable").hover(
			function(){ 
				$(this).addClass("hovered"); 
			},
			function(){ 
				$(this).removeClass("hovered"); 
			}
		);	
});


	