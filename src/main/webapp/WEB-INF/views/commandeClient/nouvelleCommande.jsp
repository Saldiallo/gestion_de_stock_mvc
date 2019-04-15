<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Blank</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath() %>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath() %>/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/menu_left/menu_left.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <%@ include file="/WEB-INF/views/menu_top/menu_top.jsp" %>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">			
			    <div class="card o-hidden border-0 shadow-lg my-5">
			      <div class="card-body p-0">
			        <!-- Nested Row within Card Body -->
			        
			        <div class="alert alert-danger"id="wrongCodeArticle">
			        	<fmt:message code="commande.client.article.not.found" />			        	
			        </div>
			        <div class="alert alert-danger"id="choiceClient">
			        	<fmt:message code="commande.client.select.client.msfg.erreur" />			        	
			        </div>
			        
			        <div class="row">
			          <div class="col-lg-0 d-none d-lg-block"></div>
			          <div class="col-lg-12">
			            <div class="p-5">
			              <div class="text-center">
			                <h1 class="h4 text-gray-900 mb-4"><fmt:message code="commande.client.nouveau" /></h1>
			              </div>
			              <form  method="post" class="user">
			              	<div class="row">
				               <div class="col-md-4 mb-3" >
				                 <input  class="form-control form-control-user" value="${code }" id="code" disabled placeholder="codeCommande" id="exampleFirstName"/>
				               </div>			                  
				               <div class="col-md-4 mb-3">
				                  <input value="${dateCommande }" id="dateCommande"  class="form-control form-control-user" disabled id="exampleLastName" placeholder="Date"/>
				               </div>
				                
				                <div class="col-md-4 mb-3">
					                <select class="form-control" id="listeClients">
					                	<option value="-1">Selectionner un client</option>
					                	<c:forEach items="${clients }" var="client">
					                		<option value="${client.getIdClient() }">${client.getNom()}</option>
					                	</c:forEach>
					                </select>
				                </div>
			                </div>
			                <button id="btnSaveCommande" type="submit" class="btn btn-primary btn-user btn-block">
			                  <i class="fa fa-save">&nbsp;<fmt:message code="common.enregistrer" /></i>
			                </button>
			                <a href="<c:url value="/commandeClient/"/>" class="btn btn-google btn-user btn-block">
			                   <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i>
			                </a>
			              </form>
			            </div>
			          </div>
			        </div>
			      </div>
			    </div>
			    <div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								<fmt:message code="commande.client.detail" />
							</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">							
								<div id="dataTable_filter" class="form-group">
									<label class="control-label"><fmt:message code="common.article" /> :
										<input type="text" id="code_article" class="form-control form-control-sm" placeholder="Saisir le code de l'article">
									</label>
								</div>
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
									<tbody id="detailNewCommande">
										
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
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=request.getContextPath() %>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath() %>/resources/js/sb-admin-2.min.js"></script>
  
   <script	src="<%=request.getContextPath()%>/resources/myJS/commandeClient2.js"> </script>

</body>

</html>
