<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> List of Products</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <c:forEach items="${hangList}" var="hang">
        <tr>
            <td><p>${hang.idHang}</p></td>
            <td><p>${hang.ten}</p></td>
        </tr>
    </c:forEach>

    <select class="form-select" aria-label="Default select example">
        <c:forEach items="${hangList}" var="hang">
                <option value=${hang.idHang}>${hang.ten}</option>
        </c:forEach>
    </select>
    <select class="form-select" aria-label="Default select example">
        <c:forEach items="${kieuTuList}" var="kt">
            <option value=${kt.idKieuTu}>${kt.ten}</option>
        </c:forEach>
    </select>
</table>
<br/>