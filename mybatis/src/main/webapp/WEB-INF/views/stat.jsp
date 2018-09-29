<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일입출력</title>
    <style>
        th,td{border:1px solid #ccc}
    </style>
</head>
<body>

<h2>파일 입출력 볼까</h2>
 
<div class="container">
    <a href="stat.xls">엑셀다운, 확장자(stat.xls)</a>
    <table>
        <thead>
        <tr>
            <th>이름</th>
            <th>값1</th>
            <th>값2</th>
        </tr>
        </thead>
        <tobdy>
                <c:forEach var="row" items="${rows}">
                    <tr>
                        <td>${row.name}</td>
                        <td><fmt:formatNumber value="${row.value1}" pattern="#,###" /></td>
                        <td><fmt:formatNumber value="${row.value2}" pattern="#,###" /></td>
                    </tr>
                </c:forEach>
        </tobdy>
    </table>
    <%--<a href="stat?format=xls">엑셀다운, 파라미터(stat?format=xls)</a>--%>
</div>
</body>
</html>
</layoutTag:layout>