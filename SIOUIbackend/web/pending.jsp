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
<div class="alert <%=request.getAttribute("alertType")%>">
    <%=request.getAttribute("alertContent")%>
</div>

<% ArrayList<Permohonan> listPermohonan = (ArrayList<Permohonan>) request.getAttribute("listPermohonan");%>

<div class="container">
    <div class="col-lg-12"> 
        <table class="table table-hover table-striped">
            <% if (listPermohonan.size() > 0) {%>
            <thead>    
            <th> # </th>
            <th> Pemohon </th>
            <th> Username </th>
            <th> Nama Panjang </th>
            <th> Deskripsi </th>
            <th> Tanggal Pengajuan </th>
            <th>  </th>
            </thead>      

            <% for (Permohonan a : listPermohonan) {%>

            <tr>
                <td> <%= a.getId()%> </td>
                <td> <%= a.getUsername()%> </td>
                <td> <%= a.getNama_panjang()%> </td>
                <td> <%= a.getDeskripsi()%> </td>
                <td> <%= a.getCreated_at()%> </td>
                <td> 
                    <a href="pending/permit?act=approve&id=<%= a.getId()%>" class="btn btn-default btn-success">Approve</a>
                    <a href="pending/permit?act=reject&id=<%= a.getId()%>" class="hapus btn btn-default btn-danger">Reject</a>                               
                </td>
            </tr>
            <%}
            } else {%>
            <h4 class="text-primary">Belum ada permohonan yang tercatat.</h4>
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