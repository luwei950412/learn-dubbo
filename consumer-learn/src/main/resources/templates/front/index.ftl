
<#include "base/header.ftl">
<aside id="fh5co-hero">
    <div class="flexslider">
        <ul class="slides">
            <li style="background-image: url(images/img_bg_1.jpg);">
                <div class="overlay-gradient"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center slider-text">
                            <div class="slider-text-inner">
                                <h1>系统学习Docker，践行DevOps理念</h1>
                                <p><a class="btn btn-primary btn-lg" href="#">开始学习!</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            <li style="background-image: url(images/img_bg_2.jpg);">
                <div class="overlay-gradient"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center slider-text">
                            <div class="slider-text-inner">
                                <h1>学会TensorFlow,抢占人工智能前沿阵地</h1>
                                <p><a class="btn btn-primary btn-lg btn-learn" href="#">开始学习!</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            <li style="background-image: url(images/img_bg_3.jpg);">
                <div class="overlay-gradient"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center slider-text">
                            <div class="slider-text-inner">
                                <h1>学习人工智能，从这开始</h1>
                                <p><a class="btn btn-primary btn-lg btn-learn" href="#">开始学习!</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</aside>



<div id="fh5co-course-categories">
        <div class="container">
            <div class="row animate-box">
                <div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
                    <h2>热门推荐</h2>
                </div>
            </div>
            <div class="row">
            <#assign count1 = 0 />
            <#list courseList?sort_by("score")?reverse as course1>
                <div class="col-md-3 col-sm-6 text-center animate-box">
                <#assign count1 = count1 +1 />
                <#if count1 <= 8>
                    <div class="services">
                        <span class="icon">
                            <a href="${base}/chapter/listChapter?id=${course1.id}">
                                <img src="${base}/admin/upload/${course1.filePath}" style="width:260px; height:154px;">
                            </a>
                        </span>
                        <div class="desc">
                            <p><a href="${base}/chapter/listChapter?id=${course1.id}">${course1.courseName}</a></p>
                        </div>
                    </div>
                </#if>
                </div>
            </#list>
            </div>
        </div>
    </div>

    <div id="fh5co-counter" class="fh5co-counters" style="background-image: url(images/img_bg_4.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="row">
                        <div class="col-md-3 col-sm-6 text-center animate-box">
                            <span class="icon"><i class="icon-world"></i></span>
                            <#--数据还未获取-->
                            <span class="fh5co-counter js-counter" data-from="0" data-to="3297" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">已访问人数</span>
                        </div>
                        <div class="col-md-3 col-sm-6 text-center animate-box">
                            <span class="icon"><i class="icon-study"></i></span>
                            <span class="fh5co-counter js-counter" data-from="0" data-to="3700" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">已注册用户</span>
                        </div>
                        <div class="col-md-3 col-sm-6 text-center animate-box">
                            <span class="icon"><i class="icon-bulb"></i></span>
                            <span class="fh5co-counter js-counter" data-from="0" data-to="5034" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">已完成课程</span>
                        </div>
                        <div class="col-md-3 col-sm-6 text-center animate-box">
                            <span class="icon"><i class="icon-head"></i></span>
                            <span class="fh5co-counter js-counter" data-from="0" data-to="1080" data-speed="5000" data-refresh-interval="50"></span>
                            <span class="fh5co-counter-label">已认证讲师</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#--<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>-->

    <div id="fh5co-course">
        <div class="container">
            <div class="row animate-box">
                <div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
                    <h2>新上好课</h2>
                    <#--<p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>-->
                </div>
            </div>
            <div class="row">
                <#assign count = 0 />
                <#list courseList?sort_by("modifyDate")?reverse as course>
                <div class="col-md-6 animate-box">
                    <#assign count = count +1 />
                    <#if count <= 4>
                    <div class="course">
                        <a href="${base}/chapter/listChapter?id=${course.id}" class="course-img" style="background-image: url(${base}/admin/upload/${course.filePath});">
                        </a>
                        <div class="desc">
                            <h3>${course.courseName}</h3>
                            <#--<p>${course.introduction}</p>-->
                            <p></br></p>
                            <span><a href="${base}/chapter/listChapter?id=${course.id}" class="btn btn-primary btn-sm btn-course">开始学习</a></span>
                        </div>
                    </div>
                    </#if>
                </div>
                </#list>
            </div>
        </div>
    </div>

    <div id="fh5co-testimonial" style="background-image: url(images/school.jpg);">
        <div class="overlay"></div>
        <div class="container">
            <div class="row animate-box">
                <div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
                    <h2><span>精英名师</span></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="row animate-box">
                        <div class="owl-carousel owl-carousel-fullwidth">
                    <#assign count=0 />
                    <#list userList as user>
                        <#if user.userType?number == 2>
                            <#assign count = count + 1 />
                            <#if count <= 3>
                            <div class="item">
                                <div class="testimony-slide active text-center">
                                    <a href="${base}/front/teacher?id=${user.id}">
                                    <div class="user" style="background-image: url(${base}/admin/upload/${user.headimg});"></div>
                                    </a>
                                    <span>${user.username}<br><small>${(user.position)!}</small></span>
                                    <blockquote>
                                        <p>${(user.introduction)!}</p>
                                    </blockquote>
                                </div>
                            </div>
                            </#if>
                        </#if>
                        </#list>
                    </div>

                </div>
                </div>
            </div>
        </div>
    </div>

    <#--<div id="fh5co-blog">-->
        <#--<div class="container">-->
            <#--<div class="row animate-box">-->
                <#--<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">-->
                    <#--<h2>Blog &amp; Events</h2>-->
                    <#--<p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="row row-padded-mb">-->
                <#--<div class="col-md-4 animate-box">-->
                    <#--<div class="fh5co-event">-->
                        <#--<div class="date text-center"><span>15<br>Mar.</span></div>-->
                        <#--<h3><a href="#">USA, International Triathlon Event</a></h3>-->
                        <#--<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>-->
                        <#--<p><a href="#">Read More</a></p>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="col-md-4 animate-box">-->
                    <#--<div class="fh5co-event">-->
                        <#--<div class="date text-center"><span>15<br>Mar.</span></div>-->
                        <#--<h3><a href="#">USA, International Triathlon Event</a></h3>-->
                        <#--<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>-->
                        <#--<p><a href="#">Read More</a></p>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="col-md-4 animate-box">-->
                    <#--<div class="fh5co-event">-->
                        <#--<div class="date text-center"><span>15<br>Mar.</span></div>-->
                        <#--<h3><a href="#">New Device Develope by Microsoft</a></h3>-->
                        <#--<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>-->
                        <#--<p><a href="#">Read More</a></p>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="row">-->
                <#--<div class="col-lg-4 col-md-4">-->
                    <#--<div class="fh5co-blog animate-box">-->
                        <#--<a href="#" class="blog-img-holder" style="background-image: url(images/project-1.jpg);"></a>-->
                        <#--<div class="blog-text">-->
                            <#--<h3><a href="#">Healty Lifestyle &amp; Living</a></h3>-->
                            <#--<span class="posted_on">March. 15th</span>-->
                            <#--<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>-->
                            <#--<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="col-lg-4 col-md-4">-->
                    <#--<div class="fh5co-blog animate-box">-->
                        <#--<a href="#" class="blog-img-holder" style="background-image: url(images/project-2.jpg);"></a>-->
                        <#--<div class="blog-text">-->
                            <#--<h3><a href="#">Healty Lifestyle &amp; Living</a></h3>-->
                            <#--<span class="posted_on">March. 15th</span>-->
                            <#--<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>-->
                            <#--<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="col-lg-4 col-md-4">-->
                    <#--<div class="fh5co-blog animate-box">-->
                        <#--<a href="#" class="blog-img-holder" style="background-image: url(images/project-3.jpg);"></a>-->
                        <#--<div class="blog-text">-->
                            <#--<h3><a href="#">Healty Lifestyle &amp; Living</a></h3>-->
                            <#--<span class="posted_on">March. 15th</span>-->
                            <#--<span class="comment"><a href="">21<i class="icon-speech-bubble"></i></a></span>-->
                            <#--<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->

    <div id="fh5co-pricing" class="fh5co-bg-section">
        <div class="container">
            <div class="row animate-box">
                <div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
                    <h2>技术分享</h2>
                    <p></p>
                </div>
            </div>
            <div class="row">
                <div class="pricing pricing--rabten">
                    <div class="col-md-4 animate-box">
                        <div class="pricing__item">
                            <div class="wrap-price">
                                <!-- <div class="icon icon-user2"></div> -->
                                <h3 class="pricing__title"></h3>
                                <!-- <p class="pricing__sentence">Single user license</p> -->
                            </div>
                            <div class="pricing__price">
                        <span class="pricing__anim pricing__anim--1">
								<span class="pricing__currency"> </span>
                        </span>
                                <span class="pricing__anim pricing__anim--2">
								<span class="pricing__period"> </span>
                        </span>
                            </div>
                            <div class="wrap-price">
                                <ul class="pricing__feature-list">
                                    <li class="pricing__feature"> </li>
                                    <li class="pricing__feature"> </li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                </ul>
                                <button class="pricing__action">查看</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 animate-box">
                        <div class="pricing__item">
                            <div class="wrap-price">
                                <!-- <div class="icon icon-store"></div> -->
                                <h3 class="pricing__title"></h3>
                                <!-- <p class="pricing__sentence">Up to 5 users</p> -->
                            </div>
                            <div class="pricing__price">
                        <span class="pricing__anim pricing__anim--1">
								<span class="pricing__currency"></span>
                        </span>
                                <span class="pricing__anim pricing__anim--2">
								<span class="pricing__period"></span>
                        </span>
                            </div>
                            <div class="wrap-price">
                                <ul class="pricing__feature-list">
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                </ul>
                                <button class="pricing__action">查看</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 animate-box">
                        <div class="pricing__item">
                            <div class="wrap-price">
                                <!-- <div class="icon icon-home2"></div> -->
                                <h3 class="pricing__title"></h3>
                                <!-- <p class="pricing__sentence">Unlimited users</p> -->
                            </div>
                            <div class="pricing__price">
                        <span class="pricing__anim pricing__anim--1">
								<span class="pricing__currency"></span>
                        </span>
                                <span class="pricing__anim pricing__anim--2">
								<span class="pricing__period"></span>
                        </span>
                            </div>
                            <div class="wrap-price">
                                <ul class="pricing__feature-list">
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                    <li class="pricing__feature"></li>
                                </ul>
                                <button class="pricing__action">查看</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="fh5co-register" style="background-image: url(images/img_bg_2.jpg);">
        <div class="overlay"></div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2 animate-box">
                <div class="date-counter text-center">
                    <div class="simply-countdown simply-countdown-one"></div>
                    <p><strong></strong></p>
                    <p><a href="#" class="btn btn-primary btn-lg btn-reg">开始注册学习吧！</a></p>
                </div>
            </div>
        </div>
    </div>

    <div id="fh5co-gallery" class="fh5co-bg-section">
        <div class="row text-center">
            <h2><span>画廊展示</span></h2>
        </div>
        <div class="row">
            <div class="col-md-3 col-padded">
                <a href="#" class="gallery" style="background-image: url(images/project-5.jpg);"></a>
            </div>
            <div class="col-md-3 col-padded">
                <a href="#" class="gallery" style="background-image: url(images/project-2.jpg);"></a>
            </div>
            <div class="col-md-3 col-padded">
                <a href="#" class="gallery" style="background-image: url(images/project-3.jpg);"></a>
            </div>
            <div class="col-md-3 col-padded">
                <a href="#" class="gallery" style="background-image: url(images/project-4.jpg);"></a>
            </div>
        </div>
    </div>

<#include "base/footer.ftl">





