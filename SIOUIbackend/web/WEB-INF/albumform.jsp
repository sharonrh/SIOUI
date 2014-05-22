<%-- 
    Document   : albumform
    Created on : May 16, 2014, 10:22:38 PM
    Author     : Johanes
--%>

<%@page import="java.util.List"%>
<%@page import="object.Image"%>
<%@page import="java.util.ArrayList"%>
<%@page import="object.User"%>
<%@page import="object.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "album";%>
<%@include file="header.jspf" %>

<%
    Object objAlbum = request.getAttribute("album");
    Object objUser = session.getAttribute("currentUser");
    Object objRole = request.getAttribute("role");
    Object objTitle = request.getAttribute("title");
    
    
    User u;
    if(objUser!=null){
        u = (User)objUser;
    }else{
        //redirect here
    }
    
    Album a = ((objAlbum!=null) ? (Album)objAlbum : null);
    String role = ((objRole!=null) ? (String) objRole : null);
    String title = ((objTitle!=null) ? (String)objTitle : null);
    
%>

<div class="title">
    <%if(request.getAttribute("title")!=null){out.print(request.getAttribute("title").toString());}%>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"><% if(title!=null){ out.print(title); } %></h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" role="form" method="POST" action="<% if(request.getAttribute("formAction1")!=null){ out.print(request.getAttribute("formAction1").toString()); } %>">
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Nama Album</label>
                <div class="col-sm-3">
                    <input type="text" name="nama-album" class="form-control" id="inputEmail" value="<%if(a!=null){out.print(a.getName());}%>">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Deskripsi</label>
                <div class="col-sm-6">
                    <textarea class="form-control deskripsi-foto" rows="3" id="textarea" name="deskripsi-album"><%if(a!=null){out.print(a.getDescription());}%></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default btn-success">Update Informasi Album</button>
                </div>
            </div>
        </form>
    </div>
</div>
                
        
<div class="panel panel-default <% if(role!=null&&role.equals("create")){ out.print("hide"); } %>">
    <div class="panel-heading">
        <h3 class="panel-title">Tambah Gambar</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" enctype="multipart/form-data" role="form" method="POST" action="<% if(request.getAttribute("formAction2")!=null){ out.print(request.getAttribute("formAction2").toString()); } %>">
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Pilih Gambar</label>
                <div class="col-sm-3">
                    <input type="file" id="inputEmail">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Deskripsi Gambar</label>
                <div class="col-sm-6">
                    <textarea class="form-control" rows="3" id="textarea" name="textarea"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default btn-success">Tambah Gambar</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="panel panel-default <% if(role!=null&&role.equals("create")){ out.print("hide"); } %> ">
    <div class="panel-heading">
        <h3 class="panel-title">Isi Album</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" role="form" method="POST" action="<% if(request.getAttribute("formAction3")!=null){ out.print(request.getAttribute("formAction3").toString()); } %>">
            <div class="row">
                <%
                    if(a!=null&&a.getImages()!=null){
                        List<Image> images = a.getImages();
                        for(Image img:images){                
                %>
                <div class="col-sm-4 col-md-2">
                    <div class="thumbnail">
                        <img src="http://sioui.cloudapp.net:8080/SIOUI/img/c3.jpg" alt="">
                        <div class="caption">
                            <textarea class="form-control deskripsi-foto" rows="3" id="textarea" name=""><%=img.getDescription()%></textarea>
                            <p>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox">hapus
                                </label>
                            </div>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <a href="#" class="btn btn-warning" role="button">Update All</a>
            <a href="#" class="btn btn-danger" role="button">Delete Selected</a>
        </form>
    </div>
</div>




<%@include file="footer.jspf" %>
        