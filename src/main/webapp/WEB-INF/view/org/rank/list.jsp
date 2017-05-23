<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">직위관리</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <form method="post" action="/org/rank/list.do">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        직위
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>순위</th>
                                    <th>직책</th>
                                    <th>Last Name</th>
                                    <th>수정/삭제</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>
                                        <input type="submit" class="btn btn-default" value="수정하기">
                                        <input type="submit" class="btn btn-danger" value="삭제하기">
                                    </td>
                                </tr>
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
    </form>


</div>
<jsp:include page="/WEB-INF/view/bottom.jsp"/>




