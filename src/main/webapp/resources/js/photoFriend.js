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
    caption.innerHTML = date2;
});
$('.closePhoto').on('click',function() {
    var modal = document.getElementById('myModal');
    modal.style.display = "none";
});