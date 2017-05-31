<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<link href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script>
    $(document).ready(function() {
        $( "#Datepicker" ).datepicker({
            dateFormat: 'yy-mm-dd',
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
            monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
            dayNames: ['일','월','화','수','목','금','토'],
            dayNamesShort: ['일','월','화','수','목','금','토'],
            dayNamesMin: ['일','월','화','수','목','금','토'],
            showMonthAfterYear: true,
            changeMonth: true,
            changeYear: true,
            yearSuffix: '년'
        });
    });

    function deleteMemberv(memberId) {
        if (confirm("삭제하시겠습니까?")) {
            location.href = "/org/member/deleteMember.do?memberId=" + memberId;
        }
    }

</script>

<div id="page-wrapper">
    <div class="row">
        <!-- /.col-lg-6 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    회원수정
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <form action="/org/member/modifyMember.do">

                        <div class="form-group">
                            <label>아이디</label>
                            <input name="memberId" value="${getMember.memberId}" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>pw</label>
                            <input name="pw" value="${getMember.pw}" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>이름</label>
                            <input name="name" value="${getMember.name}" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>직위</label>
                            <select name="spotNo" class="form-control">
                                <c:forEach items="${getSpots}" var="spot">
                                    <option value="${spot.spotNo}">${spot.spotName}</option>
                                </c:forEach>
                            </select>
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>직책</label>
                            <select name="positionNo" class="form-control">
                                <c:forEach items="${getPositions}" var="position">
                                    <option value="${position.positionNo}">${position.positionName}</option>
                                </c:forEach>
                            </select>
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>부서</label>
                            <select name="departmentNo" class="form-control">
                                <c:forEach items="${getDepartments}" var="department">
                                    <option value="${department.departmentNo}">${department.departmentName}</option>
                                </c:forEach>
                            </select>
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>이메일</label>
                            <input name="email" value="${getMember.email}" class="form-control">
                            <p class="help-block">id@email.com</p>
                        </div>
                        <div class="form-group">
                            <label>입사일</label>
                            <%--<button type="button" class="btn btn-default btn-sm">--%>
                            <%--<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>날짜선택--%>
                            <%--</button>--%>
                            <input name="entryDate" value="${getMember.entryDate}" id="Datepicker" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>보안등급</label>
                            <select name="securityRating" class="form-control">
                                <c:forEach begin="1" end="5" var="idx">
                                    <option value="${idx}">${idx}등급</option>
                                </c:forEach>
                            </select>
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="form-group">
                            <label>사용여부</label>
                            <div class="checkbox">
                                <label class="radio-inline">
                                    <input type="radio" name="used" value="true"> 사용
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="used" value="false"> 사용안함
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>사번</label>
                            <input name="businessNo" value="${getMember.businessNo}" class="form-control">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <input type="submit" class="btn btn-primary" value="수정하기">
                        <a href="javascript:deleteMemberv('${getMember.memberId}')" class="btn btn-danger">삭제하기</a>
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