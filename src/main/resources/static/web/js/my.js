$(".confirm").click(function(){
    //openUrl("/mobile/user-info");
    var telephone = $("#phone-input").val();
    if (telephone.trim()=="") {
        layer.msg("手机不能为空");
        return;
    }

    if(!(/^1[3|5|6|7|8|9][0-9]\d{4,8}$/.test(telephone))){
        layer.msg("手机号格式有误");
        return ;
    }

    var realName = $("#name-input").val();
    if (realName.trim()=="") {
        layer.msg("真实姓名不能为空");
        return;
    }

    var request_data = {};
    request_data.realName = realName;
    request_data.phone = telephone;

    $.ajax({
        type: "POST",
        url: "/member-info",
        data: request_data,
        dataType: "json",
        success: function (data) {
            if (data.ok) {
                layer.msg("提交成功",{icon: 6});
                setTimeout(function(){
                    window.parent.layer.closeAll();
                },2000)
            }else {
                layer.msg("系统错误",{icon: 5});
            }

        },
        error: function (message) {
            layer.msg("系统错误",{icon: 5});
        }
    });

});

