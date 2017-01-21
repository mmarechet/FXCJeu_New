<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
	<div class="header-nav">
		<nav class="navbar navbar-default">
			<!-- Le toggle, c'est le menu sur mobile -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>


				<a class="navbar-brand" href="index.jsp"><span>T</span>estiJeux</a>



			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse nav-wil"
				id="bs-example-navbar-collapse-1">
				<div class="sign-in">

					<ul>
						<li><a href="inscription.jsp"
							class="hvr-bounce-to-bottom button">Créer un compte</a>
					</ul>

				</div>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>
	<!-- search-scripts -->
	<script src="js/classie.js"></script>
	<script src="js/uisearch.js"></script>
	<script>
		new UISearch(document.getElementById('sb-search'));
	</script>
	<!-- //search-scripts -->
</div>
