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
    border: 1px solid #CCCCCC !important;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #CCCCCC !important;
  }
  body {
    margin: 10px;
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
            <li style="margin-bottom: 5%;"><img src="resources/images/Alert.png" style="width:20%; height:20%;margin-bottom:3%"><a id="notice" href="sc_notice.html">공지사항</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/FAQ.png" style="width:20%; height:20%;margin-bottom:3%"><a id="FAQ"  href="sc_FAQ.html">FAQ</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/inquiary.png" style="width:20%; height:20%;margin-bottom:3%"><a id="inquiary" style="color:rgb(0, 125, 255);" readonly>1:1문의</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/proposal.png" style="width:20%; height:20%;margin-bottom:3%"><a id="product_proposal"  href="sc_proposal.html">상품제안</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/mages/benefit.png" style="width:20%; height:20%;margin-bottom:3%"><a id="tier_benefit"  href="sc_benefit.html">등급별 혜택</a></li>
        </ul>
      </div>
      <div class="col-9">
        
          <form>
            <div style="font-size: 30px;">1:1 문의</div>
            <hr style="border-color:rgb(0, 125, 255);">
            <table style="margin-top:15px">
                <tbody >
                    <tr>
                        <th style="width:10%; padding:20px;text-align: center;">문의유형</th>
                        <td style="width:39%;text-align:center;" colspan="3"> 상품정보문의</td>
                    </tr>
                    <tr>
                        <th style="width:10%; padding:20px;text-align: center;">제목</th>
                        <td style="width:39%;text-align:center;" colspan="3">이게 뭐야?</td>
                    </tr>
                    <tr>
                        <th style="width:15%; padding:20px;text-align: center;">작성자</th>
                        <td style="width:39%;text-align:center;">클템</td>
                        <th style="width:15%; padding:20px;text-align: center;">비밀글 설정</th>
                        <td style="width:39%;text-align:center;">공개글</td>
                    </tr>
                    <tr>
                        <td colspan="4" style="height:auto; padding:5%">
                        <span style="margin:auto">쓰레기야!</span>
                        <br><br>
                        <center>
                            <img style="width:700px;height:500px" src="resources/images/salad3.jpg" >
                        </center>
                        </td>
                    </tr>              
                </tbody>
              </table>
              <br><br>
              
              <table style="margin-top:15px">
                <tr>
                  <th style="width:15%; padding:20px;text-align: center;" colsapn="1">답변</th>
                  <td colspan="3" style="height:auto; padding:5%">에욱</td>
                </tr>
              </table>
      
            </form>
            <br><br><br>
            <a href="sc_inquriary.html" type="button" class="btn btn-primary" style="float:right;">목록으로</a>
            <input type="submit" value="수정하기" class="btn btn-primary" style="float:right; margin-right: 10px;">&nbsp;&nbsp;
            </div>
            </div>
        	</div>
            <br><br><br>
</body>
</html>