<%@page import="bean.NotifBean"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Title here -->
        <title>Sistem Informasi Organisasi Universitas Indonesia</title>
        <!-- Description, Keywords and Author -->
        <meta name="description" content="Your description">
        <meta name="keywords" content="Your,Keywords">
        <meta name="author" content="ResponsiveWebInc">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Styles -->
        <!-- Bootstrap CSS -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <!-- Animate CSS -->
        <link href="<%=request.getContextPath()%>/css/animate.min.css" rel="stylesheet">
        <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
        <link href="<%=request.getContextPath()%>/css/settings.css" rel="stylesheet">
        <!--[if IE ]><link rel="stylesheet" href="css/settings-ie8.css"><![endif]-->
        <!-- Portfolio CSS -->
        <link href="<%=request.getContextPath()%>/css/prettyPhoto.css" rel="stylesheet">
        <!-- Countdown CSS -->
        <link href="<%=request.getContextPath()%>/css/jquery.countdown.css" rel="stylesheet">
        <!-- Font awesome CSS -->
        <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet">		
        <!-- Custom CSS -->
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">

        <link href="css/style-joef.css" rel="stylesheet">
        <!--[if IE]><link rel="stylesheet" href="<%=request.getContextPath()%>/css/ie-style.css"><![endif]-->

        <!-- Favicon -->
        <link rel="shortcut icon" href="#">
    </head>

    <body>

        <!-- Body Wrapper -->
        <div class="wrapper white">

            <!-- Header Start -->
            <div class="header">
                <!-- Header Information -->
                <div class="header-info">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4 col-sm-4">
                                <!-- Social Media -->
                                <div class="social">
                                    <a href="http://www.facebook.com/moelolieverywhere" class="facebook"><i class="fa fa-facebook"></i></a>
                                    <a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a>
                                    <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                                    <a href="#" class="pinterest"><i class="fa fa-pinterest"></i></a>
                                    <a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <!-- Search Box -->
                                <div class="search">
                                    <form>
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Text to search">
                                            <span class="input-group-btn">
                                                <button class="btn" type="button"><i class="fa fa-search"></i></button>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <!-- Contact Info -->
                                <div class="contact-info">
                                    <span><i class="fa fa-phone br-lblue"></i> <strong>0812 816 2864</strong></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Header Navigation -->
                <div class="header-navigation">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4">
                                <!-- Logo -->
                                <div class="logo">
                                    <!-- Heading -->
                                    <h1><a href="<%=request.getContextPath()%>"><i class="fa fa-eye-slash br-red"></i> SIOUI</a></h1>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <!-- Bootstrap Navbar -->
                                <nav class="navbar navbar-default" role="navigation">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle br-orange" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                    </div>
                                    <!-- Collect the nav links, forms, and other content for toggling -->
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav navbar-right">
                                            <li>
                                                <a href="<%=request.getContextPath()%>" class="br-orange">
                                                    <!-- Link Icon -->
                                                    <i class="fa fa-home link-icon"></i>
                                                    <!-- Link Title -->
                                                    <span class="link-title">Home</span>
                                                </a>
                                            </li>
                                            <%
                                                // jika user belum login
                                                if (session.getAttribute("currentUser") == null) {
                                            %>
                                            <li class="dropdown">
                                                <a href="" class="dropdown-toggle br-pink" data-toggle="dropdown">
                                                    <!-- Link Icon -->
                                                    <i class="fa fa-unlock link-icon"></i>
                                                    <!-- Link Title -->
                                                    <span class="link-title">Login <b class="fa fa-angle-down"></b></span> 
                                                </a>
                                                <ul class="dropdown-menu dropdown-default dropdown-login">
                                                    <form class="form login-nav-form" role="form" method="POST" action="<%=request.getContextPath()%>/login/dologin">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                                        </div>
                                                        <div class="form-group pull-right">
                                                            <button type="submit" class="btn btn-danger">Login</button>
                                                        </div>
                                                    </form>
                                                </ul>
                                            </li>
                                            <%}%>
                                            <%
                                                // jika user sudah login
                                                if (session.getAttribute("currentUser") != null) {
                                                    String username = session.getAttribute("currentUser").toString();
                                                    NotifBean nb = (NotifBean)session.getAttribute(username+"_notif");
                                            %>
                                            <li class="dropdown">
                                                <a href="<%=request.getContextPath()%>" class="dropdown-toggle br-purple" data-toggle="dropdown">
                                                    <!-- Link Icon -->
                                                    <i class="fa fa-dashboard link-icon"></i>
                                                    <!-- Link Title -->
                                                    <span class="link-title">Dashboard <b class="fa fa-angle-down"></b></span> 
                                                </a>
                                                <ul class="dropdown-menu dropdown-sm dashboard-dropdown">
                                                    <li>
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="col-inner">
                                                                    <ul class="list-unstyled">
                                                                        <li><a href="#"><span class="number-notif"><%=nb.getNotifications().size() %></span> Notifikasi</a></li>
                                                                        <li><a href="#"><span class="number-notif"><%=nb.getCloseRec().size() %></span> Close Recruitment</a></li>
                                                                        <li><a href="#"><span class="number-notif"><%=nb.getPendaftaranku().size() %></span> Pendaftaranku</a></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="dropdown">
                                                <a href="<%=request.getContextPath()%>/login/dologout" class="dropdown-toggle br-black">
                                                    <!-- Link Icon -->
                                                    <i class="fa fa-unlock link-icon"></i>
                                                    <!-- Link Title -->
                                                    <span class="link-title">Logout</span> 
                                                </a>
                                            </li>
                                            <%}%>
                                            <li class="dropdown">
                                                <a class="dropdown-toggle br-lblue" data-toggle="dropdown">
                                                    <!-- Link Icon -->
                                                    <i class="fa fa-group link-icon"></i>
                                                    <!-- Link Title -->
                                                    <span class="link-title">Explore <b class="fa fa-angle-down"></b></span> 
                                                </a>
                                                <ul class="dropdown-menu dropdown-md">
                                                    <li>
                                                        <div class="row">
                                                            <div class="col-md-4">
                                                                <div class="col-inner col-disable">
                                                                    <!-- Heading -->
                                                                    <h4 class="br-green"><i class="fa fa-filter heading-icon"></i> UKM</h4>
                                                                    <!-- Paragraph -->
                                                                    <p>Unit Kegiatan Mahasiswa merupakan organisasi tetap yang terbuka untuk seluruh mahasiswa Universitas Indonesia.</p>
                                                                    <div class="view-button">
                                                                        <a href="<%=request.getContextPath() %>/explore/showlistorg?jenis=ukm" class="btn btn-danger btn-sm">Lihat Daftar UKM <i class="fa fa-angle-right"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="col-inner col-disable">
                                                                    <!-- Heading -->
                                                                    <h4 class="br-yellow"><i class="fa fa-ticket heading-icon"></i> UKF</h4>
                                                                    <!-- Paragraph -->
                                                                    <p>Unit Kegiatan Fakultas merupakan organisasi tetap yang dikhususkan untuk mahasiswa Fakultas Ilmu Komputer UI.</p>
                                                                    <!-- View Next Button -->
                                                                    <div class="view-button">
                                                                        <a href="<%=request.getContextPath() %>/explore/showlistorg?jenis=ukf" class="btn btn-danger btn-sm">Lihat Daftar UKF <i class="fa fa-angle-right"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="col-inner col-disable">
                                                                    <!-- Heading -->
                                                                    <h4 class="br-blue"><i class="fa fa-filter heading-icon"></i> Event</h4>
                                                                    <!-- Paragraph -->
                                                                    <p>Event merupakan organisasi yang dikhususkan untuk pelaksanaan suatu event tertentu.</p>
                                                                    <div class="view-button">
                                                                        <a href="<%=request.getContextPath() %>/explore/showlistorg?jenis=event" class="btn btn-danger btn-sm">Lihat Daftar Event <i class="fa fa-angle-right"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </li>


                                            <li>
                                                <a href="about-us.jsp" class="br-red">
                                                    <!-- Link Icon -->
                                                    <i class="fa fa-user link-icon"></i>
                                                    <!-- Link Title -->
                                                    <span class="link-title">About</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div><!-- /.navbar-collapse -->
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->