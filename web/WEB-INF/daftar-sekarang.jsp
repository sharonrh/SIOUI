<%-- 
    Document   : daftar-sekarang
    Created on : Apr 17, 2014, 1:56:51 PM
    Author     : daniel.januar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/header.jsp" %>



<div class="container">
    <div class="col-md-12">
        <div class="col-md-3">
            
        </div>
    <div class="col-md-4">
        <div class="alert <%=request.getAttribute("alertType")%>">
        <%if(request.getAttribute("alertContent")!= null){
            out.print(request.getAttribute("alertContent"));};
        %>
        </div>
        <h2>Registration</h2>
        <!-- Sign Up Form Start -->
        <form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath()%>/daftar-organisasi/add">
            <div class="form-group">
                <label class="col-sm-2 control-label">Username</label>
                <div class="col-sm-8">
                    <input required name="username_organisasi" type="text" class="form-control" id="username" placeholder="username untuk backend">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Password</label>
                <div class="col-sm-8">
                    <input required name="password" type="password" class="form-control" placeholder="password backend">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Nama Panjang</label>
                <div class="col-sm-8">
                    <input required type="text" class="form-control" id="nama_panjang" placeholder="Nama panjang">
                </div>
            </div>  
            <div class="form-group">
                <label class="col-sm-2 control-label">Deskripsi</label>
                <div class="col-sm-8">
                    <textarea required class="form-control" rows="5" placeholder="Deskripsi singkat mengenai organisasimu untuk diverifikasi oleh admin" name="deskripsi"></textarea>
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
</div>
<%@include file="/WEB-INF/footer.jsp" %>