// JavaScript Document
$(function(){
	
	//修改密码
	$("#submitPasswordButten").click(function(){
		
		//
		$.ajax({
			url:"retrieveUserServlet?action=doUpdatePassword",
			data:{"username":$("#userName").val(),
			"password":$("#password").val()
			},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#submitbuttenspan").html("修改成功!请登录");
						$("#submitbuttenspan").css({"color":"green"});
						$("#submitbuttenspan").show(500);
						$(".hide").show(500)
						setTimeout(window.location.href='index.jsp',3000);
					} else if (data == 1){
						$("#submitbuttenspan").html("出现异常,请重试");
						$("#submitbuttenspan").css({"color":"red"});
						$("#submitbuttenspan").show(500);
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
	
	
	
	
	//提交信息验证权限
	$("#submitbutten").click(function(){
		
		//
		$.ajax({
			url:"retrieveUserServlet?action=doJudgeUser",
			data:{"username":$("#userName").val(),
			"idcode":$("#idcode").val(),
			"email":$("#email").val()
			},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#submitbuttenspan").html("请修改密码!");
						$("#submitbuttenspan").css({"color":"green"});
						$("#submitbuttenspan").show(500);
						$(".hide").show(500)
					} else if (data == 1){
						$("#submitbuttenspan").html("信息错误!找回密码失败!");
						$("#submitbuttenspan").css({"color":"red"});
						$("#submitbuttenspan").show(500);
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
	
	
	//填写信息判断
	$("#idcode").blur(function(){
		if ($("#userName").val()!="" && $("#email").val()!="" && $("#idcode").val()!="" ){
			$("#submitbuttenspan").hide(500);
			$("#submitbutten").show(500);
		}
	});
	
	//填写信息判断
	$("#email").blur(function(){
		if ($("#userName").val()!="" && $("#email").val()!="" && $("#idcode").val()!="" ){
			$("#submitbuttenspan").hide(500);
			$("#submitbutten").show(500);
		}
	});
	
	
	
	//判断用户名是否存在
	$("#userName").blur(function(){
		if ($("#userName").val()==null || $("#userName").val()==""){
			$("#uName").html("请先输入用户名!");
			$("#uName").css({"color":"red"});
			$("#uName").show(500);
		} else {
		//
		$.ajax({
			url:"registerServlet?User=User",
			data:{"username":$("#userName").val()},
			type:"post",
			dataType:"html",
			success:function(data){
					if (data == 0){
						$("#uName").html("用户名不存在!");
						$("#uName").css({"color":"red"});
						$("#uName").show(500);
					} else if (data == 1){
						$("#uName").hide(500);
					} else{
						alert("请刷新页面!");
					}
					 
			},
			error:function(){
				alert("请刷新页面!");
			}
		})
		//
		}
	});
	
	$("#submitbuttenspan").css({"color":"red"});
	$("#submitbuttenspan").show();
	$("#submitbutten").hide(500);
	
});
