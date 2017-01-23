<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<%@ include file="entete.jsp"%>

		<%-- 
		<!-- //header -->
		<p>ID : ${JEU.idJeu}</p>
		<p>Titre : ${JEU.titreJeu}</p>
		<p>Date : ${JEU.dateSortieJeu}</p>
		<p>Description : ${JEU.description}</p>
		<p>Class : ${JEU.classification.getLibelleClassification()}</p>
		<p>Editeur : ${JEU.editeur.getRaisonSociale()}</p>
		<p>Genre : ${JEU.genre.getLibelleGenre()}</p>
		<p>Dev : ${JEU.developpeur.getRaisonSociale()}</p>
		<p>
			Support :
			<c:forEach items="${JEU.listeSupports}" var="support">
		${support.getLibelleSupport()},
		</c:forEach>
		</p>
		<p>
			Plateforme :
			<c:forEach items="${JEU.listePlateformes}" var="plateforme">
		${plateforme.getLibellePlateforme()},
		</c:forEach>
		</p>

		<p>
			Modele Economique :
			<c:forEach items="${JEU.listeModeleEconomiques}"
				var="modeleEconomique">
		${modeleEconomique.getLibelleModeleEco()},
		</c:forEach>
		</p>
		<BR> <a href="javascript:history.go(-1)">Retour</a>
	</div>
</div> --%>


		<div class="single-page-artical">
			<div class="artical-content">

				<h3>${JEU.titreJeu}</h3>
				<img class="img-responsiveTest"
					src="images/imgTests/${JEU.idJeu}.jpg" alt=" " />

			</div>



			<div class="Buttons test-align-center">

				<h3 class="ghj">Caractéristiques du jeu</h3>
				<h3>
					<span class="label label-default">${JEU.editeur.getRaisonSociale()}</span>
					<span class="label label-primary">${JEU.developpeur.getRaisonSociale()}</span>
					<span class="label label-success">${JEU.genre.getLibelleGenre()}</span>
					<span class="label label-info">${JEU.classification.getLibelleClassification()}</span>
				</h3>

				<h3>
					<c:forEach items="${JEU.listeSupports}" var="support">
						<span class="label label-warning">${support.getLibelleSupport()}</span>
					</c:forEach>
					<c:forEach items="${JEU.listeModeleEconomiques}" var="modeleEco">
						<span class="label label-new">${modeleEco.getLibelleModeleEco()}</span>
					</c:forEach>
				</h3>

				<h3>
					<c:forEach items="${JEU.listePlateformes}" var="plateforme">
						<span class="label label-danger">${plateforme.getLibellePlateforme()}</span>
					</c:forEach>
				</h3>
			</div>

			<p>${JEU.description}</p>


			<div class="artical-links">
				<ul>
					<li><small> </small><span>Date de sortie :</span></li>
					<li><small> </small><span>${JEU.dateSortieJeu} </span></li>

				</ul>
			</div>
		</div>

	</div>
</div>

		<%@ include file="footer.jsp"%>
</body>
</html>