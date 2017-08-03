<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(document).ready(function () {
        $("#Datepicker").datepicker({
            dateFormat: 'yy/mm/dd',
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            showMonthAfterYear: true,
            changeMonth: true,
            changeYear: true,
            yearSuffix: '년'
        });
    });
</script>
<thead>
<tr>
    <th>장소명</th>
    <th>날짜</th>
    <th>시작시간</th>
    <th>종료시간</th>
    <th>관리</th>
</tr>
</thead>
<form name="reservationForm" action="/reservation/reservation/insertReservation.do" method="post" onsubmit="onsubmitLogin(this)">
    <tbody>
    <tr>
        <td>
            <select name="place" class="form-control">
                <c:forEach items="${place}" var="place">
                    <option value="${place.place}">${place.place}</option>
                </c:forEach>
            </select>

        </td>
        <td>
            <input id="Datepicker" class="form-control">
        </td>
        <td>
            <input type="time" name="startTime" class="form-control">
        </td>
        <td>
            <input type="time" name="endTime" class="form-control">
        </td>
        <td>
            <input type="submit" class="btn btn-success" value="등록하기">
        </td>
    </tr>
    </tbody>
</form>