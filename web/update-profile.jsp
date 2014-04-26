<%-- 
    Document   : createOrganizationProfile
    Created on : Apr 26, 2014, 8:26:48 PM
    Author     : daniel.januar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div class="inner-page">
    <div class="container">
        <form class="form-horizontal" role="form" method="POST" action="RegisterServlet">
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Nama Panjang</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="nama_panjang">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Nama Pendek</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="nama_pendek">
                </div>
            </div>
            <!--div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Logo</label>
                <div class="col-sm-1">
                	<img src="http://sioui.cloudapp.net:8080/SIOUI/img/c3.jpg" width="80" class="img-thumbnail" alt="">
                </div>
                <div class="col-sm-3">
                    <input type="file" id="inputEmail">
                </div>
            </div-->
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Deskripsi</label>
                <div class="col-sm-8">
                    <textarea class="form-control" rows="6" id="textarea" name="deskripsi"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Visi</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="visi">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Jenis</label>
                <div class="col-sm-4">
                    <select id="selectbasic" name="jenis" class="form-control">
                        <option value="ukm">Unit Kegiatan Mahasiswa (UKM)</option>
                        <option value="ukf">Unit Kegiatan Fakultas (UKF)</option>
                        <option value="event">Event</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Alamat</label>
                <div class="col-sm-6">
                    <textarea class="form-control" rows="3" id="textarea" name="alamat"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default btn-success">Update Profil</button>
                </div>
            </div>
        </form>
    </div>
</div>


<%@include file="footer.jsp" %>