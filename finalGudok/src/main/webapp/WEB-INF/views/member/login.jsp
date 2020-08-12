<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

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

<title>로그인</title>
<style>
/*폰트 적용*/
body {
	font-family: 'Jua', sans-serif;
}

.card {
	/* box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23); */
	text-align: center;
	border: none;
}

#find {
	margin-top: 30px;
}

#find>a {
	color: #495057;
}

#find>a:hover {
	color: black;
	cursor: pointer;
}

#loginBtn, #signInBtn {
	color: #495057;
	border: 1px solid lightgray;
}

#loginBtn:hover, #signInBtn:hover {
	color: black;
	cursor: pointer;
}

#find > a, #find > div{
	display:inline-block;
}

.vl {
  border-left: 3px solid #495057;
  height: 15px;
  margin-right:20px;
  margin-left:20px;
}

.container pt-3{
	margin-top:30px;
}
</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="../common/menubar.jsp" />
	
	<div class="container pt-3">
		<div class="row justify-content-sm-center">
			<div class="col-sm-6 col-md-4">

				<div class="card">
					<div class="card-body">
						<h2>로그인</h2>
						<br>
						<form class="form-signin">
							<input type="text" class="form-control mb-3" placeholder="ID"
								required autofocus> <input type="password"
								class="form-control mb-3" placeholder="Password" required>
							<br>
							<button class="btn btn-md btn-block mb-3" type="submit"
								id="loginBtn">로그인</button>
							<!-- <label class="checkbox float-left">
              <input type="checkbox" value="remember-me">
                아이디 저장하기
              </label> -->
						</form>
						<div id="find">
							<a href="find.do">계정찾기</a>
							<div class="vl"></div>
							<a href="signUp.do">회원가입</a>
						</div>
					</div>
				</div>
			</div>
		</div>
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