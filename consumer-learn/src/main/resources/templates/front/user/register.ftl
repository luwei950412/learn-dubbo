<#include "../base/header.ftl">

<!-- Main Container  -->
<div class="main-container container" style="padding-bottom: 50px">
    <ul class="breadcrumb">
        <li><a href="#"><i class="fa fa-home"></i></a></li>
        <li><a href="#">账户</a></li>
        <li><a href="#">注册</a></li>
    </ul>

    <div class="row">
        <div id="content" class="col-sm-12">
            <h2 class="title">用户注册</h2>
            <p>
                如果您有我们的帐户，请登录 <a href="/user/frontLogin">登录</a>.
            </p>
            <form action="" id="registerWindowForm" method="post"
                  enctype="multipart/form-data"
                  class="form-horizontal account-register clearfix">
                <fieldset id="account">
                    <legend>你的个人信息</legend>
                <#--
                <div class="form-group required" style="display: none;">
                    <label class="col-sm-2 control-label">Customer Group</label>
                    <div class="col-sm-10">
                        <div class="radio">
                            <label> <input type="radio" name="customer_group_id"
                                value="1" checked="checked"> Default
                            </label>
                        </div>
                    </div>
                </div>
                -->
                    <div class="form-group required">
                        <label class="col-sm-2 control-label" for="input-firstname">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" name="username" value=""
                                   placeholder="输入您的用户名" id="username" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="input-telephone">职位</label>
                        <div class="col-sm-10">
                            <input type="tel" name="position" value=""
                                   placeholder="Position" id="position" class="form-control">
                        </div>
                    </div>
                    <div class="form-group required">
                        <label class="col-sm-2 control-label" for="input-telephone">E-mail</label>
                        <div class="col-sm-10">
                            <input type="tel" name="email" value=""
                                   placeholder="Email" id="email" class="form-control">
                        </div>
                    </div>
                </fieldset>
                <fieldset id="address">
                    <legend>你的地址</legend>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="input-address-1">城市</label>
                        <div class="col-sm-10">
                            <input type="text" name="city" value=""
                                   placeholder="城市" id="city" class="form-control">
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>你的密码</legend>
                    <div class="form-group required">
                        <label class="col-sm-2 control-label" for="input-password">密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="password" value=""
                                   placeholder="密码" id="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group required">
                        <label class="col-sm-2 control-label" for="input-confirm">确认密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="confirm" value="" placeholder="确认密码"
                                   id="confirm" class="form-control">
                        </div>
                    </div>
                </fieldset>

                <div class="buttons">
                    <div class="pull-right">
                        我已阅读并同意 <input class="box-checkbox" type="checkbox" name="agree"
                                       value="1"> &nbsp; <input type="button"
                                                                onclick="memberRegister()" value="注册" class="btn btn-primary">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- //Main Container -->

<#include "../base/footer.ftl">