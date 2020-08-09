<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>관리자 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


  <style>
    .container {
        width: 100%;
        height:1100px;
        
    }
    .content{
        margin-left:250px;
        background-color: RGB(237,237,237);
        
    
    }
    .mainBox{
        padding:5px; 
        background-color:  RGB(237,237,237);
        height:1100px;
       
    }
    .mainRow{
 
    display: flex;
    
    flex-wrap: wrap;
    }
    
    #maintd1{
        width:30%;
        height:270px;
    }

    #mainTable{
        width:100%;
        max-height:1000px;
    }

    #subBox1{
        width:98%; 
        height:260px; 
        background-color: white; 
        margin:auto;
        padding:10px;
      
    }
    #subBox2{
        width:99%; 
        height:800px; 
        background-color: white; 
        margin:auto;
        padding:30px;
        text-align:center;
    
    }

    .table{
        padding:50px;
        margin:auto;
        word-wrap:break-word;
        word-break:break-all;
        table-layout:fixed;
        
    }
    
    td{
      text-overflow: ellipsis;
        overflow:hidden;
		white-space:nowrap;
    }
   
   
    
   

    
    </style>
</head>
<body>

	<jsp:include page="../common/adminMenubar.jsp"/>
    <div class="content">
        <div class="mainBox">
            
            <table id="mainTable">
                <tr>
                    <td id="maintd1">
                        <div id="subBox1">
                            <div style="float:left; margin-bottom:5px;"><h5><b>미답변 문의</b></h5></div>
                            
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                            <br>
                            <br>
                        <table class="table">
                            
                            <tr>
                                <td style="width:68%">
                                  문의합니다1
                                </td>
                                <td style="width:32%">
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
                    </td>
                    <td id="maintd1">
                        <div id="subBox1">
                        <div style="float:left; margin-bottom:5px;"><h5><b>배송 대기</b></h5></div>
                            
                        <div class="mr-0" style="float:right;">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                        <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                        </svg></div> 
                   
                        <br>
                        <br>
                    <table class="table">
                        
                        <tr>
                            <td style="width:70%">
                                124-536
                            </td>
                            <td style="width:30%;">
                                2020-08-01
                            </td>
                        </tr>
                        <tr>
                            <td>
                                124-578
                            </td>
                            <td>
                                2020-08-01
                            </td>
                        </tr>
                        <tr>
                            <td>
                                124-987
                            </td>
                            <td>
                                2020-08-01
                            </td>
                        </tr>
                        <tr>
                            <td>
                                124-382
                            </td>
                            <td>
                                2020-08-01
                            </td>
                        </tr>
                    </table>
                    </div>
                    </td>



                    <td id="maintd1">
                        <div id=subBox1>
                            <div style="float:left;  margin-bottom:5px;"><h5><b>일일 방문 및 가입 현황</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                            <br>
                            <br>
                        <table  style="text-align: center; width:100%; margin:auto;" >
                            <tr>
                                <td style="padding:5px; background-color:rgb(149, 169, 229);">가입자 수</td>
                                <td style="padding:5px;background-color:rgb(195, 203, 226)">101 명</td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td style="padding:5px;background-color:rgb(149, 169, 229)">방문자 수</td>
                                <td style="padding:5px;background-color:rgb(195, 203, 226)">434 명</td>
                            </tr>
                            <tr>
                                <td colspan="5" style="height:130px"><div></div></td>
                            </tr>
                        </table>
                        <div>
                            구글차트 삽입예정
                        </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" rowspan="3">
                        <div id="subBox2"> 
                            <div style="float:left;margin-bottom:5px;"><h5><b>주간 매출 현황</b></h5></div>
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
                       <table class="table" style="border:1px solid lightgrey;margin:auto; width:100%">
                        <thead>
                        <tr>
                            <th>거래일자</th>
                            <th>매출액</th>
                            <th>거래건수</th>
                        </tr>
                    </thead>
                    <tbody>

                   
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
                    </tbody>
                         </table>
                        </div>
                    </td>
                    <td id="maintd1">
                        <div id="subBox1">
                            <div style="float:left;"><h5><b>이벤트 진행 건</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> 
                            <br><br>
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
                    </td>
                </tr>
                <tr>
                    <td id="maintd1">
                        <div id="subBox1">
                            <div style="float:left;"><h5><b>공지사항</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> <br><br>
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
                    </td>
                </tr>
                <tr>
                    <td id="maintd1">
                        <div id="subBox1">
                            <div style="float:left;"><h5><b>상품 제안</b></h5></div>
                            <div class="mr-0" style="float:right;">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
                            <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
                            </svg></div> <br><br>
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
                    </td>
                </tr>
            </table>

       


        </div><!--하얀바탕-->
    </div><!--회색바탕 div-->


</body>
</html>