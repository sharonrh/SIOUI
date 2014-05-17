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

<%
    if (session.getAttribute("currentUser")
            != null) {
%>
<h1>Selamat Datang di Sistem Backend SIOUI.</h1>
<p>Silakan pilih menu di atas untuk melakukan perubahan data organisasi Anda.</p>
<%
} else {
%>
<form class="form-horizontal" role="form" method="POST" action="index/login">
    <div class="form-group">
        <label for="namaPanjang" class="col-sm-2 control-label">Username</label>
        <div class="col-sm-3">
            <input name="id_user" type="text" class="form-control" id="namaPanjang">
        </div>
    </div>
    <div class="form-group">
        <label for="namaPanjang" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-3">
            <input name="pass" type="password" class="form-control" id="namaPanjang">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-success">Login</button>
        </div>
    </div>
</form>



<%
    }
%>

<%@include file="/WEB-INF/footer.jspf" %>

