<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head> 
    <meta charset="utf-8"> </meta>
    <title>video play</title> 

</head>
<body>
<#--绝对路径-->
<div>
    <canvas id="canvasBarrage" class="canvas-barrage"></canvas>
    <video id="video1" width="640" height="384" controls="controls" src="/admin/video/movie.mp4">
        <!--<source src="movie.mp4"  type="video/mp4"/>-->
        <!--<source src="movie.ogg"  type="video/ogg"/>-->
        您的浏览器不支持 HTML5 video
    </video>
    <form id="barrageForm" action="barrage.php" method="post" autocomplete="off">
        <p>透明度(0-100)：<input type="range" class="range" name="opacity" value="100" min="0" max="100"> 文字大小(16-32)：<input type="range" class="range" name="fontSize" value="24" min="16" max="32"></p>
        <p>弹幕位置：<input type="radio" id="rangeFull" name="range" checked value="0,1"><label class="ui-radio" for="rangeFull"></label><label for="rangeFull">全部位置</label>
            <input type="radio" id="rangeTop" name="range" value="0,0.3"><label class="ui-radio" for="rangeTop"></label><label for="rangeTop">顶部</label>
            <input type="radio" id="rangeBottom" name="range" value="0.7,1"><label class="ui-radio" for="rangeBottom"></label><label for="rangeBottom">底部</label>
        </p>
        <p class="last">
            <input class="ui-input" id="input" name="value" required>
            <input type="submit" class="ui-button ui-button-primary" value="发送弹幕">
            颜色：
            <input type="color" id="color" name="color" value="#ff0000">
        </p>
    </form>
</div>

<p>-------------------</p>
<button id="p1"></button>
<button id = "p2"></button>

<#--<script src="admin/js/canvasBarrage.js"></script>-->
<script>
    var CanvasBarrage = function (canvas, video, options) {
        console.log("CanvasBarrage.....")
        if (!canvas || !video) {
            return;
        }
        var defaults = {
            opacity: 100,
            fontSize: 24,
            speed: 2,
            range: [0,1],
            color: 'white',
            data: []
        };

        options = options || {};

        var params = {};
        // 参数合并
        for (var key in defaults) {
            if (options[key]) {
                params[key] = options[key];
            } else {
                params[key] = defaults[key];
            }

            this[key] = params[key];
        }
        var top = this;
        var data = top.data;

        if (!data || !data.length) {
            return;
        }

        var context = canvas.getContext('2d');
        canvas.width = canvas.clientWidth;
        canvas.height = canvas.clientHeight;

        // 存储实例
        var store = {};

        // 暂停与否
        var isPause = true;
        // 播放时长
        var time = video.currentTime;

        // 字号大小
        var fontSize = 28;

        // 实例方法
        var Barrage = function (obj) {
            // 一些变量参数
            this.value = obj.value;
            this.time = obj.time;
            // data中的可以覆盖全局的设置
            this.init = function () {
                // 1. 速度
                var speed = top.speed;
                if (obj.hasOwnProperty('speed')) {
                    speed = obj.speed;
                }
                if (speed !== 0) {
                    // 随着字数不同，速度会有微调
                    speed = speed + obj.value.length / 100;
                }
                // 2. 字号大小
                var fontSize = obj.fontSize || top.fontSize;

                // 3. 文字颜色
                var color = obj.color || top.color;
                // 转换成rgb颜色
                color = (function () {
                    var div = document.createElement('div');
                    div.style.backgroundColor = color;
                    document.body.appendChild(div);
                    var c = window.getComputedStyle(div).backgroundColor;
                    document.body.removeChild(div);
                    return c;
                })();

                // 4. range范围
                var range = obj.range || top.range;
                // 5. 透明度
                var opacity = obj.opacity || top.opacity;
                opacity = opacity / 100;

                // 计算出内容长度
                var span = document.createElement('span');
                span.style.position = 'absolute';
                span.style.whiteSpace = 'nowrap';
                span.style.font = 'bold ' + fontSize + 'px "microsoft yahei", sans-serif';
                span.innerText = obj.value;
                span.textContent = obj.value;
                document.body.appendChild(span);
                // 求得文字内容宽度
                this.width = span.clientWidth;
                // 移除dom元素
                document.body.removeChild(span);

                // 初始水平位置和垂直位置
                this.x = canvas.width;
                if (speed == 0) {
                    this.x	= (this.x - this.width) / 2;
                }
                this.actualX = canvas.width;
                this.y = range[0] * canvas.height + (range[1] - range[0]) * canvas.height * Math.random();
                if (this.y < fontSize) {
                    this.y = fontSize;
                } else if (this.y > canvas.height - fontSize) {
                    this.y = canvas.height - fontSize;
                }

                this.moveX = speed;
                this.opacity = opacity;
                this.color = color;
                this.range = range;
                this.fontSize = fontSize;
            };

            this.draw = function () {
                // 根据此时x位置绘制文本
                context.shadowColor = 'rgba(0,0,0,'+ this.opacity +')';
                context.shadowBlur = 2;
                context.font = this.fontSize + 'px "microsoft yahei", sans-serif';
                if (/rgb\(/.test(this.color)) {
                    context.fillStyle = 'rgba('+ this.color.split('(')[1].split(')')[0] +','+ this.opacity +')';
                } else {
                    context.fillStyle = this.color;
                }
                // 填色
                context.fillText(this.value, this.x, this.y);
            };
        };

        data.forEach(function (obj, index) {
            store[index] = new Barrage(obj);
        });

        // 绘制弹幕文本
        var draw = function () {
            for (var index in store) {
                var barrage = store[index];

                if (barrage && !barrage.disabled && time >= barrage.time) {
                    if (!barrage.inited) {
                        barrage.init();
                        barrage.inited = true;
                    }
                    barrage.x -= barrage.moveX;
                    if (barrage.moveX == 0) {
                        // 不动的弹幕
                        barrage.actualX -= top.speed;
                    } else {
                        barrage.actualX = barrage.x;
                    }
                    // 移出屏幕
                    if (barrage.actualX < -1 * barrage.width) {
                        // 下面这行给speed为0的弹幕
                        barrage.x = barrage.actualX;
                        // 该弹幕不运动
                        barrage.disabled = true;
                    }
                    // 根据新位置绘制圆圈圈
                    barrage.draw();
                }
            }
        };

        // 画布渲染
        var render = function () {
            // 更新已经播放时间
            time = video.currentTime;
            // 清除画布
            context.clearRect(0, 0, canvas.width, canvas.height);

            // 绘制画布
            draw();

            // 继续渲染
            if (isPause == false) {
                requestAnimationFrame(render);
            }
        };

        // 视频处理
        video.addEventListener('play', function () {
            isPause = false;
            render();
        });
        video.addEventListener('pause', function () {
            isPause = true;
        });
        video.addEventListener('seeked', function () {
            // 跳转播放需要清屏
            top.reset();
        });


        // 添加数据的方法
        this.add = function (obj) {
            store[Object.keys(store).length] = new Barrage(obj);
        };

        // 重置
        this.reset = function () {
            time = video.currentTime;
            // 画布清除
            context.clearRect(0, 0, canvas.width, canvas.height);

            for (var index in store) {
                var barrage = store[index];
                if (barrage) {
                    // 状态变化
                    barrage.disabled = false;
                    // 根据时间判断哪些可以走起
                    if (time < barrage.time) {
                        // 视频时间小于播放时间
                        // barrage.disabled = true;
                        barrage.inited = null;
                    } else {
                        // 视频时间大于播放时间
                        barrage.disabled = true;
                    }
                }
            }
        };
    };

    // 调试弹幕数据
    var dataBarrage = [{
        value: 'speed设为0为非滚动',
        time: 1, // 单位秒
        speed: 0
    }, {
        value: 'time控制弹幕时间，单位秒',
        color: 'blue',
        time: 2
    }, {
        value: '视频共21秒',
        time: 3.2
    }, {
        value: '视频背景为白色',
        time: 4.5
    }, {
        value: '视频为录制',
        time: 5.0
    }, {
        value: '视频内容简单',
        time: 6.3
    }, {
        value: '是为了让视频尺寸不至于过大',
        time: 7.8
    }, {
        value: '省流量',
        time: 8.5
    }, {
        value: '支持弹幕暂停（视频暂停）',
        time: 9
    }, {
        value: 'add()方法新增弹幕',
        time: 11
    }, {
        value: 'reset()方法重置弹幕',
        time: 11
    }, {
        value: '颜色，字号，透明度可全局设置',
        time: 13
    }, {
        value: '具体交互细节可参考页面源代码',
        time: 14
    }, {
        value: '内容不错哦！',
        time: 18,
        color: 'yellow'
    }];

    // 初始化弹幕方法
//    获取canvas对象
    var eleCanvas = document.getElementById('canvasBarrage');
//    获取video对象
    var eleVideo = document.getElementById('video1');

    var demoBarrage = new CanvasBarrage(eleCanvas, eleVideo, {
        data: dataBarrage
    });
//设置弹幕透明度100
    demoBarrage.opacity=100

    // 下面是交互处理，与弹幕方法本身无关，旨在演示如何修改全局设置，新增弹幕等
    // 1. 全局的弹幕大小，位置和透明度处理
    document.addEventListener("DOMContentLoaded", function() {
        $('.range').on('change', function () {
            // 改变弹幕的透明度和字号大小
            demoBarrage[this.name] = this.value * 1;
        });

        $('input[name="range"]').on('click', function () {
            // 改变弹幕在视频显示的区域范围
            demoBarrage['range'] = this.value.split(',');
        });

        // 发送弹幕
        var elForm = $('#barrageForm'), elInput = $('#input');
        elForm.submit(function (event) {
            event.preventDefault();
            // 新增弹幕
            demoBarrage.add({
                value: $('#input').val(),
                color: $('#color').val(),
                time: eleVideo.currentTime
            });
//        elForm.on('submit', function (event) {
//            event.preventDefault();
//            // 新增弹幕
//            demoBarrage.add({
//                value: $('#input').val(),
//                color: $('#color').val(),
//                time: eleVideo.currentTime
//            });
//
//            elInput.val('').trigger('input');
//        });
        // 提交按钮
        var elSubmit = elForm.find('input[type="submit"]');

//        // 输入框和禁用按钮
//        elInput.on('input', function () {
//            if (this.value.trim()) {
//                elSubmit.removeAttr('disabled');
//            } else {
//                elSubmit.attr('disabled', 'disabled');
//            }
//        });

    }, false);
</script>

<script src="https://qidian.gtimg.com/c/=/lulu/theme/peak/js/plugin/jquery.js,/lulu/theme/peak/js/common/ui/Follow.js,/lulu/theme/peak/js/common/ui/Tips.js,/lulu/theme/peak/js/common/ui/Range.js,/lulu/theme/peak/js/common/ui/Drop.js,/lulu/theme/peak/js/common/ui/Color.js"></script>
<script>
    $('.range').range();
    $('#color').color();
</script>


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