


function deleteDay(id){
   var data_send = {};
    data_send.day = id;

    //alert(data_send.id);
    //alert(data_send.password);

     var status_request =$.ajax({
           type: 'post',
           url: '/cms/reward/day-delete',
           data: data_send,
           dataType: 'json'
        });

     status_request.fail(function( jqXHR, textStatus ) {
          if(jqXHR.status==401){
             //openWeiboLogin();

          }
        });

     status_request.done(function(data) {
         //layer.closeAll('prompt');
         layer.alert("已删除",
           {} ,
            function(){
                window.location.reload();
            }
          );

        });
}