<%-- 
    Document   : album
    Created on : May 25, 2014, 5:39:00 PM
    Author     : Johanes
--%>


<%@page import="object.Image"%>
<%@page import="object.Organisasi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="object.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "album"; %>
<%@include file="/WEB-INF/header.jsp" %>

<%
    Object objAlbums = request.getAttribute("albums");
    ArrayList<Album> albums = ((objAlbums != null) ? (ArrayList<Album>) objAlbums : null);

    Object objOrg = request.getAttribute("org");

    Organisasi org = ((objOrg != null) ? (Organisasi) objOrg : null);

    Object objAlbumDipilih = request.getAttribute("albumDipilih");
    Album albumDipilih = ((objAlbumDipilih != null) ? (Album) objAlbumDipilih : null);
%>




<!-- BODY DIMULAI -->
<div class="inner-page">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <!-- Inner Page Content Sidebar -->
                <div class="page-sidebar">
                    <!-- Page Title -->
                    <div class="page-title br-green">
                        <!-- Inner Page Title // Heading -->
                        <h2>Album <%=org.getNama_pendek()%></h2>
                        <!-- Paragraph -->
                        <p><%=org.getDeskripsi()%></p>
                    </div>
                    <!-- Sidebar Links -->
                    <div class="sidebar-link col-disable">
                        <!-- Search Box -->
                        <div class="search">
                            <!--
                            <form>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Text to search">
                                    <span class="input-group-btn">
                                        <button class="btn" type="button"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </form>-->
                        </div>
                        <ul class="list-unstyled">
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>" class="animated">Profil <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>#oprec" class="animated">Daftar Lamaran <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showdetailorg?id=<%=org.getId()%>#strukturid" class="animated">Struktur Organisasi <i class="fa fa-angle-double-right"></i></a></li>
                            <li><a href="<%=request.getContextPath()%>/explore/showalbums?id=<%=org.getId()%>" class="animated">Gallery <i class="fa fa-angle-double-right"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>




            <!-- Main-bar Column -->
            <div class="col-md-9">
                <% if (albums != null && albumDipilih!=null) { %>
                <div class="page-mainbar aboutus">

                    <div class="carousel slide" id="carousel-220145">
                        <ol class="carousel-indicators">
                            <li class="active" data-slide-to="0" data-target="#carousel-220145"></li>
                            <li data-slide-to="1" data-target="#carousel-220145"></li>
                            <li data-slide-to="2" data-target="#carousel-220145"></li>
                        </ol>
                        <div class="carousel-inner">
                            <%
                                int ii = 0;
                                for (Image img : albumDipilih.getImages()) {
                            %>
                            <div class="item <% if (ii == 0) {
                                        out.print("active");
                                    } %>">
                                <img alt="" src="<%
                                    if (img.getName() != null) {
                                        out.print(request.getContextPath() + "/ImageAlbum?idorg=" + org.getId() + "&idalbum=" + albumDipilih.getId() + "&filename=" + img.getName());
                                    }%>">	
                                <div class="carousel-caption">
                                    <p>
                                        <%=img.getDescription()%>
                                    </p>
                                </div>
                            </div>
                            <%ii++;
                                        }%>
                        </div>
                        <a data-slide="prev" href="#carousel-220145" class="left carousel-control">‹</a>
                        <a data-slide="next" href="#carousel-220145" class="right carousel-control">›</a>
                    </div>
                        <br><hr><br>
                    <%
                        if (albums != null) {
                            for (int i = 0; i < albums.size(); i++) {
                    %>
                    <div class="col-sm-4 col-md-3">
                        <div class="thumbnail">
                            <img src="<%
                                Image img = albums.get(i).getRandomImage();
                                if (img != null && img.getName() != null) {
                                    out.print(request.getContextPath() + "/ImageAlbum?idorg=" + albums.get(i).getId_organisasi() + "&idalbum=" + albums.get(i).getId() + "&filename=" + img.getName());
                                }%>" alt="...">

                            <div class="caption">
                                <h3><% out.print(albums.get(i).getName());%></h3>
                            </div>
                            <a href="<%= request.getContextPath()%>/explore/showalbums?id=<%=org.getId()%>&idalbum=<%=albums.get(i).getId()%>" class="btn btn-xs btn-success" role="button">Preview</a>  
                    
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
                <%}else{
                    out.print("Saat ini organisasi ini belum mempunyai album.");
                }%>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/footer.jsp" %>