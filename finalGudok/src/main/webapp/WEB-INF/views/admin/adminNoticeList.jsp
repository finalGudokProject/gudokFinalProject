<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<title></title>
<style>
          body{
      font-family: 'Jua', sans-serif;
    }
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
  button{
      background-color: rgb(0, 125, 255);
  }

  .container {
        width: 100%;
        margin-right: auto;
        margin-left: auto;
        margin:auto;
    }
    .content{
        margin-left:250px;
        background-color: RGB(237,237,237);
        padding:50px;
    
    }
    .box{
        padding:70px 70px 70px 70px; 
        
        background-color: #ffffff;
        height:1100px;
      
    }


    </style>
  </head>
  <body>
  
  <jsp:include page="../common/adminMenubar.jsp"/>

    <!-- 화면 -->
    <div class="content">
      <div class="container box">

        <div style="font-size: 30px;">공지사항</div>
        
        <form action="adminNoticeList.do" method="post" enctype="multipart/form-data">
            <div class="input-group" >
              <select class="custom-select" id="inputGroupSelect04" style="margin-left: 600px; width:50px" >
                <option selected>모두</option>
                <option value="1">제목</option>
                <option value="2">내용</option>
                <option value="3">제목+내용</option>
              </select>
              <input type="text" class="form-control" style="float:right; width:100px;height: 38px;">
              <div class="input-group-append" style="float:right; width: 75px; height: 38px;">
                <input type="submit" value="검색"  class="btn btn-primary">
              </div>
            </div>
            <br>

            
          <table style="text-align: center; margin-top:15px">
        <thead>
          <tr>
            <th><input type="checkbox">
            </th><th style="width:10%">번호</th>
            <th style="width:55%">제목</th>
            <th style="width:20%">작성일</th>
            <th style="width:10%">조회수</th>
          </tr>
        </thead>
        <tbody >
        <c:forEach var="b" items="${list }">
          <tr>
          		<td><input type="checkbox">
          		<td align="center">${b.rownum }</td>
				<td align="center">
					<c:url var="adminNoticeDetail" value="adminNoticeDetail.do">
						<c:param name="bBoard_no" value="${b.bBoard_no }"/>
						<c:param name="page" value="${pi.currentPage }"/>
					</c:url>
					<a href="${adminNoticeDetail }">${b.bTitle }</a>
				</td>
				<td align="center">${b.bWrite_date }</td>
				<td align="center">${b.bRead_num }</td>
          </tr>
		</c:forEach>
        </tbody>
      </table>
            <br><br>
            &nbsp;&nbsp;<a href="adminNoticeInsert.do" type="button" class="btn btn-primary" style="float:right;">글쓰기</a> 
            <input type="submit" value="삭제" class="btn btn-primary" style="float:right; margin-right: 10px;">
    </form>
            <br><br><br>

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

    </div><!--하얀박스 있는부분 끝-->
  </div><!--회색바탕 div-->
  

   




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>