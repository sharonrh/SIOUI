<%-- 
    Document   : daftar-pelamar
    Created on : May 13, 2014, 4:24:49 PM
    Author     : daniel.januar
--%>

<%@page import="webservice.BasicInformation"%>
<%@page import="java.util.List"%>
<%@page import="object.Image"%>
<%@page import="object.Pelamar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PelamarModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "lowongan";%>

<%@include file="/WEB-INF/header.jspf" %>

<div class="alert alert-success <%if (request.getAttribute("alertContent") == null) {
        out.print("hide");
    }%>">
    <%=request.getAttribute("alertContent")%>
</div>

<% ArrayList<Pelamar> listPelamar = (ArrayList<Pelamar>) request.getAttribute("listPelamar");
    String status = request.getAttribute("status_recruitment").toString();
    String jenis = request.getAttribute("jenis_recruitment").toString();
%>
<form class="form-horizontal" role="form" method="POST" action="/SIOUIbackend/pelamar">
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Jenis Recruitment</label>
        <div class="col-sm-4">
            <select id="selectbasic" name="jenis_recruitment" class="form-control">
                <option value="open" <%if (jenis.equals("open")) {
                        out.print("selected");
                    };%>>Open Recruitment</option>
                <option value="close" <%if (jenis.equals("close")) {
                        out.print("selected");
                    };%>>Close Recruitment</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Status Recruitment</label>
        <div class="col-sm-4">
            <select id="selectbasic" name="status_recruitment" class="form-control">
                <option value="wait" <%if (status.equals("wait")) {
                        out.print("selected");
                    };%>>Menunggu Konfirmasi</option>
                <option value="reject" <%if (status.equals("reject")) {
                        out.print("selected");
                    };%>>Ditolak</option>
                <option value="accept" <%if (status.equals("accept")) {
                        out.print("selected");
                    };%>>Diterima</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-success">Cari</button>
        </div>
    </div>
</form>

<div class="title">
    Daftar Pelamar
</div>

<div class="container">
    <div class="col-lg-12"> 
        <% if (listPelamar.size() > 0) {%>
        <table class="table table-hover table-striped">
            <thead>    
            <th> No </th>
            <th> Username </th>
            <th> Tanggal melamar </th>
            <th> Detail </th>               
            <th><%out.print(jenis.equals("open") ? "Ubah status" : "");%> </th>
            </thead>      
            <% int i = 1;
                for (Pelamar p : listPelamar) {%>
            <tr>
                <td> <%=i++%></td>
                <td> <%=p.getUsername()%> </td>
                <td> <%=p.getCreated_at()%> </td>
                <td>
                    <% // pastiin punya cv
                    if (p.getId_cv() != 0) {%>
                    <a href="pelamar/detail?id=<%= p.getId()%>" class="btn btn-default btn-primary">Unduh CV</a>
                    <%} %>
                </td>
                <td>
                    <%if (jenis.equals("open")) {
                            if (!status.equals("accept")) {%>
                    <a href="pelamar/status?id=<%= p.getId()%>&act=accept" class="btn btn-default btn-success">Terima</a>
                    <%}
                        if (!status.equals("reject")) {%>
                    <a href="pelamar/status?id=<%= p.getId()%>&act=reject" class="btn btn-default btn-danger">Tolak</a>
                    <%}
                            }
                        }%>
        </table>
        <%} else {%>
        <h4 class="text-primary">Belum ada pelamar yang tercatat.</h4>
        <%}%>
    </div>
</div>

<%if (jenis.equals("close")) {%>
<div class="title">
    Rekomendasi
</div>
<div class="container">
    <!-- Nanti webservicenya taro di bagian sini-->

    <%
        List<BasicInformation> rekomendasi = (List<BasicInformation>) request.getAttribute("listRekomendasi");
        for (BasicInformation b : rekomendasi) {
    %>
    <div class="col-sm-4 col-md-3">
        <div class="caption">
            <h3><%=b.getFullName()%></h3>
            <ul class="list-unstyled">
                <li>  <%=b.getAddressLine1()%></li>
                <li>  <%=b.getEmail()%></li>
                <li>  <%=b.getPhoneNumber()%></li>
            </ul>
            <p>
                <%// ini link ke halaman di sivimu apa gimana ya?%>
                <a href="pelamar/recruit?name=<%=b.getUsername()%>" class="confirm btn btn-xs btn-info" role="button">Recruit</a> 
            </p>
        </div>
    </div>
    <%}%>            
</div>
<%}%>

<script>
    $(document).ready(function() {
        $(".confirm").bind("click", function(event) {
            if (!confirm('Anda yakin akan merecruit pengguna ini?')) {
                event.preventDefault();
            }
        });

    });
</script>
<%@include file="/WEB-INF/footer.jspf" %>