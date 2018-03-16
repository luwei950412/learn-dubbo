<#include "../base/header.ftl" />
<link href="${base}/front/css/lecture.css" rel="stylesheet" type="text/css" />
<div id="main">

    <!-- top title -->
    <div class="top-box">
        <p>慕课精英名师推荐</p>
    </div>
    <!-- teacher list -->
    <div class="teacher-wrap">
        <div class="teacher-list-box clearfix js-teacher-list" style="width: 100%; height: 100%;margin-left: 80px">
            <#assign count = 0 />
            <#list lectureList as lecture>
            <div class="teacher-item l" style="height:400px;margin-left: 15px;">
                <a href="${base}/front/teacher?id=${lecture.id}" target="_blank" class="teacher-header-img" style="background-image:url(${base}/admin/upload/${lecture.headimg});"></a>
                <a href="${base}/front/teacher?id=${lecture.id}" target="_blank" class="teacher-nickname">${lecture.username}</a>
                <!-- tag -->
                <div class="tag-box clearfix">
                    <span class="tag-item l">${(lecture.city)!}</span>
                    <span class="tag-item l">${(lecture.position)!}</span>
                    <#--<span class="tag-item l">前端工具</span>-->
                    <#--<span class="tag-item l">Vue.js</span>-->
                </div>
                <div class="teacher-desc"><#if "${(lecture.introduction)!}"?length gt 30>${(lecture.introduction?substring(0,30))!}<#else>${(lecture.introduction)!}</#if></div>
                <a href="${base}/front/teacher?id=${lecture.id}" target="_blank" class="go-more">查看更多</a>
            </div>
            <#assign count=count +1 />
            </#list>
        </div>
        <div class="loading" style="display: none;">
            <div class="bounce1"></div>
            <div class="bounce2"></div>
            <div class="bounce3"></div>
        </div>
        <!-- <div class="page"><span class="disabled_page">首页</span><span class="disabled_page">上一页</span><a href="javascript:void(0)" class="active text-page-tag">1</a><a class="text-page-tag" href="https://www.imooc.com/lecturer/?page=2">2</a><a class="text-page-tag" href="https://www.imooc.com/lecturer/?page=3">3</a><a class="text-page-tag" href="https://www.imooc.com/lecturer/?page=4">4</a><a class="text-page-tag" href="https://www.imooc.com/lecturer/?page=5">5</a><a class="text-page-tag" href="https://www.imooc.com/lecturer/?page=6">6</a><a class="text-page-tag" href="https://www.imooc.com/lecturer/?page=7">7</a><a href="https://www.imooc.com/lecturer/?page=2">下一页</a><a href="https://www.imooc.com/lecturer/?page=7">尾页</a></div> -->
    </div>

</div>


<#include "../base/footer.ftl" />