<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/view/menu.jsp"></jsp:include>

<script type="text/javascript">

    $(document).ready(function () {

        <c:forEach var="winNum" items="${winNumberList}">
        var nums = [];

        <c:forEach var = "num" items="${winNum.numArr}">
        nums.push("${num}");

        </c:forEach>
        $(nums).each(function (num) {
            $(".inputNumber[num='" + num + "'][times='${winNum.times}']")
                .css("display", "inline-block")
                .css('background', 'red')
                .css('color', '#fff')
                .css('padding', '3px')
                .css('border-radius', '10px');
        });


        $(".inputNumber[num='${winNum.bonusNum}'][times='${winNum.times}']")
            .css("display", "inline-block")
            .css('background', 'blue')
            .css('color', '#fff')
            .css('padding', '3px')
            .css('border-radius', '10px');
        </c:forEach>

    });

</script>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">뽑은 목록</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="/lotto/number/pickNumber.do">번호 뽑기</a></li>
                        <li role="presentation" class="active"><a href="/lotto/number/numberList.do">뽑은 번호</a></li>
                        <li role="presentation"><a href="/lotto/winNumber/winNumberList.do">당첨 번호</a></li>
                    </ul>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="positionForm" class="table table-striped table-boardered table-hover">
                                <thead>
                                <tr>
                                    <th>
                                        #
                                    </th>
                                    <th>
                                        num1
                                    </th>
                                    <th>
                                        num2
                                    </th>
                                    <th>
                                        num3
                                    </th>
                                    <th>
                                        num4
                                    </th>
                                    <th>
                                        num5
                                    </th>
                                    <th>
                                        num6
                                    </th>
                                    <th>
                                        times
                                    </th>
                                    <th>
                                        pickDate
                                    </th>
                                    <th>
                                        rank
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${numberList}" var="num">
                                    <tr>
                                        <td></td>

                                        <td>
                                            <span class='inputNumber' num='${num.num1}'
                                                  times="${num.times}">${num.num1}</span>
                                        </td>
                                        <td>
                                            <span class='inputNumber' num='${num.num2}'
                                                  times="${num.times}">${num.num2}</span>
                                        </td>
                                        <td>
                                            <span class='inputNumber' num='${num.num3}'
                                                  times="${num.times}">${num.num3}</span>
                                        </td>
                                        <td>
                                            <span class='inputNumber' num='${num.num4}'
                                                  times="${num.times}">${num.num4}</span>
                                        </td>
                                        <td>
                                            <span class='inputNumber' num='${num.num5}'
                                                  times="${num.times}">${num.num5}</span>
                                        </td>
                                        <td>
                                            <span class='inputNumber' num='${num.num6}'
                                                  times="${num.times}">${num.num6}</span>
                                        </td>
                                        <td>${num.times} 회차</td>
                                        <td>
                                            <fmt:formatDate value="${num.pickDate}" var="dateFmt" pattern="yyyy/MM/dd"/>
                                                ${dateFmt}
                                        </td>
                                        <td>${num.rank} 등</td>

                                    </tr>
                                </c:forEach>
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

</div>

<jsp:include page="/WEB-INF/view/bottom.jsp"></jsp:include>