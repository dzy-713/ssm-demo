<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>MES-WEB</title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="/login" method="post">
                    <h1>MES-WEB</h1>
                    <h1>登陆</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="Username" required="" name="account" />
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="Password" required="" name="password"/>
                    </div>
                    <ul class="parsley-errors-list filled" id="parsley-id-multiple-hobbies">
                        <li class="parsley-required">${msg}</li>
                    </ul>
                    <div>
                        <button type="submit" class="btn btn-success col-lg-12 form-control">登陆</button>
                    </div>
                    <br />

                    <div class="separator">
                        <p class="change_link">
                            <%--<a class="to_register" href="#">忘记密码?</a>
                            <a href="#signup" class="to_register"> 注册新账号 </a>--%>
                        </p>

                        <div class="clearfix"></div>

                        <br />

                        <div>
                            <%--<h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>--%>
                            <%--<p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>--%>
                        </div>
                    </div>
                </form>
            </section>
        </div>

    </div>
</div>
<script src="/vendors/jquery/dist/jquery.min.js"></script>
<script>
    if(top.$("div[data-example-id='togglable-tabs'")[0]!=null){
        top.location="/logout";
    }
</script>
</body>
</html>
