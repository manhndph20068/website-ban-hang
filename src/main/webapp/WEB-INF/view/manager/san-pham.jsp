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
    <%@include file="header.jsp" %>
    <form action="/manager/san-pham/save" method="post">
        <div class="row">
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
                <input type="file" class="form-control" name="hinhAnh" value="${sanPham.hinhAnh}" >
                <c:if test="${not empty sanPham.hinhAnh}">
                    <span>${sanPham.hinhAnh}</span>
                </c:if>
                <c:if test="${empty sanPham.hinhAnh}">
                    <span>Dont have any img</span>
                </c:if>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Ban co dong y them')">Add</button>
    </form>
</section>
<section class="container">
    <h1> List of Products</h1>
    <br>
    <form>
        <input placeholder="Nhập giá thấp nhất" name="minGia" type="number" value="${param.minGia} "/>
        <input placeholder="Nhập giá lớn nhất"  name="maxGia" type="number" value="${param.maxGia}"/>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <form>
        <input placeholder="Nhập tên sản phẩm"  name="tenSearch" value="${param.tenSearch}"/>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <div class="row">
        <div class="form-group col-md-4">
            <select class="form-select" aria-label="Default select example">
                <c:forEach items="${categorySP}" var="category">
                    <option value=${category.hang}>${category.hang}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-4">
            <select class="form-select" aria-label="Default select example">
                <c:forEach items="${categorySP}" var="category">
                    <option value=${category.kieuTu}>${category.kieuTu}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-4">
            <select class="form-select" aria-label="Default select example">
                <c:forEach items="${categorySP}" var="category">
                    <option value=${category.namSanXuat}>${category.namSanXuat}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <br>
    <c:if test="${not empty successMessage}">
        <div class="success-message">
            <h4 style="color: red">${successMessage}</h4>
        </div>
    </c:if>
    <table class="table table-bordered" border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>Ten</th>
            <th>Gia</th>
            <th>So Luong</th>
            <th>Hang</th>
            <th>Kieu tu</th>
            <th>Hinh Anh</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty sanPhamList.isEmpty()}">
            <c:forEach items="${sanPhamList.getContent()}" var="sp">
                <tr>
                    <td>${sp.idSanPham}</td>
                    <td>${sp.tenSanPham}</td>
                    <td>${sp.gia}</td>
                    <td>${sp.soLuong}</td>
                    <td>${sp.hang}</td>
                    <td>${sp.kieuTu}</td>
                    <td><img style="height: 90px;width: 120px" src="../../../asset/img/${sp.hinhAnh}"></td>
                    <td>
                        <a href="/manager/san-pham/delete/${sp.idSanPham}">
                            <button  class="btn btn-warning" onclick="return confirm('Ban co muon xoa ${sp.tenSanPham}')">
                                Delete
                            </button>
                        </a>
                        <a href="/manager/san-pham/edit/${sp.idSanPham}" onclick="return confirm('Ban co muon sua ${sp.tenSanPham}')">
                            <button class="btn btn-danger">
                                Edit
                            </button>
                        </a>
                        <a href="/manager/san-pham/detail/${sp.idSanPham}">
                            <button class="btn btn-info">
                                Detail
                            </button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty sanPhamList.isEmpty()}">
                <tr>
                    <td>Not found any records</td>
                </tr>
        </c:if>

        </tbody>
    </table>
    <div>
        <c:if test="${sanPhamList.getNumber()+1 > 1}">
            <a href="?page=${sanPhamList.getNumber() + 1 - 1}&tenSearch=${param.tenSearch}">Previos</a>
        </c:if>
        <span> ${sanPhamList.getNumber()+1} / ${sanPhamList.getTotalPages()}</span>
        <c:if test="${sanPhamList.getNumber()+1 < sanPhamList.getTotalPages()}">
            <a href="?page=${sanPhamList.getNumber() + 1 + 1}&tenSearch=${param.tenSearch}">Next</a>
        </c:if>
    </div>

    <br>

</section>
</body>
<script src="../../../asset/js/bootstrap.bundle.min.js"></script>

<%--<script>--%>
<%--    var uniqueHangSet = new Set();--%>

<%--    <c:forEach items="${categorySP}" var="category">--%>
<%--    uniqueHangSet.add("${category.hang}");--%>
<%--    </c:forEach>--%>

<%--    var uniqueHangArray = Array.from(uniqueHangSet);--%>
<%--</script>--%>

<%--<select class="form-select" aria-label="Default select example">--%>
<%--    <script>--%>
<%--        for (var i = 0; i < uniqueHangArray.length; i++) {--%>
<%--            document.write('<option value="' + uniqueHangArray[i] + '">' + uniqueHangArray[i] + '</option>');--%>
<%--        }--%>
<%--    </script>--%>
<%--</select>--%>
</html>