<%-- 
    Document   : album
    Created on : May 1, 2014, 2:55:28 PM
    Author     : Johanes
--%>

<%@page import="object.Organization"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "album"; %>
<%@include file="header.jspf" %>

<h1>Album!</h1>
<%
    Organization o = (Organization)request.getAttribute("hehe");
    out.print(o.getNamaPanjang());
%>
