<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<title></title>
<style>
.list{
        margin:20px;
        list-style-type: none;
    }
    
  
  #list a{
    color:black;
    text-decoration: none;
  }
  button{
      background-color: rgb(0, 125, 255);
  }
  table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<br><br><br>
	
	<div class="container">
    <div class="row">
      <div class="col-3">
        <h1 align="center">고객센터</h1>
        <ul class="list" id="list">
            <li style="margin-bottom: 5%;"><img src="resources/images/Alert.png" style="width:20%; height:20%;margin-bottom:3%"><a id="notice" style="color:rgb(0, 125, 255);" readonly>공지사항</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/FAQ.png" style="width:20%; height:20%;margin-bottom:3%"><a id="FAQ"  href="sc_FAQ.html">FAQ</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/inquiary.png" style="width:20%; height:20%;margin-bottom:3%"><a id="inquiary"  href="sc_nquriary.html">1:1문의</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/proposal.png" style="width:20%; height:20%;margin-bottom:3%"><a id="product_proposal"  href="sc_proposal.html">상품제안</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/benefit.png" style="width:20%; height:20%;margin-bottom:3%"><a id="tier_benefit"  href="sc_benefit.html">등급별 혜택</a></li>
        </ul>
      </div>
      <div class="col-9">
        
          
            <div style="font-size: 30px;">공지사항</div>
            <hr style="border-color:rgb(0, 125, 255);">
            <table style="margin-top:15px">
                <thead style="text-align: center;">
                  <tr>
                    <th style="width:5%; padding:20px;">제목</th><td style="width: 35%;">공지사항</td>
                    <th style="width: 10%;">작성일</th><td style="width: 10%;">2020.08.05</td>
                  </tr>
                </thead>
                <tbody >
                  <tr>
                      <td colspan="4" style="height:auto; padding:5%">
                        <span style="margin:auto">제18조(“몰“의 의무)
                        <br>(1) “몰”은 법령과 이 약관이 금지하거나 공서양속에 반하는 행위를 하지 않으며 이 약관이 정하는 바에 따라 지속적이고, 안정적으로 재화 등을 제공하는데 최선을 다하여야 합니다.
                        <br>(2) “몰”은 이용자가 안전하게 인터넷 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함)보호를 위한 보안 시스템을 갖추어야 합니다.
                        <br>(3) “몰”이 재화 등에 대하여 「표시·광고의 공정화에 관한 법률」 제3조 소정의 부당한 표시·광고행위를 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 집니다.
                        <br>(4) “몰”은 이용자가 원하지 않는 영리목적의 광고성 전자우편, 앱푸쉬 등을 발송하지 않습니다.
                        </span>
                        <br><br>
                        <center>
                          <img src="resources/images/logo.png" >
                        </center>
                      </td>
                  </tr>
                </tbody>
              </table>

            <br><br><br>
            <a href="sc_notice.html" type="button" class="btn btn-primary" style="float:right;">목록으로</a>
            </div>
            </div>
            </div>
            
            <br><br><br>
</body>
</html>