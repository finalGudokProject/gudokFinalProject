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
    table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  
  #list a{
    color:black;
    text-decoration: none;
  }

/*페이징 처리용 cs*/
.pagination-t {
            display: flex;
            padding-left: 0;
            list-style: none;
            border-radius: 0.25rem;
        }

        .page-link-t {
            position: relative;
            display: block;
            padding: 0.5rem 0.75rem;
            margin-left: -1px;
            line-height: 1.25;
            color: black;
            background-color: #fff;
            border: 1px solid #dee2e6;
        }

        .page-link-t:hover {
            z-index: 2;
            color: #0056b3;
            text-decoration: none;
            background-color: #e9ecef;
            border-color: #dee2e6;
        }

        .page-link-t:focus {
            z-index: 3;
            outline: 0;
        }

        .page-item-t:first-child .page-link-t {
            border-top-left-radius: 0.25rem;
            border-bottom-left-radius: 0.25rem;
        }

        .page-item-t:last-child .page-link-t {
            border-top-right-radius: 0.25rem;
            border-bottom-right-radius: 0.25rem;
        }

        .page-item-t.active-t .page-link-t {
            z-index: 3;
            color: #fff;
            background-color: rgba(90,148,235,0.8);
            border-color:  rgba(90,148,235,0.8);
        }

        .page-item-t.disabled-t .page-link-t {
            color: #6c757d;
            pointer-events: none;
            cursor: auto;
            background-color: #fff;
            border-color: #dee2e6;
        }


        .sr-only-t {
            position: absolute;
            width: 1px;
            height: 1px;
            padding: 0;
            margin: -1px;
            overflow: hidden;
            clip: rect(0, 0, 0, 0);
            white-space: nowrap;
            border: 0;
        }

        .page-center {
            display: flex;
            justify-content: center;
            /*가운데 정렬*/
            align-items: center;
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
            <li style="margin-bottom: 5%;"><img src="resources/images/FAQ.png" style="width:20%; height:20%;margin-bottom:3%"><a id="FAQ" style="color:rgb(0, 125, 255);" readonly>FAQ</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/inquiary.png" style="width:20%; height:20%;margin-bottom:3%"><a id="inquiary"  href="sc_inquriary.html">1:1문의</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/proposal.png" style="width:20%; height:20%;margin-bottom:3%"><a id="product_proposal"  href="sc_proposal.html">상품제안</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/benefit.png" style="width:20%; height:20%;margin-bottom:3%"><a id="tier_benefit"  href="sc_benefit.html">등급별 혜택</a></li>
        </ul>
      </div>
      <div class="col-9">
        <div class="input-group" >
          <div style="font-size: 30px;">FAQ</div>
          <select class="custom-select" id="inputGroupSelect04" style="margin-left: 445px;">
            <option selected>모두</option>
            <option value="1">제목</option>
            <option value="2">내용</option>
            <option value="3">제목+내용</option>
          </select>
          <input type="text" class="form-control" style="float:right; width:100px;height: 38px;">
          <div class="input-group-append" style="float:right; width: 55px; height: 38px;">
            <button type="button" class="btn btn-primary" >검색</button>
          </div>
        </div>
         
        
        <table style="text-align: center; margin-top:15px">
      <thead>
        <tr>
          <th style="width:5%">번호</th>
          <th style="width: 35%;">제목</th>
          <th style="width: 10%;">작성일</th>
          <th style="width: 10%;">조회수</th>
        </tr>
      </thead>
      <tbody >
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
        <tr>
            <td>1</td><td>아이디 어떻게 찾나요?</td><td>2020.08.04</td><td>0</td>
        </tr>
      </tbody>
    </table>
    <br><br>
    <!------페이징 처리----->
    <div class="page-center">
      <ul class="pagination-t">

          <!-- disabled: 페이지 비활성화 -->
          <li class="page-item-t disabled-t"><a class="page-link-t" href="#"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-left" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
            </svg></a></li>

          <li class="page-item-t"><a class="page-link-t" href="#">1</a></li>

          <!-- disabled: 해당 버튼 활성화 -->
          <li class="page-item-t active-t" aria-current="page-t">
              <a class="page-link-t" href="#">2 <span class="sr-only">(current)</span></a>
          </li>
          <li class="page-item-t"><a class="page-link-t" href="#">3</a></li>
          <li class="page-item-t"><a class="page-link-t" href="#"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-right" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
            </svg></a></li>
      </ul>
    </div>
      </div>
    </div>
    <br><br><br><br><br>
    
    </div>
	
</body>
</html>