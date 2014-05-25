<%-- 
    Document   : daftar-sekarang
    Created on : Apr 17, 2014, 1:56:51 PM
    Author     : daniel.januar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/header.jsp" %>

<%
    String regStatus = request.getParameter("register");
    if (regStatus != null) {
        if (regStatus.equals("success")) {
%>
<div class="alert alert-success">Registrasi Anda telah tercatat. Mohon tunggu konfirmasi selanjutnya di email.</div>
<%
        }
    }
%>
<div class="container"> 
    <div class="col-md-4">
        <h2>Registration</h2>
        <!-- Sign Up Form Start -->
        <form class="form-horizontal" role="form" method="POST" action="/daftar-organisasi/add">
            <div class="form-group">
                <div class="col-sm-12">
                    <input name="username_organisasi" type="text" class="form-control" id="username" placeholder="username untuk backend">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input name="password" type="password" class="form-control" placeholder="password backend">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" id="nama_panjang" placeholder="Nama panjang">
                </div>
            </div>  
            <div class="form-group">
                <div class="col-sm-12">
                    <textarea class="form-control" placeholder="Deskripsi singkat mengenai organisasimu untuk diverifikasi oleh admin" name="deskripsi"></textarea>
                </div>
            </div>
            <div class="form-group text-center">
                <div class="col-sm-12">
                    <button type="submit" class="btn btn-black">Registration</button>&nbsp;
                    <button type="reset" class="btn btn-default">Reset</button>
                </div>
            </div>
        </form>
        <!-- Sign Up form End -->
    </div>
</div>
<%@include file="/WEB-INF/footer.jsp" %>