<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<thead>
<tr>
    <th>
        #
    </th>
    <th>
        PostName
    </th>
    <th>
        PostedId
    </th>
    <th>
        PostingDate
    </th>
    <th>
        ViewCnt
    </th>
</tr>
</thead>
<tbody>
<c:forEach items="${pagingList.listData}" var="post">
    <tr>
        <td></td>
        <td><a href="/post/getPost.do?boardNo=${boardSetting.boardNo}&postNo=${post.postNo}">${post.postName}(${post.commentCnt})</a></td>
        <td>${post.postedId}</td>
        <fmt:formatDate value="${post.postingDate}" var="dateFmt" pattern="yyyy/MM/dd"/>
        <td>${dateFmt}</td>
        <td>${post.viewCnt}</td>
    </tr>
</c:forEach>

</tbody>