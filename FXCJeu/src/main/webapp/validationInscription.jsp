<%@page import="java.util.TimerTask"%>
<%@page import="java.util.Timer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Quickly Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 





</script>
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>

<script src="js/classie.js"></script>
<script src="js/uisearch.js"></script>
<script>
	new UISearch(document.getElementById('sb-search'));
</script>

<script src="js/responsiveslides.min.js"></script>
<script>
	// You can also use "$(window).load(function() {"
	$(function() {
		// Slideshow 4
		$("#slider3").responsiveSlides({
			auto : true,
			pager : false,
			nav : true,
			speed : 500,
			namespace : "callbacks",
			before : function() {
				$('.events').append("<li>before event fired.</li>");
			},
			after : function() {
				$('.events').append("<li>after event fired.</li>");
			}
		});

	});
</script>


<script type="text/javascript">
	$(window).load(function() {
		$("#flexiselDemo1").flexisel({
			visibleItems : 3,
			animationSpeed : 1000,
			autoPlay : false,
			autoPlaySpeed : 3000,
			pauseOnHover : true,
			enableResponsiveBreakpoints : true,
			responsiveBreakpoints : {
				portrait : {
					changePoint : 480,
					visibleItems : 1
				},
				landscape : {
					changePoint : 640,
					visibleItems : 2
				},
				tablet : {
					changePoint : 768,
					visibleItems : 3
				}
			}
		});

	});
</script>
<script type="text/javascript" src="js/jquery.flexisel.js"></script>

<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true
		// 100% fit in a container
		});
	});
</script>

<script src="js/jquery.swipebox.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {
		$(".swipebox").swipebox();
	});
</script>

<link rel="stylesheet" href="css/swipebox.css" type="text/css"
	media="all" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="refresh" content="2; URL=index.jsp">
<title>Validation de l'inscription</title>
</head>
<body>
	<div class="banner-body logn">
		<div class="container">
			<h2>
				Félicitations votre inscription a réussi !!! <br> <br>
				Vous allez être redirigé vers la page de connexion dans quelques
				secondes ...
			</h2>
		</div>
	</div>

</body>
</html>