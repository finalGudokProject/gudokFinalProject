<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/data/201101/IJ12941530138912/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/data/201101/IJ12941530138912/jquery-contained-sticky-scroll.js"></script>
<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery('#sidebar').containedStickyScroll();
});
</script>
<style>
	.basketImg{
		width:30%;
		height:30%;
	}
	.listChk{
		width:5%;
		height:5%;
	}
	input[type=checkbox]{
		width:30px;
		height:30px;
		display:block;
		margin:0 auto;
		
	}
	td{
		vertical-align:middle;
		font-size:20px;
	}
	th{
		font-size:20px;
	}
	
	input[type=button]{
		background:#6AAED9;
		color:white;
		border-radius:5px;
		padding:2%;
		width:20%;
		transition:0.5s;
	  	position:relative;
	  	border:1px solid #6AAED9;
		margin-bottom:1%;
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
		
	.signImg{
		width:35px;
		height:35px;
	}
	
	table .countTd{
		vertical-align:middle;
	}
	
	
</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>


		
		<div style="padding-left:12%;">
			<img src="${contextPath }/resources/images/basketImg.png" style="width:7%;height:7%;">
			<span style="vertical-align:middle;font-size:50px;"><b>장바구니</b></span>
		</div>
	<div class="container">
		<div class="row" style="text-align:center;">
			<table style="border:1px solid black; text-align:center; padding:10%;" align="center">
				<thead>
				<tr style="border-bottom:1px solid lightgray; vertical-align:middle;">
					<th class="listChk"  style="width:3%;"><input type="checkbox" id="allChk"></th>
					<th style="width:7%;"><label for="chk" style="display:block;margin:0px;text-align:center;">전체선택(@/?)</label></th>
					<th colspan="2">상품정보</th>
					<th style="width:15%;">수량</th>
					<th style="width:10%;">구독주기</th>
					<th style="width:10%;">상품가격</th>
				</tr>
				
				</thead>
				<tr style="border-bottom:1px solid lightgray;vertical-align:middle;">
					<td class="listChk"><input type="checkbox" class="chk"></td>
					<td colspan="2" style="width:30%;"><img src="${contextPath }/resources/images/breadLogo.jpg" class="basketImg"></td>
					<td>상품명상품명상품명상품명상품명상품명상품명상품</td>
					<td class="countTd"><img src="${contextPath }/resources/images/XSIGN.png" class="signImg" id="signM">
					<input type="text" readonly class="amountT" value="1" style="width:50px;text-align:center;">
					<img src="${contextPath }/resources/images/plus.png" class="signImg" id="signP"></td>
					<td>
					<select style="width:80px;height:30px;">
						<option value="1">1주일</option>
						<option value="2">2주일</option>
						<option value="3">3주일</option>
						<option value="4">4주일</option>
					</select>
					<td>10,000원</td>
				</tr>
				<tr style="border-bottom:1px solid lightgray;vertical-align:middle;">
					<td class="listChk"><input type="checkbox" class="chk"></td>
					<td colspan="2" style="width:30%;"><img src="${contextPath }/resources/images/breadLogo.jpg" class="basketImg"></td>
					<td>상품명상품명상품명상품명상품명상품명상품명상품</td>
					<td class="countTd"><img src="${contextPath }/resources/images/XSIGN.png" class="signImg" id="signM">
					<input type="text" readonly class="amountT" value="1" style="width:50px;text-align:center;">
					<img src="${contextPath }/resources/images/plus.png" class="signImg" id="signP"></td>
					<td>
					<select style="width:80px;height:30px;">
						<option value="1">1주일</option>
						<option value="2">2주일</option>
						<option value="3">3주일</option>
						<option value="4">1개월</option>
					</select>
					<td>10,000원</td>
				</tr>
				<tr style="border-bottom:1px solid lightgray;vertical-align:middle;">
					<td class="listChk"><input type="checkbox" class="chk"></td>
					<td colspan="2" style="width:30%;"><img src="${contextPath }/resources/images/breadLogo.jpg" class="basketImg"></td>
					<td>상품명상품명상품명상품품명상품</td>
					<td class="countTd"><img src="${contextPath }/resources/images/XSIGN.png" class="signImg" id="signM">
					<input type="text" readonly class="amountT" value="1" style="width:50px;text-align:center;">
					<img src="${contextPath }/resources/images/plus.png" class="signImg" id="signP"></td>
					<td>
					<select style="width:80px;height:30px;">
						<option value="1">1주일</option>
						<option value="2">2주일</option>
						<option value="3">3주일</option>
						<option value="4">1개월</option>
					</select>
					<td>10,000원</td>
				</tr>
				
				<tr>
					<td colspan="7" style="text-align:right; padding-right:3%; font-size:40px;">총 주문 금액 : 체크박스 체크한 것만 연산</td>
				</tr>
				<tr>
					<td colspan="7" style="text-align:right;padding-right:3%;"><input type="button" value="개 상품 삭제" style="margin-right:5%;" id="delBtn"><input type="button" value="10,000원 결제하기" id="paymentBtn"></td>
				</tr>
			</table>
		</div>
	</div>	<!-- 컨테이너 끝 -->
	
	<script>
		$(function(){
			$("#allChk").click(function(){
				if($("#allChk").prop("checked")){
					$("input[type=checkbox]").prop("checked",true);
				}else{
					$("input[type=checkbox]").prop("checked",false);
				}
			})
			$(".chk").click(function(){
				if($("#allChk").prop("checked")){
					$("#allChk").prop("checked",false);
				}
			})
		})
	</script>
	
	
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
						swal("","1개 미만은 선택하실 수 없습니다.","error");
					}
				})
			})
		</script>
		
		<!-- 장바구니 목록 삭제버튼 -->
		<script>
			$(function(){
				$("#delBtn").on("click", function(){
					var check = $("input:checkbox[class=chk]:checked").length;
					if(check == 0){
						swal("","체크된 상품이 존재하지 않습니다.","info");
					}else{
						swal({
							text : check + "개의 상품을 장바구니에서 삭제하시겠습니까?",
							icon : "warning",
							buttons : ["예", "아니오"],
							closeOnEsc : false,
							dangerMode : true,
						}).then((result)=>{
							if(result){
								
							}else{
								swal("",check+"개의 상품이 장바구니에서 삭제되었습니다.","success");
							}
						})
					}
				})
			})	
		</script>
		<!-- 장바구니 목록 삭제버튼 끝 -->
		
		<!-- 결제하기 버튼 -->
		<script>
			$(function(){
				$("#paymentBtn").on("click", function(){
					var check = $("input:checkbox[class=chk]:checked").length;
					if(check == 0){
						swal("","체크된 상품이 존재하지 않습니다.","info");
					}else{
						swal({
							text : check + "개의 상품 " + "얼마를 결제하시겠습니까?",
							icon : "warning",
							buttons : ["예", "아니오"],
							closeOnEsc : false,
							dangerMode : true,
						}).then((result)=>{
							if(result){
								
							}else{
								swal("","결제 페이지로","success");
							}
						})
					}
				})
			})	
		</script>
		<!-- 결제하기 버튼 끝 -->
		
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>