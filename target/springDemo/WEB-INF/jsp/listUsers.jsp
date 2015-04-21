<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出所有用户</title>
<script language="javascript">
	//跳转后有后退功能
	function edit() {
		window.location = "http://www.baidu.com";
	}
	//跳转后有后退功能
	function old_page() {
		window.location = "http://www.baidu.com";
	}
	//跳转后没有后退功能
	function replace() {
		window.location.replace("http://www.baidu.com");
	}
	//在新的窗口打开链接
	function new_page() {
		window.open("http://www.baidu.com");
	}
	function del() {
		if(!confirm('确定删除该用户么？')) {
			return false;
		}
	}
</script>
</head>
<body>
	<p>用户列表</p>
	<c:forEach items="${userList}" var="user">
       姓名： <c:out value="${user.userName}"></c:out>
       邮箱： <c:out value="${user.email}"></c:out>
       年龄： <c:out value="${user.age}"></c:out>
       <!-- 此处将_self改成_blank会在新窗口打开 -->
       <a href="http://localhost:8080/springDemo/UserController/edit?id=${user.id}" target="_self">编辑</a>&nbsp;
       <a href="http://localhost:8080/springDemo/UserController/delete?id=${user.id}" onClick="del()">删除</a>&nbsp;
       <!-- <input type="button" onclick="edit()" value="编辑" /> -->
       <br />
	</c:forEach>
	<br />
	<input type="button" onclick="new_page()" value="new_page" />
	<input type="button" onclick="old_page()" value="old_page" />
	<input type="button" onclick="replace()" value="replace" />
</body>
</html>