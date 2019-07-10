<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Epaisseur</title>
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
	<style>
table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
table#t01 th {
  background-color: black;
  color: white;
}
</style>
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
            <a href="Predimensionnement" class="active"><u><b>Prédimensionnement</b></u></a>
          </li>
             <li>
            <a href="Hypotheses" class="active">Hypothéses</a>
          </li>
             <li>
            <a href="Ask" class="active">Posez une question</a>
          </li>
          <li>
            <a href="Contact" class="active">Contact</a>
          </li>
             <li>
           <a href="Plaquette" class="active">Plaquette</a>
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
					<br><h3 class="txt-w3_agile" data-aos="fade-down">Epaisseur du plancher</h3>
				</div>
		</div>
	</div>
	</div>
	<!-- //banner -->
	
</header>
<h3 class="text-center">Charge : ${charge} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Portee : ${portee}</h3>
<section class="contact py-5" id="contact">

	<div class="container py-lg-3">

				<table id="t01">
  <tr>
    <th>Travées</th>
    <th>Poutrelles</th> 
    <th>Epaisseur</th>
  </tr>
  <tr>
    <td rowspan="2">Isostatique</td>
    <td>Simple</td>
    
    <td>
    <c:choose>
	    <c:when test="${empty resultat.get(0)}">
	        Aucune valeur
	    </c:when>    
	    <c:otherwise>
	         ${resultat.get(0).get(0).get(0)} &nbsp;+&nbsp; ${resultat.get(0).get(0).get(1)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a data-aos="fade-up" href="#" data-toggle="modal" data-target="#exampleModalCenter1" role="button"><i class="fas mr-2 fa-plus-square"></i></a> 
	    </c:otherwise>
	</c:choose>
	</td>
  
    
  </tr>
  <tr>
    <td>Jumelée</td>
    <td>
    <c:choose>
	    <c:when test="${empty resultat.get(1)}">
	        Aucune valeur
	    </c:when>    
	    <c:otherwise>
	         ${resultat.get(1).get(0).get(0)} &nbsp;+&nbsp; ${resultat.get(1).get(0).get(1)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a data-aos="fade-up" href="#" data-toggle="modal" data-target="#exampleModalCenter2" role="button"><i class="fas mr-2 fa-plus-square"></i></a> 
	    </c:otherwise>
	</c:choose>
	</td>
  </tr>
  <tr>
    <td rowspan="2">Continue</td>
    <td>Simple</td>
    <td>
    <c:choose>
	    <c:when test="${empty resultat.get(2)}">
	        Aucune valeur
	    </c:when>    
	    <c:otherwise>
	         ${resultat.get(2).get(0).get(0)} &nbsp;+&nbsp; ${resultat.get(2).get(0).get(1)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a data-aos="fade-up" href="#" data-toggle="modal" data-target="#exampleModalCenter3" role="button"><i class="fas mr-2 fa-plus-square"></i></a> 
	    </c:otherwise>
	</c:choose>
	</td>
  </tr>
   <tr>
    
    <td>Jumelée</td>
    <td>
    <c:choose>
	    <c:when test="${empty resultat.get(3)}">
	        Aucune valeur
	    </c:when>    
	    <c:otherwise>
	         ${resultat.get(3).get(0).get(0)} &nbsp;+&nbsp; ${resultat.get(3).get(0).get(1)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a data-aos="fade-up" href="#" data-toggle="modal" data-target="#exampleModalCenter4" role="button"><i class="fas mr-2 fa-plus-square"></i></a> 
	    </c:otherwise>
	</c:choose>
	</td>
  </tr>
</table>
<div class="click text-center mt-3">
				<a href="Epaisseur"><button type="button" class="btn btn-primary">Retour</button></a>
			</div>
			
	</div>
<!-- //contact -->
</section>
<!-- //header -->
<div class="modal fade" id="exampleModalCenter1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenter1" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-capitalize text-center" id="exampleModalLongTitle">Autres résultats</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:forEach var="table1" items="${resultat.get(0)}" begin="1">
        			<c:out value="${table1.get(0)} + ${table1.get(1) }" /><br>
				</c:forEach>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenter1" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-capitalize text-center" id="exampleModalLongTitle">Autres résultats</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:forEach var="table2" items="${resultat.get(1)}" begin="1">
        			<c:out value="${table2.get(0)} + ${table2.get(1) }" /><br>
				</c:forEach>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="exampleModalCenter3" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenter1" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-capitalize text-center" id="exampleModalLongTitle">Autres résultats</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:forEach var="table3" items="${resultat.get(2)}" begin="1">
        			<c:out value="${table3.get(0)} + ${table3.get(1) }" /><br>
				</c:forEach>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="exampleModalCenter4" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenter1" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-capitalize text-center" id="exampleModalLongTitle">Autres résultats</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:forEach var="table4" items="${resultat.get(3)}" begin="1">
        			<c:out value="${table4.get(0)} + ${table4.get(1) }" /><br>
				</c:forEach>
			</div>
			<div class="modal-footer">
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