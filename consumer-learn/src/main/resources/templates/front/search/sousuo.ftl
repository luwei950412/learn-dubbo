<#include "../base/header.ftl">
<div id="main">

    <div class="search-main">
        <div class="search-header">
            <div class="search-form">
                <i class="icon-search sz-search"></i>
                <input type="text" class="search-form-ipt js-search-ipt" value="${text}" placeholder="请输入想搜索的内容">
                <button class="search-form-btn js-search-btn">搜索</button>
                <div class="search-history-area js-search-history" style="display: none;">
                </div>
            </div>

            <ul class="search-hot">
                <li class="fli">热搜关键词：</li>
                <li><a href="https://www.imooc.com/search/course?words=%E9%9D%A2%E8%AF%95&amp;type=sz" target="_blank">面试</a></li>
                <li><a href="https://www.imooc.com/search/course?words=%E6%AF%95%E8%AE%BE&amp;type=sz" target="_blank">毕设</a></li>
                <li><a href="https://www.imooc.com/search/course?words=%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91&amp;type=sz" target="_blank">微信开发</a></li>
                <li><a href="https://www.imooc.com/search/course?words=%E7%AE%97%E6%B3%95&amp;type=sz" target="_blank">算法</a></li>
                <li><a href="https://www.imooc.com/search/course?words=Spring%20Boot&amp;type=sz" target="_blank">Spring Boot</a></li>
                <li><a href="https://www.imooc.com/search/course?words=Go&amp;type=sz" target="_blank">Go</a></li>
                <li><a href="https://www.imooc.com/search/course?words=Java&amp;type=sz" target="_blank">Java</a></li>
                <li><a href="https://www.imooc.com/search/course?words=%E5%89%8D%E7%AB%AF&amp;type=sz" target="_blank">前端</a></li>
            </ul>
        </div>
        <div class="search-body">
            <div class="search-content">
                <div class="search-classify clearfix">
                    <ul class="search-classify-list clearfix">
                        <li><a href="javascript:;" data-page="course">课程</a></li>
                    </ul>

                    <span class="search-related">共找到 ${searchCourseList?size} 个相关内容</span>


                </div>

                <#list searchCourseList as course>
                    <div class="course-item">
                        <a href="https://www.imooc.com/view/85" target="_blank" class="course-detail-title">
                            <img src="${base}/admin/upload/${course.filePath}" target="_blank">
                        </a>


                        <div class="course-item-detail">
                            <a href="https://www.imooc.com/view/85" target="_blank" class="course-detail-title">
                            ${course.courseName}
                            </a>
                            <div class="course-item-classify">
                                <span>课程</span>
                                <#assign key=course_index >
                                <span>讲师：
									<a class="course-tname" target="_blank" href="https://www.imooc.com/u/112258">${userNameList[key]}</a>
								</span>
                                <span>
                                    等级：${course.level}
								</span>
                                <i class="course-study-number icon-set_sns"></i><span>${course.score}</span>
                            </div>
                            <p>${course.introduction}</p>

                        </div>
                    </div>
                </#list>



                <#--<a href="https://www.imooc.com/search/course?words=java" class="search-remind"><div>更多课程搜索结果</div></a>-->
            </div>
        </div>
    </div>
<#include "../base/footer.ftl">