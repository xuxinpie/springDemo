<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Form 用来提取用户填入并提交的信息-->
	<form method="post" name="frmUpdate" action="update">
		<h1 align="center">更新用户资料</h1>
		<br>
		<div align="center">
			用户名： <input type="text" name="userName" value="${user.userName}" /><br />
			年龄:<input type="text" name="age" value="${user.age}"/><br />
			邮箱:<input type="text" name="email" value="${user.email}"/><br />
			密码:<input type="password" name="password" value="${user.password}"/><br />
			<input type="hidden" name="id" value="${user.id}" />
			<input type="submit" value="submit"/> <input type="reset" value="cancel"/>
		</div>
	</form>
</body>
</html>