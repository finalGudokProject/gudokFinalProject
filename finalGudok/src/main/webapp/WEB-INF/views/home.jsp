<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
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

        .cardWrap{
          text-align: center;
        }

        .card{
          margin: 0 30px 0 30px;
          display: inline-block;
        }

        .carousel-inner > .item > img{
          height: 10px;
        }
        
    </style>
<body>
<jsp:include page="common/header.jsp"/>

<!-- 캐러셀 시작 -->
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="${contextPath }/resources/images/mainItemImg.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="${contextPath }/resources/images/mainItemImg.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="${contextPath }/resources/images/mainItemImg.jpg" class="d-block w-100" alt="...">
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
      <!-- 캐러셀 끝 -->

      <br><br><br><br><br>
<div class="container">
      <div class="row">
      <div class="cardWrap">
        <p style="font-size:2em;">오늘의 신상품</p>
        <br>

        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>

        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
      </div>
      <br><br>
      <div class="cardWrap">
        <p style="font-size:2em;">베스트 상품</p>
        <br>
		<div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
		</div>
      <br><br>
      
      <div class="cardWrap">
        <p style="font-size:2em;">지금 가장 핫한 상품</p>
        <br>
		<div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
</div>
      <br><br>
      <div class="cardWrap">
        <p style="font-size:2em;">베스트 상품</p>
        <br>
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        
        <div class="card" style="width: 18rem;">
          <img src="${contextPath }/resources/images/mainItemImg.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>
        </div>
</div>
</div>


<a href="itemPage.do">상품 페이지</a>







<jsp:include page="common/footer.jsp"/>
</body>
</html>
