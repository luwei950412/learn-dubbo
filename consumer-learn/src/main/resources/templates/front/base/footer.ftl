<footer id="fh5co-footer" role="contentinfo" style="background-image: url(images/img_bg_4.jpg); width: 100%;height: 400px;">
    <div class="overlay"></div>
    <div class="container">
        <div class="row row-pb-md">
            <div class="col-md-3 fh5co-widget">
                <h3>Project Manager</h3>
                <p>Lu Wei</p>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1 fh5co-widget">
                <h3>Product Owner</h3>
            <#--<ul class="fh5co-footer-links">-->
            <#--<li><a href="#">Course</a></li>-->
            <#--<li><a href="#">Blog</a></li>-->
            <#--<li><a href="#">Contact</a></li>-->
            <#--<li><a href="#">Terms</a></li>-->
            <#--<li><a href="#">Meetups</a></li>-->
            <#--</ul>-->
                <p>Chen Long</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1 fh5co-widget">
                <h3>Technical Director</h3>
            <#--<ul class="fh5co-footer-links">-->
            <#--<li><a href="#">Blog</a></li>-->
            <#--<li><a href="#">Privacy</a></li>-->
            <#--<li><a href="#">Testimonials</a></li>-->
            <#--<li><a href="#">Handbook</a></li>-->
            <#--<li><a href="#">Held Desk</a></li>-->
            <#--</ul>-->
                <p>Feng Xiaobin</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1 fh5co-widget">
                <h3>Software Engineer</h3>
            <#--<ul class="fh5co-footer-links">-->
            <#--<li><a href="#">Marketing</a></li>-->
            <#--<li><a href="#">Visual Assistant</a></li>-->
            <#--<li><a href="#">System Analysis</a></li>-->
            <#--<li><a href="#">Advertise</a></li>-->
            <#--</ul>-->
                <p>Xu Minghao</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1 fh5co-widget">
                <h3>Software Engineer</h3>
            <#--<ul class="fh5co-footer-links">-->
            <#--<li><a href="#">Find Designers</a></li>-->
            <#--<li><a href="#">Find Developers</a></li>-->
            <#--<li><a href="#">Teams</a></li>-->
            <#--<li><a href="#">Advertise</a></li>-->
            <#--<li><a href="#">API</a></li>-->
            <#--</ul>-->
                <p>Zhao Shanshan</p>
            </div>
        </div>

        <div class="row copyright">
            <div class="col-md-12 text-center">
                <p>
                    <small class="block">&copy; 2018 &nbsp;sixteen-group&nbsp;智能学习平台</small>
                </p>
            </div>
        </div>

    </div>
</footer>
</div>

<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
</div>


<!-- jQuery -->
<script src="${base}/front/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="${base}/front/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${base}/front/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="${base}/front/js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="${base}/front/js/jquery.stellar.min.js"></script>
<!-- Carousel -->
<script src="${base}/front/js/owl.carousel.min.js"></script>
<!-- Flexslider -->
<script src="${base}/front/js/jquery.flexslider-min.js"></script>
<!-- countTo -->
<script src="${base}/front/js/jquery.countTo.js"></script>
<!-- Magnific Popup -->
<script src="${base}/front/js/jquery.magnific-popup.min.js"></script>
<script src="${base}/front/js/magnific-popup-options.js"></script>
<!-- Count Down -->
<script src="${base}/front/js/simplyCountdown.js"></script>
<!-- Main -->
<script src="${base}/front/js/main.js"></script>
<script src="${base}/front/js/login.js"></script>
<script>
    var d = new Date(new Date().getTime() + 1000 * 120 * 120 * 2000);

    // default example
    simplyCountdown('.simply-countdown-one', {
        year: d.getFullYear(),
        month: d.getMonth() + 1,
        day: d.getDate()
    });

    //jQuery example
    $('#simply-countdown-losange').simplyCountdown({
        year: d.getFullYear(),
        month: d.getMonth() + 1,
        day: d.getDate(),
        enableUtc: false
    });
</script>
</body>
</html>

