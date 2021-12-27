// html 불러오고 실행 
$(document).ready(function () {
    $("button").click(function () {
        var menu = {
            menu: $("#data").val()
        };
 
        $.ajax({
            type : 'POST',
            url : '/api/v1/savemenu',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(menu)
        }).done(function () {
            alert('메뉴가 저장되었습니다.');
            location.reload();
            // window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });
});