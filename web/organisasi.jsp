<%-- 
    Document   : organisasi
    Created on : May 24, 2014, 5:32:14 PM
    Author     : Johanes
--%>
<%@page import="object.Organisasi"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/WEB-INF/header.jsp" %>

<%
    Object objOrgs = request.getAttribute("orgs");
    String judul = request.getAttribute("judul").toString();
    String detail = request.getAttribute("detail").toString();
    ArrayList<Organisasi> orgs = ((objOrgs != null) ? (ArrayList<Organisasi>) objOrgs : null);
%>

<div class="inner-page">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <!-- Inner Page Content Sidebar -->
                <div class="page-sidebar">
                    <!-- Page Title -->
                    <div class="page-title br-green">
                        <!-- Inner Page Title // Heading -->
                        <h2><%=judul%></h2>
                        <!-- Paragraph -->
                        <p>
                            <%=detail%>
                        </p>
                    </div>
                    <!-- Sidebar Links -->
                    <div class="sidebar-link col-disable">
                        <!-- Search Box -->
                        <div class="search">
                            <form>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Text to search">
                                    <span class="input-group-btn">
                                        <button class="btn" type="button"><i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                            </form>
                        </div>
                        <ul class="list-unstyled">
                            <li><a href="index.html" class="animated">UKM <i class="fa fa-angle-double-right"></i></a>
                            </li>
                            <li><a href="aboutus.html" class="animated">UKF <i class="fa fa-angle-double-right"></i></a>
                            </li>
                            <li><a href="feature.html" class="animated">Event <i class="fa fa-angle-double-right"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Main-bar Column -->
            <div class="col-md-9">
                <div class="page-mainbar">
                    <div class="row">
                        <% for (Organisasi org : orgs) {%>
                        <div class="col-md-3">
                            <!-- Box Outer Layer [ Box 1 ] -->
                            <div class="box box-md br-yellow animated box-org">
                                <!-- Box Link -->
                                <a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>">
                                    <!-- Box Link Content -->
                                    <div class="box-content navigation">
                                        <!-- Box Icon -->
                                        <img class="logo-org-sm" src="<%
                                            if (org.getLogo() != null) {
                                                out.print("\\ImageLogo?id=" + org.getId() + "\\" + org.getLogo());
                                            }
                                             %>" width="140"/>
                                        <!-- Box Title -->
                                        <span class="box-title"><%=org.getNama_panjang()%></span>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <%}%>


                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Inner Page Content // End -->


<%@include file="/WEB-INF/footer.jsp" %>

