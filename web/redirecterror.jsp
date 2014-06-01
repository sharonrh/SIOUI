<%-- 
    Document   : redirecterror.jsp
    Created on : Jun 1, 2014, 3:15:02 PM
    Author     : Johanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page isErrorPage="true" %>

<% response.sendRedirect("/errorpage.jsp");     %>
