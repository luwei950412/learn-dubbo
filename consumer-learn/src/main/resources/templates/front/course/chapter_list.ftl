
<#include "../base/header.ftl" />
<div id="main">
    <div class="course-infos">
        <div class="w pr">
            <div class="path">
                <a href="/course/listCourse">课程</a>
                <i class="path-split">\</i>
                ${course.type}
                <i class="path-split">\</i>
                <a href="/learn/767"><span>${course.courseName}</span></a>

            </div>
            <div class="hd clearfix">
                <h2>${course.courseName}</h2>
            </div>

            <div class="statics clearfix">
                <div class="moco-btn l learn-btn moco-btn-green" style="width:115px;height:45px;background:red;border-radius:15%">
                    <a href="${base}/video/videoView" style="">继续学习</a>
                    <em></em>
                    <i class="follow-action js-follow-action"></i>
                </div>
                <div class="static-item l">
                    <span class="meta">上次学到</span>
                    <span class="meta-value smale-value" title="SpringBoot介绍"> 1-1 SpringBoot介绍</span>
                </div>
                <div class="static-item l">
                    <span class="meta">学习人数</span>
                    <span class="meta-value js-learn-num">66</span>
                    <em></em>            </div>
                <div class="static-item l">
                    <span class="meta">难度级别</span>
                    <span class="meta-value"><#if course.level == 1>初级<#elseif course.level ==2>中级<#else>困难</#if></span>
                    <em></em>
                </div>
                <div class="static-item l">
                    <span class="meta">课程时长</span>
                    <span class="meta-value"> ${course.duration}</span>
                    <em></em>
                </div>
                <div class="static-item l score-btn">
                    <span class="meta">综合评分</span>
                    <span class="meta-value">${course.score}</span>
                    <em></em>

                    <!-- <div class="score-rl-tips score-posi js-score-tip">
                        <span>发表评价即可 +</span><strong>1积分</strong>
                        <span class="rule-arrow"></span>
                    </div> -->
                    <div class="score-wrap icon-drop_up triangle">
                        <div class="score-box">
                            <a href="/coursescore/767" class="person-num">
                                <span class="person-num l">317人评价</span>
                            </a>
                            <a href="/coursescore/767?page=1" class="evaluation-btn r">去评价</a>
                            <div class="score-detail-box">
                                <div class="score-static-item">
                                    <span class="meta-value">9.8</span>
                                    <span class="meta">内容实用</span>
                                </div>
                                <div class="score-static-item">
                                    <span class="meta-value">9.7</span>
                                    <span class="meta">简洁易懂</span>
                                    <em></em>
                                </div>
                                <div class="score-static-item">
                                    <span class="meta-value">9.4</span>
                                    <span class="meta">逻辑清晰</span>
                                    <em></em>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="extra">
                <div class="share-action r bdsharebuttonbox">
                    <a href="javascript:;" class="share wx js-share icon-share-weichat" data-cmd="weixin"></a>
                    <a href="javascript:;" class="share qq js-share icon-share-qq" data-cmd="qzone"></a>
                    <a href="javascript:;" class="share sina js-share icon-share-weibo" data-cmd="tsina"></a>
                </div>
            </div>
        </div>
        <div class="info-bg" id="js-info-bg">
            <div class="cover-img-wrap">
                <img src="${base}/admin/upload/${course.filePath}" style="width:1800px;-webkit-filter: blur(10px);-moz-filter: blur(10px);-ms-filter: blur(10px);filter: blur(10px);"/>
            </div>
            <div class="cover-mask"></div>
        </div>

        <div class="progress">
            <ins data-progress="100" title="已完成100%，用时 7小时15分"></ins>
        </div>
    </div>


    <div class="course-info-main clearfix w">
        <div class="content-wrap">
            <div class="content">
                <div class="course-brief">
                    <p class="auto-wrap">简介：${course.introduction} </p>
                </div>
                <!-- 课程简介 end -->
                <div class="mod-tab-menu green-box">
                    <ul class="course-menu clearfix">
                        <li><a class="ui-tabs-active active" id="learnOn"  href="/learn/767"><span>章节</span></a></li>
                        <li><a id="commentOn" class="" href="/comment/767"><span>评论</span></a></li>
                        <li><a id="qaOn" class="" href="/qa/767/t/1?page=1"><span>问答</span></a></li>
                        <li><a id="noteOn" class="" href="/note/767?sort=last&page=1"><span>笔记</span></a></li>
                        <!--
                        <li><a id="wikiOn" class="" href="/wiki/767">WIKI</a></li>
                        -->
                    </ul>

                </div><!-- 课程面板 -->
                <!-- 课程章节 -->
                <div class="mod-chapters">
                    <#list chapterList as chapter>
                    <div class="chapter">
                        <!-- 章节标题 -->
                        <h3>
                            <#--<i class="icon-arrow-right-thick"></i>-->
                            <span class="icon-drop_down js-close"></span>
                            <strong>
                                <i class="icon-bookmark"></i>
                                ${chapter.chapterName}
                                <div class="icon-info chapter-info">
                                    <i class="icon-drop_up triangle">
                                        <div class="chapter-introubox">
                                            <div class="chapter-content">1-1 SpringBoot介绍和课程安排</div>
                                        </div>
                                    </i>
                                </div>
                            </strong>
                        </h3>
                        <ul class="video">
                            <#list videoList as video>
                                <#if video.chapterId == chapter.id>
                                    <li data-media-id="13589">
                                        <a href="${base}/video/videoView?id=${video.id}" class="J-media-item">
                                            <i class="icon-video3"></i>
                                        ${video.videoName} (05:50)<i style="color: green;"class="icon-check"></i>
                                        </a>
                                    </li>
                                </#if>
                            </#list>
                        </ul>
                    </div>
                    </#list>


                </div>
                <!-- 课程章节 end -->
            </div><!--content end-->


            <div class="aside r">
                <div class="bd">
                    <div class="box mb40 js-usercard-box">
                        <h4>讲师提示</h4>
                        <div class="teacher-info">
                            <a href="/u/4559066/courses?sort=publish" target="_blank" >
                                <img data-userid="4559066" class="js-usercard-dialog" src="${base}/admin/upload/${user.headimg}" width="80" height="80">
                            </a>
                            <span class="tit">
				                <a href="/u/4559066/courses?sort=publish" target="_blank">${user.username}</a><i class="icon-imooc"></i>
				            </span>
                            <span class="job">${user.position}</span>
                        </div>
                        <div class="course-info-tip">
                            <dl class="first">
                                <dt>课程须知</dt>
                                <dd class="autowrap">学习本门课程之前，您需要了解一些前置知识： 1、如何利用maven构建项目 2、Spring注解相关知识 3、MVC的思想的基本概念 4、RestfulApi相关知识</dd>
                            </dl>
                            <dl>
                                <dt>老师告诉你能学到什么？</dt>
                                <dd class="autowrap">1、创建第一个Spring Boot应用 2、Spirng Boot中自定义属性配置 3、Spring Boot中Controller的使用 4、Spirng Boot中使用spirng-data-jpa和事务操作</dd>
                            </dl>
                        </div>
                    </div>
                    <div class="js-recom-box">
                        <!-- 推荐课程 -->
                    </div>

                </div>
            </div>
        </div>
        <div class="clear"></div>

    </div>



    <!-- 视频介绍 -->
    <div id="js-video-wrap" class="video pop-video" style="display:none">
        <div class="video_box" id="js-video"></div>
        <a href="javascript:;" class="pop-close icon-close"></a>
    </div>

</div>

<#include "../base/footer.ftl">