<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>答题系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="/swiper/dist/css/swiper.min.css"/>
    <link rel="stylesheet" href="/web/css/mobile.css?v=1.0"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <!-- Swiper JS -->
    <script src="/swiper/dist/js/swiper.min.js"></script>
    <script  type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script  type="text/javascript" src="/web/js/wx-share.js?version=1.0"></script>
    <script src="/web/js/common.js"></script>


</head>
<body>
<!-- Swiper -->
<link rel="stylesheet" href="/web/css/login.css"/>

<div class="page-bg-1">
    <img class="img-bg-1" src="/web/img/page1/bg.jpg"/>
    <img class="logo-1" src="/web/img/page1/logo.png"/>


    <div class="title-1" >
        昆仑能源答题系统
    </div>
    <div class="title-2">
        系统使用人数: ${totalMemberCount!}
    </div>

    <div class="title-3">
        <input placeholder="请输入手机号" class="name_input" id="telephone"/>
    </div>
    <div class="title-4">
        <input placeholder="密码是 gas" class="name_input" id="password"/>
    </div>


    <div class="btn-1" onclick="login();">
        登录
    </div>


    <!--
   <a class="btn-1" style="display: block; " href="/list">
       登录
   </a>

   -->



</div>


<!-- Initialize Swiper -->
<script src="/web/js/login.js"></script>

</body>
</html>
