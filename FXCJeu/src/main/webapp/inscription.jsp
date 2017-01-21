<%@ include file="header.jsp"%>
<div class="banner-body regstr">
	<div class="container">
		<!-- header -->
		<%@ include file="entete.jsp"%>
		<!-- //header -->
		<!-- register -->

		<%
				String login_on_use = ""; // Variable qu'on appelera après si le login existe déja.
				//if (session.getAttribute("CONTROLE_INSCRIPTION") == null){
				//out.println("Bienvenu ! Veuillez vous inscrire");			
				//}
				//else 
				if (session.getAttribute("CONTROLE_INSCRIPTION") == "NOK")
				{
					login_on_use = "Ce pseudo est déja utilisé. Veuillez en choisir un autre.";
					out.println("Le login est déjà utilé ! Veuillez réessayer");
				}
			%>

		<div class="sign-up-form">
			<h3>S'enregistrer</h3>
			<p>TestiJeux sera votre moyen de faire découvrir aux autres la beauté des jeux récents ... ou pas !</p>
			<div class="sign-up">
				<form action="InscriptionServlet" method="POST"
					name="inscriptionForm">
					<h5>Informations de connexion</h5>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">Pseudo* :</h4>
						</div>
						<div class="sign-up2">
							<input type="text" placeholder=" " required name="LOGIN"
								value="<%out.print(login_on_use);%>" />
						</div>
						<div class="sign-up1">
							<h4 class="d">Password* :</h4>
						</div>
						<div class="sign-up2">
							<input type="password" placeholder=" " required name="PASSWORD" />
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
<!-- //register -->
<!-- footer -->
<%@ include file="footer.jsp"%>
<!-- //footer -->
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->

</body>
</html>