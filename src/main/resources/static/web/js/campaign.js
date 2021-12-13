function openUrl(url){
    layer.open({
      type: 2,
      shade: true,
      title: false, //不显示标题
      area: ['100%', '100%'], //宽高
      offset: ['0px', '0px'],
      content: [url, 'yes'],//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
      cancel: function(){
        //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
      }
    });
}

function submitInvite(){
    var name = $("#name_input").val();
    if (isEmpty(name)) {
        layer.msg("姓名不能为空");
        return;
    }

    var phone = $("#phone_input").val();
    if (isEmpty(phone)) {
        layer.msg("电话不能为空");
        return;
    }

    var company = $("#company_input").val();
    if (isEmpty(company)) {
        layer.msg("公司不能为空");
        return;
    }

    var position = $("#position_input").val();
    if (isEmpty(position)) {
        layer.msg("职位不能为空");
        return;
    }

    var data_send = {};
    data_send.name = name;
    data_send.phone = phone;
    data_send.company = company;
    data_send.position = position;
    var url = "/invitation/save";
    var invite_request =$.ajax({
       type: 'post',
       url: url,
       data: data_send,
       dataType: 'json'
    });

    invite_request.fail(function( jqXHR, textStatus ) {
         //openWeiboLogin();
        layer.msg("操作异常");

    });

    invite_request.done(function(data) {
          layer.msg("提交成功");
          setTimeout(function(){
            var lineLink = window.location.href;
             if(lineLink.indexOf("?") != -1)
             {
                 lineLink = lineLink.split("?")[0];
                 console.log(lineLink);
             }
           window.location.href = lineLink+"?random=" + Math.random();
         },5);
    });
}

function submitPraise(){
    var data_send = {};
    var url = "/praise/save";
    var praise_request =$.ajax({
       type: 'post',
       url: url,
       data: data_send,
       dataType: 'json'
    });

    praise_request.fail(function( jqXHR, textStatus ) {
         //openWeiboLogin();
        layer.msg("操作异常");

    });

    praise_request.done(function(data) {
        praiseAnimation();
    });

}

function praiseAnimation(){
    $(".hart").css("top", "35.4rem");
    $(".hart").animate({top:'-5rem'},3000);
}

$(document).ready(function() {
    var data_send = {};
    var url = "/praise/get";
    var praise_request =$.ajax({
       type: 'get',
       url: url,
       data: data_send,
       dataType: 'json'
    });

    praise_request.fail(function( jqXHR, textStatus ) {
         //openWeiboLogin();
        layer.msg("操作异常");

    });

    praise_request.done(function(data) {
        $("#praise-msg").text("已有"+data.data+"人为昆仑能源开放日点赞");
    });

});