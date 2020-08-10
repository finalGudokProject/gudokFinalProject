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
    <title>교환 신청 리스트</title>    
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
                <h3>교환 신청 리스트</h3>
                <br>
    
                <div>
                    <div style="width:60%; float:left; height:300px; background-color:lightsteelblue">구글차트</div>
                    <div style="width:40%; padding:10px; float:left;height:300px;">
                        <h5>교환 사유</h5>
                        
                        <table>
                            <tr>
                                <td>품질 문제</td>
                                <td id="td3">3명</td>
                            </tr>
                            <tr>
                                <td>배송 문제</td>
                                <td id="td3">5명</td>
                            </tr>
                            <tr>
                                <td>서비스</td>
                                <td id="td3">1명</td>
                            </tr>
                            <tr>
                                <td>이벤트</td>
                                <td id="td3">30명</td>
                            </tr>
                            <tr>
                                <td>기타</td>
                                <td id="td3">6명</td>
                            </tr>

                        </table>
                    </div>
                    
                </div>

                
                    
                    
                    <div style="width:100%; margin-top:30px; margin-bottom:15px; float:right; text-align:right;">
                        <select name="out">
                            <option value="quality">교환 대기</option>
                            <option value="delivery">배송중</option>
                            <option value="service">교환 완료</option>
                            <option value="etc">기타</option></select>
                        <input type="text">   
                        <button id="btn">검색</button>
                    </div>
                    <button id="btn1">대기</button>&nbsp;
                                    <button id="btn1">배송</button>&nbsp;
                                    <button id="btn1">완료</button>
                
                <br>
                <br>
            
        
                    <table>
                        <thead>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th id="td1">신청 일자</th>
                                <th>주문 번호</th>
                                <th>상품명</th>
                                <th>구매자</th>
                                <th>상태</th>
                             </tr>   
                         </thead>
                         <tbody>
                             <tr>
                                <th><input type="checkbox"></th>
                                <th>2020-07-29</th>
                                <td>1</td>
                                <td>꽃다발 왕 큰 꽃다발</td>
                                <td>user01</td>
                                <td>교환 대기중</td>
                            </tr>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th>2020-07-29</th>
                                <td>2</td>
                                <td>라떼엔 부드러운 우유</td>
                                <td>user01</td>
                                <td>교환 대기중</td>
                                
                            </tr>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th>2020-07-29</th>
                                <td>3</td>
                                <td>폭신폭신 이불</td>
                                <td>user01</td>
                                <td>교환 대기중</td>
                                
                            </tr>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th>2020-07-29</th>
                                <td>4</td>
                                <td>향기로운 디퓨저</td>
                                <td>user01</td>
                                <td>교환 대기중</td>
                               
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