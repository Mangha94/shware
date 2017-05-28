<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>
    function deletePositionv(positionNo) {
        if (confirm("삭제하시겠습니까?")) {
            $.ajax({
                type: "GET",
                url: "/org/rank/deletePosition.do?positionNo=" + positionNo,
                dataType: "html",
                success: function (data, textStatus) {
                    result = data;
                    console.log(data);
                    console.log(result);
                    alert("삭제되었습니다");

                    reloadPosition();
                }

            })
        }
    }

    function modifyPositionv(positionNo) {
//        positionForm.positionNo.value = positionNo;
//        modifyPositionv.submit();
        $(document).ready(function () {
                var formData = $("modifyForm").serialize();
                $.ajax({
                    type: "POST",
                    url: "/org/rank/modifyPosition.do?positionNo=" + positionNo,
                    data: dataForm,
                    success: function (data, textStatus) {
                        result = data;
                        console.log(data);
                        console.log(result);
                        alert("수정되었습니다");

                        reloadPosition();
                    }
                })
        })
    }

    function reloadPosition() {
        $("#positionForm").load("/org/rank/reloadPosition.do");
    }

</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">직책관리</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    직책
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <c:choose>
                            <input type="hidden" name="positionNo" value=""/>
                            <c:when test="${getPositon eq null}">
                                <form method="post" id="addForm" action="/org/rank/addPosition.do">
                            </c:when>
                            <c:otherwise>
                                <form method="post" id="modifyForm" action="">
                            </c:otherwise>
                        </c:choose>
                            <table id="positionForm" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>순위</th>
                                    <th>직책명</th>
                                    <th>관리</th>
                                </tr>
                                </thead>
                                <c:forEach items="${positionList}" var="position">
                                    <%--<form method="post" action="/org/rank/modifyPosition.do">--%>
                                    <tbody>
                                    <tr>

                                        <td>
                                            <select name="ranking_${position.positionNo}" class="form-control">
                                                <c:forEach begin="1" end="12" var="idx">
                                                    <option value="${idx}"
                                                            <c:if test="${position.ranking eq idx}">selected</c:if>>${idx}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="text" name="positionName_${position.positionNo}"
                                                   class="form-control" value="${position.positionName}">
                                        </td>
                                        <td>
                                            <a href="javascript: modifyPositionv('${position.positionNo}')"
                                               class="btn btn-warning">수정하기</a>
                                            <a href="javascript: deletePositionv('${position.positionNo}')"
                                               class="btn btn-danger">삭제하기</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <%--</form>--%>
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
                                                <input type="text" class="form-control" name="positionName"
                                                       placeholder="positionName"/>
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