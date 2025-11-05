<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<%@ include file="/include/header.jspf" %>
<body>
<%@ include file="/include/navigation.jspf" %>

<div class="container" id="main">

    <%--    <main class="form-signin">--%>

    <%--        <form name="sign-up" method="post" action="/user/signup">--%>
    <%--            <div class="form-floating">--%>
    <%--                <input type="text" class="form-control" id="userId" name="userId" placeholder="Id">--%>
    <%--                <label for="userId">User Id</label>--%>
    <%--            </div>--%>
    <%--            <div class="form-floating">--%>
    <%--                <input type="password" class="form-control" id="password" name="password" placeholder="Password">--%>
    <%--                <label for="password">Password</label>--%>
    <%--            </div>--%>
    <%--            <div class="form-floating">--%>
    <%--                <input type="text" class="form-control" id="name" name="name" placeholder="name">--%>
    <%--                <label for="name">Name</label>--%>
    <%--            </div>--%>
    <%--            <div class="form-floating">--%>
    <%--                <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">--%>
    <%--                <label for="email">Email address</label>--%>
    <%--            </div>--%>
    <%--            <div style="height:10px;">--%>
    <%--            </div>--%>
    <%--            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>--%>
    <%--        </form>--%>
    <%--    </main>--%>
    <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
        <div class="panel panel-default content-main">
            <form name="question" method="post" action="<c:url value='/qna/create' />">
                <div class="form-group">
                    <label for="writer">글쓴이</label>
                    <input type="text" class="form-control" value="${sessionScope.user.userId}" id="writer"
                           name="writer" placeholder="글쓴이" readonly/>
                </div>
                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="제목"/>
                </div>
                <div class="form-group">
                    <label for="contents">내용</label>
                    <textarea name="contents" id="contents" rows="5" class="form-control"></textarea>
                </div>
                <button type="submit" class="btn btn-success clearfix pull-right">질문하기</button>
                <div class="clearfix"></div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/scripts.js"></script>
</body>
</html>