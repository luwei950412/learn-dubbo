<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head> 
    <meta charset="utf-8"> </meta>
    <title>video play</title> 

</head>
<body>
<#--绝对路径-->
<video id="video1" width="320" height="240" controls="controls" src="/admin/video/movie.mp4">
    <!--<source src="movie.mp4"  type="video/mp4"/>-->
    <!--<source src="movie.ogg"  type="video/ogg"/>-->
    您的浏览器不支持 HTML5 video
</video>
<p>-------------------</p>
<button id="p1"></button>
<button id = "p2"></button>




<script type="text/javascript">
    video=document.getElementById("video1")
    var i = setInterval(function() {
        // 这里注意, 必须判断视频的 readyState。
        // 因为有可能没加载完，则获取到的视频时长信息是不正确的。
        if(video.readyState > 0) {
            // 计算,10进制，以及取模
            var minutes = parseInt(video.duration / 60, 10);
            var seconds = video.duration % 60;

            // (此处可以添加代码，将分钟，秒数显示到需要的地方)
            document.getElementById("p1").innerText="视频时长"+minutes+":"+parseInt(seconds);

            // 执行到这里，就将循环定时器清除。
            clearInterval(i);
        }
    }, 200);

    //获取实时进度
    getvideoprogress();
    function getvideoprogress() {
        setTimeout(function () {
            var vid = document.getElementById("video1");
            var currentTime = vid.currentTime.toFixed(1);
//            if (currentTime == 1.2) {
//                //触发
//                return false;
//            }
            document.getElementById("p2").innerText = currentTime;
            getvideoprogress();
        }, 50);
    }



</script>
<script type="text/javascript" >
    video=document.getElementById("video1")
    playBySeconds();
    function playBySeconds() {
        video.currentTime = 81
    }

    window.onbeforeunload = function(event) {
        event.returnValue = "test..";
        console.log(video.currentTime)

//        var params = {};
//        params.progress=video.currentTime
//        params.videoId = 22;
//        params.userId = 33;//注意params.名称  名称与实体bean中名称一致
//        params.createDate=null;
//        params.modifyDate=null;
        $.ajax({
            type: "POST",
            url: "/vp/addRecord",
            data:{progress:video.currentTime,videoId:22,userId:33},
//            dataType:"json",
            success:function(data){
                if(data == "success"){
                    alert( "ok" );
                }
            },
            complete: function() {
                 alert("hello");
            }
        });
        console.log(video.currentTime);

    };
</script>
<#include "../base/footer.ftl">