
$(document).ready(function() {
  $('.nuove-uscite').slick({
    dots : true,
    infinite : true,
    slidesToShow : 3,
    slidesToScroll : 1,
    autoplay : true,
    autoplaySpeed : 2000,
    prevArrow : '.arrow_prev2',
    nextArrow : '.arrow_next2'
  });

  $('.carosello-home').slick({
    dots : true,
    infinite : true,
    slidesToShow : 1,
    slidesToScroll : 1,
    autoplay : true,
    autoplaySpeed : 5000,
    prevArrow : '.arrow_prev1',
    nextArrow : '.arrow_next1'
  });
});