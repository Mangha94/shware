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
<tbody>
<c:forEach items="${positionList}" var="position">

    <tr id = "positionTr_${position.positionNo}">

        <td>
            <input type="hidden" name="positionNo" value="${position.positionNo}"/>
            <select name="ranking" class="form-control">
                <c:forEach begin="1" end="12" var="idx">
                    <option value="${idx}"
                            <c:if test="${position.ranking eq idx}">selected</c:if>>${idx}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="text" name="positionName" class="form-control" value="${position.positionName}">
        </td>
        <td>
            <a href="javascript: modifyPositionv('${position.positionNo}')"
               class="btn btn-warning">수정하기</a>
            <a href="javascript: deletePositionv('${position.positionNo}')"
               class="btn btn-danger">삭제하기</a>
        </td>
    </tr>

</c:forEach>

<tr id="addTr">

    <td>
        <select name="ranking" class="form-control">
            <c:forEach begin="1" end="12" var="idx">
                <option value="${idx}">${idx}</option>
            </c:forEach>
        </select>
    </td>
    <td>
        <input type="text" name="positionName" class="form-control" value="">
    </td>
    <td>
        <a href="javascript:addPositionv()" class="btn btn-primary">등록하기</a>
    </td>
</tr>

</tbody>