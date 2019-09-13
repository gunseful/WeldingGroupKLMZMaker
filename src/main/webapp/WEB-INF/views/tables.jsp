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
<div class="lefttopangle"><a href="/" class="w3-button w3-yellow">Home Page </a></div>
<table class="style">
    <caption class="heading">KLMZ MAKER WELDING GROUP</caption>
    <br>
</table>
<table class="style">
    <caption class="heading">T1</caption>
    <tr>
        <th><p style="color: black">Катет</p></th>
        <th><p style="color: black">Коэффициент</p></th>
        <th><p style="color: black"></p></th>
        <th><p style="color: black"></p></th>
    </tr>
    <c:forEach var="s" items="${Т1}">
        <tr>
            <td><p style="color: black">${s.getCathet()}</p></td>
            <td><p style="color: black">${s.getCoefficient()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-delete"></span></a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-edit"></span></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Т1" class="w3-button"><span class="icon icon-add"></span></a></td>

    </tr>
</table>
<table class="style">
    <caption class="heading">T3</caption>
    <tr>
        <th><p style="color: black">Катет</p></th>
        <th><p style="color: black">Коэффициент</p></th>
        <th><p style="color: black"></p></th>
        <th><p style="color: black"></p></th>
    </tr>
    <c:forEach var="s" items="${Т3}">
        <tr>
            <td><p style="color: black">${s.getCathet()}</p></td>
            <td><p style="color: black">${s.getCoefficient()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-delete"></span></a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-edit"></span></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Т3" class="w3-button"><span class="icon icon-add"></span></a></td>

    </tr>
</table>
<table class="style">
    <caption class="heading">T6</caption>
    <tr>
        <th><p style="color: black">Катет</p></th>
        <th><p style="color: black">Коэффициент</p></th>
        <th><p style="color: black"></p></th>
        <th><p style="color: black"></p></th>
    </tr>
    <c:forEach var="s" items="${Т6}">
        <tr>
            <td><p style="color: black">${s.getCathet()}</p></td>
            <td><p style="color: black">${s.getCoefficient()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-delete"></span></a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-edit"></span></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Т6" class="w3-button"><span class="icon icon-add"></span></a></td>
    </tr>
</table>
<table class="style">
    <caption class="heading">Н1</caption>
    <tr>
        <th><p style="color: black">Катет</p></th>
        <th><p style="color: black">Коэффициент</p></th>
        <th><p style="color: black"></p></th>
        <th><p style="color: black"></p></th>
    </tr>
    <c:forEach var="s" items="${Н1}">
        <tr>
            <td><p style="color: black">${s.getCathet()}</p></td>
            <td><p style="color: black">${s.getCoefficient()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-delete"></span></a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-edit"></span></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Н1" class="w3-button"><span class="icon icon-add"></span></a></td>
    </tr>
</table>
<table class="style">
    <caption class="heading">У4</caption>
    <tr>
        <th><p style="color: black">Катет</p></th>
        <th><p style="color: black">Коэффициент</p></th>
        <th><p style="color: black"></p></th>
        <th><p style="color: black"></p></th>
    </tr>
    <c:forEach var="s" items="${У4}">
        <tr>
            <td><p style="color: black">${s.getCathet()}</p></td>
            <td><p style="color: black">${s.getCoefficient()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-delete"></span></a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-edit"></span></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Т6" class="w3-button"><span class="icon icon-add"></span></a></td>
    </tr>
</table>
</body>
</html>
