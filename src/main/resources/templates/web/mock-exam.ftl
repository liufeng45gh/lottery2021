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
    <script  type="text/javascript" src="/js/wx-share.js?version=1.0"></script>
    <script src="/web/js/common.js"></script>



</head>
<body>
<!-- Swiper -->
<link rel="stylesheet" href="/web/css/mock-exam.css"/>

<div class="page-bg-1" id="outer-div">
    <img class="img-bg-1" src="/web/img/page1/bg.jpg"/>



    <div class="title-1" >
        <a  class="wa-channel-back" href="/mobile/list"></a>
        <span id="time-count"></span>

    </div>

    <div class="middle-content">
        <div class="single-select" id="single-select"> </div>
        <div class="question" id="title"></div>
        <div class="answer-area" id="answer-area">

        </div>
        <div style="clear:both;"></div>
        <div class="confirm-select" onclick="confirmSelect();">确定选择</div>

        <div class="right-answer-outer-div">
            <div class="title-2">试题详解</div>
            <div class="title-3">
                <div class="right-answer-name">答案: </div>
                <div class="right-answer" id="right-answer"></div>
            </div>


            <div class="right-answer-description">
                <div id="right-answer-description"></div>

                <div style="margin-top:5rem">&nbsp;</div>
            </div>
        </div>
    </div>

    <!--
    <div class="answer answer1"><div class="option">A</div> <div class="option-text">民事责任</div> </div>

    <div class="answer answer2"><div class="option">B</div>  <div class="option-text">形式责任 </div></div>
    <div class="answer answer3"><div class="option">C</div> <div class="option-text"> 没有责任</div></div>

    <div class="answer answer4"><div class="option">C</div> <div class="option-text">再无责任</div></div>
    -->






    <div class="bottom-nav">
        <div class="submit-exam" onclick="submitExam()">交卷</div>
        <!--
        <div class="pre-question" onclick="preQuestion();">上一题</div>
        -->
        <div class="right-count">√ 65</div>
        <div class="wrong-count">× 28</div>

        <div class="total-count" id="total-count">65/398</div>
        <div class="next-question"  onclick="nextQuestion()">下一题</div>
    </div>
</div>


<!-- Initialize Swiper -->


</body>
<script src="/web/js/mock-exam.js"></script>
</html>
