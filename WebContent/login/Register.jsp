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
		var repassword = document.form1.repassword.value;
		if (password != repassword) {
			alert(" 2次输入的密码 必须相同  !");
			return false;
		}
		
		var nickname = document.form1.nickname.value;
		if (nickname == "" || nickname.length < 6) {
			alert("nickname必须 至少 6 位 !");
			return false;
		}

		var email = document.form1.email.value;
		if(!/.+@.+\.[a-zA-Z]{2,4}$/.test(email)){
			alert("邮件地址必须 正确 ！")
			return false;
		}
		return true;
		
	}
</script>
</head>
<body>

${requestScope['register.msg'] } <br />

<form  name="form1" action="${pageContext.request.contextPath }/register" 
	method="post" onsubmit="return checkinput()">

用户名称 <input type="text" name="username" value="${user.username }"> <br />
密码 <input type="password" name="password"> <br />
再次输入密码 <input type="password" name="repassword"> <br />
昵称 <input type="text" name="nickname"> <br />
邮件地址 <input type="text" name="email"> <br />

<input type="submit"  value="注册用户" >
<input type="reset"  >

</form>

</body>
</html>