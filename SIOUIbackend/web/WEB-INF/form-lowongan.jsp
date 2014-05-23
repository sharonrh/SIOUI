<%-- 
    Document   : form-lowongan
    Created on : May 12, 2014, 11:54:47 AM
    Author     : daniel.januar
--%>

<%@page import="object.Lowongan"%>
<%@page import="model.LowonganModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String activePage="Lowongan";%>
<%@include file="/WEB-INF/header.jspf" %>
<div class="title">
    Detail Lowongan
</div>
<div class="alert-info">
</div>
<%
    //Organization org = (Organization) request.getAttribute("organization");
    Lowongan lw = (Lowongan) request.getAttribute("detailLowongan");
    String status = request.getAttribute("status").toString();
    out.println(status);
%>
<form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath()%>/lowongan/<%=status%>">
    <div class="form-group">
        <% if(status.equals("edit")){
            %><input name="id" type="hidden" id="id" value="<%=lw.getId()%>"><%
        }
        %>
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
            <input name="tanggal_buka" type="datetime" pattern="(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})" class="form-control" id="tanggal_buka" value="<%if (lw.getTanggal_buka() != null) {
                    out.print(lw.getTanggal_buka());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Tanggal Buka</label>
        <div class="col-sm-3">
            <input name="tanggal_tutup" type="datetime" pattern="(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})" class="form-control" id="tanggal_tutup" value="<%if (lw.getTanggal_tutup() != null) {
                out.print(lw.getTanggal_tutup());}%>" required/>
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
            <input name="minimum_ipk" type="number" class="form-control" id="minimum_ipk" value="<%if (lw.getMinimum_ipk() != 0) {
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
            <button type="submit" class="btn btn-default btn-success">Update Lowongan</button>
        </div>
    </div>
</form>
<%@include file="/WEB-INF/footer.jspf" %>