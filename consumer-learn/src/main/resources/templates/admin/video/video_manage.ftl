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
                    <a href="/course/listAdmin">课程管理管理</a> <span class="fa-angle-right fa">
                    <a href="/chapter/chapterManage?id=${(courseId)!}">章节管理</a> <span class="fa-angle-right fa"></span> 视频信息
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
                                    <#if videoList?size == videoNum>
                                        <button onclick="alert('视频数已经满了')" class=" btn ripple-infinite btn-3d btn-primary" value="primary"
                                                style="margin-top: -10px;">
                                            <span><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;添加课程视频</span>
                                        </button>
                                    <#else>
                                        <button data-toggle="modal" data-target="#myModal" class=" btn ripple-infinite btn-3d btn-primary" value="primary"
                                                style="margin-top: -10px;">
                                            <span><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;添加课程视频</span>
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
                                                            添加视频信息
                                                        </h4>
                                                    </div>
                                                    <form action="/video/addVideo" method="post" enctype="multipart/form-data">
                                                        <div class="modal-body" style="height:170px;width:400px">
                                                            <label for="name" class="col-sm-2 control-label">编号</label>
                                                            <div class="col-sm-10">
                                                                <input type="hidden" name="courseId" value="${courseId}" />
                                                                <input type="hidden" name="chapterId" value="${chapterId}" />
                                                                <input type="text" style="width: 400px;" class="form-control" name="serialNumber"
                                                                       placeholder="请输入编号">
                                                            </div>
                                                            <label for="name" class="col-sm-2 control-label">视频名称</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" style="width: 400px;" class="form-control" name="videoName"
                                                                       placeholder="请输入名称">
                                                            </div>
                                                            <label for="name" class="col-sm-2 control-label">视频</label>
                                                            <div class="col-sm-10">
                                                                <input type="file" style="width: 400px;" class="form-control" name="filePath">
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
                                                aria-label="Name: activate to sort column ascending">序列编号
                                            </th>
                                            <th class="sorting_desc" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 50px;"
                                                aria-label="Position: activate to sort column ascending"
                                                aria-sort="descending">视频时长
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 165px;"
                                                aria-label="Name: activate to sort column ascending">视频名称
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

                                        <#assign count=0 />
                                        <#if (videoList?size > 0)>
                                        <#--<@lectureList count=100; lectureList>-->
                                            <#list videoList as video>
                                                <#assign count=count + 1 />
                                            <#--<#if "${lecture.userType}" != "1">-->
                                            <tr role="row" class="odd">
                                                <td class="">${video.serialNumber}</td>
                                                <td class="sorting_1">${video.videoDuration}</td>
                                                <td class="">${video.videoName}
                                                    <a href="" data-toggle="modal" data-target=".bs-example-modal-lg${count}">查看视频</a>
                                                    <!-- Large modal -->
                                                    <div class="modal fade bs-example-modal-lg${count}" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                                                        <div class="modal-dialog modal-lg" role="document">
                                                            <div class="modal-content">
                                                                <video src="/admin/upload/${video.filePath}" height="450" controls preload="metadata"></video>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <#--<video src="/admin/upload/${video.filePath}" controls="controls">-->
                                                        <#--您的浏览器不支持 video 标签。-->
                                                    <#--</video>-->
                                                </td>
                                                <td><#if video.createDate??>
                                                    <span title="${video.createDate?string("yyyy-MM-dd HH:mm:ss")}">${video.createDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                                                <#else>
                                                    &nbsp;
                                                </#if>
                                                </td>
                                                <td><#if video.modifyDate??>
                                                    <span title="${video.modifyDate?string("yyyy-MM-dd HH:mm:ss")}">${video.modifyDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                                                <#else>
                                                    &nbsp;
                                                </#if>
                                                </td>
                                                <td>
                                                    <a href="/video/deleteVideo?id=${video.id}" onclick="javascript:return p_del()" title="删除">[删除]</a>
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
                                                    <a href="" data-toggle="modal" data-target="#myModal_update${count}" title="修改视频信息">[修改]</a>
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
                                                                        修改视频信息
                                                                    </h4>
                                                                </div>
                                                                <form action="/video/updateVideo" method="post"  enctype="multipart/form-data">
                                                                    <div class="modal-body" style="height:170px;width:400px">
                                                                        <label for="name" class="col-sm-2 control-label">编号</label>
                                                                        <div class="col-sm-10">
                                                                            <#--<input type="hidden" name="courseId" value="${courseId}" />-->
                                                                            <#--<input type="hidden" name="chapterId" value="${chapterId}" />-->
                                                                            <input type="hidden" name="id" value="${(video.id)!}" />
                                                                            <input type="text" style="width: 400px;" class="form-control" name="serialNumber"
                                                                                  value="${(video.serialNumber)!}" placeholder="请输入编号">
                                                                        </div>
                                                                        <label for="name" class="col-sm-2 control-label">视频名称</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="text" style="width: 400px;" class="form-control" name="videoName"
                                                                                  value="${(video.videoName)!}" placeholder="请输入名称">
                                                                        </div>
                                                                        <label style="line-height: 34px;" for="name" class="col-sm-2 control-label">视频</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="file" style="font-size:15px;width: 400px;" class="form-control" name="filePath">
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