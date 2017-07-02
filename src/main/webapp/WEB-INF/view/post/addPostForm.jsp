<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>
<div id="page-wrapper">
    <div class="row">
        <h1>${boardSetting.boardName}</h1>
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>${getPost.postNo eq null ? '포스트등록' : '포스트수정'}</h3>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <form id="addPostForm" method="post" action="/post/${getPost.postNo eq null ? 'addPost.do' : 'modifyPost.do'}">
                        <input type="hidden" name="postNo" value="${getPost.postNo}">
                        <input type="hidden" name="boardNo" value="${boardSetting.boardNo}">
                        <p>제목</p>
                        <input type="text" name="postName" value="${getPost.postName}" class="form-control" placeholder="postName">
                        <p>등록아이디</p>
                        <input type="text" name="postedId" value="${getPost.postedId}" class="form-control" ${getPost.postNo eq null ? '' : 'readonly'} placeholder="postedId" >
                        <p>내용</p>
                        <textarea name="postContent" class="form-control" rows="15">${getPost.postContent}</textarea>

                        <input type="submit" class="btn btn-${getPost.postNo eq null ? 'primary' : 'warning'}" value="${getPost.postNo eq null ? '등록하기' : '수정하기'}">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>