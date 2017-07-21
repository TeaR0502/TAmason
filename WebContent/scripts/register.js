// JavaScript Document
$(function(){
	
	
	//提交注册信息并返还注册结果
	$("#submittd").click(function(){

		//
		$.ajax({
			url:"registerServlet",
			data:{"username":$("#userName").val(),
				"password":$("#passWord").val(),
				"sex":$("input[name='sex']:checked").val(),
				"birthday":$("#birthday").val(),
				"idcode":$("#identity").val(),
				"email":$("#email").val(),
				"mobile":$("#mobile").val(),
				"address":$("#address").val()
			},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 1){

						setTimeout(window.location.href='index.jsp',5000);
					} else if (data == 0){
						$("#registerresult").html("注册失败!");
						$("#registerresult").css({"color":"red"});
					} else{
						alert("请刷新页面!");
					}
					 
			},
			error:function(){
				alert("请刷新页面!");
			}
		})
		//
	});
	
	//判断用户名是否存在
	$("#userName").blur(function(){

		//
		$.ajax({
			url:"registerServlet?User=User",
			data:{"username":$("#userName").val()},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#uName").html("用户名可以使用");
						$("#uName").css({"color":"green"});
						$("#uName").show(1000);
					} else if (data == 1){
						$("#uName").html("用户名已存在");
						$("#uName").css({"color":"red"});
						$("#uName").show(1000);
					} else{
						alert("请刷新页面!");
					}
					 
			},
			error:function(){
				alert("请刷新页面!");
			}
		})
		//
	});
	
	
	//点击验证码输入框显示提示
	$("#veryCode").click(function(){
		//
		$.ajax({
			url:"codeServlet?color=color",
			data:{"Color":"Color"},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#veryCodespan").html("请输入图中红色数字");
						$("#veryCodespan").css({"color":"green"});
						$("#veryCodespan").show(1000);
					} else if (data == 1){
						$("#veryCodespan").html("请输入图中绿色数字");
						$("#veryCodespan").css({"color":"green"});
						$("#veryCodespan").show(1000);
					} else{
						alert("请刷新页面!");
					}
					 
			},
			error:function(){
				alert("请刷新页面!");
			}
		})
		//
	});
	//焦点离开进行判断 
	$("#veryCode").blur(function(){
		if (
				$("#passWord").val() == "" 
				|| $("#veryCode").val() == "" 
				|| $("#userName").val() == ""
				|| $("#passWord").val() != $("#rePassWord").val()
				|| $("#birthday").val() == ""
				|| $("#identity").val() == ""	
				|| $("#email").val() == ""	
				|| $("#mobile").val() == ""	
				|| $("#address").val() == ""
		){
			$("#veryCodespan").html("请正确填写所有信息");
			$("#veryCodespan").css({"color":"red"});
			$("#veryCodespan").show(1000);
		} else {
			//
			$.ajax({
			url:"codeServlet",
			data:{"code":$("#veryCode").val()},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#veryCodespan").html("");
						$("#veryCodespan").css({"color":"green"});
						$("#veryCodespan").hide(1000);
						$("#submitbutten").show(1000);
					} else{
						$("#veryCodespan").html("验证码不正确!");
						$("#veryCodespan").css({"color":"red"});
						$("#veryCodespan").show(1000);
						
					}
			},
			error:function(){
				alert("请刷新页面!");
			}
		})
			//
		}
	});
	
	//隐藏登录按钮
	$("#submitbutten").css({"display":"none"});
	
});
