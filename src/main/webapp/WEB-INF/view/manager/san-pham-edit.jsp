<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="../../../asset/css/bootstrap.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
<section class="container">
    <form action="/manager/san-pham/update" method="post">
        <div class="row">
            <input type="text"  name="idSanPham" value="${sanPham.idSanPham}" hidden>
            <div class="form-group col-md-6">
                <label >Ten San Pham</label>
                <input type="text" class="form-control" name="tenSanPham" required value="${sanPham.tenSanPham}">
            </div>
            <div class="form-group col-md-6">
                <label >Gia</label>
                <input type="number" class="form-control" name="gia" required value="${sanPham.gia}" >
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label >So Luong</label>
                <input type="number" class="form-control" name="soLuong" required value="${sanPham.soLuong}">
            </div>
            <div class="form-group col-md-6">
                <label >Cong Suat Tieu Thu</label>
                <input type="number" step="any" class="form-control" name="congSuatTieuThu" value="${sanPham.congSuatTieuThu}">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label >Dung Tich Ngan Da</label>
                <input type="text" class="form-control" name="dungTichNganDa" value="${sanPham.dungTichNganDa}">
            </div>
            <div class="form-group col-md-6">
                <label >Dung Tich Ngan Mat</label>
                <input type="text" class="form-control" name="dungTichNganMat" value="${sanPham.dungTichNganMat}">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label >Chieu Cao</label>
                <input type="number" class="form-control" name="chieuCao" value="${sanPham.chieuCao}">
            </div>
            <div class="form-group col-md-4">
                <label>Chieu Rong</label>
                <input type="number" class="form-control" name="chieuRong" value="${sanPham.chieuRong}">
            </div>
            <div class="form-group col-md-4">
                <label>Chieu Sau</label>
                <input type="number" class="form-control" name="chieuSau" value="${sanPham.chieuSau}">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label >Can Nang</label>
                <input type="number" class="form-control" name="canNang" value="${sanPham.canNang}" >
            </div>
            <div class="form-group col-md-4">
                <label>Hang</label>
                <input type="text" class="form-control" name="hang" value="${sanPham.hang}" >
            </div>
            <div class="form-group col-md-4">
                <label>Kieu Tu</label>
                <input type="text" class="form-control" name="kieuTu" value="${sanPham.kieuTu}" >
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label >Nam San Xuat</label>
                <input type="number" class="form-control" name="namSanXuat" value="${sanPham.namSanXuat}" >
            </div>
            <div class="form-group col-md-4">
                <label>Xuat Xu</label>
                <input type="text" class="form-control" name="xuatXu" value="${sanPham.xuatXu}" >
            </div>
            <div class="form-group col-md-4">
                <label>Hinh Anh</label>
                <input id="imgInput" type="file" name="hinhAnh" class="form-control"
                       value="${sanPham.hinhAnh}" >
                <input type="text" value="${sanPham.hinhAnh}" style="display: none;" />
                <c:if test="${not empty sanPham.hinhAnh}">
                    <label for="imgInput">${sanPham.hinhAnh}</label>
                </c:if>
                <c:if test="${empty sanPham.hinhAnh}">
                    <span>Dont have any img</span>
                </c:if>
            </div>
<%--            ${sanPham.hinhAnh != null ? sanPham.hinhAnh.getOriginalFilename():""}--%>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có chắc chắn muốn sửa')">Update</button>
    </form>
</section>
<section class="container">

</section>
</body>
<script src="../../../asset/js/bootstrap.bundle.min.js"></script>
</html>