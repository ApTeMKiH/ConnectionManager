$(document).ready(getAllFriends());

$("#people").on('click', function () {
    getAllPeople();
});
$("#followers").on('click', function () {
    getAllFollowers();
});
$("#following").on('click', function () {
    getAllFollowing();
});
$("#friends").on('click', function () {
    getAllFriends();
});

function getAllFriends() {
    $('#rowFriendsContent').empty();
    $.ajax({
        url: '/friends/all',
        type: 'GET',
        contentType: 'application/json',
        success: function (friends) {
            if (friends.length != 0){
                var html = '';
                for (var i = 0; i<friends.length;i++){
                    html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/delete/"+friends[i].id+"' onclick='deleteFriend("+friends[i].id+")' class='btn btn-danger buttonFriendDelete'>Delete</a></div> </div>";
                }
                $('#rowFriendsContent').append(html);
            }else {
                $('#rowFriendsContent').append("<div id=\"haveNoFriend\" class=\"col-sm-9\"><div class=\"well\">You don't have friend</div></div>");
            }
            $('#focusedInput').removeClass("searchFollower");
            $('#focusedInput').removeClass("searchFollowing");
            $('#focusedInput').removeClass("searchPeople");
            $('#focusedInput').addClass("searchFriend");
            $('#focusedInput').val('');
        }
    });
}

function getAllFollowers() {
    $('#rowFriendsContent').empty();
    $.ajax({
        url: '/friends/followers',
        type: 'GET',
        contentType: 'application/json',
        success: function (friends) {
            if (friends.length != 0){
                var html = '';
                for (var i = 0; i<friends.length;i++){
                    html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/confirm/"+friends[i].id+"' onclick='confirmFriend("+friends[i].id+")' class='btn btn-success buttonFriendConfirm'>Confirm</a></div> </div>";
                }
                $('#rowFriendsContent').append(html);
            }else {
                $('#rowFriendsContent').append("<div id=\"haveNoFriend\" class=\"col-sm-9\"><div class=\"well\">You don't have followers</div></div>");
            }
            $('#focusedInput').removeClass("searchFriend");
            $('#focusedInput').removeClass("searchFollowing");
            $('#focusedInput').removeClass("searchPeople");
            $('#focusedInput').addClass("searchFollower");
            $('#focusedInput').val('');
        }
    });

}

function getAllFollowing() {
    $('#rowFriendsContent').empty();
    $.ajax({
        url: '/friends/following',
        type: 'GET',
        contentType: 'application/json',
        success: function (friends) {
            if (friends.length != 0){
                var html = '';
                for (var i = 0; i<friends.length;i++){
                    html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/unfollowing/"+friends[i].id+"' onclick='unfollowingFriend("+friends[i].id+")' class='btn btn-warning buttonFriendUnfollowing'>Unfollowing</a></div> </div>";
                }
                $('#rowFriendsContent').append(html);
            }else {
                $('#rowFriendsContent').append("<div id=\"haveNoFriend\" class=\"col-sm-9\"><div class=\"well\">You are not following</div></div>");
            }
            $('#focusedInput').removeClass("searchFriend");
            $('#focusedInput').removeClass("searchFollower");
            $('#focusedInput').removeClass("searchPeople");
            $('#focusedInput').addClass("searchFollowing");
            $('#focusedInput').val('');
        }
    });
}

function getAllPeople() {
    $('#rowFriendsContent').empty();
    $.ajax({
        url: '/friends/people',
        type: 'GET',
        contentType: 'application/json',
        success: function (friends) {
            console.log(friends);
                var html = '';
                for (var i = 0; i<friends.length;i++){
                    console.log(friends);
                    if (friends[i].who == "FRIEND"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/delete/"+friends[i].id+"' onclick='deleteFriend("+friends[i].id+")' class='btn btn-danger buttonFriendDelete'>Delete</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWING"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/unfollowing/"+friends[i].id+"' onclick='unfollowingFriend("+friends[i].id+")' class='btn btn-warning buttonFriendUnfollowing'>Unfollowing</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWER"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/confirm/"+friends[i].id+"' onclick='confirmFriend("+friends[i].id+")' class='btn btn-success buttonFriendConfirm'>Confirm</a></div> </div>";
                    }else {
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/add/"+friends[i].id+"'  onclick='addFr("+friends[i].id+")' class='btn btn-primary buttonFriendAdd'>Add to friend</a></div></div>";
                    }
                }
                $('#rowFriendsContent').append(html);
            $('#focusedInput').removeClass("searchFriend");
            $('#focusedInput').removeClass("searchFollower");
            $('#focusedInput').removeClass("searchFollowing");
            $('#focusedInput').addClass("searchPeople");
            $('#focusedInput').val('');
        }
    });
}

function confirmFr(id) {
    $.ajax({

        url: '/friends/confirm/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllFollowers();
        }
    });

}

function addFr(id) {
    $.ajax({

        url: '/friends/add/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllPeople();
        }
    });

}

function deleteFr(id) {
    $.ajax({

        url: '/friends/delete/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllFriends();
        }
    });

}

function unfollowingFr(id) {
    $.ajax({
        url: '/friends/unfollowing/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllFollowing();
        }
    });
}
function confirmFriend(id) {
    $.ajax({
        url: '/friends/confirm/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllFollowers();
            chekFriend()
        }
    });
}
function deleteFriend(id) {
    $.ajax({
        url: '/friends/delete/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllFriends();
            chekFriend()
        }
    });
}
function unfollowingFriend(id) {
    $.ajax({
        url: '/friends/unfollowing/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllFollowing();
        }
    });
}