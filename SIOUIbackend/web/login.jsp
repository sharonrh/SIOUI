<%-- 
    Document   : home
    Created on : May 21, 2014, 4:36:58 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <!-- Bootstrap CSS -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <!--<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>-->
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="col-md-6 col-md-offset-3 content"> 
                <div class="title">
                    Login
                </div>
                <div class="alert <%=request.getAttribute("alertType")%>">
                    <%=request.getAttribute("alertContent")%>
                </div>
                <form class="form-horizontal" role="form" method="POST" action="index/login">
                    <div class="form-group">
                        <label for="namaPanjang" class="col-sm-2 control-label">Username</label>
                        <div class="col-sm-4">
                            <input name="id_user" type="text" class="form-control" id="namaPanjang">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="namaPanjang" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-4">
                            <input name="pass" type="password" class="form-control" id="namaPanjang">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default btn-success">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
