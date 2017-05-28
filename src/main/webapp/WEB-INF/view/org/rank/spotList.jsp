<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>
    function deleteSpotv(spotNo) {
        if (confirm("삭제하시겠습니까?")) {
            $.ajax({
                type: "GET",
                url: "/org/rank/deleteSpot.do?spotNo=" + spotNo,
                dataType: "html",
                success: function (data, textStatus) {
                    result = data;
                    console.log(data);
                    console.log(result);
                    alert("삭제되었습니다");

                    reloadSpot();
                }

            })
        }
    }
    function reloadSpot() {
        $("#spotForm").load("/org/rank/reloadSpot.do");
    }

    function modifySpotv(spotNo) {
        modifyForm.spotNo.value = spotNo;

        modifyForm.submit();
    }

</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">직위관리</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    직위
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <c:choose>
                            <input type="hidden" name="spotNo" value="${}"/>
                            <c:when test="${getSpot eq null}">
                            <form method="post" name="addForm" action="/org/rank/addSpot.do">
                            </c:when>
                            <c:otherwise>
                            <form method="post" name="modifyForm" action="">
                            </c:otherwise>
                        </c:choose>
                            <table id="spotForm" class="table table-striped table-bordered table-hover">

                                <thead>
                                <tr>
                                    <th>순위</th>
                                    <th>직위명</th>
                                    <th>관리</th>
                                </tr>
                                </thead>
                                <c:forEach items="${spotList}" var="spot">
                                    <tbody>
                                    <tr>

                                        <td>
                                            <select name="ranking_${spot.spotNo}" class="form-control">

                                                <c:forEach begin="1" end="12" var="idx">
                                                    <option value="${idx}"
                                                            <c:if test="${spot.ranking eq idx}">selected</c:if>>${idx}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="text" name="spotName_${spot.spotNo}" class="form-control"
                                                   value="${spot.spotName}">
                                        </td>
                                        <td>
                                                <%--<input type="submit" class="btn btn-warning" value="수정하기">--%>
                                            <a href="javascript: modifySpotv('${spot.spotNo}')" class="btn btn-warning">수정하기</a>
                                            <a href="javascript: deleteSpotv('${spot.spotNo}')" class="btn btn-danger">삭제하기</a>
                                        </td>

                                    </tr>
                                    </tbody>

                                </c:forEach>
                                <div>
                                <div class="col-lg-12">
                                    <table>
                                        <td>
                                            <select class="form-control" name="ranking">
                                                <c:forEach begin="1" end="12" var="idx">
                                                    <option value="${idx}">${idx}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="text" class="form-control" name="spotName" placeholder="spotName"/>
                                        </td>
                                        <td>
                                            <input type="submit" class="btn btn-primary" value="등록하기">
                                        </td>
                                    </table>
                                </div>
                                </div>
                            </table>
                        </form>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </div>


</div>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>




