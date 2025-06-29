<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#loginDiv{border: 1px solid black; margin: auto; margin-top: 150px; padding: 150px; width: 500px;}
	#loginDiv>label:hover{font-weight: bold; text-decoration: underline; cursor: pointer;}
	input{height: 30px;}
</style>
</head>
<body>
	<jsp:include page="../common/top.jsp"/>
	<form action="${ contextPath }/login.me" method="post" id="loginForm">
		<div align="center" id="loginDiv">
			<table>
				<tr>
					<td align="right"><label for="id">사원번호</label></td>
					<td><input type="text" name="id" id="id" size="25" autofocus></td>
				</tr>
				<tr>
					<td align="right"><label for="pwd">비밀번호</label></td>
					<td><input type="password" name="pwd" id="pwd" size="25"></td>
				</tr>
			</table>
			<br>
			<label onclick="doLoginLabel();">로그인</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<label id="findIdPwdLabel">ID/PW 찾기</label>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</form>
	<script>
	
		// 아이디와 비밀번호를 모두 입력해야 로그인이 작동되는 코드
		const doLoginLabel = () => {
			const id = document.getElementById('id');
			const pwd = document.getElementById('pwd');
			if(id.value.trim() == ''){
				alert('사원번호를 입력하세요');
			} else if(pwd.value.trim() == ''){
				alert('비밀번호를 입력하세요');
				pwd.focus();
			} else {
				document.getElementById('loginForm').submit();
			}
		}
		
		// 버튼없이 엔터키만 쳐도 로그인이 되게 만드는 코드
		// 함수로 실행이 아니기 때문에 window.onload 사용
		window.onload = () => {
			const inputIdPw = document.getElementsByTagName('input');
			for(let i = 0; i < inputIdPw.length; i++){
				inputIdPw[i].addEventListener('keyup', e => { // addEventListender 표준 이벤트 모델
					if(e.key == 'Enter'){
						doLoginLabel();
					}
				});
			}
		}
	</script>
</body>
</html>