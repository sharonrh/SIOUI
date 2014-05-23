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

<script>
    function submitForm(action)
    {
        document.getElementById('form-image').action = action;
        document.getElementById('form-image').submit();
    }
</script>

<%
    Object objAlbum = request.getAttribute("album");
    Object objUser = session.getAttribute("currentUser");
    Object objRole = request.getAttribute("role");
    Object objTitle = request.getAttribute("title");
    Object objNotif = request.getAttribute("notif");

    User u;
    if (objUser != null) {
        u = (User) objUser;
    } else {
        //redirect here
    }

    Album a = ((objAlbum != null) ? (Album) objAlbum : null);
    String role = ((objRole != null) ? (String) objRole : null);
    String title = ((objTitle != null) ? (String) objTitle : null);
    String notif = ((objNotif != null) ? (String) objNotif : null);

%>

<div class="alert alert-success <%if (notif == null) {
        out.print("hide");
    }%>">
    <%=notif%>
</div>

<div class="title">
    <%if (request.getAttribute("title") != null) {
            out.print(request.getAttribute("title").toString());
        }%>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"><% if (title != null) {
                out.print(title);
            } %></h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" role="form" method="POST" action="<% if (request.getAttribute("formAction1") != null) {
                out.print(request.getAttribute("formAction1").toString());
            } %>">
            <div class="form-group">
                <label for="" class="col-sm-2 control-label">Nama Album</label>
                <div class="col-sm-3">
                    <input type="text" name="nama-album" class="form-control" value="<%if (a != null) {
                            out.print(a.getName());
                        }%>">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Deskripsi</label>
                <div class="col-sm-6">
                    <textarea class="form-control deskripsi-foto" rows="3" id="textarea" name="deskripsi-album"><%if (a != null) {
                            out.print(a.getDescription());
                        }%></textarea>
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

<div class="panel panel-default <% if (role != null && role.equals("create")) {
        out.print("hide");
    } %>">
    <div class="panel-heading">
        <h3 class="panel-title">Tambah Gambar</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" role="form" method="POST" enctype="multipart/form-data" action="<% if (request.getAttribute("formAction2") != null) {
                out.print(request.getAttribute("formAction2").toString());
            } %>">
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Pilih Gambar</label>
                <div class="col-sm-3">
                    <input type="file" name="file_gambar" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Deskripsi Gambar</label>
                <div class="col-sm-6">
                    <textarea class="form-control" rows="3" id="textarea" name="deskripsi"></textarea>
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



<div class="panel panel-default <% if (role != null && role.equals("create")) {
        out.print("hide");
    } %> ">
    <div class="panel-heading">
        <h3 class="panel-title">Isi Album</h3>
    </div>
    <div class="panel-body">
        <form id="form-image" class="form-horizontal" role="form" method="POST" action="">
            <div class="row">
                <%
                    if (a != null && a.getImages() != null) {
                        List<Image> images = a.getImages();
                        for (Image img : images) {
                %>
                <div class="col-sm-4 col-md-2">
                    <div class="thumbnail">
                        <img src="<%
                            if (img.getName() != null) {
                                out.print(request.getContextPath() + "/ImageAlbum?idorg=" + a.getId_organisasi() + "&idalbum=" + a.getId() + "&filename=" + img.getName());
                            }%>" alt="">
                        <div class="caption">
                            <textarea class="form-control deskripsi-foto" rows="3" id="textarea" name="imgdesc_<%=img.getId()%>"><%=img.getDescription()%></textarea>
                            <p>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="imgdelete_<%=img.getId()%>">hapus
                                </label>
                            </div>
                            </p>
                        </div>
                    </div>
                </div>
                <%}
                    }%>
            </div>

            <a href="#" class="btn btn-warning <% if (a == null || a.getImages().size()==0) {
                    out.print("hide");
                               } %>" role="button" onclick="submitForm('<% if (request.getAttribute("formAction3") != null) {
                                   out.print(request.getAttribute("formAction3").toString());
                } %>')">Update All</a>
            <a href="#" class="hapus btn btn-danger <% if (a == null || a.getImages().size()==0) {
                    out.print("hide");
                }%>" role="button" onclick="submitForm('<% if (request.getAttribute("formAction4") != null) {
                        out.print(request.getAttribute("formAction4").toString());
                    }%>')">Delete Selected</a>
        </form>
    </div>
</div>     
<script>
$( document ).ready( function() {
		$( ".hapus" ).bind( "click", function(event) {
			if( !confirm( 'Anda yakin untuk menghapus data ini?' ) ){
				 event.preventDefault();
			}
		});

});
</script>

<%@include file="/WEB-INF/footer.jspf" %>