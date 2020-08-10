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

    .delivery {
      margin-top: 5%;
      margin-left: 10%;
    }

    .delivery table {
      width: 100%;
    }

    .delivery table tr {
      height: 45px;
    }

    .delivery table button {
      border: 1px solid black;
      background: #fff;
      padding: 1% 5%;
      margin-right: 3%;
    }

    /* 모달 */
    .panel {
      background-color: #444;
      height: 34px;
      padding: 10px;
    }

    a#exchange_pop {
      border: 1px solid black;
      color: black;
      display: block;
      padding: 1% 1%;
      margin-right: 3%;
      text-decoration: none;
    }

    a#exchange_pop:hover {
      border-color: rgb(155, 150, 150);
    }

    .overlay {
      background-color: rgba(0, 0, 0, 0.6);
      bottom: 0;
      cursor: default;
      left: 0;
      opacity: 0;
      position: fixed;
      right: 0;
      top: 0;
      visibility: hidden;
      z-index: 1;

      -webkit-transition: opacity .5s;
      -moz-transition: opacity .5s;
      -ms-transition: opacity .5s;
      -o-transition: opacity .5s;
      transition: opacity .5s;
    }

    .overlay:target {
      visibility: visible;
      opacity: 1;
    }

    .popup {
      background-color: #fff;
      border: 3px solid #fff;
      display: inline-block;
      left: 50%;
      opacity: 0;
      padding: 15px;
      position: fixed;
      text-align: justify;
      top: 40%;
      visibility: hidden;
      z-index: 10;

      -webkit-transform: translate(-50%, -50%);
      -moz-transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
      -o-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);

      -webkit-transition: opacity .5s, top .5s;
      -moz-transition: opacity .5s, top .5s;
      -ms-transition: opacity .5s, top .5s;
      -o-transition: opacity .5s, top .5s;
      transition: opacity .5s, top .5s;
    }

    .overlay:target+.popup {
      top: 50%;
      opacity: 1;
      visibility: visible;
    }

    .close {
      height: 30px;
      line-height: 30px;
      position: absolute;
      right: 0;
      text-align: center;
      text-decoration: none;
      top: 10px;
      right: 10px;
      width: 30px;
    }

    .close:before {
      color: black;
      content: "X";
      font-size: 24px;
      text-shadow: 0 -1px rgba(0, 0, 0, 0.9);
    }

    .popup p,
    .popup div {
      margin-bottom: 10px;
    }

    .popup label {
      display: inline-block;
      text-align: left;
      width: 120px;
    }

    .popup table tr {
      height: 40px;
    }

    .popup button {
      border: none;
      background: #11538C;
      color: white;
      padding: 1% 3%;
      text-align: center;
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
	      <span class="sub_content" style="font-size: 1.5em;">배송 조회</span>
	      <br><br><br>
	
	      <div class="delivery" style="width:80%;">
	        <table>
	          <tr>
	            <td style="width: 10%;" class="top bottom">주문 일자</td>
	            <td style="width: 40%;" class="top bottom">상품</td>
	            <td style="width: 20%;" class="top bottom">배송상태</td>
	            <td style="width: 20%;" class="top bottom">배송지 변경</td>
	            <td style="width: 20%;" class="top bottom">교환 신청</td>
	          </tr>
	          <tr>
	            <td>2020.08.06</td>
	            <td>무가당 드링킹 요거트</td>
	            <td>배송중</td>
	            <td><button>배송지 변경</button></td>
	            <td><a href="#exchange_form" id="exchange_pop">교환 신청</a></td>
	          </tr>
	          <tr>
	            <td>2020.08.06</td>
	            <td>무가당 드링킹 요거트</td>
	            <td>배송중</td>
	            <td><button>배송지 변경</button></td>
	            <td><a href="#exchange_form" id="exchange_pop">교환 신청</a></td>
	          </tr>
	
	        </table>
	      </div>
	
	      <!-- popup form #1 -->
	      <a href="#x" class="overlay" id="exchange_form"></a>
	      <div class="popup">
	        <h4>교환신청</h4>
	        <div>
	          <table>
	            <tr>
	              <td style="width: 100px;" class="top bottom">교환 사유</td>
	              <td class="top bottom">
	                <select style="width: 200px; height: 30px;">
	                  <option>품질불량</option>
	                  <option>주문상품과 다른 상품 배송</option>
	                  <option>기타</option>
	                </select>
	              </td>
	            </tr>
	            <tr>
	              <td colspan="2">
	                <br>
	                <textarea cols="50" rows="5"></textarea>
	              </td>
	            </tr>
	          </table>
	        </div>
	        <div style="text-align: center;">
	          <button>교환신청</button>
	        </div>
	        <a class="close" href="#close"></a>
	      </div>
	    </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>