<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<thead>
<tr>
    <th>부서명</th>
    <th>부서코드</th>
    <th>관리</th>
</tr>
</thead>
<tbody>
<c:forEach items="${departmentList}" var="department">

    <tr id = "departmentTr_${department.departmentNo}">

        <td>
            <input type="hidden" name="departmentNo" value="${department.departmentNo}"/>
            <input type="text" name="departmentName" class="form-control" value="${department.departmentName}">
        </td>
        <td>
            <input type="text" name="departmentCode" class="form-control" value="${department.departmentCode}">
        </td>
        <td>
            <a href="javascript: modifyDepartmentv('${department.departmentNo}')"
               class="btn btn-warning">수정하기</a>
            <a href="javascript: deleteDepartmentv('${department.departmentNo}')"
               class="btn btn-danger">삭제하기</a>
        </td>
    </tr>

</c:forEach>

<tr id="addTr">

    <td>
        <input type="text" name="departmentName" class="form-control" value="">
    </td>
    <td>
        <input type="text" name="departmentCode" class="form-control" value="">
    </td>
    <td>
        <a href="javascript:addDepartmentv()" class="btn btn-primary">등록하기</a>
    </td>
</tr>

</tbody>