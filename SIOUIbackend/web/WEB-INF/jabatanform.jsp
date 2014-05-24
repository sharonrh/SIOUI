<%-- 
    Document   : jabatanform
    Created on : May 24, 2014, 12:15:43 AM
    Author     : Johanes
--%>


<%@page import="object.User"%>
<%@page import="object.Jabatan"%>


<% String activePage = "struktur"; %>
<%@include file="header.jspf" %>

<%
    Object objJabatan = request.getAttribute("jabatan");
    Object objTitle = request.getAttribute("title");
    Object objRole = request.getAttribute("role");
    Object objNotif = request.getAttribute("notif");
    Object objUser = session.getAttribute("currentUser");

    User u;
    if (objUser != null) {
        u = (User) objUser;
    } else {
        //redirect here
    }

    Jabatan a = ((objJabatan != null) ? (Jabatan) objJabatan : null);
    String title = ((objTitle != null) ? (String) objTitle : null);
    String role = ((objRole != null) ? (String) objRole : null);
    String notif = ((objNotif != null) ? (String) objNotif : null);


%>
<div class="container">
    <div class="title">
        <%=title%>
    </div>
    <form class="form-horizontal" role="form" method="POST" action="<% if (request.getAttribute("formAction") != null) {
            out.print(request.getAttribute("formAction").toString());
        } %>">
        <div class="form-group">
            <label class="col-sm-2 control-label">Nama Pejabat</label>
            <div class="col-sm-3">
                <input type="text" name="nama" class="form-control" value="<%if (a != null) {
                        out.print(a.getNama());
                    }%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Nama Jabatan</label>
            <div class="col-sm-3">
                <input type="text" name="jabatan" class="form-control" value="<%if (a != null) {
                        out.print(a.getJabatan());
                    }%>">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default btn-success"><%=role%> jabatan</button>
            </div>
        </div>
    </form>
</div>



<%@include file="footer.jspf" %>