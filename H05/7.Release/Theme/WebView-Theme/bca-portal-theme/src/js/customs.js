(function ($) {
  'use strict';
  
  $(window).ready(function () {
    $('.section-banner').slick({
      autoplay:true,
      slidesToShow: 1,
      arrows: false,
      dots: false,
      fade: true
    });

    $('.section-nav-cate').slick({
      autoplay:true,
      slidesToShow: 5,
      arrows: false,
      dots: false,
      responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 3,
          infinite: true,
          dots: true
        }
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 3
        }
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 2
        }
      }
      // You can unslick at a given breakpoint now by adding:
      // settings: "unslick"
      // instead of a settings object
    ]
    });

    $('.datepicker-ip').datepicker({
      format: 'dd/mm/yyyy',
      autoclose: true,
      language: 'vi',
      todayBtn: 'linked',
      todayHighlight: true,
      startDate: '-0d',
      changeMonth: true,
      stepMonths: 0
    });

    $('.multiple-select').tokenize2();

    //Menu
		$('#main-menu').smartmenus({});

		$('.icon-toggle').click(function(){
			$(this).parent().find('.menu').toggleClass('show');
			$(this).toggleClass('active');
		});
    $('.slidebar-left-header').click(function(){
      $(this).parent().toggleClass('show');
    })

    $(window).scroll(function() {

    });

  });

  // **********************************************************************//
  // ! Window resize
  // **********************************************************************//
  $(window).on('resize', function () {

  });

})(jQuery);