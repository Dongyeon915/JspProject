<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>





<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">수정페이지</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">수정/삭제</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form>
					<!-- form의 기본 버튼은 전부 submit -->
					<div>
						<label>Bno</label> <input class="form-control" name="bno"
							readonly="readonly" value='<c:out value="${board.bno}"></c:out>'>
					</div>


					<div class="form-group">
						<label>Title</label> <input class="form-control"
							placeholder="Enter text" name="title" readonly="readonly"
							value='<c:out value="${board.title}"></c:out>'>
					</div>


					<div class="form-group">
						<label>Writer</label> <input class="form-control"
							placeholder="Enter text" name="writer"
							value='<c:out value="${board.writer}"></c:out>'>
					</div>
					<!-- data-oper='modify' 나만의 속성 -->
					<button class="btn btn-default" data-oper='modify'>수정</button>
					<button class="btn btn-danger" data-oper='remove'>삭제</button>
					<button class="btn btn-info" data-oper='list'>메인</button>
				</form>

				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

	<script type="text/javascript">
		$(document).ready(function(){
			// 태그 잡기
	var formObj = $("form");
	
	$('button').on("click", function(e){
		// 모든 form태그의 버튼은 submit이므로 기본동작을 막는 설정
		e.preventDefault();
		// 클릭시 해당버튼의 oper값을 출력해준다
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'remove'){
			// 잡은 form태그의 attr속성중 action을 잡아서 변경
			formObj.attr("action","/board/remove");
		}else if(operation === 'list'){
			//// 현재 창을 해당 창으로
			formObj.attr("action","/board/list").attr("method","get");
			formObj.empty();
			// self.location= "/board/list";
			return;
		}
		formObj.submit();
	});
});
		
		
	</script>


	<%@include file="../includes/footer.jsp"%>