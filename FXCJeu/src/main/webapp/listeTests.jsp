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
							   <div class="alert alert-info" role="alert">
					<strong><a href="ListeJeuxServlet?action=ajout">Ajouter un test</a></strong> 
				   </div>
				   
			<div class="blog">
				<!-- Gros bloc de tests de jeux -->
				<div class="blog-left">

					<c:forEach items="${LISTE_TESTS}" var="test">
						<div class="blog-left-grid-left">
							<h3>
								<a href="TestServlet?idTest=${test.idTest}">${test.titreTest}</a>
							</h3>
						</div>
												<div class="blog-left-grid-right">
							<a href="#" class="hvr-bounce-to-bottom non">${test.getNbCom()}
								</a>
						</div> 

						<div class="clearfix"></div>

						<div class="col-xs-12 col-sm-3">
							<a href="TestServlet?idTest=${test.idTest}"><img
								src="${test.jeu.imgJeu}" alt=" "
								class="img-responsive img-rounded" /></a>
						</div>


						<p class="para">
							Jeu : <span>${test.jeu.getTitreJeu()}</span> <br> Auteur : <span>
								${test.utilisateur.getLogin()} </span><br> Date : <span>${test.dateTest}
							</span><br> Note du jeu : <span>${test.noteJeu} / 20</span><br>
							Moyenne du test : <span>${test.getMoyenne()} </span><br>
							Description : <span>${test.descriptionTest}</span>
						</p>
						<br>
						<br>

					</c:forEach>

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