<!DOCTYPE html>
<html lang="en">
<head>
<title>Prédimensionnement</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Landing Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
	
	<!-- animation css files -->
	<link rel="stylesheet" href="inc/css/animation-aos.css">
	<link href='inc/css/aos.css' rel='stylesheet prefetch' type="text/css" media="all" />
	<!-- //animation css files -->

	<!-- css files -->
    <link href="inc/css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="inc/css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="inc/css/fontawesome-all.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->
	<link href="inc/images/favicon.png" type="image/x-icon" rel="shortcut icon">
	<!-- google fonts -->
	<link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
	<!-- //google fonts -->
	
</head>
<body>

<!-- header -->
<header class="index-banner">
    <!-- nav -->
    <nav class="main-header">
      <div id="brand" data-aos="zoom-in-up">
        <div id="word-mark">
          <a href="Home"> 
            <img alt="" src="inc/images/logosodibet.png">
          </a>
        </div>
      </div>
      <div id="menu">
        <div id="menu-toggle">
          <div id="menu-icon">
            <div class="bar"></div>
            <div class="bar"></div>
            <div class="bar"></div>
          </div>
        </div>
        <ul class="text-center nav-agile" data-aos="zoom-in-up">
          <li>
           <a href="Predimensionnement"><u><b>Prédimensionnement</b></u></a>
          </li>
             <li>
            <a href="Hypotheses">Hypothèses</a>
          </li>
             <li>
            <a href="Ask">Posez une question</a>
          </li>
          <li>
            <a href="Contact">Contacts</a>
          </li>
             <li>
            <a href="Plaquette">Plaquette</a>
          </li>
          <li>
            <a href="Logout"><button  type="button" class="btn btn-secondary" >
              Log out
            </button></a>
          </li>
        </ul>
      </div>
    </nav>
    <!-- //nav -->
    </header>
	<!-- banner -->
	<div class="banner layer" id="home">
		<div class="container">
			<!-- banner bottom -->
			</div>
<!-- //banner -->
<section class="banner-bottom py-5">
</section>
</div><div class="container py-md-3"></div>
	
	<section class="choose py-5" id="choose">
	<div class="container py-md-3">
		<h3 class="heading mb-5 text-center" data-aos="zoom-in">Fonctionnalités</h3>
		<div class="feature-grids row">
			<div class="col-lg-4 col-md-6" data-aos="fade-right">
				<a href="Portee">
				<div class="f1 icon1 p-4">
					<img alt="porteeImage" src="inc/images/portee.jpg" width="25%" height="25%">
					<h3 class="my-3">Portée limite</h3>
					<p>Détermination de la portée limite par la flèche</p>
				</div>
				</a>
			</div>
			<div class="col-lg-4 col-md-6" data-aos="fade-up">
				<a href="Epaisseur">
				<div class="f1 icon2 p-4">
					<img alt="epaisseurImage" src="inc/images/epaisseur.jpg" width="25%" height="25%">
					<h3 class="my-3">Epaisseur du plancher</h3>
					<p>Détermination de l'épaisseur du plancher</p>
				</div>
				</a>
			</div>		
			<div class="col-lg-4 col-md-6 mt-lg-0 mt-4 " data-aos="fade-left">
				<a href="Litrage">
				<div class="f1 icon2 p-4">
					<img alt="litrageImage" src="inc/images/litrage.jpg" width="25%" height="25%">
					<h3 class="my-3">Litrage</h3>
					<p>Calcul du litrage</p>
				</div>
				</a>
			</div>
		</div>
	</div>
</section>
<!-- //header -->

    <!-- js -->
    <script src="inc/js/jquery-2.2.3.min.js"></script>
    <script src="inc/js/bootstrap.js"></script>
    <!-- //js -->
	
	<!-- animation js -->
	<script src='inc/js/aos.js'></script>
	<script>
		AOS.init({
            easing: 'ease-out-back',
            duration: 1000
        });

    </script>
	<!-- //animation js -->

	<!-- testimonials  Responsiveslides -->
    <script src="inc/js/responsiveslides.min.js"></script>
    <script>
        // You can also use"$(window).load(function() {"
        $(function () {
            // Slideshow 4
            $("#slider3").responsiveSlides({
                auto: true,
                pager: true,
                nav: false,
                speed: 500,
                namespace: "callbacks",
                before: function () {
                    $('.events').append("<li>before event fired.</li>");
                },
                after: function () {
                    $('.events').append("<li>after event fired.</li>");
                }
            });

        });
    </script>
    <!-- //testimonials  Responsiveslides -->

	<!-- sticky nav bar-->
	<script>
		$(() => {

		  //On Scroll Functionality
		  $(window).scroll(() => {
			var windowTop = $(window).scrollTop();
			windowTop > 100 ? $('nav').addClass('navShadow') : $('nav').removeClass('navShadow');
			windowTop > 100 ? $('ul.nav-agile').css('top', '50px') : $('ul.nav-agile').css('top', '160px');
		  });

		  //Click Logo To Scroll To Top
		  $('#logo').on('click', () => {
			$('html,body').animate({
			  scrollTop: 0
			}, 500);
		  });

		 /*
		  //Smooth Scrolling Using Navigation Menu
		  $('a[href*="#"]').on('click', function (e) {
			$('html,body').animate({
			  scrollTop: $($(this).attr('href')).offset().top - 100
			}, 500);
			e.preventDefault();
		  });
		 */

		  //Toggle Menu
		  $('#menu-toggle').on('click', () => {
			$('#menu-toggle').toggleClass('closeMenu');
			$('ul').toggleClass('showMenu');

			$('li').on('click', () => {
			  $('ul').removeClass('showMenu');
			  $('#menu-toggle').removeClass('closeMenu');
			});
		  });

		});
	</script>
	<!-- //sticky nav bar -->

	<script src="inc/js/smoothscroll.js"></script><!-- Smooth scrolling -->

    <!-- start-smoth-scrolling -->
    <script src="inc/js/move-top.js"></script>
    <script src="inc/js/easing.js"></script>
    <script>
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 900);
            });
        });
    </script>
    <script>
        $(document).ready(function () {
            /*
			var defaults = {
				  containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			 };
			*/

            $().UItoTop({
                easingType: 'easeOutQuart'
            });

        });
    </script>
    <!-- //end-smoth-scrolling -->

</body>
</html>