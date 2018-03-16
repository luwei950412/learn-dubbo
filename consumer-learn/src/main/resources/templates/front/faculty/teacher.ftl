
<#include "../base/header.ftl">

<#--<aside id="fh5co-hero">-->
    <#--<div class="flexslider">-->
        <#--<ul class="slides">-->
            <#--<li style="background-image: url(images/img_bg_4.jpg);">-->
                <#--<div class="overlay-gradient"></div>-->
                <#--<div class="container">-->
                    <#--<div class="row">-->
                        <#--<div class="col-md-8 col-md-offset-2 text-center slider-text">-->
                            <#--<div class="slider-text-inner">-->
                                <#--<div class="teacher-info">-->
                                    <#--<div class="teacher-info-image" style="background-image: url(${base}/admin/upload/${userList.headimg});">-->
                                    <#--</div>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</li>-->
        <#--</ul>-->
    <#--</div>-->
<#--</aside>-->


<div id="main">
    <div class="big-wrap">
        <div class="top-box">
            <div class="top-bg-mask">
                <div class="top-content-wrap">
                    <div class="clearfix">
                        <div class="share-box r">
                        </div>
                    </div>
                    <div class="teacher-box">
                        <div class="teacher-info">
                            <div class="teacher-info-image" style="background-image: url(${base}/admin/upload/${userList.headimg});"></div>
                        </div>
                        <p class="tea-nickname">${userList.username}</p>
                        <p class="tea-professional">${(userList.position)!}</p>
                        <a href="javascript:void(0);" class="moco-btn payattention-btn js-payattention-btn js-add-attention" data-id="5634820">
                            <i class="icon-group_add"></i>
                            关注Ta
                        </a>
                        <p class="tea-desc">
                            ${(userList.introduction)!}
                        </p>


                        <#--实战、手记、粉丝的数字需要从后台获取-->
                        <div class="tea-detail-box">
                            <ul class="clearfix">
                                <li>
                                    <a href="https://www.imooc.com/t/5634820#Shizhan">
                                        <p class="num">2</p>
                                        <p class="text">实战</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="https://www.imooc.com/t/5634820#Article">
                                        <p class="num">3</p>
                                        <p class="text">手记</p>
                                    </a>
                                </li>
                                <li>
                                    <p class="num" id="js-tea-fan-num">58</p>
                                    <p class="text">粉丝</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bottom-trangle"></div>
        </div>


        <div class="bottom-box">
            <div class="shizhan-box">
                <h2 id="Shizhan">实战</h2>
                <p class="cato-desc">上进唯实战可得，突破绝技成长瓶颈</p>
                <div class="shizhan-del-box">

                    <ul>
                    <#assign count = 0 />
                    <#list courseList?sort_by("score")?reverse as course>
                        <#assign count = count +1 />
                        <#if count <= 2>
                        <li style="background-image: url(${base}/admin/upload/${course.filePath}); ">
                            <div class="shizhan-mask">
                                <a href="${base}/chapter/listChapter?id=${course.id}" target="_blank">
                                    <p class="shizhan-title" align="center">${course.type}</p>
                                    <p class="shizhan-desc" align="center">${course.introduction}</p>
                                    <div class="bottom-box clearfix">
                                        <p class="shizhan-price l"></p>
                                        <p class="icon icon-right r"></p>
                                    </div>
                                </a>
                            </div>
                        </li>
                        </#if>
                    </#list>
                    </ul>
                </div>
            </div>
            <div class="article-box">
                <h2 id="Article">问答</h2>
                <p class="cato-desc">分享交流心得，学习前沿流行技术</p>
                <div class="article-del-box">
                    <ul>
                        <li>
                            <a href="https://www.imooc.com/article/23476" target="_blank">
                                <p class="article-title" title="在Docker的助攻下，2018年将是Kubernetes之年">在Docker的助攻下，2018年将是Kubernetes之年</p>
                                <p class="article-desc">(封面图：Dockercon17，Solomon Hykes FOUNDER, CTO AND CHIEF PRODUCT OFFICER of Docker) 2月底，我的&lt;系统学习Docker，CI/CD践行DevOps理念&gt;实战课程就要上线了，这个课程是对我从2014年接触和使用Docker/Kuberntes以来的总结和分享，想写一点东西来梳理下这几年容器生态圈发生的故事。（这里也安利下这个实战课程，这个课程内容丰富，包括Docker的基础讲解，镜像，容器，单机多机网络，docker-Compose，Docker swarm，Docker Cloud，Docker企业版，Kubernetes，容器监控，以及多</p>
                                <div class="bottom-box clearfix">
                                    <p class="item l">999浏览</p>
                                    <em class="l"></em>
                                    <p class="item l">6推荐</p>
                                    <em class="l"></em>
                                    <p class="item l">1评论</p>
                                    <p class="icon icon-right r"></p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.imooc.com/article/22547" target="_blank">
                                <p class="article-title" title="Python写CLI命令行程序">Python写CLI命令行程序</p>
                                <p class="article-desc">使用Python写命令行程序，以argparse是基础，但是有两个更好的工具可以选择，click和oslo.config click click可以用于简单的命令行程序，下面是我写的一个demo https://github.com/xiaopeng163/click-demo $ cd click-demo $ python setup.py install $ clickctl Usage: clickctl [OPTIONS] COMMAND [ARGS]... Click Demo Command Line Interface Options: -v, --verbose show debug message. --help Show this message and exit. Commands: init Initiali</p>
                                <div class="bottom-box clearfix">
                                    <p class="item l">1947浏览</p>
                                    <em class="l"></em>
                                    <p class="item l">3推荐</p>
                                    <em class="l"></em>
                                    <p class="item l">1评论</p>
                                    <p class="icon icon-right r"></p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.imooc.com/article/22545" target="_blank">
                                <p class="article-title" title="Python虚拟环境之virtualenvwrapper vs Pipenv">Python虚拟环境之virtualenvwrapper vs Pipenv</p>
                                <p class="article-desc">今年年初，Kenneth Reitz发布了Pipenv (https://www.kennethreitz.org/essays/announcing-pipenv), 目前已经是Python官方推荐的包管理工具(https://docs.pipenv.org/)。 个人之前一直都是用virtualenvwrapper (https://virtualenvwrapper.readthedocs.io/en/latest/), virtualenvwrapper基本保持了大家之前对pip，virtualenv和requirements.txt的使用习惯，但是强大和方便了许多。如果要迁移到pipenv，需要对已有项目的包管理方式做较大的改变，因为pipenv引入了新的机制。 virtualenvwra</p>
                                <div class="bottom-box clearfix">
                                    <p class="item l">2295浏览</p>
                                    <em class="l"></em>
                                    <p class="item l">4推荐</p>
                                    <em class="l"></em>
                                    <p class="item l">0评论</p>
                                    <p class="icon icon-right r"></p>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "../base/footer.ftl">