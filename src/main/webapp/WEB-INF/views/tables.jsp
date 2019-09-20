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
<div class="lefttopangle">

    <a href="/" class="w3-button w3-yellow">Home Page </a>

</div>
<table class="style">
    <caption class="heading">KLMZ MAKER WELDING GROUP</caption>
    <br>
</table>
    <table class="style">
        <tr>
            <td colspan="5"><a href="/tables/Т1" class="w3-button w3-green w3-large">Т1</a>
            </td>
            <td colspan="5"><a href="/tables/Т3" class="w3-button w3-light-green w3-large">Т3</a>
            </td>
            <td colspan="5"><a href="/tables/Т6" class="w3-button w3-green w3-large">Т6</a>
            </td>
            <td colspan="5"><a href="/tables/Т8" class="w3-button w3-light-green w3-large">Т8</a>
            </td>
            <td colspan="5"><a href="/tables/У4" class="w3-button w3-green w3-large">У4</a>
            </td>
            <td colspan="5"><a href="/tables/У5" class="w3-button w3-light-green w3-large">У5</a>
            </td>
            <td colspan="5"><a href="/tables/Н1" class="w3-button w3-green w3-large">Н1</a>
            </td>
            <td colspan="5"><a href="/tables/С15" class="w3-button w3-green w3-large">С15</a>
            </td>
            <td colspan="5"><a href="/tables/С8" class="w3-button w3-green w3-large">С8</a>
            </td>

        </tr>
    </table>
<c:if test="${seam!=null}">
    <table class="style">
        <caption class="heading">${seam}</caption>
        <tr>
            <th><p style="color: black">Катет</p></th>
            <th><p style="color: black">Коэффициент</p></th>
            <th><p style="color: black"></p></th>
            <th><p style="color: black"></p></th>
        </tr>
        <c:forEach var="s" items="${seamList}">
            <tr>
                <td><p style="color: black">${s.getCathetValue()}</p></td>
                <td><p style="color: black">${s.getCoefficient()}</p></td>
                <td><a href="/tables/delete/${s.getId()}" class="w3-button w3-tiny"><span
                        class="icon icon-delete"></span></a></td>
                <td><a href="/tables/edit/${s.getId()}" class="w3-button w3-tiny"><span class="icon icon-edit"></span></a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"><a href="/add/${seam}" class="w3-button"><span class="icon icon-add"></span></a></td>
        </tr>
    </table>
</c:if>


</body>
</html>
