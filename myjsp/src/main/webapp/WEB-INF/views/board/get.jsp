<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>





<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Read Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Read Register</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<!-- form의 기본 버튼은 전부 submit -->
					<div>
						<label>Bno</label>
						<input class="form-control" name="bno" readonly="readonly"
							value='<c:out value="${board.bno}"></c:out>'
						>
					</div>
					
					
					<div class="form-group">
						<label>Title</label> 
						<input class="form-control" placeholder="Enter text" name="title" readonly="readonly"
						value='<c:out value="${board.title}"></c:out>'>
					</div>				
			
					
					<div class="form-group">
						<label>Writer</label> 
						<input class="form-control" placeholder="Enter text" name="writer"
							value='<c:out value="${board.writer}"></c:out>'						
						>
					</div>
					
					<button data-oper='modify' class="btn btn-default">수정</button>
                    <button data-oper='list' class="btn btn-info">목록</button>
                    
                    
                    <form id='operForm' action="/board/modify" method="get">
						<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
                    </form>


				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<script type="text/javascript">
		$(document).ready(function () {
			// 담아서 변수처럼 사용
			var operForm = $("#operForm");
			// find()는 배열로 사용해줘야하므로
			$("button[data-oper='modify']").on("click", function (e) {
				operForm.attr("action","/board/modify").submit();
			});
			
			$("button[data-oper='list']").on("click", function (e) {
				operForm.find("#bno").remove();
				operForm.attr("action","/board/list")
				operForm.submit();
			});
		});
	</script>

	<%@include file="../includes/footer.jsp"%>