<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="userLogin">
		userName:<input type="text" name="userName"/><br/>
		passWord:<input type="password" name="password"/><br/>
		<!-- confirm password:<input type="password" name="confirmpassword"/><br/> -->
		<!-- Age:<input type="text" name="age"/><br/> -->
		<!-- emphireDate:<input type="text" name="empHireDate"/><br/> -->
		<input type="submit" value="submit"/> <input type="reset" value="cancel"/>
	</form>
</body>
</html>