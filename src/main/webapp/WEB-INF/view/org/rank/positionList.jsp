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
        var formData = $("#positionTr_" + positionNo).find(':input').serialize();

        $.ajax({
            type: "POST",
            url: "/org/rank/modifyPosition.do",
            data: formData,
            success: function (data, textStatus) {
                result = data;
                console.log(data);
                console.log(result);
                alert("수정되었습니다");

                reloadPosition();
            }
        });

    }

    function addPositionv()
    {
	    var formData = $("#addTr").find(":input").serialize();

	    $.ajax({
		    type: "POST",
		    url: "/org/rank/addPosition.do",
		    data: formData,
		    success: function (data, textStatus) {
			    result = data;

			    alert("등록되었습니다");

			    reloadPosition();
		    }
	    });
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
                            <table id="positionForm" class="table table-striped table-boardered table-hover">
								<jsp:include page="/WEB-INF/view/org/rank/reloadPosition.jsp" />
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