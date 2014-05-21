<%-- 
    Document   : manage
    Created on : May 21, 2014, 6:59:05 PM
    Author     : ACER
--%>

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
        <tr>    
            <th> # </th>
            <th> Username </th>
            <th> Deskripsi </th>
            <th> Tanggal Pengajuan </th>
            <th> Action </th>
        </tr>      

        <% ArrayList<Organisasi> listOrganisasi = (ArrayList<Organisasi>) request.getAttribute("listOrganisasi");
            for (Organisasi a : listOrganisasi) {
        %>

        <tr>
            <td> <%= a.getId()%> </td>
            <td> <%= a.getUsername()%> </td>
            <td> <%= a.getDeskripsi()%> </td>
            <td> <%= a.getCreated_at()%> </td>
            <td> 
                <form method="post" class="form-inline" action="#">
                    <button class="btn btn-default btn-success" type="submit">Approve</button>
                    <button class="btn btn-default btn-danger" type="submit">Reject</button>
                    <input type="hidden" name="act" value="del">
                    <input type="hidden" name="del_id" value="">                                
                </form>
            </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
