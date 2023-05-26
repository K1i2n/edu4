<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="http://localhost:8080/edu3/book/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
</head>
<body>
    <div id="login_header">
        <img class="login_img" alt="" src="static/img/logo.gif">
    </div>
        <div class="login_banner">
            <div id="1_content">
                <span class="login_word">欢迎登录</span>
            </div>
            <div id="content">
                <div class="login_form">
                    <div class="login_box">
                        <div class="tit">
                            <h1>会员</h1>
                            <a href="/edu3/book/pages/user/regist.jsp">立即注册</a>
                        </div>
                        <div class="msg_cont">
                            <b></b>
                            <span class="erroaMsg"><%--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
                            ${ empty requestScope.msg ?"请输入用户名和密码":requestScope.msg}
                            </span>
                        </div>
                        <div class="form">
                            <form th:action="@{/user.do}" method="post">
                                <input type="hidden" name="operate" value="login"/>
                                <label>用户名：</label>
                                <input class="itxt" type="text" placeholder="请输入用户名"
                                       autocomplete="off" tabindex="1" name="uname" id="username"
                                       value="<%--<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>--%>
                                    ${ requestScope.username}
                                    "/>
                                <br/>
                                <label>密码：</label>
                                <input class="itxt" type="password" placeholder="请输入密码"
                                autocomplete="off" tabindex="1" name="pwd" id="password"/>
                                <br/>
                                <input class="submit"type="submit" value="登录" id="sub_btn"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>