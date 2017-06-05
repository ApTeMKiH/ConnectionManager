function addFr(id) {
    $.ajax({

        url: '/friends/add/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            window.location.assign("/friend/profile/"+id+"");
        }
    });

}
function confirmFriend(id) {
    $.ajax({
        url: '/friends/confirm/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            window.location.assign("/friend/profile/"+id+"");
        }
    });
}
function deleteFriend(id) {
    $.ajax({
        url: '/friends/delete/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            window.location.assign("/friend/profile/"+id+"");
        }
    });
}
function unfollowingFriend(id) {
    $.ajax({
        url: '/friends/unfollowing/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            window.location.assign("/friend/profile/"+id+"");
        }
    });
}
