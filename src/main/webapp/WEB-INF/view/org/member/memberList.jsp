<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sh" uri="/WEB-INF/tlds/shUtil.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script src='/bower_components/moment/min/moment.min.js'></script>

<script>
    $(document).ready(function () {
        $("#checkall").click(function () {
            if ($("#checkall").prop("checked")) {
                $("input[name=chkMember]").prop("checked", true);
            } else {
                $("input[name=chkMember]").prop("checked", false);
            }
        });
    });


    $(document).ready(function () {
        $("input[type=checkbox]").switchButton({
            on_label: '사용',
            off_label: '사용안함'
        });
    });

    function onPage(pageNo) {
        $("#pageNo").val(pageNo);

        location.href = "/org/member/memberList.do?" + $("#searchForm").serialize();
    }

    function changeArticlePerPage(v) {
        $("#searchForm [name='pageSize']").val(v);
        onPage(1);
    }

    function orderList(orderVal, orderAsc) {
        $("#searchForm [name='orderVal']").val(orderVal);
        $("#searchForm [name='orderAsc']").val(orderAsc);

        onPage(1);
    }

    function simplyModify() {

	    /*$("#memberForm").attr ("method", "post");
	    $("#memberForm").attr ("action", "simplyModify.do");
    	$("#memberForm").submit ();*/

	    var items = [];

	    $("#memberForm input[type='checkbox'][name='chkMember']:checked").each (function () {
		    var data = {'memberId':$(this).val(),
			    "used":($("#memberForm input[type='checkbox'][name='used_" + $(this).val() + "']:checked").length > 0)
		    };

		    items.push (data);
	    });

	    var successCnt = 0;

	    for (i = 0; i < items.length; i++)
	    {
	    	var data = items[i];

		    $.ajax({
			    type: "POST",
			    url: "modifyMember.do",
			    data: data,
			    success: function (data, textStatus) {

				    successCnt++;

			        if (items.length == successCnt) {
				        alert("수정되었습니다");
				        location.reload();
			        }
			    }
		    });
	    }

        // var items = [];
        /*$("#memberForm input[type='checkbox'][name='chkMember']:checked").each(function () {
                items.push($(this).val());
            }
        );*/
        //var item=$("#memberForm input[type='checkbox'][name='chkMember']:checked").find(':input').serialize();
        //alert(items);
//        var tmp = items.join(',');
//        alert(tmp);
//        $.ajax({
//            type: "POST",
//            url: "/org/member/simplyModify.do",
//            dataType: "html",
//            data: tmp,
//            success: function (data, textStatus) {
//                alert("수정되었습니다");
//
//                location.href="/org/member/memberList.do";
//            }
//        });

    }

    function simplyDelete() {
        $.ajax({
            type: "POST",
            url: "/org/member/simplyDelete.do",
            dataType: "html",
            data: $("#memberForm input[type='checkbox'][name='chkMember']:checked").serialize(),
            success: function (data, textStatus) {
                alert("삭제되었습니다");

                location.href = "/org/member/memberList.do";
            }
        });
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

                            <a href="javascript:simplyModify()" class="btn btn-warning">수정</a>
                            <a href="javascript:simplyDelete()" class="btn btn-danger">삭제</a>
                        </div>
                        <form action="/org/member/memberList.do" name="memberForm" id="memberForm">
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
                <div class="col-lg-12">
                    <form name="searchForm" id="searchForm" action="/org/member/memberList.do" class="form-inline">
                        <input type="hidden" name="pageNo" id="pageNo" value="${paging.currentPage}">
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
                        <div style="border: 1px; float: left; width: 20%; ">

                            이름 <input type="text" name="se_name" class="form-control" value="${se_name}"
                                   placeholder="Search for name">
                        </div>
                        <div style="border: 1px; float: left; width: 20%; ">

                            아이디 <input type="text" name="se_memberId" class="form-control" value="${se_memberId}"
                                   placeholder="Search for memberId">
                        </div>
                        <div style="border: 1px; float: left; width: 20%; ">

                            이메일 <input type="text" name="se_email" class="form-control" value="${se_email}"
                                   placeholder="Search for email">
                        </div>

                        <div style="border: 1px; float: left; ">
                        <input type="submit" class="btn btn-default" value="찾기">
                        </div>
                        <div style="border: 1px; float: left; ">
                        <a href="/org/member/memberList.do" class="btn btn-primary">목록으로</a>
                        </div>
                    </form>

                    <div style="clear:both;"></div>

                    <sh:paging currentPage="${paging.currentPage}" totalArticles="${paging.totalArticles}"
                               showPages="${paging.showPages}" articlesPerPage="${paging.articlesPerPage}"/>


                </div><!-- /.col-lg-6 -->
            </div><!-- /row-->
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</div>

<form name = 'modifyForm'>

</form>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>