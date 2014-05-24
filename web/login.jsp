<%-- 
    Document   : login
    Created on : May 24, 2014, 3:57:06 PM
    Author     : Johanes
--%>

<%@include file="/WEB-INF/header.jsp" %>
<!-- Slider Start -->

<%
    Object objNotif = request.getParameter("status");
    String notif = ((objNotif != null) ? (String) objNotif : null);
%>

<div class="container">
    <!-- Heading -->
    <h4><i class="fa fa-sign-in"></i> Gunakan akun JUITA Anda untuk login ke SIOUI.</h4>

    <div class="alert alert-success <%if (notif == null) {
            out.print("hide");
        }%>">
        <%=notif%>
    </div>

    <div class="col-md-4">
        <!-- Sign in Form Start -->
        <form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath()%>/login/dologin">
            <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-danger">Login</button>&nbsp;
                <button type="reset" class="btn btn-default">Reset</button>
            </div>
        </form>
    </div>
</div>

<%@include file="/WEB-INF/footer.jsp" %>

