<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<%@ include file="entete.jsp"%>

		<c:set var="dejaNote" scope="session" value="false" />

		<c:set var="auteur" scope="session" value="${idUtilisateur}" />


		<%-- 		<c:out value="${auteur}" /> --%>
		<c:set var="auteur1" scope="session"
			value="${TEST.utilisateur.getIdUtilisateur()}" />
		<%-- 		<c:out value="${auteur1}" /> --%>


		<div class="single-page-artical">
			<div class="artical-content">

				<h3>${TEST.titreTest}</h3>
				<img class="img-responsiveTest"
					src="images/imgTests/${TEST.jeu.idJeu}.jpg" alt=" " />

			</div>



			<div class="Buttons test-align-center">
				<h3 class="ghj">
					<a href="TeleversementServlet?idTest=${TEST.idTest}">Voir les
						images du test</a>
				</h3>
				<br>
				<h3 class="ghj">Caractéristiques du jeu</h3>
				<h3>
					<span class="label label-default">Editeur :
						${TEST.jeu.editeur.getRaisonSociale()}</span> <span
						class="label label-primary">Développeur :
						${TEST.jeu.developpeur.getRaisonSociale()}</span> <span
						class="label label-success">Genre :
						${TEST.jeu.genre.getLibelleGenre()}</span> <span class="label label-info">Classification
						: ${TEST.jeu.classification.getLibelleClassification()}</span>
				</h3>

				<h3>
					<span class="label label-warning">Support :</span>
					<c:forEach items="${TEST.jeu.listeSupports}" var="support">
						<span class="label label-warning">${support.getLibelleSupport()}</span>
					</c:forEach>
				</h3>
				<h3>
					<span class="label label-new">Modèle économique :</span>
					<c:forEach items="${TEST.jeu.listeModeleEconomiques}"
						var="modeleEco">
						<span class="label label-new">${modeleEco.getLibelleModeleEco()}</span>
					</c:forEach>
				</h3>

				<h3>
					<c:forEach items="${TEST.jeu.listePlateformes}" var="plateforme">
						<span class="label label-danger">${plateforme.getLibellePlateforme()}</span>
					</c:forEach>
				</h3>
			</div>

			<p>${TEST.contenuTest}</p>


			<div class="artical-links">
				<ul>
					<li><small> </small><span>${TEST.dateTest} </span></li>

					<li><small class="admin"> </small><span>${TEST.utilisateur.getLogin()}</span></li>
				</ul>
			</div>
			<br>
			<div class="alert alert-success" role="alert">
				<strong>Avantages</strong> ${TEST.avantageJeu}
			</div>

			<div class="alert alert-danger" role="alert">
				<strong>Inconvénients</strong> ${TEST.inconvenientJeu}
			</div>

			<div class="artical-commentbox">

				<c:if test="${auteur == auteur1}">
					<!-- Permet d'ajouter des images seulement si on est l'auteur du test -->
					<h3>Ajouter des images aux test.</h3>

					<div class="table-form">
						<form action="TeleversementServlet" enctype="multipart/form-data"
							method="POST" name="formulaireTeleversement">
							<input type="hidden" name="ID_TEST" value="${TEST.idTest}">
							<input type="file" name="NOM_IMAGE" multiple> <br> <input
								type="submit" name="submit" id="sumbit" value="Envoyer">
						</form>
					</div>
				</c:if>
				<br>
			</div>

			<div class="comment-grid-top">
				<h3>Commentaires</h3>

				<c:forEach items="${TEST.getListeCommentaires()}" var="commentaire">
					<c:if test="${auteur == commentaire.utilisateur.idUtilisateur}">
						<c:set var="dejaNote" scope="session" value="true" />
					</c:if>
					<div class="comments-top-top top-grid-comment">
						<div class="top-comment-right">
							<ul>
								<li><span class="left-at">${commentaire.utilisateur.login}</span></li>
								<li><span class="right-at">${commentaire.dateCom}</span></li>
								<li><button class="reply" type="button"
										onclick="toggle_div(this,'commentaire-${commentaire.idCom}');">Répondre</button></li>
								<div id="commentaire-${commentaire.idCom }"
									style="display: none;">
									<form name="ReponseCommentaireServlet"
										action="CommentaireServlet" method="POST">
										<input type="hidden" name="Utilisateur"
											value="${idUtilisateur}"> <input type='hidden'
											name="Test" value="${TEST.idTest}"> <input
											type="hidden" name="Commentaire"
											value="${commentaire.idCom }">
										<textarea rows="3" cols="50" name="ContenuReponse"></textarea>
										<input type="submit" value="Envoyer">
									</form>
								</div>
							</ul>
							<p>${commentaire.contenuCom}</p>
						</div>
						<div class="clearfix"></div>

						<c:forEach items="${commentaire.getListeCommentairesReponses()}"
							var="commentaireReponse">
							<div class="comments-top-top top-grid-comment">
								<div class="top-comment-right">
									<ul>
										<li><span class="left-at">${commentaireReponse.utilisateur.login}</span></li>
										<li><span class="right-at">${commentaireReponse.dateCom}</span></li>
									</ul>
									<p>${commentaireReponse.contenuCom}</p>
									<div class="clearfix"></div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
			</div>



			<div class="artical-commentbox">
				<c:if test="${auteur != auteur1}">


					<h3>Laisser un commentaire</h3>
					<div class="table-form">
						<form name="CommentaireServlet" action="CommentaireServlet"
							method="POST">
							<input name="AuteurComm" type="text" class="textbox"
								value="${loginUtilisateur}" readOnly="readOnly"> <input
								type="hidden" name="Utilisateur" value="${idUtilisateur}">
							<input type='hidden' name="Test" value="${TEST.idTest}">
							<textarea name="ContenuCom"
								placeholder="Saisir ici votre commentaire."></textarea>
							<c:if test="${dejaNote==false}">
							<br>
								<label>Noter le test</label>
								<select name="notes">
									<c:forEach begin="1" end="5" var="i">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select>
							</c:if>
							<input type="submit" value="Envoyer">
						</form>
					</div>
				</c:if>
			</div>

			<!-- single -->
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
<script src="js/bootstrap.js"></script>
</body>
</html>