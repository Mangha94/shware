<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap;

    $(document).ready (function () {
        element_wrap = document.getElementById('wrap');
    });

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {

        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function (data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if (data.addressType === 'R') {
                    //법정동명이 있을 경우 추가한다.
                    if (data.bname !== '') {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if (data.buildingName !== '') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample3_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample3_address').value = fullAddr;

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize: function (size) {
//                element_wrap.style.height = size.height+'px';
            },
            width: '100%',
            height: '100%'
        }).embed(element_wrap);

// iframe 을 넣은 element 를 보이게 한다.
        element_wrap.style.display = 'block';
//        element_wrap.show();
    }

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
        else if (myForm.idDuplication.value != "idCheck") {
            alert("아이디 중복체크를 해주세요");
            flag = false;

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

                    location.href = "/org/member/memberList.do";
                }

            });
        }

//sumit을 안시킨다

        event.preventDefault();
        event.returnValue = false;

        return false;
    }

    function idChk() {
        var newMemberId = document.userInfo.memberId.value;
        $.ajax({
            type: "GET",
            url: "/org/member/idCheckForm.do?memberId=" + newMemberId,
            dataType: "json",
            data: newMemberId,
            success: function (data, textStatus) {

                if (data.success) {
                    alert("등록가능한 아이디 입니다");
                    document.userInfo.idDuplication.value = "idCheck";
                }
                else
                    alert("이미 존재하는 아이디 입니다");
            }

        });
    }

    function returnMemberList() {
        location.href = "/org/member/memberList.do";

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
                    <form method="post" action="/org/member/addMember.do" id="userInfo" name="userInfo"
                          onsubmit="onSubmitMember(this)">

                        <div class="form-group">
                            <label>아이디</label>
                            <input type="hidden" name="idDuplication" value="idUncheck">
                            <input type="text" name="memberId" id="memberId" class="form-control">
                            <input type="button" onClick="idChk()" class="btn btn-warning" value="중복확인">
                        </div>
                        <div class="form-group">
                            <label>pw</label>
                            <input type="password" name="pw" class="form-control">
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
                            <label>주소</label>
                            <input type="text" id="sample3_postcode" placeholder="우편번호"> -
                            <input type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기"><br>

                            <div id="wrap"
                                 style="display:none; border:1px solid; width:500px; height:300px; margin:5px 0; position:relative">
                                <img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
                                     id="btnFoldWrap"
                                     style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1"
                                     onclick="foldDaumPostcode()" alt="접기 버튼">
                            </div>
                            <input type="text" id="sample3_address" class="d_form large" placeholder="주소">
                            <input type="text" id="sample4_address" class="d_form large" placeholder="도로명주소">
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