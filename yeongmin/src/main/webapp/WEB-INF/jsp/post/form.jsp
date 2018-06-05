<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

</head>
<body>
	<%@ include file="/WEB-INF/jspf/nav.jspf" %>
	
	 <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header norm">
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
    <div class="container" style="margin-bottom:30px;">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            
            
				<div id="toolbar">
					<!-- span id="back" class="icon-back" onclick="history.back();">돌아가기</span><br> 
					<span id="hinted" class="icon-pre disabled" title="Toggle Markdown Hints"></span>-->
					
					<form action="/category/add" method="post" id="add_category" >
						<input type="text" name="categoryName" class="form-control" placeholder="새로운 카테고리">
						<input type="hidden" name="_csrf" value="${_csrf.token}">
						<button type="submit" class="form-control">추가</button>
					</form>
				</div>
			
				<div id="custom-toolbar" class="pen-menu pen-menu" >
				  <i class="pen-icon icon-insertimage" data-action="insertimage"></i>
				  <i class="pen-icon icon-blockquote" data-action="blockquote"></i>
				  <i class="pen-icon icon-h1" data-action="h1"></i>
				  <i class="pen-icon icon-h2" data-action="h2"></i>
				  <i class="pen-icon icon-h3" data-action="h3"></i>
				  <i class="pen-icon icon-p active" data-action="p"></i>
				  <i class="pen-icon icon-code" data-action="code"></i>
				  <i class="pen-icon icon-insertorderedlist" data-action="insertorderedlist"></i>
				  <i class="pen-icon icon-insertunorderedlist" data-action="insertunorderedlist"></i>
				  <i class="pen-icon icon-inserthorizontalrule" data-action="inserthorizontalrule"></i>
				  <i class="pen-icon icon-indent" data-action="indent"></i>
				  <i class="pen-icon icon-outdent" data-action="outdent"></i>
				  <i class="pen-icon icon-bold" data-action="bold"></i>
				  <i class="pen-icon icon-italic" data-action="italic"></i>
				  <i class="pen-icon icon-underline" data-action="underline"></i>
				  <i class="pen-icon icon-createlink" data-action="createlink"></i>
				</div>
			
				<c:if test="${post.id == 0}"><c:url var="actionUrl" value="/post/write"/></c:if>
				<c:if test="${post.id != 0}"><c:url var="actionUrl" value="/post/${post.id}/edit"/></c:if>
			
				<form:form action="${actionUrl}" commandName="post" onsubmit="formCheck();" method="post">
			
					<form:input type="hidden" path="_csrf" value="${_csrf.token}"></form:input>
			
					<form:errors path="*" cssClass="errorblock" element="div" />
			
					<form:input type="text" path="title" placeholder="Title"/>
					<form:errors path="title" cssClass="error" />
			
					<form:input type="text" path="subtitle" placeholder="Subtitle (option)" />
			
					<hr>
			
					<div data-toggle="pen" data-placeholder="Content" id="pen"></div>
					<form:input type="hidden" path="content" id="content" />
					<form:errors path="content" cssClass="error" />
			
					<div class="form-group" >
						<label for="category" class="col-sm-2 control-label">Category</label>
						<div class="col-sm-10">
							<form:select path="categoryId" items="${categoryMap}" id="category" class="form-control"/>
							<form:errors path="categoryId" cssClass="error" />
						</div>
					</div>
					
					<hr>
			
					<button type="submit" class="btn btn-primary btn-lg btn-block">저장</button>
			
				</form:form>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	

	<script src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
	<script src="/webjars/bootstrap/3.3.5/dist/js/bootstrap.min.js"></script>
	<script src="/webjars/pen/0.1.0/src/pen.js"></script>
	<script src="/webjars/pen/0.1.0/src/markdown.js"></script>
	<script type="text/javascript">
	
		function formCheck(){

			if($('#pen').html()!='<p><br></p>'){
				$('#content').val($('#pen').html());
			}else{ 
				pen.destroy();
			}
			
		}
		
		$(document).ready(function(){
			$('#pen').html($('#content').val());
		});
		
		$('#add_category').submit(function(event) {
			var form = $(this);
			$.ajax({
				type : form.attr('method'),
				url : form.attr('action'),
				data : form.serialize()
			}).done(function(c) {				
				$("#category").append("<option value=" + c.id + ">" + c.name + "</option>");
				$("#category").val(c.id);
				
				alert(c.name + " 카테고리가 추가되었습니다.");
			}).fail(function() {
				alert('error');
			});
			event.preventDefault();
		});

		// config
		var options = {
			toolbar : document.getElementById('custom-toolbar'),
			editor : document.querySelector('[data-toggle="pen"]')
		};

		$('#pen').html($('#content').val());

		// create editor
		var pen = window.pen = new Pen(options);

		pen.focus();

		document.querySelector('#hinted').addEventListener('click', function() {
			var pen = document.querySelector('.pen')

			if (pen.classList.contains('hinted')) {
				pen.classList.remove('hinted');
				this.classList.add('disabled');
			} else {
				pen.classList.add('hinted');
				this.classList.remove('disabled');
			}
		});
		
		// 바디의 마진을 가지고 와서. 툴바의 좌측으로.
	</script>
</body>
</html>