<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>searchTest.jsp</title>
	<script src="../js/jquery-3.7.1.min.js"></script>
	<script src="../js/jquery.cookie.js"></script>
</head>
<body>

	<h3>교재검색</h3>
	
	<form name="search" id="search">
	 <input type="text" name="keyword" id="keyword">
	 <input type="button" value="검색">
	</form>
	
	<!-- 검색 결과 출력 -->
	<div id="pane1" style="display:none"></div>

	<script>
	 $("#keyword").keyup(function () {
		//alert("test");
		if($("#keyword").val()==""){//검색어가 존재하지 않으면
			$("#pane1").hide();		//출력결과 숨기기
		}//if end
		
		//1)id="keyword" 값 가져오기
		//let params = $("#keyword").val();
		//alert(params);
		
		//2)<form id="search"></form>
		//	폼안의 모든 컨트롤 요소를 가져오기
		let params = $("#search").serialize();
		//alert(params); //keyword=java
		
		$.post("searchproc.do", params, responseProc);
		
	 });//keyup end
	 
	 function responseProc(data) {
		//alert(data);
	}//responseProc() end
	 
   </script>
   
   
</body>
</html>