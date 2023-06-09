<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>书城首页</title>
<script type="text/javascript">
    $(function(){
       $("button.addToCart").click(function(){
           var bookId = $(this).attr(bookId);
           //location.href="http://localhost:8080/edu3/book/cartServlet?action=addItem&id="+bookId;
            $.getJSON("http://localhost:8080/edu3/book/cartServlet","action=ajaxAddItem&id="+bookId,function(data){
                $("#cartTotalCount").text("您的购物车中有"+data.totalCount+"件商品");
                $("#cartLastName").text(data.lastName);
            });
       }) ;
    });
</script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif"/>
    <span class="wel_word" >网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="/edu3/book/pages/user/regist.jsp">注册</a>
            <a href="/edu3/book/pages/user/login.jsp">登录</a>
            <a href="/edu3/book/pages/manager/manager_menu.jsp">后台</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎</span><span class="um_span" >${sessionScope.user.username}</span><span>光临书城</span>
            <a href="/edu3/book/pages/manager/manager_menu.jsp">我的订单</a>
            <a href="/edu3/book/userServlet?action=logout">注销</a>
            <a href="/edu3/book/index.jsp">返回</a>
        </c:if>

    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="/edu3/book/client/bookServlet" method="post">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="...">
            <c:if test="${empty sessionScope.cart.items}">
                <span id="cartTotalCount"></span>
                <div>
                    <span style="..." id="cartLastName">购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <span id="cartTotalCount">您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="..." id="cartLastName">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>
        <c:forEach items="${requestScope.page.items}" var="book">
        <div class="b_list">
            <div class="img_div">
                <img class="book_img" alt="" src="${book.imgPath}"/>
            </div>
            <div class="book_info">
                <div class="book_name">
                    <span class="sp1">书名：</span>
                    <span class="sp1">${book.name}</span>
                </div>
                <div class="book_author">
                    <span class="sp1">作者：</span>
                    <span class="sp1">${book.author}</span>
                </div>
                <div class="book_price">
                    <span class="sp1">价格：</span>
                    <span class="sp1">${book.price}</span>
                </div>
                <div class="book_sales">
                    <span class="sp1">销量：</span>
                    <span class="sp1">${book.sales}</span>
                </div>
                <div class="book_amount">
                    <span class="sp1">库存：</span>
                    <span class="sp1">${book.stock}</span>
                </div>
                <div class="book_add">
                    <button class="addToCart" bookId="${book.id}">加入购物车</button>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    <%@include file="/pages/common/page_nav.jsp"%>

</div>

</body>
</html>