<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sh" uri="/WEB-INF/tlds/shUtil.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>

    function onPage(pageNo)
    {
        $("#pageNo").val (pageNo);

        location.href = "/post/postList.do?" + $("#searchForm").serialize();
    }

    function changeArticlePerPage (v)
    {
        $("#searchForm [name='pageSize']").val (v);

        onPage(1);
    }
</script>

<div id="page-wrapper">
    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1>${boardSetting.boardName}</h1>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <div class="btn-group">
                            <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown"
                                    aria-expanded="false">
                                limit pageSize <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:changeArticlePerPage('10')">10개씩 보기</a></li>
                                <li><a href="javascript:changeArticlePerPage('20')">20개씩 보기</a></li>
                                <li><a href="javascript:changeArticlePerPage('50')">50개씩 보기</a></li>
                                <li><a href="javascript:changeArticlePerPage('100')">100개씩 보기</a></li>
                            </ul>
                        </div>
                        <form action="/post/postList.do">
                            <table class="table">
                                <jsp:include page="reloadPost.jsp"></jsp:include>
                            </table>
                        </form>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <form name="searchForm" id="searchForm" action="/post/postList.do" class="form-inline">
                        <input type="hidden" name="boardNo" value="${boardSetting.boardNo}">
                        <input type="hidden" name="pageNo" id = "pageNo" value="${paging.currentPage}">
                        <input type="hidden" name="pageSize" value="${paging.articlesPerPage}">
                        <div class="form-group">
                            <label>
                                <select name="searchFrom" class="form-control">
                                    <option value="postedId"
                                            <c:if test="${searchFrom eq 'postedId'}">selected</c:if>>아이디</option>
                                    <option value="postName"
                                            <c:if test="${searchFrom eq 'postName'}">selected</c:if>>게시물이름</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <input type="text" name="searchVal" class="form-control" value="${searchVal}"
                                   placeholder="Search for...">
                        </div>
                        <input type="submit" class="btn btn-default" value="찾기">
                        <a href="/post/addPostForm.do?boardNo=${boardSetting.boardNo}" class="btn btn-info">글쓰기</a>
                        <a href="javascript:onPage(1)" class="btn btn-primary">목록으로</a>

                    </form>

                    <sh:paging currentPage="${paging.currentPage}" totalArticles="${paging.totalArticles}"
                               showPages="${paging.showPages}" articlesPerPage="${paging.articlesPerPage}"/>


                </div><!-- /.col-lg-6 -->
            </div><!-- /row-->
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</div>


<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>