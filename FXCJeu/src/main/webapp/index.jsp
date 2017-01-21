<%@ include file="headerIndex.jsp"%>

<body>
<a href="image.jsp">Ajouter une image</a>
<a href="TeleversementServlet">Voir les images</a>
	<!-- banner-body -->
	<div class="banner-body logn">
		<div class="container">
			<!-- header -->
			<%@ include file="enteteIndex.jsp"%>
			<!-- search-scripts -->
			<script src="js/classie.js"></script>
			<script src="js/uisearch.js"></script>
			<script>
				new UISearch(document.getElementById('sb-search'));
			</script>
			<!-- //search-scripts -->
			<!-- //header -->
			<!-- login-page -->

			<div class="login">
				<div class="login-grids">
					<div class="col-md-6 log">
						<h3>S'identifier</h3>
						<p>Bienvenue, veuillez saisir vos informations de connexion
							pour continuer</p>
						<!-- <p>If you have previously Login with us, <a href="#">click here</a></p> -->
						<form action="LoginServlet" method="POST"
							name="formulaireConnexion">

							<!--  A GARDER -->
							<c:if test="${CONTROLE_CONNEXION eq'NOK'}">
								<div class="alert alert-danger" role="alert">
									<strong>Erreur</strong> La combinaison est incorrecte.
								</div>
							</c:if>

							<h5>Pseudo :</h5>
							<input type="text" name="LOGIN" id="LOGIN" value="${LOGIN}">
							<h5>Mot de passe :</h5>
							<input type="password" name="PASSWORD" id="PASSWORD"
								value="${MDP}"> <br> <label for="MEMOIRE">Se
								souvenir de moi</label> <input type="checkbox" id="MEMOIRE"
								name="MEMOIRE"
								<c:if test="${MEMOIRE eq'OK'}">
									checked
								</c:if> />
							<br> <br> <input type="submit" name="submit"
								id="sumbit" value="Se connecter"> <br>

						</form>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- //login-page -->
			</div>
		</div>
	</div>
	<!--  footer -->
	<%@ include file="footer.jsp"%>
	<!-- footer -->
	<!-- for bootstrap working -->
	<script src="js/bootstrap.js">
		
	</script>
	<!-- //for bootstrap working -->
</body>
</html>