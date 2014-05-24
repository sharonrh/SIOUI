<%@page import="object.Organisasi"%>
<!-- 
    Document   : profil
    Created on : May 1, 2014, 11:41:09 AM
    Author     : Johanes
-->

<%@page import="model.OrganisasiModel"%>
<%@page import="object.Organisasi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "profil"; %>
<%@include file="/WEB-INF/header.jspf" %>

<div class="alert <%=request.getAttribute("alertType")%>">
    <%=request.getAttribute("alertContent")%>
</div>

<div class="title">
    Profil Organisasi
</div>
<%
    Organisasi org = (Organisasi) request.getAttribute("organization");
    System.out.println(org.getUsername());
%>


<form class="form-horizontal" role="form" method="POST" action="profil/edit" enctype="multipart/form-data">
    <div class="form-group">
        <label for="namaPanjang" class="col-sm-2 control-label">Nama Panjang</label>
        <div class="col-sm-3">
            <input required name="nama_panjang" type="text" class="form-control" id="namaPanjang" value="<%if (org.getNama_panjang() != null) {
                    out.print(org.getNama_panjang());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Nama Pendek</label>
        <div class="col-sm-3">
            <input required name="nama_pendek" type="text" class="form-control" id="inputEmail" value="<%if (org.getNama_pendek() != null) {
                    out.print(org.getNama_pendek());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Logo</label>
        <div class="col-sm-1">
            <img name="logo_img" src="<%
                if (org.getLogo() != null) {
                    out.print("ImageLogo?id="+ org.getId() +"\\" + org.getLogo());
                }
                 %>" width="80" class="img-thumbnail" alt="">
        </div>
        <div class="col-sm-3">
            <input name="file_logo" type="file" id="file_logo" >
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Deskripsi</label>
        <div class="col-sm-8">
            <textarea class="form-control" rows="6" id="textarea" name="deskripsi"><%if (org.getDeskripsi() != null) {
                    out.print(org.getDeskripsi());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Visi</label>
        <div class="col-sm-3">
            <textarea class="form-control" rows="6" id="visi" name="visi"><%if (org.getVisi() != null) {
                    out.print(org.getVisi());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Jenis</label>
        <div class="col-sm-4">
            <select required id="selectbasic" name="jenis" class="form-control">
                <option value="ukm" <%if (org.getJenis() != null && org.getJenis().equals("ukm")) {
                        out.print("selected");}%>>Unit Kegiatan Mahasiswa (UKM)</option>
                <option value="ukf" <%if (org.getJenis() != null && org.getJenis().equals("ukf")) {
                        out.print("selected");}%>>Unit Kegiatan Fakultas (UKF)</option>
                <option value="event" <%if (org.getJenis() != null && org.getJenis().equals("event")) {
                        out.print("selected");}%>>Event</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Alamat</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" id="textarea" name="alamat"><%if (org.getAlamat() != null) {
                    out.print(org.getAlamat());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-success">Update Profil</button>
        </div>
    </div>
</form>



<%@include file="/WEB-INF/footer.jspf" %>