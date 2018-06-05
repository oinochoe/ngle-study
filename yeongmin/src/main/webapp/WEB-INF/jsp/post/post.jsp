<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/nav.jspf" %>

   <!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header post-bg">
	    <div class="container">
	        <div class="row">
	            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
	                <div class="post-heading">
	                    <h1><c:out value="${post.title}" escapeXml="true"></c:out></h1>
	                    <h2 class="subheading"><c:out value="${post.subtitle}" escapeXml="true"></c:out></h2>
	                    <span class="meta">Posted by <a href="#">Yeongmin</a> on ${post.regDate}</span>
	                </div>
	            </div>
	        </div>
	    </div>
	</header>
	<!-- Post Content -->
	<article>
	    <div class="container">
	        <div class="row">
	            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
	                ${post.content}
	            </div>
	        </div>
	        
            
            <div class="pull-right">
	            <c:choose> 
				    <c:when test="${_USER!=null && _USER.providerUserId == post.userId}">
						<a href="/post/${post.id}/edit">
		            		<button type="button" class="btn btn-warning">Edit</button>
		            	</a>
				    </c:when>
				    <c:otherwise>					    
                     	<a href="/user/login/" onclick="alert('로그인 후 가능합니다.')">
		            		<button type="button" class="btn btn-warning">Edit</button>
		            	</a>
				    </c:otherwise>
				</c:choose>
				<c:choose> 
				    <c:when test="${_USER!=null && _USER.providerUserId == post.userId}">
						<a href="/post/${post.id}/delete" onclick="if(!confirm('진심이에요?')){return false;}">
		            		<button type="button" class="btn btn-danger">Delete</button>
		            	</a>
				    </c:when>
				    <c:otherwise>					    
                     	<a href="/user/login/" onclick="alert('로그인 후 가능합니다.')">
		            		<button type="button" class="btn btn-danger">Delete</button>
		            	</a>
				    </c:otherwise>
				</c:choose>
            	
            </div>
             
	    </div>
	</article>
    <hr>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</body>
</html>