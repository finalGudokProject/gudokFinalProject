<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
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
	transition:0.5s;
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
  transition:0.5s;
}



.cycleSpan{
	display:block;
	cursor:pointer;
	background:white;
	border-radius:5px;
	border:1px solid #6AAED9;
	color:#6AAED9;
	padding:5%;	
}


.cycleTable{
	text-align:center;
	width:100%;
}


</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container" style="margin-top:3%;">
		<div class="row">
			<div class="col-md-6" style="padding:0 2% 0 2%;"><img src="${contextPath }/resources/images/breadLogo.jpg" id="logoImg"></div>
			<div class="col-md-6" style="margin-bottom:2%;">
					<div style="margin-top:3%;">카테고리명</div>
					<div class="row">
					<div class="col-md-10" style="padding:0px 15px;margin:0px;font-size:35px;vertical-align:middle;"><b>상품명 상품명 상품명</b></div>
					<div class="col-md-2" style="padding:0px;margin:0px;text-align:center;font-size:35px;"><span id = heart><i class="fa fa-heart-o" aria-hidden="true" ></i> </span></div>
					<div style="padding:0 15px;font-size:20px;">상품약식설명</div>
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
						<div style="padding:1% 0 1% 0;"><input type="button" value="장바구니 담기" id="basketBtn" style="margin:0 5% 0 5%;"><input type="button" value="결제하기"></div>
						</div>
						<div style="margin-top:3%;border-top:1px dotted lightgray;"></div>
						<div class="cycleListClass" style="margin-top:3%;padding:2%;background:#F8F9FA;">
							<input type="text" id="cycleText" style="display:none;" name="inputCycle">
							<table class="cycleTable">
								<tr>
									<td style="width:25%;"><span class="cycleSpan" id="1cycle">1주일</span></td>
									<td style="width:25%;"><span class="cycleSpan" id="2cycle">2주일</span></td>
									<td style="width:25%;"><span class="cycleSpan" id="3cycle">3주일</span></td>
									<td style="width:25%;"><span class="cycleSpan" id="4cycle">한 달</span></td>
								</tr>
								<tr>
									<td colspan="4" style="padding:3% 3% 0 0;text-align:right;font-size:20px;" id="cycleChTd">구독 주기를 선택해 주세요.</td>
								</tr>
							</table>
						</div>
						<script>
							$(function(){
								var text = $("#cycleText").val()
								$(".cycleSpan").click(function(){
									text = "";
									var c1 = $(this).text();
									var $cycle = $(this).text();
									$(".cycleTable").find("tr td .cycleSpan").not($cycle).css({"background":"white","color":"#6AAED9","border":"1px solid #6AAED9"});
									$(this).css({"background":"#6AAED9","color":"white"});
									switch(c1){
										case "1주일" : 
											text = text + 1;
											$("#cycleChTd").text("1주일 구독을 선택하셨습니다.");
											break;
										case "2주일" : 
											text = text + 2;
											$("#cycleChTd").text("2주일 구독을 선택하셨습니다.");
											break;
										case "3주일" : 
											text = text + 3;
											$("#cycleChTd").text("3주일 구독을 선택하셨습니다.");
											break;
										case "한 달" :
											text = text + 4;
											$("#cycleChTd").text("한 달 구독을 선택하셨습니다.");
											break;
									}
									
									console.log(text)
									$("#cycleText").val(text);
								})
							})
						</script>
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
			</table>
			<table class="fileAddClass">
				<tr>
					<td><img src="${contextPath }/resources/images/plus.png" style="width:30px;height:30px;" class="fileImgBtn" id="fileAddBtn"></td>
					<td><input type="file" name="uploadFile"></td>
				</tr>
				<tbody>
				
				</tbody>
			</table>
			
		</div>
		<br>
		
		<div class="row" style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;" >
			<div class="col-md-6" class="reviewRC">
				<p class="reviewRP"><b>긍정 상품평</b></p>
				<div><span style="font-size:20px;">OOO님의 리뷰</span>
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
				<div><span style="font-size:20px;">OOO님의 리뷰</span>
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
				<div><span style="font-size:20px;">OOO님의 리뷰</span>
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
	
	<script>
		$(function(){
			$('.starRev span').click(function(){
				$(this).parent().children('span').removeClass('on');
				$(this).addClass('on').prevAll('span').addClass('on');
				return false;
			});
		})
		
	</script>
	
	<script>
		$(function(){
			$("#basketBtn").click(function(){
				location.href="basket.do";
			})
		})
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
	
	<!-- <script>
		var count = 1;
		var removeImgId = null;
		$(function(){
			$("#fileAddBtn").click(function(){
				if(count < 3){
					console.log(count);
					count++;
					removeImgId = "minusImgId" + count;
					
					$(".fileAddClass > tbody:last").
					append("<tr><td>"+"<img src='${contextPath }/resources/images/minus.png' style='width:30px;height:30px;' class='fileImgBtn' id='"+removeImgId+"' onclick='removeBtn"+count+"();'></td>"+
							"<td><input type='file' name='uploadFile'></td></tr>");
				}else{
					alert("파일은 3개까지 등록 가능합니다.")
				}
			});
		})
		
		function removeBtn2(){
			$("#minusImgId2").parent().parent().remove();
			count--;
		}
		function removeBtn3(){
			$("#minusImgId3").parent().parent().remove();
			count--;
		}
		
	</script> -->
	
	<script>
		var count = 1;
		var removeImgId = null;
		$(function(){
			$("#fileAddBtn").click(function(){
				if(count < 3){
					console.log(count);
					count++;
					removeImgId = "minusImgId" + count;
					
					$(".fileAddClass > tbody:last").
					append("<tr><td>"+"<img src='${contextPath }/resources/images/minus.png' style='width:30px;height:30px;' class='fileImgBtn' id='"+removeImgId+"' onclick='removeBtn"+count+"();'></td>"+
							"<td><input type='file' name='uploadFile'></td></tr>");
				}else{
					alert("파일은 3개까지 등록 가능합니다.")
				}
			});
		})
		
		function removeBtn2(){
			$("#minusImgId2").parent().parent().remove();
			count--;
		}
		function removeBtn3(){
			$("#minusImgId3").parent().parent().remove();
			count--;
		}
		
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
	
</body>
</html>