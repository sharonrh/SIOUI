<%-- 
    Document   : manage
    Created on : May 21, 2014, 6:59:05 PM
    Author     : ACER
--%>

<%@page import="object.Permohonan"%>
<%@page import="object.Organisasi"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String activePage = "pending";%>

<%@include file="/WEB-INF/header.jspf" %>
<div class="title">
    Pending Request
</div>

<div class="col-lg-12"> 
    <table class="table table-hover table-striped">
        <thead>    
            <th> # </th>
            <th> Username </th>
            <th> Nama Panjang </th>
            <th> Deskripsi </th>
            <th> Tanggal Pengajuan </th>
            <th> Action </th>
        </thead>      

        <% ArrayList<Permohonan> listPermohonan = (ArrayList<Permohonan>) request.getAttribute("listPermohonan");
            for (Permohonan a : listPermohonan) {
        %>

        <tr>
            <td> <%= a.getId()%> </td>
            <td> <%= a.getUsername()%> </td>
            <td> <%= a.getNama_panjang()%> </td>
            <td> <%= a.getDeskripsi()%> </td>
            <td> not implemented </td>
            <td> 
                <a href="pending/permit?act=approve&id=<%= a.getId()%>" class="btn btn-default btn-success">Approve</a>
                <a href="pending/permit?act=reject&id=<%= a.getId()%>" class="btn btn-default btn-danger">Reject</a>                               
            </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
