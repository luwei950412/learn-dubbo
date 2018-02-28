<!DOCTYPE html>
<html lang="en">
<#include "../base/header.ftl">
<!-- start: Content -->
<div id="content">
    <div class="panel box-shadow-none content-header">
        <div class="panel-body">
            <div class="col-md-12">
                <h3 class="animated fadeInLeft">讲师信息管理</h3>
                <p class="animated fadeInDown">
                    用户管理 <span class="fa-angle-right fa"></span> 讲师信息
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
                                <div class="col-sm-6">
                                    <div id="datatables-example_filter" class="dataTables_filter">
                                        <label>Search:<input class="form-control input-sm" placeholder=""
                                                             aria-controls="datatables-example" type="search"></label>
                                    </div>
                                </div>
                            <#--<div class="col-sm-3">-->
                            <#--<div id="datatables-example_filter" class="dataTables_filter">-->
                            <#--<button class=" btn ripple-infinite btn-3d btn-primary" value="primary" style="margin-top: -10px;">-->
                            <#--<span><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;添加用户</span>-->
                            <#--</button>-->
                            <#--</div>-->
                            <#--</div>-->
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
                                                aria-label="Name: activate to sort column ascending">Username
                                            </th>
                                            <th class="sorting_desc" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 205px;"
                                                aria-label="Position: activate to sort column ascending"
                                                aria-sort="descending">Email
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 125px;"
                                                aria-label="Office: activate to sort column ascending">用户状态
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 117px;"
                                                aria-label="Age: activate to sort column ascending">创建账户
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 117px;"
                                                aria-label="Start date: activate to sort column ascending">信息修改
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables-example"
                                                rowspan="1" colspan="1" style="width: 95px;"
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



                                        <#assign count=0>
                                        <#--<@lectureList count=100; lectureList>-->
                                        <#list lectureList as lecture>
                                            <#if "${lecture.userType}" != "1">
                                                <#assign count=count+1>
                                            <tr role="row" class="odd">
                                                <td class="">${lecture.username}</td>
                                                <td class="sorting_1">${lecture.email}</td>
                                                <td class="">
                                                    <#if lecture.userStatus ==0 ><i class="fa fa-check-square-o"
                                                                                    style="color: green">正常</i>
                                                        <#if "${userInfo.userType}"=="0">
                                                            <#if "${lecture.userType}"=="0">
                                                                <span title="您无权冻结管理员">[冻结锁定]</span>
                                                            <#else>
                                                                <a href="/user/view?id=${lecture.id}" title="操作冻结">[冻结锁定]</a>
                                                            </#if>
                                                        </#if>
                                                    <#elseif lecture.userStatus == 1><i class="fa fa-hourglass-half"
                                                                                        style="color:orange">待审核</i>
                                                        <#if "${userInfo.userType}"=="0">
                                                            <a href="/user/view?id=${lecture.id}"
                                                               title="操作通过审核">[审核操作]</a>
                                                        </#if>
                                                    <#elseif lecture.userStatus == 2>
                                                        <i class="fa fa-lock" style="color: red">锁定</i>
                                                        <#if "${userInfo.userType}"=="0">
                                                            <a href="/user/view?id=${lecture.id}"
                                                               title="操作解除冻结">[解除冻结]</a>
                                                        </#if>
                                                    <#else>
                                                        <i class="fa fa-times" style="color: grey">审核未通过</i>
                                                        <#if "${userInfo.userType}"=="0">
                                                            <a href="/user/view?id=${lecture.id}"
                                                               title="操作审核">[重新审核]</a>
                                                        </#if>
                                                    </#if>
                                                </td>
                                                <td><#if lecture.createDate??>
                                                    <span title="${lecture.createDate?string("yyyy-MM-dd HH:mm:ss")}">${lecture.createDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                                                <#else>
                                                    &nbsp;
                                                </#if>
                                                </td>
                                                <td><#if lecture.modifyDate??>
                                                    <span title="${lecture.modifyDate?string("yyyy-MM-dd HH:mm:ss")}">${lecture.modifyDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                                                <#else>
                                                    &nbsp;
                                                </#if></td>
                                                <td>
                                                    <#if "${userInfo.userType}"=="0">
                                                        <a href="/user/delete?id=${lecture.id}"
                                                           onclick="javascript:return p_del()" title="删除">[删除]</a>
                                                    </#if>

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
                                                <#--<a href="income!view.action?id=${income.id}" title="查看">[查看]</a>-->
                                                </td>
                                            </tr>
                                            </#if>
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