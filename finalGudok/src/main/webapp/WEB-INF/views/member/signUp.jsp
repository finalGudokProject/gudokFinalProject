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

table {
	margin: auto;
}

/* #btnTd {
	text-align: center;
} */
td {
	padding: 10px;
}

::placeholder {
	font-size: small;
}

.btn {
	border: 1px solid #ced4da;
	color: #495057;
}

.btn:hover {
	border-color: black;
	color: black;
}

#submitBtn {
	margin-right: 10px;
}

#titleTag {
	margin-left: -30px;
	margin-top: 50px;
}

#signUpDiv {
	margin-bottom: 50px;
}
</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<section>
		<h2 align="center" id="titleTag" style="color: black;">회원가입</h2>
		<br>

		<div id="signUpDiv">
			<form action="signUp.do" method="post" id="signUpForm" >
				<table align="center" width="500" id="signUpTb">
					<tr>
						<td>*아이디</td>
						<td><input type="text" name="memberId" id="userId"
							placeholder="사용할 아이디를 입력하세요." required autofocus> 
							<!-- <span class="guide ok">사용 가능한 아이디입니다.</span> 
							<span class="guide error">사용 불가능한 아이디입니다.</span> 
							<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value="0"></td> -->
					</tr>
					<tr>
						<td>*비밀번호</td>
						<td><input type="password" name="memberPwd" id="pwd"
							placeholder="사용할 비밀번호를 입력하세요." required></td>
						<td></td>
					</tr>
					<tr>
						<td>*비밀번호 확인</td>
						<td><input type="password" placeholder="비밀번호를 한번 더 입력하세요."
							required></td>
						<td></td>
					</tr>
					<tr>
						<td>*이름</td>
						<td><input type="text" id="name" name="memberName"
							placeholder="이름을 입력하세요." required></td>
						<td></td>
					</tr>
					<tr>
						<td>*이메일</td>
						<td colspan="2"><input type="email" class="input-area"
							id="email" placeholder="email@email.com" name="email" required>&nbsp;
							<input type="hidden" id="clickVerify" value="0">
							<button class="btn" type="button" id="verifyEmail">인증하기</button></td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td colspan="2"><input type="text" name="address1"
							class="postcodify_postcode5" value="">&nbsp;
							<button class="btn" type="button" id="postcodify_search_button">검색하기</button>
						</td>
					</tr>
					<tr>
						<td>도로명 주소</td>
						<td><input type="text" name="address2"
							class="postcodify_address" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type="text" name="address3"
							class="postcodify_extra_info" value=""></td>
						<td></td>
					</tr>
					<!-- Postcodify를 로딩하자 -->

					<script>
						$(function() {
							$("#postcodify_search_button").postcodifyPopUp();
						})
					</script>
					<tr>
						<td>성별</td>
						<td><input type="radio" class="gender" name="gender"
							id="male" value="M" checked><label for="male">&nbsp;남자</label>
							&nbsp; <input type="radio" class="gender" name="gender"
							id="female" value="F"><label for="female">&nbsp;여자</label>
							&nbsp; <input type="radio" class="gender" name="gender" id="none"
							value="N"><label for="none">&nbsp;선택안함</label></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2" id="btnTd">
							<button type="button" class="btn" id="submitBtn"
								onclick="validate();">가입하기</button>
							<button type="reset" class="btn">취소하기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>

	</section>
	<!-- Footer -->
	<footer>
		<jsp:include page="../common/footer.jsp" />
	</footer>

	<script>
		/* $("#submitBtn").on("click",function(){
			
			if($(#)) {
				alert("이메일 인증");
			}
		} */

		/* $(function() {
			$("#userId").on("keyup",function() {
						var userId = $(this).val().trim();

						if (userId.length < 4) {
							$(".guide").hide();
							$("#idDuplicateCheck").val(0);

							return;
						}

						$.ajax({
							url : "duplicateId.do",
							data : {memberId : userId},
							success : function(data) {
								if (data.isUsable == true) {
									$(".error").hide();
									$(".ok").show();
									$("#idDuplicateCheck").val(1);
								} else {
									$(".error").show();
									$(".ok").hide();
									$("#idduplicate").val(0);
								}
							},
							error : function(request, status, errorData) {
								alert("error code: " + request.status + "\n"
										+ "message: " + request.responseText
										+ "error: " + errorData);
							}
						})
					})
		}) */

		function validate() {
			if($("#idDuplicateCheck").val == 0) {
				alert("사용 가능한 아이디를 입력해 주세요.");
				$("userId").focus();
			} else{
				$("#signUpForm").submit();
		}}
	</script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script> -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
</body>
</html>