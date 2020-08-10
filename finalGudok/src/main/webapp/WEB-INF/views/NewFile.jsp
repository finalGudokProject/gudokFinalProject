<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
	.starR{
     background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
     background-size: auto 100%;
     width: 30px;
     height: 30px;
     display: inline-block;
     text-indent: -9999px;
     cursor: pointer;
     margin:0 0 12px;
   }
   .starR.on{background-position:0 0;}
   
</style>
</head>
<body>
	<c:forEach var="i" items="${list }" varStatus="vs">
      <c:url var="idetail" value="idetail.do">
         <c:param name="itemNo" value="${i.itemNo }"/>
         <c:param name="page" value="${pi.currentPage }"/>
      </c:url>
      <fmt:formatNumber var="discountPrice" value="${(i.itemPrice - i.itemPrice*(i.itemDiscount/100))}" type="number"/>
      <fmt:formatNumber var="itemPrice" value="${i.itemPrice}" type="number"/>
         <div class="col-4" onclick="location.href='${idetail}'">
            <div class="card">
               <c:if test="${i.itemDiscount != 0}" >
               <div class="cardHeader">
                  <div class="circle">
                     <div id="ratePercentId" style="position:absolute;"><span>${i.itemDiscount }%</span></div>
                     <img src="resources/images/sale.png">
                  </div>
                  <img src="resources/images/breadLogo.jpg" class="card-img-top" alt="..." style="position:relative;">
               </div>
               </c:if>
               
               <c:if test="${i.itemDiscount == 0}">
               <div class="cardHeader">
               <img src="resources/images/breadLogo.jpg" class="card-img-top" alt="...">
               </div>
               </c:if>
               <div class="cardBody">
                  <h3 class="card-title"><b>${i.itemName }</b></h3>
                  <h5>${i.itemMemo }</h5>
                  <div class="itemPriceDiv">
                  <c:if test="${i.itemDiscount != 0}">
                     <s style="color:red;">${itemPrice }원</s>→${discountPrice }원
                  </c:if>
                  <c:if test="${i.itemDiscount == 0}">
                     ${itemPrice }원
                  </c:if>
                  </div>
                  
                  <div class="starRev">
                     <c:choose>
                        <c:when test="${i.itemRate == 0}">
                           <span class="starR">1</span>
                           <span class="starR">2</span>
                           <span class="starR">3</span>
                           <span class="starR">4</span>
                           <span class="starR">5</span>
                        </c:when>
                        <c:when test="${i.itemRate < 2 }">
                           <span class="starR on">1</span>
                           <span class="starR">2</span>
                           <span class="starR">3</span>
                           <span class="starR">4</span>
                           <span class="starR">5</span>
                        </c:when>
                        
                        <c:when test="${i.itemRate < 3 }">
                           <span class="starR on">1</span>
                           <span class="starR on">2</span>
                           <span class="starR">3</span>
                           <span class="starR">4</span>
                           <span class="starR">5</span>
                        </c:when>
                        
                        <c:when test="${i.itemRate < 4 }">
                           <span class="starR on">1</span>
                           <span class="starR on">2</span>
                           <span class="starR on">3</span>
                           <span class="starR">4</span>
                           <span class="starR">5</span>
                        </c:when>
                        
                        <c:when test="${i.itemRate < 5 }">
                           <span class="starR on">1</span>
                           <span class="starR on">2</span>
                           <span class="starR on">3</span>
                           <span class="starR on">4</span>
                           <span class="starR">5</span>
                        </c:when>
                        <c:otherwise>
                           <span class="starR on">1</span>
                           <span class="starR on">2</span>
                           <span class="starR on">3</span>
                           <span class="starR on">4</span>
                           <span class="starR on">5</span>
                        </c:otherwise>
                     </c:choose>
                    <div style="display:inline-block;color:gray;">(리뷰수:${i.reviewCount}개)</div>
                  </div>
                  
              
                    <div id="rateId">(평점 : ${i.itemRate }점 / 찜한 사람 : ${i.itemChoice }명)</div>
                  </div>
                  <div class="row">
                     <div class="col-4" id="btnBlank"></div>
                     <div class="col-4" style="padding:0px;">
                        <button class="btn btn-primary" style="width:100%;height:100%;" id="preview${vs.index}">상품평보기</button>
                        <input type="hidden" value="${i.itemNo }">
                     </div>
                     <div class="col-4" id="btnBlank"></div>
                  </div>
                  <div class="cardFooter"></div>
            </div>
         </div>
      </c:forEach>
      
      <script>
      	$(function(){
      		$(".card").on("click",function(){
      			alert("카드클릭");
      		})
      		
      		$(".btn").on("click",function(){
      			event.stopPropagation();
      			alert("버튼클릭");
      		})
      		
      	})
      </script>
</body>
</html>