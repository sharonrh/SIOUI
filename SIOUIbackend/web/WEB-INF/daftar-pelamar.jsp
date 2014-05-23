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
<% ArrayList<Pelamar> listPelamar = (ArrayList<Pelamar>) request.getAttribute("listPelamar");%>

<div class="container">
    <div class="title">
        Daftar Pelamar
    </div>
    <div class="row">
        <div class ="col-xs-1">
            No
        </div>
        <div class ="col-xs-8">
            Nama
        </div>
        <div class ="col-xs-3">
            Action
        </div>
    </div>
    <% for(int ii=0;ii<listPelamar.size();ii++){ %>
    <div class="row">
        <div class ="col-xs-1">
            <%=ii+1%>
        </div>
        <!-- Nanti webservicenya taro di bagian sini-->
        <div class ="col-xs-8">
            <b> <%=listPelamar.get(ii).getUsername()%> </b>
        </div>
        <div class ="col-xs-3">
            Details
        </div>
    </div>
    <%}%>
    
</div>


<%@include file="/WEB-INF/footer.jspf" %>

