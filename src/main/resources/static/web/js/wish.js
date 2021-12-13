
$(document).ready(function(){
    $("#p2-submit").click(function(){

        var wishText = $("#wish-input").val();
        if (wishText.trim()=="" ) {
            layer.msg("祝福不能为空");
            return;
        }


        var request_data = {};
        request_data.text = wishText;

        $.ajax({
            type: "POST",
            url: "/wish/commit",
            data: request_data,
            dataType: "json",
            success: function (data) {
                if (data.ok) {
                    layer.msg("提交成功",{icon: 6});
                    setTimeout(function(){
                        swiper.slideTo(2);
                         refreshResidue();
                    },2000)
                }else {
                    layer.msg("系统错误",{icon: 5});
                }

            },
            error: function (message) {
                layer.msg("系统错误",{icon: 5});
            }
        });

        //toPage(2);
    });
});

function loadWishList(){

    $.ajax({
        type: "GET",
        url: "/wish/list",
        dataType: "json",
        success: function (data) {
            $("#wish-list").empty();
            for (i = 0; i < data.length; i++) {
                var wish = data[i];
                $("#wish-list").append('<li >'+wish.nickName + ': ' + wish.text + '</li>');
             }
             $("#wish-list").slideUp();
        },
        error: function (message) {
            layer.msg("系统错误",{icon: 5});
        }
    });
}
