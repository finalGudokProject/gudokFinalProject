<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title></title>
    <style>

    .list{
        margin:20px;
        list-style-type: none;
    }
    table {
    width: 100%;
    border: 1px solid #CCCCCC !important;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #CCCCCC !important;
  }

  button{
      background-color: rgb(0, 125, 255);
  }
  
    .container {
        width: 100%;
        margin-right: auto;
        margin-left: auto;
        margin:auto;
    }
    .content{
        margin-left:250px;
        background-color: RGB(237,237,237);
        padding:50px;
    
    }
    .box{
        padding:70px 70px 70px 70px; 
        
        background-color: #ffffff;
        height:1100px;
      
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
    width: 54px;
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
  background-color: rgb(0, 125, 255);
    border-color:  rgb(0, 125, 255);
    margin-bottom:0px;
}
  
</style>
</head>
<body>
 <c:set var="contextPath"
		value="${pageContext.servletContext.contextPath }" scope="application" />
	<jsp:include page="../common/adminMenubar.jsp"/>
	
    <div class="content">
      <div class="container box">

       
            <form action="eventUpdate.do" method="post" enctype="Multipart/form-data">
            	<input type="hidden" name="page" value="${currentPage }">
				<input type="hidden" name="bBoard_no" value="${board.bBoard_no }">
				<input type="hidden" name="renameFileName" value="${board.renameFileName }">
				<input type="hidden" name="originalFileName" value="${board.originalFileName }">
                <div style="font-size: 30px;">이벤트</div><br>
                <hr style="border-color:rgb(0, 125, 255);">
                <table style="text-align: center; margin-top:15px">
                    <tbody>
                        <tr>
                            <th style="width:10%; padding:20px;">제목</th>
                            <td style="width: 40%;" colspan="3">
                                <textarea class="form-control" rows="1" name="bTitle" style="resize: none;width:907px;">${board.bTitle }</textarea>
                            </td>
                        </tr>
                        <tr>
                            <th style="padding:20px;">내용</th>
                            <td colspan="3"><textarea class="form-control" rows="15" name="bContent" style="resize: none;">${board.bContent }</textarea>
                        	<br><br>
	                        <c:if test="${!empty board.originalFileName }">
		                        <center>
	                          		<img style="height:500px;width:500px" src="${contextPath }/resources/eventUploadFiles/${board.renameFileName }">
	                        	</center>
                        	</c:if></td>
                        </tr>
                        <tr>
                            <th style="padding:20px;">이미지</th><td colspan="3"><div class="filebox bs3-primary preview-image">
                            <input class="upload-name" value="파일선택" disabled="disabled" style="width: 200px;">
                            <label for="input_file">업로드</label> 
                            <input type="file" id="input_file" name="uploadEvent" class="upload-hidden"> 
                        </div>
                        </tr>
                    </tbody>
                  </table>
          
    
            <br><br>
            &nbsp;&nbsp;<a href="javascript:history.go(-1)" type="button" class="btn btn-primary" style="float:right;">이전으로</a>
            <input type="submit" value="수정하기" class="btn btn-primary" style="float:right; margin-right: 10px;">
            
            <br><br><br>
	        </form>

    </div><!--하얀박스 있는부분 끝-->
  </div><!--회색바탕 div-->
 

   




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  
    <script>
        $(document).ready(function(){
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
</body>
</html>