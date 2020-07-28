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
	font-size:20px;
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

.sign{
	text-align: center;
	vertical-align: middle;
}
.signImg{
	width:35px;
	height:35px;
}
.amountT{
	text-align: center;
	line-height: 27px;
    width:50px;
}

.amountPriceDiv{
	text-align:right;
	padding-right:5%;
	font-size:20px;
	background:#F8F9FA;
	border-radius: 5px;
}
   
  .fa-heart-o {
  color: black;
  cursor: pointer;
}

.fa-heart {
  color: red;
  cursor: pointer;
}

div #mainImg{
	display:block;
	width: 100%;
	height: 100%;
}

div #logoImg{
	display:block;
	width: 100%;
	height: 100%;
	border:1px solid lightgray;
}

input[type=button]{
	background:#6AAED9;
	color:white;
	border-radius:5px;
	padding:2%;
	width:40%;
	transition:800ms ease all;
  	position:relative;
  	border:1px solid #6AAED9;
	margin-bottom:2%;
}
input[type=button]:hover{
  background:#11538C;
  color:#white;
  border:1px solid #11538C;
}

input[type=button]:hover:before,input[type=button]:hover:after{
  width:100%;
  transition:800ms ease all;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
		<div class="row">
			<div class="col-md-6"><img src="${contextPath }/resources/images/breadLogo.jpg" id="logoImg"></div>
			<div class="col-md-6" style="margin-bottom:2%;">
					<div style="margin-top:3%;">카테고리명</div>
					<div class="row">
					<div class="col-md-10" style="padding:0px 15px;margin:0px;font-size:35px;vertical-align:middle;"><b>상품명 상품명 상품명</b></div>
					<div class="col-md-2" style="padding:0px;margin:0px;text-align:center;font-size:35px;"><span id = heart><i class="fa fa-heart-o" aria-hidden="true" ></i> </span></div>
				</div>
				<div class="starRev">
				  <span class="starR on">별1</span>
				  <span class="starR">별2</span>
				  <span class="starR">별3</span>
				  <span class="starR">별4</span>
				  <span class="starR">별5</span>
				</div>
					<div style="padding:5% 0 5% 0;margin-bottom:3%;font-size:30px;border-bottom:1px dotted lightgray;"><b>10,000원</b></div>
					<div class="amountDC">
						<table style="vertical-align:middle;">
							<tr>
								<td class="sign"><img src="${contextPath }/resources/images/XSIGN.png" class="signImg" id="signM"></td>
								<td><input type="text" readonly class="amountT" value="1"></td>
								<td class="sign"><img src="${contextPath }/resources/images/plus.png" class="signImg" id="signP"></td>
							</tr>
						</table>
						<br>
						<div class="amountPriceDiv"><div style="margin-bottom:2%;padding-top:2%;"><b>변동하는 가격</b></div>
						<div style="padding:1% 0 1% 0;"><input type="button" value="장바구니 담기" style="margin:0 5% 0 5%;"><input type="button" value="결제하기"></div>
						</div>
					</div>
			</div>
			<br><br>
			
		</div>
			<div class="col-md-12" style="padding:3%;margin:3% 0 3% 0; width:100%;height:auto;">
				<img src="${contextPath }/resources/images/bread.png" id="mainImg">
			</div>
		
		<!-- 수량 버튼 -->
		<script>
			$(function(){
				var amount = $(".amountT").val();
				$("#signP").click(function(){
					amount = Number(amount) + 1;
					console.log(amount);
					$(".amountT").val(amount);
					if(amount > 1){
						$("#signM").attr("src","${contextPath }/resources/images/minus.png").css("transitionDuration","1s");
					}
				})
				$("#signM").click(function(){
					if(amount > 1){
						amount = Number(amount) - 1;
						$(".amountT").val(amount);
						console.log(amount);
						if(amount < 2){
							$("#signM").attr("src","${contextPath }/resources/images/XSIGN.png").css("transitionDuration","1s");
						}
					}else if(amount == 1){
						alert("1개 미만은 선택하실 수 없습니다.");
					}
				})
			})
		</script>
		
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
				<td><input type="file" name="uploadFile"></td>
				<td></td>
			</tr>
			</table>
			
		</div>
		<br>
		
		<div class="row" style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;" >
			<div class="col-md-6" class="reviewRC">
				<p class="reviewRP"><b>긍정 상품평</b></p>
				<div><span>OOO님의 리뷰</span>
					<div class="starPp">
					  <span class="starP on">별1</span>
					  <span class="starP on">별2</span>
					  <span class="starP on">별3</span>
					  <span class="starP on">별4</span>
					  <span class="starP on">별5</span>
					  <span>등록일 : 2020/DB/DB</span>
					</div>
					<div style="border:1px solid #BBDDF2;margin-bottom:2%;">
						<span>내용 입력내용 입력내용 입력내용 입력내용 입력내용 입력 가나다라마바사 아자차카타파하</span>
					</div>
				</div>
			</div>
			<div class="col-md-6" class="reviewRC" style="border-left:1px dashed lightgray;">
				<p class="reviewRP"><b>부정 상품평</b></p>
				<div><span>OOO님의 리뷰</span>
					<div class="starPp">
					  <span class="starP on">별1</span>
					  <span class="starP">별2</span>
					  <span class="starP">별3</span>
					  <span class="starP">별4</span>
					  <span class="starP">별5</span>
					  <span>등록일 : 2020/DB/DB</span>
					</div>
					<div style="border:1px solid #BBDDF2;margin-bottom:2%;">
						<span>내용 입력내용 입력내용 입력내용 입력내용 입력내용 입력 가나다라마바사 아자차카타파하</span>
					</div>
				</div>
				<div><span>OOO님의 리뷰</span>
					<div class="starPp">
					  <span class="starP on">별1</span>
					  <span class="starP">별2</span>
					  <span class="starP">별3</span>
					  <span class="starP">별4</span>
					  <span class="starP">별5</span>
					  <span>등록일 : 2020/DB/DB</span>
					</div>
					<div style="border:1px solid #BBDDF2;margin-bottom:2%;">
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
	
	<script>
	$(document).ready(function(){
		  $("#heart").click(function(){
		    if($("#heart").hasClass("liked")){
		      $("#heart").html('<i class="fa fa-heart-o" aria-hidden="true"></i>');
		      $("#heart").removeClass("liked");
		    }else{
		      $("#heart").html('<i class="fa fa-heart" aria-hidden="true"></i>');
		      $("#heart").addClass("liked");
		    }
		  });
		});
	</script>
</body>
</html>