<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Register: 填写表单模板</h1>
	<form action="checkbean.action" method="post">
		First Name: <input type="text" name="firstName" value="丑"> <br>
		Last Name: <input type="text" name="lastName" value="怪兽"> <br>
		Birthday: <input type="text" name="birthday" value="1978-11-03">
		<br> Gender: 男 <input type="radio" " name="gender" value="false">
		&nbsp;女 <input type="radio" " name="gender" value="true"
			checked="checked"> <br> Working age: <select
			name="working-Age">
			<option value="-1">-请选择-</option>
			<option value="3">三年</option>
			<option value="5" selected="selected">五年</option>
			<option value="10">十年</option>
			<option value="20">二十年</option>
		</select> <br> Interest: 游泳 <input type="checkbox" name="its" value="1"
			checked="checked"> &nbsp;打球 <input type="checkbox" name="its"
			value="2" checked="checked"> &nbsp;下棋 <input type="checkbox"
			name="its" value="3"> &nbsp;打麻将 <input type="checkbox"
			name="its" value="4"> &nbsp;看书 <input type="checkbox"
			name="its" value="5" checked="checked"> <br> <br> <input
			type="submit" value="确 定">&nbsp;&nbsp;<input type="reset"
			value="重 置">
	</form>
</body>
</html>