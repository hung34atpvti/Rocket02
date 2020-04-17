window.onscroll = function() {
  scrollFunction()
};

function scrollFunction() {
  if (document.body.scrollTop > 300 || document.documentElement.scrollTop > 300) {
    document.getElementById("navbar_menu1").style.top = "0px";
  } else {
    document.getElementById("navbar_menu1").style.top = "-100px";

  }
}

// slide
(function ($) {
  "use strict";
  // Auto-scroll
  $('#myCarousel').carousel({
    interval: 5000
  });

  // Control buttons
  $('.next').click(function () {
    $('.carousel').carousel('next');
    return false;
  });
  $('.prev').click(function () {
    $('.carousel').carousel('prev');
    return false;
  });

  // On carousel scroll
  $("#myCarousel").on("slide.bs.carousel", function (e) {
    var $e = $(e.relatedTarget);
    var idx = $e.index();
    var itemsPerSlide = 4;
    var totalItems = $(".carousel-item").length;
    if (idx >= totalItems - (itemsPerSlide - 1)) {
      var it = itemsPerSlide -
          (totalItems - idx);
      for (var i = 0; i < it; i++) {
        // append slides to end
        if (e.direction == "left") {
          $(
            ".carousel-item").eq(i).appendTo(".carousel-inner");
        } else {
          $(".carousel-item").eq(0).appendTo(".carousel-inner");
        }
      }
    }
  });
})
(jQuery);

$(document).ready(function() {
 // executes when HTML-Document is loaded and DOM is ready
console.log("document is ready");


  $( ".card" ).hover(
  function() {
    $(this).addClass('shadow-lg').css('cursor', 'pointer');
  }, function() {
    $(this).removeClass('shadow-lg');
  }
);

// document ready
});


//
// $(document).ready(function() {
//   $("#myCarousel").on("slide.bs.carousel", function(e) {
//     var $e = $(e.relatedTarget);
//     var idx = $e.index();
//     var itemsPerSlide = 4;
//     var totalItems = $(".carousel-item").length;
//
//     if (idx >= totalItems - (itemsPerSlide - 1)) {
//       var it = itemsPerSlide - (totalItems - idx);
//       for (var i = 0; i < it; i++) {
//         // append slides to end
//         if (e.direction == "left") {
//           $(".carousel-item")
//             .eq(i)
//             .appendTo(".carousel-inner");
//         } else {
//           $(".carousel-item")
//             .eq(0)
//             .appendTo($(this).find(".carousel-inner"));
//         }
//       }
//     }
//   });
// });
