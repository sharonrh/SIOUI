<%-- 
    Document   : list-lowongan.jsp
    Created on : Mar 27, 2014, 12:54:23 AM
    Author     : Johanes
--%>

<%@page import="object.Organisasi"%>
<%@page import="object.Lowongan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.LowonganModel"%>
<%@include file="/WEB-INF/header.jsp" %>

<%
    Object objLwgs = request.getAttribute("lwgs");
    ArrayList<Lowongan> lwgs = ((objLwgs != null) ? (ArrayList<Lowongan>) objLwgs : null);
    
    Object objOrg = request.getAttribute("org");
    Organisasi org = ((objOrg != null) ? (Organisasi) objOrg : null);
    
    if(org==null||lwgs==null){
        response.sendRedirect(request.getContextPath());
    }
%>
<h1><%=lwgs.get(0).getId() %></h1>

<!-- BODY DIMULAI -->
<div class="inner-page">
    <div class="container"> 
        <div class="row">
            <div class="col-md-3">
                <!-- Inner Page Content Sidebar -->
                <div class="page-sidebar">
                    <!-- Page Title -->
                    <div class="page-title br-green">
                        <!-- Inner Page Title // Heading -->
                        <h2><%=org.getNama_pendek() %></h2>
                        <!-- Paragraph -->
                        <p><%=org.getDeskripsi() %></p>
                    </div>
                    <!-- Sidebar Links -->
                    <div class="sidebar-link col-disable">
                        <!-- Search Box -->
                        <div class="search">
                        </div>
                        <ul class="list-unstyled">
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>" class="animated">Profil <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>#oprec" class="animated">Daftar Lamaran <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?=<%=org.getId()%>#strukturid" class="animated">Struktur Organisasi <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showalbums?id=<%=org.getId()%>" class="animated">Gallery <i class="fa fa-angle-double-right"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="judul-halaman">
                    Daftar Lowongan
                </div>
                <div class="list-lowongan">
                    <%                        // cetak setiap detil lowongan 
                        for (Lowongan l : lwgs) {
                    %>
                    <div class="item-lowongan">
                        <div class="row">
                            <div class="col-md-2">
                                <img src="img/flat-icon/fi8.png" class="img-list-lowongan img-responsive" alt="">
                            </div>
                            <div class="col-md-10">
                                <div class="row">
                                    <div class="col-md-8"><h3><%=l.getJudul()%></h3></div>
                                </div>
                                <div class="deskripsi-lowongan">
                                    <p><%=l.getDeskripsi()%></p>

                                    <a href="<%=request.getContextPath() %>/explore/showdetaillwg?id=<%=l.getId() %>">read more</a>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/footer.jsp" %>