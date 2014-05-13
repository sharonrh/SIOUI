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

<%@include file="header.jspf" %>
<% LowonganModel lm = new LowonganModel();%>
<% ArrayList<Lowongan> listLowongan = lm.selectAll("jojoeffe");
   System.out.println("ListLowongan:"+listLowongan.get(0).getJudul());%>
<div class="container">
    <div class="title">
        Daftar Lowongan
        <br>
        <button type="button" class="btn-lg">Tambah Lowongan</button>
    </div>
    <% for(int ii=0;ii<listLowongan.size();ii++){ %>
    <div class="row">
        <div class ="col-xs-1">
            Delete
        </div>
        <div class ="col-xs-7">
            <b> <%=listLowongan.get(ii).getJudul()%> </b>
            <br><%=listLowongan.get(ii).getJabatan()%>
        </div>
        <div class ="col-xs-2">
            Close Recruitment
        </div>
        <div class ="col-xs-1">
            <a href="form-lowongan.jsp?id=<%=listLowongan.get(ii).getId()%>">Edit</a>
        </div>
        <div class ="col-xs-1">
            Manage Pendaftar
        </div>  
    </div>
    <%}%>
</div>
<%@include file="footer.jspf" %>

