$(document).ready(function () {

$.getJSON("/api/v1/melon", function(result){
    var html = "";
    var link = "https://www.youtube.com/results?search_query=";
    $.each(result, function(i, field){
        // 반복문
        html += "<tr>";
        html += "<td>" + field.rank + "</td>";
        html += "<td> <a href='#' onclick=\"openPop('" + link + field.title + "')\">"
        html += field.title + "</a> </td>";
        html += "<td>" + field.artist + "</td>";
        html += "</tr>";
    });
    $("#musiclist").append(html);

  });
});

function openPop(url) {
  var popup = window.open(url, '멜론에서 유튜브로', 'width=700px, height=800px, scrollbars = yes')
}

