<!DOCTYPE html>
<html lang="en">
<#include "../base/header.ftl">
<!-- start: Content -->
<div id="content">
<#--<div class="panel box-shadow-none content-header">-->
<#--<div class="panel-body">-->
<#--<div class="col-md-12">-->
<#--<h3 class="animated fadeInLeft">讲师信息管理</h3>-->
<#--<p class="animated fadeInDown">-->
<#--用户管理 <span class="fa-angle-right fa"></span> 讲师信息-->
<#--</p>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
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

                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div id="datatables-example_filter" class="dataTables_filter">
                                        <label>Search:<input class="form-control input-sm" placeholder=""
                                                             aria-controls="datatables-example" type="search"></label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">

                                    <div class="panel">
                                        <div class="panel-body">
                                            <div class="col-md-12">
                                                <h3>用户信息列表<a href="JavaScript:history.go(-1)">返回上一步</a></h3>
                                                <dl>
                                                    <dt>用户名：</dt>
                                                    <dd>${userView.username}</dd>
                                                    <dt>email</dt>
                                                    <dd>${userView.username}</dd>
                                                    <dt>用户状态</dt>
                                                    <dd><#--  0:正常，1：待审核 2：冻结  3：审核不通过-->
                                                    <#if "${userView.userStatus}"=="0">正常
                                                        <a href="/user/editStatus?id=${userView.id}&status=2"
                                                           title="操作冻结">[冻结]</a>
                                                    <#elseif "${userView.userStatus}"=="1">待审核
                                                        <a href="/user/editStatus?id=${userView.id}&status=0"
                                                           title="操作审核">[审核通过]</a>
                                                        <a href="/user/editStatus?id=${userView.id}&status=3"
                                                           title="操作审核">[审核不通过]</a>
                                                    <#elseif userView.userStatus == 2>冻结锁定
                                                        <a href="/user/editStatus?id=${userView.id}&status=0"
                                                           title="操作解除冻结">[解除冻结]</a>
                                                    <#else>
                                                        <a href="/user/editStatus?id=${userView.id}&status=0"
                                                           title="操作审核">[审核通过]</a>
                                                    </#if>

                                                    ${userView.userStatus}</dd>
                                                    <dt>用户类别</dt>
                                                    <dd>${userView.userType}</dd>
                                                    <dt>城市</dt>
                                                    <dd><#if (userView.city??)>${userView.city}<#else>无</#if></dd>
                                                    <dt>个性签名</dt>
                                                    <dd><#if userView.introduction??>${userView.introduction}<#else>
                                                        无</#if></dd>
                                                    <dt>职位</dt>
                                                    <dd><#if userView.position??>${userView.position}<#else>无</#if></dd>
                                                    <dt>建户时间</dt>
                                                    <dd>${userView.createDate?string('yyyy-MM-dd HH:mm:ss')}</dd>
                                                    <dt>修改时间</dt>
                                                    <dd>${userView.modifyDate?string('yyyy-MM-dd HH:mm:ss')}</dd>
                                                </dl>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel">
                                        <div class="panel-body">

                                        <#if (userView?size > 0)>
                                            <blockquote>
                                                <p>用户名：</p>
                                                <footer>${userView.username} <cite title="Source Title">Source
                                                    Title</cite></footer>
                                            </blockquote>
                                            <blockquote>
                                                <p>email.</p>
                                                <footer><#if userView.email??>无<#else>${userView.email}</#if><cite
                                                        title="Source Title">Source Title</cite></footer>
                                            </blockquote>
                                            <blockquote>
                                                <p>用户状态.</p>
                                                <footer>${userView.userStatus} <cite title="Source Title">Source
                                                    Title</cite></footer>
                                            </blockquote>
                                            <blockquote>
                                                <p>用户类别.</p>
                                                <footer>${userView.userType}<cite title="Source Title">Source
                                                    Title</cite></footer>
                                            </blockquote>
                                        <#--<blockquote>-->
                                        <#--<p>城市：</p>-->
                                        <#--<footer><#if userView.city??>无<#else>${userView.city}</#if> <cite title="Source Title">Source Title</cite></footer>-->
                                        <#--</blockquote>-->
                                        <#--<blockquote>-->
                                        <#--<p>个性签名：</p>-->
                                        <#--<footer><#if userView.email??>无<#else>${userView.introduction}</#if> <cite title="Source Title">Source Title</cite></footer>-->
                                        <#--</blockquote>-->
                                        <#--<blockquote>-->
                                        <#--<p>职位：</p>-->
                                        <#--<footer><#if userView.email??>无<#else>${userView.position}</#if> <cite title="Source Title">Source Title</cite></footer>-->
                                        <#--</blockquote>-->
                                        <#--<blockquote>-->
                                        <#--<p>建户时间：</p>-->
                                        <#--<footer>${userView.createDate?string('yyyy-MM-dd HH:mm:ss')} <cite title="Source Title">Source Title</cite></footer>-->
                                        <#--</blockquote>-->
                                        <#--<blockquote>-->
                                        <#--<p>修改时间：</p>-->
                                        <#--<footer>${userView.modifyDate?string('yyyy-MM-dd HH:mm:ss')} <cite title="Source Title">Source Title</cite></footer>-->
                                        <#--</blockquote>-->

                                        <#else>
                                            没有记录
                                        </#if>
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
</div>
<!-- end: content -->
<#include "../base/right_menu.ftl">