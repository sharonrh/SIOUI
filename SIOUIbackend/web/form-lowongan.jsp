<%-- 
    Document   : form-lowongan
    Created on : May 12, 2014, 11:54:47 AM
    Author     : daniel.januar
--%>

<%@page import="object.Lowongan"%>
<%@page import="model.LowonganModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String activePage="form-lowongan";%>
<%@include file="header.jspf" %>
<div class="title">
    Detail Lowongan
</div>
<%
    //Organization org = (Organization) request.getAttribute("organization");
    LowonganModel lm = new LowonganModel();
    System.out.println(request.getParameter("id"));
    Lowongan lw = lm.select(Integer.parseInt(request.getParameter("id")));
%>
<form class="form-horizontal">
    <div class="form-group">
        <label for="Jabatan" class="col-sm-2 control-label">Jabatan</label>
        <div class="col-sm-3">
            <input name="jabatan" type="text" class="form-control" id="jabatan" value="<%if (lw.getJabatan()!= null) {
                    out.print(lw.getJabatan());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Judul</label>
        <div class="col-sm-3">
            <input name="judul" type="text" class="form-control" id="judul" value="<%if (lw.getJudul() != null) {
                    out.print(lw.getJudul());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Kapasitas</label>
        <div class="col-sm-8">
            <input name="kapasitas" type="number" class="form-control" id="kapasitas" value="<%if (lw.getKapasitas() != 0) {
                    out.print(lw.getKapasitas());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Tanggal Buka</label>
        <div class="col-sm-3">
            <input name="tanggal_buka" type="datetime" class="form-control" id="tanggal_buka" value="<%if (lw.getTanggal_buka() != null) {
                    out.print(lw.getTanggal_buka());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Tanggal Buka</label>
        <div class="col-sm-3">
            <input name="tanggal_tutup" type="datetime" class="form-control" id="tanggal_tutup" value="<%if (lw.getTanggal_tutup() != null) {
                    out.print(lw.getTanggal_tutup());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Deskripsi</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" id="textarea" name="deskripsi"><%if (lw.getDeskripsi()!= null) {
                    out.print(lw.getDeskripsi());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Minimum Tahun</label>
        <div class="col-sm-3">
            <input name="minimum_tahun" type="number" class="form-control" id="minimum_tahun" value="<%if (lw.getMinimum_tahun() != 0) {
                    out.print(lw.getMinimum_tahun());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Minimum IPK</label>
        <div class="col-sm-3">
            <input name="ipk" type="number" class="form-control" id="ipk" value="<%if (lw.getMinimum_ipk() != 0) {
                    out.print(lw.getMinimum_ipk());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Kategori</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" id="kategori" name="kategori"><%if (lw.getKategori() != null) {
                    out.print(lw.getKategori());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-success">Update Profil</button>
        </div>
    </div>
</form>
<%@include file="footer.jspf" %>