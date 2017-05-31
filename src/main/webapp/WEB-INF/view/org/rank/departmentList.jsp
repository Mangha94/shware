<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>
    function deleteDepartmentv(departmentNo) {
        if (confirm("삭제하시겠습니까?")) {
            $.ajax({
                type: "GET",
                url: "/org/rank/deleteDepartment.do?departmentNo=" + departmentNo,
                dataType: "html",
                success: function (data, textStatus) {
                    result = data;
                    alert("삭제되었습니다");

                    reloadDepartment();
                }

            })
        }
    }

    function modifyDepartmentv(departmentNo) {
        var formData = $("#departmentTr_" + departmentNo).find(':input').serialize();

        $.ajax({
            type: "POST",
            url: "/org/rank/modifyDepartment.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("수정되었습니다");

                reloadDepartment();
            }
        });

    }

    function addDepartmentv()
    {
        var formData = $("#addTr").find(":input").serialize();

        $.ajax({
            type: "POST",
            url: "/org/rank/addDepartment.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;

                alert("등록되었습니다");

                reloadDepartment();
            }
        });
    }

    function reloadDepartment() {
        $("#positionForm").load("/org/rank/reloadDepartment.do");
    }

</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">부서관리</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    부서
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="positionForm" class="table table-striped table-bordered table-hover">
                            <jsp:include page="/WEB-INF/view/org/rank/reloadDepartment.jsp" />
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