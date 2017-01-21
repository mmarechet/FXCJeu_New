<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<!-- header -->
		<%@ include file="entete.jsp"%>
		<div class="header-bottom">
			<div class="header-bottom-top">
				<br>
	
	<p>Chemin image : ${CHEMIN}</p><br>

	<c:forEach items="${LISTE_IMAGE}" var="image">
		<p>ID : ${image.idImage} <br> Nom Image : ${image.cheminImage}</p>
		<img alt="Si pas trouvé (Chemin+Nom) : ${CHEMIN}${image.cheminImage}" src="${CHEMIN}${image.cheminImage}" HEIGHT=100 WIDTH=100></img>
		<br><br>
	</c:forEach>
	
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
		
	<div class="clearfix"></div>
</div>
<%@ include file="footer.jsp"%>
<!-- <p>
		<%//String message = "Connexion réussi. Bienvenue "+ session.getAttribute("LOGIN");
			//out.println(message);%>
	</p> -->
</body>
</html>