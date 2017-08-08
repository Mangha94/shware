<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<%--full calendar--%>
<link href='/bower_components/fullcalendar/dist/fullcalendar.min.css' rel='stylesheet' />
<link href='/bower_components/fullcalendar/dist/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='/bower_components/moment/min/moment.min.js'></script>
<%--<script src='/bower_components/jquery/dist/jquery.min.js'></script>--%>
<script src='/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>

<script>

    $(document).ready(function() {

        $('#calendar').fullCalendar({
            eventSources: [
                '/eventSource1.json',
                '/eventSource2.json'
            ]
        });

    });

    function onsubmitReservation(myForm) {
        var flag = true;

        if (myForm.place.value.trim() == "") {

            alert("예약장소를 입력해주세요");
            flag = false;

            myForm.place.focus();
        }
        else if (myForm.startTime.value.trim() == "") {
            alert("시작시간을 입력해주세요");
            flag = false;

            myForm.startTime.focus();
        }
        else if (myForm.endTime.value.trim() == "") {
            alert("종료시간을 입력해주세요");
            flag = false;

            myForm.endTime.focus();
        }

        if (flag) {
            $.ajax({
                type: "POST",
                url: myForm.action,
                dataType: "json",
                data: $(myForm).serialize(),
                success: function (data, textStatus) {

                    if (data.success) {
                        alert("예약 성공했습니다~");
                        location.href = "/index.do";
                    }
                    else
                        alert("겹치는 시간 입니다...");
                }

            });
        }
        event.preventDefault();
        event.returnValue = false;

        return false;
    }

    function deleteReservationv(reservationNo) {
        if (confirm("삭제하시겠습니까?")) {
            $.ajax({
                type: "GET",
                url: "/reservation/Reservation/deleteReservation.do?reservationNo=" + reservationNo,
                dataType: "html",
                success: function (data, textStatus) {
                    result = data;
                    console.log(data);
                    console.log(result);
                    alert("삭제되었습니다");

                    reloadReservation();
                }

            });
        }
    }
    function modifyReservationv(reservationNo) {

        var formData=$("#reservationTr"+reservationNo).find(":input").serialize();
        $.ajax({
            type: "POST",
            url: "/reservation/reservation/modifyReservation.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                alert("수정되었습니다");

                reloadReservation();
            }
        });
    }
    function reloadReservation() {
        $("#placeForm").load("/reservation/reservation/reloadReservation.do");
    }
</script>
<style>

    body {
        margin: 40px 10px;
        padding: 0;
        font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
        font-size: 14px;
    }

    #calendar {
        max-width: 900px;
        margin: 0 auto;
    }

</style>


<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">예약하기</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    예약
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">


                    <div id='calendar'></div>

                    <table id="placeForm" class="table table-striped table-boardered table-hover">
                        <jsp:include page="/WEB-INF/view/reservation/reservation/reloadReservation.jsp"></jsp:include>
                    </table>


                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>