<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Education</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${base}/front/css/video_page.css" type="text/css">
    <link rel="stylesheet" href="${base}/front/css/mocoplayer.css" type="text/css">
    <link rel="stylesheet" href="${base}/front/css/style.css" type="text/css">
</head>
<body>

<div id="header" class="course-detail-header">
    <div class="cd-inner clearfix">
        <ul class="l">
            <li class="nv nv-goback"><a href="https://www.imooc.com/learn/924" class="revert l"><i class="icon icon-left"></i></a></li>
            <li class="nv nv-menu">
                <a href="javascript:;" class="chaptername J-chaptername" data-id="16211" style="cursor:text;"><span>${(video.videoName)!}</span><em>${(chapter.chapterName)!}</em></a>
            </li>
            <li class="nv nv-share bdsharebuttonbox bdshare-button-style0-16" data-bd-bind="1520060968915">
                <span>分享</span>
                <a class="icon-cloud" data-cmd="weixin" title="分享到微信"></a>
                <a class="icon-renren" data-cmd="qzone" href="#" title="分享到QQ空间"></a>
                <a class="icon-sina-weibo" data-cmd="tsina" title="分享到新浪微博"></a>

                <#--<div style="display:none" id="coursePic"><img src="%E8%AF%BE%E7%A8%8B%E4%BB%8B%E7%BB%8D%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%91_files/5a2f4d7f00012c8106000338-590-330.jpg">-->
                <#--</div>-->
            </li>

        </ul>

        <div id="login-area">
            <ul class="clearfix logined">

                <li class="set_btn user-card-box" id="header-user-card">
                    <a id="header-avator" class="user-card-item" action-type="my_menu" href="https://www.imooc.com/u/1328987/courses" target="_self">
                        <img src="${base}/admin/upload/${(userFront.headimg)!}" width="40" height="40">
                        <i class="myspace_remind" style="display: none;"></i>
                        <span style="display: none;">动态提醒</span>
                    </a>
                    <div class="g-user-card">
                        <div class="card-inner">
                            <div class="card-top clearfix">
                                <a href="https://www.imooc.com/u/1328987" class="l">
                                    <img src="%E8%AF%BE%E7%A8%8B%E4%BB%8B%E7%BB%8D%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%91_files/545846580001fede02200220-100-100.jpg" alt="luwei13218016163">
                                </a>
                                <div class="card-top-right-box l">
                                    <a href="https://www.imooc.com/u/1328987">
                                        <span class="name text-ellipsis">luwei13218016163</span>
                                    </a>
                                    <div class="meta">
                                        <a href="https://www.imooc.com/u/1328987/experience">经验<b id="js-user-mp">1,243</b>
                                        </a>
                                        <a href="https://www.imooc.com/u/1328987/credit">积分<b id="js-user-credit">0</b>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </li>

            </ul>
        </div>

    </div>
</div>



<div id="studyMain">

    <div id="bgarea" class="video-con">
        <div class="js-box-wrap" style="width: 100%; height: 460px;">

            <!-- ***********视频部分********** -->
            <video src="${base}/admin/upload/${(video.filePath)!}" width="100%" height="450" controls preload="metadata">
            </video>

        </div>
        <div class="section-list">
            <div class="operator">
                <div class="op chapter"><em class="icon-menu"></em>章节</div>
                <div class="op notes"><em class="icon-note"></em>笔记</div>
                <div class="op question"><em class="icon-addques"></em>提问</div>
                <div class="op wiki"><em class="icon-wiki"></em>WIKI</div>
            </div>
            <div class="nano has-scrollbar">
                <div class="nano-content" tabindex="0" style="right: -17px;">
                    <h3>IntelliJ IDEA神器使用技巧...</h3>
                    <ul>
                        <li class="sec-title">
                            <span>第1章 课程介绍</span>
                        </li>
                        <li data-id="16211">
                            <a href="https://www.imooc.com/video/16211"><i class="">正在学<em class="icon-clock"></em></i><em class="icon-video"></em>1-1 课程介绍(01:44)</a>
                        </li>
                        <li data-id="16212">
                            <a href="https://www.imooc.com/video/16212"><i class=""><em class="icon-nolearn"></em></i><em class="icon-video"></em>1-2 神器初试(02:03)</a>
                        </li>
                        <li data-id="16213">
                            <a href="https://www.imooc.com/video/16213"><i class=""><em class="icon-nolearn"></em></i><em class="icon-video"></em>1-3 IDEA下载(03:48)</a>
                        </li>
                        <li data-id="16214">
                            <a href="https://www.imooc.com/video/16214"><i class=""><em class="icon-nolearn"></em></i><em class="icon-video"></em>1-4 IDEA安装(03:44)</a>
                        </li>
                        <li data-id="16215">
                            <a href="https://www.imooc.com/video/16215"><i class=""><em class="icon-nolearn"></em></i><em class="icon-video"></em>1-5 IDEA界面介绍(06:11)</a>
                        </li>
                    </ul>
                </div>
                <!-- <div class="nano-pane">
                    <div class="nano-slider" style="height: 143px; transform: translate(0px, 0px);">

                    </div>
                </div> -->
            </div>
        </div></div>

    <!-- <div class="maybe-wenda" id="maybe-wenda" style="display: none;">
        <i class="icon-chat"></i>
        <p class="text">你发的评论可能会是问题？<br>是否将他发到问答中</p>
        <input class="btn ok" value="好的" id="wenda-ok" type="button">
        <input class="btn no" value="不用" id="wenda-no" type="button">
    </div> -->
</div>

<div class="course-subcontainer clearfix">
    <div class="course-left">
        <ul class="course-menu course-video-menu clearfix js-course-menu" data-ower="all" data-sort="last" style="position: absolute; left: 0px;">
            <li class="course-menu-item"><a class="active" href="javascript:void(0)" id="plMenu">评论</a></li>
            <li class="course-menu-item"><a href="javascript:void(0)" id="qaMenu" class="">问答</a></li>
            <li class="course-menu-item"><a href="javascript:void(0)" id="noteMenu">笔记</a></li>
        </ul>
        <div id="disArea" class="lists-container list-wrap">
            <div id="pl-content" class="list-tab-con" style="display: block;">
                <div class="publish clearfix" id="discus-publish">
                    <div class="publish-wrap publish-wrap-pl">
                        <div class="pl-input-wrap clearfix">
                            <div class="pl-input-box clearfix">
                                <a href="" class="user-head l">
                                    <img src="%E8%AF%BE%E7%A8%8B%E4%BB%8B%E7%BB%8D%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%91_files/avatar_default.png">
                                </a>
                                <div id="js-pl-input-fake" class="pl-input-inner l">
                                    <textarea id="js-pl-textarea" class="js-placeholder" placeholder="扯淡、吐槽、表扬、鼓励……想说啥就说啥！"></textarea>
                                    <span class="num-limit"><span id="js-pl-limit">0</span>/300</span>
                                </div>
                            </div>
                            <div class="pl-input-btm input-btm clearfix">

                                <div class="captcha-verify-box js-verify-box hide"></div>
                                <input id="js-pl-submit" class="r course-btn" value="发表评论" type="button">
                            </div>
                        </div>

                    </div>
                </div>
                <div id="plLoadListData">
                    <div class="pl-container">

                        <ul>
                            <li class="pl-list clearfix">
                                <div class="pl-list-avator">
                                    <a href="https://www.imooc.com/u/3936322/courses" target="_blank">
                                        <img src="%E8%AF%BE%E7%A8%8B%E4%BB%8B%E7%BB%8D%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%91_files/57cc5f1d0001675a00910087-40-40.jpg" title="zsail" width="40" height="40">
                                    </a>

                                </div>
                                <div class="pl-list-main">
                                    <div class="pl-list-nick">
                                        <a href="https://www.imooc.com/u/3936322/courses" target="_blank">zsail</a>
                                    </div>
                                    <div class="pl-list-content">idea是业界公认最好的开发工具，用了一年多了，比eclipse强大太多，看慕课出了个视频，来看一下有没有什么新的收获</div>
                                    <div class="pl-list-btm clearfix">
                                        <span class="pl-list-time l">时间: 2017-12-13</span>
                                        <a title="赞" href="javascript:;" class="js-pl-praise list-praise r" data-id="523684">
                                            <i class="icon-thumb-revert"></i>
                                            <span>13</span></a>
                                        <a href="javascript:;" data-id="523684" data-type="4" data-uid="3936322" class="js-tip-off r tipoff">举报</a>
                                    </div>
                                </div>
                            </li>

                            <li class="pl-list clearfix">
                                <div class="pl-list-avator">
                                    <a href="https://www.imooc.com/u/4713809/courses" target="_blank"><img src="%E8%AF%BE%E7%A8%8B%E4%BB%8B%E7%BB%8D%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%91_files/58e9df9b000194e404190419-40-40.jpg" title="大头5680" width="40" height="40"></a>
                                </div>
                                <div class="pl-list-main">
                                    <div class="pl-list-nick">
                                        <a href="https://www.imooc.com/u/4713809/courses" target="_blank">大头5680</a>
                                    </div>
                                    <div class="pl-list-content">全网都没找到IDEA的视频教程，今天在幕课看到了。先点赞，后学习</div>
                                    <div class="pl-list-btm clearfix">
                                        <span class="pl-list-time l">时间: 2017-12-16</span>
                                        <a title="赞" href="javascript:;" class="js-pl-praise list-praise r" data-id="524712"><i class="icon-thumb-revert"></i>
                                            <span>5</span>
                                        </a>
                                        <a href="javascript:;" data-id="524712" data-type="4" data-uid="4713809" class="js-tip-off r tipoff">举报</a>
                                    </div>
                                </div>
                            </li>

                        </ul>
                    </div>
                    <div class="page pl-list-page">
                        <span class="disabled_page">首页</span>
                        <span class="disabled_page">上一页</span>
                        <a href="javascript:void(0)" data-page="1" class="active text-page-tag">1</a>
                        <a href="javascript:void(0)" data-page="2" class="text-page-tag">2</a>
                        <a href="javascript:void(0)" data-page="2">下一页</a>
                        <a href="javascript:void(0)" data-page="2">尾页</a>
                    </div>
                </div>
            </div>

        </div>
        <div class="tipoff-block js-tipoff-block"></div>
    </div>
    <div class="course-right clearfix">
        <div class="js-recom-box">
            <div class="box mb40 all-attention-box">
                <h4>大家都关注</h4>
                <div class="js-all-attention all-attention"><a href="https://www.imooc.com/topic/java" target="_blank" data-id="56" class="blue fs16 normal">零基础入门Java Web</a><a href="https://www.imooc.com/topic/uiandroid" target="_blank" data-id="42" class="yellow fs18 bold">Android开发入门</a><a href="https://www.imooc.com/topic/springboot" target="_blank" data-id="54" class="orange fs14 normal">Spring Boot实战项目</a><a href="https://www.imooc.com/topic/job" target="_blank" data-id="50" class="lake-blue fs20 bold">求职全攻略</a><a href="https://www.imooc.com/topic/list" target="_blank" data-id="45" class="green fs16 normal">职场必杀技清单</a><a href="https://www.imooc.com/topic/zhaopin" target="_blank" data-id="44" class="yellow fs18 bold">校招面试技巧合辑</a><a href="https://www.imooc.com/topic/bigdata" target="_blank" data-id="52" class="blue fs14 bold">大数据实战</a>
                </div>
            </div>
            <div class="box mb40 recom-course-list-box">
                <h4>推荐课程</h4>
                <ul class="js-recom-course recom-course-list clearfix">
                    <li class="clearfix">
                        <a href="https://coding.imooc.com/class/186.html" class="clearfix" target="_blank">
                            <div class="l course-img" style="background-image: url(//szimg.mukewang.com/5a82c6c200013f0905400300-360-202.jpg);">
                                <div class="cart-color red"></div>
                            </div>
                            <div class="l content-box">
                                <p class="smalle-title">分布式架构之路 Tomcat集群与优化</p>
                                <p class="content-text" title=""></p>
                                <div class="clearfix learn-detail">中级<span>·</span>15人在学</div>
                            </div>
                        </a>
                    </li>

                    <li class="clearfix">
                        <a href="https://www.imooc.com/learn/166" class="clearfix" target="_blank">
                            <div class="l course-img" style="background-image: url(https://www.imooc.com/courseimg/s/cover007_s.jpg);">
                                <div class="cart-color red"></div>
                            </div>
                            <div class="l content-box">
                                <p class="smalle-title">JAVA遇见HTML——JSP篇</p>
                                <p class="content-text" title="亲，这里有资深讲师为初学者量身打造的Java Web入门级课程JSP，讲师将通过大量的案例向您展示JavaWeb开发环境搭建、工具使用和JSP的基本语法，深入理解Java Web开发思想，最终使您能独立开发简单的Java Web应用。">亲，这里有资深讲师为初学者量身打造的Java Web入门级课程JSP，讲师将通过大量的案例向您展示JavaWeb开发环境搭建、工具使用和JSP的基本语法，深入理解Java Web开发思想，最终使您能独立开发简单的Java Web应用。</p>
                                <div class="clearfix learn-detail">初级<span>·</span>183937人在学</div>
                            </div>
                        </a>
                    </li>

                </ul>
            </div>
        </div>



        <div class="articlelist js-right-article" style="display: block;">
            <div class="course-right-title">
                <h3>手记推荐</h3>
                <a href="https://www.imooc.com/article/?block_id=tuijian_wz" target="_blank" class="more">更多</a>
            </div>
            <div class="course-right-content">

            </div>
            <ul>
                <li>
                    <a href="https://www.imooc.com/article/23616?block_id=tuijian_wz" target="_blank">Jsoup选择器使用</a>
                </li>
                <li>
                    <a href="https://www.imooc.com/article/23609?block_id=tuijian_wz" target="_blank">Springboot 与 Redis 集成 简易Redis工具类实现</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<#--<#include "../base/footer.ftl" />-->
</body>
</html>