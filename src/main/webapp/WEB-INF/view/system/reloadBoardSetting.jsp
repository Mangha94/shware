<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<thead>
<tr>
    <th>게시판 조정</th>
    <th>게시판 이름</th>
    <th>사용 여부</th>
    <th>관리</th>
</tr>
</thead>
<tbody>

<c:forEach items="${boardSettingList}" var="board">

    <tr id="boardSettingTr_${board.boardNo}">
        <td>
            <a href="javascript:upBoardSeq('${board.boardNo}')" type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
            </a>
            <a href="javascript:downBoardSeq('${board.boardNo}')" type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
            </a>
        </td>
        <td>
            <input type="text" name="boardName" class="form-control"
                   value="${board.boardName}">
        </td>
        <td>
                <%--셀렉트로--%>
            <select name="used" class="form-control">
                <option value="true"
                        <c:if test="${board.used eq true}">selected</c:if>>사용
                </option>
                <option value="false"
                        <c:if test="${board.used eq false}">selected</c:if>>사용안함
                </option>
            </select>
        </td>
        <td>
            <a href="javascript: modifyBoardSettingv('${board.boardNo}')"
               class="btn btn-warning">수정하기</a>
            <a href="javascript: deleteBoardSettingv('${board.boardNo}')"
               class="btn btn-danger">삭제하기</a>
        </td>
    </tr>

</c:forEach>

<tr id="addTr">

    <td>
    </td>
    <td>
        <input type="text" name="boardName" class="form-control" value="">
    </td>
    <td>
        <select name="used" class="form-control">
            <option value="true">사용</option>
            <option value="false">사용안함</option>
        </select>
    </td>
    <td>
        <a href="javascript:addBoardSettingv()" class="btn btn-primary">등록하기</a>
    </td>
</tr>
</tbody>