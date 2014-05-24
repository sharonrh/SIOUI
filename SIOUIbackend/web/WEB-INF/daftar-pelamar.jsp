<%-- 
    Document   : daftar-pelamar
    Created on : May 13, 2014, 4:24:49 PM
    Author     : daniel.januar
--%>

<%@page import="object.Pelamar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PelamarModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "daftar-pelamar"; %>

<%@include file="/WEB-INF/header.jspf" %>
<% ArrayList<Pelamar> listPelamar = (ArrayList<Pelamar>) request.getAttribute("listPelamar");
   String status = request.getAttribute("status_recruitment").toString();
   String jenis = request.getAttribute("jenis_recruitment").toString();
%>
<form class="form-horizontal" role="form" method="POST" action="/SIOUIbackend/pelamar">
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Jenis Recruitment</label>
        <div class="col-sm-4">
            <select id="selectbasic" name="jenis_recruitment" class="form-control">
                <option value="open" <%if(jenis.equals("open")){out.print("selected");};%>>Open Recruitment</option>
                <option value="close" <%if(jenis.equals("close")){out.print("selected");};%>>Close Recruitment</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Status Recruitment</label>
        <div class="col-sm-4">
            <select id="selectbasic" name="status_recruitment" class="form-control">
                <option value="wait" <%if(status.equals("wait")){out.print("selected");};%>>Menunggu Konfirmasi</option>
                <option value="reject" <%if(status.equals("reject")){out.print("selected");};%>>Ditolak</option>
                <option value="accept" <%if(status.equals("accept")){out.print("selected");};%>>Diterima</option>
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
        <table class="table table-hover table-striped">
            <thead>    
            <th> No </th>
            <th> Nama </th>
            </thead>      
            <% for (int ii = 0; ii < listPelamar.size(); ii++) {%>
            <tr>
                <td> <%=ii + 1%></td>
                <td>  
                    <b> <%=listPelamar.get(ii).getUsername()%> </b>
                </td>
                <td> Details</td>
            </tr>
            <%}%>
        </table>
    </div>
    <!-- Nanti webservicenya taro di bagian sini-->
</div>

<%@include file="/WEB-INF/footer.jspf" %>

