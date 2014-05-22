<%-- 
    Document   : album
    Created on : May 1, 2014, 2:55:28 PM
    Author     : Johanes
--%>

<%@page import="object.Organisasi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="object.Album"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "album"; %>
<%@include file="/WEB-INF/header.jspf" %>

<%
    Object objAlbums = request.getAttribute("albums");
    ArrayList<Album> albums = ((objAlbums != null) ? (ArrayList<Album>) objAlbums : null);
%>

<div class="title">
    Album
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
            <a href="album/add" class="btn btn-success pull-right" role="button">Create Album</a> 
        </div>
    </div>

    <%
        if (albums != null) {
            for (int i = 0; i < albums.size(); i++) {
    %>
    <div class="col-sm-4 col-md-3">
        <div class="thumbnail">
            <img src="http://sioui.cloudapp.net:8080/SIOUI/img/c3.jpg" alt="...">
            <div class="caption">
                <h3><% out.print(albums.get(i).getName()); %></h3>
                <p><% %></p>
                <p>
                    <a href="<%= request.getContextPath() %>/album/edit?id=<%=albums.get(i).getId()%>" class="btn btn-xs btn-success" role="button">Manage</a>  
                    <a href="#" class="btn btn-xs btn-danger" role="button">Delete</a>
                </p>
            </div>
        </div>
    </div>
    <%
            }
        }
    %>
</div>
    <%@include file="/WEB-INF/footer.jspf" %>
