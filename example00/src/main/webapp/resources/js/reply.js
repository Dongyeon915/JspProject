console.log("자바 스크립트의 즉시 실행함수 () 안에 함수선언");


var replyService = (function(){
	function add(reply, callback){
		console.log("reply....................");
		
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json : charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	}
	return {add:add};
})();