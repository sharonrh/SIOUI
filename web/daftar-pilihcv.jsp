
<%@page import="ws.UserCV"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/header.jsp" %>

<%
    Object objCvs = request.getAttribute("cvs");
    Object objFormAction = request.getAttribute("formAction");
    Object objIdlw = request.getAttribute("idlw");
    
    ArrayList<UserCV> cvs = ((objCvs != null) ? (ArrayList<UserCV>) objCvs : null);
    String formAction = ((objFormAction != null) ? objFormAction.toString() : null);
    String idlw = ((objIdlw != null) ? objIdlw.toString() : null);
%>

<div class="container"> 
    <div class="inner-page">
        <div class="container"> 
            <div class="row">
                <div class="col-md-3">
                    <!-- Inner Page Content Sidebar -->
                    <div class="page-sidebar">
                        <!-- Page Title -->
                        <div class="page-title br-green">
                            <!-- Inner Page Title // Heading -->
                            <h2></h2>
                            <!-- Paragraph -->
                            <p></p>
                        </div>
                        <!-- Sidebar Links -->
                        <div class="sidebar-link col-disable">
                            <!-- Search Box -->
                            <div class="search">
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
                        <h3>Pilih CV yang Akan Anda Submit</h3>
                    </div><br>
                    <div class="list-lowongan">
                        <form class="form-horizontal" role="form" method="POST" action="<%=formAction %>">
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <%for (UserCV cv : cvs) {%>
                                    <div class="col-md-6 col-sm-6">
                                        <!-- Image -->
                                        <input type="radio" name="cvs" value="<%=cv.getCvId()%>">
                                        <!-- Heading -->
                                        <h4><%=cv.getTitle()%></h4>
                                        <!-- Paragraph -->
                                        <p class=""><%=cv.getReference()%> referensi</p>
                                        <div class="clearfix"></div>
                                    </div>

                                    <%}%>
                                    <input type="hidden" name="idlw" value="<%=idlw%>">
                                </div> 
                            </div>
                            <div class="form-group text-center">
                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-warning">Daftar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/footer.jsp" %>