<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>
    function deletePlacev(placeNo) {
        if (confirm("삭제하시겠습니까?")) {
            $.ajax({
                type: "GET",
                url: "/reservation/place/deletePlace.do?placeNo=" + placeNo,
                dataType: "html",
                success: function (data, textStatus) {
                    result = data;
                    console.log(data);
                    console.log(result);
                    alert("삭제되었습니다");

                    reloadPlace();
                }

            });
        }
    }
    function modifyPlacev(placeNo) {

        var formData=$("#placeTr"+placeNo).find(":input").serialize();
        $.ajax({
            type: "POST",
            url: "/reservation/place/modifyPlace.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("수정되었습니다");

                reloadPlace();
            }
        });
    }

    function insertPlace() {
        var formData=$("#addTr").find(":input").serialize();
        $.ajax({
            type: "POST",
            url: "/reservation/place/insertPlace.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("등록되었습니다");

                reloadPlace();
            }
        });
    }
    function reloadPlace() {
        $("#placeForm").load("/reservation/place/reloadPlace.do");
    }

</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">예약장소 관리</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    예약장소
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="placeForm" class="table table-striped table-boardered table-hover">
                            <jsp:include page="/WEB-INF/view/reservation/place/reloadPlaceList.jsp"></jsp:include>
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