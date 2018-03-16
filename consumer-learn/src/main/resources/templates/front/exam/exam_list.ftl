<#include "../base/header.ftl" />

<div class="exam_body">
    <div class="exam_main">
        <div class="exam_title">
            <div class="course_img">
                <img src="${base}/admin/upload/${(course.filePath)!}" class="course_img_show">
            </div>
            <div class="exam_title_span">
                <span>${(course.courseName)!}</span>
            </div>
            <div class="exam_teacher">
                讲师:<span class="exam_teacher_span">${(user.username)!}</span>
            </div>
            <div class="time_left">
                <span class="time_left_char">考试倒计时</span><span id="timeshow"></span>
            </div>
        </div>
        <div class="exam_content">
            <div class="exam_">

                <#--<form id="test_form" method="post" action="${base}/test/score_calculate">-->
                    <div class="test_title_span">试卷：<span>${(course.courseName)!}</span></div>
                    <div class="test_title_third">
                        <div class="test_title_third_1">一、选择题（共${(choiceQuestionLists?size)!}题，每题${(100/((choiceQuestionLists?size)+(tOrFQuestionLists?size)))?string('#.#')}分）</div>
                    </div>
                    <#list choiceQuestionLists as cq>
                    <div class="option_main">
                        <div class="content_span">${(cq_index+1)}、${(cq.content)!}：<br></div>
                        <div class="option"><input type="radio" name="${cq.id}c" value="A" />&nbsp&nbsp&nbspA.&nbsp${(cq.op1)!}</div>
                        <div class="option"><input type="radio" name="${cq.id}c" value="B" />&nbsp&nbsp&nbspB.&nbsp${(cq.op2)!}</div>
                        <div class="option"><input type="radio" name="${cq.id}c" value="C" />&nbsp&nbsp&nbspC.&nbsp${(cq.op3)!}</div>
                        <div class="option"><input type="radio" name="${cq.id}c" value="D" />&nbsp&nbsp&nbspD.&nbsp${(cq.op4)!}</div>
                    </div>
                    </#list>
                    <div class="test_title_third">
                        <div class="test_title_third_1">二、判断题（共${(tOrFQuestionLists?size)!}题，每题${(100/((choiceQuestionLists?size)+(tOrFQuestionLists?size)))?string('#.#')}分）</div>
                    </div>
                    <#list tOrFQuestionLists as tq>
                        <div class="option_main">
                            <div class="content_span">${(tq_index+1)}、${(tq.content)!}：</div>
                            <div class="option"><input type="radio" name="${tq.id}t" value="T" />&nbsp&nbsp&nbspA.&nbsp正确</div>
                            <div class="option"><input type="radio" name="${tq.id}t" value="F" />&nbsp&nbsp&nbspB.&nbsp错误</div>
                        </div>
                    </#list>
                    <div class="option_btn"><input  class="opbutton" value="提交"  onclick="dosubtest();" type="button">  </div>
                    <div class="option_main_1"></div>
                <#--</form>-->
            </div>
        </div>
    </div>
</div>

<script>
    var dv=document.getElementsByClassName('option_main');
    var ci=${(course.id)};
    window.onclick=function () {
        var vs = '';
        for (var i = 0; i < dv.length; i++) {
    //        console.log(dv[i]);
            var op = dv[i].getElementsByClassName('option');

                for (var j = 0; j < op.length; j++) {
    //                console.log(op[j])
                    var ra = op[j].getElementsByTagName('input');

                    for (var x = 0; x < ra.length; x++) {
    //                    console.log(ra[x]);
                        if (ra[x].checked) {
                            console.log(ra[x].value);
                            vs += ',' + ra[x].value;
                        }
                    }
                }
            }
            console.log(vs);
            document.cookie =ci+'vs=' + vs.substring(1);
            console.log(document.cookie);
    }
    var patt=eval("/(^| |;)"+ci+"vs=([^;]+)/");
    var m = patt.exec(document.cookie);
    console.log(m[2]);
    if (m) {//cookie中有值，初始化勾选状态
        var arr = m[2].split(',');
            for (var i = 0; i < dv.length; i++) {
                //        console.log(dv[i]);
                var op = dv[i].getElementsByClassName('option');

                for (var j = 0; j < op.length; j++) {
                    //                console.log(op[j])
                    var ra = op[j].getElementsByTagName('input');

                    for (var x = 0; x < ra.length; x++) {
                        //                    console.log(ra[x]);
                        if (ra[x].value == arr[i]) {
                            ra[x].checked=true;
                            break;
                        }
                    }
                }
            }
    }


</script>

<script>
    function dosubtest() {
        var radios = "";
        var radios1= "";
        var num = ${choiceQuestionLists?size?js_string};
        var courseId = ${(course.id)!};
        var userId = ${(userFront.id)!};
        var testId = ${(testPaper.id)!};
        var usertestId=${(userTest.id)!};


    <#list choiceQuestionLists as cq>
        var id_test = ${cq.id?js_string};
        var test= ${cq_index?js_string};
        answer = $("input[name='"+id_test+"c']:checked").val();
        if(answer == null){
            answer= 'Z';
        }
        radios = radios + answer +"/";
    </#list>
    <#list tOrFQuestionLists as tq>
        var id_test = ${tq.id?js_string};
        var test= ${tq_index?js_string};
        answer1 = $("input[name='"+id_test+"t']:checked").val();
        if(answer1 == null){
            answer1= 'N';
        }
        radios1 = radios1 + answer1 +"/";
    </#list>
        var choiceQuestionNum = radios.substr(0, radios.length - 1);
        var tOrFQuestionNum = radios1.substr(0,radios1.length -1);
        console.log(choiceQuestionNum+"+++++++"+tOrFQuestionNum);
        $.ajax({
            type:"POST",
            data: {"ChoiceQuestionNum":choiceQuestionNum,"tOrFQuestionNum":tOrFQuestionNum,"course.id":courseId,"user.id":userId,"testPaper.id":testId,"id":usertestId},
            url: "/test/score_calculate",
                success:function(data){
                alert(data);
                location.href="${base}/mycenter/score?id="+usertestId;
        }
    });

        <#--window.location.href="${base}/test/score_calculate";-->
    }
</script>

<#include "../base/footer.ftl" />


<script type="text/javascript">
    var time=new Date();
    var xiaoshi=time.getHours();
    var createdate=new Date(${(userTest.createDate?string('yyyy,MM,dd,HH,mm,ss'))!});
    createdate.setMonth(createdate.getMonth()-1);
    var diff=time.getTime()-createdate.getTime();
    var sec=diff/1000;
    var left=1800-sec;
    <#--var diff=time.getTime()- (${(userTest.createDate?datetime)!}).getTime();-->
    console.log(time);
    console.log(createdate);
    console.log(sec);
    time.setHours(0);
    time.setMinutes(0);
    time.setSeconds(left);
    var timeout;
    var timeshow=document.getElementById("timeshow");
    function countdown(){
        var hour=time.getHours();
        var min=time.getMinutes();
        var second=time.getSeconds();
        if(hour=="0"&&min=="0"&&second=="0"){
            alert("考试时间结束了,自动交卷");
            clearInterval(timeout);
            dosubtest();
            <#--window.location.href="${base}/test/score_calculate";-->
        }
        time.setSeconds(second-1);
        hour<10?hour="0"+hour:hour;
        min<10?min="0"+min:min;
        second<10?second="0"+second:second;
        timeshow.innerHTML=hour+":"+min+":"+second;
    }
    timeout= setInterval(countdown,1000);
</script>