$(document).ready(getAllFriends());

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
    var data = $('#rowFriendsContent').data("friend");
    $.ajax({
        url: '/friend/'+data+'/all',
        type: 'GET',
        contentType: 'application/json',
        success: function (friends) {
            if (friends.length != 0){
                var html = '';
                for (var i = 0; i<friends.length;i++){
                    if (friends[i].who == "FRIEND"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/delete/"+friends[i].id+"' onclick='deleteFriend("+friends[i].id+")' class='btn btn-danger buttonFriendDelete'>Delete</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWING"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/unfollowing/"+friends[i].id+"' onclick='unfollowingFriend("+friends[i].id+")' class='btn btn-warning buttonFriendUnfollowing'>Unfollowing</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWER"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/confirm/"+friends[i].id+"' onclick='confirmFriend("+friends[i].id+")' class='btn btn-success buttonFriendConfirm'>Confirm</a></div> </div>";
                    }else if (friends[i].who == "YOU"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/add/"+friends[i].id+"'  onclick='addFr("+friends[i].id+")' class='btn btn-primary disabled buttonFriendAdd'>It's you</a></div></div>";
                    }else {
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/add/"+friends[i].id+"'  onclick='addFr("+friends[i].id+")' class='btn btn-primary buttonFriendAdd'>Add to friend</a></div></div>";
                    }
                }
                $('#rowFriendsContent').append(html);
            }else {
                $('#rowFriendsContent').append("<div id=\"haveNoFriend\" class=\"col-sm-9\"><div class=\"well\">Your friend don't have friends</div></div>");
            }
        }
    });
}

function getAllFollowers() {
    $('#rowFriendsContent').empty();
    var data = $('#rowFriendsContent').data("friend");
    $.ajax({
        url: '/friend/'+data+'/followers',
        type: 'GET',
        contentType: 'application/json',
        success: function (friends) {
            if (friends.length != 0){
                var html = '';
                for (var i = 0; i<friends.length;i++){
                    if (friends[i].who == "FRIEND"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/delete/"+friends[i].id+"' onclick='deleteFriend("+friends[i].id+")' class='btn btn-danger buttonFriendDelete'>Delete</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWING"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/unfollowing/"+friends[i].id+"' onclick='unfollowingFriend("+friends[i].id+")' class='btn btn-warning buttonFriendUnfollowing'>Unfollowing</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWER"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/confirm/"+friends[i].id+"' onclick='confirmFriend("+friends[i].id+")' class='btn btn-success buttonFriendConfirm'>Confirm</a></div> </div>";
                    }else if (friends[i].who == "YOU"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/add/"+friends[i].id+"'  onclick='addFr("+friends[i].id+")' class='btn btn-primary disabled buttonFriendAdd'>It's you</a></div></div>";
                    }else {
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/add/"+friends[i].id+"'  onclick='addFr("+friends[i].id+")' class='btn btn-primary buttonFriendAdd'>Add to friend</a></div></div>";
                    }
                }
                $('#rowFriendsContent').append(html);
            }else {
                $('#rowFriendsContent').append("<div id=\"haveNoFriend\" class=\"col-sm-9\"><div class=\"well\">Your friend don't have followers</div></div>");
            }
        }
    });

}

function getAllFollowing() {
    $('#rowFriendsContent').empty();
    var data = $('#rowFriendsContent').data("friend");
    $.ajax({
        url: '/friend/'+data+'/following',
        type: 'GET',
        contentType: 'application/json',
        success: function (friends) {
            if (friends.length != 0){
                var html = '';
                for (var i = 0; i<friends.length;i++){
                    if (friends[i].who == "FRIEND"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/delete/"+friends[i].id+"' onclick='deleteFriend("+friends[i].id+")' class='btn btn-danger buttonFriendDelete'>Delete</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWING"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/unfollowing/"+friends[i].id+"' onclick='unfollowingFriend("+friends[i].id+")' class='btn btn-warning buttonFriendUnfollowing'>Unfollowing</a></div> </div>";
                    }else if (friends[i].who == "FOLLOWER"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/confirm/"+friends[i].id+"' onclick='confirmFriend("+friends[i].id+")' class='btn btn-success buttonFriendConfirm'>Confirm</a></div> </div>";
                    }else if (friends[i].who == "YOU"){
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/add/"+friends[i].id+"'  onclick='addFr("+friends[i].id+")' class='btn btn-primary disabled buttonFriendAdd'>It's you</a></div></div>";
                    }else {
                        html += "<div class=\"col-sm-4\"><div class=\"well\"><pre class='friendsText'><strong><a href='/friend/profile/"+friends[i].id+"'>"+friends[i].name+" "+friends[i].surname+"</a></strong></pre><div class='friendsBlock'><img class=\"imgFriend\"  src='"+friends[i].avatarPath+"'></div><a href='#/friends/add/"+friends[i].id+"'  onclick='addFr("+friends[i].id+")' class='btn btn-primary buttonFriendAdd'>Add to friend</a></div></div>";
                    }
                }
                $('#rowFriendsContent').append(html);
            }else {
                $('#rowFriendsContent').append("<div id=\"haveNoFriend\" class=\"col-sm-9\"><div class=\"well\">Your friend don't following</div></div>");
            }
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
function confirmFriend(id) {
    $.ajax({
        url: '/friends/confirm/'+id,
        type: 'POST',
        contentType: 'application/json',
        success: function () {
            getAllPeople();
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
            getAllPeople();
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
            getAllPeople();
        }
    });
}
