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
        <td>${member.memberId}</td>
        <td>${member.name}</td>
        <td>${member.positionNo}</td>
        <td>${member.spotName}</td>
        <td>${member.departmentNo}</td>
        <td>${member.email}</td>
        <td>${member.used}</td>
        <td>${member.securityRating}등급</td>
    </tr>
</c:forEach>

<tr id="searchForm">
    <td>
        <select name="searchFrom" class="form-control">
            <option value="memberId">아이디</option>
            <option value="name">이름</option>
            <option value="email">이메일</option>
        </select>
    </td>
    <td>
        <input type="text" name="searchVal" class="form-control" value="" placeholder="Search for...">
    </td>
    <td>
        <a href="javascript: searchMember()" class="btn btn-default">찾기</a>
    </td>
</tr>
</tbody>