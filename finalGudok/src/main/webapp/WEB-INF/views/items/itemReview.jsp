<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
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
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>