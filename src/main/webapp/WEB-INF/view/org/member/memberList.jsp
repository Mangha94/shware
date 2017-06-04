<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>

    function reloadMember() {
        $("#memberForm").load("/org/member/reloadMember.do");
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
                    <form action="/org/member/searchMember.do" class="form-inline">
                        <div class="form-group">
                            <select name="searchFrom" class="form-control">
                                <option value="memberId">아이디</option>
                                <option value="name">이름</option>
                                <option value="email">이메일</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" name="searchVal" class="form-control" value="" placeholder="Search for...">
                        </div>
                            <input type="submit" class="btn btn-default" value="찾기">
                            <a href="/org/member/memberList.do" class="btn btn-primary">목록으로</a>
                    </form>
                    <nav>
                        <ul class="pagination pagination-sm">
                            <input type="hidden" name="page" id="page" value="1">
                            <input type="hidden" name="countList" id="countList" value="10">
                            <li>
                                <a href="javascript:getPreciousPage()" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <c:forEach begin="${startPage}" end="${endPage}" items="idx">
                            <li><a href="javascript:getList('${idx}')">${idx}</a></li>
                            </c:forEach>
                            <li>
                                <a href="javascript:getNextPage()" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
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