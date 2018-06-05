<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/nav.jspf" %>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1>Clean Blog</h1>
                        <hr class="small">
                        <span class="subheading">A Clean Blog Theme by Start Bootstrap</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            
			<c:forEach var="post" items="${postPage.content}">
				<div class="post-preview">
                    <a href="/post/${post.id}">
                        <h2 class="post-title">
                            <c:out value="${post.title}" escapeXml="true"></c:out>
                        </h2>
                        <h3 class="post-subtitle">
                            <c:out value="${post.subtitle}" escapeXml="true"></c:out>
                        </h3>
                    </a>
                    <p class="post-meta">Posted by <a href="#">${post.name}</a> in <a href="/post/list?category=${post.category.id}"><c:out value="${post.category.name}" escapeXml="true" /></a> on ${post.regDate}</p>
                </div>
                <hr>
			</c:forEach>
			
                <!-- Pager -->
                 <ul class="pager">
                	<c:if test="${!postPage.first}">
                    <li class="previous">
                        <a href="?<c:if test="${categoryId > 0}">category=${categoryId}&</c:if>page=${postPage.number-1}">&larr; Newer Posts</a>
                    </li>
                    </c:if>
                    <c:if test="${!postPage.last}">
                    <li class="next">
                        <a href="?<c:if test="${categoryId > 0}">category=${categoryId}&</c:if>page=${postPage.number+1}">Older Posts &rarr;</a>
                    </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>


    <hr>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

	
</body>
</html>