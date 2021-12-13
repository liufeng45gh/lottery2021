$(function(){
    var rightCount = getQueryString("rightCount");
    score = rightCount * 10 ;
    $(".title-1").text(score + " 分");
    $(".right-count").text("√ " + rightCount);
    var wrongCount = 10 - rightCount;
    $(".wrong-count").text("× " + wrongCount);
});

function getQueryString(name) {
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}