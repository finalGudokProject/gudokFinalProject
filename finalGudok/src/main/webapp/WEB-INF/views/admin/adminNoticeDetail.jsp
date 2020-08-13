<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
  
  #list a{
    color:black;
    text-decoration: none;
  }
  button{
      background-color: rgb(0, 125, 255);
  }



    </style>
  </head>




  <body>
	<jsp:include page="../common/adminMenubar.jsp"/>
    <!-- 화면 -->
    <div class="content">
      <div class="container box">

        <div style="font-size: 30px;">공지사항</div>
        <hr style="border-color:rgb(0, 125, 255);">

            <form action="aNoticeInsert.do" method="post" enctype="multipart/form-data"><input type="submit" value="저장" class="btn btn-primary" style="float:right; margin-right: 10px;">
		      	<table style="margin-top:15px">
	                <thead style="text-align: center;">
	                  <tr>
	                    <th style="width:10%; padding:20px;">제목</th>
	                    <td style="width: 35%;">${board.bTitle }</td>
	                    <th style="width: 10%;">작성일</th>
	                    <td style="width: 10%;">${board.bWrite_date }</td>
	                    <th style="width: 5%;">조회수</th>
	                    <td style="width: 5%;">${board.bRead_num }</td>
	                  </tr>
	                </thead>
                	<tbody >
	                  <tr>
	                      <td colspan="6" style="height:auto; padding:5%">
	                        <span style="margin:auto">
	                        ${board.bContent }
	                        </span>
	                        <br><br>
	                        <center>
	                          	<c:if test="${!empty board.originalFileName }">
	                          		<img src="${contextPath }/resources/aNoticeUploadFiles/${board.renameFileName }">
								</c:if>
	                        </center>
	                      </td>
	                  </tr>
	                </tbody>
              	</table>
            <br><br>
            &nbsp;&nbsp;<a href="adminNoticeList.do" type="button" class="btn btn-primary" style="float:right;">목록으로</a>
            <a href="ad_notice_write.html" type="button" class="btn btn-primary" style="float:right;margin-right:10px">수정</a>
            <input type="submit" value="삭제" class="btn btn-primary" style="float:right; margin-right: 10px;">
   			</form>
            <br><br><br>

    </div><!--하얀박스 있는부분 끝-->
  </div><!--회색바탕 div-->
  

   




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>