<%-- 
    Document   : form-lowongan
    Created on : May 12, 2014, 11:54:47 AM
    Author     : daniel.januar
--%>

<%@page import="object.Lowongan"%>
<%@page import="model.LowonganModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String activePage="lowongan";%>
<%@include file="/WEB-INF/header.jspf" %>

<div class="title">
    Detail Lowongan
</div>

<%
    Lowongan lw = (Lowongan) request.getAttribute("detailLowongan");
    String status = request.getAttribute("status").toString();
%>
<form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath()%>/lowongan/<%=status%>">
    <div class="form-group">
        <% if(status.equals("edit")){
            %><input name="id" type="hidden" id="id" value="<%=lw.getId()%>"><%
        }
        %>
        <label for="Jabatan" class="col-sm-2 control-label">Jabatan</label>
        <div class="col-sm-3">
            <input required name="jabatan" type="text" class="form-control" id="jabatan" value="<%if (lw.getJabatan()!= null) {
                    out.print(lw.getJabatan());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Judul</label>
        <div class="col-sm-3">
            <input required name="judul" type="text" class="form-control" id="judul" value="<%if (lw.getJudul() != null) {
                    out.print(lw.getJudul());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Kapasitas</label>
        <div class="col-sm-3">
            <input required min="0" name="kapasitas" type="number" class="form-control" id="kapasitas" value="<%if (lw.getKapasitas() != 0) {
                    out.print(lw.getKapasitas());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Waktu Buka</label>
       
        <div class="col-sm-3">
            <input required placeholder="yyyy-mm-dd hh:mm:ss" name="tanggal_buka" type="datetime" pattern="(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})" class="form-control" id="tanggal_buka" value="<%if (lw.getTanggal_buka() != null) {
                    out.print(lw.getTanggal_buka().substring(0, lw.getTanggal_tutup().length()-2));}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Waktu Tutup</label>
        
        <div class="col-sm-3">
            <input required placeholder="yyyy-mm-dd hh:mm:ss" name="tanggal_tutup" type="datetime" pattern="(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})" class="form-control" id="tanggal_tutup" value="<%if (lw.getTanggal_tutup() != null) {
                out.print(lw.getTanggal_tutup().substring(0, lw.getTanggal_tutup().length()-2));}%>" required/>
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
        <label for="inputEmail" class="col-sm-2 control-label">Angkatan Minimum</label>
        <div class="col-sm-3">
            <input required placeholder="1990-2020" name="minimum_tahun" type="number" min="1990" max="2020" class="form-control" id="minimum_tahun" value="<%if (lw.getMinimum_tahun() != 0) {
                    out.print(lw.getMinimum_tahun());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">IPK Minimum</label>
        <div class="col-sm-3">
            <input required step="0.1" min="0" max="4" name="minimum_ipk" type="number" class="form-control" id="minimum_ipk" value="<%if (lw.getMinimum_ipk() != 0) {
                    out.print(lw.getMinimum_ipk());}%>">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-sm-2 control-label">Kategori</label>
        <div class="col-sm-3">
            <textarea class="form-control" rows="1" id="kategori" name="kategori" placeholder="1 tag paling menggambarkan"><%if (lw.getKategori() != null) {
                    out.print(lw.getKategori());}%></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-success">
            <%if(status.equals("edit")){
                out.print("Update Lowongan");
            } else{
                out.print("Tambah Lowongan");
            }%>     
            </button>
        </div>
    </div>
</form>
<%@include file="/WEB-INF/footer.jspf" %>