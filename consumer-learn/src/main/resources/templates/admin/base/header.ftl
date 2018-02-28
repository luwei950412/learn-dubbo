<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
<head>
    <meta charset="UTF-8"/>
    <title>Miminium</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/admin/css/bootstrap.css"/>

    <!-- plugins -->
    <!-- <link rel="stylesheet" type="text/css" href="./css/font-awesome.css"> -->

    <link rel="stylesheet" type="text/css" href="/admin/css/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="/admin/css/animate.css"/>
    <link rel="stylesheet" type="text/css" href="/admin/css/fullcalendar.css"/>
    <link href="/admin/css/style.css" rel="stylesheet"/>
    <!-- end: Css -->

    <link rel="shortcut icon" href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/asset/img/logomi.png"/>
</head>
<body id="mimin" class="dashboard">
<div class="adcenter">
    <script src="/admin/js/ggad2_728x90.js"></script>
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
            <a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/index.html" class="navbar-brand">
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
                        window.location.href="/index";
                    </script>
                        <#else>
                    你好，<#if "${(userInfo.userType)!}" == "0">管理员
                <#elseif "${(userInfo.userType)!}"=="2">讲师
                </#if>
                        <#--</#if>-->
                    <span>${(userInfo.username)!}</span></li>   <#--此处是登录用户明显是地方${test.username}-->
                <li class="dropdown avatar-dropdown">
                    <img src="/admin/images/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown"
                         aria-haspopup="true" aria-expanded="true"/>
                    <ul class="dropdown-menu user-dropdown">
                        <li><a href="#"><span class="fa fa-user"></span> 我的信息</a></li>
                        <li><a href="#"><span class="fa fa-calendar"></span> 扩展功能</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="more">
                            <ul>
                                <li><a href=""><span class="fa fa-cogs"></span></a></li>
                                <li><a href=""><span class="fa fa-lock"></span></a></li>
                                <li><a href="/user/logout"><span class="fa fa-power-off " title="注销"></span></a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#" class="opener-right-menu"><span class="fa fa-coffee"></span></a></li>
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
                <!-- <li class="active ripple">
                  <a class="tree-toggle nav-header"><span class="fa-home fa"></span> Dashboard
                    <span class="fa-angle-right fa right-arrow text-right"></span>
                  </a>
                  <ul class="nav nav-list tree" style="display: none;">
                      <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/dashboard-v1.html">Dashboard v.1</a></li>
                      <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/dashboard-v2.html">Dashboard v.2</a></li>
                  </ul>
                </li> -->
                <li class="ripple">
                    <a href="/admin/index">
                        <span class="fa fa-home"></span> Home
                        <!-- <i class="fa fa-home"></i> -->
                        <span class="fa-angle-right fa right-arrow text-right"></span>
                    </a>
                <#--<ul class="nav nav-list tree" style="display: none;">-->
                <#--<li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/topnav.html">Top Navigation</a></li>-->
                <#--<li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/boxed.html">Boxed</a></li>-->
                <#--</ul>-->
                </li>
                <!-- <li class="ripple">
                  <a class="tree-toggle nav-header">
                    <span class="fa-area-chart fa"></span> Charts
                    <span class="fa-angle-right fa right-arrow text-right"></span>
                  </a>
                  <ul class="nav nav-list tree" style="display: none;">
                    <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/chartjs.html">ChartJs</a></li>
                    <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/morris.html">Morris</a></li>
                    <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/flot.html">Flot</a></li>
                    <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/sparkline.html">SparkLine</a></li>
                  </ul>
                </li> -->
                <li class="ripple"><a class="tree-toggle nav-header">
                    <span class="fa fa-pencil-square"></span> 用户管理 <span
                        class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li><a href="/user/lecture">讲师</a></li>
                        <li><a href="/user/common">普通用户</a></li>
                    </ul>
                </li>
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-check-square-o"></span> 课程管理
                    <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li><a href="/course/listAdmin">课程信息</a></li>
                        <li><a href="#">Wizard</a></li>
                    </ul>
                </li>
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-table"></span> 问答管理 <span
                        class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li>
                            <a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/datatables.html">问答信息</a>
                        </li>
                    </ul>
                </li>
                <!-- <li class="ripple"><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/calendar.html"><span class="fa fa-calendar-o"></span>Calendar</a></li>
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-envelope-o"></span> Mail <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                  <ul class="nav nav-list tree" style="display: none;">
                    <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/mail-box.html">Inbox</a></li>
                    <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/compose-mail.html">Compose Mail</a></li>
                    <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/view-mail.html">View Mail</a></li>
                  </ul>
                </li> -->
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa fa-file-code-o"></span> 考试管理 <span
                        class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li>
                            <a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/forgotpass.html">考试信息</a>
                        </li>
                    </ul>
                </li>
                <li class="ripple"><a class="tree-toggle nav-header"><span class="fa "></span> 字幕管理 <span
                        class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree" style="display: none;">
                        <li>
                            <a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/view-mail.html">字幕信息</a>
                        </li>
                        <li>
                            <a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/view-mail.html">预留扩展</a>
                        </li>
                    </ul>
                </li>
                <li><a href="http://demo.cssmoban.com/cssthemes4/btzero_30_miminiummaster/credits.html">其他扩展</a></li>
            </ul>
        </div>
    </div>
    <!-- end: Left Menu -->


