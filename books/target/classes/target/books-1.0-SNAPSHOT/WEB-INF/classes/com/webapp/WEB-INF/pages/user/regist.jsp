<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <base href="http://localhost:8080/edu3/book/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script type="text/javascript" src="static/css/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#username").blur(function(){
                var username = this.value;
                $.getJSON("http://localhost:8080/edu3/book/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
                    if(data.existsUsername){
                        $("span.errorMsg").text("用户名已存在");
                    }else{
                        $("span.errorMsg").text("用户名可用");
                    }
                });
            });

            $("#code_img").click(function (){
               this.src= "http://localhost:8080/edu3/book/kaptcha.jpg?d="+new Date();
            });
            $("#sub_btn").click(function(){
               var usernameText = $("#username").val();
               var usernamePatt = /^\w{5,13}$/;
               if(!usernamePatt.test(usernameText)){
                $("span.errorMsg").text("用户名不合法");
                return false
               }


               var passwordText = $("#password").val();
               var passwordPatt = /^\w(5,13)$/;
               if(!passwordPatt.test(passwordText)){
                $("span.errorMsg").text("密码不合法");
                return false
               }


               var repwdText = $("#repwd").val();
               if(passwordText!=repwdText){
                $("span.errorMsg").text("密码不一致");
                return false
               }

               var emailText = $("#email").val();
               var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
               if(!emailPatt.test(emailText)){
                $("span.errorMsg").text("格式不合法");
                return false
               }

               var codeText = $("#code").val();
               codeText = $.trim(codeText);//去空格
               if(codeText==null||codeText==""){
                $("span.errorMsg").text("密码不合法");
                return false
               }


               $("span.errorMsg").text("");

            });

        });
    </script>
    <style type="text/css">
        .login_form{
            height:420px;
            mergin-top:25px;
        }
    </style>
</head>
<body>
    <div class="login_banner">
        <div id="1_content">
            <span class="login_word">欢迎注册</span>
        </div>
        <div id="content">
            <div class="login_form">
                <div class="login_box">
                    <div class="tit">
                        <h1>注册</h1>
                        <span class="errorMsg">${requestScope.msg}</span>
                    </div>
                    <div class="form">
                        <form action="/edu3/book/userServlet" method="post">
                            <input type="hidden" name="action" value="regist"/>
                            <label>用户名称：</label>
                            <input class="itxt" type="text" placeholder="请输入用户名"
                                   autocomplete="off" tabindex="1" name="username" id="username"
                                   value="${requestScope.username}"/>
                            <br/>
                            <br/>
                            <label>用户密码：</label>
                            <input class="itxt" type="password" placeholder="请输入密码"
                                   autocomplete="off" tabindex="1" name="password" id="password"/>
                            <br/>
                            <br/>
                            <label>确认密码：</label>
                            <input class="itxt" type="password" placeholder="确认密码"
                                   autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                            <br/>
                            <br/>
                            <label>电子邮箱：</label>
                            <input class="itxt" type="text" placeholder="请输入电子邮箱"
                                   autocomplete="off" tabindex="1" name="email" id="email"
                                   value="${requestScope.email}"/>
                            <br/>
                            <br/>
                            <label>验证码：</label>
                            <input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
                            <img id="code_img" alt="" src="/edu3/book/kaptcha.jpg" style="float:right; margin-right: 40px; width: 110px;height: 30px;"/>
                            <br/>
                            <br/>
                            <input type="submit" value="注册" id="sub_btn"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>