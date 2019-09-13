<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new SEAM</title>
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
    <c:if test="${fail!=null}">
        <caption class="heading">${fail}</caption>
    </c:if>
</table>
<table class="style">
    <form method="post" action="/add">
        <div class="box">
            <p class="heading2">Добавление нового катета шва</p>
            <input hidden name="seam" value="${seam}">
            <input class="w3-input" type="number" placeholder="Катет в мм" name="k" required="required">
            <input class="w3-input" type="number" step="0.001" placeholder="Коэффициент" name="koef"
                   required="required">
            <button class="w3-button w3-black" type="submit">Добавить в базу</button>
            <br>
            <a href="/" class="w3-button w3-yellow">К подсчетам норм</a>
        </div>
    </form>
</table>
</body>
</html>
