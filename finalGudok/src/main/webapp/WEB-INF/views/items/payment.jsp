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

<title>Hello, world!</title>
<style>
/*폰트 적용*/
body {
	font-family: 'Jua', sans-serif;
}

.vl {
	border-left: 3px solid #495057;
	height: 300px;
	margin-right: 30px;
	margin-left: 30px;
}

#paymentInfo>div {
	display: inline-block;
}

#infoTable>tr:nth-child(1) {
	text-align: center;
}

td {
	padding: 10px;
}

tr:nth-child(1) {
	text-align: center;
}

h2{
	margin-top:30px;
}
</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>

<body>
	<jsp:include page="../common/menubar.jsp" />

	<section>
		<h2 align="center">결제 페이지</h2>
		<div id="paymentInfo" align="center">
			<div id="customerInfo">
				<table id="infoTable">
					<tr>
						<td colspan="3">배송정보</td>
					</tr>
					<tr>
						<td>받는 사람</td>
						<td><input type="text" placeholder=""></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td colspan="2"><input type="tel" placeholder=""></td>
					</tr>
					<tr>
						<td>구독주기</td>
						<td colspan="2"><input type="text"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text"></td>
						<td><button type="button" class="btn">주소 변경</button></td>
					</tr>
					<tr>
						<td>배송 요청사항</td>
						<td colspan="2"><select name="cycle" id="cycle">
								<option value="0">--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="vl"></div>
			<div id="itemInfo">
				<table>
					<tr>
						<td></td>
					</tr>
				</table>
			</div>
		</div>

	</section>

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