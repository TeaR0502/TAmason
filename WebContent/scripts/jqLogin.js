// JavaScript Document
$(function(){
		
		

		$("#submitbutten").click(function(){
			alert("123");
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
							alert("数据异常");
						}
						 
				},
				error:function(){
					alert("请求数据失败!");
				}
			})
			//
		});
		//焦点离开进行判断 
		$("#veryCode").blur(function(){
			if ($("#passWord").val() == "" || $("#veryCode").val() == "" || $("#userName").val() == ""){
				$("#veryCodespan").html("请完善所有信息");
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
					alert("请求数据失败!");
				}
			})
				//
			}
		});
		//焦点离开检测密码是否为空
		$("#passWord").blur(function(){
			if ($("#passWord").val() == ""){
				$("#passWordspan").html("密码不能为空!");
				$("#passWordspan").css({"color":"red"});
				$("#passWordspan").show(1000);
				$("#submitbutten").hide(1000);
			} else {
				$("#passWordspan").html("");
				$("#passWordspan").hide(1000);
			}
		});
		//点击用户名输入框显示提示
		$("#userName").click(function(){
			$("#usernamespan").html("在此输入用户名");
			$("#usernamespan").css({"color":"green"});
			$("#usernamespan").show(1000);
		});
		//焦点离开判断用户名是否为空
		$("#userName").blur(function(){
			if ($("#userName").val() == ""){
				$("#usernamespan").html("用户名不能为空!");
				$("#usernamespan").css({"color":"red"});
				$("#usernamespan").show(1000);
				$("#submitbutten").hide(1000);
			} else {
				$("#usernamespan").hide(1000);
				$("#usernamespan").html("");
			}
		});
		//隐藏登录按钮
		$("#submitbutten").css({"display":"none"});
	});
