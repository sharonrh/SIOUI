<%-- 
    Document   : lowongan
    Created on : May 13, 2014, 12:11:29 AM
    Author     : daniel.januar
--%>

<%@page import="object.Lowongan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.LowonganModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String activePage = "lowongan";%>
<%@include file="/WEB-INF/header.jspf" %>

<div class="alert <%=request.getAttribute("alertType")%>">
    <%=request.getAttribute("alertContent")%>
</div>

<div class="row">
    <div class="title">
        Daftar Lowongan
    </div>
</div>
<div class="container">
    <div class="col-lg-12"> 
        <a href="<%=request.getContextPath()%>/lowongan/form" class="btn-lg btn-success pull-left">
            Tambah Lowongan 
        </a>
        <table class="table table-hover table-striped">
            <thead>    
            <th>  </th>
            <th> Nama Lowongan </th>
            <th> Status </th>
            <th> Action </th>
            </thead>      

            <% ArrayList<Lowongan> listLowongan = (ArrayList<Lowongan>) request.getAttribute("listLowongan");%>
            <% for (int ii = 0; ii < listLowongan.size(); ii++) {%>

            <tr>
                <td> 
                    <a href="<%=request.getContextPath()%>/lowongan/delete?id=<%out.print(listLowongan.get(ii).getId());%>">
                        <button type="submit" class="hapus btn btn-default btn-danger">Delete</button>
                    </a>
                <td> 
                    <b> <%out.print(listLowongan.get(ii).getJudul());%> </b>
                    <br><%out.print(listLowongan.get(ii).getJabatan());%>
                </td>
                <td> Close Recruitment </td>  
                <td>            
                    <a href="<%=request.getContextPath()%>/lowongan/form?id=<%out.print(listLowongan.get(ii).getId());%>">
                        <button type="submit" class="btn btn-default btn-info">Details</button>
                    </a>

                    <a href="<%=request.getContextPath()%>/daftar-pelamar?id=<%out.print(listLowongan.get(ii).getId());%>">
                        <button type="submit" class="btn btn-default btn-info">Manage Pendaftar</button>
                    </a>
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

