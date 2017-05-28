<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<thead>
<tr>
    <th>순위</th>
    <th>직위명</th>
    <th>관리</th>
</tr>
</thead>
<c:forEach items="${spotList}" var="spot">
    <tbody>
    <tr>

        <td>
            <select name="ranking_${spot.spotNo}" class="form-control">

                <c:forEach begin="1" end="12" var="idx">
                    <option value="${idx}"
                            <c:if test="${spot.ranking eq idx}">selected</c:if>>${idx}</option>

                </c:forEach>
            </select>
        </td>
        <td>
            <input type="text" name="spotName_${spot.spotNo}" class="form-control"
                   value="${spot.spotName}">
        </td>
        <td>
                <%--<input type="submit" class="btn btn-warning" value="수정하기">--%>
            <a href="javascript: modifySpotv('${spot.spotNo}')" class="btn btn-warning">수정하기</a>
            <a href="javascript: deleteSpotv('${spot.spotNo}')" class="btn btn-danger">삭제하기</a>
        </td>

    </tr>
    </tbody>

</c:forEach>