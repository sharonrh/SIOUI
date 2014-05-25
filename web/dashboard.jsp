
<%@page import="object.Pelamar"%>
<%@page import="object.Notifikasi"%>
<%@page import="object.Organisasi"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Hashtable"%>
<%@page import="object.Lowongan"%>
<%@page import="ws.UserCV"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/header.jsp" %>

<%
    Object objTableLwgs = request.getAttribute("tableLwgs");
    Object objTableOrgs = request.getAttribute("tableOrgs");
    Object objTablePelamar = request.getAttribute("tablePelamar");
    Object objNotif = request.getAttribute("notif");

    Hashtable<Integer, Lowongan> tableLwgs = ((objTableLwgs != null) ? (Hashtable<Integer, Lowongan>) objTableLwgs : null);
    Hashtable<Integer, Organisasi> tableOrgs = ((objTableOrgs != null) ? (Hashtable<Integer, Organisasi>) objTableOrgs : null);
    Hashtable<Integer, Pelamar> tablePelamar = ((objTablePelamar != null) ? (Hashtable<Integer, Pelamar>) objTablePelamar : null);

    if (session.getAttribute("currentUser") == null) {
        //redirect here
    }

    String username = session.getAttribute("currentUser").toString();
    NotifBean nb = (NotifBean) session.getAttribute(username + "_notif");
    nb.populateBean();
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
                            <h2>Dashboard</h2>
                            <!-- Paragraph -->
                            <p>Lorem ipsum dolor sit amet</p>
                        </div>
                        <!-- Sidebar Links -->
                        <div class="sidebar-link col-disable">
                            <!-- Search Box -->
                            <div class="search">
                            </div>
                            <ul class="list-unstyled">
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="judul-halaman">
                        <h3>Dashboard</h3>
                    </div><br>
                    <div class="isi">
                        <div class="alert alert-success <%if(objNotif==null) out.print("hide");%> "><% if(objNotif!=null) out.print(objNotif.toString()); %></div>
                        <div class="col-md-12 col-sm-12">
                            <!-- Box Outer Layer [ Box 3 ] -->
                            <div class="box box-lg br-red animated" style="height:140px">
                                <div class="box-content box-service box-default">
                                    <!-- Heading -->
                                    <h4><i class="fa fa-trophy"></i> Close Recruitment</h4>
                                    <!-- Paragraph -->
                                    <p>Close Recruitment adalah mekanisme dimana anda diajak oleh sebuah organisasi untuk bergabung.</p>
                                    <!-- Box Service List -->
                                    <ul class="list-unstyled">
                                        <%
                                            for (Notifikasi nt : nb.getCloseRec()) {
                                        %>
                                        <div class="lowongan-home">
                                            <li><i class="fa fa-check-square-o"></i> <b><%= tableLwgs.get(tablePelamar.get(nt.getId_pelamar()).getId_lowongan()).getJudul()%></b> - <%= tableOrgs.get(tableLwgs.get(tablePelamar.get(nt.getId_pelamar()).getId_lowongan()).getId()).getNama_pendek()%></li>
                                            <p><%=nt.getCreated_at()%> <a href="<%=request.getContextPath()%>/explore/showdetaillwg?id=<%=tablePelamar.get(nt.getId_pelamar()).getId_lowongan()%>" class="btn btn-warning pull-right btn-xs">read more <i class="fa fa-angle-right"></i></a></p>	
                                        </div>
                                        <hr>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                            <div class="box box-lg br-yellow animated" style="height:140px">
                                <div class="box-content box-service box-default">
                                    <!-- Heading -->
                                    <h4><i class="fa fa-trophy"></i> Close Recruitment</h4>
                                    <!-- Paragraph -->
                                    <p>Close Recruitment adalah mekanisme dimana anda diajak oleh sebuah organisasi untuk bergabung.</p>
                                    <!-- Box Service List -->
                                    <ul class="list-unstyled">
                                        <%
                                            for (Notifikasi nt : nb.getNotifications()) {
                                        %>
                                        <div class="lowongan-home">
                                            <li><i class="fa fa-check-square-o"></i> <b><%= tableLwgs.get(tablePelamar.get(nt.getId_pelamar()).getId_lowongan()).getJudul()%></b> - <%= tableOrgs.get(tableLwgs.get(tablePelamar.get(nt.getId_pelamar()).getId_lowongan()).getId()).getNama_pendek()%></li>
                                            <p><%=nt.getCreated_at()%> <a href="<%=request.getContextPath()%>/explore/showdetaillwg?id=<%=tablePelamar.get(nt.getId_pelamar()).getId_lowongan()%>" class="btn btn-warning pull-right btn-xs">read more <i class="fa fa-angle-right"></i></a></p>	
                                        </div>
                                        <hr>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                            <div class="box box-lg br-green animated" style="height:140px">
                                <div class="box-content box-service box-default">
                                    <!-- Heading -->
                                    <h4><i class="fa fa-trophy"></i> Pendaftaranku</h4>
                                    <!-- Paragraph -->
                                    <p>Pendaftaran yang telah Anda lakukan</p>
                                    <!-- Box Service List -->
                                    <ul class="list-unstyled">
                                        <%
                                            for (Pelamar nt : nb.getPendaftaranku()) {
                                        %>
                                        <div class="lowongan-home">
                                            <li><i class="fa fa-check-square-o"></i> <b><%= tableLwgs.get(tablePelamar.get(nt.getId()).getId_lowongan()).getJudul()%></b> - <%= tableOrgs.get(tableLwgs.get(tablePelamar.get(nt.getId()).getId_lowongan()).getId()).getNama_pendek()%></li>
                                            <p><%=nt.getCreated_at()%> <a href="<%=request.getContextPath()%>/explore/showdetaillwg?id=<%=tablePelamar.get(nt.getId()).getId_lowongan()%>" class="btn btn-warning pull-right btn-xs">read more <i class="fa fa-angle-right"></i></a></p>	
                                        </div>
                                        <hr>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/footer.jsp" %>