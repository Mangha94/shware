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
    function modifySpotv(spotNo) {
//        modifyForm.spotNo.value = spotNo;
//
//        modifyForm.submit();
        var formData=$("#spotTr_"+spotNo).find(":input").serialize();
        $.ajax({
            type: "POST",
            url: "/org/rank/modifySpot.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("수정되었습니다");

                reloadSpot();
            }
        })
    }

    function addSpotv() {
        var formData=$("#addTr").find(":input").serialize();
        $.ajax({
            type: "POST",
            url: "/org/rank/addSpot.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("등록되었습니다");

                reloadSpot();
            }
        })
    }
    function reloadSpot() {
        $("#spotForm").load("/org/rank/reloadSpot.do");
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
                            <table id="spotForm" class="table table-striped table-bordered table-hover">
                                <jsp:include page="/WEB-INF/view/org/rank/reloadSpot.jsp"></jsp:include>
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




