<%-- 
    Document   : organisasi-details
    Created on : May 24, 2014, 9:06:22 PM
    Author     : Johanes
--%>
<%@page import="object.Jabatan"%>
<%@page import="java.util.List"%>
<%@page import="object.Organisasi"%>
<%@include file="/WEB-INF/header.jsp" %>

<%
    Object objOrg = request.getAttribute("org");
    Object objJbts = request.getAttribute("jbts");
    
    Organisasi org = ((objOrg != null) ? (Organisasi) objOrg : null);
    List<Jabatan> jbts = ((objJbts != null) ? (List<Jabatan>) objJbts : null);
    
    if(org==null||jbts==null){
        response.sendRedirect(request.getContextPath());
    }
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
                        <h2><%=org.getNama_pendek() %></h2>
                        <!-- Paragraph -->
                        <p><%=org.getDeskripsi()  %></p>
                    </div>
                    <!-- Sidebar Links -->
                    <div class="sidebar-link col-disable">
                        <!-- Search Box -->
                        <div class="search">
                            <!--
                            <form>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Text to search">
                                    <span class="input-group-btn">
                                        <button class="btn" type="button"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </form>-->
                        </div>
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
                        <h3><%=org.getNama_panjang() %></h3>
                        <div class="row">
                            <div class="col-md-8 col-sm-8">
                                <!-- Client Quotes -->
                                <div class="aboutus-quote">
                                    <!-- Quotes -->
                                    <span>&#8220;</span>
                                    <!-- Paragraph -->
                                    <p><%=org.getVisi() %></p>
                                    <br>
                                    <h5 class="pull-right"> Visi <%= org.getNama_pendek() %></h5>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <img src="<%
                                            if (org.getLogo() != null) {
                                                out.print("\\ImageLogo?id=" + org.getId() + "\\" + org.getLogo());
                                            }
                                             %>" class="img-responsive img-polaroid" alt="" />
                            </div>
                        </div>
                    </div>								
                    <!-- About Us Member -->
                    <div id="struktur" class="aboutus-member">
                        <!-- Heading -->
                        <h3>Struktur Organisasi</h3>
                        <div class="row">
                            <%
                                for(Jabatan jbt:jbts){
                            %>
                            <div class="col-md-4 col-sm-4">
                                <!-- Member Content -->
                                <div class="member-content">
                                    <h4><%= jbt.getNama() %></h4>
                                    <hr />
                                    <p><%=jbt.getJabatan() %> </p>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                        
                        <!-- About Us Skills -->
                    <div class="aboutus-skill">
                        <!-- Heading -->
                        <h3>Alamat</h3>
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <!-- Skill Item -->
                                <div class="skill-item">
                                    <!-- Image // Flat Icon -->
                                    <img src="/img/flat-icon/fi6.png" class="img-responsive" alt="" />
                                    <!-- Heading -->
                                    <h6>Alamat</h6>
                                    <!-- Paragraph -->
                                    <p><%=org.getAlamat() %></p>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h3 id="oprec">Open Recruitment di Organisasi Ini</h3>
                    <a href="<%=request.getContextPath() %>/explore/showlistlwg?idorg=<%=org.getId() %>" class="btn btn-success">Lihat lowongan di organisasi ini!</a>
                                    
<!--
                    <h3>Open Recruitment di Organisasi Ini</h3>
                    <div class="feature-details animation fadeIn">
                        <div class="row">
                            <div class="col-md-6 col-sm-6">
                                <img src="/img/flat-icon/fi6.png" class="img-responsive" alt="" />
                                <h4>Equine Porno Squamous</h4>
                                <p class="grey">Lorem Ipsum generators on the Internet tend to repeat predefined chunks as internet. </p>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
-->
                    
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/footer.jsp" %>