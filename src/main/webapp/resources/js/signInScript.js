$('#signIn').on('click', function (e) {
    var email = getEmail();
    e.preventDefault();
    if (getEmail() == 'adminConnection'){
        $('#login').submit();
    }else {
    $.ajax({
        url: '/user/check',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(email),
        success: function (userConfig) {
            if (!userConfig.activated){
                window.location.assign("/sign-in?active=1");
            }else if (!userConfig.block){
                window.location.assign("/sign-in?block=1");
            }else
                $('#login').submit();
        },
        error: function () {
            window.location.assign("/sign-in?failure=1");
        }
    });
    }
});

function getEmail() {
    var email = $('#email').val();
    return email;

}