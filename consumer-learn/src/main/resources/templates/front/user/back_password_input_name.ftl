<#include "../base/header.ftl">

<!-- Main Container  -->
<div class="container container-wide" style="height:600px;">

    <!-- content -->
    <div class="content " role="main" style="margin-top:10%;">
        <!-- row -->
        <div class="row">
            <div class="col-sm-11 col-sm-offset-1" style="border:1px solid white;border-radius:15px;background:white;">
                <div class="col-sm-12"><h2>修改密码流程</h2></div>
                <div class="col-sm-4">
                    <img src="${base}/front/images/11.png" alt="">
                </div>
                <div class="col-sm-4">
                    <img src="${base}/front/images/2.png" alt="">
                </div>
                <div class="col-sm-4">
                    <img src="${base}/front/images/3.png" alt="">
                </div>
                <br><br>
                <form class="form-horizontial" role="form" method="post" action="/subUserName">
                    <div class="form-group row" style="margin-top:5%;">
                        <label for="course" class="col-sm-6 " ><h4 class="martop">请填写用户名</h4></label>
                    </div>
                    <div class="form-group martop row" >
                        <label for="course" class="col-sm-2 col-sm-offset-1 " ><h4 class="martop">用户名</h4></label>
                        <div class="col-sm-6  martop padleft" >
                            <!-- <input type="text" placeholder="请输入课程名" class="form-control" id="course" name="name"
                            > -->
                            <div class="field_text wid" >
                                <input type="text" class="form-control" name="userName" id="name" placeholder="请输入用户名" >
                            </div>
                        </div>
                        <div class="col-sm-3 col-sm-pull-1">
                            <!-- <label for=""><h6>当前密码错误</h6></label> -->
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-offset-3">
                            <span class="btn marbot "><input type="submit" value="下一步" style="width:200px;"/></span>

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>


</div>
<!-- //Main Container -->

<#include "../base/footer.ftl">