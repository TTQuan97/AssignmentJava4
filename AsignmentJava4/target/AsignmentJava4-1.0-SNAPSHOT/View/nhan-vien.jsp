<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 3/22/2023
  Time: 23:48
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
    <title>NhanVien</title>

    <!-- FAVICONS ICON -->
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/images/profile/pic1.jpg">

    <link href="${pageContext.request.contextPath}/vendor/jquery-nice-select/css/nice-select.css" rel="stylesheet">
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

    <div class="content-body" ng-app="myApp" ng-controller="myCtrl">
        <div class="container-fluid">
            <div class="row page-titles">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active"><a href="javascript:void(0)">Quản lý cửa hàng</a></li>
                    <li class="breadcrumb-item"><a href="javascript:void(0)">Nhân Viên</a></li>
                </ol>
            </div>
            <!-- row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Thêm mới nhân viên</h4>
                        </div>
                        <div class="card-body">
                            <div class="form-validation">
                                <form action="/nhan-vien/add" method="post" class="needs-validation" novalidate="">
                                    <div class="row">
                                        <div class="col-xl-6">
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom01">Tên
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="ten" type="text" value="" class="form-control"
                                                           id="validationCustom01"
                                                           placeholder="Nhập tên.." required="">
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập tên
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom02">Tên đệm
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="tendem" type="text" value="" class="form-control"
                                                           id="validationCustom02"
                                                           placeholder="Nhập tên đệm..">
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom03">Họ
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="ho" type="text" value="" class="form-control"
                                                           id="validationCustom03"
                                                           placeholder="Nhập Họ..">
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom04">Giới
                                                    tính
                                                </label>
                                                <div class="col-lg-6" id="validationCustom04">
                                                    Nam <input value="Nam" type="radio" name="gioitinh" checked
                                                               class="form-check-input">
                                                    Nữ <input value="Nữ" type="radio" name="gioitinh"
                                                              class="form-check-input">
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom05">Ngày
                                                    sinh
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="ngaysinh" type="date" class="form-control"
                                                           id="validationCustom05"
                                                           required>
                                                    <div class="invalid-feedback">
                                                        Vui lòng chọn ngày sinh
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom06">Địa chỉ
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="diachi" value="" type="text" class="form-control"
                                                           id="validationCustom06"
                                                           placeholder="Nhập địa chỉ.." required>
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập địa chỉ
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-6">
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom07">Số điện
                                                    thoại
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="sdt" value="" type="text" class="form-control"
                                                           id="validationCustom07"
                                                           placeholder="Nhập sdt.." required>
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập sdt
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom08">Mật khẩu
                                                    <span class="text-danger">*</span>
                                                </label>
                                                <div class="col-lg-6">
                                                    <input name="matkhau" type="text" class="form-control"
                                                           id="validationCustom08"
                                                           placeholder="Nhập mật khẩu.." required>
                                                    <div class="invalid-feedback">
                                                        Vui lòng nhập mật khẩu
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom09">Cừa
                                                    hàng</label>
                                                <div class="col-lg-6">
                                                    <select name="cuahang" type="text" class="form-select"
                                                            id="validationCustom09">
                                                        <option ng-repeat="item in listCuaHang" value="{{item.id}}">
                                                            {{item.ma}}
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom10">Chức
                                                    vụ</label>
                                                <div class="col-lg-6">
                                                    <select name="chucvu" type="text" class="form-select"
                                                            id="validationCustom10">
                                                        <option ng-repeat="item in listChucVu" value="{{item.id}}">
                                                            {{item.ma}}
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <label class="col-lg-4 col-form-label" for="validationCustom11">Trạng
                                                    thái</label>
                                                <div class="col-lg-6">
                                                    <select name="trangthai" type="text" class="form-select"
                                                            id="validationCustom11">
                                                        <option value="1">Đang hoạt động</option>
                                                        <option value="0">Đã nghỉ việc</option>

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3 row">
                                                <div class="col-lg-8 ms-auto">
                                                    <button type="submit" class="btn btn-primary">Thêm nhân viên
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
                            <h4 class="card-title">DANH SÁCH NHÂN VIÊN</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-responsive-md">
                                    <thead>
                                    <tr>
                                        <th style="width:80px;"><strong>#</strong></th>
                                        <th><strong>MÃ</strong></th>
                                        <th><strong>HỌ TÊN</strong></th>
                                        <th><strong>GIỚI TÍNH</strong></th>
                                        <th><strong>NGÀY SINH</strong></th>
                                        <th><strong>ĐỊA CHỈ</strong></th>
                                        <th><strong>SDT</strong></th>
                                        <th><strong>MẬT KHẨU</strong></th>
                                        <th><strong>CỬA HÀNG</strong></th>
                                        <th><strong>CHỨC VỤ</strong></th>
                                        <th><strong>TRẠNG THÁI</strong></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="item in listNhanVien">
                                        <td><strong>{{$index+1}}</strong></td>
                                        <td>{{item.ma}}</td>
                                        <td>{{item.ho+" "+item.tenDem+" "+item.ten}}</td>
                                        <td>{{item.gioiTinh}}</td>
                                        <td>{{item.ngaySinh|date:'dd-MM-yyyy'}}</td>
                                        <td>{{item.diaChi}}</td>
                                        <td>{{item.sdt}}</td>
                                        <td>{{item.matKhau}}</td>
                                        <td>{{item.cuaHang.ten}}</td>
                                        <td>{{item.chucVu.ten}}</td>
                                        <td>{{item.trangThai==1?'Đang hoạt đông':'Đã nghỉ việc'}}</td>
                                        <td>
                                            <div class="dropdown">
                                                <button type="button" class="btn btn-success light sharp"
                                                        data-bs-toggle="dropdown">
                                                    <svg width="20px" height="20px" viewbox="0 0 24 24" version="1.1">
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
                                                       data-id="{{item.id}}" data-ma="{{item.ma}}"
                                                       data-ten="{{item.ten}}" data-tendem="{{item.tenDem}}"
                                                       data-ho="{{item.ho}}" data-gioitinh="{{item.gioiTinh}}"
                                                       data-ngaysinh="{{item.ngaySinh}}"
                                                       data-diachi="{{item.diaChi}}"
                                                       data-sdt="{{item.sdt}}" data-matkhau="{{item.matKhau}}"
                                                       data-cuahang="{{item.cuaHang.id}}"
                                                       data-chucvu="{{item.chucVu.id}}"
                                                       data-trangthai="{{item.trangThai}}">
                                                        Edit
                                                    </a>
                                                    <!-- Button trigger modal end -->
                                                    <a class="dropdown-item"
                                                       href="/nhan-vien/delete?idNhanVien={{item.id}}">Delete</a>
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
                            CẬP NHẬT THÔNG TIN NHÂN VIÊN</h4>
                        <button type="button" class="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="formUpdate" action="#" method="post" class="needs-validation" novalidate="">
                            <div class="row">
                                <div class="col-xl-6">
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom0111">Tên
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="tenUpdate" type="text" ng-model="object.ten"
                                                   ng-value="object.ten"
                                                   class="form-control"
                                                   id="validationCustom0111"
                                                   placeholder="Nhập tên.." required="">
                                            <div class="invalid-feedback">
                                                Vui lòng nhập tên
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom0222">Tên đệm
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="tendemUpdate" ng-model="object.tenDem" ng-value="object.tenDem"
                                                   type="text"
                                                   class="form-control"
                                                   id="validationCustom0222"
                                                   placeholder="Nhập tên đệm..">
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom0333">Họ
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="hoUpdate" ng-model="object.ho" ng-value="object.ho" type="text"
                                                   class="form-control"
                                                   id="validationCustom0333"
                                                   placeholder="Nhập Họ..">
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom0444">Giới
                                            tính
                                        </label>
                                        <div class="col-lg-6" id="validationCustom0444">
                                            Nam <input ng-model="object.gioiTinh" value="Nam" type="radio"
                                                       name="gioitinhUpdate"
                                                       ng-checked="object.gioiTinh=='Nam'"
                                                       class="form-check-input">
                                            Nữ <input ng-model="object.gioiTinh" value="Nữ" type="radio"
                                                      name="gioitinhUpdate"
                                                      ng-checked="object.gioiTinh=='Nữ'" class="form-check-input">
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom0555">Ngày
                                            sinh
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="ngaysinhUpdate" ng-model="object.ngaySinh"
                                                   ng-value="object.ngaySinh|date:'yyyy-MM-dd'"
                                                   type="date"
                                                   class="form-control"
                                                   id="validationCustom0555"
                                                   required>
                                            <div class="invalid-feedback">
                                                Vui lòng chọn ngày sinh
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom0666">Địa chỉ
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="diachiUpdate" ng-model="object.diaChi" ng-value="object.diaChi"
                                                   type="text"
                                                   class="form-control"
                                                   id="validationCustom0666"
                                                   placeholder="Nhập địa chỉ.." required>
                                            <div class="invalid-feedback">
                                                Vui lòng nhập địa chỉ
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-6">
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom077">Số điện
                                            thoại
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="sdtUpdate" ng-model="object.sdt" ng-value="object.sdt"
                                                   type="text"
                                                   class="form-control"
                                                   id="validationCustom077"
                                                   placeholder="Nhập sdt.." required>
                                            <div class="invalid-feedback">
                                                Vui lòng nhập sdt
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom088">Mật khẩu
                                            <span class="text-danger">*</span>
                                        </label>
                                        <div class="col-lg-6">
                                            <input name="matkhauUpdate" ng-model="object.matKhau"
                                                   ng-value="object.matKhau" type="text"
                                                   class="form-control"
                                                   id="validationCustom088"
                                                   placeholder="Nhập mật khẩu.." required>
                                            <div class="invalid-feedback">
                                                Vui lòng nhập mật khẩu
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom099">Cừa
                                            hàng</label>
                                        <div class="col-lg-6">
                                            <select name="cuahangUpdate" ng-model="object.cuaHang" type="text"
                                                    class="form-select"
                                                    id="validationCustom099">
                                                <option ng-repeat="item in listCuaHang"
                                                        ng-selected="object.cuaHang===item.id"
                                                        value="{{item.id}}">{{item.ma}}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom100">Chức vụ
                                        </label>
                                        <div class="col-lg-6">
                                            <select name="chucvuUpdate" ng-model="object.chucVu" type="text"
                                                    class="form-select"
                                                    id="validationCustom100">
                                                <option ng-repeat="item in listChucVu"
                                                        ng-selected="object.chucVu===item.id"
                                                        value="{{item.id}}">{{item.ma}}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label class="col-lg-4 col-form-label" for="validationCustom118">Trạng
                                            thái</label>
                                        <div class="col-lg-6">
                                            <select name="trangthaiUpdate" ng-model="object.trangThai" type="text"
                                                    class="form-select"
                                                    id="validationCustom118">
                                                <option ng-selected="object.trangThai==1" value="1">Đang hoạt động
                                                </option>
                                                <option ng-selected="object.trangThai==0" value="0">Đã nghỉ việc
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <div class="col-lg-8 ms-auto">
                                            <button type="submit" class="btn btn-primary">Cập nhật thông tin
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

<script src="${pageContext.request.contextPath}/vendor/jquery-nice-select/js/jquery.nice-select.min.js"></script>

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

        $scope.listNhanVien = [];
        $scope.listCuaHang = [];
        $scope.listChucVu = [];
        $scope.listNhanVien =${jsonNhanVien};
        $scope.listCuaHang = ${jsonCuaHang};
        $scope.listChucVu = ${jsonChucVu};
        $scope.getDataToModal = function (event) {
            var button = event.currentTarget;
            var id = button.getAttribute('data-id');
            var ma = button.getAttribute("data-ma");
            var ten = button.getAttribute("data-ten");
            var tenDem = button.getAttribute("data-tendem");
            var ho = button.getAttribute("data-ho");
            var gioiTinh = button.getAttribute("data-gioitinh");
            var ngaySinh = button.getAttribute('data-ngaysinh');
            var diaChi = button.getAttribute('data-diachi');
            var sdt = button.getAttribute('data-sdt');
            var matKhau = button.getAttribute('data-matkhau');
            var cuaHang = button.getAttribute('data-cuahang');
            var chucVu = button.getAttribute('data-chucvu');
            var trangThai = button.getAttribute('data-trangthai');

            $scope.object = {
                id: id,
                ma: ma,
                ten: ten,
                tenDem: tenDem,
                ho: ho,
                gioiTinh: gioiTinh,
                ngaySinh: ngaySinh,
                diaChi: diaChi,
                sdt: sdt,
                matKhau: matKhau,
                cuaHang: cuaHang.length === 0 ? $scope.listCuaHang[0].id : cuaHang,
                chucVu: chucVu.length === 0 ? $scope.listChucVu[0].id : cuaHang,
                trangThai: trangThai
            }
            document.getElementById("formUpdate").action = "/nhan-vien/update?idNhanVien=" + $scope.object.id
        }
    })
</script>
</body>
</html>

