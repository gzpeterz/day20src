<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function changeNumPerPage(npg) {
		location.href="${pageContext.request.contextPath}/customer/page?" + 
			"pageNum=${page.pageNum  }&" +
				"numPerPage=" + npg;
		
	}
</script>
<title>Insert title here</title>
</head>
<body>
	${requestScope['showpage.msg'] }
	<h3 align="center">显示 全部用户列表</h3>
	<form name="form1" action="${pageContext.request.contextPath }/customer/delMany"
		method="post">
		<table border="1" width="97%" align="center">
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
			<c:forEach items="${page.customers}" var="c">
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
				<td colspan="11">
			</tr>
		</table>
		<br>
		<div align="center" >
		<a href="${pageContext.request.contextPath }/customer/page?pageNum=1&numPerPage=${page.numPerPage}">首页</a> &nbsp;
		<c:choose>
			<c:when test="${page.pageNum == 1 }">
			上一页  &nbsp;
			</c:when>
			<c:otherwise>
		<a href="${pageContext.request.contextPath }/customer/page?pageNum=${page.pageNum - 1 }&numPerPage=${page.numPerPage}">上一页</a> &nbsp;
			</c:otherwise>
		</c:choose>
		<a href="${pageContext.request.contextPath }/customer/page?pageNum=${page.pageNum + 1 }&numPerPage=${page.numPerPage}">下一页</a> &nbsp;
		<a href="${pageContext.request.contextPath }/customer/page?pageNum=${page.totalPageNum }&numPerPage=${page.numPerPage}">尾页</a> &nbsp;
		&nbsp; &nbsp; &nbsp; 
		每页条数<select name="num" onchange="changeNumPerPage(this.value)">
			<option>5</option>
			<option>10</option>
			<option>20</option>
		</select>
		</div>
	</form>

</body>
</html>