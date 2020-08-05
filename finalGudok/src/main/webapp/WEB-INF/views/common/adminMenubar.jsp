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
    <title>goose 관리자 페이지</title>    
    <style>
body{
    font-family: 'Noto Sans KR', sans-serif;
}

img{
    max-width: 100%; height: auto;
}

.container-fluid {
    width: 100%;
    padding-right: 0px;
    padding-left: 0px; 
    margin-right: 0;
    margin-left: 0;


}


div {
    display: block;
    
}

.flex-xl-nowrap {
    -ms-flex-wrap: nowrap!important;
    flex-wrap: nowrap!important;
}
.row {
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    margin-right: -15px;
    /* margin-left: -15px; */
}


.bd-sidebar {
    /* -ms-flex: 0 1 320px; */
    flex: 0 1 320px;
    position: fixed;
    
    z-index: 1000;
    height: 100vh;
    border-right: 1px solid rgba(0,0,0,.1);
    -ms-flex-order: 0;
    order: 0;
    border-bottom: 1px solid rgba(0,0,0,.1);
    width:250px;
    margin-left:0px;
    margin-top:0px;
}

.bd-content {
    -ms-flex-order: 1;
    order: 1; /*div순서*/
    margin-top:0;
  
}




.bd-links {
    display: block!important;
    max-height: calc(100vh - 9rem);
    height: 100vh;
    overflow-y: auto;
    /* padding-top: 1rem; */
    padding-bottom: 1rem;
    
    


   
}

.nav {
  
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    padding-left: 0;
    margin-bottom: 0;
    list-style: none;
   
    
}

ul {
    margin-top: 0.5rem;
    margin-bottom: 0.5rem;
    display: block;
    list-style-type: disc;
    margin-block-start: 1.5em;
    margin-block-end: 1.5em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 20px;
    line-height: 30px;
    
}

li{
    padding:0 40px;
    list-style: none;
}

.sd-btn{
    background-color:rgba(90,148,235,0.8);
    border:none;
}

 #content{
    overflow-y: auto;
    margin-left:250px;
    
} 
</style>
    <body>

     <div class="container-fluid">
        <div class="row flex-xl-nowrap">
            <div class="col-md-3 bd-sidebar" style="background-color: #C4C4C4; float:left; overflow-y:hidden; overflow-x:hidden">
                <img src="images/로고1.png" style="padding:30px 30px;">
                <h2 style="text-align: center; font-size: 18px;"><b>관리자</b>님, 환영합니다.</h2>
                <br>
                <div style="text-align:center">
                <button class="sd-btn" id="nav-home-btn">쇼핑몰 이동</button>
                &nbsp;
                <button class="sd-btn" id="nav-logout-btn">로그아웃</button>
            </div>
                  
                    <nav class="collapse bd-links">

                     <br>
                        
                        <div>
                            <ul><b>
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-archive-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M12.643 15C13.979 15 15 13.845 15 12.5V5H1v7.5C1 13.845 2.021 15 3.357 15h9.286zM6 7a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1H6zM.8 1a.8.8 0 0 0-.8.8V3a.8.8 0 0 0 .8.8h14.4A.8.8 0 0 0 16 3V1.8a.8.8 0 0 0-.8-.8H.8z"/>
                                  </svg>&nbsp;&nbsp;상품관리</b>
                                <li>상품 등록</li>
                                <li>판매 상품 리스트</li>
                                <li>메인 배너 관리</li>
                            </ul>
                        </div>
                        <div>
                            <ul><b>
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-people-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
                                  </svg>&nbsp;&nbsp;회원 관리</b>
                                <li>회원 리스트</li>
                                <li>탈퇴 내역</li>
                            </ul>
                        </div>
                        <div>
                            <ul><b>
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bar-chart-line-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <rect width="4" height="5" x="1" y="10" rx="1"/>
                                    <rect width="4" height="9" x="6" y="6" rx="1"/>
                                    <rect width="4" height="14" x="11" y="1" rx="1"/>
                                    <path fill-rule="evenodd" d="M0 14.5a.5.5 0 0 1 .5-.5h15a.5.5 0 0 1 0 1H.5a.5.5 0 0 1-.5-.5z"/>
                                  </svg>&nbsp;&nbsp;매출 관리</b>
                                <li>주문 / 배송 내역</li>
                                <li>교환 요청 내역</li>
                                <li>매출 통계 내역</li>
                            </ul>
                        </div>
                        <div>
                            <ul><b>
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-volume-up-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M11.536 14.01A8.473 8.473 0 0 0 14.026 8a8.473 8.473 0 0 0-2.49-6.01l-.708.707A7.476 7.476 0 0 1 13.025 8c0 2.071-.84 3.946-2.197 5.303l.708.707z"/>
                                    <path d="M10.121 12.596A6.48 6.48 0 0 0 12.025 8a6.48 6.48 0 0 0-1.904-4.596l-.707.707A5.483 5.483 0 0 1 11.025 8a5.483 5.483 0 0 1-1.61 3.89l.706.706z"/>
                                    <path d="M8.707 11.182A4.486 4.486 0 0 0 10.025 8a4.486 4.486 0 0 0-1.318-3.182L8 5.525A3.489 3.489 0 0 1 9.025 8 3.49 3.49 0 0 1 8 10.475l.707.707z"/>
                                    <path fill-rule="evenodd" d="M6.717 3.55A.5.5 0 0 1 7 4v8a.5.5 0 0 1-.812.39L3.825 10.5H1.5A.5.5 0 0 1 1 10V6a.5.5 0 0 1 .5-.5h2.325l2.363-1.89a.5.5 0 0 1 .529-.06z"/>
                                  </svg>&nbsp;&nbsp;고객센터 관리</b>
                                <li>공지사항</li>
                                <li>FAQ</li>
                                <li>상품제안</li>
                                <li>1:1문의</li>
                                <li>이벤트</li>
                            </ul>
                        </div>
                        
                    </nav>
           </div>
        </div>
        
        </div>
        
        
        
        
        
        
        
        
        
        
        
        <br><br><br><br><br><br><br><br><br><br><br>
        <br><br><br><br><br><br><br><br><br><br><br>
       <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>