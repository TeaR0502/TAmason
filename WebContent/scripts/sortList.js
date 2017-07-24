// JavaScript Document
$(function() {
	
	//鼠标移入事件
	$("#fl dl").mouseover(function() {
		//alert("123");
		$(this).find("dd").stop().show(1000);
		
	});
	//鼠标移出事件
	$("#fl dl").mouseout(function() {
		//alert("123");
		$(this).find("dd").stop().hide(1000);
		//var obj = $(this).html();
		//alert(obj);
		
	});
	
	
	//隐藏二级标签
	$("#fl dd").hide(0);
	
	
	
	function getSecCategory() {
		alert("1");
		var obj = $(this).html();
		alert(obj);
	}
});



