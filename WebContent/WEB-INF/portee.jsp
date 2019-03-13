<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Portée</title>
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
        <div id="logo">
          <a href="Home">
            <i class="fab fa-blackberry"></i>
          </a>
        </div>
        <div id="word-mark">
          <h1>
            <a href="Home">SODIBET</a>
          </h1>
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
        <ul class="text-center text-capitalize nav-agile" data-aos="zoom-in-up">
          <li>
            <a href="Predimensionnement" class="active">Prédimensionnement</a>
          </li>
             <li>
            <a href="#" class="active">Hypothéses</a>
          </li>
             <li>
            <a href="#" class="active">Posez une question</a>
          </li>
          <li>
            <a href="#" class="active">Contact</a>
          </li>
             <li>
            <a href="#" class="active">Plaquette</a>
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
	<!-- banner -->
	<div class="banner layer" id="home">
		<div class="container">
			<div class="row banner-text">
				<div class=" col-lg-8">
					<h3 class="txt-w3_agile" data-aos="fade-down">Calcul portée limite par la flèche</h3>
				</div>
		</div>
	</div>
	</div>
	<!-- //banner -->
	
</header>
<section class="contact py-5" id="contact">

	<div class="container py-lg-3">
		<form action="#" method="post" data-aos="fade-up">
			<div class="row">
				<div class="col-md-6 styled-input mt-0">
				<h3>Charges d'exloitations (daN/m2)<br></h3>
					<select class="form-control" name="charge" required>
						<option class="form-control" selected value="150">150
						<option class="form-control" value="250">250
						<option class="form-control" value="400">400
						<option class="form-control" value="500">500
						<option class="form-control" value="150/T">150/T
						<option class="form-control" value="100/T">100/T
					</select>
				</div>
				<div class="col-md-6 styled-input mt-md-0">
				</div> 
			</div>
			<br>	
			<h3>L'épaisseur du plancher :<br></h3>
			<div class="row">
				<div class="col-md-6 styled-input">
					<select class="form-control" name="epaisseurX" id="epaisseurX" onchange="epaisseur(this);" required>
						<option class="form-control" selected value="12">12
						<option class="form-control" value="16">16
						<option class="form-control" value="20">20
						<option class="form-control" value="25">25
						<option class="form-control" value="30">30
					</select>
				</div>
				
				<div class="col-md-6 styled-input">
					<select class="form-control" name="epaisseurY12" id="epaisseur12" style="display:block;">
								<option class="form-control" value="4">4
					</select>
					<select class="form-control" name="epaisseurY16" id="epaisseur16" style="display:none;">
								<option class="form-control" value="4">4
								<option class="form-control" value="5">5
								<option class="form-control" value="6">6
					</select>
					<select class="form-control" name="epaisseurY20" id="epaisseur20" style="display:none;">
								<option class="form-control" value="5">5
								<option class="form-control" value="6">6
								<option class="form-control" value="7">7
					</select>
					<select class="form-control" name="epaisseurY25" id="epaisseur25" style="display:none;">
								<option class="form-control" value="5">5
								<option class="form-control" value="6">6
								<option class="form-control" value="7">7
								<option class="form-control" value="8">8
					</select>
					<select class="form-control" name="epaisseurY30" id="epaisseur30" style="display:none;">
								<option class="form-control" value="5">5
								<option class="form-control" value="6">6
								<option class="form-control" value="7">7
								<option class="form-control" value="8">8
								<option class="form-control" value="10">10
					</select>
					<p><a data-aos="fade-up" href="#" data-toggle="modal" data-target="#exampleModalCenter1" role="button"><i class="fas mr-2 fa-question-circle"></i></a></p>
				</div> 
			</div>
			<div class="click text-center mt-3">
				<input type="submit" name ="calcul" value="Afficher résultat">	
			</div>
		</form>
	</div>
</section>
<!-- //contact -->
<!-- //header -->
<div class="modal fade" id="exampleModalCenter1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenter1" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-capitalize text-center" id="exampleModalLongTitle">Explication</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				Brève Explication sur ce que c'est la portée
			</div>
			<div class="modal-footer">
			<form method="post" action="#"><input type="submit" class ="btn btn-primary" name="dontShow" value="Ne plus afficher">
					</form>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
			</div>
		</div>
	</div>
</div>

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

<c:if test="${utilisateur.getPortee_1()==0}">
<script>
   
    $(document).ready(function() {
    	  $('#exampleModalCenter1').modal('show');
    	});
</script>
</c:if>



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
    //Script pour afficher les options personnalisées selon l'option de select choisi
    function epaisseur(that) {
        /*if (that.value == "architecte") {
            document.getElementById("sous_categorie_architecte").style.display = "block";
            document.getElementById("sous_categorie_ingenieur").style.display = "none";
        } else*/ 
        if(that.value=="12") {
        	document.getElementById("epaisseur16").style.display = "none";
        	document.getElementById("epaisseur20").style.display = "none";
        	document.getElementById("epaisseur25").style.display = "none";
        	document.getElementById("epaisseur30").style.display = "none";
            document.getElementById("epaisseur12").style.display = "block";
        }
        else if(that.value=="16") {
        	document.getElementById("epaisseur12").style.display = "none";
        	document.getElementById("epaisseur20").style.display = "none";
        	document.getElementById("epaisseur25").style.display = "none";
        	document.getElementById("epaisseur30").style.display = "none";
            document.getElementById("epaisseur16").style.display = "block";
        }
        else if(that.value=="20") {
        	document.getElementById("epaisseur12").style.display = "none";
        	document.getElementById("epaisseur16").style.display = "none";
        	document.getElementById("epaisseur25").style.display = "none";
        	document.getElementById("epaisseur30").style.display = "none";
            document.getElementById("epaisseur20").style.display = "block";
        }
        else if(that.value=="25") {
        	document.getElementById("epaisseur12").style.display = "none";
        	document.getElementById("epaisseur16").style.display = "none";
        	document.getElementById("epaisseur20").style.display = "none";
        	document.getElementById("epaisseur30").style.display = "none";
            document.getElementById("epaisseur25").style.display = "block";
        }
        else{
        	document.getElementById("epaisseur12").style.display = "none";
        	document.getElementById("epaisseur16").style.display = "none";
        	document.getElementById("epaisseur20").style.display = "none";
        	document.getElementById("epaisseur25").style.display = "none";
            document.getElementById("epaisseur30").style.display = "block";
        }
    }
</script>
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