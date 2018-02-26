<!DOCTYPE html>
<html lang="en">
<#include "../base/header.ftl">
<!-- start: Content -->
<div id="content">
    <div class="panel box-shadow-none content-header">
        <div class="panel-body">
            <div class="col-md-12">
                <h3 class="animated fadeInLeft">课程管理中心</h3>
                <p class="animated fadeInDown">
                    <a href="/course/listAdmin">课程管理</a> <span class="fa-angle-right fa"></span> 章节信息
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
                                <div class="col-sm-6">
                                    <div class="dataTables_length" id="datatables-example_length">
                                        <label>Show
                                            <select name="datatables-example_length" aria-controls="datatables-example"
                                                    class="form-control input-sm">
                                                <option value="10" selected="selected">10</option>
                                                <option value="25">25</option>
                                                <option value="50">50</option>
                                                <option value="100">100</option>
                                            </select> entries</label>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div id="datatables-example_filter" class="dataTables_filter">
                                        <label>Search:<input class="form-control input-sm" placeholder=""
                                                             aria-controls="datatables-example" type="search"></label>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div id="datatables-example_filter" class="dataTables_filter">
                                        <#if chapterList?size == chapterNum>
                                            <button onclick="alert('章节数已经满了')" class=" btn ripple-infinite btn-3d btn-primary" value="primary"
                                                    style="margin-top: -10px;">
                                                <span><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;添加课程章节</span>
                                            </button>
                                            <#else>
                                        <button data-toggle="modal" data-target="#myModal" class=" btn ripple-infinite btn-3d btn-primary" value="primary"
                                                style="margin-top: -10px;">
                                            <span><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;添加课程章节</span>
                                        </button>
                                            </#if>
                                        <#--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">-->
                                            <#--开始演示模态框-->
                                        <#--</button>-->
                                        <!-- 模态框（Modal） -->
                                        <div style="margin-top: 50px" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                            &times;
                                                        </button>
                                                        <h4 class="modal-title" id="myModalLabel">
                                                            添加章节信息
                                                        </h4>
                                                    </div>
                                                    <form action="/chapter/addChapter" method="post">
                                                    <div class="modal-body" style="height:100px;width:400px">
                                                        <label for="name" class="col-sm-2 control-label">名字</label>
                                                        <div class="col-sm-10">
                                                            <input type="hidden" name="courseId" value="${courseId}" />
                                                            <input type="text" style="width: 400px;" class="form-control" name="chapterName"
                                                                   placeholder="请输入章节名称">
                                                        </div>
                                                        <label for="name" class="col-sm-2 control-label">视频数目</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" style="width: 400px;" class="form-control" name="videoNum"
                                                                   placeholder="请输入视频数目">
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
                                                aria-label="Name: activate to sort column ascending">章节名称
                                            </th>
                                            <th class="sorting_desc" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 50px;"
                                                aria-label="Position: activate to sort column ascending"
                                                aria-sort="descending">视频节数
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 117px;"
                                                aria-label="Age: activate to sort column ascending">创建时间
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 117px;"
                                                aria-label="Age: activate to sort column ascending">修改时间
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 124px;"
                                                aria-label="Salary: activate to sort column ascending">操作
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#--<#assign count=0>-->
                                        <#--<@lecture_list count=100; lectureList>-->
                                        <#--<#list memberList?sort_by("duty") as member>-->
                                        <#--<#if "${count}"?number==0>-->
                                        <#--${member.username }-->
                                        <#--</#if>-->
                                        <#--<#assign count=count+1>-->
                                        <#--</#list>-->
                                        <#--</@lecture_list>-->

                                        <#assign count=0 />
                                        <#if (chapterList?size > 0)>
                                        <#--<@lectureList count=100; lectureList>-->
                                            <#list chapterList as chapter>
                                            <#assign count=count + 1 />
                                            <#--<#if "${lecture.userType}" != "1">-->
                                            <tr role="row" class="odd">
                                                <td class="">${chapter.chapterName}</td>
                                                <td class="sorting_1">${(chapter.videoNum)!}</td>
                                                <td><#if chapter.createDate??>
                                                    <span title="${chapter.createDate?string("yyyy-MM-dd HH:mm:ss")}">${chapter.createDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                                                <#else>
                                                    &nbsp;
                                                </#if>
                                                </td>
                                                <td><#if chapter.modifyDate??>
                                                    <span title="${chapter.modifyDate?string("yyyy-MM-dd HH:mm:ss")}">${chapter.modifyDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                                                <#else>
                                                    &nbsp;
                                                </#if>
                                                </td>
                                                <td>
                                                    <a href="/video/videoManage?id=${chapter.id}" title="视频管理">[视频管理]</a>
                                                    <a href="/chapter/deleteChapter?id=${chapter.id}" onclick="javascript:return p_del()" title="删除">[删除]</a>
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
                                                    <a href="" data-toggle="modal" data-target="#myModal_update${count}" title="修改章节信息">[修改]</a>
                                                <#--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">-->
                                                <#--开始演示模态框-->
                                                <#--</button>-->
                                                    <!-- 模态框（Modal） -->
                                                    <div style="margin-top: 50px" class="modal fade" id="myModal_update${count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                                        &times;
                                                                    </button>
                                                                    <h4 class="modal-title" id="myModalLabel">
                                                                        修改章节信息
                                                                    </h4>
                                                                </div>
                                                                <form action="/chapter/updateChapter" method="post">
                                                                    <div class="modal-body" style="height:100px;width:400px">
                                                                        <label for="name" class="col-sm-2 control-label">名字</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="hidden" name="id" value="${chapter.id}" />
                                                                            <input type="text" style="width: 400px;" class="form-control" name="chapterName"
                                                                                   value="${(chapter.chapterName)!}" placeholder="请输入章节名称">
                                                                        </div>
                                                                        <label for="name" class="col-sm-2 control-label">视频数目</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="text" style="width: 400px;" class="form-control" name="videoNum"
                                                                                  value="${(chapter.videoNum)!}" placeholder="请输入视频数目">
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
                                                <#--<a href="income!view.action?id=${income.id}" title="查看">[查看]</a>-->
                                                </td>
                                            </tr>
                                            <#--</#if>-->
                                            </#list>
                                        <#--</@lectureList>-->
                                        <#else>
                                        没有记录
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