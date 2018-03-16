<html>
<head>
    <link rel="stylesheet" type="text/css" href="${base}/mycenter/css/new.css" />
</head>
<body>
<div class="paper">
    <div class="test_title_span"><span>${(course.courseName)!}测试</span></div>
    <div class="test_title_first">
        <div class="test_title_first_1">考试科目：<span class="test_title_span2">${(course.courseName)!}</span></div>
        <div class="test_title_first_1">考试时间：<span class="test_title_span2">30分钟</span></div>
        <div class="test_title_first_1">成绩：<img class="test_title_span4"width="120px" height="85px" src="img/hooker1.png"><span class="test_title_span3">${(userTest.score)}</span></div>
    </div>
    <div class="test_title_second">
        <div class="test_title_second_1">出题老师：<span class="test_title_span2">${(user.username)!}</span></div>
        <div class="test_title_second_1">考试日期：<span class="test_title_span2">${(userTest.createDate?date)!}</span></div>
        <div class="test_title_second_1">考试者：<span class="test_title_span2">${(user1.username)!}</span></div>
    </div>
    <div class="test_title_third">
        <div class="test_title_third_1">一、选择题（共${(choiceQuestionLists?size)!}题，每题${(100/((choiceQuestionLists?size)+(tOrFQuestionLists?size)))?string('#.#')}分）</div>
    </div>
    <div class="test_title_forth">
        <#list "${(userTest.choiceQuestionNum)!}"?split("/") as cu>
        <#list choiceQuestionLists as cq>
            <#if cu_index == cq_index>
            <div class="option_main">
                <div class="content_span">${(cq_index+1)}、${(cq.content)!}：
                    <div class="content_span_1">
                        <#if cq.answer!=cu><div class="false">你选了(${(cu)!})&nbsp&nbsp&nbsp× 错误<br><br>正确答案:${(cq.answer)!}</div>
                        <#else><div class="true">你选了(${(cu)!})&nbsp&nbsp&nbsp√ 正确</div>
                        </#if>
                    </div>
                </div>
                <div class="option">&nbsp&nbsp&nbsp(A).&nbsp${(cq.op1)!}</div>
                <div class="option">&nbsp&nbsp&nbsp(B).&nbsp${(cq.op2)!}</div>
                <div class="option">&nbsp&nbsp&nbsp(C).&nbsp${(cq.op3)!}</div>
                <div class="option">&nbsp&nbsp&nbsp(D).&nbsp${(cq.op4)!}</div>
            </div>
            </#if>
        </#list>
        </#list>
    </div>
    <div class="test_title_third">
        <div class="test_title_third_1">二、判断题（共${(tOrFQuestionLists?size)!}题，每题${(100/((choiceQuestionLists?size)+(tOrFQuestionLists?size)))?string('#.#')}分）</div>
    </div>
    <div class="test_title_forth">
        <#list "${(userTest.tOrFQuestionNum)!}"?split("/") as tu>
        <#list tOrFQuestionLists as tq>
            <#if tu_index == tq_index>
            <div class="option_main">
                <#if tq.answer!=tu></#if>
                <div class="content_span">${(tq_index+1)}、${(tq.content)!}：
                    <div class="content_span_1">
                        <#if tq.answer!=tu><div class="false">你选了(${(tu)!})&nbsp&nbsp&nbsp× 错误<br><br>正确答案:${(tq.answer)!}</div>
                        <#else><div class="true">你选了(${(tu)!})&nbsp&nbsp&nbsp√ 正确</div>
                        </#if>
                    </div>
                </div>
                <#--答案:${(tq.answer)!}你的答案${tu}-->
                <div class="option">&nbsp&nbsp&nbsp(A).&nbsp正确</div>
                <div class="option">&nbsp&nbsp&nbsp(B).&nbsp错误</div>
            </div>
            </#if>
        </#list>
        </#list>
    </div>

</div>

</body>
</html>