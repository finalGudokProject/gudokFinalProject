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
  
   
   
    <title>이벤트 배너 리스트</title>    
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
                <h3>배너 리스트</h3>
                <br>
            
               
                <br>
                <br>
                <form>
                <div style="width:100%">
                <div style="float:left;">
                	<input type="button" class="btn" value="글 등록" onclick="location.href='eRegisterView.do'">
          			
                    <input type="button" class="btn" value="게시">
                    <input type="button" class="btn" value="중지">
                    <input type="button" class="btn" value="삭제"onclick="eventDelete()">
                </div>
                <div style="float:right;">
                	<input type="text">
                	<input type="button" class="btn" value="검색">
                </div>
                </div>
        <br><br>
        			<input type="hidden" name="array" value="">
                    <table>
                        <thead>
                            <tr>
                                <th><input type="checkbox" id="checkAll"></th>
                                <th id="td1">배너번호</th>
                                <th>이벤트 명</th>
                                <th>상품 수</th>
                                <th>상태</th>
                             
                             </tr>   
                         </thead>
                         <tbody>
                         	<c:forEach var="e" items="${list }" varStatus="status">
	                             <tr>
	                                <td><input type="checkbox" class="common" name="eventNo" value="${e.eventNo }"></td>
	                                <td>${e.eventNo }</td>
	                                <td>
	                                
	                                
	                                ${e.eventName }
	                                
	                                
	                                </td>
	                                <td>${eCountList[status.index] }</td>
	                                <td>${e.eventStatus }</td>
	                            </tr>
                            </c:forEach>
                           
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

				</form>	
            </div><!--내용담은 컨테이너-->
        </div><!--250px띄운 div-->
        
        
        
        <script>
        
         //선택 삭제
        	function eventDelete(){
        		alert("오잉?");
        		
        		var sendArr=Array();
        		alert("오잉?");
        		var sendCnt=0;
        		var chkbox=$(".common");
        		
        		for(i=0; i<chkbox.length;i++){
        			if(chkbox[i].checked==true){
        				sendArr[sendCnt]=chkbox[i].value;
        				sendCnt++;
        			}
        		}
        		
        		$("#array").val(sendArr);
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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>