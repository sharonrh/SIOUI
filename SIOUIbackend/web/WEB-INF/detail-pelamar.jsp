<%-- 
    Document   : daftar-pelamar
    Created on : May 13, 2014, 4:24:49 PM
    Author     : daniel.januar
--%>

<%@page import="webservice.UserCV"%>
<%@page import="object.Pelamar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PelamarModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String activePage = "lowongan"; %>

<%@include file="/WEB-INF/header.jspf" %>
<% UserCV cv = (UserCV) request.getAttribute("cv");

%>

<div class="title">
    Detail Pelamar
</div>

<div class="container">
    <div class="col-lg-10 col-lg-offset-1">

        <h2> <%=cv.getName()%> </h2>
        <br/>
        <dl class="dl-horizontal">
            <dt> Address </dt>
            <dd><%=cv.getAddress()%></dd>
        </dl>
        <dl class="dl-horizontal left">
            <dt> Phone </dt>
            <dd><%=cv.getPhoneNumber()%></dd>
        </dl>
        <dl class="dl-horizontal">
            <dt> Email </dt>
            <dd><%=cv.getEmail()%></dd>
        </dl>
        <hr>
        <dl>
            <dt> <h4> Objective </h4></dt>
            <dd><%=cv.getObjective()%></dd>
        </dl>
        <br>
        <dl>
            <dt> <h4> Qualification </h4></dt>
            <dd><%=cv.getQualification()%></dd>
        </dl>
        <hr>
        <!-- ntar looping work experience -->
        <h4> Work Experiences </h4>
        <hr>
        <dl>
            <dt> <h4> Interest </h4></dt>
            <dd><%=cv.getInterests()%></dd>
        </dl>
    </div>
</div>

<%@include file="/WEB-INF/footer.jspf" %>

