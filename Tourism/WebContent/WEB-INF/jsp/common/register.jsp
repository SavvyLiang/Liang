<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
if("${result}" == "FAIL") {
	alert("该用户已经存在");
}
</script>
</head>
<body>
	<h1>添加用户</h1>
	<form action="/Tourism/user/addUser" method="post">
		姓名：<input type="text" name="username"><br/>
		邮箱：<input type="email" name="email"><br/>
		年龄：<input type="number" name="age" max="120" min="0"><br/>
		性别：<select id="sex" name="sex">
		       <option value="0">男</option>
		       <option value="1">女</option>
		    </select>
		<br/>
		<input type="submit" value="添加">
	</form>
</body>
</html>