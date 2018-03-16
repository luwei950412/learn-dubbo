<!DOCTYPE html>
<html lang="en">
<#include "../base/header.ftl">
<!-- start: Content -->
<div id="content">
    <div class="panel box-shadow-none content-header">
        <div class="panel-body">
            <div class="col-md-12">
                <h3 class="animated fadeInLeft">题库管理</h3>
                <p class="animated fadeInDown">
                    考试管理 <span class="fa-angle-right fa"></span> 试卷系统
                </p>
            </div>
        </div>
    </div>



<div class="col-md-12 top-20 padding-0">
    <div class="col-md-12">
        <div class="panel">
            <div class="">
                <form action="${base}/test/addTestPaper" method="post">
                    <input type="hidden" name="user.id" value="${(userInfo.id)!}">
                    <input type="hidden" id="userType" value="${(userInfo.userType)!}">
                    <div class="search_span">
                            <select id="courseId" name="course.id">
                            <#list courseList as course>
                                <option value ="${course.id}">${course.id}${course.courseName}</option>>
                            </#list>
                            </select>
                    </div>
                    <div class="value_show">
                        <div class="value_choice"><label>已经选择的选择题:</label><input id="choiceQuestionNum" type="text" name="choiceQuestionNum" /></div>
                        <div class="value_choice"><label>已经选择的判断题:</label><input id="tOrFQuestionNum" type="text" name="tOrFQuestionNum" /></div>
                        <input type="submit" onclick="javascript:return test_upload()" value="上传试卷"/>
                    </div>
                    <script>
                        function test_upload() {
                            var choiceQuestionNum = document.getElementById("choiceQuestionNum").value;
                            var tOrFQuestionNum = document.getElementById("tOrFQuestionNum").value;
                            var userType = document.getElementById("userType").value;
                            if(userType == 0){
                                alert("您是系统超级管理员，不能上传试卷");
                                return false;
                            }
                            if(choiceQuestionNum == ""){
                                alert("选择题不能为空");
                                return false;
                            }
                            if(tOrFQuestionNum == ""){
                                alert("判断题不能为空");
                                return false;
                            }
                            if (tOrFQuestionNum != "" && choiceQuestionNum != "") {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    </script>
                </form>
            </div>
            <div class="choose_main">
                <div class="choose_choice">
                    <label>选择题题库</label> &nbsp&nbsp           <input type ="button" onclick="addChoice()" value="提交选择" />
                    <br><br>
                    <ul id="ul1">
                        <#list choiceList as choice>
                            <li><p><input type="checkbox" name="choice" value="${choice.id}" /> ${choice.content}</p></li>
                        </#list>
                    </ul>

                </div>
                <div class="choose_torf">
                    <label>判断题题库</label> &nbsp&nbsp            <input type ="button" onclick="addTOrF()" value="提交判断" />
                    <br><br>
                    <ul>
                    <#list judgeList as judge>
                        <li><p><input type="checkbox" name="t_or_f" value="${judge.id}" /> ${judge.content}</p></li>
                    </#list>
                    </ul>

                </div>
            </div>
            <#--<div class="fill_block"></div>-->
        </div>
    </div>
</div>
        <script type="text/javascript">
            function addChoice(){
                    obj = document.getElementsByName("choice");
                    var choice_num = "";

                    for(k in obj){
                        if(obj[k].checked)
                            choice_num= choice_num+obj[k].value+"/";
                    }
                choice_num = choice_num.substring(0, choice_num.length - 1);

                document.getElementById("choiceQuestionNum").value=choice_num;

            }
            function addTOrF() {
                obj1 = document.getElementsByName("t_or_f");
    //            var tOrFQuestionNum = document.getElementById("tOrFQuestionNum").innerHTML;
                var t_or_f_num = "";
                for(j in obj1){
                    if(obj1[j].checked)
                        t_or_f_num= t_or_f_num+obj1[j].value+"/";
                }
                t_or_f_num = t_or_f_num.substring(0, t_or_f_num.length - 1);
                document.getElementById("tOrFQuestionNum").value = t_or_f_num;
            }
        </script>
        <div></div>
    </div>


<#include "../base/right_menu.ftl">