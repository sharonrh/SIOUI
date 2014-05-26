
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
                            <p></p>
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
                        <div class="alert alert-success <%if (objNotif == null) {
                                out.print("hide");
                         }%> "><% if (objNotif != null) {
                                     out.print(objNotif.toString());
                                    } %></div>
                        <div class="col-md-12 col-sm-12">
                            <!-- Box Outer Layer [ Box 3 ] -->
                            <div class="box box-lg br-red animated" style="min-height:140px">
                                <div class="box-content box-service box-default">
                                    <!-- Heading -->
                                    <h4><i class="fa fa-trophy"></i> Notifikasi</h4>
                                    <!-- Paragraph -->
                                    <p>Notifikasi adalah perubahan-perubahan baru yang belum Anda lihat.</p>
                                    <!-- Box Service List -->
                                    <ul class="list-unstyled">
                                        <%
                                            for (Notifikasi nt : nb.getNotifications()) {
                                                int idPelamar = Integer.parseInt(nt.getId_pelamar());
                                                int idLowongan = tablePelamar.get(idPelamar).getId_lowongan();
                                                Lowongan l = tableLwgs.get(idLowongan);

                                                String namaPendek = tableOrgs.get(l.getId()).getNama_pendek();
                                        %>
                                        <div class="lowongan-home">
                                            <li><i class="fa fa-check-square-o"></i> <b><%= l.getJudul()%></b> - <%= namaPendek%></li>
                                            <p>
                                                <%=nt.getCreated_at()%> 
                                                <a href="<%=request.getContextPath()%>/explore/showdetaillwg?id=<%=idLowongan%>" class="btn btn-warning pull-right btn-xs">read more <i class="fa fa-angle-right"></i></a>
                                                <a href="<%=request.getContextPath()%>/user/jawabclosereg?idpl=<%=idPelamar%>" class="btn btn-success pull-right btn-xs">Terima - Pilih CV</a>

                                            </p>	

                                        </div>
                                        <hr>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                            <div class="box box-lg br-yellow animated" style="min-height:140px">
                                <div class="box-content box-service box-default">
                                    <!-- Heading -->
                                    <h4><i class="fa fa-trophy"></i> Close Recruitment</h4>
                                    <!-- Paragraph -->
                                    <p>Close Recruitment adalah mekanisme dimana anda diajak oleh sebuah organisasi untuk bergabung.</p>
                                    <!-- Box Service List -->
                                    <ul class="list-unstyled">
                                        <%
                                            for (Notifikasi nt : nb.getCloseRec()) {
                                                int idPelamar = Integer.parseInt(nt.getId_pelamar());
                                                int idLowongan = tablePelamar.get(idPelamar).getId_lowongan();
                                        %>
                                        <div class="lowongan-home">
                                            <li><i class="fa fa-check-square-o"></i> <b><%= tableLwgs.get(idLowongan).getJudul()%></b> - <%= tableOrgs.get(tableLwgs.get(idLowongan).getId()).getNama_pendek()%></li>
                                            <p><%=nt.getCreated_at()%> 
                                                <a href="<%=request.getContextPath()%>/user/terimaclosereg?idpl=<%=idPelamar%>" class="btn btn-success btn-xs">Terima - Pilih CV </a>
                                                <a href="<%=request.getContextPath()%>/user/tolakclosereg?idpl=<%=idPelamar%>" class="awas btn btn-danger btn-xs">Tolak </a>
                                                <a href="<%=request.getContextPath()%>/explore/showdetaillwg?id=<%=idLowongan%>" class="btn btn-warning pull-right btn-xs">read more <i class="fa fa-angle-right"></i></a>
                                            </p>	
                                        </div>
                                        <hr>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                            <div class="box box-lg br-green animated" style="min-height:140px">
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
<script>
    $(document).ready(function() {
        $(".awas").bind("click", function(event) {
            if (!confirm('Anda yakin untuk menolak kesempatan ini?')) {
                event.preventDefault();
            }
        });

    });
</script>