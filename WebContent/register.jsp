<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-2.1.0.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/register.js"></script>

</head>
<body>
<%@ include file="index_top.jsp"  %>

<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1 id= "registerresult">欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current" id="registerresult1"><em></em>填写注册信息</li>
				<li class="last" id="registerresult2"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" >
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input id="userName" class="text" type="text" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span id="uName"></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" id="rePassWord" name="rePassWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td ><input type="radio" name="sex"  style="border:0px;" checked="checked" value="0" />男<input type="radio" name="sex" style="border:0px;" value="1"/>女<span></span></td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input class="text" type="text" id="birthday" name="birthday" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" id="identity" name="identity" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">电子邮件：</td>
						<td><input class="text" type="text" id="email" name="email" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span id="uEmail"></span></td>
					</tr>
					<tr>
						<td class="field">手机：</td>
						<td><input class="text" type="text" id="mobile"  name="mobile" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">地址：</td>
						<td><input class="text" type="text" id="address" name="address" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" id="veryCode" /><img id="veryCode" src="code.jsp" onclick="code.jsp"/><span id="veryCodespan"></span></td>
					</tr>
					<tr>
						<td></td>
						<td id = "submittd"><label class="ui-green"><input type="button" id="submitbutten" value="提交注册" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 TeaR All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

