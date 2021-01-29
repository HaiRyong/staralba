$(document).ready(function() {
	$('.main-slick').slick({
        dots: true,
        prevArrow: false,
        nextArrow: false,
        autoplay : false,
        autoplaySpeed : 4000,
        pauseOnHover : false,
        pauseOnFocus: false,
        centerMode: true,
  		centerPadding: '300px',
  		slidesToShow: 1,
		  responsive: [
		    {
		      breakpoint: 769,
		      settings: {
		        arrows: false,
		        centerMode: true,
		        centerPadding: '200px',
		        slidesToShow: 1
		      }
		    },
		    {
		      breakpoint: 480,
		      settings: {
		        arrows: false,
		        centerMode: true,
		        centerPadding: '80px',
		        slidesToShow: 1
		      }
		    }
		  ]
    });

    $('.video-box').slick({

        infinite: true,
        dots: true,
        prevArrow: false,
        nextArrow: false,
        autoplay : true,
        autoplaySpeed : 4000,
        pauseOnHover : false,
        pauseOnFocus: false
    });

    $( "#search_input" )
      .click(function() {
        $( ".search-wrap .search-list" ).addClass('active');
      })
      .blur(function() {
        $( ".search-wrap .search-list" ).removeClass('active');
      });

	$(".tab-slide .slide-contents").hide();
    $(".tab-slide .slide-contents:first-child").show();
    $(".main-slide .tab a").on('click',function () {
        $(".main-slide .tab a").removeClass("active");
        $(this).addClass("active");
        $(".tab-slide .slide-contents").hide();
        var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn('fast');
        $('.main-slick').slick('setPosition');
        $('.video-box').slick('setPosition');
    });

    $(".main-starbox .star-container").hide();
    $(".main-starbox .star-container:first-child").show();
    $(".star-tab a").on('click',function () {
        $(".star-tab a").removeClass("active");
        $(this).addClass("active");
        $(".main-starbox .star-container").hide();
        var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn('fast');
    });

    $(".starcall-lsit .list").hide();
    $(".starcall-lsit .list:first-child").show();
    $(".starcall-tab .inner a").on('click',function () {
        $(".starcall-tab .inner a").removeClass("active");
        $(this).addClass("active");
        $(".starcall-lsit .list").hide();
        var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn('fast');
    });

    $(".mystar-contents .list").hide();
    $(".mystar-contents .list:first-child").show();
    $(".mystar-tab .inner a").on('click',function () {
        $(".mystar-tab .inner a").removeClass("active");
        $(this).addClass("active");
        $(".mystar-contents .list").hide();
        var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn('fast');
    });

    $(".callmanager-contents .callmanager-list").hide();
    $(".callmanager-contents .callmanager-list:first-child").show();
    $(".callmanager-tab a").on('click',function () {
        $(".callmanager-tab a").removeClass("active");
        $(this).addClass("active");
        $(".callmanager-contents .callmanager-list").hide();
        var activeTab = $(this).attr("rel");
        $("#" + activeTab).fadeIn('fast');
    });

    $('#callmanager-con1 .match-box .toggle-match').click(function () {
        $(this).toggleClass('active');
        $('#callmanager-con1 .match-box .match-list').stop().slideToggle('fast');
    });

    $('#callmanager-con2 .match-box .toggle-match').click(function () {
        $(this).toggleClass('active');
        $('#callmanager-con2 .match-box .match-list').stop().slideToggle('fast');
    });

    $('#callmanager-con1 .match-box .match-button').click(function () {
        $('#callmanager-con1 .match-box .match-button').removeClass('active');
        $(this).addClass('active');
        $('#callmanager-con1 .match-box .match-info').addClass('active');
        $('#callmanager-con1 .match-box .match-info').slideUp('fast');
        $('#callmanager-con1 .match-box .match-info.active').slideDown('fast');
    });

    $('#callmanager-con2 .match-box .match-button').click(function () {
        $('#callmanager-con2 .match-box .match-button').removeClass('active');
        $(this).addClass('active');
        $('#callmanager-con2 .match-box .match-info').addClass('active');
        $('#callmanager-con2 .match-box .match-info').slideUp('fast');
        $('#callmanager-con2 .match-box .match-info.active').slideDown('fast');
    });

    $('#callmanager-con1 .new-match').click(function () {
        $(this).addClass('active');
        $('#callmanager-con1 .new-matchform').stop().slideDown('fast');
    });

    $('#callmanager-con1 .match-info button').click(function () {
        $(this).addClass('active');
        $('#callmanager-con1 .old-matchform').stop().slideDown('fast');
    });

    $('#callmanager-con2 .new-match').click(function () {
        $(this).addClass('active');
        $('.new-matchform').stop().slideDown('fast');
    });

    $('#callmanager-con2 .match-info button').click(function () {
        $(this).addClass('active');
        $('.old-matchform').stop().slideDown('fast');
    });

    $('.match-form .close-button').click(function () {
        $(this).parents('.new-match').removeClass('active');
        $(this).parents('.match-form').stop().slideUp('fast');
    });

    $('.mystar .mystar-contents .list > div').click(function () {
        $(this).toggleClass('chked');
    });



    $('#toolbar .inner .star').click(function () {
        $(this).toggleClass('active');
        $('#toolbar .star-app').slideToggle('fast');
    });

    var windowsize = $(window).width();
    if (windowsize < 1024) {

    }
    else if(windowsize < 768){

    }
    else{

    }
    $(window).resize(function() {
        if(Modernizr.mq('screen and (max-width:1024px)')) {

        }
        else if(Modernizr.mq('screen and (max-width:768)')) {

        }
        else{

        }
    });


    function ct (){
        var snba = 0;
        $('.star-container .inner a').each(function (index) {
            snba += $(this).width() + 30;
        })
        $('.star-container .inner').css('width', snba);
    }


});
