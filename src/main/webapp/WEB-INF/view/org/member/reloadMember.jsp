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
        <c:if test="${orderVal eq 'memberId'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
    <th>
        <a href="javascript:orderList('name','${orderVal eq 'name' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Name</a>
        <c:if test="${orderVal eq 'name'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
    <th>
        <a href="javascript:orderList('positionNo','${orderVal eq 'positionNo' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Position</a>
        <c:if test="${orderVal eq 'positionNo'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
    <th>
        <a href="javascript:orderList('spotNo','${orderVal eq 'spotNo' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Spot</a>
        <c:if test="${orderVal eq 'spotNo'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
    <th>
        <a href="javascript:orderList('departmentNo','${orderVal eq 'departmentNo' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Department</a>
        <c:if test="${orderVal eq 'departmentNo'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
    <th>
        <a href="javascript:orderList('email','${orderVal eq 'email' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Email</a>
        <c:if test="${orderVal eq 'email'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
    <th>
        <a href="javascript:orderList('used','${orderVal eq 'used' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">Used</a>
        <c:if test="${orderVal eq 'used'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
    <th>
        <a href="javascript:orderList('securityRating','${orderVal eq 'securityRating' and orderAsc eq 'DESC' ? 'ASC' : 'DESC'}')">SecurityRating</a>
        <c:if test="${orderVal eq 'securityRating'}">
            <span class="glyphicon glyphicon-triangle-${orderAsc eq 'DESC' ? 'top' : 'bottom'}"
                  aria-hidden="true"></span>
        </c:if>
    </th>
</tr>
</thead>
<tbody>
<form id="simplyModify" action="simplyModify.do" method="post">
    <c:forEach items="${pagingList.listData}" var="member" varStatus="vs">

        <tr>
            <td>
                    ${paging.totalArticles-(paging.currentPage-1)*paging.articlesPerPage - (vs.count - 1)}
            </td>
            <td>
                <input type="checkbox" name="simplyModifyMember" value="${member.memberId}">
                <a href="/org/member/getMember.do?memberId=${member.memberId}">${member.memberId}</a>
            </td>
            <td>${member.name}</td>
            <td>${member.positionName}</td>
            <td>${member.spotName}</td>
            <td>${member.departmentName}</td>
            <td>${member.email}</td>
            <td>
                <input type="checkbox" name="used" value="${member.used eq true}" checked>
            </td>
            <td>${member.securityRating}등급</td>
        </tr>
    </c:forEach>
    <a href="javascript:simplyModify()" class="btn btn-warning">수정</a>
    <a href="javascript:simplyDelete()" class="btn btn-danger">삭제</a>
</form>

</tbody>