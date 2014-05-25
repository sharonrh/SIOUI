<%-- 
    Document   : index
    Created on : Mar 26, 2014, 10:29:13 PM
    Author     : Johanes
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.LowonganModel"%>
<%@page import="object.Lowongan"%>
<%@page import="org.apache.tomcat.util.http.Cookies"%>


<%@include file="/WEB-INF/header.jsp" %>
<!-- Slider Start -->

<div class="container">
    <% %>
    <!--
    #################################
            - THEMEPUNCH BANNER -
    #################################
    -->
    <div class="tp-banner-container">
        <div class="tp-banner" >
            <ul>
                <!-- SLIDE  -->
                <li data-transition="zoomout" data-slotamount="7" data-masterspeed="1000" >
                    <!-- MAIN IMAGE -->
                    <img src="img/slider/slide1.jpg"  alt="darkblurbg"  data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">
                    <!-- LAYERS -->

                </li>
                <!-- SLIDE  -->
                <li data-transition="zoomout" data-slotamount="7" data-masterspeed="1500" >
                    <!-- MAIN IMAGE -->
                    <img src="img/slider/slide2.jpg"  alt="slidebg1"  data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">
                    <!-- LAYERS -->


                </li>
                <!-- SLIDE  -->
                <li data-transition="zoomout" data-slotamount="7" data-masterspeed="1500" >
                    <!-- MAIN IMAGE -->
                    <img src="img/slider/slide3.jpg"  alt="slidebg1"  data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">


                </li>
            </ul>
        </div>
    </div>
</div>

<!-- Slider End -->

<!-- Box Wrapper -->
<div class="box-wrapper">
    <div class="container">
        <!--ROW BUATAN SENDIRI-->
        <div class="row">
            <div class="col-md-8 col-sm-8">
                <!-- Box Outer Layer [ Box 3 ] -->
                <div class="box box-lg br-red animated">
                    <div class="box-content box-service box-default">
                        <!-- Heading -->
                        <h4><i class="fa fa-trophy"></i> Lowongan Terbaru</h4>
                        <!-- Paragraph -->
                        <p>Lihat lowongan-lowongan baru yang butuh kontribusimu. Buruan daftar!</p>
                        <!-- Box Service List -->
                        <ul class="list-unstyled">
                            <div class="lowongan-home">
                                <li><i class="fa fa-check-square-o"></i> <b></b> </li>
                                    <p>
                                        <a href="lowongan-details.jsp?id_organisasi=&id_lowongan=" class="btn btn-warning pull-right btn-xs" > read more<i class="fa fa-angle-right"></i></a>
                                    </p>
                              
                            </div>
                            <hr>
                        </ul>
                    </div>
                </div>
            </div>
                        
            <div class="col-md-4 col-sm-4">

                <!-- Box Outer Layer [ Box 15 ] -->
                <div class="box box-md br-blue animated">
                    <div class="box-content box-login">
                        <!-- Heading -->
                        <h4><i class="fa fa-sign-in"></i> User Login</h4>
                        <!-- Sign in Form Start -->
                        <form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath() %>/dologin">
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
                <div class="box box-md pull-up-sm animated">
                    <div class="box-content box-gallery padd-zero">
                        <div class="img-details box-hover-black">
                            <!-- Heading -->
                            <h3>Daftarkan Organisasimu!</h3>
                            <!-- Paragraph -->
                            <p>Perekrutan menjadi lebih mudah. </p>
                            <!-- View Next Button -->
                            <div class="view-button">
                                <a href="<%=request.getContextPath()%>/daftar-organisasi" class="btn btn-danger">Daftar <i class="fa fa-angle-right"></i></a>
                            </div>
                        </div>
                        <!-- Image -->
                        <img src="img/nav1.jpg" class="img-responsive box-gallery-img" alt="" />
                    </div>
                </div>
            </div>
        </div>
        <div class="box box-lg br-orange animated">
            <div class="box-content box-service-counter box-default">
                <!-- Heading -->
                <h4><i class="fa fa-gears"></i> Recently Viewed</h4>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <!-- Box Outer Layer [ Box 3 ] -->
                        <div class="box-content box-service box-default">
                            <ul class="list-unstyled">
                                <div class="lowongan-home">
                                    <li><i class="fa fa-check-square-o"></i> <b></b></li>
                                    <p>
                                        
                                        <a href="lowongan-details.jsp?id=" class="btn btn-warning pull-right btn-xs">read more <i class="fa fa-angle-right"></i></a>
                                    </p>	
                                </div>
                                <hr>
                                <p>Anda belum melihat lowongan sama sekali.</p>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div></div>
    <!-- Box First Row -->
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-6">
                    <!-- Box Outer Layer [ Box 1 ] -->
                    <div class="box box-md br-green animated">
                        <!-- Box Hover Effect -->
                        <div class="box-hover box-hover-black">
                            <!-- Hover Icon -->
                            <span class="hover-icon">GO</span>
                        </div>
                        <!-- Box Link -->
                        <a href="about-us.jsp">
                            <!-- Box Link Content -->
                            <div class="box-content navigation">
                                <!-- Box Icon -->
                                <i class="fa fa-user"></i>
                                <!-- Box Title -->
                                <span class="box-title">About Us</span>
                            </div>
                        </a>
                    </div>	
                </div>
                <div class="col-md-6 col-sm-6 col-xs-6">
                    <!-- Box Outer Layer [ Box 2 ] -->
                    <div class="box box-md br-yellow animated">
                        <!-- Box Hover Effect -->
                        <div class="box-hover box-hover-black">
                            <!-- Hover Icon -->
                            <span class="hover-icon">GO</span>
                        </div>
                        <!-- Box Link -->
                        <a href="#">
                            <!-- Box Link Content -->
                            <div class="box-content navigation">
                                <!-- Box Icon -->
                                <i class="fa fa-book"></i>
                                <!-- Box Title -->
                                <span class="box-title">UKM</span>
                            </div>
                        </a>
                    </div>	
                </div>
                <div class="col-md-6 col-sm-6 col-xs-6">
                    <!-- Box Outer Layer [ Box 2 ] -->
                    <div class="box box-md br-yellow animated">
                        <!-- Box Hover Effect -->
                        <div class="box-hover box-hover-black">
                            <!-- Hover Icon -->
                            <span class="hover-icon">GO</span>
                        </div>
                        <!-- Box Link -->
                        <a href="#">
                            <!-- Box Link Content -->
                            <div class="box-content navigation">
                                <!-- Box Icon -->
                                <i class="fa fa-book"></i>
                                <!-- Box Title -->
                                <span class="box-title">UKF</span>
                            </div>
                        </a>
                    </div>	
                </div>
                <div class="col-md-6 col-sm-6 col-xs-6">
                    <!-- Box Outer Layer [ Box 2 ] -->
                    <div class="box box-md br-red animated">
                        <!-- Box Hover Effect -->
                        <div class="box-hover box-hover-black">
                            <!-- Hover Icon -->
                            <span class="hover-icon">GO</span>
                        </div>
                        <!-- Box Link -->
                        <a href="#">
                            <!-- Box Link Content -->
                            <div class="box-content navigation">
                                <!-- Box Icon -->
                                <i class="fa fa-book"></i>
                                <!-- Box Title -->
                                <span class="box-title">Event</span>
                            </div>
                        </a>
                    </div>	
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-6">
            <!-- Box Outer Layer [ Box 20 ] -->
            <div class="box box-lg animated">
                <div class="box-content slide-up box-gallery padd-zero">
                    <!-- Image -->
                    <img src="img/c3.jpg" class="img-responsive box-gallery-img" alt="" />
                    <!-- Image Gallery Caption -->
                    <div class="image-gallery-caption movetoup box-hover-black">
                        <!-- Image Title / Heading -->
                        <h4>Golden Kodak</h4>
                        <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas ctio.</p>
                        <a href="#" class="btn btn-danger">View more <i class="fa fa-angle-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Offset for column gap -->
        <div class="col-md-4 col-sm-6">
            <!-- Box Outer Layer [ Box 11 ] -->
            <div class="box box-lg br-orange animated">
                <div class="box-content box-service-counter box-default">
                    <!-- Heading -->
                    <h4><i class="fa fa-gears"></i> Statistik</h4>
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <!-- Service Counter Item -->
                            <div class="service-item">
                                <!-- Counter Number -->
                                <span class="s-counter" data-from="0" data-to="195" data-speed="2500" data-refresh-interval="100"></span>
                                <!-- Heading -->
                                <h3>Pendaftar</h3>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <!-- Service Counter Item -->
                            <div class="service-item">
                                <!-- Counter Number -->
                                <span class="s-counter" data-from="0" data-to="175" data-speed="2500" data-refresh-interval="100"></span>
                                <!-- Heading -->
                                <h3>Organisasi</h3>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <!-- Service Counter Item -->
                            <div class="service-item">
                                <!-- Counter Number -->
                                <span class="s-counter" data-from="0" data-to="180" data-speed="2500" data-refresh-interval="100"></span>
                                <!-- Heading -->
                                <h3>Lowongan</h3>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <!-- Service Counter Item -->
                            <div class="service-item">
                                <!-- Counter Number -->
                                <span class="s-counter" data-from="0" data-to="190" data-speed="2500" data-refresh-interval="100"></span>
                                <!-- Heading -->
                                <h3>Lamaran</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/footer.jsp" %>