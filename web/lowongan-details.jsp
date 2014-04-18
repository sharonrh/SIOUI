<%-- 
    Document   : lowongan-details.jsp
    Created on : Mar 27, 2014, 1:48:31 AM
    Author     : Johanes
--%>

<%@page import="model.OrganizationModel"%>
<%@page import="object.Lowongan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.LowonganModel"%>
<%@include file="header.jsp" %>

<%
    String id_user = request.getParameter("id_user");
    int id_organisasi = Integer.parseInt(request.getParameter("id_organisasi"));
    int id_lowongan = Integer.parseInt(request.getParameter("id_organisasi"));
    Lowongan lw = null;
    if (param != null) {
        LowonganModel lm = new LowonganModel();
        lw = lm.select(id_user, id_organisasi, id_lowongan);
        if (session.getAttribute("currentUser") != null) {
            Cookie sessionCookie = new Cookie("recent_" + session.getAttribute("currentUser"), param);
            sessionCookie.setPath("/");
            response.addCookie(sessionCookie);
        }
    }
%>

<!-- BODY DIMULAI -->
<div class="inner-page">
    <div class="container">
        <%
            if (session.getAttribute("currentUser") != null) {
                //        OrganizationModel om = new OrganizationModel();
                // om.select(nama);
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
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Main-bar Column -->
            <div class="col-md-9">
                <div class="page-mainbar aboutus">
                    <!-- About Content -->
                    <div class="aboutus-content">
                        <!-- Heading -->
                        <h2><center><%=lw.getJudul()%></center></h2>
                    </div>								
                    <br>
                    <h3>Deskripsi</h3>
                    <div class="lowongan-description grey">
                        <p><%=lw.getDeskripsi()%></p>
                    </div>

                    <!-- Heading -->
                    <h3>Prasyarat</h3>
                    <!-- Feature Details -->
                    <div class="feature-details animation fadeIn">
                        <div class="row">
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="img/flat-icon/fi6.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Minimum Angkatan</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getMinimumTahun()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="img/flat-icon/fi7.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Jumlah Dibutuhkan</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getKapasitas()%> orang  </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="img/flat-icon/fi8.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Pendaftaran Dimulai</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getTanggal_buka()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="img/flat-icon/fi9.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Pendaftaran Selesai</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getTanggal_tutup()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="img/flat-icon/fi10.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Minimum IPK</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getMinimumIpk()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="img/flat-icon/fi11.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Kategori</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getKategori()%> </p>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <center><a href="" class="btn btn-lg btn-success btn-block">Daftar Sekarang!</a></center><br><hr>
                    </div>
                    <hr><br><br>
                    <!-- About Us Skills -->
                    <div class="aboutus-skill">
                        <!-- Heading -->
                        <h3>Rekomendasi</h3>
                        <div class="row">
                            <div class="col-md-6 col-sm-6">

                                <%
                                    LowonganModel lm = new LowonganModel();
                                    ArrayList<Lowongan> rekomendasi = lm.getLowonganRekomendasi(lw.getKategori());
                                    for (Lowongan r : rekomendasi) {
                                %>

                                <!-- Skill Item -->
                                <div class="skill-item">
                                    <!-- Image // Flat Icon -->
                                    <img src="img/flat-icon/fi2.png" class="img-responsive" alt="" />
                                    <!-- Heading -->
                                    <h6><%=r.getJudul()%></h6>
                                    <!-- Paragraph -->
                                    <p class="grey"><%=r.getDeskripsi()%></p>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <%}%>

                        </div>
                    </div>
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