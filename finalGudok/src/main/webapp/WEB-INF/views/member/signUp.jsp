<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<title>회원가입</title>
<style>
/*폰트 적용*/
body {
	font-family: 'Jua', sans-serif;
}

.card {
	border: none;
}

table{
	margin:auto;
}

#btnTd {
	text-align: center;
}

td{
  padding:10px;
}

::placeholder{
  font-size:small;
}

button {
	color: #495057;
	background-color: none;
	border: 1px solid #ced4da;
}

button:hover {
	color: black;
}

</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />

		<br> <br>
		<h2 align="center">회원가입</h2>
		<br>
		
		<div>
			<form action="" method="post" id="signUpForm">
				<table align="center" cellspacing="5" id="signUpTb">
					<tr>
						<td>*아이디</td>
						<td><input type="text" id="id" placeholder="사용할 아이디를 입력하세요"
							required></td>
						<td></td>
					</tr>
					<tr>
						<td>*비밀번호</td>
						<td><input type="password" id="pwd1"
							placeholder="사용할 비밀번호를 입력하세요" required></td>
						<td></td>
					</tr>
					<tr>
						<td>*비밀번호 확인</td>
						<td><input type="password" id="pwd"
							placeholder="사용할 비밀번호를 입력하세요" required></td>
						<td></td>
					</tr>
					<tr>
						<td>*이름</td>
						<td><input type="text" id="name" placeholder="이름을 입력하세요"
							required></td>
						<td></td>
					</tr>
					<tr>
						<td>*이메일</td>
						<td colspan="2"><input type="email" class="input-area" id="email"
							placeholder="email@email.com" required="">&nbsp;<td>
							<button type="button" id="verifyEmail" required>인증하기</button>
						</td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td colspan="2"><input type="text" name="post"
							class="postcodify_postcode5" value="">&nbsp;
							<button type="button" id="postcodify_search_button">검색하기</button>
						</td>
					</tr>
					<tr>
						<td>도로명 주소</td>
						<td><input type="text" name="address1"
							class="postcodify_address" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type="text" name="address2"
							class="postcodify_details" value=""></td>
						<td></td>
					</tr>
					<!-- Postcodify를 로딩하자 -->
					<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
					<script>
						$(function() {
							$("#postcodify_search_button").postcodifyPopUp();
						});
					</script>
					<tr>
						<td>성별</td>
						<td><input type="radio" class="gender" name="gender"
							value="남자" checked>&nbsp;남자 &nbsp; <input type="radio"
							class="gender" name="gender" value="여자">&nbsp;여자 &nbsp; <input
							type="radio" class="gender" name="gender" value="선택안함">&nbsp;선택안함
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="3" id="btnTd">
							<button type="submit">가입하기</button>&nbsp;&nbsp;
							<button type="reset">취소하기</button>
						</td>
					</tr>

				</table>
			</form>
		</div>
	
	<!-- Footer -->
	<footer>
		<jsp:include page="../common/footer.jsp" />
	</footer>
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>