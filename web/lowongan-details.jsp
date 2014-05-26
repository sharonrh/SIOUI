<%-- 
    Document   : lowongan-details.jsp
    Created on : Mar 27, 2014, 1:48:31 AM
    Author     : Johanes
--%>

<%@page import="object.Organisasi"%>
<%@page import="object.Lowongan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.LowonganModel"%>
<%@include file="/WEB-INF/header.jsp" %>

<%
    Object objLwg = request.getAttribute("lwg");
    Lowongan lw = ((objLwg != null) ? (Lowongan) objLwg : null);
    
    Object objOrg = request.getAttribute("org");
    
    Organisasi org = ((objOrg != null) ? (Organisasi) objOrg : null);
    System.out.println(request.getContextPath());
%>

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
                        <h2><%=org.getNama_panjang()%></h2>
                        <!-- Paragraph -->
                        <p><%=org.getDeskripsi()%> </p>
                        <hr>
                        <p><b>Visi : </b><%=org.getVisi()%> </p>
                    </div>
                    <!-- Sidebar Links -->
                    <div class="sidebar-link col-disable">
                        <!-- Search Box -->
                        <ul class="list-unstyled">
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>" class="animated">Profil <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>#oprec" class="animated">Daftar Lamaran <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>#strukturid" class="animated">Struktur Organisasi <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showalbums?id=<%=org.getId()%>" class="animated">Gallery <i class="fa fa-angle-double-right"></i></a></li>
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
                        <h2><center><%=lw.getJabatan()%></center></h2>
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
                                <img src="<%=request.getContextPath()%>/img/flat-icon/fi6.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Minimum Angkatan</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getMinimum_tahun()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="<%=request.getContextPath()%>/img/flat-icon/fi7.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Jumlah Dibutuhkan</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getKapasitas()%> orang  </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="<%=request.getContextPath()%>/img/flat-icon/fi8.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Pendaftaran Dimulai</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getTanggal_buka()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="<%=request.getContextPath()%>/img/flat-icon/fi9.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Pendaftaran Selesai</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getTanggal_tutup()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="<%=request.getContextPath()%>/img/flat-icon/fi10.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Minimum IPK</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getMinimum_ipk()%> </p>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <!-- Image -->
                                <img src="<%=request.getContextPath()%>/img/flat-icon/fi11.png" class="img-responsive" alt="" />
                                <!-- Heading -->
                                <h4>Kategori</h4>
                                <!-- Paragraph -->
                                <p class="grey"><%=lw.getKategori()%> </p>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <center><a href="<%=request.getContextPath() %>/user/daftar?id=<%=lw.getId() %>" class="btn btn-lg btn-success btn-block">Daftar Sekarang!</a></center><br><hr>
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
                                    <img src="<%=request.getContextPath()%>/img/flat-icon/fi2.png" class="img-responsive" alt="" />
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
    </div>
</div>


<%@include file="/WEB-INF/footer.jsp" %>