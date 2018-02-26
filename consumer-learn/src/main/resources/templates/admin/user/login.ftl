<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8"/>
    <title>Miminium</title>
    <!-- start: Css -->
    <link rel="stylesheet" type="text/css" href="/admin/css/bootstrap.css">

    <!-- plugins -->
    <link rel="stylesheet" type="text/css" href="/admin/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/simple-line-icons.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/aero.css">
    <link href="/admin/css/style.css" rel="stylesheet">
    <!-- end: Css -->

    <link rel="shortcut icon" href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/asset/img/logomi.png">
</head>
<body id="mimin" class="dashboard form-signin-wrapper">
<script language="javascript" type="text/javascript">
    <#--if("${(userInfo.username)!}"){-->
        <#--alert(session_user+"hello");-->
    <#--}else{-->
        <#--alert("erro,null");-->
    <#--}-->
</script>
<!--</shiro:notAuthenticated>-->
<!--<form th:action="@{/user/login}" method="post">-->
<!--<p>账号：<input type="text" name="username" value="luwei" /></p>-->
<!--<p>密码：<input type="text" name="password" value="123456" /></p>-->
<!--<p><input type="submit" value="登录"/></p>-->
<!--</form>-->
<!--<a href="../user/register">register</a>-->
<#--<img src="/admin/images/login-bg.jpg" />-->
<div class="container">

    <form class="form-signin" action="/user/login" method="post">
        <div class="panel periodic-login">
        <#--<span class="atomic-number">28</span>-->
            <div class="panel-body text-center">
                <h1 class="atomic-symbol">Mi</h1>
                <p class="atomic-mass">V 1.0.0</p>
                <p class="element-name">Miminium</p>
                <i class="fa fa-arrow-down"></i>
                <div class="form-group form-animate-text" style="margin-top:40px !important;">
                    <input class="form-text" required="" name="username" type="text">
                    <span class="bar"></span>
                    <label>Username</label>
                </div>
                <div class="form-group form-animate-text" style="margin-top:40px !important;">
                    <input class="form-text" required="" name="password" type="password">
                    <span class="bar"></span>
                    <label>Password</label>
                </div>
            <#--<label class="pull-left">-->
            <#--<div class="icheckbox_flat-aero" style="position: relative;">-->
            <#--<input class="icheck pull-left" style="position: absolute; opacity: 0;" type="checkbox" />-->
            <#--<ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255) none repeat scroll 0% 0%; border: 0px none; opacity: 0;"></ins>-->
            <#--</div> Remember me-->
            <#--</label>-->
                <input class="btn col-md-12" value="SignIn" type="submit"/>
            </div>
            <div class="text-center" style="padding:5px;">
                <a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/forgotpass.html">Forgot
                    Password </a>
                <a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/reg.html">| Signup</a>
            </div>
        </div>
    </form>

</div>

<!-- end: Content -->
<!-- start: Javascript -->
<script src="/admin/js/jquery.js"></script>
<script src="/admin/js/jquery_002.js"></script>
<script src="/admin/js/bootstrap.js"></script>

<script src="/admin/js/moment.js"></script>
<#--<script src="/admin/js/icheck.js"></script>-->

<!-- custom -->
<script src="/admin/js/main.js"></script>
<#--<script type="text/javascript">-->
<#--$(document).ready(function(){-->
<#--$('input').iCheck({-->
<#--checkboxClass: 'icheckbox_flat-aero',-->
<#--radioClass: 'iradio_flat-aero'-->
<#--});-->
<#--});-->
<#--</script>-->

</body>
</html>