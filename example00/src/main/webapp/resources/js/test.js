/*
 함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미
 화면 내에서 Javascript 처리를 하다 보면 이벤트 처리와 DOM, Ajax 처리 등 복잡하게 섞여서 유지보수가 힘들다.
 따라서 javascript를 하나의 모듈처럼 구성하여 사용한다.


*/

console.log("Reply Module.....");
//일회성으로 사용되는 함수
let replyService = (function () {

    //callback, error는 외부에서 전달받을 함수이다.
    //함수의 파라미터 개수를 일치시킬 필요가 없기 때문에
    //사용시 callback이나 error와 같은 파라미터는 상황에 따라 작성한다.

    //댓글 등록
    function add(replyInfo, callback, error) {
        console.log("add reply................");
        $.ajax({
            url: "/replies/new",
            type: "post",
            data: JSON.stringify(replyInfo),// 전달할 JSON데이터에서 문자열 처리가 필요한 것들(key, dateType)을 자동으로 처리해준다.
            contentType: "application/json; charset=utf-8",
            // dataType: 생략가능 자동으로 됨
            success: function (result, status, xhr) {
                if (callback) {
                    //외부에서 전달받은 값이 있다면 결과를 해당 함수의 매개변수로 전달하여 사용한다.
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });
    }


    //댓글 삭제
    function remove(rno, callback, error) {
        console.log("remove reply........");
        $.ajax({
                url: "/replies/" + rno,
                type: "delete",
                data: rno,
                success: function (result) {
                    if (callback) {
                        callback(result);
                    }
                },
                error: function (xhr, status, err) {
                    if (error) {
                        error(err);
                    }
                }
            }
        );
    }

    //댓글 수정
    function modify(replyInfo, callback, error) {
        console.log("MODIFY reply........");
        $.ajax({
            url: "/replies/" + replyInfo.rno,
            type: "patch",
            data: JSON.stringify(replyInfo),
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }

        });
    }


    //댓글 목록
    function getList(params, callback, error) {
        console.log("list...........");
        // let date = x | y : x가 없으면 y
        let page = params.page || 1;
        // get방식으로 요청 후 JSON으로 응답
        // $.getJSON(url, callback).fail(callback)
        //리턴값을 json으로 바꿔줌
        $.getJSON(
            "/replies/pages/" + params.bno + "/" + page,
            function (list) {
                if (callback) {
                    callback(list);
                }
            }
        ).fail(function (xhr, status, err) {
            if (error) {
                error(err);
            }
        });
    }


    // 댓글 하나 조회
    function get(rno, callback, error) {
        $.get(
            "/replies/" + rno,
            function (replyInfo) {
                if (callback) {
                    callback(replyInfo);
                }
            }
        ).fail(function (xhr, status, err) {
            if (error) {
                error(err);
            }
        });
    }



    return {add: add, remove: remove, modify: modify, getList: getList}
//    외부에서는 replyService.add(객체, 콜백)형식으로 사용하며,
//    Ajax 호출이 감춰져 있기 떄문에 사용부의 코드가 더 깔끔해진다.
})();