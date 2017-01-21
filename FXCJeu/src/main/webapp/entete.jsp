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

				<c:choose>
					<c:when test="${CONTROLE_CONNEXION eq'OK'}">
						<a class="navbar-brand" href="accueil.jsp"><span>T</span>estiJeux</a>
					</c:when>
					<c:otherwise>
						<a class="navbar-brand" href="index.jsp"><span>T</span>estiJeux</a>
					</c:otherwise>
				</c:choose>



			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse nav-wil"
				id="bs-example-navbar-collapse-1">
				<c:if test="${CONTROLE_CONNEXION eq'OK'}">
					<ul class="nav navbar-nav">

						<li class="hvr-bounce-to-bottom"><a href="ListeTestsServlet">Les
								tests</a></li>
						<li class="hvr-bounce-to-bottom"><a href="ListeJeuxServlet">Les
								jeux </a></li>
						<li class="hvr-bounce-to-bottom"><a href="ListeCommentaireServlet">Les
								Commentaires</a></li>
					</ul>
				</c:if>
				<div class="sign-in">
					<c:choose>
						<c:when test="${CONTROLE_CONNEXION eq'OK'}">
							<ul>
								<li><a href="DeconnexionServlet">Déconnexion</a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul>
								<li><a href="inscription.jsp"
									class="hvr-bounce-to-bottom button">Créer un compte</a>
							</ul>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</nav>
	</div>
	<!-- search-scripts -->
	<script src="js/classie.js"></script>
	<script src="js/uisearch.js"></script>
	<script>
		new UISearch(document.getElementById('sb-search'));
	</script>
</div>
