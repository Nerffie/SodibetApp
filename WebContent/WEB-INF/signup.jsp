<!DOCTYPE html>
<html lang="en">
<head>
<title>Inscription</title>
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
        <ul class="text-center text-capitalize nav-agile" data-aos="zoom-in-up">
          <li>
            <a href="Login"><button  type="button" class="btn w3ls-btn" >
              Login
            </button></a>
          </li>
        </ul>
      </div>
    </nav>
    <!-- //nav -->
	<!-- banner -->
	<div class="banner layer" id="home">
		<div class="container">
			<div class="row banner-text" >
				<div class="col-lg-4 col-md-2 mt-lg-0 mt-5 banner-form" data-aos="fade-right"></div>
				<div class="col-lg-4 col-md-8 mt-lg-0 mt-5 banner-form" data-aos="fade-left">
				<br>
					<h5><i class="fas mr-2 fa-laptop"></i>Cr�er un compte</h5>
					<br>
					<form action="#" class="mt-4" method="post">
					<table>
					<tr>
					<td><input class="form-control" type="text" name="prenom" placeholder="* Pr�nom" required/></td>
					<td><input class="form-control" type="text" name="nom" placeholder="* Nom" required/></td>
					</tr>
					</table>
					<input class="form-control" type="email" name="email" placeholder="* Email" required/>
					<span class="erreur">${form.erreurs['email']}</span>
					
					<input class="form-control" type="password" name="password" placeholder="* Mot de passe" required/>
					<span class="erreur">${form.erreurs['password']}</span>
					<input class="form-control" type="password" name="password_confirmation" placeholder="* Confirmer mot de passe" required />
					<span class="erreur">${form.erreurs['password_confirmation']}</span>
					
					<input class="form-control" type="text" name="ville" placeholder="* Ville" required/>
					<label class ="form-control "for="dateNaissance">Date de naissance (facultatif)</label>
					<input class="form-control" id = "dateNaissance"type="date" name="date_naissance" placeholder="Date de naissance"/><br>
					<!--  <td><label class="form-control" for="categorie">S�lectionnez cat�gorie</label></td>-->
					
					<select class="form-control" name="categorie" id="categorie" onchange="sous_categorie_show(this);" required>
						<option class="form-control" value="architecte">Architecte
						<option class="form-control" value="ingenieur">Ing�nieur
					</select>
					
					
					<!--  <td><label class="form-control" for="sous_categorie">Sp�cifiez votre choix</label></td>-->
					<div>
							<select class="form-control" name="sous_categorie_architecte" id="sous_categorie_architecte" style="display: block;">
								<option class="form-control">Agence et bureaux d'architectures
								<option class="form-control">Eleve architecte
							</select>
					</div>
					<div>
							<select style="display: none;" class="form-control" name="sous_categorie_ingenieur" id="sous_categorie_ingenieur">
								<option class="form-control">Bureaux d'�tude
								<option class="form-control">Bureaux de contr�le
								<option class="form-control">Entreprise de construction
								<option class="form-control">Laboratoires
								<option class="form-control">Eleves ing�nieurs
							</select>
					</div>
					<br>
					
					
					
					
						<input class="form-control text-capitalize" type="submit" value="Inscription">
					</form>
						<br><br><br><br><br><br>
				</div>
			</div>
		</div>
	</div>
	<!-- //banner -->

</header>
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
    <script>
    //Script pour afficher les options personnalis�es selon l'option de select choisi
    function sous_categorie_show(that) {
        /*if (that.value == "architecte") {
            document.getElementById("sous_categorie_architecte").style.display = "block";
            document.getElementById("sous_categorie_ingenieur").style.display = "none";
        } else*/ 
        if(that.value=="ingenieur") {
            document.getElementById("sous_categorie_architecte").style.display = "none";
            document.getElementById("sous_categorie_ingenieur").style.display = "block";
        }
        else{
        	document.getElementById("sous_categorie_architecte").style.display = "block";
            document.getElementById("sous_categorie_ingenieur").style.display = "none";
        }
    }
</script>
    <!-- //end-smoth-scrolling -->

</body>
</html>