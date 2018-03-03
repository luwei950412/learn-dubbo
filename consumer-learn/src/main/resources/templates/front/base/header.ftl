<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Education</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${base}/front/css/animate.css">
    <link rel="stylesheet" href="${base}/front/css/icomoon.css">
    <link rel="stylesheet" href="${base}/front/css/bootstrap.css">
    <link rel="stylesheet" href="${base}/front/css/magnific-popup.css">
    <link rel="stylesheet" href="${base}/front/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${base}/front/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${base}/front/css/flexslider.css">
    <link rel="stylesheet" href="${base}/front/css/pricing.css">
    <link rel="stylesheet" href="${base}/front/css/style.css">
    <link rel="stylesheet" href="${base}/front/css/a.css" type="text/css">
    <link href="${base}/front/css/test.css" rel="stylesheet" type="text/css" />


    <#--<script src="${base}/front/js/modernizr-2.6.2.min.js"></script>-->
    <#--<script src="${base}/front/js/respond.min.js"></script>-->

</head>
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <nav class="fh5co-nav" role="navigation">
        <#--<div class="top">-->
            <#--<div class="container">-->
                <#--<div class="row">-->
                    <#--<div class="col-xs-12 text-right">-->

                        <#--<p class="num">Call: +01 123 456 7890</p>-->
                        <#--<ul class="fh5co-social">-->
                            <#--<li><a href="#"><i class="icon-facebook2"></i></a></li>-->
                            <#--<li><a href="#"><i class="icon-twitter2"></i></a></li>-->
                            <#--<li><a href="#"><i class="icon-dribbble2"></i></a></li>-->
                            <#--<li><a href="#"><i class="icon-github"></i></a></li>-->
                        <#--</ul>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
        <div class="top-menu" style="margin-top: -10px;">
            <div class="container">
                <div class="row">
                    <div class="col-xs-2">
                        <div id="fh5co-logo"><a href="index.html"><i class="icon-study"></i>LEARN<span>.</span></a></div>
                    </div>
                    <form>
                        <input type="text">

                    </form>

                    <div class="col-xs-10 text-right menu-1">

                        <ul>
                            <li class="active"><a href="${base}/front/index">首页</a></li>
                            <li style=""><a href="${base}/course/listCourse">课程</a></li>
                            <li><a href="${base}/user/lecture">讲师</a></li>
                            <li><a href="${base}/comment/listComment">问答</a></li>
                            <li><a href="pricing.html">发现</a></li>
                            <!--							<li class="has-dropdown">
                                                            <a href="blog.html">Blog</a>
                                                            <ul class="dropdown">
                                                                <li><a href="#">Web Design</a></li>
                                                                <li><a href="#">eCommerce</a></li>
                                                                <li><a href="#">Branding</a></li>
                                                                <li><a href="#">API</a></li>
                                                            </ul>
                                                        </li>
                            -->
                            <li><a href="contact.html">联系我们</a></li>
                            <#if "${(userFront.username)!}"=="">
                            <li class="btn-cta"><a href="${base}/user/frontLogin"><span>登录</span></a></li>
                            <li class="btn-cta"><a href="${base}/user/frontRegister"><span>注册</span></a></li>
                            <#else>
                                <li class="btn-cta"><a href="${base}/mycenter/myprofile"><span>用户中心</span></a></li>
                                <li class="btn-cta"><a href="${base}/user/frontLogout"><span>注销</span></a></li>
                            </#if>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </nav>



