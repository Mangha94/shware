<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>


<script>

    function setWinNumber() {
        var formData=$("#setWinNumTr").find("input").serialize();

        $.ajax({
            type:"POST",
            url:"/winNumber/setWinNumber.do",
            data:formData,
            success:function(data,textStatus){
                result=data;

                alert("등록되었습니다");

                reloadWinNumberList();
            }
        });
    }

    function reloadWinNumberList() {
        $("#winNumberForm").load("/winNumber/reloadWinNumberList.do");
    }

</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">번호 뽑기</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="/lotto/number/pickNumber.do">번호 뽑기</a></li>
                        <li role="presentation"><a href="/lotto/number/numberList.do">뽑은 번호</a></li>
                        <li role="presentation" class="active"><a href="/lotto/winNumber/winNumberList.do">당첨 번호</a></li>
                    </ul>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="winNumberForm" class="table table-striped table-boardered table-hover">
                            <jsp:include page="/WEB-INF/view/lotto/winNumber/reloadWinNumberList.jsp"/>
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