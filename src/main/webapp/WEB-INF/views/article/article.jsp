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
						<fmt:message code="common.article" />
					</h1>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value="/article/nouveau"/>"> <i
									class="fa fa-plus">&nbsp;<fmt:message code="common.ajouter" /></i></a>
							</li>
							<li class="breadcrumb-item"><a href="<c:url value="/article/export"/>"><i class="fa fa-download">&nbsp;<fmt:message
											code="common.exporter" /></i></a></li>
							<li class="breadcrumb-item"><a href="<c:url value="/article/exportToPDF"/>"><i class="fa fa-file-pdf">&nbsp;</i></a></li>			
							
							<li class="breadcrumb-item">
								
								<a href="#"><i
									class="fa fa-upload">&nbsp;<fmt:message
											code="common.importer" /></i>
								</a>
							</li>
							<li class="breadcrumb-item">
								<c:url value="/article/import" var="ulrEnregister"/>
			              		<f:form modelAttribute="article" action="${ulrEnregister }" method="post" enctype="multipart/form-data" class="user">
			              		
			              		</f:form>
							</li>
						</ol>
					</nav>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								<fmt:message code="common.article" />
							</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>

										<tr>
											<th><fmt:message code="common.photo" /></th>
											<th><fmt:message code="common.code" /></th>
											<th><fmt:message code="common.designation" /></th>
											<th><fmt:message code="common.prixUnitHT" /></th>
											<th><fmt:message code="common.tva" /></th>
											<th><fmt:message code="common.prixUnitTTC" /></th>
											<th><fmt:message code="article.categorie" /></th>
											<th><fmt:message code="common.actions" /></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${articles }" var="article">
											<tr>
												<td><img alt="" src="${article.getPhoto() }" width="50"
													height="50"></td>
												<td>${article.getCodeArticle() }</td>
												<td>${article.getDesignation() }</td>
												<td class="center">${article.getPrixUnitaireHT() }</td>
												<td class="center">${article.getTaux() }</td>
												<td class="center">${article.getPrixUnitaireTTC() }</td>
												<td class="center">${article.categorie.getCodeCat() }</td>
												<td class="center"><c:url
														value="/article/modifier/${article.getIdArticle() }"
														var="modifArticle" /> <a href="${modifArticle }"><i
														class="fa fa-edit"></i></a> &nbsp;||&nbsp; <a href="#"
													data-backdrop="static" data-toggle="modal"
													data-target="#modalArticle${article.getIdArticle()}"><i
														class="fa fa-trash"></i></a>
													<div class="modal fade"
														id="modalArticle${article.getIdArticle()}" tabindex="-1"
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
																		value="/article/supprimer/${article.getIdArticle() }"
																		var="delArticle" />
																	<a href="${delArticle }" type="button"
																		class="btn btn-danger"> <i class="fa fa-trash"></i>&nbsp;&nbsp;<fmt:message
																			code="common.enregistrer" />
																	</a>
																</div>
															</div>
														</div>
													</div></td>
											</tr>
										</c:forEach>
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

</body>

</html>
