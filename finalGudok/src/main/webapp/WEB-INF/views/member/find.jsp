<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>아이디 찾기</title>
<style>
/*폰트 적용*/
body {
	font-family: 'Jua', sans-serif;
}

#content {
	margin-top: 100px;
	margin-right: auto;
	margin-left: auto;
}

#titleDiv>h3, #titleDiv>div {
	display: inline-block;
}

.vl {
	border-left: 3px solid #495057;
	height: 20px;
	margin-right: 30px;
	margin-left: 30px;
}

#findId {
	color: black;
}

#findPwd {
	color: #495057;
}

#findId:hover, #findPwd:hover {
	color: black;
	text-decoration: none;
}

#inputDiv{
	margin-top:30px;
	margin-left:-30px;
}

td{
	padding:10px;
}

tr:nth-child(3n){
	text-align:center;
}

#findIdBtn {
	border-color: #ced4da;
	color: #495057;
	background-color:white !important;
}

#findIdBtn:hover{
	border-color: black;
	color:black;
}

</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />

	<div id="content">
		<div id="titleDiv" align="center">
			<h3>
				<a href="#" id="findId">아이디 찾기</a>
			</h3>
			<div class="vl"></div>
			<h3>
				<a href="#" id="findPwd">비밀번호 찾기</a>
			</h3>
		</div>
		<div align="center" id="inputDiv">
			<form action="" method="POST" id="findIdForm">
				<table id="inputTable" align="center">
					<tr>
						<td colspan="3"><input class="form-control mb-1" type="text" id="name" placeholder="이름"></td>
					</tr>
					<tr>
						<td colspan="3"><input class="form-control mb-1" type="text" id="email" placeholder="이메일"></td>
					</tr>
					<tr>
						<td colspan="3"><button class="btn" id="findIdBtn">아이디 찾기</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script>
		$("#findId").on("click", function() {
			$("#findId").css("color", "black");
			$("#findPwd").css("color", "#495057");
			
			
			/* $tr2 = $("<tr>");
			$td2 = $("<td>");
			$tr3 = $("<tr>");
			$td3 = $("<td>"); */
			
			
			
			
		})

		$("#findPwd").on("click", function() {
			$("#findId").css("color", "#495057");
			$("#findPwd").css("color", "black");
			
			var $tableBody = $("#inputTable tbody");
			var $tableBody.html("");
			/* var $tr1 = $("<tr>")
			var $td1 = $("<td>").attr("<input>").attr("placeholder","이름");
			
			$tr1.append($td1);
			$tableBody.append($tr1); */
		})
		

	</script>
	<br>
	<br>
	<br>
	<br>
	<br>

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