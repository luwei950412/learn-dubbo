

<#include "base/header.ftl">
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
                    <h3 style="margin-top: -10px;color: #ddd;">${(low_temp)!}-${(high_temp)!}${(weather)!}</h3>
                </div>
                <div class="col-md-6 col-sm-6">
                    <div class="snowy rainy animated pulse infinite">
                        <div class="shadow">

                        </div>
                    </div>
                    <script>

                    </script>
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
                            <img src="${base}/admin/images/bg2.jpg" class="box-v2-cover img-responsive"/>
                            <a data-toggle="modal" data-target="#myModal_update" title="用户信息">
                            <div class="box-v2-detail">
                                <img src="${base}/admin/upload/${(userInfo.headimg)!}" class="img-responsive"/>
                                <h4>${(userInfo.username)!}</h4>
                            </div>
                            </a>

                        <#--</div>-->
                        <!-- 模态框（Modal） ---------修改信息-->
                        <div style="margin-top: 50px" class="modal fade" id="myModal_update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                    <#--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">-->
                                    <#--&times;-->
                                    <#--</button>-->
                                        <h4 class="modal-title" id="myModalLabel">
                                            用户基本信息
                                        </h4>
                                    </div>
                                    <form action="${base}/user/updateAdminUser" method="post" enctype="multipart/form-data">
                                        <div class="modal-body" style="height:550px;width:400px">

                                            <label for="name" class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-9">
                                                <input type="hidden" name="id" value="${userInfo.id}" />
                                                <input type="text" style="width: 400px;" class="form-control" name="username"
                                                       value="${(userInfo.username)!}" placeholder="请输入用户">
                                            </div>
                                            <label for="name" class="col-sm-3 control-label">Email</label>
                                            <div class="col-sm-9">
                                                <input type="text" style="width: 400px;" class="form-control" name="email"
                                                       value="${(userInfo.email)!}" placeholder="请输入用户email">
                                            </div>
                                            <label for="name" class="col-sm-3 control-label">用户状态</label>
                                            <div class="col-sm-9">
                                                <input type="text" style="width: 400px;" class="form-control" name="userStatus" readonly
                                                       value="<#if userInfo.userStatus==0>正常<#elseif userInfo.userStatus==1>待审核<#else>冻结</#if>" placeholder="请输入用户状态">
                                            <#--<textarea id="quick_post" name="content" rows="10" cols="80" placeholder="请输入赛事内容">${(sportInfo.content)!}</textarea>-->
                                            </div>
                                            <label for="name" class="col-sm-3 control-label">用户类别</label>
                                            <div class="col-sm-9">
                                                <input type="text" style="width: 400px;" class="form-control" name="userType"
                                                       value="<#if userInfo.userType==0>管理员<#else>讲师</#if>" readonly placeholder="请输入用户类别">
                                            </div>
                                            <label for="name" class="col-sm-3 control-label">所在城市</label>
                                            <div class="col-sm-9">
                                                <input type="text" style="width: 400px;" class="form-control" name="city"
                                                       value="${(userInfo.city)!}" placeholder="请输入所在城市">
                                            </div>
                                            <label for="name" class="col-sm-3 control-label">用户状态</label>
                                            <div class="col-sm-9">
                                                <textarea id="quick_post" name="introduction" rows="10" cols="50" placeholder="请输入用户介绍">${(userInfo.introduction)!}</textarea>
                                            </div>
                                            <label for="name" class="col-sm-3 control-label">用户职位</label>
                                            <div class="col-sm-9">
                                                <input type="text" style="width: 400px;" class="form-control" name="position"
                                                       value="${(userInfo.position)!}" placeholder="请输入用户职位">
                                            </div>

                                            <label for="name" class="col-sm-3 control-label">用户头像</label>
                                            <div class="col-sm-9">
                                                <input type="file" style="width: 400px;" class="form-control" name="headimg" />
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" value="关闭" class="col-sm-4 btn btn-default" data-dismiss="modal" />
                                            <input type="submit" value="提交" class="col-sm-4 btn btn-primary" />
                                        </div>
                                    </form>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>
                        <#--model end-->

                        </div>
                        <div class="panel-body">
                            <div class="col-md-12 padding-0 text-center">
                                <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                                    <h3>9999</h3>
                                    <p>学习课程</p>
                                </div>
                                <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                                    <h3>${courseList?size}</h3>
                                    <p>上传课程</p>
                                </div>
                                <div class="col-md-4 col-sm-4 col-xs-12 padding-0">
                                    <h3>9999</h3>
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

        <#--<div class="col-md-12 card-wrap padding-0">-->
            <#--<div class="col-md-6">-->
                <#--<div class="panel">-->
                    <#--<div class="panel-heading bg-white border-none" style="padding:20px;">-->
                        <#--<div class="col-md-6 col-sm-6 col-sm-12 text-left">-->
                            <#--<h4>发布新闻</h4>-->
                        <#--</div>-->
                        <#--<div class="col-md-6 col-sm-6 col-sm-12">-->
                            <#--<div class="mini-onoffswitch pull-right onoffswitch-danger" style="margin-top:10px;">-->
                                <#--<input name="onoffswitch2" class="onoffswitch-checkbox" id="myonoffswitch1"-->
                                       <#--checked="checked" type="checkbox"/>-->
                                <#--<label class="onoffswitch-label" for="myonoffswitch1"></label>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="panel-body" style="padding-bottom:50px;">-->
                        <#--<div id="canvas-holder1">-->
                            <#--<canvas class="line-chart" style="margin-top: 30px; height: 240px; width: 100%;"-->
                                    <#--height="240" width="480"></canvas>-->
                        <#--</div>-->
                        <#--<div class="col-md-12" style="padding-top:20px;">-->
                            <#--<div class="col-md-4 col-sm-4 col-xs-6 text-center">-->
                                <#--<h2 style="line-height:.4;">100</h2>-->
                                <#--<small>发布新闻数</small>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->

            <#--<div class="col-md-6">-->
                <#--<div class="panel">-->
                    <#--<div class="panel-heading bg-white border-none" style="padding:20px;">-->
                        <#--<div class="col-md-6 col-sm-6 col-sm-12 text-left">-->
                            <#--<h4>发布通知</h4>-->
                        <#--</div>-->
                        <#--<div class="col-md-6 col-sm-6 col-sm-12">-->
                            <#--<div class="mini-onoffswitch pull-right onoffswitch-primary" style="margin-top:10px;">-->
                                <#--<input name="onoffswitch3" class="onoffswitch-checkbox" id="myonoffswitch3"-->
                                       <#--checked="checked" type="checkbox"/>-->
                                <#--<label class="onoffswitch-label" for="myonoffswitch3"></label>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="panel-body" style="padding-bottom:50px;">-->
                        <#--<div id="canvas-holder1">-->
                            <#--<canvas class="bar-chart" style="width: 480px; height: 240px;" height="240"-->
                                    <#--width="480"></canvas>-->
                        <#--</div>-->
                        <#--<div class="col-md-12" style="padding-top:20px;">-->
                            <#--<div class="col-md-4 col-sm-4 col-xs-6 text-center">-->
                                <#--<h2 style="line-height:.4;">100</h2>-->
                                <#--<small>发布通知数</small>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--<div class="col-md-12">-->
    <#--<div class="panel bg-green text-white">-->

    <#--</div>-->
    <#--</div>-->
    </div>
</div>


<!-- end: Mobile -->

<#include "base/right_menu.ftl">