<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<title>Goose</title>
<style>
/*메인 */
.cardWrap {
	text-align: center;
}

.cardWrap a {
	color: black;
}

.card {
	margin: 0 30px 0 30px;
	display: inline-block;
}

.carousel-inner>.item>img {
	height: 10px;
}

/*폰트 적용*/
body {
	font-family: 'Jua', sans-serif;
}
</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="common/menubar.jsp" />

	<section>
		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="resources/images/carousel2.jpg" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item">
					<img src="resources/images/flower.jpg" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item">
					<img src="resources/images/salad.jpg" class="d-block w-100"
						alt="...">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>

		<br> <br> <br> <br> <br>

		<div class=cardWrap>
			<p style="font-size: 2em;">
				<a href="#">오늘의 신상품 ></a>
			</p>
			<br>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>
		</div>

		<br> <br> <br> <br> <br>

		<div class=cardWrap>
			<p style="font-size: 2em;">
				<a href="#">베스트 상품 ></a>
			</p>
			<br>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>
		</div>

		<br> <br> <br> <br> <br>

		<div class=cardWrap>
			<p style="font-size: 2em;">지금 가장 핫한 상품</p>
			<br>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>
		</div>

		<br> <br> <br> <br> <br>

		<div class=cardWrap>
			<p style="font-size: 2em;">JM's 추천</p>
			<br>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<a href="#"><img src="resources/images/salad1.jpg"
					class="card-img-top" alt="..."></a>
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>
		</div>

		<br> <br> <br>
		<hr>
	</section>

	<!-- Footer -->
	<footer class="page-footer font-small indigo">
		<jsp:include page="common/footer.jsp" />
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