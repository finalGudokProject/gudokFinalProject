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
    <title>이벤트 상품 등록</title>    
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
                <button type="button" class="btn" onclick="location.href='iInsertView.do'">일반 상품</button>&nbsp;
                <button type="button" class="btn" onclick="location.href='iEventInsertView.do'">이벤트 상품</button>
                <br><br>
                
                
             
                <table>
              
                    <tr>
                        <td id="td1" style="vertical-align: middle;">
                           	 이벤트 제목
                        </td>
                        <td colspan="3">
                                <select id="eventNo" name="eventNo" style="float:left;">
                                    <c:forEach var="i" items="${eArr }">
	                                    <option value="${i.eventNo }">${i.eventName }</option>
                                    </c:forEach> 
                                </select>
                        </td>     
                    </tr>
                    <tr>
                        <td id="td1">
                          	  할인율
                        </td>
                        <td colspan="3">
                            <input type="number" min="0" max="100" id="itemDiscount" name="itemDiscount" style="float:left; width:35%" value=""><label style="float:left"><b>&nbsp;&nbsp;%</b></label>
                        </td>
                    </tr>
                   
                </table>
                <br>
                <br>
                 <label style="margin-left:20px; margin-bottom:10px;font-size:20px;"><b>이벤트 미등록 상품</b></label>
                 <div style="float:right;">
                    <select name="product" style="width:45%">
                        <option value="0">1차 카테고리</option>
                        <option value="food">푸드</option>
                        <option value="living">리빙</option>
                    </select>
                &nbsp; 
                    <select name="product" style="width:45%">
                        <option value="0">2차 카테고리</option>
                        <option value="banchan">반찬</option>
                        <option value="flower">꽃</option>
                    </select>
                  </div>
                  <br>
                
                   

                    <table>
                        <thead >
                            <tr>
                                <th>상품번호</th>
                                <th>상품명</th>
                                <th>가격</th>
                                <th>평점</th>
                                <th><input type="checkbox" id="checkAll"  onclick="event.cancelBubble=true"></th>
                             </tr>   
                         </thead>
                         <tbody id="chgTable">
                         
                         
                         <c:forEach var="i" items="${list }" varStatus="cnt">
                             <tr id="cursor">
                                <td>${i.itemNo }</td>
                                <td>${i.itemName }</td>
                                <td>${i.itemPrice }</td>
                                <td>${i.itemRate }</td>
                                <td><input type="checkbox"  class="common" id="itemNo${cnt.index }" name="itemNo" value="${i.itemNo }"></td>
                            </tr>
                         </c:forEach>   
                            
                            
                            
                            
                         </tbody>
                    </table>
 				<div style="text-align: right;"><input type="button" class="btn" value="저장하기" onclick="save()"></div>
				
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
							<c:url var="blistBack" value="iEventInsertView.do">
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
	                        	<c:url var="blistCheck" value="iEventInsertView.do">
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
							<c:url var="blistAfter" value="iEventInsertView.do">
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
        //이벤트 상품 등록 시 공백 제한
        function save(){
        	
        
    	if($("#itemDiscount").val().trim().length==0){
	    		alert('할인율을 입력해주세요.(정수 0~100)');
	    		$("#itemDiscount").focus();
    
    	}else{
    		
    		var sendArr=Array();
    		var sendCnt=0;
    		var chkbox=$(".common");
    		var page=${pi.currentPage};
    		var eventNo=$("#eventNo").val();
    		var itemDiscount=$("#itemDiscount").val();
    		
    		for(i=0; i<chkbox.length;i++){
    			if(chkbox[i].checked==true){
    				sendArr[sendCnt]=chkbox[i].value;
    				sendCnt++;
    			}
    		}
    		
    		if(sendCnt=0){
    			alert('등록할 상품을 선택하세요.');
    		}
    		
    		$.ajax({
				url:"eventItemInsert.do",
				traditional:true,
				data:{"sendArr":sendArr,"page":page,"eventNo":eventNo,"itemDiscount":itemDiscount},
				success:function(data){
					
					getList();
					        					
				},
				error:function(request, status, errorData){
                    alert("error code: " + request.status + "\n"
	                           +"message: " + request.responseText
	                           +"error: " + errorData);
	                  }   
			});
    		
    	} 
    		
    	/*------------------------------------------------------------------*/	
    		
    		
    
    	}
    	
    	

    
    
 // 상태 변경 후 리스트 가져오기
    function getList(){
   	 var page=${pi.currentPage};
   	 
   	 $.ajax({
   		 
   	 	url:"eventItemListChange.do", 
   	 	type:"POST",
   	 	data:{"page":page},
   	 	dataType:"json",
   	 	success:function(data){
   	 		
   	 	  
   	 		
   	 		//게시물 상세보기(ajax후)
   	        
   	        	$(function(){

   	       		$("#cursor").on("click",function(){
   	       			var itemNo=$(this).children().eq(1).text();
   	        		 var page=${pi.currentPage };   
   	        		
   	           		location.href="itemDetail.do?itemNo="+itemNo+"&page="+page;
   	       		})
   	        	
   	       	}) 
   	       	
   	 		$tableBody=$("#chgTable");
   	 		$tableBody.html("");
   	 		
   	 		var $tr;
   	 		var $eventNo;
   	 		var $eventName;
   	 		var $eventCnt;
   	 		var $eventStatus;
   	 		var $checkBox;
   	 		var $th;
   	 	
   	 				for(var i in data.list){
   	 					
   	 				$tr=$("<tr id='cursor'>");
   	 				$td=$("<td onclick='event.cancelBubble=true'>");
   	 				$checkBox=$("<input type='checkbox' class='common' name='itemNo'>").val(data.list[i].itemNo);     	 			
   	 				$eventNo=$("<td onclick='event.cancelBubble=true'>").text(data.list[i].itemNo);
   	 				$eventName=$("<td>").text(data.list[i].itemName);
   	 				$eventName.attr('id','test');
   	 				$eventCnt=$("<td onclick='event.cancelBubble=true'>").text(data.list[i].itemPrice+'원');
   	 				$eventStatus=$("<td onclick='event.cancelBubble=true'>").text(data.list[i].itemRate);
   	 				
   	 				
   	 				$td.append($checkBox);
   	 			
   	 				$tr.append($eventNo);
   	 				$tr.append($eventName);
   	 				$tr.append($eventCnt);
   	 				$tr.append($eventStatus);
   	 				$tr.append($td);
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
			
			
        
        
      //모두 체크

	 	$(function(){
	
			$("#checkAll").click(function(){
				var bool = $(this).prop("checked");
				$(".common").prop('checked', bool);
			});
		}); 
        
        </script>
        
       <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
     <script src="https://code.jquery.com/jquery-3.4.1.js" type="text/javascript"></script>
    <script integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>