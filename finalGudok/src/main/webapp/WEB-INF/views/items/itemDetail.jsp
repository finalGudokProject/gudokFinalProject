<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.starR{
  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
  background-size: auto 100%;
  width: 30px;
  height: 30px;
  display: inline-block;
  text-indent: -9999px;
  cursor: pointer;
}
.starR.on{background-position:0 0;}
#reviewBtn{
	margin:0 0 0 1%;
}

div.reviewDC{
	vertical-align: middle;
}
#reviewPI{
	margin-top:20px;
	font-size:30px;
}
.reviewRC{
	display:inline-block;
}

.reviewRP{
	text-align:center;
	padding-top:2%;
	font-size:20px;
}

.starP{
  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
  background-size: auto 100%;
  width: 20px;
  height: 20px;
  display: inline-block;
  text-indent: -9999px;
  cursor: pointer;
}
.starP.on{background-position:0 0;}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
		<div class="row">
			<div class="col-md-6"><img src="${contextPath }/resources/images/spong.jpg" style="width:500px;height:500px;"></div>
			<div class="col-md-6">
				<span><input type="radio"></span>
				<div>상품 이름</div>
				<div>상품 가격</div>
				<div>상품 수량</div>
			</div>
			<br><br>
			
			<div class="col-md-12"><img src="${contextPath }/resources/images/spong.jpg" style="width:1100px;height:1000px;"></div>
		</div>
		
		
		<br>
		<div class="col-md-12" style="border-top:1px solid lightgray;">
		<p id="reviewPI"><b>상품평</b></p>
			<div class="starRev">
			  <span class="starR on">별1</span>
			  <span class="starR">별2</span>
			  <span class="starR">별3</span>
			  <span class="starR">별4</span>
			  <span class="starR">별5</span>
			</div>
			<br>
			<table>
			<tr>
				<td style="width:50%;" align="center">
					<textarea rows="5" cols="120" id="reviewTxt"></textarea>
				</td>
				<td style="width:20%;" align="center">
					<input id="reviewBtn" type="button" value="등록하기" style="width:160px;height:120px;">
				</td>
			</tr>
			<tr>
				<td><input type="file" value="파일 첨부하기"></td>
				<td></td>
			</tr>
			</table>
			
		</div>
		<br>
		
		<div class="row" style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;padding-bottom:2%;" >
			<div class="col-md-6" class="reviewRC">
				<p class="reviewRP"><b>긍정 상품평</b></p>
				<div>OOO님의 리뷰
					<div class="starPp">
					  <span class="starP on">별1</span>
					  <span class="starP">별2</span>
					  <span class="starP">별3</span>
					  <span class="starP">별4</span>
					  <span class="starP">별5</span>
					</div>
					<div style="border:1px solid black;">
						<span>내용 입력내용 입력내용 입력내용 입력내용 입력내용 입력 가나다라마바사 아자차카타파하</span>
					</div>
				</div>
			</div>
			<div class="col-md-6" class="reviewRC" style="border-left:1px dashed lightgray;">
				<p class="reviewRP"><b>부정 상품평</b></p>
				<div>OOO님의 리뷰
					<div class="starPp">
					  <span class="starP on">별1</span>
					  <span class="starP">별2</span>
					  <span class="starP">별3</span>
					  <span class="starP">별4</span>
					  <span class="starP">별5</span>
					</div>
					<div style="border:1px solid black;">
						<span>내용 입력내용 입력내용 입력내용 입력내용 입력내용 입력 가나다라마바사 아자차카타파하</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	
	<script>
		$('.starRev span').click(function(){
			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
			return false;
		});
		
	</script>
</body>
</html>