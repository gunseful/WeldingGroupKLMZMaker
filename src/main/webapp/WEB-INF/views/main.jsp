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
                <p class="heading2">Расчет норм расходов сварки</p>
            </c:if>
            <select name="seam">
                <option value="null">Выберите тип шва</option>
                <option name="seam" value="Т1">Т1</option>
                <option name="seam" value="Т3">Т3</option>
                <option name="seam" value="У4">У4</option>
                <option name="seam" value="У5">У5</option>
                <option name="seam" value="Н1">Н1</option>
                <option name="seam" value="Т6">Т6</option>
                <option name="seam" value="Т8">Т8</option>
                <option name="seam" value="С15">С15</option>
                <option name="seam" value="С8">С8</option>


            </select>
            <br>
            <input class="w3-input" type="number" placeholder="Катет в мм" name="k" required="required">
            <input class="w3-input" type="number" step="0.001" placeholder="Длина шва в м" name="length"
                   required="required">
            <button class="w3-button w3-black" type="submit">Посчитать норму</button>
            <br>
        </div>
    </form>
</table>
</body>
</html>
