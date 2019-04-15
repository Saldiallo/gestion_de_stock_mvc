<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Blank</title>

<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/menu_left/menu_left.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="/WEB-INF/views/menu_top/menu_top.jsp"%>
				<!-- End of Topbar -->

				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">
						<fmt:message code="common.client.commande" />
					</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value="/commandeClient/nouveau"/>"> <i
									class="fa fa-plus">&nbsp;<fmt:message code="common.ajouter" /></i></a>
							</li>
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-download">&nbsp;<fmt:message
											code="common.exporter" /></i></a></li>
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-upload">&nbsp;<fmt:message
											code="common.importer" /></i></a></li>
						</ol>
					</nav>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								<fmt:message code="commande.client.liste" />
							</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>

										<tr>
											<th><fmt:message code="common.code" /></th>
											<th><fmt:message code="common.date" /></th>
											<th><fmt:message code="common.client" /></th>
											<th><fmt:message code="common.total" /></th>
											<th><fmt:message code="common.actions" /></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${commandeClients }" var="cmdCli">
											<tr>
												<td>${cmdCli.getCode() }</td>
												<td>${cmdCli.getDateCommandeClient() }</td>
												<td>${cmdCli.getClient().getNom() }</td>
												<td>${cmdCli.getTotalCommande() }</td>
												<td class="center">
													<textArea id = "json${cmdCli.getIdCommandeClient() }" style="display: none;">${cmdCli.getLigneCommandeJson() }  </textArea>
													<a href="javascript:void(0)" onclick="updateDetailCommande(${cmdCli.getIdCommandeClient() });">
														<i class="fa fas fa-info-circle"></i></a> &nbsp;||&nbsp;
													 <c:url value="/commandeClient/modifier/${cmdCli.getIdCommandeClient() }" var="modifComClient" />
													 <a href="${modifComClient }"><i class="fa fa-edit"></i></a> &nbsp;||&nbsp; <a href="#"
													data-backdrop="static" data-toggle="modal"
													data-target="#modalClient${cmdCli.getIdCommandeClient()}"><i
														class="fa fa-trash"></i></a>
													<div class="modal fade"
														id="modalClient${cmdCli.getIdCommandeClient()}" tabindex="-1"
														role="dialog" aria-labelledby="exampleModalCenterTitle"
														aria-hidden="true">
														<div class="modal-dialog modal-dialog-centered"
															role="document">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLongTitle">
																		<fmt:message code="common.confirmer" />
																	</h5>
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																<div class="modal-body">
																	<fmt:message code="common.confirm.supp" />
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-dismiss="modal">
																		&nbsp;
																		<fmt:message code="common.annuler" />
																	</button>
																	<c:url
																		value="/commandeClient/supprimer/${cmdCli.getIdCommandeClient() }"
																		var="delClient" />
																	<a href="${delClient }" type="button"
																		class="btn btn-danger"> <i class="fa fa-trash"></i>&nbsp;&nbsp;<fmt:message
																			code="common.enregistrer" />
																	</a>
																</div>
															</div>
														</div>
													</div>
													</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					
					
					<div id="cache" class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								<fmt:message code="commande.client.detail" />
							</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>

										<tr>
											<th><fmt:message code="common.article" /></th>
											<th><fmt:message code="common.qte" /></th>
											<th><fmt:message code="common.prixUnitTTC" /></th>
											<th><fmt:message code="common.total" /></th>
											<th><fmt:message code="common.actions" /></th>
										</tr>
									</thead>
									<tbody id="detailCommande">
										
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>

				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for all pages-->
	<!-- Custom scripts for all pages-->
	<%-- 	<script	src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script> --%>

	<!-- Core plugin JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Custom scripts for all pages-->
	<%-- 	<script	src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script> --%>
	<script
		src="<%=request.getContextPath()%>/resources/js/demo/datatables-demo.js"></script>
		
		<script	src="<%=request.getContextPath()%>/resources/myJS/commandeClient.js"> </script>

</body>

</html>
