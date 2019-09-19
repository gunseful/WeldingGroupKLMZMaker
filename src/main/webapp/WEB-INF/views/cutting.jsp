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
    <form method="post">
        <div class="box">
            <c:if test="${fail!=null}">
                <p style="color: red">${fail}</p>
            </c:if>
            <c:if test="${fail==null}">
                <p class="heading2">Расчет норм расходов термической резки</p>
            </c:if>
            <input maxlength="5" class="w3-input" type="number" placeholder="Толщина в мм" name="b" required="required">
            <input maxlength="20" class="w3-input" type="number" step="0.001" placeholder="Длина реза в м" name="length"
                   required="required">
            <button class="w3-button w3-black" type="submit">Посчитать норму</button>
            <br>
        </div>
    </form>
</table>
</body>
</html>
