<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<thead>
<tr>
    <th>MemberId</th>
    <th>Name</th>
    <th>Position</th>
    <th>Spot</th>
    <th>Department</th>
    <th>Email</th>
    <th>Used</th>
    <th>SecurityRating</th>
</tr>
</thead>
<tbody>
<c:forEach items="${memberList}" var="member">

    <tr>
        <td><a href="/org/member/getMember.do?memberId=${member.memberId}">${member.memberId}</a></td>
        <td>${member.name}</td>
        <td>${member.positionNo}</td>
        <td>${member.spotNo}</td>
        <td>${member.departmentNo}</td>
        <td>${member.email}</td>
        <td>${member.used}</td>
        <td>${member.securityRating}등급</td>
    </tr>
</c:forEach>

</tbody>