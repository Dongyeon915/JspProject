<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시물 삭제/수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">게시물</div>
		</div>
		<!-- /.panel-heading -->
		<div class="panel-body">
			<form role="form" action="/board/modify" method="post">
				
				  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
                    <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
					 <input type="hidden" name="type" value="<c:out value='${cri.type}'/>" >
   					 <input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>" >
				
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name="bno"
						value='<c:out value="${board.bno}" />' readonly="readonly">
				</div>


				<div class="form-group">
					<label>Title</label> <input class="form-control" name="title"
						value='<c:out value="${board.title}" />'>
				</div>

				<div class="form-group">
					<label>Text area</label>
					<textarea rows="3" class="form-control" name="content"><c:out
							value="${board.content}" /></textarea>
				</div>

				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
						value='<c:out value="${board.writer}" />' readonly="readonly">
				</div>

				<div class="form-group" style="display: none">
					<label>RegDate</label> <input class="form-control" name="regDate"
						value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}" />'
						readonly="readonly">
				</div>

				<div class="form-group" style="display: none">
					<label>Update Date</label> <input class="form-control"
						name="updateDate"
						value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}" />'
						readonly="readonly">
				</div>

				<button type="submit" data-oper="modify" class="btn btn-default">수정</button>
				<button type="submit" data-oper="remove" class="btn btn-danger">삭제</button>
				<button type="submit" data-oper="list" class="btn btn-info">게시판</button>

			</form>
		</div>

		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>

<script type="text/javascript">

$(document).ready(function(){
	   var formObj = $("form");
	    $('button').on("click", function(e) {
	        e.preventDefault();
	        var operation = $(this).data("oper");
	    
	        console.log(operation);
	    
	        if(operation === 'remove') {
	            formObj.attr("action", "/board/remove");
	        } else if(operation === 'list') {
	            //move to list
	            formObj.attr("action", "/board/list").attr("method","get");
	            var pageNumTag = $("input[name='pageNum']").clone();
	            var amountTag = $("input[name='amount']").clone();
	            var keywordTag = $("input[name='keyword']").clone();
	            var typeTag = $("input[name='type']").clone();
	            formObj.empty();
	            formObj.append(pageNumTag);
	            formObj.append(amountTag);
	            formObj.append(keywordTag);
	            formObj.append(typeTag);
	        }
	        formObj.submit();
	    });
	    });
	
</script>

<%@include file="../includes/footer.jsp"%>
