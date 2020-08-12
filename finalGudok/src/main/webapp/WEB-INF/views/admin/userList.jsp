<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title>회원 리스트</title>    
    <style>



#td1{
    width:15%;
    vertical-align: middle;
}
#td2{
    width:35%;
    vertical-align: middle;
}
#td3{
    width:50%;
    vertical-align: middle;
    background-color: rgb(198, 224, 253);
}




input, select,textarea{
    border: 1px solid #CCCCCC;
}

</style>
</head>


    <body>
    <jsp:include page="../common/adminMenubar.jsp"/>
        <div class="content">
            <div class="container box">
                <h3>회원 리스트</h3>
                <br>
                <div>
                    <div style="width:40%; float:left; height:300px; background-color:lightsteelblue">구글차트</div>
                    <div style="width:25%; padding:10px; float:left;height:300px;">
                        <h5>등급별 현재 회원 수</h5>
                        
                        <table>
                            <tr>
                                <td>1등급</td>
                                <td id="td3">3명</td>
                            </tr>
                            <tr>
                                <td>2등급</td>
                                <td id="td3">5명</td>
                            </tr>
                            <tr>
                                <td>3등급</td>
                                <td id="td3">1명</td>
                            </tr>
                            <tr>
                                <td>4등급</td>
                                <td id="td3">30명</td>
                            </tr>
                            <tr>
                                <td>5등급</td>
                                <td id="td3">6명</td>
                            </tr>

                        </table>
                    </div>
                    <div style="width:35%; padding:10px; float:left;height:300px;">
                        <h5>등급별 최소 구매금액 및 적립율</h5>
                        
                        <table>
                            <tr>
                                <td style="width:34%">1등급</td>
                                <td id="td3" style="width:36%">0</td>
                                <td  style="width:26%">1%</td>
                            </tr>
                            <tr>
                                <td style="width:34%">2등급</td>
                                <td id="td3" style="width:36%">50,000</td>
                                <td  style="width:26%">1%</td>
                            </tr>
                            <tr>
                                <td style="width:34%">3등급</td>
                                <td id="td3" style="width:36%">100,000</td>
                                <td  style="width:26%">1%</td>
                            </tr>
                            <tr>
                                <td style="width:34%">4등급</td>
                                <td id="td3" style="width:36%">300,000</td>
                                <td  style="width:26%">1%</td>
                            </tr>
                            <tr>
                                <td style="width:34%">5등급</td>
                                <td id="td3" style="width:36%">1,000,000</td>
                                <td  style="width:26%">1%</td>
                            </tr>
                           

                        </table>
                    </div>
                </div>

                <div style="width:100%; margin-top:10px; margin-bottom:15px; text-align: right;">
                    
               
                <!-- 모달 -->

               
            <!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" id="btn" data-toggle="modal" data-target="#myModal">최소 구매금액 변경</button>
<button type="button" class="btn btn-primary btn-lg" id="btn" data-toggle="modal" data-target="#myModal2">최소 구매금액 변경</button>
  <!-- Modal 1-->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">최소 구매 금액</h4>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          
        </div>
        <div class="modal-body">
          <table>
            <tr>
                <td>
                    1등급
                </td>
                <td>
                    <input type="text" name="gradeP1"> 
                </td>
            </tr>
            <tr>
                <td>
                    1등급
                </td>
                <td>
                    <input type="text" name="gradeP1"> 
                </td>
            </tr>
            <tr>
                <td>
                    1등급
                </td>
                <td>
                    <input type="text" name="gradeP1"> 
                </td>
            </tr>
            <tr>
                <td>
                    1등급
                </td>
                <td>
                    <input type="text" name="gradeP1"> 
                </td>
            </tr>
    

          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
          <button type="button" class="btn btn-primary">저장</button>
        </div>
      </div>
    </div>
  </div>
<!-- Modal 2-->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">최소 구매 금액</h4>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          
        </div>
        <div class="modal-body">
          <table>
            <tr>
                <td>
                    적립율
                </td>
                <td>
                    <input type="text" name="gradeP1"> 
                </td>
            </tr>

          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
          <button type="button" class="btn btn-primary">저장</button>
        </div>
      </div>
    </div>
  </div>





                  <script>
                      $('#myModal').on('shown.bs.modal', function () {
                        $('#myInput').focus()
                        })
                  </script>


            

                <!--모달 끝-->
                </div><!--모달 버튼 감싸는 div-->



                <div style="margin-top:30px;margin-bottom:15px; float:right;">
                    <input type="text">
                    <button id="btn">검색</button>
                    
                </div>
                <br>
                <br>
            
        
                    <table>
                        <thead>
                            <tr>
                                <th id="td1">회원번호</th>
                                <th>아이디</th>
                                <th>총 구매금액</th>
                                <th>등급</th>
                                <th>가입일자</th>
                             </tr>   
                         </thead>
                         <tbody>
                             <tr>
                                <td>1</td>
                                <td>user01</td>
                                <td>15000</td>
                                <td>1등급</td>
                                <td>2020-08-01
                                </td>
                            </tr>
                            
                      
                            
                         </tbody>
                    </table>



                    <br>


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





            </div><!--내용담은 컨테이너-->
        </div><!--250px띄운 div-->
        
       <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>