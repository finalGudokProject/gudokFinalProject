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


/*파일첨부 이미지*/
.where {
  display: block;
  margin: 25px 15px;
  font-size: 11px;
  color: #000;
  text-decoration: none;
  font-family: verdana;
  font-style: italic;
} 

.filebox input[type="file"] {
    position: absolute;
    width: 1px;
    height: 1px;
    padding: 0;
    margin: -1px;
    overflow: hidden;
    clip:rect(0,0,0,0);
    border: 0;
}

.filebox label {
    display: inline-block;
    padding: .5em .75em;
    color: #999;
    font-size: inherit;
    line-height: normal;
    vertical-align: middle;
    background-color: #fdfdfd;
    cursor: pointer;
    border: 1px solid #ebebeb;
    border-bottom-color: #e2e2e2;
    border-radius: .25em;
    margin-bottom:0px !important;
}

/* named upload */
.filebox .upload-name {
    display: inline-block;
    padding: .5em .75em;
    font-size: inherit;
    font-family: inherit;
    line-height: normal;
    vertical-align: middle;
    background-color: #f5f5f5;
  border: 1px solid #ebebeb;
  border-bottom-color: #e2e2e2;
  border-radius: .25em;
  -webkit-appearance: none; /* 네이티브 외형 감추기 */
  -moz-appearance: none;
  appearance: none;
}

/* imaged preview */
.filebox .upload-display {
    margin-bottom: 5px;
}

@media(min-width: 768px) {
    .filebox .upload-display {
        display: inline-block;
        margin-right: 5px;
        margin-bottom: 0;
    }
}

.filebox .upload-thumb-wrap {
    display: inline-block;
    width: 350px;
    padding: 2px;
    vertical-align: middle;
    border: 1px solid #ddd;
    border-radius: 5px;
    background-color: #fff;
}

.filebox .upload-display img {
    display: block;
    max-width: 100%;
    width: 100% \9;
    height: auto;
}

.filebox.bs3-primary label {
  color: #fff;
  background-color: #337ab7;
    border-color: #2e6da4;
}



</style>
</head>

    <body>
    <jsp:include page="../common/adminMenubar.jsp"/>
        <div class="content">
            <div class="container box">
                <h3>일반 상품 등록</h3>
                <br>
                <button type="button" onclick="location.href='iInsertView.do'">일반 상품</button>&nbsp;
                <button type="button" onclick="location.href='eInsertView.do'">이벤트 상품</button>
                <br><br>
                
          		<form action="iInsert.do" method="post" encType="multipart/form-data" onsubmit="return validate()">
                <table>
              
                    <tr>
                        <td id="td1" style="vertical-align: middle;">
                         	  상품명
                        </td>
                        <td colspan="3">
                                <select name="categoryNo" id="category" style="float:left;">
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
                                <input type="text" name="itemName" id="itemName" style="width:100%; margin:3px;">
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
                            <input type="text" name="itemPrice" id="itemPrice" style="width:100%;">
                        </td>
                        <td id="td3">
                            	추천 선택
                        </td>
                        <td id="td4">
                            <input type="radio" name="itemRecommend" id="itemRecommend" value="F">&nbsp;여성 &nbsp; &nbsp; &nbsp;
                            <input type="radio" name="itemRecommend" id="itemRecommend" value="M">&nbsp;남성 &nbsp; &nbsp; &nbsp;
                            <input type="radio" name="itemRecommend" id="itemRecommend" value="C">&nbsp;공통

                        </td>

                    </tr>

                    <tr>
                        <td id="td1">제품 상세 이미지</td>
                        <td colspan="3">
                            <div class="filebox preview-image"> 
                                <input class="upload-name" value="파일선택" disabled="disabled" > 
                                <label for="input-file">업로드</label> 
                                <input type="file" id="input-file" class="upload-hidden" name="uploadFile" accept="image/*" title="이미지 파일만 업로드 가능"> 
                         	</div>
                        </td>
                    </tr>
                </table>
                
                <br>
                <br>
                
            <div style="text-align: center;">
           		<button type="submit">저장하기</button>&nbsp;
                <button type="reset">취소</button>
            </div>
            </form>
            
            </div><!--내용담은 컨테이너-->
        </div><!--250px띄운 div-->
        
        
    
  
        <script>
        
        //상품 등록시 필요정보 공백 제한
        function validate(){
        
    	if($("#category").val().trim().length==1){
	    		alert('카테고리를 선택해주세요.');
	    		$("#category").focus();
    		
    		return false;
    		
    	}else if($("#itemName").val().trim().length==0){
    			alert('상품명을 입력하세요.')
    		
    		return false;
    		
    	}else if($("#itemPrice").val().trim().length==0){
    			alert('가격을 입력하세요.')
    		
    		return false;
    		
    	}else if($("#itemRecommend").val().trim().length==0){
    			alert('추천 유형을 선택하세요.')
    		
    		return false;
    			
    	}else if(!$("#input-file").val()){
			alert('상품 이미지를 선택하세요.')
		
		return false;
		
    	}else{
    		alert('상품이 등록되었습니다.');
    		return true;
    	}
    	
    	
    };
        
        
    //가격 문자 입력 제한 및 3자리마다 콤마
        $(function() {

         $('input[name=itemPrice]').css('imeMode','disabled').keypress(function(event){
          if(event.which && (event.which<48||event.which>57)){
           event.preventDefault();
          }
         }).keyup(function(){
          if( $(this).val() != null && $(this).val() != '' ){
           $(this).val( $(this).val().replace(/[^0-9]/g, ''));
          
          }
         });
         
         
         });
         
       
         
    
    
        // 파일 업로드 관련
        $(function(){
       var fileTarget = $('.filebox .upload-hidden');

        fileTarget.on('change', function(){
            if(window.FileReader){
                // 파일명 추출
                var filename = $(this)[0].files[0].name;
            } 
            
            else {
                // Old IE 파일명 추출
                var filename = $(this).val().split('/').pop().split('\\').pop();
            };

            $(this).siblings('.upload-name').val(filename);
        });

       		 //preview image 
        var imgTarget = $('.preview-image .upload-hidden');

        imgTarget.on('change', function(){
            var parent = $(this).parent();
            parent.children('.upload-display').remove();

            if(window.FileReader){
                //image 파일만
                if (!$(this)[0].files[0].type.match(/image\//)) return;
                
                var reader = new FileReader();
                reader.onload = function(e){
                    var src = e.target.result;
                    parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
                }
                reader.readAsDataURL($(this)[0].files[0]);
            }

            else {
                $(this)[0].select();
                $(this)[0].blur();
                var imgSrc = document.selection.createRange().text;
                parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

                var img = $(this).siblings('.upload-display').find('img');
                img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";        
            }
        });
    });
        
        
            </script>
     
        
       <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   
 
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>