<#include "../base/header.ftl">
<link rel="stylesheet" href="${base}/front/css/test1.css" type="text/css">
<script type="text/javascript" src="${base}/kindeditor/themes/default/default.css"></script>
<script type="text/javascript" src="${base}/kindeditor/plugins/code/prettify.css"></script>
<script type="text/javascript" src="${base}/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="${base}/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="${base}/kindeditor//plugins/code/prettify.js"></script>

<script type="text/javascript">
    KindEditor.ready(function(K) {
        var editor1 = K.create('textarea[name="content"]', {
            cssPath : '${base}/kindeditor/plugins/code/prettify.css',
            <#--uploadJson : '${base}/kindeditor/jsp/upload_json.jsp',-->
            <#--fileManagerJson : '${base}/kindeditor/jsp/file_manager_json.jsp',-->
            allowFileManager : true,
            afterCreate : function() {
                var self = this;
                K.ctrl(document, 13, function() {
                    self.sync();
                    document.forms['example'].submit();
                });
                K.ctrl(self.edit.doc, 13, function() {
                    self.sync();
                    document.forms['example'].submit();
                });
            }
        });
        prettyPrint();
    });
</script>


<div id="main">
    <div class="container qa-container clearfix">
        <div class="qa-left l">
            <div class="qa-left-wrap">
                <div class="qa-header">
                    <div class="qa-header-right r">
                        <!-- credit -->

                        <a href="javascript:;" data-id="250894" data-type="5" data-uid="2894744" class="js-tip-off l tipoff" >举报</a>
                        <!-- share -->
                        <div class="small-share l">
                            <ul class="share-wrap">
                                <li>
                                    <span class="share-txt">分享</span>
                                </li>
                                <li class="weichat-posi">
                                    <div class="bdsharebuttonbox weichat-style bdshare-button-style0-16" data-tag="share_1">
                                        <a href="#" class="icon-cloud4" data-cmd="weixin" title="分享到云端"></a>
                                        <a href="#" class="icon-renren" data-cmd="qzone" title="分享到人人"></a>
                                        <a href="#" class="icon-sina-weibo" data-cmd="tsina" title="分享到新浪微博"></a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <em class="split l"></em>
                        <!-- follow -->
                        <a href="javascript:void(0)" data-id="250894" class="l wenda-add-collection js-collection-btn">
                            <i class="icon-heart4" style="color: red"></i>
                        </a>
                        <span class="care l">关注</span>
                    </div>
                    <a href="/u/2894744/bbs" target="_blank" class="qa-author"><img src='${base}/admin/upload/${(qa.user.headimg)!}' width='40' height='40' />${qa.user.username}</a>
                </div>
                <div class="qa-content" data-qid="250894">
                    <div class="qa-content-inner aimgPreview">
                        <div id="js-content-main">
                            <h1 class="js-qa-wenda-title qa-wenda-title">${(qa.title)!}</h1>
                            <div id="js-qa-content" class="qa-disscus rich-text"><p>${(qa.content)!}</p></div>
                        </div>
                    </div>

                    <div class="share-rl-tips cont-credit">
                        <span>快来回答问题，最佳答案可 +</span><strong>2积分</strong>
                        <a target="_blank" href="/about/faq?t=3" class="credit-rl">什么是积分？</a>
                    </div>

                    <div class="qa-content-addon clearfix">
                        <span class="qa-createtime l">${(qa.modifyDate?string("yyyy-MM-dd HH:mm:ss"))!}</span>
                        <a href="/video/16213" class="qa-course-from"> 源自：${qa.video.videoName}... ${qa.video.serialNumber}</a>
                        <span class="qa-view-num r">33 浏览</span>
                        <span class="qa-total-comment r">${qaReplyList?size} 回答</span>
                    </div>
                </div>

                <#assign count=0 />

                <#list qaReplyList as qaReply>
                <#assign  count = count +1 />
                <div class="qa-comments" data-title="">
                    <div class="qa-comment js-qa-comment" data-cid="403529" id="id_403529">
                        <div class="qa-comment-wrap clearfix ">
                            <div class="qa-comment-author">
                                <a href="/u/3355992/bbs" title="">
                                    <img src='${base}/admin/upload/${(qaReply.user.headimg)!}' width='40' height='40' />
                                    <span class="qa-comment-nick">${(qaReply.user.username)!}</span>
                                </a>
                            </div>
                            <div class="qa-comment-d ">
                                <!-- <div class="qa-triangle-left"><i></i></div> -->
                                <div class="qa-comment-inner">
                                    <div class="qa-comment-c aimgPreview">
                                        <div class="rich-text">
                                            <p>${(qaReply.content)!}</p>
                                        </div>
                                    </div>
                                    <div class="qa-comment-addon">
                                        <span class="qa-comment-time">${(qaReply.modifyDate?string("yyyy-MM-dd HH:mm:ss"))!}</span>
                                        <div class="qa-comment-addon-r">
                                            <a href="javascript:;" data-id="403529" data-type="6" data-uid="3355992" class="js-tip-off l tipoff" >举报</a>
                                            <span class="qa-total-reply js-reply-item-reply" >
                                                <i  class="icon-msg"></i>
                                                <span class="js-qa-tr-num" id="reply${count}">回复</span>
                                            </span>

                                            <span class="js-qa-comment-support qa-comment-support  js-qacom-supported-user" data-ids="250894-403529">
                                                <i class="icon-reply2"></i>
                                                <span>0</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-reply">
                            <div class="qa-reply-header"></div>
                            <div class="qa-replies">
                                <div class="qa-reply-c">
                                    <!--  <p class="qa-reply-loading">
                                        加载中...
                                    </p>  -->
                                    <!-- 默认显示三条回复的回复 -->
                                </div>

                                <!-- 回复框 -->
                                <div class="js-qa-reply-ibox qa-reply-ibox  clearfix" id="qa-reply-text${count}" style="display:none;">
                                    <div class="qa-reply-iavator l">
                                        <a href="/u/1328987/id" title="luwei13218016163">
                                            <img src='//img.mukewang.com/user/545846580001fede02200220-40-40.jpg' width='40' height='40' />
                                        </a>
                                    </div>
                                    <div class="qa-reply-iwrap">
                                        <div class="qa-reply-iarea">
                                            <textarea name="" id="" class="js-reply-ipt-default ipt"  placeholder="写下你的评论...">写下你的评论...</textarea>
                                        </div>
                                    </div>
                                    <div class="qa-reply-ifoot clearfix">
                                        <div class="qa-reply-footright r">
                                            <div class="captcha-verify-box js-reply-verify-box hide"></div>
                                            <span class="qa-tips"></span>
                                            <button class="btn-normal btn-mini js-ipt-cancel" id="cancel${count}">取消</button>
                                            <button class="btn-mini btn-green  js-ipt-submit">提交</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>


                </#list>





                <div id="js-qa-comment-input" class="qa-comment-input js-msg-context  clearfix">
                    <div class="qa-ci-avator l">

                        <a href="/u/1328987/bbs" title="luwei13218016163"><img src='//img.mukewang.com/user/545846580001fede02200220-40-40.jpg' width='40' height='40' /></a>
                    </div>
                    <div class="qa-ci-wrap">
                        <form action="/qaReply/addQaReply" method="post">
                        <div id="js-reply-editor-box" class="qa-comment-box js-ci-inner ">
                            <input type="hidden" name="user.id" value="${(userFront.id)!}" />
                            <input type="hidden" name="qa.id" value="${(qa.id)!}" />
                            <textarea id="content" name="content" cols="100" rows="16"></textarea>
                        </div>
                        <div id="js-qa-ci-footer" class="qa-ci-footer clearfix">
                            <div class="qa-ci-footright r">
                                <div class="captcha-verify-box js-verify-box hide"></div>
                                <span class="qa-tips"></span>
                                <#if "${(userFront.id)!}"=="">
                                    <input type="button" id="js-qa-ci-submit" onclick="javascript:alert('您还没有登录！请登录之后回复。')" class="btn btn-green " value="回答" />
                                <#else>
                                    <input type="submit" id="js-qa-ci-submit" class="btn btn-green " data-qid="250894" value="回答" />
                                </#if>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tipoff-block js-tipoff-block"></div>
            <#--<div class="tipoff-box js-tipoff-box">-->
                <#--<div class="tipoff-top-box clearfix">-->
                    <#--<p class="l tipoff-title">举报</p>-->
                    <#--<span class="r tipoff-close-btn icon-close2 js-tipoff-close"></span>-->
                <#--</div>-->
                <#--<div class="tipoff-type-box js-tipoff-typebox clearfix">-->
                    <#--<div class="tipoff-loading">-->
                        <#--<div class="bounce1"></div>-->
                        <#--<div class="bounce2"></div>-->
                        <#--<div class="bounce3"></div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="tipoff-content">-->
                    <#--<textarea name="tipoff-content" class="tipoff-desc js-tipoff-desc" placeholder="写下举报理由"></textarea>-->
                    <#--<div class="tipoff-text"><span class="js-tipoff-text">0</span>/150</div>-->
                <#--</div>-->
                <#--<div class="tipoff-btn-box clearfix">-->
                    <#--<div class="r tipoff-submit-btn js-tipoff-submit" data-tipofftype="">提交</div>-->
                    <#--<div class="r tipoff-cancel-btn js-tipoff-close">取消</div>-->
                <#--</div>-->
            <#--</div>-->




        </div>
        <div class="qa-right r">
            <div class="wenda-slider">
                <!-- pub new ques -->
                <div class="newques-container">
                    <a href="/wenda/save" class="newques-btn" id="js-newques" target="_blank"><!--<i class="icon-addques"></i>-->发新问题</a>
                </div>
                <!--user info-->
                <div class="wenda-my">
                    <div class="user-info">
                        <a class="user-img" href="/u/1328987/bbs">
                            <img src="${base}/admin/upload/${(qa.user.headimg)!}" alt=""/>
                        </a>
                        <p class="username">${(qa.user.username)!}</p>
                        <a href="/u/1328987/credit" target="_blank" class="credit-count">我的积分：0</a>
                    </div>
                </div>
                <div class="panel about-ques">
                    <div class="panel-heading">
                        <h2 class="panel-title">相关问题</h2>
                    </div>
                    <div class="panel-body clearfix">
                        <div class="mkhotlist padtop"><a href="/qadetail/251971" target="_blank">如何简单的表达一个num小于十位呢?</a></div>
                        <div class="mkhotlist "><a href="/qadetail/251928" target="_blank">为啥我这个数组输出最大值和总数不对</a></div>
                        <div class="mkhotlist "><a href="/qadetail/251908" target="_blank">刚开始用什么软件</a></div>
                        <div class="mkhotlist "><a href="/qadetail/251907" target="_blank">浮点型float和double有什么不同的吗？</a></div>
                        <div class="mkhotlist bordbottom"><a href="/qadetail/251885" target="_blank">求解释，不知道哪里错了</a></div>
                    </div>
                </div>

                <!-- reply rank -->
                <!-- course relations -->
            </div>
        </div>
    </div>

    <#--<div id="reply-box" style="display:none;">-->
        <#--<div class="js-qa-reply-ibox qa-reply-ibox clearfix aaa" >-->
            <#--<div class="qa-reply-iavator l">-->
                <#--<a href="/u/1328987/bbs" title="luwei13218016163">-->
                    <#--<img src='//img2.mukewang.com/user/545846580001fede02200220-40-40.jpg' width='40' height='40' />-->
                <#--</a>-->
            <#--</div>-->
            <#--<div class="qa-reply-iwrap">-->
                <#--<div class="qa-reply-iarea">-->
                    <#--<textarea maxlength="300" name="" id="" class="js-reply-ipt" readonly placeholder="写下你的评论..."></textarea>-->
                <#--</div>-->
                <#--<div class="qa-reply-ifoot clearfix">-->
                    <#--<div class="qa-reply-footright r">-->
                        <#--<div class="captcha-verify-box js-reply-verify-box hide"></div>-->
                        <#--<span class="qa-tips"></span>-->
                        <#--<button class="btn-mc-light js-ipt-cancel">取消</button>-->
                        <#--<button class="btn-mc btn-mini btn-mc-green disabled">提交</button>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->

</div>




<#include "../base/footer.ftl" />
<script>
    $(document).ready(function() {
        $(".js-reply-item-reply").on('click',function(e){
            var num = e.target.id;
            console.log(num);
//            var num = $(".js-qa-tr-num").attr("id");
            var last_num = num.charAt(num.length - 1);
            console.log(last_num);
//            $("#reply" + last_num).click(function () {
                $("#qa-reply-text" + last_num).css("display","block")
//            });
            $("#cancel"+last_num).click(function () {
                $("#qa-reply-text"+last_num).css("display","none")
            });
        })
        <#--var num = ${qaReplyList?size?js_string};-->
        <#--var temp1 = ${count?js_string};-->
<#--//        alert(temp1);-->
        <#--for(temp=1 ; temp <= temp1 ; temp++){-->
            <#--alert(temp);-->
            <#--$("#reply"+temp).click(function () {-->
                <#--$("#qa-reply-text"+temp).css("display","block")-->
            <#--});-->
            <#--$("#cancel"+temp).click(function () {-->
                <#--$("#qa-reply-text"+temp).css("display","none")-->
            <#--});-->
        <#--}-->
    })

</script>