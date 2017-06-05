
$('.btnEdit').on('click',function(e){
    e.preventDefault();
    var data = $(this).data("post")
    var pelem = document.getElementById('postText'+data);
    var form = document.getElementById('changePostForm'+data);
    var buttons = document.getElementById('btnGroup');
    var textArea = document.getElementById('textAreaPost'+data);
    textArea.innerHTML = pelem.textContent;
    pelem.style.display = "none";
    form.style.display = "block";
    buttons.style.display = "none";
});
$('.btnSubmit').on('click', function (e) {
    e.preventDefault();
    var data = $(this).data('post');
    var text = {text: $('#textAreaPost'+data+'').val()};
    $.ajax({
        url: '/posts/edit/'+data,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(text),
        success: function () {
            var idElem = "postText"+data+"";
            console.log(idElem);
            var pelem = document.getElementById(idElem);
            var form = document.getElementById('changePostForm'+data);
            var buttons = document.getElementById('btnGroup');
            form.style.display = 'none';
            pelem.textContent = text.text;
            pelem.style.display = 'block';
            buttons.style.display = 'block';
        }
    })

});

var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    // dots[slideIndex-1].className += " active";
}
