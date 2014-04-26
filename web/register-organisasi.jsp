<%-- 
    Document   : registrationOrganisasi
    Created on : Apr 19, 2014, 3:32:04 AM
    Author     : daniel.januar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div class="inner-page">
    <div class="container">
        <form method="POST" action="RegistrationOrganisasiServlet">
            <input type="text" name="username" required/><br>
            <input type="text" name="password" required/><br>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>


<%@include file="footer.jsp" %>