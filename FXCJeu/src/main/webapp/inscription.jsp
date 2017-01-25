<%@ include file="header.jsp"%>
<div class="banner-body regstr">
	<div class="container">
		<%@ include file="entete.jsp"%>


		<div class="sign-up-form">
			<h3>S'enregistrer</h3>
			<p>TestiJeux sera votre moyen de faire découvrir aux autres la
				beauté des jeux récents ... ou pas !</p>
			<div class="sign-up">
				<form action="InscriptionServlet" method="POST"
					name="inscriptionForm">
					<h5>Informations de connexion</h5>
					<c:if test="${CONTROLE_INSCRIPTION eq'NOK'}">
						<div class="alert alert-danger" role="alert">
							<strong>Erreur</strong> Le login est déjà utilisé. Veuillez en choisir un autre.
						</div>
					</c:if>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">Pseudo* :</h4>
						</div>
						<div class="sign-up2">
							<input type="text" placeholder=" " required name="LOGIN" maxlength="30"
								value="${LOGIN}" />
						</div>
						<div class="sign-up1">
							<h4 class="d">Password* :</h4>
						</div>
						<div class="sign-up2">
							<input type="password" placeholder=" " required maxlength="30" name="PASSWORD" />
						</div>
						<div class="clearfix"></div>
					</div>

					<input type="submit" value="S'inscrire">
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
<script src="js/bootstrap.js"></script>

</body>
</html>