<%-- 
    Document   : index
    Created on : May 1, 2014, 11:07:16 AM
    Author     : Johanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String activePage = "home";%>

<%@include file="/WEB-INF/header.jspf" %>

<div class="alert <%=request.getAttribute("alertType")%>">
    <%=request.getAttribute("alertContent")%>
</div>

<h1>Selamat Datang di Sistem Backend SIOUI.</h1>
<p>Silakan pilih menu di atas untuk melakukan perubahan data organisasi Anda.</p>

<%@include file="/WEB-INF/footer.jspf" %>

