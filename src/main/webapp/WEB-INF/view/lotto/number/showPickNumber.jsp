<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <thead>
    <tr>
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
            num40
        </th>
        <th>
            num5
        </th>
        <th>
            num6
        </th>
        <th>
            times
        </th>
        <th>
            pickDate
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${numberList}" var="num">
        <tr>
            <td>
                <span class='inputNumber' num='${num.num1}' times="${num.times}">${num.num1}</span>
            </td>
            <td>
                <span class='inputNumber' num='${num.num2}' times="${num.times}">${num.num2}</span>
            </td>
            <td>
                <span class='inputNumber' num='${num.num3}' times="${num.times}">${num.num3}</span>
            </td>
            <td>
                <span class='inputNumber' num='${num.num4}' times="${num.times}">${num.num4}</span>
            </td>
            <td>
                <span class='inputNumber' num='${num.num5}' times="${num.times}">${num.num5}</span>
            </td>
            <td>
                <span class='inputNumber' num='${num.num6}' times="${num.times}">${num.num6}</span>
            </td>
            <td>${num.times} 회차</td>
            <td>
                <fmt:formatDate value="${num.pickDate}" var="dateFmt" pattern="HH:mm"/>
                    ${dateFmt}
            </td>
        </tr>
    </c:forEach>
    </tbody>