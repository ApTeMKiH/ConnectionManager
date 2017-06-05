var data = $('.sendMessage').data("message");
$(document).ready(function () {
    getAllMessage(data);
    checkMessage();
});

$('#messageRefresh').on('click', function () {
   getAllMessage(data);
   checkMessage();
});

$('#sendMessage').on('click', function(){
    var text = {text: $('#writeMessage').val()};
    var data = $('.sendMessage').data("message");
    $.ajax({
        url: '/dialog/friend/'+data+'',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(text),
        success: function () {
            getAllMessage(data);
            document.getElementById('writeMessage').value = "";
            checkMessage();
        }
    })
});
function getAllMessage(data) {
    $('.messageContainer').empty();
    var current = $('.img-circle').data("current");
    $.ajax({
        url: '/dialog/'+data+'/all/message',
        method: 'GET',
        contentType: 'application/json',
        success: function (messages) {
            console.log(messages);
            for (var i = 0; i < messages.length; i++){
                if (messages[i].userFromId == current){
                    $('.messageContainer').append("<strong><span>"+messages[i].userFrom+"</span></strong><a><span onclick='deleteMess("+messages[i].id+")' class='glyphicon glyphicon-remove deleteMessage'></span></a><pre>"+messages[i].text+"</pre>");
                } else{
                    $('.messageContainer').append("<strong><span>"+messages[i].userFrom+"</span></strong><pre>"+messages[i].text+"</pre>");
                }

            }
            $('.messageContainer').scrollTop(1000000);

        }
    });
    checkMessage();
}

function deleteMess(id) {
    $.ajax({
        url: '/dialog/message/delete/'+id+'',
        method: "GET",
        contentType: 'application/json',
        success: function () {
            getAllMessage(data);

        }
    });
    checkMessage();
}
