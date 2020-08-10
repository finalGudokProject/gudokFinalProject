<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<!-- <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

Bootstrap CSS
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous"> -->

<title>Menubar</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
/*상단 회원가입, 로그인, 고객센터 메뉴(#menu-list) */
#menu-list {
	line-height: 3;
	text-align: right;
}

#menu-list > li {
	display: inline-block;
	margin-right: 50px;
}

#menu-list a {
	color: #495057;;
}

#menu-list a:hover{
	color:black;
	cursor:pointer;
	text-decoration:none;
}

/*나비바 각 카테고리(a태그) 간격조정*/
.nav-link {
	margin: 0 60px 0 60px;
	/* color: #495057; */
	color:red;
}

.nav-link:hover{
	color:black;
}

/*나비바 각 카테고리(글씨, 아이콘) 가운데 정렬*/
.nav-item {
	text-align: center;
	color: #495057;
}

.nav-item:hover {
	cursor: pointer;
}

/*나비바 각 카테고리 간격 설정*/
.navbar-nav {
	margin-left: 50px;
}

.nav-link{
	color:#495057 !important;
}

.nav-link:hover{
	color:black !important;
}

/*검색바 마진 설정*/
#searchBar {
	margin-left: 50px;
	margin-right: 50px;
}

#food-menu, #living-menu {
	background-color: #f8f9fa;
	margin-left: 10px;
	border: none;
}

.dropdown:hover>.dropdown-menu {
	text-align: center;
	display: block;
}

.dropdown-item{
	color:#495057;
}

.dropdown-item:hover{
	color:black;
}

.form-inline my-2 my-lg-0>input {
	margin-left: 50px;
}

.btn{
	border-color: #ced4da;
	color: #495057;
}

.btn:hover{
	border-color: black;
	color:black;
}

/* #searchBtn {
	border-color: #ced4da;
	color: #495057;
} */

/* #searchBtn:hover{
	border-color: black;
	color:black;
} */

::placeholder {
	font-size: small;
}

/*폰트 적용*/
body {
	font-family: 'Jua', sans-serif;
	color:#495057;
}

#cardWrap > a{
	color:#495057 !important;
}

a:hover{
	text-decoration:none;
	color:black;
}

</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>
<body>
	<c:set var="contextPath"
		value="${pageContext.servletContext.contextPath }" scope="application" />

	<div id="userMenu">
		<ul id="menu-list">
			<li><a href="signUp.do">회원가입</a></li>
			<li><a href="moveToLogin.do">로그인</a></li>
			<li><a href="#">고객센터</a></li>
			<li><a href="#">Who is JH?</a></li>
			<li><a href="payment.do">결제페이지</a>
		</ul>

	</div>
	<div class="container">
		<div class="row">
			<div class="col-12" align="center">
				<a href="home.do"><img src="resources/images/logo.png"
					width="220px" height="150px"></a>
			</div>
		</div>
	</div>
	<br>

	<nav class="navbar navbar-expand-sm navbar-light bg-light sticky-top">
		<!-- <a class="navbar-brand" href="#">Navbar</a> -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<!-- <ul class="navbar-nav mr-auto"> -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="#"><img
						src="resources/images/new.png" width="50px" height="50px"><br>신상품</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#"><img
						src="resources/images/best.png" width="50px" height="50px"><br>베스트</a>
				</li>
				<li class="nav-item dropdown"><a class="nav-link dropdown"
					href="#" id="navbarDropdown1" role="button" aria-haspopup="true"
					aria-expanded="false"> <img src="resources/images/food.png"
						width="50px" height="50px"><br>Food
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown1"
						id="food-menu">
						<a class="dropdown-item" href="#"><img
							src="resources/images/beverage.png" width="30px" height="30px">&nbsp;음료</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><img
							src="resources/images/milk.png" width="30px" height="30px">&nbsp;유제품</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><img
							src="resources/images/bakery.png" width="30px" height="30px">&nbsp;베이커리</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><img
							src="resources/images/canned_food.png" width="30px" height="30px">&nbsp;간편식품</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><img
							src="resources/images/supplement.png" width="30px" height="30px">&nbsp;건강식품</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><img
							src="resources/images/diet_food.png" width="30px" height="30px">&nbsp;다이어트
							식단</a>
					</div></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown"
					href="#" id="navbarDropdown2" role="button" aria-haspopup="true"
					aria-expanded="false"> <img src="resources/images/living.png"
						width="50px" height="50px"><br>리빙
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown2"
						id="living-menu">
						<a class="dropdown-item" href="#"><img
							src="resources/images/diffuser.png" width="30px" height="30px">&nbsp;홈데코</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><img
							src="resources/images/body_care.png" width="30px" height="30px">&nbsp;바디케어</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><img
							src="resources/images/mask.png" width="30px" height="30px">&nbsp;생활용품</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#"><img
						src="resources/images/event.png" width="50px" height="50px"><br>이벤트</a>
				</li>
			</ul>
			<!-- </ul> -->
			<form class="form-inline my-2 my-lg-0" id="searchBar">
				<input class="form-control mr-sm-2" type="search"
					placeholder="검색어를 입력하세요" aria-label="Search">
				<button class="btn" type="submit" id="searchBtn">Search</button>
			</form>
		</div>
	</nav>
	<!-- <script>
		// When the user scrolls the page, execute myFunction
		window.onscroll = function() {
			myFunction()
		};

		// Get the header
		var header = document.getElementById("navbar");

		// Get the offset position of the navbar
		var sticky = header.offsetTop;

		// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
		function myFunction() {
			if (window.pageYOffset > sticky) {
				header.classList.add("sticky");
			} else {
				header.classList.remove("sticky");
			}
		}
	</script> -->


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