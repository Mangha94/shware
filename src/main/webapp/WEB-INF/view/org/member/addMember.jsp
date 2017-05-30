<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<div id="page-wrapper">
    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    회원등록
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <form action="/org/member/addMember.do">

                        <div class="form-group">
                            <label>아이디</label>
                            <input name="memberId" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>pw</label>
                            <input name="pw" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>이름</label>
                            <input name="name" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>직위</label>
                            <select name="spotNo">
                                <c:forEach items="${getSpots}" var="spot">
                                    <option value="${spot.spotNo}">${spot.spotName}</option>
                                </c:forEach>
                            </select>
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>직책</label>
                            <select name="spotNo">
                                <c:forEach items="${getPositions}" var="position">
                                    <option value="${position.positionNo}">${position.positionName}</option>
                                </c:forEach>
                            </select>
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>부서</label>
                            <select name="departmentNo">
                                <c:forEach items="${getDepartment}" var="department">
                                    <option value="${department.departmentNo}">${department.departmentName}</option>
                                </c:forEach>
                            </select>
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>이메일</label>
                            <input name="email" class="form-control">
                            <p class="help-block">id@email.com</p>
                        </div>
                        <div class="form-group">
                            <label>입사일</label>
                            <input name="entryDate" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>보안등급</label>
                            <input name="securityRating" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>사용여부</label>
                            <input name="uesd" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>사번</label>
                            <input name="businessNo" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <input type="submit" class="btn btn-primary" value="등록하기">
                    </form>
                </div>
                <!-- /.table-responsive -->
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>