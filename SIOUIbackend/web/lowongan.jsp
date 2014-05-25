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
<% ArrayList<Lowongan> listLowongan = (ArrayList<Lowongan>) request.getAttribute("listLowongan");%>

<div class="container">
    <div class="col-lg-12"> 
        <a href="<%=request.getContextPath()%>/lowongan/form" class="btn btn-success pull-left">
            Tambah Lowongan 
        </a>

        <table class="table table-hover table-striped">
            <% if (listLowongan.size() > 0) {%>
            <thead>    
            <th>  </th>
            <th> Nama Lowongan </th>
            <th> Kapasitas </th>
            <th> Tanggal buka</th>
            <th> Tanggal tutup</th>
            <th> </th>

            </thead>      

            <% for (Lowongan l : listLowongan) {%>
            <tr>
                <td> 
                    <a href="<%=request.getContextPath()%>/lowongan/delete?id=<%out.print(l.getId());%>">
                        <button type="submit" class="hapus btn btn-default btn-danger">Delete</button>
                    </a>
                <td> 
                    <b> <%=l.getJudul()%> </b>
                    <br><%=l.getJabatan()%>
                </td>
                <td> <%=l.getKapasitas()%> </td> 
                <td> <%=l.getTanggal_buka()%> </td> 
                <td> <%=l.getTanggal_tutup()%> </td> 

                <td>            
                    <a class="btn btn-default btn-primary" href="<%=request.getContextPath()%>/lowongan/form?id=<%out.print(l.getId());%>">
                        Edit
                    </a>

                    <a class="btn btn-default btn-primary" href="<%=request.getContextPath()%>/pelamar?id=<%out.print(l.getId());%>">
                        Manage Pendaftar
                    </a>    
                </td>  
            </tr>
            <%}
            } else {%>
            <h4 class="text-primary ">Belum ada lowongan yang tercatat.</h4>
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

