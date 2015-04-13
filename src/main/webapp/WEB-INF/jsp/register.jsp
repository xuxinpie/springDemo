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
	<script type="text/javaScript">
		function validateLogin() {
			var userName = document.frmRegister.userName.value;
			var password = document.frmRegister.password.value;
			var password2 = document.frmRegister.password2.value;
			var age = document.frmRegister.age.value;
			if (userName==""|| password==""||password2==""||age=="")
			 {
			  alert("任意信息不能为空，请重新填写！");
			  return false;
			 } else if(username.length>20){
			 	alert("用户名不能超过20个字符，请重新输入！");
			  	return false;
			 } else if (parseInt(age) < 0 || parseInt(age) > 150) {
				 alert("用户年龄填写有误，请重新输入！");
			 } else if(password.length<6){
			    alert("密码不能小于6个字符，请重新输入！");
			 	return false;
			 } else if (password!=password2)
			 {
			    alert("2次密码输入不一致！");
			 	return false;
			 } else{
			  	return true;
			 }
		}
	</script>

	<!-- Form 用来提取用户填入并提交的信息-->
	<form method="post" name="frmRegister" action="add">
		<h1 align="center">用户注册</h1>
		<br>
		<div align="center">
			用户名： <input type="text" name="userName" value="Your name"
				onfocus="if(this.value=='Your name')this.value='';"><br />
			年龄:<input type="text" name="age" value="Your age"
				onfocus="if(this.value=='Your age')this.value='';"><br />
			密码：<input type="password" name="password" value="Your password"
				onfocus="if(this.value=='Your password')this.value='';"><br />
			密码确认:<input type="password" name="password2" value="Confirm password"
				onfocus="if(this.value=='Confirm password')this.value='';"><br />	
			<input type="submit" name="Submit" value="提交"
				onClick="validateLogin();"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" name="Reset" value="重置"><br>
		</div>
	</form>
</body>
</html>
</body>
</html>