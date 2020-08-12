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
    <title>Hello, world!</title>    
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
                <h3>이벤트 상품 등록</h3>
                <br>
                <button>일반 상품</button>&nbsp;
                <button>이벤트 상품</button>
                <br><br>
                <table>
              
                    <tr>
                        <td id="td1" style="vertical-align: middle;">
                            이벤트 제목
                        </td>
                        <td colspan="3">
                                <select name="product" style="float:left;">
                                    <option value="0">이벤트를 선택하세요.</option>
                                    <option value="food">반찬</option>
                                    <option value="flower">꽃</option>
                                </select>
                        </td>     
                    </tr>
                    <tr>
                        <td id="td1">
                            할인율
                        </td>
                        <td colspan="3">
                            <input type="text" name="discount" style="float:left; width:35%"><label style="float:left"><b>&nbsp;&nbsp;%</b></label>
                        </td>
                    </tr>
                   
                </table>
                <br>
                <br>
                    <select name="product" style="width:30%">
                        <option value="0">1차 카테고리</option>
                        <option value="food">푸드</option>
                        <option value="living">리빙</option>
                    </select>
                &nbsp; 
                    <select name="product" style="width:30%">
                        <option value="0">2차 카테고리</option>
                        <option value="banchan">반찬</option>
                        <option value="flower">꽃</option>
                    </select>
                    
                  <br>
                  <br>  


                    <table>
                        <thead>
                            <tr>
                                <th id="td1">상품번호</th>
                                <th>상품명</th>
                                <th>가격</th>
                                <th>확인</th>
                             </tr>   
                         </thead>
                         <tbody>
                             <tr>
                                <td>1</td>
                                <td>꽃다발 왕 큰 꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>꽃다발</td>
                                <td>15000</td>
                                <td><input type="checkbox"></td>
                            </tr>
                         </tbody>
                    </table>


                    <br>


            <div style="text-align: center;"><button id="btn">저장하기</button></div>
            </div><!--내용담은 컨테이너-->
        </div><!--250px띄운 div-->
        
       <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>