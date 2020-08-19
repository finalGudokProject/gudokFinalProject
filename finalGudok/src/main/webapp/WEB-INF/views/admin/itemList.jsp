<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title>판매 상품 리스트</title>    
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
                <h3>판매 상품 리스트</h3>
                <br>
            
                <br><br>
                <div style="width:100%">
                <div style="float:left;">
                <select name="product" style="width:200px">
                    <option value="0">1차 카테고리</option>
                    <option value="food">푸드</option>
                    <option value="living">리빙</option>
                </select>
            &nbsp; 
                <select name="product" style="width:200px">
                    <option value="0">2차 카테고리</option>
                    <option value="banchan">반찬</option>
                    <option value="flower">꽃</option>
                </select>
                <input type="text">
                <button id="btn">검색</button>
                </div>
               <div style="float:right">
                <button id="btn">게시</button>&nbsp;
                <button id="btn">중지</button>&nbsp;
               </div>


            </div>
                <br>
                <br>
            
        
                    <table>
                        <thead>
                            <tr>
                                <th><input type="checkbox" name="itemNo"></th>
                                <th id="td1">상품번호</th>
                                <th>상품명</th>
                                <th>가격</th>
                                <th>상태</th>
                             </tr>   
                         </thead>
                         
                         <tbody>
                         <c:if test="${!empty itemList}">
                         	<c:forEach var="i" items="${itemList }" varStatus="cnt">
	                             <tr>
	                                <td><input type="checkbox" class="common" id="itemNo${cnt.index}" name="itemNo" value="${i.itemNo }"></td>
	                                <td>${i.itemNo }</td>
	                                <td>${i.itemName }</td>
	                                <td>${i.itemPrice }</td>
	                                <td>${i.itemDpStatus }</td>
	                            </tr>
                            </c:forEach>
                          </c:if>
                          <c:if test="${!empty itemList}">
                           	<tr>
                           		<td colspan="5">등록된 상품이 없습니다.</td>
                           	</tr>
                           </c:if>
                         </tbody>
                    </table>



                    <br>


                     <!------페이징 처리----->
                <div class="page-center">
                    <ul class="pagination-t">
                    
                    	<!-- 이전 -->
                        <c:if test="${pi.currentPage eq 1 }">
	                        <li class="page-item-t disabled-t"><a class="page-link-t"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-caret-left-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M3.86 8.753l5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z"/>
</svg></a></li>
						</c:if>
						 <c:if test="${pi.currentPage gt 1 }">
							<c:url var="blistBack" value="eList.do">
								<c:param name="page" value="${pi.currentPage-1 }"/>
							</c:url>
		                        <li class="page-item-t">
		                        <a class="page-link-t" href="${blistBack }">
		                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-caret-left-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path d="M3.86 8.753l5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z"/>
	</svg></a></li>
						</c:if>
						
						<!-- 번호들 -->
						<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
							
							<c:if test="${p eq pi.currentPage }">
	                       		<li class="page-item-t  active-t"><a class="page-link-t">${p }<span class="sr-only"></span></a></li>
							</c:if>
							
	                        <c:if test="${p ne pi.currentPage }">
	                        	<c:url var="blistCheck" value="eList.do">
	                        		<c:param name="page" value="${p }"/>
                        		</c:url>
		                        <li class="page-item-t"><a class="page-link-t" href="${blistCheck }">${p } <span class="sr-only"></span></a>
		                        </li>
		                    </c:if>
                        </c:forEach>
                        
                        
                        <!-- 이후 -->
                        <c:if test="${pi.currentPage eq pi.maxPage }">
	                        <li class="page-item-t disabled-t"><a class="page-link-t">
	                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-caret-right-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M12.14 8.753l-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
</svg></a></li>
						</c:if>
						 <c:if test="${pi.currentPage lt pi.maxPage }">
							<c:url var="blistAfter" value="eList.do">
								<c:param name="page" value="${pi.currentPage+1 }"/>
							</c:url>
	                        <li class="page-item-t">
	                        <a class="page-link-t" href="${blistAfter }">
	                       <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-caret-right-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M12.14 8.753l-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
</svg></a></li>
						</c:if>
                    </ul>

                </div>




            </div><!--내용담은 컨테이너-->
        </div><!--250px띄운 div-->
        
        
        <script>
        
        
        
        
        
        
        
        
      // 상태 변경 후 리스트 가져오기
        function getList(){
       	 var page=${pi.currentPage};
       	 
       	 $.ajax({
       		 
       	 	url:"eListChange.do", 
       	 	data:{"page":page},
       	 	dataType:"json",
       	 	success:function(data){
       	 		
       	 
       	 		$tableBody=$("tbody");
       	 		$tableBody.html("");
       	 		
       	 		var $tr;
       	 		var $eventNo;
       	 		var $eventName;
       	 		var $eventCnt;
       	 		var $eventStatus;
       	 		var $checkBox;
       	 		var $th;
       	 		
       	 				
       	 				for(var i in data.list){
       	 					
       	 				
       	 				$tr=$("<tr>");
       	 				$td=$("<td>");
       	 				$checkBox=$("<input type='checkbox' class='common' name='eventNo'>").val(data.list[i].eventNo);     	 			
       	 				$eventNo=$("<td>").text(data.list[i].eventNo);
       	 				$eventName=$("<td onclick='bDetail(data.bannerList[i].eventNo)'>").text(data.list[i].eventName);
       	 				$eventCnt=$("<td>").text(data.list[i].eventCnt);
       	 				$eventStatus=$("<td>").text(data.list[i].eventStatus);
       	 				
       	 				
       	 				$td.append($checkBox);
       	 				$tr.append($td);
       	 				$tr.append($eventNo);
       	 				$tr.append($eventName);
       	 				$tr.append($eventCnt);
       	 				$tr.append($eventStatus);
       	 				$tableBody.append($tr);
       	 				
       	 			}
       	 			
       	 		
       	 	},
       	 	error:function(request, status, errorData){
                   alert("error code: " + request.status + "\n"
	                           +"message: " + request.responseText
	                           +"error: " + errorData);
	                  }   
       	 	
       	 })
       	 
        }
       			
        
        </script>
        
       <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>