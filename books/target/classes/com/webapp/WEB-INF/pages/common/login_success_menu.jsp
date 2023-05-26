<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/23/023
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<div >
    <span>欢迎</span><span class="um_span" >${sessionScope.user.username}</span><span>光临书城</span>
    <a href="/edu3/book/pages/order/order.jsp">我的订单</a>
    <a href="/edu3/book/userServlet?action=logout">注销</a>
    <a href="/edu3/book/index.jsp">返回</a>
</div>
