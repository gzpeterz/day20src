<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/customer/add" method="post">
<table>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>姓名</td>
		<td><input type="text" name="name" value="${customer.name }"></td>
	</tr>
	<tr>
		<td>性别</td>
		<td>
		<c:choose>
			<c:when test="${ customer.gender == '男' }">
				<input type="radio" name="gender" value="男"  checked="checked"> 男
				<input type="radio" name="gender" value="女"> 女 
			</c:when>
			<c:otherwise>
				<input type="radio" name="gender" value="男"  > 男
				<input type="radio" name="gender" value="女" checked="checked"> 女 
			</c:otherwise>
		</c:choose>
		</td>
	</tr>
	<tr>
		<td>生日</td>
		<td><input type="text" class="Wdate" name="birthday" onclick="WdatePicker()" value="${customer.birthday }"></td>
	</tr>
	<tr>
		<td>电话</td>
		<td><input type="text" name="cellphone" value="${customer.cellphone }"></td>
	</tr>
	<tr>
		<td>邮件地址</td>
		<td><input type="text" name="email" value="${customer.email }"></td>
	</tr>
	<tr>
		<td>爱好</td>
		<td><input type="text" name="preference" value="${customer.preference }"></td>
	</tr>
	<tr>
		<td>客户类型</td>
		<td><input type="text" name="type" value="${customer.type }"></td>
	</tr>
	<tr>
		<td>描述</td>
		<td><input type="text" name="description" value="${customer.description }"></td>
	</tr>
</table>
	<input type="submit" value="添加用户">
	<input type="reset" value="内容重置">
</form>

</body>
</html>