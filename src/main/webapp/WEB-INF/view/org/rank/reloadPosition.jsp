<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<thead>
<tr>
    <th>순위</th>
    <th>직책명</th>
    <th>관리</th>
</tr>
</thead>
<c:forEach items="${positionList}" var="position">
    <%--<form method="post" action="/org/rank/modifyPosition.do">--%>
    <tbody>
    <tr>

        <td>
            <select name="ranking_${position.positionNo}" class="form-control">
                <c:forEach begin="1" end="12" var="idx">
                    <option value="${idx}"
                            <c:if test="${position.ranking eq idx}">selected</c:if>>${idx}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="text" name="positionName_${position.positionNo}"
                   class="form-control" value="${position.positionName}">
        </td>
        <td>
            <a href="javascript: modifyPositionv('${position.positionNo}')"
               class="btn btn-warning">수정하기</a>
            <a href="javascript: deletePositionv('${position.positionNo}')"
               class="btn btn-danger">삭제하기</a>
        </td>

    </tr>
    </tbody>
    <%--</form>--%>
</c:forEach>