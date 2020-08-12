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
	

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

	
   
    <title>상품 등록</title>    
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

/*summer note*/


</style>
</head>

    <body>
    <jsp:include page="../common/adminMenubar.jsp"/>
        <div class="content">
            <div class="container box">
                <h3>일반 상품 등록</h3>
                <br>
                <button>일반 상품</button>&nbsp;
                <button>이벤트 상품</button>
                <br><br>
                <table>
              
                    <tr>
                        <td id="td1" style="vertical-align: middle;">
                         	  상품명
                        </td>
                        <td colspan="3">
                                <select name="product" style="float:left;">
                                    <option value="0">카테고리를 선택하세요.</option>
                                    <option value="f1">음료</option>
                                    <option value="f2">유제품</option>
                                    <option value="f3">베이커리</option>
                                    <option value="f4">간편식</option>
                                    <option value="f5">건강식품</option>
                                    <option value="f6">다이어트식단</option>
                                    <option value="l1">홈데코</option>
                                    <option value="l2">바디케어</option>
                                    <option value="l3">생활용품</option>
                                </select>
                                <input type="text" name="itemName" style="width:100%; margin:3px;">
                        </td>
                       
                    </tr>
                    <tr>
                        <td id="td1">
                        	  상품 메모
                        </td>
                        <td colspan="3">
                            <input type="text" name="itemMemo" style="width:100%;">
                        </td>
                    </tr>
                    <tr>
                        <td id="td1">
                          	  가격
                        </td>
                        <td id="td2">
                            <input type="text" name="itemPrice"  style="width:100%;">
                        </td>
                        <td id="td3">
                            	추천 선택
                        </td>
                        <td id="td4">
                            <input type="radio" name="itemRecommend" value="F">&nbsp;여성 &nbsp; &nbsp; &nbsp;
                            <input type="radio" name="itemRecommend" value="M">&nbsp;남성 &nbsp; &nbsp; &nbsp;
                            <input type="radio" name="itemRecommend" value="C">&nbsp;공통

                        </td>

                    </tr>

                    <tr>
                        <td id="td1">제품 상세 정보</td>
                        <td colspan="3">
                            <textarea id="summernote" name="itemContent"></textarea>
                        </td>
                    </tr>
               


                </table>
                <br>
                <br>
            <div style="text-align: center;"><button>저장하기</button>&nbsp;
                <button id="btn">취소</button></div>
            </div><!--내용담은 컨테이너-->
        </div><!--250px띄운 div-->
        
        
    
        <script>
        
        $(function() {
        	//여기 아래 부분
        	
        	$('#summernote').summernote({
        		  height: 300,                 // 에디터 높이
        		  minHeight: null,             // 최소 높이
        		  maxHeight: null,             // 최대 높이
        		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
        		  lang: "ko-KR",					// 한글 설정
        		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
                  
        	});
        });
       
        $(function(){
	        $('#summernote').summernote({
	  		  toolbar:[
	  			    ['fontname', ['fontname']],
	  			    ['fontsize', ['fontsize']],
	  			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
	  			    ['color', ['forecolor','backcolor']],
	  			    ['table', ['table']],
	  			    ['para', ['ul', 'ol', 'paragraph']],
	  			    ['height', ['height']],//
	  			    ['insert',['picture','link','video']],
	  			    ['view', ['fullscreen', 'help']]
	  			  ],
	  			fontNames:['Arial','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
	  			fontSizes:['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
  	 	 });
       });
        
        
     	/* // 서머노트에 text 쓰기
        $('#summernote').summernote('insertText');


        // 서머노트 쓰기 비활성화
        $('#summernote').summernote('disable');

        // 서머노트 쓰기 활성화
        $('#summernote').summernote('enable');


        // 서머노트 리셋
        $('#summernote').summernote('reset');


        // 마지막으로 한 행동 취소 ( 뒤로가기 )
        $('#summernote').summernote('undo');
        // 앞으로가기
        $('#summernote').summernote('redo'); */
        </script>
        
        
       <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   
 
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>