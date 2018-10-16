<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function del(id) {
		var flag = window.confirm("确认删除 吗 ？");
		if (flag) {
			location.href = "${pageContext.request.contextPath}/customer/del?id="
					+ id;
		}
	}

	function modifyck() {
		var ids = document.getElementsByName("ids");
		var all = document.getElementById("all");
		for (var i = 0; i < ids.length; i++) {
			ids[i].checked = all.checked;
		}
	}
	
	function queryit() {
		document.form1.action="${pageContext.request.contextPath}/customer/query";
		document.form1.submit();
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
	${requestScope['showall.msg'] }
	<h3 align="center">显示 全部用户列表</h3>
	<form name="form1" action="${pageContext.request.contextPath }/customer/delMany"
		method="post">
		<table border="1" width="97%" align="center">
			<tr>
				<td colspan="11">
				<br>
				查询 
				<select name="colname">
					<option value="none">请选择。。。</option>
					<option value="id">序号</option>
					<option value="name" >用户名称</option>
					<option value="birthday">生日</option>
					<option value="cellphone">手机</option>
				</select>
				&nbsp; &nbsp; &nbsp;
				<input type="text" name="name" >
				&nbsp; &nbsp; &nbsp;
				<input type="button" value="简单查询" onclick="queryit()">
				<br/>
				<br/>
				</td>
			</tr>
			<tr>
				<td>选择</td>
				<td>序号</td>
				<td>用户名称</td>
				<td>性别</td>
				<td>生日</td>
				<td>手机</td>
				<td>邮件</td>
				<td>爱好</td>
				<td>客户类型</td>
				<td>客户描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${customers}" var="c">
				<tr>
					<td><input type="checkbox" name="ids" value="${c.id }"></td>
					<td>${c.id }</td>
					<td>${c.name}</td>
					<td>${c.gender }</td>
					<td>${c.birthday }</td>
					<td>${c.cellphone }</td>
					<td>${c.email }</td>
					<td>${c.preference }</td>
					<td>${c.type }</td>
					<td>${c.description }</td>
					<td><a
						href="${pageContext.request.contextPath }/customer/edit?id=${c.id}">编辑</a>
						<%-- 	<a href="${pageContext.request.contextPath }/customer/del?id=${c.id}" onclick="">删除</a> --%>
						<a href="javascript:void(0)" onclick="del('${c.id}')">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="11"><a
					href="${pageContext.request.contextPath }/main/add.jsp">添加记录</a>
					&nbsp; <input type="checkbox" id="all" onchange="modifyck()">
					全部 &nbsp; <input type="submit" value="批量删除"></td>
			</tr>
		</table>
	</form>

</body>
</html>