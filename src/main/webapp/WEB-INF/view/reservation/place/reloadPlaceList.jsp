<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<thead>
<tr>
    <th>장소명</th>
    <th>시작시간</th>
    <th>마감시간</th>
    <th>관리</th>
</tr>
</thead>
<tbody>
<c:forEach items="${placeList}" var="place">
    <tr id="placeTr_${place.placeNo}">

        <td>
            <input type="text" name="place" class="form-control" value="${place.place}">
        </td>
        <td>
            <fmt:formatDate value='${place.startTime}' var='startTime' pattern="HH:MM"/>
            <input type="time" id="startTime" value="${startTime}" class="form-control">

        </td>
        <td>
            <fmt:formatDate value='${place.endTime}' var='endTime' pattern="HH:MM"/>
            <input type="time" id="endTime" value="${endTime}" class="form-control">

        </td>
        <td>
            <a href="javascript: modifyPlacev('${place.placeNo}')" class="btn btn-warning">수정하기</a>
            <a href="javascript: deletePlacev('${place.placeNo}')" class="btn btn-danger">삭제하기</a>
        </td>

    </tr>
</c:forEach>
<tr id="addTr">

    <td>
        <input type="text" class="form-control" name="place" placeholder="placeName"/>
    </td>
    <td>
        <input type="time" name="startTime" class="form-control" >
    </td>
    <td>
        <input type="time" name="endTime" class="form-control">
    </td>
    <td>
        <a href="javascript:insertPlace()" class="btn btn-primary">등록하기</a>
    </td>
</tr>
</tbody>