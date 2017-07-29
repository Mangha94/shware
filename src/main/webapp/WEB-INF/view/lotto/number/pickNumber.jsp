<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script>

    function pickNumber() {

        $.ajax({
            type:"GET",
            url:"/lotto/number/pickNum.do",
            data:"html",
            success:function(data,textStatus){
                result=data;

                alert("번호 뽑기 성공!");

                reloadNumberList();
            }
        });
    }

    function reloadNumberList() {
        $("#NumberForm").load("/lotto/number/showPickNumber.do");
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
                        <li role="presentation" class="active"><a href="/lotto/number/pickNumber.do">번호 뽑기</a></li>
                        <li role="presentation"><a href="/lotto/number/numberList.do">뽑은 번호</a></li>
                        <li role="presentation"><a href="/lotto/winNumber/winNumberList.do">당첨 번호</a></li>
                    </ul>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <h3>
                        오늘 뽑은 목록
                    </h3>
                    <div class="table-responsive">
                        <table id="NumberForm" class="table table-striped table-boardered table-hover">
                            <jsp:include page="/WEB-INF/view/lotto/number/showPickNumber.jsp"></jsp:include>
                            <a href="javascript:pickNumber()" class="btn btn-primary">번호 뽑기!!!</a>
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