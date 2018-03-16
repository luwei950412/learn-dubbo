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
                    <img src="${base}/front/images/22.png" alt="">
                </div>
                <div class="col-sm-4">
                    <img src="${base}/front/images/33.png" alt="">
                </div>
                <br><br>
                <form class="form-horizontial" role="form" method="post" >
                    <div class="form-group row" style="margin-top:5%;">
                        <div class="form-group martop row" style>
                            <label for="course" class="col-sm-2 col-sm-offset-1 " ><h4 class="martop">输入密码</h4></label>
                            <div class="col-sm-6  martop padleft" >
                                <div class="field_text wid" >
                                    <input type="hidden" name="id" id="userId" value="${user.id}" />
                                    <input class="form-control" type="password" name="name" id="inputpassword" />
                                </div>
                            </div>
                            <div class="col-sm-3 col-sm-pull-1">
                            </div>
                        </div>

                        <div class="form-group martop row" >
                            <label for="course" class="col-sm-2 col-sm-offset-1 " ><h4 class="martop">再次输入</h4></label>
                            <div class="col-sm-6  martop padleft" >
                                <div class="field_text wid" >
                                    <input class="form-control" type="password" name="name" id="repassword" />
                                </div>
                            </div>
                            <div class="col-sm-3 col-sm-pull-1">
                                <!-- <label for=""><h6>当前密码错误</h6></label> -->
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-offset-3">
                                <span class="btn marbot "><input type="button" value="确认" onclick="resetpassword()" style="width:200px;"/></span>

                            </div>
                        </div>
                        <script>
                            function resetpassword(){
                                var id=document.getElementById('userId');
                                var inputpassword=document.getElementById('inputpassword');
                                var repassword=document.getElementById('repassword');
                                if(inputpassword.value==repassword.value){
                                    $.ajax({
                                        type: "GET",
                                        url: "/reSetPassword?id="+id.value+"&password="+inputpassword.value,
                                        success: function(msg){
                                            if(msg=="yes"){
                                                alert("重置密码成功，请重新登录！");
                                                window.location.href="/user/frontLogin";
                                            }
                                            else{
                                                alert("重置密码失败，请重试！");
                                            }
                                        }
                                    });
                                }
                                else{
                                    alert("您两次输入的密码不一致！请重新输入！！(^_^)");
                                }
                            }

                        </script>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- //Main Container -->

<#include "../base/footer.ftl">