<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/1/3/003
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function(){
           $("a.deleteClass").click(function(){
              return cofirm("你确定删除【"+$(this).parent().parent().find("td:first").text()+"】？");
           });
           $("#clearCart").click(function(){
               return confirm("你确定清空购物车？");
           });
           //失去焦点事件blue 需要自行判断数据是否改变
           $(".updateCount").change(function() {
               var name = $(this).parent().parent().find("td:first").text();
               var count = this.value;
               var bookId = $(this).attr("bookId");
               if (confirm("确定修改【" + name + "】的数量为" + count + "?")) {
                    location.href = "http://localhost:8080/edu3/book/cartServlet?action=updateCount&count"+count+"&id="+bookId;
               } else {
                   //Dom对象的默认值
               this.value = this.defaultValue;
               }
           });
        });
    </script>
</head>
<body>

    <div id="header">
        <img class="logo_img" alt=""src="static/img/logo.gif">
        <span class="wel_word">购物车</span>
        <%@include file="/pages/common/login_success_menu.jsp"%>
    </div>
    <div id="main">
        <table>
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <c:if test="${empty sessionScope.cart.items}">
                <tr>
                    <td colspan="5"><a href="index.jsp"></a> 当前购物车为空</td>

                </tr>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" style="width: 80px"
                               bookId="${entry.value.id}"
                               type="text" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem"  href="/cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
                </c:forEach>
            </c:if>
        </table>
        <c:if test="${not empty sessionScope.cart.items}" >
            <div class="cart_info">
                <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
                <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
                <span class="cart_span"><a id="clearCart" href="/cartServlet?action=clear">清空购物车</a></span>
                <span class="cart_span"><a href="/orderServlet?action=createOrder">去结账</a></span>
            </div>
        </c:if>
    </div>
</body>
</html>
