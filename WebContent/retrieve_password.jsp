
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-2.1.0.js"></script>
<script type="text/javascript" src="scripts/retrieve_password.js"></script>
</head>
<body>
<%@ include file="index_top.jsp" %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>请键入找回密码的相关信息：</h1>
			<form id="loginForm" method="post" >
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName" id="userName"/><span id = "uName"></span></td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" id="idcode" name="uName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">注册邮箱：</td>
						<td><input class="text" type="text" id="email" name="email" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					
					<tr>
						<td><span id = "submitbuttenspan">先填入完整内容</span></td>
						<td><label class="ui-green"><input type="button" name="submit" value="找回密码" id="submitbutten"/></label></td>
					</tr>
					

					<tr class="hide">
						<td>请在此输入新密码：</td>
						<td><input class="text" type="password" id="password" /><span></span></td>
					</tr>
					<tr class="hide">
						<td></td>
						<td><label class="ui-blue"><input type="button" name="submit" value="修改密码" id="submitPasswordButten"/></label><span></span></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2017 TeaR All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
