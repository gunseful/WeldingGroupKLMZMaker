<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KLMZ MAKER WELDING GROUP</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/res/w3.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/png" href="<c:url value="/res/weld.png"/>"/>
</head>
<body>
<div class="lefttopangle"><a href="/" class="w3-button w3-yellow">Home Page </a>
    <a href="/tables" class="w3-button w3-green">Таблицы</a></div>
<table class="style">
    <caption class="heading">KLMZ MAKER WELDING GROUP</caption>
    <br>
</table>
<table class="style">
    <tr>
        <th><p style="color: black">ID</p></th>
        <th><p style="color: black">Тип шва</p></th>
        <th><p style="color: black">Катет</p></th>
        <th><p style="color: black">Коэффициент</p></th>
        <th><p style="color: black"></p></th>
    </tr>
    <tr>
        <c:url value="/tables/edit" var="var"/>
        <form action="${var}" method="post">
            <td>
                <p style="color: black">${cathet.getId()}</p>
                <input type="hidden" class="w3-input" value="${cathet.getId()}" name="id" >
            </td>
            <td>
                <p style="color: black">${cathet.getSeam()}</p>
                <input type="hidden" class="w3-input" value="${cathet.getSeam()}" name="seam" >
            </td>
            <td><input class="w3-input" type="number" value="${cathet.getCathetValue()}" name="cathetValue" required="required"></td>
            <td><input class="w3-input" type="number" step="0.001" value="${cathet.getCoefficient()}" name="coefficient" required="required"></td>
            <td><input type="submit" class="w3-button w3-black" value="SAVE"/></td>
        </form>
    </tr>
</table>
</body>
</html>
