<%-- 
    Document   : daftar-sekarang
    Created on : Apr 17, 2014, 1:56:51 PM
    Author     : daniel.januar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

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
        <form class="form-horizontal" role="form" method="POST" action="RegisterServlet">
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" id="name_panjang" placeholder="Nama panjang">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="email" class="form-control" id="email_pendek" placeholder="Nama pendek">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <select name = "jenis">
                        <option value="ukm">UKM</option>
                        <option value="ukf">UKF</option>
                        <option value="event">Event</option>
                    </select>
                    <label class="control-label"> Jenis organisasi</label>
                </div> 
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <input type="date" name ="tanggal_berdiri"/>                
                    <label class="control-label">Tanggal Berdiri</label>
                </div> 
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" id="username" placeholder="Alamat">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <textarea class="form-control" placeholder="Deskripsi" name="deskripsi"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <textarea class="form-control" placeholder="Visi" name="visi"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Accept All Terms & Conditions
                        </label>
                        <span class="pull-right"><a href="#">View</a></span>
                        <div class="clearfix"></div>
                    </div>
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
<%@include file="footer.jsp" %>