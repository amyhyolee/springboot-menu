$(document).ready(function () {
    $("#saveBtn").click(function () {
        let menu = $("#menu").val();

        if (menu.trim() == "") {
            alert("메뉴를 입력하세요");
            return;
        }

        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            menu: menu,
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/savemenu',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('메뉴가 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }); // saveBtn



    $("#updateBtn").click(function () {
        let menu = $("#m_menu").val();

        if (menu.trim() == "") {
            alert("메뉴를 입력하세요");
            return;
        }

        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            menu: menu,
        };

        // 업데이트를 하기위한 키값
        let id = $("#m_id").val();
        // alert(id + ". " + menu + " 수정이 됩니다.");

        $.ajax({
            type: 'PUT', // update 이니 PUT 으로
            url: '/api/v1/menu/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('메뉴가 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }); // updateBtn

    $("#deleteBtn").click(function () {
        let id = $("#m_id").val();
 
        $.ajax({
            type : 'DELETE',
            url : '/api/v1/menu/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
        }).done(function () {
            alert('메뉴가 삭제되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // deleteBtn

    $("#rndBtn").click(function() {
        var html = "";
        $.getJSON("/api/v1/rndmenu", function(result){
            console.log(result.menu);
            html = result.menu +" </b> 입니다!!!";
            $("#text-r").html(html);
        });
    });  // rndBtn
});
function modal_show(id, menu) {
    console.log(id);
    console.log(menu);

    // 클릭한 위치의 테이블의 데이터를 모달에 값을 셋팅
    $("#m_id").val(id);
    $("#m_menu").val(menu);

    $("#myModal").modal();
}