<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>

    
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시물 등록하기</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">등록란</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<!-- form의 기본 버튼은 전부 submit -->
				<form action="/board/register" method="post">
					<div class="form-group">
						<label>제목</label> 
						<input class="form-control" placeholder="Enter text" name="title">
					</div>
					
					<div class="form-group">
						<label>내용</label> 
						<textarea rows="5" cols="5" name="content" class="form-control"></textarea>
					</div>
					
					<div class="form-group">
						<label>작성자</label> 
						<input class="form-control" placeholder="Enter text" name="writer">
					</div>
					
					<button type="submit" class="btn btn-default">작성 버튼</button>
                    <button type="reset" class="btn btn-default">초기화 버튼</button>
				</form>


				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

	<%@include file="../includes/footer.jsp"%>