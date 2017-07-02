<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function deletePost(boardNo,postNo) {
        if(confirm("삭제하시겠습니까?")){
            location.href="/post/deletePost.do?boardNo="+boardNo+"&postNo="+postNo;
        }
    }
    function modifyPost(boardNo,postNo){
        location.href="/post/modifyPostForm.do?boardNo="+boardNo+"&postNo="+postNo;
    }
</script>
<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>
<div id="page-wrapper">
    <div class="row">
        <h1>${boardSetting.boardName}</h1>
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>${getPost.postName}</h3>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <form id="getPostForm" method="post">
                        <p>제목</p>
                        <input  type="text" name="postName" value="${getPost.postName}" class="form-control" placeholder="postName" readonly>
                        <p>등록                                                                                 아이디</p>
                        <input type="text" name="postedId" value="${getPost.postedId}" class="form-control" placeholder="postedId" readonly>
                        <p>내용</p>

                        <p>
                            ${f:replace(getPost.postContent, "\\n", "<br>")}
                        </p>

                        <a href="javascript:modifyPost('${boardSetting.boardNo}','${getPost.postNo}')" class="btn btn-warning">수정하기</a>
                        <a href="javascript:deletePost('${boardSetting.boardNo}','${getPost.postNo}')" class="btn btn-danger">삭제하기</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>