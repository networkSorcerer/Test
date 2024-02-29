<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="/resources/include/js/jquery-3.7.1.min.js"></script>
		<script>
			$(function(){
				let errorMsg = "${errorMsg }";
				if(errorMsg !=""){
					alert(errorMsg);
					errorMsg="";
				}
				$("#loginBtn").on("click", function(){
				    $("#loginForm").attr({
				        method: "post",
				        action: "/login"
				    });
				    $("#loginForm").submit();
				});

			$("#logoutBtn").click(function(){
				location.href = "/logout"
			});
		});
		</script>
	</head>
	<body>
		<c:if test="${empty signUp }">
		<form id="loginForm">
			<label>ID : </label><input type="text" name="memberId"><br>
			<label>PWD : </label><input type="password" name="memberPwd"><br>
			<button type="button" id="loginBtn">로그인</button>
		</form>
		</c:if>
		
		<c:if test="${!empty signUp }">
			<h3>${signUp.memberName }님 환영합니다</h3>
			<button type="button" id="logoutBtn">로그아웃</button>
		</c:if>
	</body>
</html>