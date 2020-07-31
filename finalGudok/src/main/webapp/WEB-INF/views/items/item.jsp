<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	ul{
		list-style: none;
		display:inline-block;
	}
	
	.paper{
		margin:2%;
		width:25%;
		height:auto;
		float:left;
		text-align:left;
		border:1px solid black;
	}
	#cateName{
		font-size:30px;
		margin:3% 0 3% 7%;
	}
	
	/* 상품 리스트 정렬 CSS */
	#rankDiv{
		float:left;
		margin-left:2%;
		width:500px;
		background:lightblue;
		height:35px;
		border:1px solid black;
	}
	
	a.rankDiv{
		float:left;
		size:30px;
		margin:0 3% 0 3%;
		width:17%;
		height:35px;
		display:block;
		text-align:center;
		padding-top:4px;
	}
	
	#menu{
		background:white;
		width:220px;
		height:40px;
		vertical-align:middle !important;
		padding:2%;
		border-bottom:1px solid lightgray;
	}
	#menu a{
		display:block;
		color:black;
		vertical-align:middle !important;
	}	
	
	div.col-md-9{
		padding:0 !important;
	}
	
	.paperUl{
		padding:0px !important;
	}
	#menuId{
		margin-top:10%;
		padding-left:0;
		border:1px solid lightgray;
	}
	.smallMenu{
		display:none;
		width:180px;
		height:35px;
		opacity:90%;
		border: 1px solid black;
		left:60px;
		top:20px;
	}
	.smallMenu a{
		display:block;
	}
	
	.menuName{
		margin-left:10%;
		font-size:30px;
	}
	
	.listUl{
		padding:0 !important;
	}
	ul li a div ul li{color:black;}
	ul li a div ul li :hover{color:red;}
	
	#itemsRowDiv{
		margin:5%;
		text-align:center;
	}
	
	
	
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
	<div class="row">
	<div class="col-md-12">
		<div id="cateName">아이스크림</div>
		<div id="rankDiv">
			<a href="#" class="rankDiv">인기순</a>
			<a href="#" class="rankDiv">최신 등록순</a>
			<a href="#" class="rankDiv">높은 가격순</a>
			<a href="#" class="rankDiv">낮은 가격순</a>
		</div>
	</div>
	
	<div class="row" id="itemsRowDiv">
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
	</div>
	
	<div class="row" id="itemsRowDiv">
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
	</div>
	
	<div class="row" id="itemsRowDiv">
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
		<div class="col-4">
			<div class="card">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">제목</h5>
						<p class="card-text">P태그</p>
						<a href="#" class="btn btn-primary">A태그</a>
					</div>
			</div>
		</div>
	</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp"/>
	<!-- <script>
		$(function(){
			$(".paper").mouseenter(function(){
				$(this).css("border","1px solid black");
			}).mouseout(function(){
				$(this).css("border","none");
			})
		})
	</script> -->
	
	<!-- 사이드 메뉴바 -->
	<script>
	$(function(){
		$(".menu").mouseenter(function(){
			$(this).find("li").css("display","block").css("background","white");
		}).mouseleave(function(){
			$(this).find("li").css("display","none");
		})
	})
	</script>
	
	<script>
		$(function(){
			$("div.card").click(function(){
				location.href="itemDetail.do";
			})
		})
	</script>
</body>
</html>