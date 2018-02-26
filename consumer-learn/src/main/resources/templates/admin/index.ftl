<!DOCTYPE html>
<html lang="en">


<#include "base/header.ftl">
<body>
<!-- end: Header -->

<!-- start: content -->
<div id="content" style="padding-left: 230px; padding-right: 0px;">
    <div class="panel">
        <div class="panel-body">
            <div class="col-md-6 col-sm-12">
                <h3 class="animated fadeInLeft">后台管理中心</h3>
                <p class="animated fadeInDown"><span class="fa  fa-map-marker"></span> SEU,SuZhou</p>

                <ul class="nav navbar-nav">
                    <li><a href="">用户</a></li>
                    <li><a href="" class="active">课程</a></li>
                    <li><a href="">问答</a></li>
                    <li><a href="">测试</a></li>
                    <li><a href="">直播.</a></li>
                </ul>
            </div>
            <div class="col-md-6 col-sm-12">
                <div class="col-md-6 col-sm-6 text-right" style="padding-left:10px;">
                    <h3 style="color:#DDDDDE;"><span class="fa  fa-map-marker"></span> 苏州</h3>
                    <h1 style="margin-top: -10px;color: #ddd;">-2<sup>o</sup></h1>
                </div>
                <div class="col-md-6 col-sm-6">
                    <div class="snowy rainy animated pulse infinite">
                        <div class="shadow">

                        </div>
                    </div>
                    <div class="sub-wheather snowy-sub-wheather">
                        <div class="rain">
                            <div class="droplet droplet1"></div>
                            <div class="droplet droplet2"></div>
                            <div class="droplet droplet3"></div>
                            <div class="droplet droplet4"></div>
                            <div class="droplet droplet5"></div>
                            <div class="droplet droplet6"></div>
                        </div>
                    </div>
                <#--<div class="wheather">-->
                <#--<div class="stormy rainy animated pulse infinite">-->
                <#--<div class="shadow">-->

                <#--</div>-->
                <#--</div>-->
                <#--<div class="sub-wheather">-->
                <#--<div class="thunder">-->

                <#--</div>-->
                <#--<div class="rain">-->
                <#--<div class="droplet droplet1"></div>-->
                <#--<div class="droplet droplet2"></div>-->
                <#--<div class="droplet droplet3"></div>-->
                <#--<div class="droplet droplet4"></div>-->
                <#--<div class="droplet droplet5"></div>-->
                <#--<div class="droplet droplet6"></div>-->
                <#--</div>-->
                <#--</div>-->
                <#--</div>-->
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12" style="padding:20px;">
        <div class="col-md-12 padding-0">
            <div class="col-md-8 padding-0">
                <div class="col-md-12 padding-0">
                    <div class="col-md-6">
                        <div class="panel box-v1">
                            <div class="panel-heading bg-white border-none">
                                <div class="col-md-6 col-sm-6 col-xs-6 text-left padding-0">
                                    <h4 class="text-left">用户</h4>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6 text-right">
                                    <h4>
                                        <span class="fa fa-user icons icon text-right"></span>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel-body text-center">
                                <h1>${userList?size}</h1>
                                <p>用户数量</p>
                                <hr/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel box-v1">
                            <div class="panel-heading bg-white border-none">
                                <div class="col-md-6 col-sm-6 col-xs-6 text-left padding-0">
                                    <h4 class="text-left">课程</h4>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6 text-right">
                                    <h4>
                                        <span class="fa fa-shopping-basket icons icon text-right"></span>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel-body text-center">
                                <h1>${(courseList?size)!}</h1>
                                <p>课程数量</p>
                                <hr/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 padding-0">
                    <div class="col-md-6">
                        <div class="panel box-v1">
                            <div class="panel-heading bg-white border-none">
                                <div class="col-md-6 col-sm-6 col-xs-6 text-left padding-0">
                                    <h4 class="text-left">问答</h4>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6 text-right">
                                    <h4>
                                        <span class="fa fa-user icons icon text-right"></span>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel-body text-center">
                                <h1>${(commentList?size)!}</h1>
                                <p>评论数量</p>
                                <hr/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel box-v1">
                            <div class="panel-heading bg-white border-none">
                                <div class="col-md-6 col-sm-6 col-xs-6 text-left padding-0">
                                    <h4 class="text-left">测试</h4>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-6 text-right">
                                    <h4>
                                        <span class="fa fa-shopping-basket icons icon text-right"></span>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel-body text-center">
                                <h1>51181,320</h1>
                                <p>New Orders</p>
                                <hr/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="panel box-v4">
                        <div class="panel-heading bg-white border-none">
                            <h4><span class="fa fa-notebook icons"></span> Agenda</h4>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="col-md-12 padding-0">
                    <div class="panel box-v2">
                        <div class="panel-heading padding-0">
                            <img src="/admin/images/bg2.jpg" class="box-v2-cover img-responsive"/>
                            <div class="box-v2-detail">
                                <img src="/admin/images/avatar.jpg" class="img-responsive"/>
                                <h4>luwei</h4>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="col-md-12 padding-0 text-center">
                                <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                                    <h3>2.00</h3>
                                    <p>学习课程</p>
                                </div>
                                <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                                    <h3>10.0</h3>
                                    <p>上传课程</p>
                                </div>
                                <div class="col-md-4 col-sm-4 col-xs-12 padding-0">
                                    <h3>100</h3>
                                    <p>问答数量</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-12 padding-0">
                    <div class="panel bg-light-blue">
                        <div class="panel-body text-white">
                            <p class="animated fadeInUp quote">不断的追求与努力的创新是我们奋斗不竭的动力"</p>
                            <div class="col-md-12 padding-0">
                                <div class="text-left col-md-7 col-xs-12 col-sm-7 padding-0">
                                    <span class="fa fa-twitter fa-2x"></span>
                                    <span>26 Jan, 2018 lw web</span>
                                </div>
                                <div style="padding-top:8px;" class="text-right col-md-5 col-xs-12 col-sm-5 padding-0">
                                    <span class="fa fa-retweet"></span> 2000
                                    <span class="fa fa-star"></span> 3000
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-12 card-wrap padding-0">
            <div class="col-md-6">
                <div class="panel">
                    <div class="panel-heading bg-white border-none" style="padding:20px;">
                        <div class="col-md-6 col-sm-6 col-sm-12 text-left">
                            <h4>发布新闻</h4>
                        </div>
                        <div class="col-md-6 col-sm-6 col-sm-12">
                            <div class="mini-onoffswitch pull-right onoffswitch-danger" style="margin-top:10px;">
                                <input name="onoffswitch2" class="onoffswitch-checkbox" id="myonoffswitch1"
                                       checked="checked" type="checkbox"/>
                                <label class="onoffswitch-label" for="myonoffswitch1"></label>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body" style="padding-bottom:50px;">
                        <div id="canvas-holder1">
                            <canvas class="line-chart" style="margin-top: 30px; height: 240px; width: 100%;"
                                    height="240" width="480"></canvas>
                        </div>
                        <div class="col-md-12" style="padding-top:20px;">
                            <div class="col-md-4 col-sm-4 col-xs-6 text-center">
                                <h2 style="line-height:.4;">100</h2>
                                <small>发布新闻数</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="panel">
                    <div class="panel-heading bg-white border-none" style="padding:20px;">
                        <div class="col-md-6 col-sm-6 col-sm-12 text-left">
                            <h4>发布通知</h4>
                        </div>
                        <div class="col-md-6 col-sm-6 col-sm-12">
                            <div class="mini-onoffswitch pull-right onoffswitch-primary" style="margin-top:10px;">
                                <input name="onoffswitch3" class="onoffswitch-checkbox" id="myonoffswitch3"
                                       checked="checked" type="checkbox"/>
                                <label class="onoffswitch-label" for="myonoffswitch3"></label>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body" style="padding-bottom:50px;">
                        <div id="canvas-holder1">
                            <canvas class="bar-chart" style="width: 480px; height: 240px;" height="240"
                                    width="480"></canvas>
                        </div>
                        <div class="col-md-12" style="padding-top:20px;">
                            <div class="col-md-4 col-sm-4 col-xs-6 text-center">
                                <h2 style="line-height:.4;">100</h2>
                                <small>发布通知数</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <#--<div class="col-md-12">-->
    <#--<div class="panel bg-green text-white">-->

    <#--</div>-->
    <#--</div>-->
    </div>
</div>


<!-- end: Mobile -->

<#include "base/right_menu.ftl">