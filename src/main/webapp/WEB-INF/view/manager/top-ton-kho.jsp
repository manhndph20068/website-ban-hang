<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Top 10 Products</title>

</head>
<body class="container">
<%@include file="header.jsp" %>
<h1>Top 10 Sản Phẩm Tồn Kho</h1>
<br>
<table class="table table-hover" border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${top10Products.getContent()}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${product[1]}</td>
            <td><fmt:formatNumber pattern="###,### VND" value="${product[2]}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>