var swiper = null;



var intervalId = null;
var processCurrent = 0;
var increaseQuantity = 5;
function increaseProcess(){
    processCurrent = processCurrent + increaseQuantity;
    if (processCurrent>91) {
        processCurrent = 91;
    }
    resetIncreaseQuantity();
    showProcess(processCurrent);
}
function resetIncreaseQuantity(){
    if (processCurrent < 20) {
        increaseQuantity = 4;
    }else if (processCurrent < 40) {
        increaseQuantity = 3;
        createSwiper();
    }else if (processCurrent < 60) {
         increaseQuantity = 2;

    }else if (processCurrent < 80) {
          increaseQuantity = 1;
    }
}

function showProcess(process){
    $(".process-front").css("width",process +  "%");
}


var intervalId = null;
//页面 ready 完成开始显示进度条加载效果
$(document).ready(function(){
    intervalId = setInterval(increaseProcess,500);
});

function createSwiper(){
    if (swiper != null){
        return;
    }
    $(".swiper-slide").css("display","block");
    swiper = new Swiper('.swiper-container', {
      direction: 'vertical',
      noSwiping : true,
      autoHeight:true
    });
}

//页面 load 完成 显示 100% 并显示下一页
$(window).on("load",function(){
    if (processCurrent < 80 ){
        setTimeout(doLoadFinish,10000);
    }else {
        setTimeout(doLoadFinish,3000);
        //doLoadFinish();
    }
});

function doLoadFinish(){
    clearInterval(intervalId);
    processCurrent = 92;
    showProcess(processCurrent);
    setTimeout(toInitPage,1000);

}

function toInitPage(){
    swiper.slideTo(1);
    loadWishList();
//    var mp3 = "/music/happy.mp3";
//    var audio = new Audio(mp3);
//    audio.play();
}

$(document).ready(function(){
    //checkLogin();
    $("#start-btn").click(function(){
        //swiper.slideTo(1);
        //toPage(1);
    });


    $("#opportunity-text").click(function () {
        //openWin(1);
    });

    $("#my-text").click(function () {
        openMy();
    });
});

function toPage(index){
    $(".swiper-slide").css("display","none");
    $("#swiper-slide-" + index).css("display","block");
}



function openWin(id){
    var url = window.location.protocol + "//" + window.location.hostname + ":" + window.location.port + "/win?id=" + id
    layer.open({
      type: 2,
      shade: 0.3,
      skin: 'layer-test' ,
      title: false, //不显示标题
      area: ['89%', '60%'], //宽高
      //offset: ['50%', '50%'],
      closeBtn: 0,
      content: [url, 'yes'],//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
      cancel: function(){
        //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
      }
    });
}

function openMy(){
    var url = window.location.protocol + "//" + window.location.hostname + ":" + window.location.port + "/my"
    layer.open({
      type: 2,
      shade: false,
      title: false, //不显示标题
      area: ['100%', '100%'], //宽高
      //offset: ['50%', '50%'],
      closeBtn: 0,
      content: [url, 'yes'],//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
      cancel: function(){
        //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
      }
    });
}

function closeWinAndOpenMy(){
    layer.closeAll();
    openMy();
}

var isMusicOn = true;
$(function(){
    $(".music-switch").touchClick(function(){

        if (isMusicOn == true) {
             $(".music-switch").attr("src", "/web/img/music-off.jpg");
               $("#bg-music").get(0).pause();
               $(".music-switch").removeClass('play');
            isMusicOn = false;
        }else {
              $(".music-switch").attr("src", "/web/img/music-on.jpg");
                $("#bg-music").get(0).play();
                $(".music-switch").addClass('play');
               isMusicOn = true;
        }

    });
});


