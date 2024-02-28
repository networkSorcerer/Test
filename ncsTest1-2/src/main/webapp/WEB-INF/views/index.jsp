<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>아이디 중복 체크 테스트</title>
		
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
	</head>
<body>
		<h3>아이디 중복 체크 확인</h3>
		<label>ID : </label> <input type="text" name="memberId">
		<h3 id="checkId"></h3>
		
		<script src="/resources/js/jquery-3.7.1.min.js"></script>
		<script>
			$("input[name=memberId]").on("input", function(){
				console.log($("input[name=memberId]").val());
				$.ajax({
					url : "/idDupCheck",
					data : {memberId: $("input[name=memberId]").val() },
					type : "post",
					success : function(result){
						console.log(result);
						if(result == "true"){
							$("#checkId").text("사용 가능한 아이디 입니다.");
						}else{
							$("#checkId").text("사용할 수 없는 아이디 입니다.");
						}
					},
					error : function(e){
						$("#checkId").text("ajax 통신 실패");
					}
				});
			});
</script>
</body>
</html>