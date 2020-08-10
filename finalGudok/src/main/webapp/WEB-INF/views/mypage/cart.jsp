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
    }

    .myPage_Menu>li {
        margin-bottom: 5%;
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

    .top {
      border-top: 1px solid black;
      border-width: medium;
    }

    .bottom {
      border-bottom: 1px solid black;
    }

    .cartTable {
      margin-top: 5%;
      margin-left: 10%;
      width: 85%;
    }

    .cartTable tr {
      height: 45px;
    }

    .image {
      width: 100%;
      height: 100%;
      overflow: hidden;
      display: flex;
      justify-content: center;
    }

    .image img {
      float: left;
      width: 100px;
      height: auto;
    }

    .product {
      display: inline-block;
      border: 1px solid pink;
    }

    .btn2 {
      width: 90%;
      margin-top: 5%;
      text-align: center;
      margin-left: 10%;
    }

    .btn2 button {
      border: none;
      padding: 2% 8%;
      margin-right: 10%;
      margin: 0 auto;
      margin-left: 3%;
    }

    .delete button{
      border: 1px solid black;
      background: #fff;
      padding: 0.5% 2%;
      float: left;
      margin-left: 10%;
      margin-top: 3%;
    }

    .price table{
      width: 85%;
      margin-top: 10%;
      margin-left: 10%;
    }

    .price td{
      border: 2px solid #115D8C;
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
                <a href="#news"><img src="resources/images/benefit.png"
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
	              <span class="name">홍길동 <span class="etc">&nbsp;님</span></span>
	              <br>
	              <span class="grade">알 <span class="etc">&nbsp;등급</span></span>
	              <br>
	              <span><a href="#" style="color: black; font-size: 0.9em;">등급 혜택보기 ></a></span>
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
	      <span class="sub_content" style="font-size: 1.5em;">장바구니</span>
	      <br><br><br>
	      <table class="cartTable">
	        <tr>
	          <td style="width:10%" class="top bottom"><input type="checkbox" class="check_all">&nbsp;&nbsp;전체선택</td>
	          <td style="width: 45%;" colspan="2" class="top bottom">상품명</td>
	          <td style="width: 15%;" class="top bottom">수량</td>
	          <td style="width: 15%;" class="top bottom">주문금액</td>
	        </tr>
	        <tr>
	          <td class="bottom"><input type="checkbox" style="margin: auto 0;" class="check"></td>
	          <td style="width: 10%;" class="bottom">
	            <div class="image">
	              <img src="resources/images/milk.jpg">
	            </div>
	          </td>
	          <td class="bottom"><span style="float:left; margin-left: 1%;">옳은 유기농 우유</span></td>
	          <td class="bottom">
	            <img class="minus" src="resources/images/minus.png" style="width: 10%; height: auto;">
	            <span class="amount" style="display: inline-block; width: 40px;">1</span>
	            <img class="plus" src="resources/images/plus.png" style="width: 10%; height: auto;">
	          </td>
	          <td class="bottom"><span class="price">4,950</span><span>원</span></td>
	        </tr>
	        <tr>
	          <td class="bottom"><input type="checkbox" style="margin: auto 0;" class="check"></td>
	          <td style="width: 10%;" class="bottom">
	            <div class="image">
	              <img src="resources/images/milk.jpg">
	            </div>
	          </td>
	          <td class="bottom"><span style="float:left; margin-left: 1%;">옳은 유기농 우유</span></td>
	          <td class="bottom">
	            <img class="minus" src="resources/images/minus.png" style="width: 10%; height: auto;">
	            <span class="amount" style="display: inline-block; width: 40px;">1</span>
	            <img class="plus" src="resources/images/plus.png" style="width: 10%; height: auto;">
	          </td>
	          <td class="bottom"><span class="price">4,950</span><span>원</span></td>
	        </tr>
	      </table>
	
	      <div class="delete">
	        <button>선택삭제</button>
	      </div>
	
	      <div class="price" style="width: 100%; margin: 0 auto; margin-top: 10%;">
	        <table>
	          <tr style="height: 40px;">
	            <td>총 판매금액</td>
	            <td>할인금액</td>
	            <td>배송비</td>
	            <td>최종 주문금액</td>
	          </tr>
	          <tr style="height: 80px;">
	            <td><span style="font-size:1.2em">4,950</span><span>원</span></td>
	            <td><span style="font-size:1.2em">0</span><span>원</span></td>
	            <td><span style="font-size:1.2em">2,500</span><span>원</span></td>
	            <td><span style="font-size:1.2em">7,450</span><span>원</span></td>
	          </tr>
	        </table>
	      </div>
	
	      <div class="btn2">
	        <button style="border: 1px solid black; background: #fff;">선택주문하기</button>
	        <button style="background: #115D8C; color: #fff;">주문하기</button>
	      </div>
	    </div>
    </div>
    <hr style="postion:absolute;">
    <jsp:include page="../common/footer.jsp"/>
    
    <script>
	    $(function () {
	      $('.minus').click(function (e) {
	        e.preventDefault();
	        var stat = $(this).siblings('.amount').text();
	        var num = parseInt(stat, 10);
	        num--;
	
	        if (num <= 0) {
	          alert('주문 최소 수량은 1개입니다.');
	          num = 1;
	        }
	
	        $(this).siblings('.amount').text(num);
	      });
	
	      $('.plus').click(function (e) {
	        e.preventDefault();
	        var stat = $(this).siblings('.amount').text();
	        var num = parseInt(stat, 10);
	        num++;
	
	        $(this).siblings('.amount').text(num);
	      });
	    });
  </script>

  <script>
    $( document ).ready( function() {
      $( '.check_all' ).click( function() {
        $( '.check' ).prop( 'checked', this.checked );
        if(checked){
				  $(":checkbox[name=checkbox]").prop("checked", true);
			  } else {
				  $(":checkbox[name=checkbox]").prop("checked", false);
			  }
      }); 
    });
  </script>
</body>
</html>