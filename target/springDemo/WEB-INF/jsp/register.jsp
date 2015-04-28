<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- javaScript 函数 validateLogin(),用来验证用户名和密码是否为空 -->
	<script language="javaScript">
		function validateLogin() {
			var userName = document.frmRegister.userName.value;
			var email = document.frmRegister.email.vaule;
			var password1 = document.frmRegister.password1.value;
			var password2 = document.frmRegister.password2.value;
			var age = document.frmRegister.age.value;
			if (userName=="" || email=="" || password1=="" || password2=="" || age=="") {
				alert("任意信息不能为空，请重新填写！");
			    return false;
			 } else if (userName.length>20) {
			 	alert("用户名不能超过20个字符，请重新输入！");
			  	return false;
			 } else if (isNaN(age)) {
				 alert("年龄必须为数字");
				 return false;
			 } else if (parseInt(age) <= 0 || parseInt(age) > 150) {
				alert("用户年龄填写有误，请重新输入！");
				return false;
			 } else if(password1.length<6) {
			    alert("密码不能小于6个字符，请重新输入！");
			 	return false;
			 } else if (password1!=password2) {
			    alert("2次密码输入不一致！");
			 	return false;
			 } else {
			  	return true;
			 }
		}
		
		function submitForm() {
			if (validateLogin()) {
				document.getElementById("frmRegister").submit();
			}
		}
	</script>

	<!-- Form 用来提取用户填入并提交的信息-->
	<!-- 表单标签中设置enctype="multipart/form-data"用于表单里有图片上传,来确保匿名上载文件的正确编码 -->
	<form method="post" id="frmRegister" name="frmRegister" action="add" enctype="multipart/form-data" target="_self" >
		<h1 align="center">用户注册</h1>
		<br>
		<div align="center">
		<table border="0">
		<tr>
			<td>
				用户名：
			</td>
			<td align="left">
				<input type="text" name="userName" value="Your name"
				onfocus="if(this.value=='Your name')this.value='';"><br />
			</td>
		</tr>
		<tr>
			<td>
				年龄：
			</td>
			<td align="left">
				<input type="text" name="age" value="Your age"
				onfocus="if(this.value=='Your age')this.value='';"><br />
			</td>
		</tr>
		<tr>
			<td>
				邮箱：
			</td>
			<td align="left">
				<input type="text" name="email" value="Your Email"
				onfocus="if(this.value=='Your Email')this.value='';"><br />
			</td>
		</tr>
		<tr>
			<td>
				密码：
			</td>
			<td>	
				<input type="password" name="password1" value="password"
				onfocus="if(this.value=='password')this.value='';"><br />
			</td>
		</tr>
		<tr>
			<td>
				密码确认：
			</td>
			<td>	
				<input type="password" name="password2" value="password"
				onfocus="if(this.value=='password')this.value='';"><br />
			</td>
		</tr>
		<tr>
			<td>
				头像上传：
			</td>
			<td>
				<input type="file" name="photoFile" accept="image/*" /><br />
			</td>
		</tr>
		</table>
		<br />
			<input type="button" name="Submit" value="提交"
				onclick="submitForm();"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" name="Reset" value="重置"><br>
		</div>
	</form>
</body>
</html>
</body>
</html>