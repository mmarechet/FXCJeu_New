<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<!-- header -->
		<%@ include file="entete.jsp"%>
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
</div>


</body>
</html>