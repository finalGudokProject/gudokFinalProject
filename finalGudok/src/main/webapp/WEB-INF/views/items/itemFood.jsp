<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	ul{
		list-style: none;
		display:inline-block;
	}
	
	.paper{
		margin:2%;
		width:25%;
		height:auto;
		float:left;
		text-align:left;
		border:1px solid black;
	}
	#cateName{
		font-size:30px;
		margin:3% 0 1% 7%;
		line-height:100px;
	}
	#cateName img{
		vertical-align:middle;
	}
	#cateName span{
		vertical-align:middle;
	}
	
	/* 상품 리스트 정렬 CSS */
	#rankDiv{
		float:left;
		margin-left:2%;
		width:500px;
		height:auto;
		border:1px solid lightgray;
	}
	
	.rankDiv{
		float:left;
		size:30px;
		margin:0 3% 0 3%;
		width:17%;
		height:35px;
		display:inline-block;
		text-align:center;
		padding-top:4px;
	}
	
	#menu{
		background:white;
		width:220px;
		height:40px;
		vertical-align:middle !important;
		padding:2%;
		border-bottom:1px solid lightgray;
	}
	#menu a{
		display:block;
		color:black;
		vertical-align:middle !important;
	}	
	
	div.col-md-9{
		padding:0 !important;
	}
	
	.paperUl{
		padding:0px !important;
	}
	#menuId{
		margin-top:10%;
		padding-left:0;
		border:1px solid lightgray;
	}
	.smallMenu{
		display:none;
		width:180px;
		height:35px;
		opacity:90%;
		border: 1px solid black;
		left:60px;
		top:20px;
	}
	.smallMenu a{
		display:block;
	}
	
	.menuName{
		margin-left:10%;
		font-size:30px;
	}
	
	.listUl{
		padding:0 !important;
	}
	ul li a div ul li{color:black;}
	ul li a div ul li :hover{color:red;}
	
	#itemsRowDiv{
		margin:5%;
		text-align:center;
	}
	.sortClass{
		width:8rem;
		height:8rem;
		display:block;
	}
	
	td{
		text-align:center;
	}
	
	/* .sortDivC :hover{
		cursor:pointer;
		background:lightyellow;
	} */
	
	#sortTable td :hover{
		cursor:pointer;
		background:lightyellow;
	}
	
	
	.starR{
	  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
	  background-size: auto 100%;
	  width: 30px;
	  height: 30px;
	  display: inline-block;
	  text-indent: -9999px;
	  cursor: pointer;
	  margin:0 0 12px;
	}
	.starR.on{background-position:0 0;}
	
	.itemPriceDiv{
		font-size:25px;
		font-weight:bold;
	}
	
	#rateId{
		margin-bottom:3%;
	}
	
	.cardBody {
	    -ms-flex: 1 1 auto;
	    flex: 1 1 auto;
	    min-height: 1px;
	    padding: 1.25rem;
	    padding-bottom: 0;
	}
	
	.cardFooter{
	 	padding-bottom:5%;
	}
	
	.starRev{
		line-height:35px;
	}
	.starRev span{
		vertical-align:bottom;
	}
	
	.card{
		margin:0 auto;
		float:none;
		margin-bottom:10px;
	}
	
	.circle{
		width:6rem;
		height:6rem;
		position:absolute;
		z-index:1;
		margin:3% 0 0 2%;
	}
	
	.circle img{
		width:90%;
		height:90%;
		border-radius:1rem;
		border:1px solid red;
	}
	
	#ratePercentId{
		line-height:6rem;
		width:6rem;
	}
	#ratePercentId span{
		vertical-align:middle;
		text-align:center;
		width:6rem;
		font-size:30px;
		font-weight: bold;
		opacity: 90%;
	}
	
	.col-4{
		padding-bottom:8%;
	}
</style>
</head>
<body>
<jsp:include page="../common/menubar.jsp"/>
<div class="container">
	<div class="row">
	<div class="col-md-12">
		<div id="cateName" style="font-size:50px;">
		<img src="${contextPath }/resources/images/food.png" style="width:70px;height:70px;">
		<span>푸드</span>
		</div>
		<div style="margin:0 0 3% 2%">
			<table style="display:block;">
				<tr>
					<td style="width:10%;">유제품</td>
					<td style="width:10%;">베이커리</td>
					<td style="width:10%;">다이어트 식단</td>
					<td style="width:10%;">음료</td>
					<td style="width:10%;">간편식품</td>
					<td style="width:10%;">건강식품</td>
				</tr>
			</table>
		</div>
			<div style="border-top:1px solid lightgray;border-bottom:1px solid lightgray;">
			<table align="center" style="margin-bottom:1%;" id="sortTable">
				<tr>
					<td><div class="sortDivC">
					<img src="${contextPath }/resources/images/newItem.png" class="sortClass"><span style="display:block;">신상품순</span>
					</div></td>
					<td><div class="sortDivC">
					<img src="${contextPath }/resources/images/popul.png" class="sortClass"><span style="display:block;">인기순</span>
					</div></td>
					<td><div class="sortDivC">
					<img src="${contextPath }/resources/images/high.png" class="sortClass"><span style="display:block;">높은 가격순</span>
					</div></td>
					<td><div class="sortDivC">
					<img src="${contextPath }/resources/images/low.png" class="sortClass"><span style="display:block;">낮은 가격순</span>
					</div></td>
				</tr>
			</table>
			</div>
			
	</div>
	
	<div class="row" id="itemsRowDiv">
		<c:forEach var="i" items="${list }">
			<div class="col-4">
				<div class="card">
				
					<c:if test="${empty i.eventNo}">
					<div class="cardHeader">
						<div class="circle">
							<div id="ratePercentId" style="position:absolute;"><span>30%</span></div>
							<img src="resources/images/sale.png">
						</div>
						<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="..." style="position:relative;">
					</div>
					</c:if>
					
					<c:if test="${!empty i.eventNo }">
					<div class="cardHeader">
					<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
					</div>
					</c:if>
					<div class="cardBody">
						<h3 class="card-title"><b>${i.itemName }</b></h3>
						<h5>${i.itemMemo }</h5>
						<div class="itemPriceDiv">
						<c:if test="${!empty i.eventNo  }">
							<s style="color:red;">${i.itemPrice }</s>→9,000원
						</c:if>
						<c:if test="${empty i.eventNo  }">
							${i.itemPrice }원
						</c:if>
						</div>
						<div class="starRev">
						  <span class="starR on">별1</span>
						  <span class="starR on">별2</span>
						  <span class="starR on">별3</span>
						  <span class="starR on">별4</span>
						  <span class="starR on">별5</span>
						  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
						</div>
						  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : ${i.itemChoice }명)</div>
						</div>
						<div class="row">
							<div class="col-4" id="btnBlank"></div>
							<div class="col-4" style="padding:0px;">
								<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
							</div>
							<div class="col-4" id="btnBlank"></div>
						</div>
						<div class="cardFooter"></div>
				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row" id="itemsRowDiv">
			<div class="col-12">
				<c:if test = "${pi.currentPage eq 1}">
					[이전]
				</c:if>
				<c:if test = "${pi.currentPage gt 1 }">
					<c:url var = "ilistBack" value = "itemFood.do">
						<c:param name="page" value="${pi.currentPage - 1 }"/>
					</c:url>
					<a href="${ilistback}">[이전]</a>
				</c:if>
				
				
				
				<c:if test = "${pi.currentPage eq pi.maxPage}">
					[이후]
				</c:if>
				<c:if test = "${pi.currentPage lt pi.maxPage}">
					<c:url var = "ilistAfter" value = "itemFood.do">
						<c:param name="page" value="${pi.currentPage + 1 }"/>
					</c:url>
					<a href="${ilistAfter }">[이후]</a>
				</c:if>
				
			</div>
		</div>
		
		<div>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ경계선ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</div>
		<div>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ경계선ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</div>
		<div>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ경계선ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</div>
		<div>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ경계선ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</div>
		<div>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ경계선ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</div>
		<div>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ경계선ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</div>
		<div>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ경계선ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</div>
	<div class="row" id="itemsRowDiv">
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv"><s style="color:red;">10,000원</s>→9,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
		
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv">10,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
		
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv"><s style="color:red;">10,000원</s>→9,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
	
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv">10,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
		
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv"><s style="color:red;">10,000원</s>→9,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
		
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv">10,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
	
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv">10,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
		
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
				<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="..." style="position:relative;">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv"><s style="color:red;">10,000원</s>→9,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
		
		<div class="col-4">
			<div class="card">
				<div class="cardHeader">
					<div class="circle">
						<div id="ratePercentId" style="position:absolute;"><span>30%</span></div>
						<img src="resources/images/sale.png">
					</div>
					<img src="resources/images/breadLogo.jpg" class="card-img-top" alt="..." style="position:relative;">
				</div>
				<div class="cardBody">
					<h3 class="card-title"><b>상품명</b></h3>
					<h5>상품약식설명</h5>
					<div class="itemPriceDiv"><s style="color:red;">10,000원</s>→9,000원</div>
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR on">별2</span>
					  <span class="starR on">별3</span>
					  <span class="starR on">별4</span>
					  <span class="starR on">별5</span>
					  <div style="display:inline-block;color:gray;">(리뷰수:200)</div>
					</div>
					  <div id="rateId">(평점 : 5.0점 / 찜한 사람 : 120명)</div>
					</div>
					<div class="row">
						<div class="col-4" id="btnBlank"></div>
						<div class="col-4" style="padding:0px;">
							<button class="btn btn-primary" style="width:100%;height:100%;" id="whatSpan" data-toggle="modal" data-target="#intro">미리보기</button>
						</div>
						<div class="col-4" id="btnBlank"></div>
					</div>
					<div class="cardFooter"></div>
			</div>
		</div>
	</div>
	</div>
</div>

			<!-- 모달 시작 -->
			<div id="myModal" class="modal">

				<div class="modal-content">
					<div class='modal-header'>
						<div class="row">
							<div style="font-size:40px;">상품명 상품문의</div>
							<div style="font-size:15px;padding:2%;">상품에 대한 자세한 문의는 고객 센터를 이용해 주세요.</div>
						</div>
						<div><button type='button' class="close" data-dismiss='modal'
							aria-hidden="='true'" style="font-size:50px;">&times;</button></div>
					</div>
					
					<div class='modal-body'>
						<form method="post" id="reasonForm">
							
							<textarea placeholder="문의할 내용을 입력해 주세요." style="width:100%;" rows="8" id="ansText"></textarea>
							
							
							<div class='modal-footer'>
								<input type='button' class="modalAnsBtn" data-dismiss='modal'
									value="문의하기">
								<div id='area2' class='area'></div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 모달 끝 -->
			

	<script>
		$(function(){
			$(".btn-primary").on("click", function(){
				swal("","확인","warning").then((value)=>{
					swal("","여기서 값 넣어요","info");
				});
			})
		})
	</script>

	
	<!-- 사이드 메뉴바 -->
	<script>
	$(function(){
		$(".menu").mouseenter(function(){
			$(this).find("li").css("display","block").css("background","white");
		}).mouseleave(function(){
			$(this).find("li").css("display","none");
		})
	})
	</script>
	
	<script>
		$(function(){
			$(".cardHeader, .cardBody, #btnBlank, .cardFooter").click(function(){
				location.href="itemDetail.do";
			}).mouseenter(function(){
				$(this).css("cursor","pointer");
			})
		})
	</script>
	
	<!-- 모달 실행(모달 폼보다 밑에 두기) -->
		<script>
			var modal = document.getElementById("myModal");
			var btn = document.getElementById("whatSpan");
			var span = document.getElementsByClassName("close")[0];
			btn.onclick = function() {
				modal.style.display = "block";
			}
			span.onclick = function() {
				modal.style.display = "none";
			}
			
		</script>
		<!-- 모달 실행 끝 -->
<jsp:include page="../common/footer.jsp"/>
</body>
</html>