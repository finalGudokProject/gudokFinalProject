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

<title>계정찾기</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
/*폰트 적용*/
body {
	font-family: 'Jua', sans-serif;
}

#titleDiv {
	margin-top: 50px;
	margin-right: auto;
	margin-left: auto;
	text-align: center;
}

#titleDiv>ul {
	display: inline-block;
	text-align: center !important;
}

#titleDiv li {
	display: inline-block;
}

.vl {
	border: 1px solid #495057;
	height: 20px;
	margin-left: 10px;
	margin-right: 10px;
	margin-left: 10px;
}

#findId {
	color: black !important;
	margin-left: auto;
	margin-right: auto;
	font-size: 1.8em;
}

#findPwd {
	color: #495057 !important;
	margin-left: auto;
	margin-right: auto;
	font-size: 1.8em;
}

#findId:hover, #findPwd:hover {
	color: black;
	text-decoration: none;
}

#inputDiv {
	margin-top: 30px;
	margin-bottom: 50px;
}

.btn {
	color: #495057;
	border: 1px solid #495057;
}

.btn:hover {
	border-color: black;
	color: black;
	cursor: pointer;
}

#inputIdTable td, #inputPwdTable td {
	text-align: center;
}

td {
	padding: 10px;
}
</style>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>

<body>
	<jsp:include page="../common/menubar.jsp" />

	<div id="titleDiv" align="center">
		<ul class="nav nav">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#findIdDiv" id="findId">아이디 찾기</a></li>
			<li class="vl"></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#findPwdDiv" id="findPwd">비밀번호 찾기</a></li>
		</ul>
	</div>
	<div class="tab-content" id="inputDiv">
		<div class="tab-pane show active" id="findIdDiv">
			<form action="" method="POST" id="findIdForm">
				<table id="inputIdTable" align="center">
					<tr>
						<td colspan="3"><input class="form-control mb-1" type="text"
							id="name1" placeholder="이름" autofocus></td>
					</tr>
					<tr>
						<td colspan="3"><input class="form-control mb-1" type="text"
							id="email1" placeholder="이메일"></td>
					</tr>
					<tr>
						<td colspan="3"><button type="button" class="btn"
								id="findIdBtn" onclick="findId();">아이디 찾기</button></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="tab-pane show" id="findPwdDiv">
			<form action="" method="POST" id="findPwdForm">
				<table id="inputPwdTable" align="center">
					<tr>
						<td colspan="3"><input class="form-control mb-1" type="text"
							id="id" placeholder="아이디" required autofocus></td>
					</tr>
					<tr>
						<td colspan="3"><input class="form-control mb-1" type="text"
							id="name2" placeholder="이름" required></td>
					</tr>
					<tr>
						<td colspan="3"><input class="form-control mb-1" type="text"
							id="email2" placeholder="이메일" required></td>
					</tr>
					<tr>
						<td colspan="3"><button type="button" class="btn"
								id="findPwdBtn" onclick="findPwd()">비밀번호 찾기</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<script>
		$("#findId").on("click", function() {
			$("#findId").attr("style", "color:black !important");
			$("#findPwd").attr("style", "color:#495057 !important");
		});

		$("#findPwd").on("click", function() {
			$("#findId").attr("style", "color:#495057 !important");
			$("#findPwd").attr("style", "color:black !important");
		});

		function findId() {
			if ($("#name").val() == "") {
				alert("이름1");
			} else if ($("#email1").val() == "") {
				alert("이메일");
			} else {
				alert("발송");
				$("#name1").val("");
				$("#email1").val("");
			}
		}

		function findPwd() {
			if ($("#id").val() == "") {
				alert("아이디");
			} else if ($("#name2").val() == "") {
				alert("이름")
			} else if ($("#email2").val() == "") {
				alert("이메일");
			} else {
				alert("발송");
				$("#id").val("");
				$("#name2").val("");
				$("#email2").val("");
			}
		}
	</script>

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