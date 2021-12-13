function submitUserInfo(){
    var nick_name = $("#nick_name").val();
    if (nick_name.trim()=="") {
        layer.msg("姓名不能为空");
        return;
    }

    var company = $("#company").val();
    if (company == null) {
            layer.msg("公司不能为空");
            return;
     }
    if (company.trim()=="") {
        layer.msg("公司不能为空");
        return;
    }

    if (company.trim()=="请选择") {
        layer.msg("公司不能为空");
        return;
    }

    var department = $("#department").val();
     if (department == null) {
            layer.msg("部门不能为空");
            return;
     }
    if (department.trim()=="") {
        layer.msg("部门不能为空");
        return;
    }

    if (department.trim()=="请选择") {
        layer.msg("部门不能为空");
        return;
    }

    var request_data = {};
    request_data.nickName = nick_name;
    request_data.department = department;
    request_data.company = company;

    $.ajax({
         type: "POST",
         url: "/mobile/user-info",
         data: request_data,
         dataType: "json",
         success: function (data) {
              if (data.ok) {
                    layer.msg("修改成功",{icon: 6});
                  setTimeout(function(){
                    layer.closeAll();
                    window.location.href = "/mobile/list?"+ Math.random();
                  },2000)
              }else {
                layer.msg("操作异常",{icon: 5});
              }

         },
         error: function (message) {
             layer.msg("系统错误",{icon: 5});
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
        layer.msg("操作异常");

    });

    _request.done(function(data) {
       $("#nick_name").val(data.data.nickName);
       $("#department").val(data.data.department);
    });
});