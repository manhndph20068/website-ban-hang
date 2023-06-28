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
        <h4>Order Detail</h4>
    </div>
    <div>
        <table class="table table-hover" border="1">
            <thead>
            <tr>
                <td>Ma Hoa Don</td>
                <td>Ten San Pha,</td>
                <td>So Luong</td>
                <td>Don Gia</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cthd}" var="hd">
                <tr>
                    <td>HD${hd[0]}</td>
                    <td>${hd[2]}</td>
                    <td>${hd[3]}</td>
                    <td><fmt:formatNumber pattern="###,### VND" value="${hd[4]}" /></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</section>
</body>
</html>