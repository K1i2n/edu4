<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/28/028
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="edu3/book/img/logo.gif" >
    <span class="wel_word">图书管理系统</span>
    <%@include file="/pages/manager/manager_menu.jsp"%>
    <script type="text/javascript">
        $(function(){
            $("a.deleteClass").click(function (){
                /*
                两个按钮  确认true  取消false


                 */

                return confirm("你确认删除["+$(this).parent().parent().find("td:first").text()+"]");
            });

        });
    </script>
</div>
<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.author}</td>
            <td>${book.sales}</td>
            <td>${book.stock}</td>
            <td ><a href="/edu3/book/manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
            <td><a class="deleteClass" href="/edu3/book/manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
        </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="/edu3/book/pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
    <%@include file="/pages/common/page_nav.jsp"%>

</div>
</body>
</html>
