<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>





<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Borad Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Borad Register</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<!-- form의 기본 버튼은 전부 submit -->
				<form action="/board/register" method="post">
					<div class="form-group">
						<label>Title</label> 
						<input class="form-control" placeholder="Enter text" name="title">
					</div>
					
					<div class="form-group">
						<label>Content</label> 
						<textarea rows="5" cols="5" name="content" class="form-control"></textarea>
					</div>
					
					<div class="form-group">
						<label>Writer</label> 
						<input class="form-control" placeholder="Enter text" name="writer">
					</div>
					
					<button type="submit" class="btn btn-default">Submit Button</button>
                    <button type="reset" class="btn btn-default">Reset Button</button>
				</form>


				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

	<%@include file="../includes/footer.jsp"%>