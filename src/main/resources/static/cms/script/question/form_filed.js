function removeAnswerThis(obj){
    $(obj).parent().parent().remove();
}

function addAnswer(){
    $("#answer-body").append($("#answer-template").html());
}


$(function(){
    var ue = UE.getEditor('editor');
});

