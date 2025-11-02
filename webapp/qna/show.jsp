<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="ko">
<%@ include file="/include/header.jspf" %>
<body>
<%@ include file="/include/navigation.jspf" %>

<div class="container" id="main">
    <header class="qna-header">
        <%--                <h2 class="qna-title">객체지향을 가장 잘 다룬 책이 뭐가 있나요?</h2>--%>
        <h2 class="qna-title">${question.title}</h2>
    </header>
    <div class="content-main">
        <article class="article">
            <div class="article-header">
                <div class="article-header-thumb">
                    <img src="../img/picture.jpeg" class="article-author-thumb" alt="">
                </div>
                <div class="article-header-text">
                    <!-- 사용자 프로필 추가 할거면 span -> a 태그로 바꾸고 API 연결 -->
                    <%--                            <span class="article-author-name">이영선</span>--%>
                    <span class="article-author-name">${question.writer}</span>
                    <span class="article-header-time">
<%--                              2024-09-29 22:11--%>
                                ${question.createdDate}
                            </span>
                </div>
            </div>
            <div class="article-doc">
                <%--                        <p>저는 지금 '객체지향의 사실과 오해' 라는 책을 읽고 있는데 정말 좋아요</p>--%>
                <%--                        <p>이해가 쏙쏙 됩니다!</p>--%>
                <p>${question.contents}</p>
            </div>
            <div class="article-util">
                <ul class="article-util-list">
                    <li>
                        <!-- 수정, 삭제 API 연결 필요 -->
                        <%--                                <a class="link-modify-article" href="/questions/423/form">수정</a>--%>
                        <a class="link-modify-article" href="/questions/${question.questionId}/form">수정</a>
                    </li>
                    <li>
                        <!-- 수정, 삭제 API 연결 필요 -->
                        <%--                                <form class="form-delete" action="/questions/423" method="POST">--%>
                        <form class="form-delete" action="/questions/${question.questionId}" method="POST">
                            <input type="hidden" name="_method" value="DELETE">
                            <button class="link-delete-article" type="submit">삭제</button>
                        </form>
                    </li>
                    <li>
                        <a class="link-modify-article" href="../home.jsp">목록</a>
                    </li>
                </ul>
            </div>
        </article>

        <div class="qna-comment">
            <div class="qna-comment-kuit">
                <%--                        <p class="qna-comment-count"><strong>2</strong>개의 의견</p>--%>
                <c:set var="answerCount" value="0"/>
                <c:if test="${not empty answers}">
                    <c:set var="answerCount" value="${fn:length(answers)}"/>
                </c:if>
                <p class="qna-comment-count"><strong>${answerCount}</strong>개의 의견</p>
                <div>
                    <%--                            <article class="article" id="answer-1405">--%>
                    <%--                                <div class="article-header">--%>
                    <%--                                    <div class="article-header-thumb">--%>
                    <%--                                        <img src="../img/picture.jpeg" class="article-author-thumb" alt="">--%>
                    <%--                                    </div>--%>
                    <%--                                    <div class="article-header-text">--%>
                    <%--                                        <span class="article-author-name">이윤정</span>--%>
                    <%--                                        <span class="article-header-time">--%>
                    <%--                                           2024-09-29 22:15--%>
                    <%--                                        </span>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                                <div class="article-doc comment-doc">--%>
                    <%--                                    <p>오브젝트여</p>--%>
                    <%--                                </div>--%>
                    <%--                                <div class="article-util">--%>
                    <%--                                    <ul class="article-util-list">--%>
                    <%--                                        <li>--%>
                    <%--                                          <!-- 수정, 삭제 API 연결 필요 -->--%>
                    <%--                                            <a class="link-modify-article" href="/questions/1/answers/1/form">수정</a>--%>
                    <%--                                        </li>--%>
                    <%--                                        <li>--%>
                    <%--                                          <!-- 수정, 삭제 API 연결 필요 -->--%>
                    <%--                                            <form class="delete-answer-form" action="/questions/1/answers/1" method="POST">--%>
                    <%--                                                <input type="hidden" name="_method" value="DELETE">--%>
                    <%--                                                <button type="submit" class="delete-answer-button">삭제</button>--%>
                    <%--                                            </form>--%>
                    <%--                                        </li>--%>
                    <%--                                    </ul>--%>
                    <%--                                </div>--%>
                    <%--                            </article>--%>
                    <%--                            <article class="article" id="answer-1406">--%>
                    <%--                                <div class="article-header">--%>
                    <%--                                    <div class="article-header-thumb">--%>
                    <%--                                        <img src="../img/picture.jpeg" class="article-author-thumb" alt="">--%>
                    <%--                                    </div>--%>
                    <%--                                    <div class="article-header-text">--%>
                    <%--                                        <span class="article-author-name">함형주</span>--%>
                    <%--                                        <span class="article-header-time">--%>
                    <%--                                          2023-09-30 20:20--%>
                    <%--                                        </span>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                    <%--                                <div class="article-doc comment-doc">--%>
                    <%--                                    <p>스프링 입문을 위한 자바 객체 지향의 원리와 이해 추천합니다.</p>--%>
                    <%--                                    <p>(근데 저도 아직 안 읽었어요..)</p>--%>
                    <%--                                </div>--%>
                    <%--                                <div class="article-util">--%>
                    <%--                                    <ul class="article-util-list">--%>
                    <%--                                        <li>--%>
                    <%--                                          <!-- 수정, 삭제 API 연결 필요 -->--%>
                    <%--                                            <a class="link-modify-article" href="/questions/1/answers/2/form">수정</a>--%>
                    <%--                                        </li>--%>
                    <%--                                        <li>--%>
                    <%--                                          <!-- 수정, 삭제 API 연결 필요 -->--%>
                    <%--                                            <form class="form-delete" action="/questions/1/answers/2" method="POST">--%>
                    <%--                                                <input type="hidden" name="_method" value="DELETE">--%>
                    <%--                                                <button type="submit" class="delete-answer-button">삭제</button>--%>
                    <%--                                            </form>--%>
                    <%--                                        </li>--%>
                    <%--                                    </ul>--%>
                    <%--                                </div>--%>
                    <%--                            </article>--%>
                    <c:if test="${not empty answers}">
                        <c:forEach var="answer" items="${answers}">
                            <article class="article" id="answer-${answer.answerId}">
                                <div class="article-header">
                                    <div class="article-header-thumb">
                                        <img src="../img/picture.jpeg" class="article-author-thumb" alt="">
                                    </div>
                                    <div class="article-header-text">
                                        <span class="article-author-name">${answer.writer}</span>
                                        <span class="article-header-time">
                                                ${answer.createdDate}
                                        </span>
                                    </div>
                                </div>
                                <div class="article-doc comment-doc">
                                    <p>${answer.contents}</p>
                                </div>
                                <div class="article-util">
                                    <ul class="article-util-list">
                                        <li>
                                            <!-- 수정, 삭제 API 연결 필요 -->
                                            <a class="link-modify-article"
                                               href="/questions/${question.questionId}/answers/${answer.answerId}/form">수정</a>
                                        </li>
                                        <li>
                                            <!-- 수정, 삭제 API 연결 필요 -->
                                            <form class="delete-answer-form"
                                                  action="/questions/${question.questionId}/answers/${answer.answerId}"
                                                  method="POST">
                                                <input type="hidden" name="_method" value="DELETE">
                                                <button type="submit" class="delete-answer-button">삭제</button>
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </article>
                        </c:forEach>
                    </c:if>
                    <form class="submit-write">
                        <div class="form-group" style="padding:14px;">
                            <textarea class="form-control" placeholder="Update your status"></textarea>
                        </div>
                        <button class="btn btn-primary pull-right" type="button">답변하기</button>
                        <div class="clearfix"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/scripts.js"></script>
</body>
</html>