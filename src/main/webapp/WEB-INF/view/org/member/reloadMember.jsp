<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<thead>
<tr>
    <th>
        #
    </th>
    <th>
        <a href="javascript:orderList('memberId','${orderVal eq 'memberId' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">MemberId</a>
	    <c:if test = "${orderVal eq 'memberId'}">
        <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}" aria-hidden="true"></span>
	    </c:if>
    </th>
    <th>
        <a href="javascript:orderList('name','${orderVal eq 'name' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Name</a>
    </th>
    <th>
        <a href="javascript:orderList('positionNo','${orderVal eq 'positionNo' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Position</a>
    </th>
    <th>
        <a href="javascript:orderList('spotNo','${orderVal eq 'spotNo' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Spot</a>
    </th>
    <th>
        <a href="javascript:orderList('departmentNo','${orderVal eq 'departmentNo' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Department</a>
    </th>
    <th>
        <a href="javascript:orderList('email','${orderVal eq 'email' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Email</a>
    </th>
    <th>
        <a href="javascript:orderList('used','${orderVal eq 'used' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Used</a>
    </th>
    <th>
        <a href="javascript:orderList('securityRating','${orderVal eq 'securityRating' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">SecurityRating</a>
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