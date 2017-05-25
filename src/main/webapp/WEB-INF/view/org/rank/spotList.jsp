<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<%--<script>--%>
<%--function deleteSpotv(spotNo) {--%>
<%--if (confirm("삭제하시겠습니까?")) {--%>
<%--location.href = "/deleteSpot.do?positionNo=" + spotNo;--%>
<%--}--%>
<%--}--%>

<%--function modifySpotv(spotNo) {--%>
<%--if (confirm("수정하시겠습니까?")) {--%>
<%--location.href = "/modifySpot.do?positionNo=" + spotNo;--%>
<%--}--%>
<%--}--%>
<%--</script>--%>
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
                        <table class="table table-striped table-bordered table-hover">
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
                                    <form method="post" action="/org/rank/modifySpot.do">
                                        <input type="hidden" name="spotNo" value="${spot.spotNo}"/>
                                        <td>
                                                ${spot.ranking}
                                            <select name="ranking" class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                                <option>8</option>
                                                <option>9</option>
                                                <option>10</option>
                                                <option>11</option>
                                                <option>12</option>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="text" name="spotName" class="form-control"
                                                   value="${spot.spotName}">
                                        </td>
                                        <td>
                                            <input type="submit" class="btn btn-warning" value="수정하기">
                                    </form>
                                    <input type="submit" class="btn btn-danger" value="삭제하기">
                                        <%--<a href="javascript: deleteSpotv('${spot.spotNo}')" class="btn btn-danger">삭제하기</a>--%>
                                    </td>

                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </div>
    <div>

        <form method="post" action="/org/rank/addSpot.do">
            <div class="col-lg-12">
                <table>
                    <td>
                        <select class="form-control" name="ranking">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
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
        </form>

    </div>


</div>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>



