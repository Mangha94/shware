<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<thead>
<tr>
    <th>
        #
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','memberId','${orderAsc}')">MemberId</a>
        <span class="glyphicon glyphicon-up" aria-hidden="true"></span>
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','name','${orderAsc}')">Name</a>
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','position','${orderAsc}')">Position</a>
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','spot','${orderAsc}')">Spot</a>
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','department','${orderAsc}')">Department</a>
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','email','${orderAsc}')">Email</a>
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','used','${orderAsc}')">Used</a>
    </th>
    <th>
        <a href="javascript:orderList('${pageNo}','${pageSize}','${searchVal}','${searchFrom}','securityRating','${orderAsc}')">SecurityRating</a>
    </th>
</tr>
</thead>
<tbody>
<c:forEach items="${pagingList.listData}" var="member">
    <tr>
        <td></td>
        <td><a href="/org/member/getMember.do?memberId=${member.memberId}">${member.memberId}</a></td>
        <td>${member.name}</td>
        <td>${member.positionName}</td>
        <td>${member.spotName}</td>
        <td>${member.departmentName}</td>
        <td>${member.email}</td>
        <td>${member.used}</td>
        <td>${member.securityRating}등급</td>
    </tr>
</c:forEach>

</tbody>