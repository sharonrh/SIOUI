<%-- 
    Document   : jabatan
    Created on : May 1, 2014, 2:55:28 PM
    Author     : Johanes
--%>

<%@page import="object.Jabatan"%>
<%@page import="object.User"%>
<%@page import="object.Image"%>
<%@page import="object.Organisasi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "struktur"; %>
<%@include file="/WEB-INF/header.jspf" %>

<%
    Object objJabatans = request.getAttribute("jabatans");
    Object objUser = session.getAttribute("currentUser");
    String notif = request.getParameter("notif");

    List<Jabatan> jabs = ((objJabatans != null) ? (List<Jabatan>) objJabatans : null);
%>

<div class="alert alert-success <%if (notif == null) {
        out.print("hide");
    }%>">
    <%=notif%>
</div>
<div class="container">
    <div class="title">
        Struktur Organisasi
    </div>
    <a href="<%=request.getContextPath() %>/susunanorganisasi/add" class="btn btn-success">Tambah Jabatan</a>
    <div class="isi">
        <table class="table table-hover table-condensed">
            <tr>
                <th>Nama</th>
                <th>Jabatan</th>
                <th>Created at</th>
                <th>Updated at</th>
                <th>Manage</th>
            </tr>
            <% for(Jabatan jab:jabs){ %>
            <tr>
                <td><%=jab.getNama() %></td>
                <td><%=jab.getJabatan() %></td>
                <td><%=jab.getCreated_at()%></td>
                <td><%=jab.getUpdated_at()%></td>
                <td>
                    <a href="<%= request.getContextPath()%>/susunanorganisasi/edit?id=<%=jab.getId()%>" class="btn btn-xs btn-success" role="button">Manage</a>  
                    <a href="<%= request.getContextPath()%>/susunanorganisasi/delete?id=<%=jab.getId()%>" class="hapus btn btn-xs btn-danger" role="button">Delete</a>
                </td>
            </tr>
            <%}%>
        </table>
    </div>
</div>

<script>
    $(document).ready(function() {
        $(".hapus").bind("click", function(event) {
            if (!confirm('Anda yakin untuk menghapus data ini?')) {
                event.preventDefault();
            }
        });

    });
</script>

<%@include file="/WEB-INF/footer.jspf" %>

