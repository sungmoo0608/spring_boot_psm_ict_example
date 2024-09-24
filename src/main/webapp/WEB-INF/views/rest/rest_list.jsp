<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest 게시판 리스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/eshopper/js/board.js"></script>

<script type="text/javascript">
	$(document).ready(function(){

		$.ajax({	/*웹브라우저라고 생각하면 편함*/	
			type : "GET",
			url: "/boards/list",
			success : function(result){
				console.log(result);
				
				let htmls="";
				
				$("#list-table").html('');
		        
				$("<tr>" , {
					html : "<td>" + "번호" + "</td>"+  // 컬럼명들
							"<td>" + "이름" + "</td>"+
							"<td>" + "제목" + "</td>"+
							"<td>" + "날짜" + "</td>"+
							"<td>" + "히트" + "</td>"+
							"<td>" + "삭제" + "</td>"
				}).appendTo("#list-table")	// 이것을 테이블에 붙임
				
				if(result.length <1) {
					htmls.push("등록된 댓글이 없습니다.");
				} else {
					$(result).each(function(){
						htmls += '<tr>';
							htmls += '<td>'+ this.bid + '</td>'; 
							htmls += '<td>'+ this.bname + '</td>';
							htmls += '<td>'
							for(let i=0; i < this.bindent; i++){
								htmls += '-'
							}
							htmls += '<a href="/rest_content_view.html?bid=' + this.bid + '">' + this.btitle + '</a></td>';
							htmls += '<td>'+ this.bdate + '</td>'; 
							htmls += '<td>'+ this.bhit + '</td>';
							htmls += '<td>'+ '<input id=' + this.bid + " type='button' class='btn_delete' value='삭제'>" + '</td>';
						htmls += '</tr>';
					});	//each end
					
					htmls += '<tr>';
					htmls += '<td colspan="5"> <a href="/write_view">글작성</a> </td>';        
					htmls += '</tr>';
				}
				
				$('#list-table').append(htmls);
				
			},
			error : function(e){
				console.log(e);
			}
		});	
		
	});
</script>

<script type="text/javascript">
	$(document).ready(function(){

		$(document).on("click","#list-table .btn_delete", function(){
			console.log($(this).attr("id"))
			
			$(this).parent().parent().remove();
			
			let board = boardService();
			board.del($(this).attr("id"));
			
		});
	});
</script>
 
</head>
<body>
	<h1>Rest 게시판 리스트</h1>
	<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
	</table>
</body>
</html>