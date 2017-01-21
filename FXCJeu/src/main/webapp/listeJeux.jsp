<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<%@ include file="entete.jsp"%>
		<c:forEach items="${LISTE_JEUX}" var="jeu">
			<section class="main">
				<ul class="ch-grid">
					<li>
						<div class="ch-item jeu${jeu.idJeu}">
							<!-- </style> -->
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front jeu${jeu.idJeu}"></div>
									<div class="ch-info-back">
										<h3>
											<a href="ListeTestsServlet?idJeu=${jeu.idJeu}&action=jeu">Voir
												les tests du jeu</a>
										</h3>
										<p>
											<a href="JeuServlet?idJeu=${jeu.idJeu}">${jeu.titreJeu}</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</section>
		</c:forEach>
	</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>