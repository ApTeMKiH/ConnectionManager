$(document).ready(function () {
   searchPeople();
});
function searchPeople() {
    $('#rowFriendsContent').empty();
    $.ajax({
        url: '/manage/search',
        data: { "name" : $('#focusedInput').val()},
        method: 'GET',
        contentType: 'application/json',
        success: function (people) {
            var html = '';
            for (var i = 0; i<people.length;i++){
                if (people[i].userConfig.block){
                    html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+people[i].id+"'>"+people[i].name+" "+people[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+people[i].avatarPath+"'></div><div class='btn-group btn-group-justified' style='margin-top: 5px'><a href=''  onclick='blockUS("+people[i].id+")' class='btn btn-warning buttonFriendAdd'>Block</a><a href=''  onclick='deleteUs("+people[i].id+")' class='btn btn-danger buttonFriendAdd'>Delete</a></div></div></div>";
                }else if (!people[i].userConfig.block){
                    html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+people[i].id+"'>"+people[i].name+" "+people[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+people[i].avatarPath+"'></div><div class='btn-group btn-group-justified' style='margin-top: 5px'><a href=''  onclick='unblockUS("+people[i].id+")' class='btn btn-warning buttonFriendAdd'>Unblock</a><a href=''  onclick='deleteUs("+people[i].id+")' class='btn btn-danger buttonFriendAdd'>Delete</a></div></div></div>";
                }

            }
            $('#rowFriendsContent').append(html);
        }
    })
}

function blockUS(us) {
    $.ajax({
        url: '/manage/block/user/'+us,
        contentType: 'application/json',
        method: 'GET',
        success: function () {
            searchPeople();
        }
    })
}

function unblockUS(us) {
    $.ajax({
        url: '/manage/unblock/user/'+us,
        contentType: 'application/json',
        method: 'GET',
        success: function () {
            searchPeople();
        }
    })
}

function deleteUs(us) {
    $.ajax({
        url: '/manage/delete/user/'+us,
        contentType: 'application/json',
        method: 'GET',
        success: function () {
            searchPeople();
        }
    })

}