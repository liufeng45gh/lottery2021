

function setShow(id){
    setIsShow(id,1);
}

function setHide(id){
    setIsShow(id,0);
}

function setIsShow(id,status){
   var data_send = {};
    data_send.id = id;
    data_send.isShow = status;
    //alert(data_send.id);
    //alert(data_send.password);

     var status_request =$.ajax({
           type: 'post',
           url: '/cms/wish/set-show',
           data: data_send,
           dataType: 'json'
        });

     status_request.fail(function( jqXHR, textStatus ) {
          if(jqXHR.status==401){
             //openWeiboLogin();

          }
        });

     status_request.done(function(data) {
         layer.closeAll('prompt');
         layer.alert("状态已从新设定",
           {} ,
            function(){
                window.location.reload();
            }
          );

        });
}