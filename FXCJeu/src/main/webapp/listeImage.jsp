<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<%@ include file="entete.jsp"%>
		<div class="header-bottom">
			<div class="header-bottom-top">
				<br>
			</div>
			<div class="clearfix"></div>

			<div class='center'>
				<c:if test="${!empty LISTE_IMAGE}">
					<c:forEach items="${LISTE_IMAGE}" var="image">

						<img class="img-responsiveTest center-block"
							alt="Si pas trouvé (Chemin+Nom) : ${CHEMIN}${image.cheminImage}"
							src="images/${image.cheminImage}"></img>

						<br>
					</c:forEach>
				</c:if>
				<c:if test="${empty LISTE_IMAGE}">
					<img class="img-responsiveTest center-block"
						src="images/img_non_dispo.jpg"></img>
					<div class="alert alert-danger" role="alert">
						<strong>Désolé ...</strong> L'auteur n'a pas ajouté d'images à son test!
					</div>
				</c:if>
			</div>
		</div>

	</div>
</div>
<%@ include file="footer.jsp"%>

</body>
</html>
