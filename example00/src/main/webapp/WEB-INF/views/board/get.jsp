<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시물 조회</h1>
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
			<div class="form-group">
				<label>Bno</label> <input class="form-control" name="bno"
					readonly="readonly" value="<c:out value='${board.bno}'/>">
			</div>
			<div class="form-group">
				<label>Title</label> <input class="form-control" name="title"
					readonly="readonly" value="<c:out value='${board.title}'/>">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" rows="5" name="content"
					readonly="readonly"> <c:out value='${board.content}' /></textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input class="form-control" name="writer"
					readonly="readonly" value="<c:out value='${board.writer}'/>">
			</div>
			<!-- <button data-oper="modify" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'" class="btn btn-default">수정</button> -->
			<button data-oper="modify" class="btn btn-default">수정</button>
			<button data-oper="list" class="btn btn-default">목록</button>

			<form id="operForm" action="/board/modify" method="get">
				<input type="hidden" id="bno" name="bno"
					value="<c:out value='${board.bno }'/>"> <input
					type="hidden" name="pageNum"
					value="<c:out value='${cri.pageNum}'/>"> <input
					type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
				<input type="hidden" name="type"
					value="<c:out value='${cri.type}'/>"> <input type="hidden"
					name="keyword" value="<c:out value='${cri.keyword}'/>">
			</form>


		</div>

		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>

<div class = 'row'>
	<div class = "col-lg-12">
		
		<!-- /.panel -->
		<div class = "panel panel-default">
			<div class= "panel-heading">
				<i class = "fa fa-comments fa-fw"></i> 리플
			</div>
			
			
				<div class="col-lg-12">
		<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
					<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<ul class="chat">
						<!-- start reply -->
						<li class="left clearfix" data-rno='12'>
			
			
			<!-- /.panel-heading -->
			<div class = "panel-body">
				<ul class = "chat">
				
					<!-- start reply -->
					<li class = "left clearfix" data-rno = '12'>
						<div>
							<div class = "header">
								<strong class = "primary-font">user00</strong>
								<small class = "pull-right text-muted">2018-01-01 13:13</small>								
							</div>
							<p>Good job!</p>
						</div>
					</li>
					<!-- end reply -->
				</ul>
				<!-- ./ end ul -->
			</div>
			<!-- /.panel .chat-panel -->
		</div>
	</div>
	<!-- ./end row -->
</div>

<!-- Modal -->
	<div class = "modal fade" id = "MyModal" tabindex = "-1" role = "dialog"
		aria-labelledby = "myModalLabel" aria-hidden = "true">
		<div class = "modal-dialog">
			<div class = "modal-content">
				<div class = "modal-header">
					<button type = "button" class = "close" data-dismiss = "modal"
						ari-hidden = "true">&times;</button>
					<h4 class = "modal-title" id = "myModalLabel">REPLY MODAL</h4>
				</div>
				<div class = "modal-body">
					<div class = "form-group">
						<label>Reply</label>
						<input class = "form-control" name = 'reply' value = 'New Reply!!!!'>
					</div>
					<div class = "form-group">
						<label>Replyer</label>
						<input class = "form-control" name = 'replyer' value = 'replyer'>
					</div>
					<div class = "form-group">
						<label>Reply Date</label>
						<input class = "form-control" name = 'replyDate' value = ''>
					</div>
				</div>
<div class = "modal-footer">
	<button id = 'modalModBtn' type = "button" class = "btn btn-warning">Modify</button>
	<button id = 'modalRemoveBtn' type = "button" class = "btn btn-danger">Remove</button>
	<button id = 'modalRegisterBtn' type = "button" class = "btn btn-primary">Register</button>
	<button id = 'modalCloseBtn' type = "button" class = "btn btn-default">Close</button>
</div>
			</div>
		</div>
		</div>



</div>


<script type="text/javascript" src="/resources/js/reply.js"></script>


<script>
	// 자바스크립트 타입의 객체를 전달해줘야한다.
//	replyService.add({
//		reply : "테스트",
//		replyer : "테스터",
//		bno : bnoValue
//	},
	// 전송 결과를 처리하는 함수
//	function(result) {
//		alert("RESULT" + result)
//	});
$(document).ready(function(){
	
	
	
	var bnoValue = '<c:out value = "${board.bno}"/>';
	var replyUL = $(".chat");
	
	showList(1);
	function showList(page){
		replyService.getList({bno:bnoValue,page : page || 1}, function(list){
			var str = "";
			if(list == null || list.length == 0){
				replyUL.html("");
				
				return;
			}
			for(var i =0, len = list.length || 0; i<len; i++){
				str += "<li class  = 'left clearfix' data-rno = '"+list[i].rno+"'>";
				str += "	<div><div class = 'header'><strong class = 'primary-font'>"+list[i].replyer+"</strong>";
				str += "		<small class = 'pull-right text-muted'>"+list[i].replyDate+"</small></div>";
				str += "			<p>"+list[i].reply+"</p></div></li>";
			}
			replyUL.html(str);
		}); // end function
	} // end showList
	
	var modal = $(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");

	var modalModBtn = $("#modalModBtn");
	var modalRemoveBtn = $("#modalRemoveBtn");
	var modalRegisterBtn = $("#modalRegisterBtn");
	
	// chat클래스 ul태그를 클릭시 실제 동작은 li가 되도록 설정
	$(".chat").on("click", "li", function (e) {
	// 클릭시 해당 부분의 data관련 보여준다	var rno = $(this).data("rno");
	//	console.log(rno);
		var rno = $(this).data("rno");
		replyService.get(rno, function(reply) {
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly", "readonly");
			modal.data("rno", reply.rno);
			
			modal.find("button[id != 'modalCloseBtn']").hide();
			modalModBtn.show();
			modalRemoveBtn.show();
			
			$(".modal").modal("show");
		});

		modalModBtn.on("click", function(e) {
			var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};
			replyService.update(reply, function(result) {
				alert(result);
				modal.modal("hide");
				showList(1);
			});
		});
		
		modalRemoveBtn.on("click", function(e) {
			var rno = modal.data("rno");
			replyService.remove(rno, function(result) {
				alert(result);
				modal.modal("hide");
				showList(1);
			});
		});
		
		
	});
	

	$('#addReplyBtn').on("click", function(e) {
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id !='modalCloseBtn']").hide();
		modalRegisterBtn.show();

	    $(".modal").modal("show");
	});
	
	modalRegisterBtn.on("click", function(e){
		var reply = {
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val(),
				bno : bnoValue
		};
		
		replyService.add(reply, function(result){
			alert(result);
		
			modal.find("input").val("");
			modal.modal("hide");
			
			showList(1);
			
		});
	});
	
});

	replyService.getList({
		bno : bnoValue,
		page : 1
	}, function(list) {
		for (var i = 0, len = list.length || 0; i < len; i++) {
			console.log(list[i]);
		}
	});
	
	
	// 삭제
	replyService.remove(6, function (count) {
		console.log(count);
		if (count === "success") {
			alert("삭제")
		}
	},
		function (err) {
			alert("에러");
		}
	);
	
	// 수정
	reply,Service.update({rno : 22,bno : bnoValue, reply : "Modified Reply.."},
		function (result) {
			alert("수정 완료");
		}		
	)
	
	// 조회
	replyService.get(10, function (data) {
		console.log(data);
	})
</script>


<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "/board/modify").submit();
		});

		$("button[data-oper='list']").on("click", function() {
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list")
			operForm.submit();
		});
	});
</script>

<%@include file="../includes/footer.jsp"%>