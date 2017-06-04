<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>


<script>
    $(document).ready(function () {
        $("#Datepicker").datepicker({
            dateFormat: 'yy/mm/dd',
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            showMonthAfterYear: true,
            changeMonth: true,
            changeYear: true,
            yearSuffix: '년'
        });
    });

    function onSubmitMember(myForm) {
        var flag = true;

        if (myForm.memberId.value.trim() == "") {

            alert("아이디를 입력해주세요");
            flag = false;

            myForm.memberId.focus();
        }
        else if(myForm.idDuplication.value !="idCheck"){
            alert("아이디 중복체크를 해주세요");
            flag=false;

            myForm.memberId.focus();
        }
        else if (myForm.pw.value.trim() == "") {
            alert("비밀번호를 입력해주세요");
            flag = false;

            myForm.pw.focus();
        }
        else if (myForm.name.value.trim() == "") {
            alert("이름을 입력해주세요");
            flag = false;

            myForm.name.focus();
        }
        else if (myForm.email.value.trim() == "") {
            alert("이메일을 입력해주세요");
            flag = false;

            myForm.email.focus();
        }
        else if (myForm.entryDate.value.trim() == "") {
            alert("입사일을 입력해주세요");
            flag = false;

            myForm.entryDate.focus();
        }
        else if (myForm.securityRating.value.trim() == "") {
            alert("보안등급을 입력해주세요");
            flag = false;

            myForm.securityRating.focus();
        }
        else if (myForm.used.value.trim() == null) {
            alert("사용여부를 선택해주세요");
            flag = false;

            myForm.used.focus();
        }
        else if (myForm.businessNo.value.trim() == "") {
            alert("사번을 입력해주세요");
            flag = false;

            myForm.businessNo.focus();
        }

        if (flag) {
            $.ajax({
                type: "POST",
                url: myForm.action,
                dataType: "html",
                data: $(myForm).serialize(),
                success: function (data, textStatus) {
                    alert("등록되었습니다");
                }

            });
        }

//sumit을 안시킨다
        if (event.preventDefault)
            event.preventDefault();
        else
            event.returnValue = false;

        return false;
    }

    function idChk() {
        var newMemberId=document.userInfo.memberId.value;
        $.ajax({
            type: "POST",
            url: "/org/member/idCheckForm.do?memberId="+newMemberId,
            dataType: "html",
            data: newMemberId,
            success: function (data, textStatus) {
                if('${newMemberId}' != ""){
                    alert("등록가능한 아이디 입니다");
                    document.userInfo.idDuplication.value ="idCheck";
                    document.userInfo.memberId.value = newMemberId;
                }
               else
                   alert("이미 존재하는 아이디 입니다");
            }

        });
    }


</script>

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
                    <form method="post" action="/org/member/addMember.do" name="userInfo" onsubmit="onSubmitMember(this)">

                        <div class="form-group">
                            <label>아이디</label>
                            <input type="hidden" name="idDuplication" value="idUncheck">
                            <input type="text" name="memberId" id="memberId" class="form-control">
                            <input type = "button" onClick = "idChk()" class="btn btn-warning" value ="중복확인">
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
                            <input name="email" class="form-control">
                            <p class="help-block">id@email.com</p>
                        </div>
                        <div class="form-group">
                            <label>입사일</label>
                            <input name="entryDate" id="Datepicker" class="form-control">
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