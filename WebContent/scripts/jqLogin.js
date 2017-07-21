// JavaScript Document
$(function(){
		
		
		//登录功能!2017.7.20 19:18
		$("#submitbutten").click(function(){
			//
			$.ajax({
				url:"loginServlet",
				data:{"username":$("#userName").val(),"password":$("#passWord").val()},
				type:"post",
				dataType:"html",
				success:function(data){
						if (data == 0){
							$("#result").html("登陆成功!5秒后自动转跳到<a href='index.jsp'>主页<a>!");
							$("#result").css({"color":"green"});
							$("#result").show(500);
							setTimeout(window.location.href='index.jsp',5000);
						} else if (data == 1){
							$("#result").html("密码错误!请确认!");
							$("#result").css({"color":"red"});
							$("#result").show(500);
						} else if (data == 2){
							$("#result").html("无此用户,请确认账号!或<a href='register.jsp'>注册<a>新会员!");
							$("#result").css({"color":"red"});
							$("#result").show(500);
						} else{
							alert("数据异常");
						}
						 
				},
				error:function(){
					alert("请求数据失败!");
				}
			});
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
			if ($("#passWord").val() == "" || $("#veryCode").val() == "" || $("#userName").val() == ""){
				$("#veryCodespan").html("请完善所有信息");
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
		//焦点离开检测密码是否为空
		$("#passWord").blur(function(){
			if ($("#passWord").val() == ""){
				$("#passWordspan").html("密码不能为空!");
				$("#passWordspan").css({"color":"red"});
				$("#passWordspan").show(500);
				$("#submitbutten").hide(500);
			} else {
				$("#passWordspan").html("");
				$("#passWordspan").hide(500);
			}
		});
		//点击用户名输入框显示提示
		$("#userName").click(function(){
			$("#usernamespan").html("在此输入用户名");
			$("#usernamespan").css({"color":"green"});
			$("#usernamespan").show(500);
		});
		//焦点离开判断用户名是否为空
		$("#userName").blur(function(){
			if ($("#userName").val() == ""){
				$("#usernamespan").html("用户名不能为空!");
				$("#usernamespan").css({"color":"red"});
				$("#usernamespan").show(500);
				$("#submitbutten").hide(500);
			} else {
				$("#usernamespan").hide(500);
				$("#usernamespan").html("");
			}
		});
		//隐藏登录按钮
		$("#submitbutten").css({"display":"none"});
	});
