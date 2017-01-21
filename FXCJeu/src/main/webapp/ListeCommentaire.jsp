<%@ include file="header.jsp"%>
<div class="banner-body">
	<div class="container">
		<!-- header -->
		<%@ include file="entete.jsp"%>
		<!-- //header -->

		<!-- /CECI EST UNE JSP TEST POUR TESTER LAFFICHAGE DES COMMENTAIRES BONJOUR JE VOUS EMMERDE ! <3/ -->



		<c:forEach items="${LISTE_COMMENTAIRE}" var="commentaire">
			<a href="ListeCommentaireServlet"></a>
			<span> ${commentaire.getContenuCom()} </span>
			<br>
		</c:forEach>

		<!-- portfolio -->
		<div class="portfolio">
			<h3>Les jeux de TestiJeux</h3>
			<section class="main">
				<ul class="ch-grid">
					<li>
						<div class="ch-item ch-img-1">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-1"></div>
									<div class="ch-info-back">
										<h3>
											<a href="index.jsp">WoW</a>
										</h3>
										<p>World of warcraft.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-2">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-2"></div>
									<div class="ch-info-back">
										<h3>
											<a href="index.jsp">WoW</a>
										</h3>
										<p>World of warcraft.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-3">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-3"></div>
									<div class="ch-info-back">
										<h3>Temporibus</h3>
										<p>Temporibus autem quibusdam.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</section>
			<section class="main">
				<ul class="ch-grid">
					<li>
						<div class="ch-item ch-img-4">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-4"></div>
									<div class="ch-info-back">
										<h3>officiis</h3>
										<p>Temporibus autem quibusdam.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-5">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-5"></div>
									<div class="ch-info-back">
										<h3>autem</h3>
										<p>Temporibus autem quibusdam.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-6">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-6"></div>
									<div class="ch-info-back">
										<h3>Temporibus</h3>
										<p>Temporibus autem quibusdam.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</section>
			<section class="main">
				<ul class="ch-grid">
					<li>
						<div class="ch-item ch-img-3">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-3"></div>
									<div class="ch-info-back">
										<h3>officiis</h3>
										<p>Temporibus autem quibusdam.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-1">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-1"></div>
									<div class="ch-info-back">
										<h3>autem</h3>
										<p>Temporibus autem quibusdam.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-2">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-2"></div>
									<div class="ch-info-back">
										<h3>Temporibus</h3>
										<p>Temporibus autem quibusdam.</p>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</section>
		</div>
		<!-- //portfolio -->
	</div>
</div>


</body>
</html>