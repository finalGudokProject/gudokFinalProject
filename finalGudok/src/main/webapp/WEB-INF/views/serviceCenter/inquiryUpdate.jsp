<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title></title>
<style>
    .list{
        margin:20px;
        list-style-type: none;
    }
    
  
  #list a{
    color:black;
    text-decoration: none;
  }
  button{
      background-color: rgb(0, 125, 255);
  }
  table {
    width: 100%;
    border: 1px solid #CCCCCC !important;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #CCCCCC !important;
  }
        body {margin: 10px;}
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
	<jsp:include page="../common/menubar.jsp"/>
	<br><br><br>
    <div class="container">
    <div class="row">
      <div class="col-3">
        <h1 align="center">고객센터</h1>
        <ul class="list" id="list">
            <li style="margin-bottom: 5%;"><img src="resources/images/Alert.png" style="width:20%; height:20%;margin-bottom:3%"><a href="noticeList.do">공지사항</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/FAQ.png" style="width:20%; height:20%;margin-bottom:3%"><a href="FAQList.do">FAQ</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/inquiary.png" style="width:20%; height:20%;margin-bottom:3%"><a style="color:rgb(0, 125, 255);" readonly>1:1문의</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/proposal.png" style="width:20%; height:20%;margin-bottom:3%"><a href="productProposalList.do">상품제안</a></li>
            <li style="margin-bottom: 5%;"><img src="resources/images/benefit1.png" style="width:20%; height:20%;margin-bottom:3%"><a href="tierOfBenefit.do">등급별 혜택</a></li>
        </ul>
      </div>
      <div class="col-9">
        
          <form action="rInquiryUpdate.do" method="post" enctype="multipart/form-data">
          	<input type="hidden" name="page" value="${currentPage }">
			<input type="hidden" name="bBoard_no" value="${board.bBoard_no }">
			<input type="hidden" name="iBoard_no" value="${inquiry.iBoard_no }">
			<input type="hidden" name="oBoard_no" value="${secret.oBoard_no }">			
			<input type="hidden" name="renameFileName" value="${board.renameFileName }">
			<input type="hidden" name="originalFileName" value="${board.originalFileName }">
            <div style="font-size: 30px;">1:1 문의</div>
            <hr style="border-color:rgb(0, 125, 255);">
            <table style="text-align: center; margin-top:15px">
                <tbody >
                    <tr>
                        <th style="width:10%; padding:20px;">문의유형 </th>
                        <td style="width: 39%;" colspan="3">
                        <c:if test="${inquiry.iBoard_type eq 'OPI' }">
                            <select name="iBoard_type" style="float:left; margin-left:35%; height:30px ;width:200px;" id="iBoard_type" name="iBoard_type">
                                <option value="">문의유형을 선택 해주세요</option>
                                <option value="OPI" selected>상품정보문의</option>
                                <option value="OEC">교환문의</option>
                                <option value="OAL">제휴</option>
                                <option value="ODL">배송문의</option>
                                <option value="OETC">기타문의</option>
                            </select>
                        </c:if>
                        <c:if test="${inquiry.iBoard_type eq 'OEC' }">
                            <select name="iBoard_type" style="float:left; margin-left:35%; height:30px ;width:200px;" id="iBoard_type" name="iBoard_type">
                                <option value="">문의유형을 선택 해주세요</option>
                                <option value="OPI">상품정보문의</option>
                                <option value="OEC" selected>교환문의</option>
                                <option value="OAL">제휴</option>
                                <option value="ODL">배송문의</option>
                                <option value="OETC">기타문의</option>
                            </select>
                        </c:if>
                        <c:if test="${inquiry.iBoard_type eq 'OAL' }">
                            <select name="iBoard_type" style="float:left; margin-left:35%; height:30px ;width:200px;" id="iBoard_type" name="iBoard_type">
                                <option value="">문의유형을 선택 해주세요</option>
                                <option value="OPI">상품정보문의</option>
                                <option value="OEC">교환문의</option>
                                <option value="OAL" selected>제휴</option>
                                <option value="ODL">배송문의</option>
                                <option value="OETC">기타문의</option>
                            </select>
                        </c:if>
                        <c:if test="${inquiry.iBoard_type eq 'ODL' }">
                            <select name="iBoard_type" style="float:left; margin-left:35%; height:30px ;width:200px;" id="iBoard_type" name="iBoard_type">
                                <option value="">문의유형을 선택 해주세요</option>
                                <option value="OPI">상품정보문의</option>
                                <option value="OEC">교환문의</option>
                                <option value="OAL">제휴</option>
                                <option value="ODL" selected>배송문의</option>
                                <option value="OETC">기타문의</option>
                            </select>
                        </c:if>
                        <c:if test="${inquiry.iBoard_type eq 'OETC' }">
                            <select name="iBoard_type" style="float:left; margin-left:35%; height:30px ;width:200px;" id="iBoard_type" name="iBoard_type">
                                <option value="">문의유형을 선택 해주세요</option>
                                <option value="OPI">상품정보문의</option>
                                <option value="OEC">교환문의</option>
                                <option value="OAL">제휴</option>
                                <option value="ODL">배송문의</option>
                                <option value="OETC" selected>기타문의</option>
                            </select>
                        </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th style="width:10%; padding:20px;">제목</th>
                        <td style="width: 39%;" colspan="3">
                            <textarea class="form-control" rows="1" style="resize: none;  margin-left:10%;width:550px;" name="bTitle">${board.bTitle }</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th style="width:15%; padding:20px;">비밀글 설정</th>
                        <td style="width: 39%;">
                        	<c:if test="${secret.oSecret eq 'Y' }">
                            <input type="radio" name="oSecret" id="open" value="Y" checked="checked">공개글
                            &nbsp;
                            <input type="radio" name="oSecret" id="close" value="N">비밀글
                        	</c:if>
                        	<c:if test="${secret.oSecret eq 'N' }">
                            <input type="radio" name="oSecret" id="open" value="Y">공개글
                            &nbsp;
                            <input type="radio" name="oSecret" id="close" value="N" checked="checked">비밀글
                        	</c:if>
                        	
                            </td>
                        <th style="width:15%; padding:20px;">비밀번호</th>
                        <td style="width: 39%;"><input type="password" id="oSecret_pwd" name="oSecret_pwd" value="${secret.oSecret_pwd }">
                        </td>
                    </tr>
                    <tr>
                        <th style="padding:20px;">내용</th>
                        <td colspan="3">
                        <textarea class="form-control" rows="20" style="resize: none;" name="bContent">${board.bContent }</textarea>
                        <br><br>
                        <c:if test="${!empty board.originalFileName }">
                        	<center>
                           		<img style="height:500px;width:500px"src="${contextPath }/resources/inquiryUploadFiles/${board.renameFileName }">
                        	</center>
                        </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th style="padding:20px;">이미지</th><td colspan="3"><div class="filebox bs3-primary preview-image">
                        <input class="upload-name" value="파일선택" disabled="disabled" style="width: 200px;">
                        <label for="input_file">업로드</label> 
                        <input type="file" id="input_file" name="uploadInquiry" class="upload-hidden">
                    </div>
                    </tr>
                </tbody>
              </table>
      

            <br><br>
             &nbsp;&nbsp;<a href="javascript:history.go(-1)" type="button" class="btn btn-primary" style="float:right;">이전으로</a>
            <input type="submit" value="수정하기" class="btn btn-primary" style="float:right; margin-right: 10px;">
            </form>
            </div>
            </div>
            </div>
        
            <br><br><br>
            <footer class="page-footer font-small indigo">
				<jsp:include page="../common/footer.jsp" />
			</footer>
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