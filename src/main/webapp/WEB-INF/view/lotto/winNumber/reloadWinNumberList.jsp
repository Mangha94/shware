<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

 <thead>
    <tr>
        <th>
            times
        </th>
        <th>
            num1
        </th>
        <th>
            num2
        </th>
        <th>
            num3
        </th>
        <th>
            num4
        </th>
        <th>
            num5
        </th>
        <th>
            num6
        </th>
        <th>
            bonusNum
        </th>
    </tr>
    </thead>
    <tbody>
    <tr id="setWinNumTr">

        <td>
            <input type="text" name="times" class="form-control">
        </td>
        <td>
            <input type="text" name="num1" class="form-control">
        </td>
        <td>
            <input type="text" name="num2" class="form-control">
        </td>
        <td>
            <input type="text" name="num3" class="form-control">
        </td>
        <td>
            <input type="text" name="num4" class="form-control">
        </td>
        <td>
            <input type="text" name="num5" class="form-control">
        </td>
        <td>
            <input type="text" name="num6" class="form-control">
        </td>
        <td>
            <input type="text" name="bonusNum" class="form-control">
        </td>
        <td>
            <a href="javascript:setWinNumber()" class="btn btn-primary">등록하기</a>
        </td>

    </tr>
    <c:forEach items="${winNumberList}" var="num">
        <tr>
            <td>${num.times} 회차</td>
            <td>${num.num1}</td>
            <td>${num.num2}</td>
            <td>${num.num3}</td>
            <td>${num.num4}</td>
            <td>${num.num5}</td>
            <td>${num.num6}</td>
            <td>${num.bonusNum}</td>

        </tr>
    </c:forEach>
    </tbody>