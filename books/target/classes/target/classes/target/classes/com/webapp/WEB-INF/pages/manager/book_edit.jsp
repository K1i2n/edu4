<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/29/029
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
    <%-- 方案3  ${empty requestScope.book?"add":"update"}--%>
    <img class="logo_img" alt="" src="edu3/book/static/img/logo.gif">
    <span class="wel_word">编辑图书</span>
    <%@include file="/pages/manager/manager_menu.jsp"%>
</div>
<div id="main">
    <form action="/edu3/book/manager/bookServlet" method="post">
        <input type="hidden" name="pageNo" value="${param.pageNo}"/>
        <input type="hidden" name="action" value="${empty param.id?"add":"update"}"/><%--value="${param.method}"}--%>
        <input type="hidden" name="id" value="${requestScope.book.id}"/>
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
