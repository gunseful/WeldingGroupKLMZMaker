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
            <c:if test="${wire!=null}">
                <%--                <table>--%>
                <%--                    <tr>--%>
                <%--                        <th bgcolor="white">Расход проволоки</th>--%>
                <%--                        <td bgcolor="white">${wire} кг</td>--%>
                <%--                    </tr>--%>

                <%--                    <tr>--%>
                <%--                        <th bgcolor="white">Расход углекислоты</th>--%>
                <%--                        <td bgcolor="white">${gas} м3</td>--%>
                <%--                    </tr>--%>

                <%--                    <tr>--%>
                <%--                        <th bgcolor="white" colspan="2">Расход смеси</th>--%>
                <%--                    </tr>--%>
                <%--                    <tr>--%>
                <%--                        <th bgcolor="white">СO2</th>--%>
                <%--                        <td bgcolor="white">${gasCO2} м3</td>--%>
                <%--                    </tr>--%>
                <%--                    <tr>--%>
                <%--                        <th bgcolor="white">Ar</th>--%>
                <%--                        <td bgcolor="white">${gasAr} м3</td>--%>
                <%--                    </tr>--%>
                <%--                    <tr>--%>
                <%--                        <th bgcolor="white">Расход СварПола</th>--%>
                <%--                        <td bgcolor="white">${svarPol} гр</td>--%>
                <%--                    </tr>--%>
                <%--                </table>--%>
                <div style="white-space: nowrap; opacity: 0.7; color: black; background-color: white; align-content: center; border: 30px; box-shadow: 0 0 40px rgba(0, 0, 0, 0.9);">
                    <p style="color: black; background-color: white; text-align: center; ">Расход проволоки - <b>${wire}</b>
                        кг</p>
                    <p style="color: black; background-color: white; text-align: center">Расход углекислоты - <b>${gas}</b>
                        м3</p>
                    <p style="color: black; background-color: white; text-align: center">Расход смеси: СO2 - <b>${gasCO2}</b>
                        м3; Ar - <b>${gasAr}</b> м3</p>
                    <p style="color: black; background-color: white; text-align: center">Расход СварПола - <b>${svarPol}</b>
                        гр</p>
                </div>
            </c:if>
            <c:if test="${fail!=null}">
                <p style="color: red">${fail}</p>
            </c:if>
            <c:if test="${fail==null}">
                <p class="heading2">Расчет норм расходов сварки</p>
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
                <option name="seam" value="Н1">Н1</option>
            </select>
            <br>


            <input class="w3-input" type="number" placeholder="Катет в мм" name="k" required="required">

            <input class="w3-input" type="number" step="0.001" placeholder="Длина шва в м" name="length"
                   required="required">

            <button class="w3-button w3-green" type="submit">+</button>
            <a href="/" class="w3-button w3-red">Сброс</a>


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
                    <input hidden name="katet" value=${seam.katet.id}>
                    <input hidden name="lenght" value=${seam.lenght}>

                    <tr>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${seam.katet.seam}</p>
                        </td>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${seam.katet.k}</p>
                        </td>
                        <td bgcolor="white" align="center">
                            <p style="color: black">${seam.lenght}</p>
                        </td>
                        <td bgcolor="white" align="center">
                            <button class="w3-button w3-red w3-tiny" type="submit">-</button>
                        </td>
                    </tr>
                </form>

            </c:forEach>


        </table>

    </c:if>


</table>


</body>
</html>
