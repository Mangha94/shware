<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sh" uri="/WEB-INF/tlds/shUtil.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script src='/bower_components/moment/min/moment.min.js'></script>

<script>
    $(document).ready(function () {
        $("input[type=checkbox]").switchButton({
            on_label: '사용',
            off_label: '사용안함'
        });
    });

    function onPage(pageNo)
    {
	    $("#pageNo").val (pageNo);

        location.href = "/org/member/memberList.do?" + $("#searchForm").serialize();
    }

    function changeArticlePerPage (v)
    {
	    $("#searchForm [name='pageSize']").val (v);

	    onPage(1);
    }

    function orderList(orderVal,orderAsc)
    {
	    $("#searchForm [name='orderVal']").val (orderVal);
	    $("#searchForm [name='orderAsc']").val (orderAsc);

        onPage(1);
    }
</script>

<div id="page-wrapper">
    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    회원 목록
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
                        <form action="/org/member/memberList.do" name="memberForm">
                        <table id="memberTable" class="table">
                            <jsp:include page="reloadMember.jsp"></jsp:include>
                        </table>
                        </form>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <form name="searchForm" id="searchForm" action="/org/member/memberList.do" class="form-inline">
                        <input type="hidden" name="pageNo" id = "pageNo" value="${paging.currentPage}">
                        <input type="hidden" name="pageSize" value="${paging.articlesPerPage}">

                        <input type="hidden" name="orderAsc" value="${orderAsc}">
                        <input type="hidden" name="orderVal" value="${orderVal}">
                        <%--<div class="form-group">--%>
                            <%--<label>--%>
                                <%--<select name="searchFrom" class="form-control">--%>
                                    <%--<option value="memberId"--%>
                                    <%--<c:if test="${searchFrom eq 'memberId'}">selected</c:if>>아이디</option>--%>
                                    <%--<option value="name"--%>
                                    <%--<c:if test="${searchFrom eq 'name'}">selected</c:if>>이름</option>--%>
                                    <%--<option value="email"--%>
                                    <%--<c:if test="${searchFrom eq 'email'}">selected</c:if>>이메일</option>--%>
                                <%--</select>--%>
                            <%--</label>--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                        <div>
                            이름
                            <input type="hidden" name="searchFrom" value="name">
                            <input type="text" name="searchVal" class="form-control" value="${searchVal_name}"
                                   placeholder="Search for name"><br>
                            아이디
                            <input type="hidden" name="searchFrom" value="memberId">
                            <input type="text" name="searchVal" class="form-control" value="${searchVal_memberId}"
                                   placeholder="Search for memberId"><br>
                            이메일
                            <input type="hidden" name="searchFrom" value="email">
                            <input type="text" name="searchVal" class="form-control" value="${searchVal_email}"
                                   placeholder="Search for email"><br>
                        </div>
                        <input type="submit" class="btn btn-default" value="찾기">
                        <a href="/org/member/memberList.do" class="btn btn-primary">목록으로</a>

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