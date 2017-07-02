<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>
    function deleteBoardSettingv(boardNo) {
        if (confirm("삭제하시겠습니까?")) {
            location.href="/system/deleteBoardSetting.do?boardNo=" + boardNo
        }
    }

    function modifyBoardSettingv(boardNo) {
        var formData = $("#boardSettingTr_" + boardNo).find(':input').serialize();

        $.ajax({
            type: "POST",
            url: "/system/modifyBoardSetting.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("수정되었습니다");

                location.href="/system/boardSetting.do";
            }
        });

    }

    function upBoardSeq(boardNo) {

            $.ajax({
                type: "POST",
                url: "/system/upBoardSeq.do?boardNo="+boardNo,
                dataType: "json",
                data: boardNo,
                success: function (data, textStatus){

                    if(data.success){
                        alert("수정되었습니다");
                        reloadBoardSetting();
                    }
                    else
                        alert("실패했습니다");
                }

            });
    }

    function downBoardSeq(boardNo) {
        $.ajax({
            type: "POST",
            url: "/system/downBoardSeq.do?boardNo="+boardNo,
            dataType: "json",
            data: boardNo,
            success: function (data, textStatus){

                if(data.success){
                    alert("수정되었습니다");
                    reloadBoardSetting();
                }
                else
                    alert("실패했습니다");
            }

        });
    }

    function reloadBoardSetting() {
        $("#boardSettingForm").load("/system/reloadBoardSetting.do");
    }

    function addBoardSettingv() {
        var formData = $("#addTr").find(":input").serialize();

        $.ajax({
            type: "POST",
            url: "/system/addBoardSetting.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;

                alert("등록되었습니다");

                reloadBoardSetting();
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
                        <table id="boardSettingForm" class="table table-striped table-boardered table-hover">

                            <jsp:include page="/WEB-INF/view/system/reloadBoardSetting.jsp"></jsp:include>

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
