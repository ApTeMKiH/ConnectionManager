$('.photo').on('click',function(){
    var img01 = document.getElementById('img01');
    var modal = document.getElementById('myModal');
    var caption = document.getElementById('caption');
    modal.style.display = "block";
    img01.src = this.src;
    var data = $(this).data("image");
    var date = this.alt;
    var date2 = date.substr(0,date.length - 5);
    console.log(img01.src);
    if (img01.src != "http://localhost:8080/resources/images/defaultImg/1.png"){
        caption.innerHTML = date2 + "<a href='/delete/avatar' class='makeAsAvatar'>Delete avatar</a>";
    }else if (img01.src == "http://localhost:8080/resources/images/defaultImg/1.png"){
        caption.innerHTML = date2;
    }
});
$('.photoFriend').on('click',function(){
    var img01 = document.getElementById('img01');
    var modal = document.getElementById('myModal');
    var caption = document.getElementById('caption');
    modal.style.display = "block";
    img01.src = this.src;
    var date = this.alt;
    var date2 = date.substr(0,date.length - 5);
    console.log(img01.src);
    if (img01.src != "http://localhost:8080/resources/images/defaultImg/1.png"){
        caption.innerHTML = date2;
    }else if (img01.src == "http://localhost:8080/resources/images/defaultImg/1.png"){
        caption.innerHTML = date2;
    }
});
$('.closePhoto').on('click',function() {
    var modal = document.getElementById('myModal');
    modal.style.display = "none";
});

