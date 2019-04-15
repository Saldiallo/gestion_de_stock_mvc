<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <c:url value="/home" var="home" />
      <a class="sidebar-brand d-flex align-items-center justify-content-center"
       href="${home }">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Gestion De Stock </div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
      	<c:url value="/home" var="home" />
        <a class="nav-link" href="${home }">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span> <fmt:message code="common.dashbord"/> </span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">
      
      <li class="nav-item">
      	<c:url value="/article" var="article" />
        <a class="nav-link collapsed" href="${article}">
          <i class="fas fa-fw fa-cog"></i>
          <span> <fmt:message code="common.article"/></span>
        </a>
      </li>
      
      <!-- Divider -->
      <hr class="sidebar-divider">
      
      <!-- Clients -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span><fmt:message code="common.client"/></span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"><fmt:message code="common.client"/>:</h6>
            <c:url value="/client" var="client" />
            <a class="collapse-item" href="${client }"><fmt:message code="common.client"/></a>
            <c:url value="/commandeClient" var="cmdClient" />
            <a class="collapse-item" href="${cmdClient }"><fmt:message code="common.client.commande"/></a>
          </div>
        </div>
      </li>
      
      <!-- Divider -->
      <hr class="sidebar-divider">
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span> <fmt:message code="common.fournisseur"/> </span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"><fmt:message code="common.fournisseur"></fmt:message>:</h6>
            <c:url value="/fournisseur" var="fournisseur" />
            <a class="collapse-item" href="${fournisseur }"><fmt:message code="common.fournisseur"/></a>
            <c:url value="/commandeFournisseur" var="cdmFournisseur" />
            <a class="collapse-item" href="${cmdFournisseur }"><fmt:message code="common.fournisseur.commande"/></a>
          </div>
        </div>
      </li>

		<!-- Divider -->
      <hr class="sidebar-divider">
      <!-- Nav Item - Charts -->
      <li class="nav-item">
      <c:url value="/stock" var="stock" />
        <a class="nav-link" href="${stock}">
          <i class="fas fa-fw fa-chart-area"></i>
          <span><fmt:message code="common.stock"/></span></a>
      </li>
      
      <!-- Divider -->
      <hr class="sidebar-divider">
      
      <!-- Nav Item - Tables -->
      <li class="nav-item">
      	<c:url value="/vente" var="vente" />
        <a class="nav-link" href="${vente }">
          <i class="fas fa-fw fa-table"></i>
          <span><fmt:message code="common.vente"/></span></a>
      </li>      

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span><fmt:message code="common.parametrage"/></span>
        </a>
        <div id="collapsePages" class="collapse " aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"><fmt:message code="common.parametrage"/>:</h6>
            <c:url value="/utilisateur" var="utilisateur" />
            <a class="collapse-item" href="${utilisateur }"><fmt:message code="common.parametrage.utilisateur"/></a>
            <c:url value="/categorie" var="category" />
            <a class="collapse-item" href="${category }"><fmt:message code="common.parametrage.category"/></a>
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>