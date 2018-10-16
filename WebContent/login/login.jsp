<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkinput() {
		// var username = document.getElementById("username");
		var username = document.form1.username.value;
		if (username == "" || username.length < 6) {
			alert("用户名称必须 至少 6 位 !");
			return false;
		}
		var password = document.form1.password.value;
		if (password == "" || password.length < 6) {
			alert("密码必须 至少 6 位 !");
			return false;
		}
		return true;
		
	}
</script>
</head>
<body>

${requestScope['login.msg'] } <br />

<form  name="form1" action="${pageContext.request.contextPath }/login" 
	method="post" onsubmit="return checkinput()">

用户名称 <input type="text" name="username" value="${user.username }"> <br />
密码 <input type="password" name="password"> <br />

<input type="submit"  value="用户登录" >
<input type="reset"  >

</form>

</body>
</html>