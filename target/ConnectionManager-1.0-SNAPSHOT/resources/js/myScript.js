$(document).ready(function () {
    $('#errorMessage').css({'display':'none'});
});

$("#send").on("click",function (e) {

    e.preventDefault();

    $.ajax({
        url: '/user/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(getUserObject()),
        success: function () {
            window.location.assign("/sign-in?reg");
        },
        error: function(error){
            showErrorMessage(error.responseText.replace(/"/g,''));
        }
    });
    // window.location.replace("/");
});
// var photoRegex = /([^\s]+(\.(?i)(jpg|png|gif|bmp|jpeg))$)/;
$("#addPhoto").on("click",function (e) {

    e.preventDefault();
    $.ajax({
        url: '/photo/check',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(getPhotoObject()),
        success: function () {
            $('#photoAdd').submit();
            // window.location.assign("/photo");
        },
        error: function(error){
            showErrorMessage(error.responseText.replace(/"/g,''));
        }
    });
});

function getPhotoObject() {
    var path = $('.addImage').val();
    return path;

}

$("#sendAudio").on("click",function (e) {

    e.preventDefault();
    $.ajax({
        url: '/audio/check',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(getAudioObject()),
        success: function () {
            $('#addAudio').submit();
            // window.location.assign("/photo");
        },
        error: function(error){
            showErrorMessage(error.responseText.replace(/"/g,''));
        }
    });
});

function getAudioObject() {
    var path = $('#audioAdd').val();
    return path;

}

function getUserObject() {
    var user = {name: $('#name').val(),
        surname: $('#surname').val(),
        email: $('#email').val(),
        password: $('#password').val()};
    return user;
}

function showErrorMessage(message) {
    $("#errorMessage").text(message);
    $("#errorMessage").css({"display":"block"});
}

function showBtn() {
    $('#addAvatar').css({"display":"block"});
};
function hideBtn() {
    $('#addAvatar').css({"display":"none"});
}
