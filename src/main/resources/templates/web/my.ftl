<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>中奖了</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="/web/css/mobile.css?v=1.0"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <!-- Swiper JS -->

    <script src="/web/js/common.js"></script>



</head>
<body >
<!-- Swiper -->
<link rel="stylesheet" href="/web/css/my.css"/>

<div class="page-bg">
    <img class="img-bg-1" src="/web/img/my/b5.png"/>

    <div class="text-1" >
        王者粉丝奖 100元加油卡: ${award_1!0}
    </div>
    <div class="text-2" >
        钻石粉丝奖 30元红包: ${award_2!0}
    </div>
    <div class="text-3" >
        白金粉丝奖 20元红包: ${award_3!0}
    </div>
    <div class="text-4" >
        黄金粉丝奖 10元红包: ${award_4!0}
    </div>
    <div class="text-5" >
        青铜粉丝奖 5元红包: ${award_5!0}
    </div>





    <div class="title-1" >
        手机号
    </div>

    <img class="phone-bg" src="/web/img/my/phone-bg.png"/>
    <input class="phone-input" id="phone-input" value="${member.phone!}"/>


    <div class="title-2" >
        真实姓名
    </div>

    <img class="name-bg" src="/web/img/my/phone-bg.png"/>
    <input  class="name-input" id="name-input" value="${member.realName!}"/>


    <img class="b5-3" src="/web/img/my/b5-3.png"/>

    <img class="confirm" src="/web/img/my/confirm.png"/>


</div>


<!-- Initialize Swiper -->


</body>
<script src="/web/js/my.js"></script>
</html>
