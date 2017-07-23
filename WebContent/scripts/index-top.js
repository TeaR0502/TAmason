// JavaScript Document
$(function(){
	$("#myStyle").mouseover(function(){
		$("#myStyleli").stop().show(1000);
	});
	
	$("#myStyle").mouseout(function(){
		$("#myStyleli").stop().hide(1000);
	});
	

})