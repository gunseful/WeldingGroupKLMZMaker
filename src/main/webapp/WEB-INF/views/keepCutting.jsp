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

            <c:if test="${o2!=null}">
                <div style="white-space: nowrap; opacity: 0.7; color: black; background-color: white; align-content: center; border: 30px; box-shadow: 0 0 40px rgba(0, 0, 0, 0.9);">
                    <p style="color: black; background-color: white; text-align: center; ">Расход кислорода -
                        <u><b>${o2}</b></u>
                        кг<br>
                    Расход Пропана -
                        <u><b>${propan}</b></u>
                        м3<br>
                                    </div>
            </c:if>
            <c:if test="${fail!=null}">
                <p style="color: red">${fail}</p>
            </c:if>
            <c:if test="${fail==null}">
                <p class="heading2">Добавить еще один рез</p>
            </c:if>
            <input hidden name="o2" value=${o2}>
            <input hidden name="propan" value=${propan}>
            <br>
            <input class="w3-input" type="number" placeholder="Толщина в мм" name="b" required="required">
            <input class="w3-input" type="number" step="0.001" placeholder="Длина реза в м" name="length"
                   required="required">

            <button class="w3-button w3-white" type="submit"><span class="icon icon-add"></span></button><br>
            <br>
            <button onclick="window.location.href='/cutting'" class="w3-button w3-large w3-red">Сброс</button>

            <br>
        </div>
    </form>
    <c:if test="${!history.isEmpty()}">
        <table>
            <tr>
                <th colspan="4" bgcolor="white">История</th>
            </tr>
            <tr>
                <th bgcolor="white"><p style="color: black">Катет(в мм)</p></th>
                <th bgcolor="white"><p style="color: black">Длина(в м)</p></th>
                <th bgcolor="white"></th>
            </tr>
            <c:forEach var="cut" items="${history}">
                <form action="/cutting/more/remove/" method="post">
                    <input hidden name="plateId" value=${cut.plate.id}>
                    <input hidden name="cutId" value=${cut.id}>
                    <input hidden name="length" value=${cut.length}>
                    <tr>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${cut.plate.plateValue}</p>
                        </td>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${cut.length}</p>
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
