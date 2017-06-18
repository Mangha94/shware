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

    function upBordSeq(bordNo) {

            $.ajax({
                type: "POST",
                url: "/system/upBordSeq.do?bordNo="+bordNo,
                dataType: "json",
                data: bordNo,
                success: function (data, textStatus){

                    if(data.success){
                        alert("수정되었습니다");
                        reloadBordSetting();
                    }
                    else
                        alert("실패했습니다");
                }

            });
    }

    function downBordSeq(bordNo) {
        $.ajax({
            type: "POST",
            url: "/system/downBordSeq.do?bordNo="+bordNo,
            dataType: "json",
            data: bordNo,
            success: function (data, textStatus){

                if(data.success){
                    alert("수정되었습니다");
                    reloadBordSetting();
                }
                else
                    alert("실패했습니다");
            }

        });
    }

    function reloadBordSetting() {
        $("#bordSettingForm").load("/system/reloadBordSetting.do");
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

                reloadBordSetting();
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

                            <jsp:include page="/WEB-INF/view/system/reloadBordSetting.jsp"></jsp:include>

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
