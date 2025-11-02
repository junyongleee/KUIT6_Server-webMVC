<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<%@ include file="/include/header.jspf" %>
<body>
<%@ include file="/include/navigation.jspf" %>

<div class="container" id="main">
    <h2>Q&A</h2>
    <div class="qna-list">
        <ul class="list">
            <c:if test="${empty questions}">
                <li>
                    <div class="wrap">
                        <div class="main">
                            <strong class="subject">등록된 질문이 없습니다.</strong>
                                <%--
                                            <li>
                                                <div class="wrap">
                                                    <div class="main">
                                                        <strong class="subject">
                                                            <a href="qna/show.jsp"> 객체지향을 가장 잘 다룬 책이 뭐가 있나요? </a>
                                                        </strong>
                                                        <div class="auth-info">
                                                            <i class="icon-add-comment"></i>
                                                            <span class="time">2024-09-29 23:11</span>
                                                            <span clas="author">이영선</span>
                                                            <!-- <a href="./user/profile.html" class="author">이영선</a> -->
                                                        </div>
                                                        <div class="reply" title="댓글">
                                                            <i class="icon-reply"></i>
                                                            <span class="point">12</span>
                                                            --%>
                        </div>
                    </div>
                        <%--                </div>--%>
                        <%--            </li>--%>
                        <%--            <li>--%>
                        <%--                <div class="wrap">--%>
                        <%--                    <div class="main">--%>
                        <%--                        <strong class="subject">--%>
                        <%--                            <a href="qna/show.jsp"> 객체지향에서 가장 중요하다고 생각하는 것이 무엇인가요? </a>--%>
                        <%--                        </strong>--%>
                        <%--                        <div class="auth-info">--%>
                        <%--                            <i class="icon-add-comment"></i>--%>
                        <%--                            <span class="time">2024-09-29 23:55</span>--%>
                        <%--                            <span class="author">이윤정</span>--%>
                        <%--                            <!-- <a href="./user/profile.html" class="author">이윤정</a> -->--%>
                        <%--                        </div>--%>
                        <%--                        <div class="reply" title="댓글">--%>
                        <%--                            <i class="icon-reply"></i>--%>
                        <%--                            <span class="point">8</span>--%>

                </li>
            </c:if>
            <c:forEach items="${questions}" var="question" varStatus="status">
                <li>
                    <div class="wrap">
                        <div class="main">
                            <c:url var="showQuestionUrl" value="/qna/show">
                                <c:param name="questionId" value="${question.questionId}" />
                            </c:url>
                            <strong class="subject">
<%--                            <a href="qna/show?questionId=${question.questionId}">${question.title}</a>--%>
                                <a href="${showQuestionUrl}">${question.title}</a>
                            </strong>
                            <div class="auth-info">
                                <i class="icon-add-comment"></i>
                                <span class="time">${question.createdDate}</span>
                                <span class="author">${question.writer}</span>
                                    <%-- profile 관련 api 구현 --%>
                                    <%-- <a href="./user/profile.jsp" class="author">${question.writer}</a> --%>
                            </div>
                            <div class="reply" title="댓글">
                                <i class="icon-reply"></i>
                                <span class="point">
                                        <c:choose>
                                            <c:when test="${not empty question.countOfAnswer}">${question.countOfAnswer}</c:when>
                                            <c:otherwise>0</c:otherwise>
                                        </c:choose>
                                    </span>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-5">
                <ul class="pagination" style="display:align-items-center;">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item active" aria-current="page">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </div>
            <div class="col-md-2 qna-write">
<%--                <a href="./qna/form.html" class="btn btn-primary pull-right" role="button">질문하기</a>--%>
                <a href="<c:url value='/qna/form'/>" class="btn btn-primary pull-right" role="button">질문하기</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>