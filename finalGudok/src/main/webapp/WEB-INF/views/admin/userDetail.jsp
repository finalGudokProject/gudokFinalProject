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
    <title>회원 상세 정보</title>    
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
    width:15%;
    vertical-align: middle;
}
#td4{
    width:35%;
    vertical-align: middle;
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
                <h3>회원 상세 정보</h3>
                <br>
            
            
                <h5 style="padding-left:25px; padding-bottom:10px;">- 회원 정보</h5>
          
                    <table>
                        <tr>
                            <td>회원 번호</td>
                            <td><input type="text" name="userId" value="" readonly></td>
                            <td>이메일</td>
                            <td><input type="text" name="Email"></td>
                        </tr>
                        <tr>
                            <td>이름</td>
                            <td><input type="text" name="userName" value="" readonly></td>
                            <td>전화번호</td>
                            <td><input type="text" name="phone"></td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td colspan="3"><input type="text" name="userName" value="" readonly style="width:87%"></td>
                        </tr>
                        <tr>
                            <td>적립금</td>
                            <td><input type="text" name="point" value=""></td>
                            <td>총 구매 금액</td>
                            <td><input type="text" name="purchase" readonly></td>
                        </tr>
                        <tr>
                            <td>가입일</td>
                            <td><input type="text" name="enroll" readonly></td>
                            <td>탈퇴일</td>
                            <td><input type="text" name="out" readonly></td>
                        </tr>




                    </table>

                    <br>
                    <h5 style="padding-left:25px; padding-bottom:10px;">-결제 내역</h5>
                    <table>
                        <thead>
                            <tr style="background-color:lightgray">
                                <th id="td1">결제일자</th>
                                <th>상품명</th>
                                <th>수량</th>
                                <th>결제금액</th>
                             </tr>   
                         </thead>
                         <tbody>
                             <tr>
                                <td>2020-08-01</td>
                                <td>키가 쑥쑥 우유</td>
                                <td>3</td>
                                <td>30,000</td>
                            </tr>
                            <tr>
                                <td>2020-07-29</td>
                                <td>키가 쑥쑥 치즈</td>
                                <td>5</td>
                                <td>70,000</td>
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