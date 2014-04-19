<%-- 
    Document   : list-lowongan.jsp
    Created on : Mar 27, 2014, 12:54:23 AM
    Author     : Johanes
--%>

<%@page import="object.Lowongan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.LowonganModel"%>
<%@include file="header.jsp" %>

<%
    LowonganModel lm = new LowonganModel();
    List<Lowongan> result = lm.selectAll();
%>


<!-- BODY DIMULAI -->
<div class="inner-page">
    <div class="container">
        <%
            if (session.getAttribute("currentUser") != null) {
        %>
        <div class="row">
            <div class="col-md-3">
                <!-- Inner Page Content Sidebar -->
                <div class="page-sidebar">
                    <!-- Page Title -->
                    <div class="page-title br-green">
                        <!-- Inner Page Title // Heading -->
                        <h2>BEM Fasilkom UI</h2>
                        <!-- Paragraph -->
                        <p>Roosevelt accusal et gusto sod pianist moss dulcimers blandish desideratum voluptuary lenitive.</p>
                    </div>
                    <!-- Sidebar Links -->
                    <div class="sidebar-link col-disable">
                        <!-- Search Box -->
                        <div class="search">
                            <form>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Text to search">
                                    <span class="input-group-btn">
                                        <button class="btn" type="button"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </form>
                        </div>
                        <ul class="list-unstyled">
                            <li><a href="index.html" class="animated">Profil <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="" class="animated">Daftar Lamaran <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="" class="animated">Struktur Organisasi <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="" class="animated">Gallery <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="" class="animated">Event <i class="fa fa-angle-double-right"></i></a></li>
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
                        for (Lowongan l : result) {
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

                                    <form action="lowongan-details.jsp" method="post">
                                        <input type="hidden" name="id_lowongan" value="<%=l.getId_lowongan()%>">
                                        <input type="hidden" name="id_organisasi" value="<%=l.getId_organisasi()%>">
                                        <input class="btn btn-sm btn-danger pull-right" type="submit" value="read more"/> 
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
        <% } else {
        %>
        <div class="alert alert-danger">Anda harus login terlebih dahulu untuk melihat konten dari halaman ini.</div>
        <% }%>
    </div>
</div>

<%@include file="footer.jsp" %>