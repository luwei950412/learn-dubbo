<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <#--<meta http-equiv="Access-Control-Allow-Origin" content="*">-->
    <title>Miminium</title>
    <link rel="stylesheet" type="text/css" href="${base}/admin/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/admin/css/bootstrap.css"/>

    <!-- plugins -->
    <!-- <link rel="stylesheet" type="text/css" href="./css/font-awesome.css"> -->

    <link rel="stylesheet" type="text/css" href="${base}/admin/css/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/admin/css/animate.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/admin/css/fullcalendar.css"/>
    <link href="${base}/admin/css/style.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${base}/admin/css/new.css"/>
    <!-- end: Css -->

    <link rel="shortcut icon" href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/asset/img/logomi.png"/>
</head>
<body id="mimin" class="dashboard">
<div class="adcenter">
    <script src="${base}/admin/js/ggad2_728x90.js"></script>
</div>
<!-- start: Header -->
<nav class="navbar navbar-default header navbar-fixed-top">
    <div class="col-md-12 nav-wrapper">
        <div class="navbar-header" style="width:100%;">
            <div class="opener-left-menu is-open">
                <span class="top"></span>
                <span class="middle"></span>
                <span class="bottom"></span>
            </div>
            <a href="${base}/admin/index" class="navbar-brand">
                <b>MIMIN</b>
            </a>

            <ul class="nav navbar-nav search-nav">
                <li>
                    <div class="search">
                        <span class="fa fa-search icon-search" style="font-size:23px;"></span>
                        <div class="form-group form-animate-text">
                            <input class="form-text" required="" type="text"/>
                            <span class="bar"></span>
                            <label class="label-search">信息检索 <b>Search</b> </label>
                        </div>
                    </div>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right user-nav">
                <li class="user-name">
                    <#if "${(userInfo.username)!}"=="">
                    <script>
                        window.location.href="/user/login";
                    </script>
                        </#if>
                    你好，<#if "${(userInfo.userType)!}" == "0">管理员
                <#elseif "${(userInfo.userType)!}"=="2">讲师
                </#if>
                        <#--</#if>-->
                    <span>${(userInfo.username)!}</span></li>   <#--此处是登录用户明显是地方${test.username}-->
                <li class="dropdown avatar-dropdown">
                    <img src="/admin/upload/${(userInfo.headimg)!}" class="img-circle avatar" alt="user name" data-toggle="dropdown"
                         aria-haspopup="true" aria-expanded="true"/>
                    <ul class="dropdown-menu user-dropdown">
                        <li><a data-toggle="modal" data-target="#myModal_update"><span class="fa fa-user"></span> 我的信息</a></li>
                        <li><a href="#"><span class="fa fa-calendar"></span> 扩展功能</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="more">
                            <ul>
                                <li><a href=""><span class="fa fa-cogs"></span></a></li>
                                <li><a href=""><span class="fa fa-lock"></span></a></li>
                                <li><a href="${base}/user/logout"><span class="fa fa-power-off " title="注销"></span></a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#" class="opener-right-menu"></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid mimin-wrapper">

    <!-- start:Left Menu -->
    <div id="left-menu">
        <div class="sub-left-menu scroll" style="overflow: hidden; width: 230px; display: block;" tabindex="5000">
            <ul class="nav nav-list">
                <li>
                    <div class="left-bg"></div>
                </li>
                <li class="time">
                    <h1 class="animated fadeInLeft">14:44</h1>
                    <p class="animated fadeInRight">Wednesday, January 24th 2018</p>
                </li>
                <li class="ripple">
                    <a href="${base}/admin/index">
                        <span class="fa fa-home"></span> Home
                        <!-- <i class="fa fa-home"></i> -->
                        <span class="fa-angle-right fa right-arrow text-right"></span>
                    </a>
                </li>
                <li class="ripple"><a class="tree-toggle nav-header">
                    <span class="fa fa-pencil-square"></span> 用户管理 <span
                        class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li><a href="${base}/user/lecture">讲师</a></li>
                        <li><a href="${base}/user/common">普通用户</a></li>
                    </ul>
                </li>
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-check-square-o"></span> 课程管理
                    <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li><a href="${base}/course/listAdmin">课程信息</a></li>
                        <li><a href="#">Wizard</a></li>
                    </ul>
                </li>
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-table"></span> 问答管理 <span
                        class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li>
                            <a href="">问答信息</a>
                        </li>
                    </ul>
                </li>
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-file-code-o"></span> 考试管理 <span
                        class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li>
                            <a href="${base}/choice/listChoice">选择题库</a>
                        </li>
                        <li>
                            <a href="${base}/tOrF/listTOrF">判断题库</a>
                        </li>
                        <li>
                            <a href="${base}/test/listTest">试题系统</a>
                        </li>
                    </ul>
                </li>
                <#--<li class="ripple"><a class="tree-toggle nav-header"><span class="fa "></span> 字幕管理 <span-->
                        <#--class="fa-angle-right fa right-arrow text-right"></span> </a>-->
                    <#--<ul class="nav nav-list tree" style="display: none;">-->
                        <#--<li>-->
                            <#--<a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/view-mail.html">字幕信息</a>-->
                        <#--</li>-->
                    <#--</ul>-->
                <#--</li>-->
                <#--<li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/credits.html">其他扩展</a></li>-->
            </ul>
        </div>
    </div>
    <!-- end: Left Menu -->