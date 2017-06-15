<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>
    function deleteBordSettingv(bordNo) {
        if (confirm("삭제하시겠습니까?")) {
            location.href="/system/deleteBordSetting.do?bordNo=" + bordNo
        }
    }

    function modifyBordSettingv(bordNo) {
        var formData = $("#bordSettingTr_" + bordNo).find(':input').serialize();

        $.ajax({
            type: "POST",
            url: "/system/modifyBordSetting.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("수정되었습니다");

                location.href="/system/bordSetting.do";
            }
        });

    }
    function addBordSettingv() {
        var formData = $("#addTr").find(":input").serialize();

        $.ajax({
            type: "POST",
            url: "/system/addBordSetting.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;

                alert("등록되었습니다");

                location.href="/system/bordSetting.do";
            }
        });
    }
</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">게시판 설정</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    게시판
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="bordSettingForm" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>게시판 순서</th>
                                <th>게시판 이름</th>
                                <th>사용 여부</th>
                                <th>관리</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${bordSettingList}" var="bord">

                                <tr id="bordSettingTr_${bord.bordNo}">
                                    <td>
                                        <input type="hidden" name="bordNo" value="${bord.bordNo}"/>
                                        <select name="sequence" class="form-control">
                                            <c:forEach begin="1" end="5" var="idx">
                                                <option value="${idx}"
                                                        <c:if test="${bord.sequence eq idx}">selected</c:if>>${idx}번째
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" name="bordName" class="form-control"
                                               value="${bord.bordName}">
                                    </td>
                                    <td>
                                        <%--셀렉트로--%>
                                        <input type="radio" name="used" value="true"
                                               <c:if test="${bord.used eq true}">checked</c:if>> 사용
                                        <input type="radio" name="used" value="false"
                                               <c:if test="${bord.used eq false}">checked</c:if>> 사용안함
                                    </td>
                                    <td>
                                        <a href="javascript: modifyBordSettingv('${bord.bordNo}')"
                                           class="btn btn-warning">수정하기</a>
                                        <a href="javascript: deleteBordSettingv('${bord.bordNo}')"
                                           class="btn btn-danger">삭제하기</a>
                                    </td>
                                </tr>

                            </c:forEach>

                            <tr id="addTr">

                                <td>
                                    <select name="sequence" class="form-control">
                                        <c:forEach begin="1" end="5" var="idx">
                                            <option value="${idx}">${idx}번째</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <input type="text" name="bordName" class="form-control" value="">
                                </td>
                                <td>
                                    <label class="radio-inline">
                                        <input type="radio" name="used" value="true"> 사용
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="used" value="false"> 사용안함
                                    </label>
                                </td>
                                <td>
                                    <a href="javascript:addBordSettingv()" class="btn btn-primary">등록하기</a>
                                </td>
                            </tr>

                            </tbody>
                        </table>
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
