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
    <#--<link rel="stylesheet" href="${base}/front/css/test1.css" type="text/css">-->

    <link rel="stylesheet" href="${base}/front/css/icomoon.css">
    <link rel="stylesheet" href="${base}/front/css/bootstrap.css">
</head>
<body>

<#-- ajax 刷新评论信息 -->
<script>
    // 添加评论信息
    dosave=function () {
        // 给Date原型添加转化成字符串格式yyyy-MM-dd HH:mm:ss函数
//        Date.prototype.toMyStr = function() {
//            return this.getFullYear()
//                    + '-' + (this.getMonth() + 1).padLeft(2)
//                    + '-' + this.getDate().padLeft(2)
//                    + ' ' + this.getHours().padLeft(2)
//                    + ':' + this.getMinutes().padLeft(2)
//                    + ':' + this.getSeconds().padLeft(2);
//        };
        console.log("hhhhhhssshhhhhhhhh");
        console.log("++++++++++++++++++++++++++++");
        var userId1 = document.getElementById("userId").value;
        var videoId1 = document.getElementById("videoId").value;
        var content=document.getElementById("js-pl-textarea").value;
        var date=new Date()
        var time=date.getFullYear()+'-'+date.getMonth()+'-'+date.getDate()+' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
        console.log("userId: "+userId1+" videoId: "+videoId1+" content: "+content);
        console.log(time);
        if(userId1 != 0){
            $.ajax({
                type: "POST",
                url: "/video/commentList",
                data:{"videoId":videoId1,"user.id":userId1,"content":content},
                success:function(data){
                    if(data == "success"){
                        var str="";
                    }
                },
                complete: function() {
//                    alert("hello");
                }
            });
//            console.log(video.currentTime);
        }else{
            alert("登录才能评论");
            return;
        }
        console.log("ajax 传递");
        var container=document.getElementById("comments-container");
        var li=document.createElement("li");
        li.setAttribute("class","pl-list clearfix");
        li.setAttribute("style","list-style:none;");
//        var node=document.createTextNode("这是新段落。");
//        li.appendChild(node);
        <#--var base = ${base?js_string};-->
        <#--alert(base);-->
        <#--var headimg = ${(userFront.headimg?js_string)!};-->
//        console.log(headimg);
        <#--var username = ${(userFront.username?js_string)!};-->
        var text= "                              <div class=\"pl-list-avator\">"+
                "                                    <a href=\"https://www.imooc.com/u/3936322/courses\" target=\"_blank\">"+
                "                                        <img src=\"/admin/upload/\" title=\"zsail\" width=\"40\" height=\"40\">"+
                "                                    </a>"+
                "                                </div>"+
                "                                <div class=\"pl-list-main\">"+
                "                                    <div class=\"pl-list-nick\">"+
                "                                        <a href=\"https://www.imooc.com/u/3936322/courses\" target=\"_blank\">luwei</a>"+
                "                                    </div>"+
                "                                    <div class=\"pl-list-content\">"+content+"</div>"+
                "                                    <div class=\"pl-list-btm clearfix\">"+
                "                                        <span class=\"pl-list-time l\">"+time+"</span>"+
                "                                    </div>"+
                "                                </div>";

        li.innerHTML=text;
        container.append(li);
    };
    <#--<li class="pl-list clearfix">-->
    <#--<div class="pl-list-avator">-->
    <#--<a href="https://www.imooc.com/u/3936322/courses" target="_blank">-->
    <#--<img src="%E8%AF%BE%E7%A8%8B%E4%BB%8B%E7%BB%8D%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%91_files/57cc5f1d0001675a00910087-40-40.jpg" title="zsail" width="40" height="40">-->
    <#--</a>-->

    <#--</div>-->
    <#--<div class="pl-list-main">-->
    <#--<div class="pl-list-nick">-->
    <#--<a href="https://www.imooc.com/u/3936322/courses" target="_blank">zsail</a>-->
    <#--</div>-->
    <#--<div class="pl-list-content">${comment.content}</div>-->
    <#--<div class="pl-list-btm clearfix">-->
    <#--<span class="pl-list-time l">时间: ${comment.createDate?datetime}</span>-->
    <#--</div>-->
    <#--</div>-->
    <#--</li>-->
</script>

<div id="header" class="course-detail-header">
    <div class="cd-inner clearfix">
        <ul class="l">
            <li class="nv nv-goback"><a style="height: 70px;"href="${base}/chapter/listChapter?id=${chapter.courseId}" class="revert l">
                <i style="font-size: 25px;line-height: 70px;" class="icon-arrow-back"></i></a></li>
            <li class="nv nv-menu">
                <a href="javascript:;" class="chaptername J-chaptername" data-id="16211" style="cursor:text;">
                    <span style="font-size: 18px;">${(chapter.chapterName)!}</span>
                    <em>${video.serialNumber}&nbsp;&nbsp;&nbsp;${(video.videoName)!}</em></a>
            </li>
            <li class="nv nv-share bdsharebuttonbox bdshare-button-style0-16" data-bd-bind="1520060968915">
                <span>分享</span>
                <a href="" data-cmd="weixin" title="分享到微信"><i class="icon-cloud4"></i></a>
                <a href="" data-cmd="qzone" title="分享到QQ空间"><i class="icon-renren"></i></a>
                <a href="" data-cmd="tsina" title="分享到新浪微博"><i class="icon-sina-weibo"></i></a>

                <#--<div style="display:none" id="coursePic"><img src="%E8%AF%BE%E7%A8%8B%E4%BB%8B%E7%BB%8D%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%91_files/5a2f4d7f00012c8106000338-590-330.jpg">-->
                <#--</div>-->
            </li>

        </ul>

        <div id="login-area">
            <ul class="clearfix logined">
                <#if "${(userFront.username)!}" != "">
                <li class="set_btn user-card-box" id="header-user-card">
                    <a id="header-avator" class="user-card-item" action-type="my_menu" href="${base}/mycenter/myprofile" target="_blank">
                        <img src="${base}/admin/upload/${(userFront.headimg)!}" width="40" height="40">
                        <#--<i class="myspace_remind"></i>-->
                        <b>${(userFront.username)!}</b>
                    </a>
                    <div class="g-user-card">
                        <div class="card-inner">
                            <div class="card-top clearfix">
                                <a href="#" class="l">
                                    <img src="" alt="luwei13218016163">
                                </a>
                                <div class="card-top-right-box l">
                                    <a href="">
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
                <#else>
                    <li class="set_btn user-card-box" id="header-user-card">
                        <a id="header-avator" class="user-card-item"  href="${base}/user/frontLogin" target="_blank">
                            您还没有登录，请登录保存学习进度
                            <i class="myspace_remind" style="display: none;"></i>
                        </a>
                    </li>
                </#if>
            </ul>
        </div>

    </div>
</div>



<div id="studyMain">

    <div id="bgarea" class="video-con">
        <div class="js-box-wrap" style="width: 100%; height: 460px;">
            <#if "${(userFront.id)!}"=="">
                <input type="hidden" id="userId" value="0" />
                <input type="hidden" id="progress" value="0">
            <#else>
                <input type="hidden" id="userId" value="${(userFront.id)!}" />
                <input type="hidden" id="progress" value="${(userVideo.progress)!}" />
                <input type="hidden" id="courseId" value="${(course.id)!}" />
            </#if>


                <input type="hidden" id="videoId" value="${(video.id)!}" />
            <!-- ***********视频部分********** -->
            <video id="video1" src="${base}/admin/upload/${(video.filePath)!}" width="100%" height="450" controls preload="metadata">
                您的浏览器不支持 HTML5 video
            </video>

        </div>
        <div class="section-list">
            <div class="operator">
                <div class="op chapter"><em class="icon-align-left"></em>章节</div>
                <div class="op notes"><em class="icon-note"></em>笔记</div>
                    <div class="op question">
                    <em class="icon-addques"></em>提问
                    </div>
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
            </div>
        </div></div>
</div>


<#-- script 脚本 -->
<#--<p>------------×××××××××××××××××××××-------</p>-->
<button id="p1"></button>
<button id = "p2"></button>




<#--ajax-->

<script type="text/javascript">
    video=document.getElementById("video1");
    var userId1 = document.getElementById("userId").value;
    var videoId1 = document.getElementById("videoId").value;
    var progress = document.getElementById("progress").value;
    var courseId = document.getElementById("courseId").value;
    playBySeconds();
    function playBySeconds() {
        video.currentTime = progress;
    }

    window.onbeforeunload = function(event) {

        if(userId !="kong"){
            event.returnValue = "test..";
            console.log(video.currentTime);

            $.ajax({
                type: "POST",
                url: "/vp/addRecord",
                data:{progress:video.currentTime,videoId:videoId1,userId:userId1,courseId:courseId},
                success:function(data){
                    if(data == "success"){
                    }
                },
                complete: function() {
                }
            });
            console.log(video.currentTime);
        }
    };
</script>

<script type="text/javascript">
    video=document.getElementById("video1")
    var i = setInterval(function() {
        // 这里注意, 必须判断视频的 readyState。
        // 因为有可能没加载完，则获取到的视频时长信息是不正确的。
        if(video.readyState > 0) {
            // 计算,10进制，以及取模
            var minutes = parseInt(video.duration / 60, 10);
            var seconds = video.duration % 60;

            // (此处可以添加代码，将分钟，秒数显示到需要的地方)
//            document.getElementById("p1").innerText="视频时长"+minutes+":"+parseInt(seconds);

            // 执行到这里，就将循环定时器清除。
            clearInterval(i);
        }
    }, 200);

    //获取实时进度
    getvideoprogress();
    function getvideoprogress() {
        setTimeout(function () {
            var vid = document.getElementById("video1");
            var currentTime = vid.currentTime.toFixed(1);
//            if (currentTime == 1.2) {
//                //触发
//                return false;
//            }
//            document.getElementById("p2").innerText = currentTime;
            getvideoprogress();
        }, 50);
    }
</script>


<#-- script 脚本 -->

<div class="course-subcontainer clearfix">
    <div class="course-left">
        <ul id="myTab" class="course-menu course-video-menu clearfix js-course-menu">
            <li class="active"><a href="#comment" data-toggle="tab" id="plMenu">评论</a></li>
            <li><a href="#qa" data-toggle="tab">问答</a></li>
            <li><a href="javascript:void(0)" id="noteMenu">笔记</a></li>
        </ul>
        <div id="myTabContent" class="tab-content lists-container list-wrap ">
            <div class="tab-pane fade in active" id="comment">
                <div class="publish clearfix" id="discus-publish">
                    <div class="publish-wrap publish-wrap-pl">
                        <div class="pl-input-wrap clearfix">
                            <div class="pl-input-box clearfix">
                                <a href="" class="user-head l">
                                    <img src="<#if "${(userFront.id)!}"=="">${base}/admin/upload/head.jpg<#else>${base}/admin/upload/${(userFront.headimg)!}</#if>" />
                                </a>
                                <div id="js-pl-input-fake" class="pl-input-inner l">
                                    <textarea id="js-pl-textarea" class="js-placeholder" placeholder="扯淡、吐槽、表扬、鼓励……想说啥就说啥！"></textarea>
                                    <span class="num-limit"><span id="js-pl-limit">0</span>/300</span>
                                </div>
                            </div>
                        <#--发表评论按钮-->
                            <div class="pl-input-btm input-btm clearfix">
                                <div class="captcha-verify-box js-verify-box hide"></div>
                                <input id="js-pl-submit"  class="r course-btn" value="发表评论"  onclick="dosave();" type="button"/>
                            </div>
                        </div>

                    </div>
                </div>
            <#-- 展示评论结果 fxb 3-5  -->
                <div id="plLoadListData">
                    <div class="pl-container" id = "comments-container">
                        <ul id = "comments-container">
                        <#list commentList as comment>
                            <li class="pl-list clearfix">
                                <div class="pl-list-avator">
                                    <a href="https://www.imooc.com/u/3936322/courses" target="_blank">
                                        <img src="${base}/admin/upload/${(comment.user.headimg)!}" title="${(comment.user.username)!}" width="40" height="40">
                                    </a>
                                </div>
                                <div class="pl-list-main">
                                    <div class="pl-list-nick">
                                        <a href="https://www.imooc.com/u/3936322/courses" target="_blank">${(comment.user.username)!}</a>
                                    </div>
                                    <div class="pl-list-content">${comment.content}</div>
                                    <div class="pl-list-btm clearfix">
                                        <span class="pl-list-time l">时间: ${comment.createDate?datetime}</span>
                                    </div>
                                </div>
                            </li>
                        </#list>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="qa" class="tab-pane fade">
                <#--<div id="pl-content" class="list-tab-con">-->
                    <#--<div class="publish clearfix" id="discus-publish">-->
                        <#--<div class="publish-wrap publish-wrap-pl">-->
                            <#--<div class="pl-input-wrap clearfix">-->
                                <#--<div class="pl-input-box clearfix">-->
                                    <#--<a href="" class="user-head l">-->
                                        <#--<img src="IDEA%E4%B8%8B%E8%BD%BD%EF%BC%8CIntelliJ%20IDEA%E7%A5%9E%E5%99%A8%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E6%95%99%E7%A8%8B-%E6%85%95%E8%AF%BE%E7%BD%911_files/avatar_default.png">-->
                                    <#--</a>-->
                                    <#--<div id="js-pl-input-fake" class="pl-input-inner l">-->
                                        <#--<textarea id="js-pl-textarea" class="js-placeholder" placeholder="扯淡、吐槽、表扬、鼓励……想说啥就说啥！"></textarea>-->
                                        <#--<span class="num-limit"><span id="js-pl-limit">0</span>/300</span>-->
                                    <#--</div>-->
                                <#--</div>-->
                                <#--<div class="pl-input-btm input-btm clearfix">-->
                                    <#--<div class="captcha-verify-box js-verify-box hide"></div>-->
                                    <#--<input id="js-pl-submit" class="r course-btn" value="发表评论" type="button">-->
                                <#--</div>-->
                            <#--</div>-->

                        <#--</div>-->
                    <#--</div>-->
                    <#--<div id="plLoadListData"><div class="pl-container"></div><div class="page pl-list-page"></div></div>-->
                <#--</div>-->

                <div id="qa-content" class="list-tab-con" style="">
                    <div id="qaLoadListData">
                        <div class="sortlist">
                            <div class="ordertab clearfix">
                                <a href="javascript:void(0)" hidefocus="true" data-order="1" class="quealltab onactive">全部</a>
                                <a href="javascript:void(0)" hidefocus="true" data-order="2" class="quealltab ">精华</a>
                            </div>
                        </div>
                        <#-- fxb 3-8 -->
                        <ul>
                            <#list qaList as qa>
                                <li>
                                    <div class="answertabcon">
                                        <div class="wenda-listcon clearfix">
                                            <div class="headslider l">
                                                <a href="https://www.imooc.com/u/2894744/courses" class="wenda-head" target="_blank" title="${qa.user.username}">
                                                    <img src="${base}/admin/upload/${qa.user.headimg}" alt="${qa.user.username}" width="40">
                                                    <i class="icon-ques-revert nofinish"></i>
                                                </a>
                                            </div>
                                            <div class="wendaslider">
                                                <h2 class="wendaquetitle">
                                                    <a href="https://www.imooc.com/u/2894744/courses" target="_blank" title="${qa.user.username}" class="wenda-nickname">${qa.user.username}
                                                    </a>
                                                    <div class="wendatitlecon">
                                                        <a href="${base}/qa/qaView?id=${qa.id}" target="_blank" class="wendatitle"> <b> ${qa.title}  </b>
                                                        </a>

                                                    </div>
                                                </h2>
                                                <div class="replycont clearfix">
                                                    <div class="fl replydes">
                                                        <#--<span class="replysign praise">[最新-->
                                                          <#--<a href="https://www.imooc.com/space/u/uid/3355992" target="_blank" title="星空dream" class="nickname">星空dream-->
                                                          <#--</a> 的回答]-->
                                                        <#--</span>-->
                                                        <#--<span class="replydet">看3.2节</span>-->
                                                    </div>
                                                </div>
                                                <div class="replymegfooter clearfix">
                                                    <div class="wenda-time l">
                                                        <em>${qa.createDate?string("yyyy年MM月dd日")}</em>
                                                    </div>
                                                    <a href="https://www.imooc.com/qadetail/250894" target="_blank" class="replynumber r hasanswernum">
                                                            <span class="ys">
                                                                <#assign key=qa.id?c />
                                                                  <#--<b class="numShow">${key}</b>-->
                                                                <b class="numShow">${hashMap1[key]!}</b>
                                                              <span class="number">回答</span>
                                                            </span>
                                                            <#--<span class="browsenum">-->
                                                              <#--<b class="numShow">33</b>-->
                                                              <#--<span class="number">浏览</span>-->
                                                            <#--</span>-->
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div
                                </li>

                            </#list>
                        </ul>
                        >
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
<!-- jQuery -->
<script src="${base}/front/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="${base}/front/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${base}/front/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="${base}/front/js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="${base}/front/js/jquery.stellar.min.js"></script>
<!-- Carousel -->
<script src="${base}/front/js/owl.carousel.min.js"></script>
<!-- Flexslider -->
<script src="${base}/front/js/jquery.flexslider-min.js"></script>
<!-- countTo -->
<script src="${base}/front/js/jquery.countTo.js"></script>
<!-- Magnific Popup -->
<script src="${base}/front/js/jquery.magnific-popup.min.js"></script>
<script src="${base}/front/js/magnific-popup-options.js"></script>
<!-- Count Down -->
<script src="${base}/front/js/simplyCountdown.js"></script>
<!-- Main -->
<script src="${base}/front/js/main.js"></script>
<script src="${base}/front/js/login.js"></script>
</body>
</html>