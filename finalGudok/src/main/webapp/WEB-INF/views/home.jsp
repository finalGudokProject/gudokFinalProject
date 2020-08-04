<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>메인페이지</title>
</head>
<link rel="shortcut icon" type="image⁄x-icon" href="<%=request.getContextPath()%>/images/logo.png">
	<!-- 아이콘 -->
	<script src="https://kit.fontawesome.com/4b6b63d8f6.js" crossorigin="anonymous"></script>
	<!-- 제이쿼리 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<!-- popper 툴팁 -->
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<!-- 부트스트랩 스크립트(jQuery보다 아래 있어야함) -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">

   <style>
        /*상단 회원가입, 로그인, 고객센터 메뉴(#menu-list) */
        #menu-list{
          line-height: 3;
          text-align: right;
        }

		#menu-list > li{
          display: inline-block;
          margin-right: 50px;
        }
		
		#menu-list a{
          color:black;
        }
		
			
		/*나비바 각 카테고리(a태그) 간격조정*/
        .nav-link{
            margin : 0 60px 0 60px;
            color:black;
        }
		
		.nav-item:hover{
          cursor:pointer;
        }
       /*나비바 각 카테고리 간격 설정*/
        .navbar-nav{
            margin-left: 50px;
        }
        /*나비바 각 카테고리(글씨, 아이콘) 가운데 정렬*/
        .nav-item{
          text-align: center;
        }
        /*검색바 마진 설정*/
        #searchBar{
          margin-left: 50px;
          margin-right: 50px;
        }
        #food-menu, #living-menu{
          background-color: #f8f9fa;
          margin-left: 10px;
          border : none;
        }
        .dropdown:hover>.dropdown-menu {
          text-align: center;
          display: block;
        }
        
        .form-inline my-2 my-lg-0 > input{
            margin-left : 50px;
        }
        /*메인 */
        .cardWrap{
          text-align: center;
        }
        .cardWrap a{
          color: black;
        }
        .card{
          margin: 0 30px 0 30px;
          display: inline-block;
        }
        .carousel-inner > .item > img{
          height: 10px;
        }
        
        /*폰트 적용*/
        body{
          font-family: 'Jua', sans-serif;
        }
        
        .outer{
        	display:table;
        	width:100%;
        	height:100%;
        }
        .inner{
        	display:table-cell;
        	vertical-align:middle;
        	text-align:center;
        }
        
        .centered {
		  position: relative;
		  display: inline-block;
		 
		  width: 100%;
		  padding: 1em;
		}
		
		.card{
			margin:0 auto;
			float:none;
			margin-bottom:10px;
		}
    </style>
<body>
<jsp:include page="common/menubar.jsp"/>

<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="resources/images/carousel2.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="resources/images/flower.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="resources/images/salad.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

      <br><br><br><br><br>
	<div class="container-fluid">
	<div class="outer">
	<div class="inner">
	<div class="centered">
      <div class=cardWrap>
        <p style="font-size:2em;"><a href="#">오늘의 신상품 ></a></p>
        <br>
		<div class="row">
        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
      </div>
	</div>
      <br><br><br><br><br>

      <div class=cardWrap>
        <p style="font-size:2em;"><a href="#">베스트 상품 ></a></p>
        <br>
        <div class="row">
        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
      </div>
	</div>
      <br><br><br><br><br>

      <div class=cardWrap>
        <p style="font-size:2em;">지금 가장 핫한 상품</p>
        <br>
		<div class="row">
        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
      </div>
	</div>
      <br><br><br><br><br>

      <div class=cardWrap>
        <p style="font-size:2em;text-align:center;">JM's 추천</p>
        <br>
		<div class="row" style="text-align:middle;">
        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <a href="#"><img src="resources/images/salad1.jpg" class="card-img-top" alt="..."></a>
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
      </div>
      </div>
	</div>
	</div>
	</div>
	</div>
      <br><br><br>
      <hr>



<jsp:include page="common/footer.jsp"/>
</body>
</html>
