<%-- 
    Document   : album
    Created on : May 1, 2014, 2:55:28 PM
    Author     : Johanes
--%>

<%@page import="object.Organization"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "album"; %>
<%@include file="header.jspf" %>

<div class="title">
    Album
</div>
<%
    Organization o = (Organization) request.getAttribute("hehe");
%>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail">
                <img src="http://sioui.cloudapp.net:8080/SIOUI/img/c3.jpg" alt="...">
                <div class="caption">
                    <h3>Nama Album</h3>
                    <p>Created at: 26 April 2014</p>
                    <p>
                        <a href="#" class="btn btn-xs btn-success" role="button">Manage</a>  
                        <a href="#" class="btn btn-xs btn-danger" role="button">Delete</a>
                    </p>
                </div>
            </div>
        </div>

    </div>
</div>
