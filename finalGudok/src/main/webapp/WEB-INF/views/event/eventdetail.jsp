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
        body {margin: 10px;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<br><br><br>
    <div class="container">
            <h1 align="center">이벤트</h1>
            <br>
            <hr style="border-color:rgb(0, 125, 255);"><br>
            <table style="margin-top:15px">
                <tbody >
                <tr>
                    <th style="width:200px; padding:20px; text-align: center;">제목</th>
                    <td style="text-align: center;" colspan="3">커피 할인 이벤트</td>
                </tr>
                <tr>
	              	<td colspan="2" style="height:auto; padding:5%">
	                <span style="margin:auto">쓰레기야!</span>
	                <br><br>
	                <center>
	                	<img style="width:900px;height:500px"src="resources/images/salad2.jpg" >
	                </center>
	                </td>
              	</tr>                          
                    
                </tbody>
              </table>
              <br><br>
      

            <br><br><br>
            <a href="sc_proposal.html" type="button" class="btn btn-primary" style="float:right;">목록으로</a>
            </div>

            <br><br><br>
</body>
</html>