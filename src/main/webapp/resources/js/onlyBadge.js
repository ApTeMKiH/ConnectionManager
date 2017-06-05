$(document).ready(function () {
chekFriend();
checkMessage();
});

function checkMessage() {
    $.ajax({
        url: '/message/check',
        type: 'GET',
        contentType: 'application/json',
        success: function (count) {
            if (count != 0){
                $('.messageBadge').text(count);
            }else{
                $('.messageBadge').text(null);
            }
        }
    })

}

function chekFriend(){
    $.ajax({
        url: '/user/check/friend',
        type: 'GET',
        contentType: 'application/json',
        success: function (count) {
            if (count != 0){
                $('.friendBadge').text(count);
            } else {
                $('.friendBadge').text(null);
            }
        }
    })
}