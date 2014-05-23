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

<% //LowonganModel lm = new LowonganModel();%>
<% //ArrayList<Lowongan> listLowongan = lm.selectAll("jojoeffe");
   //System.out.println("ListLowongan:"+listLowongan.get(0).getJudul());%>

<div class="container">
    <div class="title">
        Daftar Lowongan
        <br>
        <a href="<%=request.getContextPath()%>/lowongan/add">
            <button type="button" class="btn-lg">
                Tambah Lowongan
            </button>
        </a>
    </div>
    <% ArrayList<Lowongan> listLowongan = (ArrayList<Lowongan>) request.getAttribute("listLowongan");%>
    <% out.println(listLowongan.size());%>
    <% for(int ii=0;ii<listLowongan.size();ii++){ %>
    
    <div class="row">
        <div class ="col-xs-1">
            Delete
        </div>
        <div class ="col-xs-7">
            <b> <%out.print(listLowongan.get(ii).getJudul());%> </b>
            <br><%out.print(listLowongan.get(ii).getJabatan());%>
        </div>
        <div class ="col-xs-2">
            Close Recruitment
        </div>
        <div class ="col-xs-1">
            <a href="<%=request.getContextPath()%>/lowongan/edit?id=13">
                <button type="submit" class="btn btn-default btn-success">Details</button>
            </a>
        </div>
        <div class ="col-xs-1">
            Manage Pendaftar
        </div>  
    </div>
    <%}%>
</div>
<%@include file="/WEB-INF/footer.jspf" %>

