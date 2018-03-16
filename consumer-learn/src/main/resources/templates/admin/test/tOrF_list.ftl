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
                    考试管理 <span class="fa-angle-right fa"></span> 判断题
                </p>
            </div>
        </div>
    </div>
    <div class="col-md-12 top-20 padding-0">
        <div class="col-md-12">
            <div class="panel">
            <#--<div class="panel-heading"><h3>Data Tables</h3></div>-->
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper"
                             class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="dataTables_length" id="datatables-example_length">
                                        <label>课程名称：&nbsp;&nbsp;&nbsp;&nbsp;
                                        <#if "${(courseId)!}"=="">所有课程
                                        <#else>
                                        ${(course.courseName)!}
                                        </#if>
                                    </div>
                                </div>
                                <div class="col-sm-5">
                                    <div id="datatables-example_filter" class="dataTables_filter">
                                        <select name="course.id" id="courseId">
                                        <#list courseList as course>
                                            <option value ="${course.id}">${course.id}${course.courseName}</option>
                                        </#list>
                                        </select>
                                        &nbsp;&nbsp;&nbsp;&nbsp;<i style="font-size: 20px;color: #0c66ae;cursor:pointer;" title="按课程号查找" onclick="choiceCourse()" class="fa fa-search"></i>
                                        <script>
                                            function choiceCourse(){
                                                var courseId = document.getElementById("courseId").value;
                                                window.location.href="/tOrF/listTOrF?courseId="+courseId;
                                            }
                                        </script>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div id="datatables-example_filter" class="dataTables_filter">
                                        <button data-toggle="modal" data-target="#myModal" class=" btn ripple-infinite btn-3d btn-primary" value="primary"
                                                style="margin-top: -10px;">
                                            <span><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;添加题库</span>
                                        </button>

                                        <!-- 模态框（Modal） -->
                                        <div style="margin-top: 50px" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                            &times;
                                                        </button>
                                                        <h4 class="modal-title" id="myModalLabel">
                                                            添加题库题目（判断题）
                                                        </h4>
                                                    </div>
                                                    <form action="${base}/tOrF/addTOrF?courseId=${(courseId)!}" method="post" enctype="multipart/form-data">
                                                        <div class="modal-body" style="height:450px;width:400px">
                                                            <label for="name" class="col-sm-3 control-label">选择课程</label>
                                                            <div class="col-sm-9">
                                                                <input type="hidden" name="user.id" value="${(userInfo.id)!}" />

                                                                <select name="course.id">
                                                                    <#list courseList as course>
                                                                        <option value ="${course.id}">${course.id}${course.courseName}</option>
                                                                    </#list>
                                                                </select>
                                                            </div>
                                                            <label for="name" class="col-sm-3 control-label">题目内容</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" style="width: 400px;" class="form-control" name="content"
                                                                       placeholder="请输入题目内容">
                                                            </div>
                                                            <label for="name" class="col-sm-3 control-label">题目答案</label>
                                                            <div class="col-sm-9">
                                                                <input type="text" style="width: 400px;" class="form-control" name="answer"
                                                                       placeholder="请输入题目答案">
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                            </button>
                                                            <input type="submit" value="提交" class="btn btn-primary" />
                                                        </div>
                                                    </form>
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <table id="datatables-example"
                                           class="table table-striped table-bordered dataTable no-footer" role="grid"
                                           aria-describedby="datatables-example_info" style="width: 100%;" width="100%"
                                           cellspacing="0">
                                        <thead>
                                        <tr role="row">
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 165px;"
                                                aria-label="Name: activate to sort column ascending">课程名称
                                            </th>
                                            <th class="sorting_desc" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 205px;"
                                                aria-label="Position: activate to sort column ascending"
                                                aria-sort="descending">发布人名称
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 125px;"
                                                aria-label="Office: activate to sort column ascending">题目内容
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 95px;"
                                                aria-label="Salary: activate to sort column ascending">操作
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <#assign count=0>
                                        <#--<@lectureList count=100; lectureList>-->
                                        <#list questionList as question>
                                                <#assign count=count+1>
                                            <tr role="row" class="odd">
                                                <td class="">
                                                    &nbsp;&nbsp;&nbsp;${(question.course.courseName)!}</td>
                                                <td class="sorting_1">${(question.user.username)!}</td>
                                                <td class="">
                                                    ${question.content}
                                                </td>
                                                <td>
                                                    <a href="${base}/tOrF/deleteTOrF?id=${question.id}"
                                                       onclick="javascript:return p_del()" title="删除">[删除]</a>
                                                    <a href="" data-toggle="modal" data-target="#myModal_update${count}" title="修改用户信息">[修改]</a>
                                                </td>
                                                <script language="javascript">
                                                    function p_del() {
                                                        var msg = "您真的确定要删除吗？\n\n请确认！";
                                                        if (confirm(msg) == true) {
                                                            return true;
                                                        } else {
                                                            return false;
                                                        }
                                                    }
                                                </script>

                                                <!-- 模态框（Modal） ---------修改信息-->
                                                <div style="margin-top: 50px" class="modal fade" id="myModal_update${count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                            &times;
                                                            </button>
                                                                <h4 class="modal-title" id="myModalLabel">
                                                                    修改判断题信息
                                                                </h4>
                                                            </div>
                                                            <form action="${base}/tOrF/addTOrF" method="post" enctype="multipart/form-data">
                                                                <div class="modal-body" style="height:550px;width:400px">

                                                                    <label for="name" class="col-sm-3 control-label">选择课程</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="hidden" name="id" value="${question.id}" />
                                                                        <input type="hidden" name="user.id" value="${question.user.id}" />
                                                                        <select name="course.id">
                                                                            <#list courseList as course>
                                                                                <option value ="${course.id}" <#if question.course.id == course.id>selected</#if>>${course.id}${course.courseName}</option>
                                                                            </#list>
                                                                        </select>
                                                                    </div>
                                                                    <label for="name" class="col-sm-3 control-label">题目内容</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" style="width: 400px;" class="form-control" name="content"
                                                                               value="${question.content}" placeholder="请输入题目内容">
                                                                    </div>
                                                                    <label for="name" class="col-sm-3 control-label">题目答案</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" style="width: 400px;" class="form-control" name="answer"
                                                                               value="${question.answer}" placeholder="请输入题目答案">
                                                                    </div>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <input type="button" value="关闭" class="col-sm-4 btn btn-default" data-dismiss="modal" />
                                                                    <input type="submit" value="提交" class="col-sm-4 btn btn-primary" />
                                                                </div>
                                                            </form>
                                                        </div><!-- /.modal-content -->
                                                    </div><!-- /.modal -->
                                                </div>
                                            </tr>
                                        </#list>
                                        <#--</@lectureList>-->


                                        <#if count == 0>
                                        <tr role="row" class="odd">
                                            <td class="" colspan="6">没有记录</td>
                                        </tr>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-5">
                                    <div class="dataTables_info" id="datatables-example_info" role="status"
                                         aria-live="polite">Showing 1 to 10 of 57 entries
                                    </div>
                                </div>
                                <div class="col-sm-7">
                                    <div class="dataTables_paginate paging_simple_numbers"
                                         id="datatables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous disabled"
                                                id="datatables-example_previous">
                                                <a href="#" aria-controls="datatables-example" data-dt-idx="0"
                                                   tabindex="0">Previous</a>
                                            </li>
                                            <li class="paginate_button active">
                                                <a href="#" aria-controls="datatables-example" data-dt-idx="1"
                                                   tabindex="0">1</a>
                                            </li>
                                            <li class="paginate_button "><a href="#" aria-controls="datatables-example"
                                                                            data-dt-idx="2" tabindex="0">2</a>
                                            </li>
                                            <li class="paginate_button "><a href="#" aria-controls="datatables-example"
                                                                            data-dt-idx="3" tabindex="0">3</a>
                                            </li>
                                            <li class="paginate_button "><a href="#" aria-controls="datatables-example"
                                                                            data-dt-idx="4" tabindex="0">4</a>
                                            </li>
                                            <li class="paginate_button "><a href="#" aria-controls="datatables-example"
                                                                            data-dt-idx="5" tabindex="0">5</a>
                                            </li>
                                            <li class="paginate_button "><a href="#" aria-controls="datatables-example"
                                                                            data-dt-idx="6" tabindex="0">6</a>
                                            </li>
                                            <li class="paginate_button next" id="datatables-example_next">
                                                <a href="#" aria-controls="datatables-example" data-dt-idx="7"
                                                   tabindex="0">Next</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end: content -->
<#include "../base/right_menu.ftl">