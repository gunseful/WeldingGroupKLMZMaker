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
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>

            <c:if test="${wire!=null}">
                <div style="white-space: nowrap; opacity: 0.7; color: black; background-color: white; align-content: center; border: 30px; box-shadow: 0 0 40px rgba(0, 0, 0, 0.9);">
                    <p style="color: black; background-color: white; text-align: center; ">Расход проволоки -
                        <u><b>${wire}</b></u>
                        кг<br>
                    Расход углекислоты -
                        <u><b>${gas}</b></u>
                        м3<br>
                    Расход смеси: СO2 -
                        <u><b>${gasCO2}</b></u>
                        м3; Ar - <u><b>${gasAr}</b></u> м3<br>
                    Расход СварПола -
                        <u><b>${svarPol}</b></u>
                        гр<br>
                    Расход электродов на прихватки -
                        <u><b>${electrod}</b></u>
                        кг</p>
                </div>
            </c:if>
            <c:if test="${fail!=null}">
                <p style="color: red">${fail}</p>
            </c:if>
            <c:if test="${fail==null}">
                <p class="heading2">Добавить еще один шов</p>
            </c:if>
            <input hidden name="wire" value=${wire}>
            <input hidden name="gas" value=${gas}>
            <input hidden name="gasCO2" value=${gasCO2}>
            <input hidden name="gasAr" value=${gasAr}>
            <input hidden name="svarPol" value=${svarPol}>
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
            <input class="w3-input" type="number" placeholder="Катет в мм" name="cathet" required="required">
            <input class="w3-input" type="number" step="0.001" placeholder="Длина шва в м" name="length"
                   required="required">

            <button class="w3-button w3-white" type="submit"><span class="icon icon-add"></span></button><br>
            <br>
            <button onclick="window.location.href='/'" class="w3-button w3-large w3-red">Сброс</button>

            <br>
        </div>
    </form>
    <c:if test="${!history.isEmpty()}">
        <table>
            <tr>
                <th colspan="4" bgcolor="white">История</th>
            </tr>
            <tr>
                <th bgcolor="white"><p style="color: black">Тип шва</p></th>
                <th bgcolor="white"><p style="color: black">Катет(в мм)</p></th>
                <th bgcolor="white"><p style="color: black">Длина(в м)</p></th>
                <th bgcolor="white"></th>
            </tr>
            <c:forEach var="seam" items="${history}">
                <form action="/newSeam/remove/" method="post">
                    <input hidden name="seam" value=${seam.id}>
                    <input hidden name="cathet" value=${seam.cathet.id}>
                    <input hidden name="lenght" value=${seam.lenght}>
                    <tr>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${seam.cathet.seam}</p>
                        </td>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${seam.cathet.cathetValue}</p>
                        </td>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${seam.lenght}</p>
                        </td>
                        <td bgcolor="white" align="center">
                            <button class="w3-button w3-tiny" type="submit"><span class="icon icon-delete"></span>
                            </button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </c:if>
</table>
</body>
</html>
