<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<section class="header container">
    <%@include file="header.jsp" %>
</section>

<section class="body container">
    <div class="mt-5">
        <h4>List of Order</h4>
    </div>
    <div>
        <table class="table table-hover" border="1">
            <thead>
            <tr>
                <td>Ma Hoa Don</td>
                <td>Ngay Tao</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hoaDonPage.getContent()}" var="hd">
                <tr>
                    <td>${hd.maHoaDon}</td>
                    <td>${hd.ngayTao}</td>
                    <td>
                        <a href="/detail-order/${hd.idHoaDon}">
                            <button class="btn btn-primary">View Detail</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <c:if test="${hoaDonPage.getNumber() + 1 > 1}">
            <a href="?page=${hoaDonPage.getNumber() + 1 - 1}">Prev</a>
        </c:if>

        <span>${hoaDonPage.getNumber() + 1} / ${hoaDonPage.getTotalPages()}</span>

        <c:if test="${hoaDonPage.getNumber() + 1 < hoaDonPage.getTotalPages()}">
            <a href="?page=${hoaDonPage.getNumber() + 1 + 1}">Next</a>
        </c:if>
    </div>
</section>
</body>
</html>