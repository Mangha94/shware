<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>

    function reloadMember(pageNo,pageSize) {
        $("#memberForm").load("/org/member/reloadMember.do?pageNo="+pageNo+"&pageSize="+pageSize);
    }

    function goPage(pageNo,pageSize,searchForm,searchVal) {
        if(pageNo==null){
            pageNo=1;
        }
        if(pageSize==null) {
            pageSize = 10;
        }

	    if(searchForm==null) {
		    searchForm = "";
	    }

	    if(searchVal==null) {
		    searchVal = "";
	    }

        location.href="/org/member/memberList.do?pageNo=" + pageNo + "&pageSize=" + pageSize+"&searchForm="+searchForm+"&searchVal="+searchVal;

//        $.ajax({
//            type: "GET",
//            url: "/org/member/reloadMember.do?pageNo="+pageNo+"&pageSize="+pageSize,
//            dataType: "html",
//            success: function (data, textStatus){
//                console.log(data);
//                reloadMember(pageNo,pageSize);
//            }
//
//        });
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
                            <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                                limit pageSize <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:goPage('${1}','${20}','${searchForm}','${searchVal}')">20개씩 보기</a></li>
                                <li><a href="javascript:goPage('${1}','${50}','${searchForm}','${searchVal}')">50개씩 보기</a></li>
                                <li><a href="javascript:goPage('${1}','${100}','${searchForm}','${searchVal}')">100개씩 보기</a></li>
                            </ul>
                        </div>
                        <table id="memberForm" class="table">
                            <jsp:include page="reloadMember.jsp"></jsp:include>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <form action="/org/member/memberList.do" class="form-inline">
                        <input type="hidden" name="pageNo" value="1">
                        <input type="hidden" name="pageSize" value="10">
                        <div class="form-group">
                            <select name="searchFrom" class="form-control">
                                <option value="memberId">아이디</option>
                                <option value="name">이름</option>
                                <option value="email">이메일</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" name="searchVal" class="form-control" value=""
                                   placeholder="Search for...">
                        </div>
                        <input type="submit" class="btn btn-default" value="찾기">
                        <a href="/org/member/memberList.do" class="btn btn-primary">목록으로</a>
                    </form>

                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a href="javascript:goPage('${paging.prevPageNo}','${currentPageSize}','${searchForm}','${searchVal}')" class="page-link" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>

                            <c:forEach begin="${paging.startPageNo}" end="${paging.endPageNo}" var="pageNo">
                                <c:choose>
                                    <c:when test="${pageNo eq paging.pageNo}">
                                        <li class="page-item active">
                                              <span class="page-link">
                                                      ${pageNo}
                                                <span class="sr-only">(current)</span>
                                              </span>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item">
                                            <a href="javascript:goPage('${pageNo}','${currentPageSize}','${searchForm}','${searchVal}')" class="page-link">${pageNo}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <li class="page-item">
                                <a href="javascript:goPage('${paging.nextPageNo}','${currentPageSize}','${searchForm}','${searchVal}')" class="page-link" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </nav>

                </div><!-- /.col-lg-6 -->
            </div><!-- /row-->
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</div>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>