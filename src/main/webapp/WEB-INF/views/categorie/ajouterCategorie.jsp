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
			        <div class="row">
			          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
			          <div class="col-lg-7">
			            <div class="p-5">
			              <div class="text-center">
			                <h1 class="h4 text-gray-900 mb-4"><fmt:message code="categorie.nouveau" /></h1>
			              </div>
			              <c:url value="/categorie/enregistrer" var="ulrEnregister"/>
			              <f:form modelAttribute="categorie" action="${ulrEnregister }" method="post" class="user">
			                <f:hidden path="idCategorie"/>
			                <div class="form-group row">
			                  <div class="col-sm-6 mb-3 mb-sm-0">
			                  	<f:label path="codeCat"><fmt:message code="categorie.code" /></f:label>
			                    <f:input path="codeCat" class="form-control form-control-user" placeholder="Code categorie" id="exampleFirstName"/>
			                  </div>
			                  
			                  <div class="col-sm-6">
			                    <f:label path="designation"><fmt:message code="categorie.designation" /></f:label>
			                    <f:input type="text" path="designation" class="form-control form-control-user" id="exampleLastName" placeholder="Designation"/>
			                  </div>
			                </div>
			                <button type="submit" class="btn btn-primary btn-user btn-block">
			                  <i class="fa fa-save">&nbsp;<fmt:message code="common.enregistrer" /></i>
			                </button>
			                <a href="<c:url value="/categorie/"/>" class="btn btn-google btn-user btn-block">
			                   <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i>
			                </a>
			              </f:form>
			              <div class="text-center">
			                <a class="small" href="">Already have an account? Login!</a>
			              </div>
			            </div>
			          </div>
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

</body>

</html>
