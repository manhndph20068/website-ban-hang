<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <h4>List of poduct</h4>
    </div>
    <div class="row">
        <c:forEach items="${sanPham}" var="sp">
            <div class="col-3 mt-4">
                <div class="card" style="width: 18rem; text-align: center; justify-content: center" >
                    <img class="card-img-top" style="height: 250px; width: 250px;padding: 10px; margin-left: 13px;"
                         src="../../../asset/img/${sp.hinhAnh}" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${sp.tenSanPham}</h5>

                        <div class="row"><h5 class="card-title">
                            <fmt:formatNumber pattern="###,### VND" value="${sp.gia}" />
                        </h5>
                        <p>Sl: ${sp.soLuong}</p>
                        </div>

                        <a href="/add/${sp.idSanPham}" class="btn btn-primary">Add To Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>