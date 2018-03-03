<!DOCTYPE html >
<html>
<head>
    <title>My Center</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="/mycenter/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/elements.css" />
    <link rel="stylesheet" type="text/css" href="css/icons.css" />
    <link rel="stylesheet" type="text/css" href="/mycenter/css/new.css" />
    <link rel="stylesheet" type="text/css" href="css/zcity.css">

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/index.css" type="text/css" media="screen" />


    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<#if "${(userFront.username)!}"=="">
<script>
    window.location.href="/front/index";
</script>
</#if>
<!-- navbar -->
<div class="navbar navbar-inverse">
    <div class="navbar-inner">
        <button type="button" class="btn btn-navbar visible-phone" id="menu-toggler">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <a class="brand" href="${base}/front/index"><img src="img/logo.png" /></a>

        <ul class="nav pull-right">
            <li class="hidden-phone">
                <input class="search" type="text" />
            </li>
            <li class="notification-dropdown hidden-phone">
                <a href="#" class="trigger">
                    <i class="icon-warning-sign"></i>
                    <span class="count">8</span>
                </a>
                <div class="pop-dialog">
                    <div class="pointer right">
                        <div class="arrow"></div>
                        <div class="arrow_border"></div>
                    </div>
                    <div class="body">
                        <a href="#" class="close-icon"><i class="icon-remove-sign"></i></a>
                        <div class="notifications">
                            <h3>You have 6 new notifications</h3>
                            <a href="#" class="item">
                                <i class="icon-signin"></i> New user registration
                                <span class="time"><i class="icon-time"></i> 13 min.</span>
                            </a>
                            <a href="#" class="item">
                                <i class="icon-signin"></i> New user registration
                                <span class="time"><i class="icon-time"></i> 18 min.</span>
                            </a>
                            <a href="#" class="item">
                                <i class="icon-envelope-alt"></i> New message from Alejandra
                                <span class="time"><i class="icon-time"></i> 28 min.</span>
                            </a>
                            <a href="#" class="item">
                                <i class="icon-signin"></i> New user registration
                                <span class="time"><i class="icon-time"></i> 49 min.</span>
                            </a>
                            <a href="#" class="item">
                                <i class="icon-download-alt"></i> New order placed
                                <span class="time"><i class="icon-time"></i> 1 day.</span>
                            </a>
                            <div class="footer">
                                <a href="#" class="logout">View all notifications</a>
                            </div>
                        </div>
                    </div>
                </div>
            </li>

            <li class="notification-dropdown hidden-phone">
                <a href="#" class="trigger">
                    <i class="icon-envelope-alt"></i>
                </a>
                <div class="pop-dialog">
                    <div class="pointer right">
                        <div class="arrow"></div>
                        <div class="arrow_border"></div>
                    </div>
                    <div class="body">
                        <a href="#" class="close-icon"><i class="icon-remove-sign"></i></a>
                        <div class="messages">
                            <a href="#" class="item">
                                <img src="img/contact-img.png" class="display" />
                                <div class="name">Alejandra Galván</div>
                                <div class="msg">
                                    There are many variations of available, but the majority have suffered alterations.
                                </div>
                                <span class="time"><i class="icon-time"></i> 13 min.</span>
                            </a>
                            <a href="#" class="item">
                                <img src="img/contact-img2.png" class="display" />
                                <div class="name">Alejandra Galván</div>
                                <div class="msg">
                                    There are many variations of available, have suffered alterations.
                                </div>
                                <span class="time"><i class="icon-time"></i> 26 min.</span>
                            </a>
                            <a href="#" class="item last">
                                <img src="img/contact-img.png" class="display" />
                                <div class="name">Alejandra Galván</div>
                                <div class="msg">
                                    There are many variations of available, but the majority have suffered alterations.
                                </div>
                                <span class="time"><i class="icon-time"></i> 48 min.</span>
                            </a>
                            <div class="footer">
                                <a href="#" class="logout">View all messages</a>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle hidden-phone" data-toggle="dropdown">
                    Your account
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="personal-info.html">Personal info</a></li>
                    <li><a href="#">Account settings</a></li>
                    <li><a href="#">Billing</a></li>
                    <li><a href="#">Export your data</a></li>
                    <li><a href="#">Send feedback</a></li>
                </ul>
            </li>
            <li class="settings hidden-phone">
                <a href="personal-info.html" role="button">
                    <i class="icon-cog"></i>
                </a>
            </li>
            <li class="settings hidden-phone">
                <a href="signin.html" role="button">
                    <i class="icon-share-alt"></i>
                </a>
            </li>
        </ul>
    </div>
</div>
<!-- end navbar -->

<!-- sidebar -->
<div id="sidebar-nav">
    <ul id="dashboard-menu">
        <li>
            <div id="p_active1" >
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
            </div>
            <a href="myprofile">
                <div id="active1">
                <i class="icon-home"></i>
                <span>资料</span>
                </div>
            </a>
        </li>
        <li>
            <div id="p_active2"  >
            <div class="pointer">
                <div class="arrow"></div>
                <div class="arrow_border"></div>
            </div>
        </div>
            <a class="dropdown-toggle" href="#">
                <div id="active2">
                <i class="icon-signal"></i>
                <span>课程</span>
                <i class="icon-chevron-down"></i>
                </div>
            </a>
            <ul class="submenu">
                <li><a href="recent"><span class="drop-item"">最近学习</span></a></li>
                <li><a href="favorite"><span class="drop-item">我的收藏</span></a></li>
            </ul>
        </li>
        <li>
            <div id="p_active3">
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
            </div>
            <a class="dropdown-toggle" href="#">
                <div id="active3">
                <i class="icon-group"></i>
                <span>问答</span>
                <i class="icon-chevron-down"></i>
                </div>
            </a>
            <ul class="submenu">
                <li><a href="myquestion"><span class="drop-item">我的提问</span></a></li>
                <li><a href="myanswer"><span class="drop-item">我的回答</span></a></li>
                <li><a href="myfollow"><span class="drop-item">我的关注</span></a></li>
            </ul>
        </li>
        <li>
            <div id="p_active4">
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
            </div>
            <a href="score"id="active4">
                <div id="active4">
                <i class="icon-edit"></i>
                <span>成绩</span>
                </div>
            </a>
        </li>
        <li>
            <div id="p_active5">
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
            </div>
            <a href="schedule" id="active5">
                <div id="active5">
                <i class="icon-calendar-empty"></i>
                <span>计划</span>
                </div>
            </a>
        </li>
        <li>
            <div id="p_active6">
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
            </div>
            <a href="community" id="active6">
                <div id="active6">
                <i class="icon-th-large"></i>
                <span>社区</span>
                </div>
            </a>
        </li>
        <li>
            <div id="p_active7">
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
            </div>
            <a href="setting" id="active7">
                <div id="active7">
                <i class="icon-cog"></i>
                <span>设置</span>
                </div>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="icon-share-alt"></i>
                <span>退出</span>
            </a>
        </li>
    </ul>
</div>
<!-- end sidebar -->



</body>
</html>