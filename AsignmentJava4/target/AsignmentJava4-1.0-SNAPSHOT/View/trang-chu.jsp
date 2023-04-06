<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 3/21/2023
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="admin, dashboard">
    <meta name="author" content="DexignZone">
    <meta name="robots" content="index, follow">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Dompet : Payment Admin Template">
    <meta property="og:title" content="Dompet : Payment Admin Template">
    <meta property="og:description" content="Dompet : Payment Admin Template">
    <meta property="og:image" content="https://dompet.dexignlab.com/xhtml/social-image.png">
    <meta name="format-detection" content="telephone=no">

    <!-- PAGE TITLE HERE -->
    <title>Asignment Java 4</title>

    <!-- FAVICONS ICON -->
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/images/profile/pic1.jpg">
    <!-- Custom Stylesheet -->
    <link href="${pageContext.request.contextPath}/vendor/jquery-nice-select/css/nice-select.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/nouislider/nouislider.min.css">
    <!-- Style css -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/angular-1.8.2/angular.min.js"></script>


</head>
<body>

<!--*******************
    Preloader start
********************-->
<div id="preloader">
    <div class="waviy">
        <span style="--i:1">L</span>
        <span style="--i:2">o</span>
        <span style="--i:3">a</span>
        <span style="--i:4">d</span>
        <span style="--i:5">i</span>
        <span style="--i:6">n</span>
        <span style="--i:7">g</span>
        <span style="--i:8">.</span>
        <span style="--i:9">.</span>
        <span style="--i:10">.</span>
    </div>
</div>
<!--*******************
    Preloader end
********************-->

<!--**********************************
    Main wrapper start
***********************************-->
<div id="main-wrapper">

    <div class="nav-header">
        <a href="/chi-tiet-san-pham/view-all" class="brand-logo">
            <i class="flaticon-046-home"></i>
        </a>
        <div class="nav-control">
            <div class="hamburger">
                <span class="line"></span><span class="line"></span><span class="line"></span>
            </div>
        </div>
    </div>

    <div class="header">
        <div class="header-content">
            <nav class="navbar navbar-expand">
                <div class="collapse navbar-collapse justify-content-between">
                    <div class="header-left">
                        <div class="dashboard_bar">
                            Dashboard
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <div class="dlabnav">
        <div class="dlabnav-scroll">
            <ul class="metismenu" id="menu">
                <li class="dropdown header-profile">
                    <a class="nav-link" href="javascript:void(0);" role="button" data-bs-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}/images/profile/pic1.jpg" width="20" alt="">
                        <div class="header-info ms-3">
                            <span class="font-w600 ">Hi,<b>Tran The Quan</b></span>
                            <small class="text-end font-w400">quanttph19447@fpt.edu.vn</small>
                        </div>
                    </a>

                </li>
                <li>
                    <a class="has-arrow ai-icon" href="javascript:void(0)"
                       aria-expanded="false">
                        <i class="flaticon-025-dashboard"></i>
                        <span class="nav-text">Quản lý hàng hóa</span>
                    </a>
                    <ul aria-expanded="false">
                        <li><a href="${pageContext.request.contextPath}/san-pham/view-all">Sản phẩm</a></li>
                        <li><a href="${pageContext.request.contextPath}/dong-san-pham/view-all">Dòng sản
                            phẩm</a></li>
                        <li><a href="${pageContext.request.contextPath}/nha-san-xuat/view-all">Nhà sản xuất</a></li>
                        <li><a href="${pageContext.request.contextPath}/mau-sac/view-all">Màu sắc</a></li>
                    </ul>
                </li>
                <li>
                    <a class="has-arrow ai-icon" href="javascript:void(0)"
                       aria-expanded="false">
                        <i class="flaticon-041-graph"></i>
                        <span class="nav-text">Quản lý Cửa Hàng</span>
                    </a>
                    <ul aria-expanded="false">
                        <li><a href="${pageContext.request.contextPath}/cua-hang/view-all">Cửa hàng</a></li>
                        <li><a href="${pageContext.request.contextPath}/nhan-vien/view-all">Nhân viên</a></li>
                        <li><a href="${pageContext.request.contextPath}/chuc-vu/view-all">Chức vụ</a></li>
                    </ul>
                </li>
                <li>
                    <a class="has-arrow ai-icon" href="javascript:void(0)"
                       aria-expanded="false">
                        <i class="flaticon-045-heart"></i>
                        <span class="nav-text">Đối tác</span>
                    </a>
                    <ul aria-expanded="false">
                        <li><a href="${pageContext.request.contextPath}/khach-hang/view-all">Khách Hàng</a>
                        </li>
                    </ul>
                </li>

            </ul>
            <div class="copyright">
                <p><strong>Asignment Java 4</strong> © 2023 IT17306</p>
                <p class="fs-12">Custom <span class="heart"></span> by Quan Tran</p>
            </div>
        </div>
    </div>
    <!--**********************************
        Sidebar end
    ***********************************-->

    <!--**********************************
        Content body start
    ***********************************-->
    <div class="content-body" ng-app="myApp" ng-controller="myCtrl">
        <!-- row -->
        <div class="container-fluid">
            <div class="row invoice-card-row">
                <div class="col-xl-3 col-xxl-3 col-sm-6">
                    <div class="card bg-warning invoice-card">
                        <div class="card-body d-flex">
                            <div class="icon me-3">
                                <svg width="33px" height="32px">
                                    <path fill-rule="evenodd" fill="rgb(255, 255, 255)"
                                          d="M31.963,30.931 C31.818,31.160 31.609,31.342 31.363,31.455 C31.175,31.538 30.972,31.582 30.767,31.583 C30.429,31.583 30.102,31.463 29.845,31.243 L25.802,27.786 L21.758,31.243 C21.502,31.463 21.175,31.583 20.837,31.583 C20.498,31.583 20.172,31.463 19.915,31.243 L15.872,27.786 L11.829,31.243 C11.622,31.420 11.370,31.534 11.101,31.572 C10.832,31.609 10.558,31.569 10.311,31.455 C10.065,31.342 9.857,31.160 9.710,30.931 C9.565,30.703 9.488,30.437 9.488,30.167 L9.488,17.416 L2.395,17.416 C2.019,17.416 1.658,17.267 1.392,17.001 C1.126,16.736 0.976,16.375 0.976,16.000 L0.976,6.083 C0.976,4.580 1.574,3.139 2.639,2.076 C3.703,1.014 5.146,0.417 6.651,0.417 L26.511,0.417 C28.016,0.417 29.459,1.014 30.524,2.076 C31.588,3.139 32.186,4.580 32.186,6.083 L32.186,30.167 C32.186,30.437 32.109,30.703 31.963,30.931 ZM9.488,6.083 C9.488,5.332 9.189,4.611 8.657,4.080 C8.125,3.548 7.403,3.250 6.651,3.250 C5.898,3.250 5.177,3.548 4.645,4.080 C4.113,4.611 3.814,5.332 3.814,6.083 L3.814,14.583 L9.488,14.583 L9.488,6.083 ZM29.348,6.083 C29.348,5.332 29.050,4.611 28.517,4.080 C27.985,3.548 27.263,3.250 26.511,3.250 L11.559,3.250 C12.059,4.111 12.324,5.088 12.325,6.083 L12.325,27.092 L14.950,24.840 C15.207,24.620 15.534,24.500 15.872,24.500 C16.210,24.500 16.537,24.620 16.794,24.840 L20.837,28.296 L24.880,24.840 C25.137,24.620 25.463,24.500 25.802,24.500 C26.140,24.500 26.467,24.620 26.724,24.840 L29.348,27.092 L29.348,6.083 ZM25.092,20.250 L16.581,20.250 C16.205,20.250 15.844,20.101 15.578,19.835 C15.312,19.569 15.162,19.209 15.162,18.833 C15.162,18.457 15.312,18.097 15.578,17.831 C15.844,17.566 16.205,17.416 16.581,17.416 L25.092,17.416 C25.469,17.416 25.829,17.566 26.096,17.831 C26.362,18.097 26.511,18.457 26.511,18.833 C26.511,19.209 26.362,19.569 26.096,19.835 C25.829,20.101 25.469,20.250 25.092,20.250 ZM25.092,14.583 L16.581,14.583 C16.205,14.583 15.844,14.434 15.578,14.168 C15.312,13.903 15.162,13.542 15.162,13.167 C15.162,12.791 15.312,12.430 15.578,12.165 C15.844,11.899 16.205,11.750 16.581,11.750 L25.092,11.750 C25.469,11.750 25.829,11.899 26.096,12.165 C26.362,12.430 26.511,12.791 26.511,13.167 C26.511,13.542 26.362,13.903 26.096,14.168 C25.829,14.434 25.469,14.583 25.092,14.583 ZM25.092,8.916 L16.581,8.916 C16.205,8.916 15.844,8.767 15.578,8.501 C15.312,8.236 15.162,7.875 15.162,7.500 C15.162,7.124 15.312,6.764 15.578,6.498 C15.844,6.232 16.205,6.083 16.581,6.083 L25.092,6.083 C25.469,6.083 25.829,6.232 26.096,6.498 C26.362,6.764 26.511,7.124 26.511,7.500 C26.511,7.875 26.362,8.236 26.096,8.501 C25.829,8.767 25.469,8.916 25.092,8.916 Z"></path>
                                </svg>

                            </div>
                            <div>
                                <span class="text-white fs-18">Tổng sản phẩm</span>
                                <h2 class="text-white invoice-num">{{listSanPham.length}}</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-xxl-3 col-sm-6">
                    <div class="card bg-success invoice-card">
                        <div class="card-body d-flex">
                            <div class="icon me-3">
                                <svg width="35px" height="34px">
                                    <path fill-rule="evenodd" fill="rgb(255, 255, 255)"
                                          d="M32.482,9.730 C31.092,6.789 28.892,4.319 26.120,2.586 C22.265,0.183 17.698,-0.580 13.271,0.442 C8.843,1.458 5.074,4.140 2.668,7.990 C0.255,11.840 -0.509,16.394 0.514,20.822 C1.538,25.244 4.224,29.008 8.072,31.411 C10.785,33.104 13.896,34.000 17.080,34.000 L17.286,34.000 C20.456,33.960 23.541,33.044 26.213,31.358 C26.991,30.866 27.217,29.844 26.725,29.067 C26.234,28.291 25.210,28.065 24.432,28.556 C22.285,29.917 19.799,30.654 17.246,30.687 C14.627,30.720 12.067,29.997 9.834,28.609 C6.730,26.671 4.569,23.644 3.752,20.085 C2.934,16.527 3.546,12.863 5.486,9.763 C9.488,3.370 17.957,1.418 24.359,5.414 C26.592,6.808 28.360,8.793 29.477,11.157 C30.568,13.460 30.993,16.016 30.707,18.539 C30.607,19.448 31.259,20.271 32.177,20.371 C33.087,20.470 33.911,19.820 34.011,18.904 C34.363,15.764 33.832,12.591 32.482,9.730 L32.482,9.730 Z"></path>
                                    <path fill-rule="evenodd" fill="rgb(255, 255, 255)"
                                          d="M22.593,11.237 L14.575,19.244 L11.604,16.277 C10.952,15.626 9.902,15.626 9.250,16.277 C8.599,16.927 8.599,17.976 9.250,18.627 L13.399,22.770 C13.725,23.095 14.150,23.254 14.575,23.254 C15.001,23.254 15.427,23.095 15.753,22.770 L24.940,13.588 C25.592,12.937 25.592,11.888 24.940,11.237 C24.289,10.593 23.238,10.593 22.593,11.237 L22.593,11.237 Z"></path>
                                </svg>

                            </div>
                            <div>
                                <span class="text-white fs-18">Tổng Số Dòng sản phẩm</span>
                                <h2 class="text-white invoice-num">{{listDongSanPham.length}}</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-xxl-3 col-sm-6">
                    <div class="card bg-info invoice-card">
                        <div class="card-body d-flex">
                            <div class="icon me-3">
                                <svg width="35px" height="34px">
                                    <path fill-rule="evenodd" fill="rgb(255, 255, 255)"
                                          d="M33.002,9.728 C31.612,6.787 29.411,4.316 26.638,2.583 C22.781,0.179 18.219,-0.584 13.784,0.438 C9.356,1.454 5.585,4.137 3.178,7.989 C0.764,11.840 -0.000,16.396 1.023,20.825 C2.048,25.247 4.734,29.013 8.584,31.417 C11.297,33.110 14.409,34.006 17.594,34.006 L17.800,34.006 C20.973,33.967 24.058,33.050 26.731,31.363 C27.509,30.872 27.735,29.849 27.243,29.072 C26.751,28.296 25.727,28.070 24.949,28.561 C22.801,29.922 20.314,30.660 17.761,30.693 C15.141,30.726 12.581,30.002 10.346,28.614 C7.241,26.675 5.080,23.647 4.262,20.088 C3.444,16.515 4.056,12.850 5.997,9.748 C10.001,3.353 18.473,1.401 24.876,5.399 C27.110,6.793 28.879,8.779 29.996,11.143 C31.087,13.447 31.513,16.004 31.227,18.527 C31.126,19.437 31.778,20.260 32.696,20.360 C33.607,20.459 34.432,19.809 34.531,18.892 C34.884,15.765 34.352,12.591 33.002,9.728 L33.002,9.728 Z"></path>
                                    <path fill-rule="evenodd" fill="rgb(255, 255, 255)"
                                          d="M23.380,11.236 C22.728,10.585 21.678,10.585 21.026,11.236 L17.608,14.656 L14.190,11.243 C13.539,10.592 12.488,10.592 11.836,11.243 C11.184,11.893 11.184,12.942 11.836,13.593 L15.254,17.006 L11.836,20.420 C11.184,21.071 11.184,22.120 11.836,22.770 C12.162,23.096 12.588,23.255 13.014,23.255 C13.438,23.255 13.864,23.096 14.190,22.770 L17.608,19.357 L21.026,22.770 C21.352,23.096 21.777,23.255 22.203,23.255 C22.629,23.255 23.054,23.096 23.380,22.770 C24.031,22.120 24.031,21.071 23.380,20.420 L19.962,17.000 L23.380,13.587 C24.031,12.936 24.031,11.887 23.380,11.236 L23.380,11.236 Z"></path>
                                </svg>

                            </div>
                            <div>
                                <span class="text-white fs-18">Tổng số nhân viên</span>
                                <h2 class="text-white invoice-num">{{listNhanVien.length}}</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-xxl-3 col-sm-6">
                    <div class="card bg-secondary invoice-card">
                        <div class="card-body d-flex">
                            <div class="icon me-3">
                                <svg width="33px" height="32px">
                                    <path fill-rule="evenodd" fill="rgb(255, 255, 255)"
                                          d="M31.963,30.931 C31.818,31.160 31.609,31.342 31.363,31.455 C31.175,31.538 30.972,31.582 30.767,31.583 C30.429,31.583 30.102,31.463 29.845,31.243 L25.802,27.786 L21.758,31.243 C21.502,31.463 21.175,31.583 20.837,31.583 C20.498,31.583 20.172,31.463 19.915,31.243 L15.872,27.786 L11.829,31.243 C11.622,31.420 11.370,31.534 11.101,31.572 C10.832,31.609 10.558,31.569 10.311,31.455 C10.065,31.342 9.857,31.160 9.710,30.931 C9.565,30.703 9.488,30.437 9.488,30.167 L9.488,17.416 L2.395,17.416 C2.019,17.416 1.658,17.267 1.392,17.001 C1.126,16.736 0.976,16.375 0.976,16.000 L0.976,6.083 C0.976,4.580 1.574,3.139 2.639,2.076 C3.703,1.014 5.146,0.417 6.651,0.417 L26.511,0.417 C28.016,0.417 29.459,1.014 30.524,2.076 C31.588,3.139 32.186,4.580 32.186,6.083 L32.186,30.167 C32.186,30.437 32.109,30.703 31.963,30.931 ZM9.488,6.083 C9.488,5.332 9.189,4.611 8.657,4.080 C8.125,3.548 7.403,3.250 6.651,3.250 C5.898,3.250 5.177,3.548 4.645,4.080 C4.113,4.611 3.814,5.332 3.814,6.083 L3.814,14.583 L9.488,14.583 L9.488,6.083 ZM29.348,6.083 C29.348,5.332 29.050,4.611 28.517,4.080 C27.985,3.548 27.263,3.250 26.511,3.250 L11.559,3.250 C12.059,4.111 12.324,5.088 12.325,6.083 L12.325,27.092 L14.950,24.840 C15.207,24.620 15.534,24.500 15.872,24.500 C16.210,24.500 16.537,24.620 16.794,24.840 L20.837,28.296 L24.880,24.840 C25.137,24.620 25.463,24.500 25.802,24.500 C26.140,24.500 26.467,24.620 26.724,24.840 L29.348,27.092 L29.348,6.083 ZM25.092,20.250 L16.581,20.250 C16.205,20.250 15.844,20.101 15.578,19.835 C15.312,19.569 15.162,19.209 15.162,18.833 C15.162,18.457 15.312,18.097 15.578,17.831 C15.844,17.566 16.205,17.416 16.581,17.416 L25.092,17.416 C25.469,17.416 25.829,17.566 26.096,17.831 C26.362,18.097 26.511,18.457 26.511,18.833 C26.511,19.209 26.362,19.569 26.096,19.835 C25.829,20.101 25.469,20.250 25.092,20.250 ZM25.092,14.583 L16.581,14.583 C16.205,14.583 15.844,14.434 15.578,14.168 C15.312,13.903 15.162,13.542 15.162,13.167 C15.162,12.791 15.312,12.430 15.578,12.165 C15.844,11.899 16.205,11.750 16.581,11.750 L25.092,11.750 C25.469,11.750 25.829,11.899 26.096,12.165 C26.362,12.430 26.511,12.791 26.511,13.167 C26.511,13.542 26.362,13.903 26.096,14.168 C25.829,14.434 25.469,14.583 25.092,14.583 ZM25.092,8.916 L16.581,8.916 C16.205,8.916 15.844,8.767 15.578,8.501 C15.312,8.236 15.162,7.875 15.162,7.500 C15.162,7.124 15.312,6.764 15.578,6.498 C15.844,6.232 16.205,6.083 16.581,6.083 L25.092,6.083 C25.469,6.083 25.829,6.232 26.096,6.498 C26.362,6.764 26.511,7.124 26.511,7.500 C26.511,7.875 26.362,8.236 26.096,8.501 C25.829,8.767 25.469,8.916 25.092,8.916 Z"></path>
                                </svg>

                            </div>
                            <div>
                                <span class="text-white fs-18">Tổng số khách hàng</span>
                                <h2 class="text-white invoice-num">{{listKhachHang.length}}</h2>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Thêm chi tiết sản phẩm</h4>
                        </div>
                        <div class="card-body">
                            <div class="form-validation">
                                <form action="/chi-tiet-san-pham/add" method="post" class="needs-validation" novalidate>
                                    <div class="row">
                                        <div class="col-xl-6">
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom01">Sản
                                                    phẩm</label>
                                                <div class="col-lg-6">
                                                    <select name="sanpham" type="text" class="form-select"
                                                            id="validationCustom01">
                                                        <option ng-repeat="item in listSanPham" value="{{item.id}}">
                                                            {{item.ma}}
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom02">Nhà sản
                                                    xuất</label>
                                                <div class="col-lg-6">
                                                    <select name="nhaSanXuat" type="text" class="form-select"
                                                            id="validationCustom02">
                                                        <option ng-repeat="item in listNsx" value="{{item.id}}">
                                                            {{item.ma}}
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom03">Màu
                                                    sắc</label>
                                                <div class="col-lg-6">
                                                    <select name="mausac" type="text" class="form-select"
                                                            id="validationCustom03">
                                                        <option ng-repeat="item in listMauSac" value="{{item.id}}">
                                                            {{item.ma}}
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom04">Dòng sản
                                                    phẩm</label>
                                                <div class="col-lg-6">
                                                    <select name="dongsp" type="text" class="form-select"
                                                            id="validationCustom04">
                                                        <option ng-repeat="item in listDongSanPham" value="{{item.id}}">
                                                            {{item.ma}}
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom05">Năm bảo
                                                    hành
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="nambh" type="number" min="1" class="form-control"
                                                           id="validationCustom05"
                                                           placeholder="Nhập số năm.." required="">
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập(định dạng: số nguyên>0)
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="col-xl-6">
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom11">Số lượng
                                                    tồn
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="soluongton" type="number" min="1" class="form-control"
                                                           id="validationCustom11"
                                                           placeholder="Nhập số lượng tồn.." required="">
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập(định dạng: số nguyên>0)
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom06">Giá nhập
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="gianhap" type="number" min="1" class="form-control"
                                                           id="validationCustom06"
                                                           placeholder="Nhập giá nhập.." required="">
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập(định dạng: số nguyên>0)
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom07">Giá bán
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="giaban" type="number" min="1" class="form-control"
                                                           id="validationCustom07"
                                                           placeholder="Nhập giá bán.." required="">
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập(định dạng: số nguyên>0)
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom08">Mô tả
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <textarea name="mota" class="form-control" id="validationCustom08"
                                                              placeholder="Nhập mô tả.." required=""></textarea>
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <div class="col-lg-8 ms-auto">
                                                    <button type="submit" class="btn btn-primary">Tạo sản phẩm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">DANH SÁCH CHI TIẾT SẢN PHẨM</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-responsive-md">
                                    <thead>
                                    <tr>
                                        <th style="width:80px;"><strong>#</strong></th>
                                        <th><strong>MÃ SP</strong></th>
                                        <th><strong>NSX</strong></th>
                                        <th><strong>MÀU</strong></th>
                                        <th><strong>DÒNG SP</strong></th>
                                        <th><strong>NĂM BH</strong></th>
                                        <th><strong>SL TỒN</strong></th>
                                        <th><strong>GIÁ NHẬP</strong></th>
                                        <th><strong>GIÁ BÁN</strong></th>
                                        <th><strong>MÔ TẢ</strong></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="item in listChiTietSp">
                                        <td><strong>{{$index+1}}</strong></td>
                                        <td>{{item.sanPham.ma}}</td>
                                        <td>{{item.nhaSanXuat.ma}}</td>
                                        <td>{{item.mauSac.ma}}</td>
                                        <td>{{item.dongSanPham.ma}}</td>
                                        <td>{{item.namBH}}</td>
                                        <td>{{item.soLuongTon}}</td>
                                        <td>{{item.giaNhap}}</td>
                                        <td>{{item.giaBan}}</td>
                                        <td>{{item.moTa}}</td>
                                        <td>
                                            <div class="dropdown">
                                                <button type="button" class="btn btn-success light sharp"
                                                        data-bs-toggle="dropdown">
                                                    <svg width="20px" height="20px" viewbox="0 0 24 24"
                                                         version="1.1">
                                                        <g stroke="none" stroke-width="1" fill="none"
                                                           fill-rule="evenodd">
                                                            <rect x="0" y="0" width="24" height="24"></rect>
                                                            <circle fill="#000000" cx="5" cy="12" r="2"></circle>
                                                            <circle fill="#000000" cx="12" cy="12" r="2"></circle>
                                                            <circle fill="#000000" cx="19" cy="12" r="2"></circle>
                                                        </g>
                                                    </svg>
                                                </button>
                                                <div class="dropdown-menu">
                                                    <!-- Button trigger modal start -->
                                                    <a ng-click="getDataToModal($event)" href="#"
                                                       class="dropdown-item"
                                                       data-bs-toggle="modal" data-bs-target="#exampleModal"
                                                       data-id="{{item.id}}"
                                                       data-sanpham="{{item.sanPham.id}}"
                                                       data-mausac="{{item.mauSac.id}}"
                                                       data-nhaSanXuat="{{item.nhaSanXuat.id}}"
                                                       data-dongsp="{{item.dongSanPham.id}}"
                                                       data-nambh="{{item.namBH}}"
                                                       data-soluongton="{{item.soLuongTon}}"
                                                       data-gianhap="{{item.giaNhap}}" data-giaban="{{item.giaBan}}"
                                                       data-mota="{{item.moTa}}">
                                                        Edit
                                                    </a>
                                                    <!-- Button trigger modal end -->
                                                    <a class="dropdown-item"
                                                       href="/chi-tiet-san-pham/delete?idChiTietSp={{item.id}}">Delete</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Start-->
        <div class="modal fade" id="exampleModal" tabindex="-1"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="exampleModalLabel">
                            CẬP NHẬT CHI TIẾT SẢN PHẨM</h4>
                        <button type="button" class="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="formUpdate" action="#" method="post" class="needs-validation" novalidate="">
                            <div class="row">
                                <div class="col-xl-6">
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom0111">Sản
                                            phẩm</label>
                                        <div class="col-lg-6">
                                            <select name="sanphamUpdate" ng-model="object.sanpham" type="text"
                                                    class="form-select"
                                                    id="validationCustom0111">
                                                <option ng-repeat="item in listSanPham"
                                                        value="{{item.id}}"
                                                        ng-selected="object.sanpham===item.id">{{item.ma}}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom021">Nhà sản
                                            xuất</label>
                                        <div class="col-lg-6">
                                            <select name="nsxUpdate" ng-model="object.nhaSanXuat" type="text"
                                                    class="form-select"
                                                    id="validationCustom021">
                                                <option ng-repeat="item in listNsx"
                                                        value="{{item.id}}"
                                                        ng-selected="object.nhaSanXuat===item.id">{{item.ma}}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom031">Màu
                                            sắc</label>
                                        <div class="col-lg-6">
                                            <select name="mausacUpdate" ng-model="object.mausac" type="text"
                                                    class="form-select"
                                                    id="validationCustom031">
                                                <option ng-repeat="item in listMauSac"
                                                        value="{{item.id}}"
                                                        ng-selected="object.mausac===item.id">{{item.ma}}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom041">Dòng sản
                                            phẩm</label>
                                        <div class="col-lg-6">
                                            <select name="dongspUpdate" ng-model="object.dongsp" type="text"
                                                    class="form-select"
                                                    id="validationCustom041">
                                                <option ng-repeat="item in listDongSanPham"
                                                        value="{{item.id}}"
                                                        ng-selected="object.dongsp===item.id">{{item.ma}}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom051">Năm bảo
                                            hành
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="nambhUpdate" ng-value="object.nambh" ng-model="object.nambh"
                                                   type="number" min="1"
                                                   class="form-control"
                                                   id="validationCustom051"
                                                   placeholder="Nhập số năm BH.." required="">
                                            <div class="invalid-feedback">
                                                Vui lòng nhập(định dạng: số nguyên>0)
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-6">
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom111">Số lượng
                                            tồn
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="soluongtonUpdate" ng-value="object.soluongton"
                                                   ng-model="object.soluongton" type="number" min="1"
                                                   class="form-control"
                                                   id="validationCustom111"
                                                   placeholder="Nhập số lượng tồn.." required="">
                                            <div class="invalid-feedback">
                                                Vui lòng nhập(định dạng:số nguyên dương>0)
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom061">Giá nhập
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="gianhapUpdate" ng-value="object.gianhap"
                                                   ng-model="object.gianhap" type="number" min="1"
                                                   class="form-control"
                                                   id="validationCustom061"
                                                   placeholder="Nhập giá nhập.." required="">
                                            <div class="invalid-feedback">
                                                Vui lòng nhập(định dạng: số nguyên>0)
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom071">Giá bán
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="giabanUpdate" ng-value="object.giaban" ng-model="object.giaban"
                                                   type="number" min="1"
                                                   class="form-control"
                                                   id="validationCustom071"
                                                   placeholder="Nhập giá bán.." required="">
                                            <div class="invalid-feedback">
                                                Vui lòng nhập(định dạng: số nguyên>0)
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom082">Mô tả
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                        <textarea name="motaUpdate" ng-value="object.mota" ng-model="object.mota"
                                                  class="form-control"
                                                  id="validationCustom082"
                                                  placeholder="Nhập mô tả.." required=""></textarea>
                                            <div class="invalid-feedback">
                                                Vui lòng nhập
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <div class="col-lg-8 ms-auto">
                                            <button type="submit" class="btn btn-primary">Cập nhật chi tiết sản phẩm
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="copyright">
            <p style="color: black">© Copy & Paste &amp; Customed by Tran The Quan 2023</p>
        </div>
    </div>
</div>

<!-- Required vendors -->
<script src="${pageContext.request.contextPath}/vendor/global/global.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery-nice-select/js/jquery.nice-select.min.js"></script>

<!-- Apex Chart -->
<script src="${pageContext.request.contextPath}/vendor/apexchart/apexchart.js"></script>
<script src="${pageContext.request.contextPath}/vendor/nouislider/nouislider.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/wnumb/wNumb.js"></script>

<!-- Dashboard 1 -->
<script src="${pageContext.request.contextPath}/js/dashboard/dashboard-1.js"></script>

<script src="${pageContext.request.contextPath}/js/custom.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dlabnav-init.js"></script>
<script src="${pageContext.request.contextPath}/js/demo.js"></script>
<script src="${pageContext.request.contextPath}/js/styleSwitcher.js"></script>

<script>
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
    var myApp = angular.module('myApp', []);
    myApp.controller('myCtrl', function ($scope) {

        $scope.listChiTietSp = [];
        $scope.listSanPham = [];
        $scope.listDongSanPham = [];
        $scope.listNsx = [];
        $scope.listMauSac = [];
        $scope.listNhanVien = [];
        $scope.listChiTietSp =${jsonChiTietSp};
        $scope.listSanPham = ${jsonSanPham};
        $scope.listDongSanPham = ${jsonDongSp};
        $scope.listNsx = ${jsonNsx};
        $scope.listMauSac = ${jsonMauSac};
        $scope.listNhanVien =${jsonNhanVien};
        $scope.listKhachHang =${jsonKhachHang};
        $scope.getDataToModal = function (event) {
            var button = event.currentTarget;
            var id = button.getAttribute('data-id');
            var sanpham = button.getAttribute("data-sanpham");
            var mausac = button.getAttribute("data-mausac");
            var nhaSanXuat = button.getAttribute("data-nhaSanXuat");
            var dongsp = button.getAttribute("data-dongsp");
            var nambh = button.getAttribute('data-nambh');
            var soluongton = button.getAttribute('data-soluongton');
            var gianhap = button.getAttribute('data-gianhap');
            var giaban = button.getAttribute('data-giaban');
            var mota = button.getAttribute('data-mota');
            $scope.object = {
                id: id,
                sanpham: sanpham.length === 0 ? $scope.listSanPham[0].id : sanpham,
                mausac: mausac.length === 0 ? $scope.listMauSac[0].id : mausac,
                nhaSanXuat: nhaSanXuat.length === 0 ? $scope.listNsx[0].id : nhaSanXuat,
                dongsp: dongsp.length === 0 ? $scope.listDongSanPham[0].id : dongsp,
                nambh: nambh,
                soluongton: soluongton,
                gianhap: gianhap,
                giaban: giaban,
                mota: mota
            }
            document.getElementById("formUpdate").action = "/chi-tiet-san-pham/update?idChiTietSp=" + $scope.object.id
        }
    })
</script>

</body>
</html>

