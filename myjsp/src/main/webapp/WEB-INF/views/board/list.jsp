<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../includes/header.jsp"%>



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		<button id='regBtn' type="button" class="btn btn-xs pull-right">항목 추가하기</button>
			<div class="panel-heading">DataTables Advanced Tables</div>
			
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>수정일</td>
						</tr>
					</thead>
					
					<c:forEach items="${list}" var="board">
						<tr class="odd gradeX">
							<td><c:out value="${board.bno}"/></td>
							<td><c:out value="${board.title}"/></td>
							<td><c:out value="${board.writer}"/></td>
						</tr>
					</c:forEach>
					
		

				</table>
				<!-- /.table-responsive -->
	
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>


<script>
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';	
	});
</script>

<div id="myModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>





<script>
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		function checkModal(result) {
			if (result === '') {
				return;
			}
			if (parsInt(result) > 0) {
				$(".modal-body").html(
					"게시글이 등록되었습니다"		
				);
			}
			$("#myModal").modal("show");
		}
	})	
	
	// 등록 버튼 누를시 register로 이동
	$("#regBtn").click(function() {
		self.location = "/board/register";
	})
	
</script>



<%@include file="../includes/footer.jsp"%>