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
		transition:800ms ease all;
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
		transition:800ms ease all;
	}
	
	
</style>
<body>
	<jsp:include page="../common/header.jsp"/>


		
		<div style="padding-left:12%;">
			<img src="${contextPath }/resources/images/basketImg.png" style="width:7%;height:7%;">
			<span style="vertical-align:middle;font-size:50px;"><b>장바구니</b></span>
		</div>
	<div class="container">
		<div class="row" style="text-align:center;">
			<table style="border:1px solid black; text-align:center; padding:10%;" align="center" valign="middle">
				<thead>
				<tr style="border-bottom:1px solid lightgray; vertical-align:middle;">
					<th class="listChk"><input type="checkbox" id="chk"></th>
					<th style="width:7%;"><label for="chk" style="display:block;margin:0px;text-align:center;">전체선택(@/?)</label></th>
					<th colspan="2">상품정보</th>
					<th>수량</th>
					<th>상품가격</th>
				</tr>
				</thead>
				<tr style="border-bottom:1px solid lightgray;">
					<td class="listChk"><input type="checkbox"></td>
					<td colspan="2" style="width:30%;"><img src="${contextPath }/resources/images/breadLogo.jpg" class="basketImg"></td>
					<td>상품명</td>
					<td>1개</td>
					<td>10,000원</td>
				</tr>
				
				<tr>
					<td colspan="6" style="text-align:right; padding-right:3%; font-size:40px;">총 주문 금액 : 체크박스 체크한 것만 연산</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align:right;padding-right:3%;"><input type="button" value="개 상품 삭제" style="margin-right:5%;"><input type="button" value="10,000원 결제하기"></td>
				</tr>
			</table>
		</div>
		
		
		
		
		
		
		
	</div>	<!-- 컨테이너 끝 -->
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>