<#include "../base/header.ftl" />

<div id="main">

    <div class="wrap ">
        <div class="top">
            <div class="course-content">
                <div class="course-nav-box">
                    <div class="course-nav-row clearfix">
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
                                <#--<#list “This|is|split”?split(“|”) as s>-->
                                <#list direction as di>

                                    <#if dict?exists>
                                    <#list dict?keys as key>
                                    <#if (dict[key] == di)>

                                    <#if "${(direction_flag)!}" == "${(dict[key])!}" || "${(direction_flag)!}" == "${key}">
                                        <li class="course-nav-item on">
                                            <a href="${base}/course/listCourse?c=${key}" data-ct="fe">${di}</a>
                                        </li>
                                    <#else>
                                        <li class="course-nav-item">
                                            <a href="${base}/course/listCourse?c=${key}" data-ct="fe">${di}</a>
                                        </li>
                                    </#if>
                                    </#if>
                                    <#--${dict[key]}-->
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
                                    <#--<a href="${base}/course/listCourse?c=${dict[cl]}" data-ct="fe">${cl}</a>-->

                                        <a href="${base}/course/listCourse?c=${(dict[key])!}" data-ct="fe">${cl}</a>
                                    <#--3-2 fxb 1:00-->
                                    <#--<#if dict?exists>-->
                                    <#--<#list dict?keys as key>-->
                                    <#--<#if (dict[key] == cl)>-->
                                    <#--<a href="${base}/course/listCourse?c=${key}" data-ct="fe">${cl}</a>-->
                                    <#--</#if>-->
                                    <#--&lt;#&ndash;${dict[key]}&ndash;&gt;-->
                                    <#--</#list>-->
                                    <#--</#if>-->

                                    </li>
                                <#else>

                                <li class="course-nav-item">
                                    <#--<a href="${base}/course/listCourse?c=${dict[cl]}" data-ct="fe">${cl}</a>-->
                                    <a href="${base}/course/listCourse?c=${(dict[key])!}" data-ct="fe">${cl}</a>
                                    <#--3-2 fxb 1:00-->
                                    <#--<#if dict?exists>-->
                                        <#--<#list dict?keys as key>-->
                                            <#--<#if (dict[key] == cl)>-->
                                                <#--<a href="${base}/course/listCourse?c=${key}" data-ct="fe">${cl}</a>-->
                                            <#--</#if>-->
                                        <#--&lt;#&ndash;${dict[key]}&ndash;&gt;-->
                                        <#--</#list>-->
                                    <#--</#if>-->

                                </li>
                                </#if>
                                </#list>

                            </ul>
                        </div>
                    </div>
                    <div class="course-nav-row clearfix border_bottom_none">
                        <span class="hd l">类型：</span>
                        <div class="bd">
                            <ul class="">

                                <li class="course-nav-item on">
                                    <a href="https://www.imooc.com/course/list?">全部</a>
                                </li>
                                <li class="course-nav-item ">
                                    <a href="https://www.imooc.com/course/list?type=1">基础</a>
                                </li>
                                <li class="course-nav-item ">
                                    <a href="https://www.imooc.com/course/list?type=2">案例</a>
                                </li>
                                <li class="course-nav-item ">
                                    <a href="https://www.imooc.com/course/list?type=3">框架</a>
                                </li>
                                <li class="course-nav-item ">
                                    <a href="https://www.imooc.com/course/list?type=4">工具</a>
                                </li>
                                <li class="course-nav-item ">
                                    <a href="https://www.imooc.com/course/list?type=6">设计模式</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="course-tool-bar clearfix">
            <div class="tool-left l">
                <a href="https://www.imooc.com/course/list?sort=last" class="sort-item active">最新</a>
                <a href="https://www.imooc.com/course/list?sort=pop" class="sort-item">最热</a>
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
                <a href="https://www.imooc.com/course/list?" class="sort-item active">全部</a>
                <a href="https://www.imooc.com/course/list?is_easy=1" class="sort-item">初级</a>
                <a href="https://www.imooc.com/course/list?is_easy=2" class="sort-item">中级</a>
                <a href="https://www.imooc.com/course/list?is_easy=3" class="sort-item">高级</a>
            </div>
        </div>
        <div class="course-list">
            <div class="moco-course-list">
                <ul class="clearfix">

                    <#list courseList as course>
                    <div class="course-card-container">
                        <a target="_blank" href="https://www.imooc.com/learn/950" class="course-card">

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
                                        <span><#if "${course.level}"=="1">初级<#elseif "${course.level}"=="2">中级<#else>困难</#if></span><span><i class="icon-set_sns"></i>491</span>
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

<#include "../base/footer.ftl">