<#include "../base/header.ftl" />

<div id="main">

    <div class="wrap ">
        <div class="top">
            <div class="course-content">
                <div class="course-nav-box">
                    <div class="course-nav-row clearfix">
                    <#-- 声明FreeMarker的全局变量 -->
                    <#--<#assign c1 =c>-->

                        <span class="hd l">方向：</span>
                        <div class="bd">
                            <ul class="">
                            <#if "${(direction_flag)!}" == "">
                                <li class="course-nav-item on">
                                    <a href="${base}/course/listCourse">全部</a>
                                </li>
                            <#else>
                                <li class="course-nav-item">
                                    <a href="${base}/course/listCourse">全部</a>
                                </li>
                            </#if>
                            <#list direction as di>

                                <#if dict?exists>
                                    <#list dict?keys as key>
                                        <#if (dict[key] == di)>

                                            <#if "${(direction_flag)!}" == "${(dict[key])!}" || "${(direction_flag)!}" == "${key}">
                                                <li class="course-nav-item on">
                                                <#--3-13 fxb-->
                                                <#--<#assign c1=key>-->
                                                    <a href="${base}/course/listCourse?c=${key}" data-ct="fe">${di}</a>
                                                </li>
                                            <#else>
                                                <li class="course-nav-item">
                                                <#--3-13 fxb-->
                                                <#--<#assign c1=key>-->
                                                    <a href="${base}/course/listCourse?c=${key}" data-ct="fe">${di}</a>
                                                </li>
                                            </#if>
                                        </#if>
                                    </#list>
                                </#if>

                            </#list>
                            </ul>
                        </div>
                    </div>
                    <div class="course-nav-row clearfix">
                        <span class="hd l">分类：</span>
                        <div class="bd">
                            <ul class="">
                            <#if "${(classes_flag)!}" == "">
                                <li class="course-nav-item on">
                                    <a href="${base}/course/listCourse">全部</a>
                                </li>
                            <#else>
                                <li class="course-nav-item">
                                    <a href="${base}/course/listCourse">全部</a>
                                </li>
                            </#if>
                            <#list classes as cl>
                                <#assign key="${cl}" />
                                <#if "${(classes_flag)!}" == "${(dict[key])!}">
                                    <li class="course-nav-item on">
                                    <#--&lt;#&ndash;3-13 fxb&ndash;&gt;-->
                                    <#--<#assign c1=dict[key]>-->
                                        <a href="${base}/course/listCourse?c=${(dict[key])!}" data-ct="fe">${cl}</a>

                                    </li>
                                <#else>

                                    <li class="course-nav-item">
                                    <#--&lt;#&ndash;3-13 fxb&ndash;&gt;-->
                                    <#--<#assign c1=dict[key]>-->
                                        <a href="${base}/course/listCourse?c=${(dict[key])!}" data-ct="fe">${cl}</a>


                                    </li>
                                </#if>
                            </#list>

                            </ul>
                        </div>
                    </div>
                    <#--<div class="course-nav-row clearfix border_bottom_none">-->
                        <#--<span class="hd l">类型：</span>-->
                        <#--<div class="bd">-->
                            <#--<ul class="">-->

                                <#--<li class="course-nav-item on">-->
                                    <#--<a href="https://www.imooc.com/course/list?">全部</a>-->
                                <#--</li>-->
                                <#--<li class="course-nav-item ">-->
                                    <#--<a href="https://www.imooc.com/course/list?type=1">基础</a>-->
                                <#--</li>-->
                                <#--<li class="course-nav-item ">-->
                                    <#--<a href="https://www.imooc.com/course/list?type=2">案例</a>-->
                                <#--</li>-->
                                <#--<li class="course-nav-item ">-->
                                    <#--<a href="https://www.imooc.com/course/list?type=3">框架</a>-->
                                <#--</li>-->
                                <#--<li class="course-nav-item ">-->
                                    <#--<a href="https://www.imooc.com/course/list?type=4">工具</a>-->
                                <#--</li>-->
                                <#--<li class="course-nav-item ">-->
                                    <#--<a href="https://www.imooc.com/course/list?type=6">设计模式</a>-->
                                <#--</li>-->
                            <#--</ul>-->
                        <#--</div>-->
                    <#--</div>-->
                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="course-tool-bar clearfix">
            <div class="tool-left l">
            <#if c??>
                <#if is_easy??>
                    <a href="${base}/course/listCourse?sort=last&c=${c!}&is_easy=${is_easy!}" class="sort-itemzui">最新</a>
                <#else >
                    <a href="${base}/course/listCourse?sort=last&c=${c!}" class="sort-itemzui">最新</a>
                </#if>
            <#else >
                <#if is_easy??>
                    <a href="${base}/course/listCourse?sort=last&is_easy=${is_easy!}" class="sort-itemzui">最新</a>
                <#else >
                    <a href="${base}/course/listCourse?sort=last" class="sort-itemzui">最新</a>
                </#if>
            </#if>
            <#if c??>
                <#if is_easy??>
                    <a href="${base}/course/listCourse?sort=pop&c=${c!}&is_easy=${is_easy!}" class="sort-itemhao">好评</a>
                <#else >
                    <a href="${base}/course/listCourse?sort=pop&c=${c!}" class="sort-itemhao">好评</a>
                </#if>
            <#else >
                <#if is_easy??>
                    <a href="${base}/course/listCourse?sort=pop&is_easy=${is_easy!}" class="sort-itemhao">好评</a>
                <#else >
                    <a href="${base}/course/listCourse?sort=pop" class="sort-itemhao">好评</a>
                </#if>

            </#if>
            </div>
            <div class="l">
                        <span class="tool-item" style="display: none;">
                            <a class="follow-learn tool-chk" href="javascript:void(0);">跟我学</a>
                        </span>
            </div>
            <div class="tool-right r">
                        <span class="tool-item">
                            <a href="https://www.imooc.com/course/list?unlearn=1" class="hide-learned tool-chk ">
                                    隐藏已参加课程
                            </a>
                        </span>

                <span class="tool-item total-num">
                            共<b>829</b>个课程
                        </span>

            </div>
            <div class="tool-iseasy r"><strong>难度：</strong>
            <#if c??>
                <a href="${base}/course/listCourse?c=${c}" class="sort-itemqua">全部</a>
            <#else >
                <a href="${base}/course/listCourse" class="sort-itemqua">全部</a>
            </#if>
            <#if c??>
                <#if sort??>
                    <a href="${base}/course/listCourse?sort=${sort}&c=${c!}&is_easy=1" class="sort-itemchu">初级</a>
                <#else >
                    <a href="${base}/course/listCourse?c=${c!}&is_easy=1" class="sort-itemchu">初级</a>
                </#if>
            <#else >
                <#if sort??>
                    <a href="${base}/course/listCourse?sort=${sort}&is_easy=1" class="sort-itemchu">初级</a>
                <#else >
                    <a href="${base}/course/listCourse?is_easy=1" class="sort-itemchu">初级</a>
                </#if>

            </#if>
            <#if c??>
                <#if sort??>
                    <a href="${base}/course/listCourse?sort=${sort}&c=${c!}&is_easy=2" class="sort-itemzho">中级</a>
                <#else >
                    <a href="${base}/course/listCourse?c=${c!}&is_easy=2" class="sort-itemzho">中级</a>
                </#if>
            <#else >
                <#if sort??>
                    <a href="${base}/course/listCourse?sort=${sort}&is_easy=2" class="sort-itemzho">中级</a>
                <#else >
                    <a href="${base}/course/listCourse?is_easy=2" class="sort-itemzho">中级</a>
                </#if>

            </#if>
            <#if c??>
                <#if sort??>
                    <a href="${base}/course/listCourse?sort=${sort}&c=${c!}&is_easy=3" class="sort-itemgao">高级</a>
                <#else >
                    <a href="${base}/course/listCourse?c=${c!}&is_easy=3" class="sort-itemgao">高级</a>
                </#if>
            <#else >
                <#if sort??>
                    <a href="${base}/course/listCourse?sort=${sort}&is_easy=3" class="sort-itemgao">高级</a>
                <#else >
                    <a href="${base}/course/listCourse?is_easy=3" class="sort-itemgao">高级</a>
                </#if>

            </#if>
            </div>
        </div>
        <div class="course-list">
            <div class="moco-course-list">
                <ul class="clearfix">

                <#list courseList as course>
                    <div class="course-card-container">
                        <a target="_blank" href="${base}/chapter/listChapter?id=${course.id}" class="course-card">

                            <div class="course-card-top">
                                <img class="course-banner lazy" data-original="//img4.mukewang.com/5a9371160001ecb106000338-240-135.jpg" src="${base}/admin/upload/${(course.filePath)!}" style="display: inline;">
                                <div class="course-label">
                                    <label>${course.type}</label>
                                </div>
                            </div>
                            <div class="course-card-content">
                                <h3 class="course-card-name">${course.courseName}</h3>
                                <div class="clearfix course-card-bottom">
                                    <div class="course-card-info">
                                        <span><#if "${course.level}"=="1">初级<#elseif "${course.level}"=="2">中级<#else>困难</#if></span><span><i class="icon-set_sns"></i>${course.score}</span>
                                    </div>
                                    <p class="course-card-desc">${course.introduction}</p>
                                </div>
                            </div>
                        </a>
                    </div>
                </#list>
                </ul>
            </div>
        </div>
    </div>
</div>

<script>
    function getRequest() {
        var url = window.location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for(var i = 0; i < strs.length; i ++) {

                theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);

            }
        }
        return theRequest;
    }
    var sort= getRequest().sort;
    var iseasy= getRequest().is_easy;
    if(sort == "last"){
        var x = document.getElementsByClassName("sort-itemzui");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].style.color = "red";
        }
    }
    if(sort == "pop"){
        var x = document.getElementsByClassName("sort-itemhao");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].style.color = "red";
        }
    }
    if(iseasy == "1"){
        var x = document.getElementsByClassName("sort-itemchu");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].style.color = "red";
        }
    }
    if(iseasy == "2"){
        var x = document.getElementsByClassName("sort-itemzho");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].style.color = "red";
        }
    }
    if(iseasy == "3"){
        var x = document.getElementsByClassName("sort-itemgao");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].style.color = "red";
        }
    }
    if(iseasy ==null){
        console.log("bababa")
        var x = document.getElementsByClassName("sort-itemqua");
        var i;
        for (i = 0; i < x.length; i++) {
            x[i].style.color = "red";
        }
    }

    console.log(sort);
    console.log(iseasy);
</script>

<#include "../base/footer.ftl">