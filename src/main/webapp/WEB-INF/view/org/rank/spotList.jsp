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
                                    <th>직위명</th>
                                    <th>관리</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <select class="form-control">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                            <option>7</option>
                                            <option>8</option>
                                            <option>9</option>
                                            <option>10</option>
                                            <option>11</option>
                                            <option>12</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" value="spot">
                                    </td>
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
    <div>

        <form method="post" action="/org/rank/list.do">
            <div class="col-lg-12">
            <table>
                <td>
                    <select class="form-control" name="ranking">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                        <option>11</option>
                        <option>12</option>
                    </select>
                </td>
                <td>
                    <input type="text" class="form-control" value="spot"/>
                </td>
                <td>
                    <input type="submit" class="btn btn-primary" value="등록하기">
                </td>
            </table>
            </div>
        </form>

    </div>


</div>
<jsp:include page="/WEB-INF/view/bottom.jsp"/>




