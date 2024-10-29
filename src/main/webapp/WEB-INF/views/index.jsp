<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    var posts = request.getAttribute("posts");
%>
<html>
    <head>
        <title>HOME</title>
    </head>
    <body>
    <%@include file="layout/header.jsp"%>
    <h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>
    <div>
        <div>
            <div>
                <a href="/posts/save" role="button">글등록</a>
                <br/>
                <!-- 목록 출력 영역 시작 -->
                <table>
                    <thead>
                        <tr>
                            <th>게시글 번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>최종수정일</th>
                        </tr>T
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${posts}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.title}</td>
                            <td>${item.author}</td>
                            <td>${item.modified_date}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%@include file="layout/footer.jsp"%>
    </body>
</html>