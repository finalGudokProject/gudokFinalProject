<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.starP{
		background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
		background-size: auto 100%;
		width: 30px;
		height: 30px;
		display: inline-block;
		text-indent: -9999px;
		cursor: pointer;
	}
	.starP.on{background-position:0 0;}
	
	div.reviewDC{
	vertical-align: middle;
	}
	#reviewPI{
		margin-top:20px;
		font-size:35px;
	}
	.reviewRC{
		display:inline-block;
	}
	
	.reviewRP{
		text-align:center;
		padding-top:2%;
		font-size:25px;
	}
</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div style="padding-left:12%;">
			<img src="${contextPath }/resources/images/basketImg.png" style="width:7%;height:7%;">
			<span style="vertical-align:middle;font-size:50px;"><b>상품명 상품평</b></span>
		</div>
	<div class="container">
		<div class="row" style="text-align:center;">
		<table>
			<tr>
				<td><span style="font-size:20px;">OOO님의 상품평</span></td>
			</tr>
			<tr>
				<td>
					<div class="starPp">
					  <span class="starP on">별1</span>
					  <span class="starP">별2</span>
					  <span class="starP">별3</span>
					  <span class="starP">별4</span>
					  <span class="starP">별5</span>
					  <span>등록일 : 2020/DB/DB</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="reviewText">내용 입력내용 입력내용 입력내용 입력내용 입력내용 입력 가나다라마바사 아자차카타파하</div>
				</td>
			</tr>
		</table>
		
		</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>