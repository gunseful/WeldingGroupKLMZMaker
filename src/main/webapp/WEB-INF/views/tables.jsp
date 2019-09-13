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
    <c:forEach var="s" items="${T1}">
        <tr>
            <td><p style="color: black">${s.getK()}</p></td>
            <td><p style="color: black">${s.getKoef()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-black w3-tiny">DELETE</a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-black w3-tiny">EDIT</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Т1" class="w3-button w3-green">Добавить новый шов</a></td>
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
    <c:forEach var="s" items="${T3}">
        <tr>
            <td><p style="color: black">${s.getK()}</p></td>
            <td><p style="color: black">${s.getKoef()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-black w3-tiny">DELETE</a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-black w3-tiny">EDIT</a></td>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Т3" class="w3-button w3-green">Добавить новый шов</a></td>
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
    <c:forEach var="s" items="${T6}">
        <tr>
            <td><p style="color: black">${s.getK()}</p></td>
            <td><p style="color: black">${s.getKoef()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-black w3-tiny">DELETE</a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-black w3-tiny">EDIT</a></td>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Т6" class="w3-button w3-green">Добавить новый шов</a></td>
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
            <td><p style="color: black">${s.getK()}</p></td>
            <td><p style="color: black">${s.getKoef()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-black w3-tiny">DELETE</a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-black w3-tiny">EDIT</a></td>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/Н1" class="w3-button w3-green">Добавить новый шов</a></td>
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
            <td><p style="color: black">${s.getK()}</p></td>
            <td><p style="color: black">${s.getKoef()}</p></td>
            <td><a href="/tables/${s.getId()}" class="w3-button w3-black w3-tiny">DELETE</a></td>
            <td><a href="/edit/${s.getId()}" class="w3-button w3-black w3-tiny">EDIT</a></td>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="4"><a href="/add/У4" class="w3-button w3-green">Добавить новый шов</a></td>
    </tr>

</table>

</body>
</html>
