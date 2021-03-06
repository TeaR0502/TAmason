// JavaScript Document
$(function(){
	
	
	
	
	
	//提交注册信息并返还注册结果
	$("#submittd").click(function(){
		
		//
		$.ajax({
			url:"registerServlet?action=register",
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
						window.location.href='reg-result.jsp';
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
	
	
	//判断邮箱是否已经注册!
	$("#email").blur(function() {
		//
		$.ajax({
			url:"registerServlet?action=email",
			data:{"email":$("#email").val()},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#uEmail").html("该邮箱可以使用");
						$("#uEmail").css({"color":"green"});
						$("#uEmail").show(500);
					} else if (data == 1){
						$("#uEmail").html("该邮箱已经被注册!");
						$("#uEmail").css({"color":"red"});
						$("#uEmail").show(500);
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
			url:"registerServlet??action=name",
			data:{"username":$("#userName").val()},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#uName").html("用户名可以使用");
						$("#uName").css({"color":"green"});
						$("#uName").show(500);
					} else if (data == 1){
						$("#uName").html("用户名已存在");
						$("#uName").css({"color":"red"});
						$("#uName").show(500);
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
						$("#veryCodespan").show(500);
					} else if (data == 1){
						$("#veryCodespan").html("请输入图中绿色数字");
						$("#veryCodespan").css({"color":"green"});
						$("#veryCodespan").show(500);
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
			$("#veryCodespan").show(500);
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
						$("#veryCodespan").hide(500);
						$("#submitbutten").show(500);
					} else{
						$("#veryCodespan").html("验证码不正确!");
						$("#veryCodespan").css({"color":"red"});
						$("#veryCodespan").show(500);
						
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
