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
                    상세 페이지
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <h3>
                        아이디
                    </h3>
                    <p>
                        ${member.memberId}
                    </p>
                    <h3>
                        이름
                    </h3>
                    <p>
                        ${member.name}
                    </p>
                    <h3>
                        직책
                    </h3>
                    <p>
                        <c:forEach items="${getPositions}" var="position">
                            <c:if test="${position.positionNo eq member.positionNo}">${position.positionName}</c:if>
                        </c:forEach>
                    </p>
                    <h3>
                        직위
                    </h3>
                    <p>
                        <c:forEach items="${getSpots}" var="spot">
                            <c:if test="${spot.spotNo eq member.spotNo}">${spot.spotName}</c:if>
                        </c:forEach>
                    </p>
                    <h3>
                        부서
                    </h3>
                    <p>
                        <c:forEach items="${getDepartments}" var="department">
                            <c:if test="${department.departmentNo eq member.departmentNo}">${department.departmentName}</c:if>
                        </c:forEach>
                    </p>
                    <h3>
                        이메일
                    </h3>
                    <p>
                        ${member.email}
                    </p>
                    <h3>
                        입사일
                    </h3>
                    <p>
                        <fmt:formatDate value="${member.entryDate}" var="dateFmt" pattern="yyyy/MM/dd"/>
                        ${dateFmt}
                    </p>
                    <h3>
                        사용여부
                    </h3>
                    <p>
                        <c:if test="${member.used eq true}">사용</c:if>
                        <c:if test="${member.used eq false}">사용안함</c:if>
                    </p>
                    <h3>
                        보안등급
                    </h3>
                    <p>
                        ${member.securityRating} 등급
                    </p>
                    <h3>
                        사번
                    </h3>
                    <p>
                        ${member.businessNo}
                    </p>
                    <a href="/org/member/getMember.do?memberId=${member.memberId}" class="btn btn-warning">수정하기</a>
                    <a href="/org/member/memberList.do" class="btn btn-primary">목록으로</a>
                </div><!-- /.col-lg-6 -->
            </div><!-- /row-->
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
</div>


<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>