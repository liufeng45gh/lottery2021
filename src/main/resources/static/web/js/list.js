$(".title-1").click(function(){
    //openUrl("/mobile/user-info");
    window.location.href = "/mobile/user-info";
});

$(".title-2").click(function(){
    //openUrl("/mobile/user-info");
    window.location.href = "/mobile/user-info";
});

function openUrl(url){
    layer.open({
      type: 2,
      shade: true,
      title: false, //不显示标题
      area: ['100%', '100%'], //宽高
      offset: ['0px', '0px'],
      closeBtn: 0,
      content: [url, 'yes'],//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
      cancel: function(){
        //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
      }
    });
}

$(function(){
    var url = "/mobile/get-member-by-token";

     var _request =$.ajax({
       type: 'get',
       url: url,
       data: {},
       dataType: 'json'
    });

    _request.fail(function( jqXHR, textStatus ) {
         //openWeiboLogin();
        layer.msg("需要登陆");
        window.location.href = "/mobile/index";

    });

    _request.done(function(data) {

          if(data.data.nickName == null || data.data.department == null){
            //openUrl("/mobile/user-info");
            window.location.href = "/mobile/user-info";
          }else {
               $("#nick_name").text(data.data.nickName);
               var cd = data.data.company + " | " + data.data.department
               $("#department").text(cd);
          }
    });
});