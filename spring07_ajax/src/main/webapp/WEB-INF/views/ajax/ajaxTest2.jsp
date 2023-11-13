<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajaxTest1.jsp</title>
	<script src="../js/jquery-3.7.1.min.js"></script>
	<script src="../js/jquery.cookie.js"></script>
</head>
<body>
	
	<h3>* $.ajax() 테스트 *</h3>
	
	<button id="btn">* 서버에서 응답받기 *</button>
	<div id="pane1"></div>
	
	<script>
		//1)$.ajax()함수
		//형식) $.ajax({name:value, name:value, name:value, ~~~ })
		/*
		$("#btn").click(function() {
			$.ajax({
				url 	: "message.do" //요청명령어
			   ,type    : "get"		   //get방식
			   ,dataType: "text"	   //응답메세지 타입
			   ,error	: function(error){
				   alert("에러:" + error);
			   } //error callback함수
			   ,success : function(result){//result는 서버가 응답해준 메세지
				  //alert("성공:" + result);
			   	
			   	  //$("#pane1").append(result);
			   	
				  //$("#pane1").empty();
				  //$("#pane1").text(result); //단순 문자열로 출력
				  //$("#pane1").html(result);   //HTML 구조로 출력
			   	  
			   	  
			   	  
			   } //success callback함수				
			});//ajax() end	
		});//click end
		*/
	
		//2)$.get()방식
		// AJAX를 GET방식으로 요청하는 함수
		// 형식) $.get("요청명령어", callback함수)
		$("#btn").click(function() {
			$.get("message2.do", responseProc);
		})//click end
		
		function responseProc(result) {//callback함수
			$("#pane1").append(result);
		}//responseProc() end
		
	</script>
</body>
</html>