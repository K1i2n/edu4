<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/1/3/003
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结算页面</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1{
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>
    <div id="header">
        <img class="logo_img " alt="" src="static/img/logo.gif">
        <span class="wel_word">结算</span>

        <%@include file="/pages/common/login_success_menu.jsp"%>
    </div>
    <div id="main">
        <h1>订单号为:${sessionScope.orderId}</h1>
    </div>

</body>
</html>
