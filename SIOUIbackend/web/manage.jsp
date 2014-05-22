<%-- 
    Document   : manage
    Created on : May 21, 2014, 6:59:05 PM
    Author     : ACER
--%>

<%@page import="object.Organisasi"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String activePage = "manage";%>

<%@include file="/WEB-INF/header.jspf" %>
<div class="title">
    Manage Organisasi
</div>

<div class="col-lg-12"> 
    <table class="table table-hover table-striped">
        <thead>    
            <th> # </th>
            <th> Username </th>
            <th> Nama Organisasi </th>
            <th> Deskripsi </th>
            <th> Action </th>
        </thead>      

        <% ArrayList<Organisasi> listOrganisasi = (ArrayList<Organisasi>) request.getAttribute("listOrganisasi");
            for (Organisasi a : listOrganisasi) {
        %>

        <tr>
            <td> <%= a.getId()%> </td>
            <td> <%= a.getUsername()%> </td>
            <td> <%= a.getNama_panjang()%> </td>
            <td> <%= a.getDeskripsi()%> </td>
            <td> 
                <form method="post" action="manage/delete">
                    <button class="btn btn-default btn-danger" type="submit">Delete</button>
                    <input type="hidden" name="del_id" value="<%=a.getUsername()%>">                                
                </form>
            </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
