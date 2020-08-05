<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>메인페이지</title>
    <style>
     
        
.table {
  width: 100%;
  /* margin-bottom: 1rem; */
  color: #212529;
}
.table th,
.table td {
  padding: 0.5rem 1rem;
  vertical-align: top;
  border-top: 1px solid #dee2e6;
  /* border-bottom: 1px solid #dee2e6; */
}




.box{
    position:absolute;
    padding:30px;
    background-color:white; 
    top:50%; 
    left:50%; 
    transform:translate(-50%,-50%);
}

        
    </style>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  </head>
  <body>
  
  
    <jsp:include page="common/adminMenubar.jsp"/>


	
       <!--내용-->
            <!-- <main class="col-md-9 col-xl-12 py-md-3 pl-md-5 bd-content" role="main">
                메인
            </main> -->
            <div id="content" style="background-color: RGB(237,237,237);">
            <div class="row" style="height:300px">
                <div class="col-4" style="position:relative;">
                    <div class="container box">
                            <div style="float:left;"><h5><b>미답변 문의</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                        <table class="table">
                            
                            <tr>
                                <td style="width:70%">
                                    문의합니다1
                                </td>
                                <td style="width:30%;">
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    문의합니다2
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    문의합니다3
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    문의합니다4
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                         
                        
                        </table>
                    </div>
                </div>
                <div class="col-4" style="position:relative;">
                    <div class="container box">
                            <div style="float:left;"><h5><b>미배송 건</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                        <table class="table">
                            
                            <tr>
                                <td style="width:70%">
                                    꽃 정기구독
                                </td>
                                <td style="width:30%;">
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    우유 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    빵 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    반찬 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                         
                        
                        </table>
                    </div>
                </div>
                
                <div class="col-4" style="position:relative;">
                    <div class="container box">
                            <div style="float:left;"><h5><b>일일 방문 및 가입 현황</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                            <br>
                            <br>
                        <table  style="text-align: center;" >
                            <tr>
                                <td style="padding:5px; background-color:rgb(149, 169, 229);">가입자 수</td>
                                <td style="padding:5px;background-color:rgb(195, 203, 226)">101 명</td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td style="padding:5px;background-color:rgb(149, 169, 229)">방문자 수</td>
                                <td style="padding:5px;background-color:rgb(195, 203, 226)">434 명</td>
                            </tr>
                            <tr>
                                <td colspan="5" style="height:130px"><div>구글차트 삽입예정</div></td>
                            </tr>
                        </table>
                         
        
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-8">
                    <div class="container box ml-0 mr-3 mb-3" style="width:97%; height:875px;">
                        <div style="float:left;"><h5><b>주간 매출 현황</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                        <br><br>
                        <div>구글차트 삽입</div>
                        <br>
                        <br>
                       <table style="border:1px solid lightgrey">
                        <tr>
                            <td>거래일자</td>
                            <td>매출액</td>
                            <td>거래건수</td>
                        </tr>
                        <tr>
                            <td>2020-08-01</td>
                            <td>100,000,000</td>
                            <td>3268</td>
                        </tr>
                        <tr>
                            <td>2020-08-02</td>
                            <td>21,000,000</td>
                            <td>652</td>
                        </tr>
                         </table>
                    </div>
                    
                </div>




                <div class="col-4">
                    <div class="row" style="position:relative; height:300px;">
                        <div class="container box">
                            <div style="float:left;"><h5><b>이벤트 진행 건</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                        <table class="table">
                            
                            <tr>
                                <td style="width:70%">
                                    꽃 정기구독
                                </td>
                                <td style="width:30%;">
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    우유 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    빵 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    반찬 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                         
                        
                        </table>
                    </div>
                    </div>
                    <div class="row" style="position:relative; height:300px;">
                        <div class="container box">
                            <div style="float:left;"><h5><b>공지사항</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                        <table class="table">
                            
                            <tr>
                                <td style="width:70%">
                                    꽃 정기구독
                                </td>
                                <td style="width:30%;">
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    우유 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    빵 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    반찬 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                         
                        </table>
                    </div>
                    </div>



                    <div class="row" style="position:relative; height:300px;">
                        <div class="container box">
                            <div style="float:left;"><h5><b>상품 제안</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                        <table class="table">
                            
                            <tr>
                                <td style="width:70%">
                                    꽃 정기구독
                                </td>
                                <td style="width:30%;">
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    우유 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    빵 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    반찬 정기구독
                                </td>
                                <td>
                                    2020-08-01
                                </td>
                            </tr>
                         
                        
                        </table>
                    </div>
                    </div>
                    
                </div>
                </div>
                
      <br><br><br>
      <hr>

	
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>
