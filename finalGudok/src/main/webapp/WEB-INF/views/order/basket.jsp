<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.basketImg{
		width:30%;
		height:30%;
	}
	.listChk{
		width:3%;
		height:3%;
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

	<div class="container">
		<p style="padding-left:10%;margin-top:3%;font-size:60px;"><b>장바구니</b></p>
		<div class="row" style="text-align:center;">
			<table style="border:1px solid black; text-align:center; padding:10%;" align="center" valign="middle">
				<tr style="border-bottom:1px solid lightgray; vertical-align:middle;">
					<td class="listChk"><input type="checkbox" id="chk"></td>
					<th style="width:7%;"><label for="chk" style="display:block;margin:0px;text-align:center;">전체선택(0/0)</label></th>
					<th>상품정보</th>
					<th>상품가격</th>
				</tr>
				<tr style="border-bottom:1px solid lightgray;">
					<td class="listChk"><input type="checkbox"></td>
					<td colspan="2" style="width:30%;"><img src="${contextPath }/resources/images/breadLogo.jpg" class="basketImg"></td>
					<td>10,000원</td>
				</tr>
				
				<tr>
					<td colspan="4" style="text-align:right; padding-right:3%; font-size:40px;">총 주문 금액 : 체크박스 체크한 것만 연산</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align:left;padding-left:0 0 0 3%;"><input type="button" value="선택 삭제"></td>
					<td colspan="1" style="text-align:right;padding-right:3%;"><input type="button" value="결제하기"></td>
				</tr>
			</table>
		</div>
		
		
		
		
		
		
		
	</div>	<!-- 컨테이너 끝 -->
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>