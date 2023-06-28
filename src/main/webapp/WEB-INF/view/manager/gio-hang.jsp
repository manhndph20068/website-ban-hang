<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<body class="container">
<%@include file="header.jsp" %>
<h1> My Cart</h1>
<a href="/home">Back to List</a>

<table class="table table-bordered" border="1">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Ten San Pham</th>
        <th>SoLuong</th>
        <th>Gia</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="totalGia" value="0" />
    <c:forEach items="${sanPhamTrongGio}" var="sanPham" varStatus="status">
    <tr>
        <td><p>${sanPham.key}</p></td>
        <td><p>${sanPhamMap[sanPham.key].tenSanPham}</p></td>
        <td><p>${sanPham.value}</p></td>
        <td><p><c:set var="amount" value="${sanPhamMap[sanPham.key].gia * sanPham.value}"/>
            <fmt:formatNumber pattern="###,### VND" value="${amount}"/></p></td>
        <td>
            <a href="/delete-cart/${sanPham.key}">
                <button>Delete</button>
            </a>
        </td>
    </tr>
    <form id="form-${status.index}" action="/tao-hoa-don">
        <input type="hidden" name="productId" value="${sanPham.key}"/>
        <input type="hidden" name="quantity" value="${sanPham.value}"/>
        <input type="hidden" name="price" value="${sanPhamMap[sanPham.key].gia * sanPham.value}"/>
        <button type="submit">Thanh Toan</button>
    </form>
        <c:set var="totalGia" value="${totalGia + (sanPhamMap[sanPham.key].gia * sanPham.value)}" />
    </c:forEach>
</table>
<p>Tổng giá: <fmt:formatNumber pattern="###,### VND" value="${totalGia}" /></p>
</body>
<script src="../../../asset/js/bootstrap.bundle.min.js"></script>
</html>