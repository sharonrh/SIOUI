<!-- 
    Document   : profil
    Created on : May 1, 2014, 11:41:09 AM
    Author     : Johanes
-->

<%@page import="model.OrganizationModel"%>
<%@page import="object.Organization"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "profile"; %>
<%@include file="header.jspf" %>

<div class="alert <%=request.getAttribute("alertType")%>">
    <%=request.getAttribute("alertContent")%>
</div>

<div class="title">
    Profil Organisasi
</div>
<%
    //Organization org = (Organization) request.getAttribute("organization");
    OrganizationModel om = new OrganizationModel();
    Organization o = om.select(1);
    System.out.println(o.getAlamat());
%>


<form class="form-horizontal" role="form" method="POST" action="profil/edit" enctype="multipart/form-data">
    <div class="form-group">
        <label for="namaPanjang" class="col-sm-2 control-label">Nama Panjang</label>
        <div class="col-sm-3">
            <input name="nama_panjang" type="text" class="form-control" id="namaPanjang" value="<%if (o.getNama_panjang() != null) {
                    out.print(o.getNama_panjang());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Nama Pendek</label>
        <div class="col-sm-3">
            <input name="nama_pendek" type="text" class="form-control" id="inputEmail" value="<%if (o.getNama_pendek() != null) {
                    out.print(o.getNama_pendek());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Logo</label>
        <div class="col-sm-1">
            <img name="logo_img" src="<%
                if (o.getLogo() != null) {
                    out.print("image?id="+ o.getId() +"\\" + o.getLogo());
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
            <textarea class="form-control" rows="6" id="textarea" name="deskripsi"><%if (o.getDeskripsi() != null) {
                    out.print(o.getDeskripsi());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Visi</label>
        <div class="col-sm-3">
            <input name="visi" type="text" class="form-control" id="inputEmail" value="<%if (o.getVisi() != null) {
                    out.print(o.getVisi());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Jenis</label>
        <div class="col-sm-4">
            <select id="selectbasic" name="jenis" class="form-control">
                <option value="ukm" <%if (o.getJenis() != null && o.getJenis().equals("ukm")) {
                        out.print("selected");}%>>Unit Kegiatan Mahasiswa (UKM)</option>
                <option value="ukf" <%if (o.getJenis() != null && o.getJenis().equals("ukf")) {
                        out.print("selected");}%>>Unit Kegiatan Fakultas (UKF)</option>
                <option value="event" <%if (o.getJenis() != null && o.getJenis().equals("event")) {
                        out.print("selected");}%>>Event</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Alamat</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" id="textarea" name="alamat"><%if (o.getAlamat() != null) {
                    out.print(o.getAlamat());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-success">Update Profil</button>
        </div>
    </div>
</form>



<%@include file="footer.jspf" %>