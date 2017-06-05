$('.photo').on('click',function(){
    var img01 = document.getElementById('img01');
    var modal = document.getElementById('myModal');
    var caption = document.getElementById('caption');
    modal.style.display = "block";
    img01.src = this.src;
    var data = $(this).data("image");
    var avatar = $(this).data("avatar");
    var date = this.alt;
    var date2 = date.substr(0,date.length - 5);
    if (avatar){
        caption.innerHTML = date2 + "<a id='deleteImage' href='/delete/image/"+data+"' >Delete image</a><a id='deleteAvatar' href='/delete/avatar' class='makeAsAvatar'>Delete avatar</a>";
    }else {
        caption.innerHTML = date2 + "<a id='deleteImage' href='/delete/image/"+data+"' >Delete image</a><a id='setAvatar' href='/set/avatar/"+data+"' class='makeAsAvatar'>Set as avatar</a>";
    }
});
$('.closePhoto').on('click',function() {
    var modal = document.getElementById('myModal');
    modal.style.display = "none";
});