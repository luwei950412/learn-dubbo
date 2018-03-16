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
                    <img src="${base}/front/images/3.png" alt="">
                </div>
                <br><br>
                <form class="form-horizontial" role="form" method="post" >
                    <div class="form-group row" style="margin-top:5%;">
                        <label for="course" class="col-sm-6 " ><h4 class="martop">请填写邮箱</h4></label>
                        <!--   <div class="col-sm-6  martop padleft" >
                              <!-- <input type="text" placeholder="请输入课程名" class="form-control" id="course" name="name"
                              > -->
                        <!--     <div class="field_text wid" >
                                <input type="password" name="name" id="name" placeholder="新密码" >
                            </div>
                        </div> -->
                        <!-- <div class="col-sm-3 col-sm-pull-1"> -->
                        <!-- <label for="" ><h6>当前密码错误当前密码</h6></label> -->
                        <!-- </div> -->
                        <#--<c:forEach var="backuser"  items="${backuser}">-->
                            <#--<input type="hidden" id="email" value="${backuser.semail}" />-->
                            <#--<input type="hidden" id="sno" value="${backuser.sno}" />-->
                        <#--</c:forEach>-->
                        <input type="hidden" id="email" value="${backUser.email}" />
                        <input type="hidden" id="username" value="${backUser.username}" />
                    </div>

                    <div class="form-group martop row" >
                        <label for="course" class="col-sm-2 col-sm-offset-1 " ><h4 class="martop">邮箱号</h4></label>
                        <div class="col-sm-6  martop padleft" >
                            <!-- <input type="text" placeholder="请输入课程名" class="form-control" id="course" name="name"
                            > -->
                            <div class="field_text wid" >
                                <input class="form-control" type="email" name="semail" id="semail" placeholder="邮箱号" >
                            </div>
                        </div>
                        <div class="col-sm-3 col-sm-pull-1">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-offset-3">
                            <span class="btn marbot "><input type="button" onclick="checkemail()" value="下一步" style="width:200px;"/></span>

                        </div>
                    </div>
                    <script>
                        function checkemail()
                        {
//                 	alert("sdfsfs");
                            var inputemail=document.getElementById('semail');
                            var getemail=document.getElementById('email');
                            var getUsername=document.getElementById('username');
                            if(inputemail.value==getemail.value){
                                $.ajax({
                                    type: "GET",
                                    url: "/sendEmail?email="+getemail.value+"&username="+getUsername.value,
                                    success: function(msg){
                                        if(msg=="yes"){
                                            alert("发送邮件成功");
                                        }else{
                                            alert("发送邮件失败");
                                        }
                                    }
                                });
                            }
                            else{
                                alert("您输入的邮箱和该用户名绑定的邮箱不一致！请重新输入！！(^_^)");
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