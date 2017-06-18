<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sh" uri="/WEB-INF/tlds/shUtil.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>

    function onPage(pageNo, pageSize,searchVal,searchFrom) {
        location.href = "/org/member/memberList.do?pageNo=" + pageNo + "&pageSize=" + pageSize+"&searchFrom="+searchFrom+"&searchVal="+searchVal;
    }

    function orderList(pageNo,pageSize,searchFrom,searchVal,orderVal,orderFrom) {
        location.href = "/org/member/memberList.do?pageNo=" + pageNo + "&pageSize=" + pageSize+"&searchFrom="+searchFrom+"&searchVal="+searchVal+"&orderVal="+orderVal+"&orderFrom="+orderFrom;
    }

    function changeOrderVal() {
        if(document.memberForm.orderAsc.value =="ASC") {
            document.memberForm.orderAsc.value = "DESC";
        }
        else
            document.memberForm.orderAsc.value = "ASC";
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
                                <li><a href="javascript:onPage('${1}','${20}','${searchVal}','${searchFrom}')">20개씩 보기</a></li>
                                <li><a href="javascript:onPage('${1}','${50}','${searchVal}','${searchFrom}')">50개씩 보기</a></li>
                                <li><a href="javascript:onPage('${1}','${100}','${searchVal}','${searchFrom}')">100개씩 보기</a></li>
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
                    <form name="searchForm" action="/org/member/memberList.do" class="form-inline">
                        <input type="hidden" name="pageNo" value="1">
                        <input type="hidden" name="pageSize" value="10">
                        <div class="form-group">
                            <label>
                                <select name="searchFrom" class="form-control">
                                    <option value="memberId"
                                    <c:if test="${searchFrom eq 'memberId'}">selected</c:if>>아이디</option>
                                    <option value="name"
                                    <c:if test="${searchFrom eq 'name'}">selected</c:if>>이름</option>
                                    <option value="email"
                                    <c:if test="${searchFrom eq 'email'}">selected</c:if>>이메일</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <input type="text" name="searchVal" class="form-control" value="${searchVal}"
                                   placeholder="Search for...">
                        </div>
                        <input type="submit" class="btn btn-default" value="찾기">
                        <a href="/org/member/memberList.do" class="btn btn-primary">목록으로</a>

                    <sh:paging currentPage="${paging.currentPage}" totalArticles="${paging.totalArticles}"
                               showPages="${paging.showPages}" articlesPerPage="${paging.articlesPerPage}"/>
                    </form>

                </div><!-- /.col-lg-6 -->
            </div><!-- /row-->
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</div>


<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>