<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<!-- header -->
		<%@ include file="entete.jsp"%>
		<div class="header-bottom">
			<div class="header-bottom-top">
				<br>
			</div>
			<div class="clearfix"></div>
			<div class="blog">
				<!-- Gros bloc de tests de jeux -->
				<div class="blog-left">
					<h1> Création d'un test</h1>
					<form action="AjoutTestServlet"  method="POST"
						name="formulaireAjoutTest" class="form-style-7">
						<ul>
							<li>
								<label>Jeu</label> 
								<select name="jeux">
										<c:forEach var="JEU" items="${ListeJeu}">
											<option value="${JEU.idJeu}">${JEU.titreJeu}</option>
										</c:forEach>
								</select> 
								<span>Sélectionnez le jeu testé.</span>
							</li>

							<li>
								<label>Titre</label> 
								<input type="text" name="titre" required="obligatoire">
								<span>Entrez ici le titre du jeu.</span>
							</li>
							
							<li>
								<label>Description</label> 
								<textarea name="description" rows="8" cols="50" onkeyup="adjust_textarea(this)" required="obligatoire"></textarea> 
								<span>Entrez ici la description du test.</span>
							</li>
							
							
							<li>
								<label>Contenu</label> 
								<textarea name="contenu" rows="8" cols="50" onkeyup="adjust_textarea(this)" required="obligatoire"></textarea> 
								<span>Entrez ici le contenu du test.</span>
							</li>
							
							<li>
							<label>Avantage</label> 
							<input type="text" name="avantage" required="obligatoire">
							<span>Entrez ici le principal avantage du jeu.</span>
							</li>
							
							<li>
								<label>Inconvénient</label> 
								<input type="text" name="inconvenient" required="obligatoire"> 
								<span>Entrez ici le principal inconvénient du jeu.</span>
							</li>

							<li>
							<label>Note</label> 
								<select name="notes">
									<c:forEach begin="0" end="20" var="i">
										<option  value="${i}">${i}</option>
									</c:forEach>
								</select> 
								<span>Selectionnez la note du jeu.</span>
							</li>
							
							<input type="hidden" name="auteur" value="${idUtilisateur}">
							
							<label>Ajouter des images :</label>
							<input type="file" name="NOM_IMAGE" multiple>

							<li><input type="submit" value="Envoyer"></li>
						</ul>

					</form>
				</div>
			</div>


		</div>
		<div class="clearfix"></div>
	</div>
</div>
<%@ include file="footer.jsp"%>
<!-- <p>
		<%//String message = "Connexion réussi. Bienvenue "+ session.getAttribute("LOGIN");
			//out.println(message);%>
	</p> -->
</body>
</html>