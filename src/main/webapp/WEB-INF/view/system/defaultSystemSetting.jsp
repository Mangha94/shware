<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>
<script>

    function modifyBrowserTitlev(systemSettingNo) {
        var formData = $("#defaultSystemSettingTr_" + systemSettingNo).find(':input').serialize();

        $.ajax({
            type: "POST",
            url: "/system/modifyBrowserTitle.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("수정되었습니다");

                location.href="/system/defaultSystemSetting.do";
            }
        });

    }

</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">기본시스템관리</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    기본시스템
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="defaultSystemSetting" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>브라우져 이름</th>
                                <th>관리</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${defaultSystemSettings}" var="defaultSystemSetting">

                                <tr id = "defaultSystemSettingTr_${defaultSystemSetting.systemSettingNo}">

                                    <td>
                                        <input type="hidden" name="systemSettingNo" value="${defaultSystemSetting.systemSettingNo}"/>
                                        <input type="text" name="browserTitle" class="form-control" value="${defaultSystemSetting.browserTitle}">
                                    </td>
                                    <td>
                                        <a href="javascript: modifyBrowserTitlev('${defaultSystemSetting.systemSettingNo}')"
                                           class="btn btn-warning">수정하기</a>
                                    </td>
                                </tr>

                            </c:forEach>

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
