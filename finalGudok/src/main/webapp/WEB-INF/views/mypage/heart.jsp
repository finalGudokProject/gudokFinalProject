<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
	#content {
        font-size: 1em;
        margin-top: 5%;
    }

    /* 마이페이지 메뉴바 */

    .myPage_Menu {
        float: left;
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 10%;
        display: relative;
    }

    .myPage_Menu ul {
        list-style-type: none;
        padding: 0;
        font-size: 1em;
        font-weight: lighter;
        margin-left: 10%;
        margin-bottom:5%;
    }

    .myPage_Menu>li {
        margin-bottom: 10%;
    }

    .myPage_Menu li a {
        display: block;
        color: #000;
        padding: 8px 16px;
        text-decoration: none;
    }

    .myPage_Menu li a.active {
        /* background-color: #4CAF50; */
        color: #000;
    }

    .myPage_Menu li a:hover:not(.active) {
        color: #115D8C;
    }
    
    /* 회원정보 상자 */

    .content_sub {
      float: left;
      width: 85%;
      text-align: center;
      margin-bottom: 10%;
    }

    .content_member {
      height: 10em;
      width: 100%;
    }
    
    .title{
    	font-size: 1.2em;
    }

    .member_info {
      overflow: hidden;
      border: 1px solid #ccc;
      height: 10em;
      width: 80%;
      margin: 0 auto;

    }

    .member,
    .cart,
    .point,
    .subscribe {
      float: left;
      width: 25%;
      height: 100%;
      text-align: center;
      margin: 0;
      padding: 0;
    }

    .member,
    .subscribe,
    .cart,
    .point {
      position: relative;
    }

    .member span {
      display: inline-block;
      padding-top: 10%;
    }

    .sub {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }

    .sub a {
      text-decoration: none;
    }

    .name,
    .grade {
      font-size: 1.2em;
    }

    .name {
      color: black;
    }

    .grade {
      color: #115D8C;
    }

    .etc {
      color: black;
      display: inline;
      font-size: 1em;
    }

    .count {
      color: #115D8C;
      font-size:1.1em;
    }
    /* ------------------- */
	.sub_content {
      float: left;
      margin-left: 10%;
      margin-top: 3%;
    }

    .delete,
    .go_cart,
    .selectAll {
      border: 1px solid black;
      background: #ffffff;
      padding: 1% 2%;
      margin-top: 3%;
      float: right;
    }

    .selectAll{
      margin-right: 2%;
    }

    .delete {
      margin-right: 10%;
      margin-left: 2%;
    }

    .heart {
      float: left;
      margin-left: 10%;
    }

    .heart_item {
      float: left;
      border: 1px solid #cccc;
      width: 330px;
      height: 180px;
      margin-top: 3%;
      margin-right: 3%;
    }

    .heart_item input[type="checkbox"] {
      float: left;
      margin-left: 3%;
      margin-top: 3%;
    }

    .image {
      float: left;
      width: 30%;
      height: auto;
      margin-top: 10%;
      overflow: hidden;
      display: flex;
      justify-content: center;
      float: left;
    }

    .image img {
      float: left;
      width: 100px;
      height: auto;
    }

    .product {
      float: right;
      width: 60%;
      margin-top: 20%;
    }

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div id="content">
        <ul class="myPage_Menu">
            <li>
                <a href="#home"><img src="resources/images/delivery.png"
                        style="width: 25%; height: 25%; margin-right: 4%;">구독배송</a>
                <ul>
                    <li><a href="#">구독 조회</a></li>
                    <li><a href="#">배송 조회</a></li>
                    <li><a href="#">교환 내역</a></li>
                </ul>
            </li>
            <li>
                <a href="#news"><img src="resources/images/my_benefit.png"
                        style="width: 25%; height: 25%; margin-right: 4%;">나의혜택</a>
                <ul>
                    <li><a href="#">회원 등급</a></li>
                    <li><a href="#">적립금 내역</a></li>
                </ul>
            </li>
            <li><a href="#contact"><img src="resources/images/cart.png"
                        style="width: 25%; height: 25%; margin-right: 4%;">장바구니</a></li>
            <li><a href="#about"><img src="resources/images/heart.png" style="width: 25%; height: 25%; margin-right: 4%;">찜</a>
            </li>
            <li><a href="#about"><img src="resources/images/review.png"
                        style="width: 25%; height: 25%; margin-right: 4%;">상품리뷰</a></li>
            <li><a href="#about"><img src="resources/images/inquiry.png"
                        style="width: 25%; height: 25%; margin-right: 4%;">1:1문의</a></li>
            <li>
                <a href="#about"><img src="resources/images/member_information.png"
                        style="width: 25%; height: 25%; margin-right: 4%;">회원정보</a>
                <ul>
                    <li><a href="#">회원정보 확인</a></li>
                    <li><a href="#">회원탈퇴</a></li>
                </ul>
            </li>
        </ul>
        
        <div class="content_sub">
	      <div class="content_member">
	        <div class="member_info">
	          <div class="member">
	            <div class="sub">
	              <span class="name">${loginUser.memberName } <span class="etc">&nbsp;님</span></span>
	              <br>
	              <span class="grade">알 <span class="etc">&nbsp;등급</span></span>
	              <br>
	              <span><a href="#" style="color: black; font-size: 0.8em;">등급 혜택보기</a></span>
	            </div>
	          </div>
	          <div class="subscribe">
	            <div class="sub">
	              <span class="title"><a href="#" style="color: black;">구독</a></span>
	              <br><br>
	              <span class="count"><a href="#" style="color :#115D8C;">0<span class="etc">&nbsp;건</span></a></span>
	            </div>
	          </div>
	          <div class="cart">
	            <div class="sub">
	              <span class="title"><a href="#" style="color: black;">장바구니</a></span>
	              <br><br>
	              <span class="count"><a href="#" style="color :#115D8C;">0<span class="etc">&nbsp;건</span></a></span>
	            </div>
	          </div>
	          <div class="point">
	            <div class="sub">
	              <span class="title"><a href="#" style="color: black;">적립금</a></span>
	              <br><br>
	              <span class="count"><a href="#" style="color :#115D8C;">0<span class="etc">&nbsp;건</span></a></span>
	            </div>
	          </div>
	        </div>
	      </div>
	      <span class="sub_content" style="font-size: 1.5em;">찜</span>
	      <button class="delete">선택삭제</button>
	      <button class="go_cart">장바구니</button>
	      <button class="selectAll">전체선택</button>
	      <br><br><br>
	      <div class="heart">
	        <div class="heart_item">
	          <input type="checkbox" class="check">
	          <div class="image">
	            <img src="resources/images/milk.jpg">
	          </div>
	          <div class="product">
	            <span>옳은 유기농 우유</span>
	            <br>
	            <span>4,950원</span>
	          </div>
	        </div>
	        <div class="heart_item">
	          <input type="checkbox" class="check">
	          <div class="image">
	            <img src="resources/images/milk.jpg">
	          </div>
	          <div class="product">
	            <span>옳은 유기농 우유</span>
	            <br>
	            <span>4,950원</span>
	          </div>
	        </div>
	        <div class="heart_item">
	          <input type="checkbox" class="check">
	          <div class="image">
	            <img src="resources/images/milk.jpg">
	          </div>
	          <div class="product">
	            <span>옳은 유기농 우유</span>
	            <br>
	            <span>4,950원</span>
	          </div>
	        </div>
	        <div class="heart_item">
	          <input type="checkbox" class="check">
	          <div class="image">
	            <img src="resources/images/milk.jpg">
	          </div>
	          <div class="product">
	            <span>옳은 유기농 우유</span>
	            <br>
	            <span>4,950원</span>
	          </div>
	        </div>
	      </div>
	    </div>
    </div>
    <br style="clear:both;">
    <jsp:include page="../common/footer.jsp"/>
    <script>
    var clicked = false;
    $(".selectAll").on("click", function() {
        $(".check").prop("checked", !clicked);
        clicked = !clicked;
        this.innerHTML = clicked ? '전체해제' : '전체선택';
    });
  </script>
</body>
</html>