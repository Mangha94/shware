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
<tbody>
<c:forEach items="${spotList}" var="spot">
    <tr id="spotTr_${spot.spotNo}">

        <td>
            <input type="hidden" name="spotNo" value="${spot.spotNo}">
            <select name="ranking" class="form-control">

                <c:forEach begin="1" end="12" var="idx">
                    <option value="${idx}" <c:if test="${spot.ranking eq idx}">selected</c:if>>${idx}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="text" name="spotName" class="form-control" value="${spot.spotName}">
        </td>
        <td>
            <a href="javascript: modifySpotv('${spot.spotNo}')" class="btn btn-warning">수정하기</a>
            <a href="javascript: deleteSpotv('${spot.spotNo}')" class="btn btn-danger">삭제하기</a>
        </td>

    </tr>
</c:forEach>
    <tr id="addTr">
        <td>
            <select class="form-control" name="ranking">
                <c:forEach begin="1" end="12" var="idx">
                    <option value="${idx}">${idx}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="text" class="form-control" name="spotName" placeholder="spotName"/>
        </td>
        <td>
            <a href="javascript:addSpotv()" class="btn btn-primary">등록하기</a>
        </td>
    </tr>
</tbody>
