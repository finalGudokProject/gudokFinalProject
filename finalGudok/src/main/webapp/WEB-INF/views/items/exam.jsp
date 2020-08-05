<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="../common/menubar.jsp"/>

		<table class="fileAddClass">
		<thead>
			<tr style="vertical-align:middle;margin-bottom:0.5%;">
				<td><img src="${contextPath }/resources/images/plus.png" style="width:30px;height:30px;margin-bottom:0.3rem;" class="fileImgBtn" id="fileAddBtn"></td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
		</table>
	<script>
		var count = 1;
		var removeImgId = null;
		$(function(){
			$("#fileAddBtn").click(function(){
				if(count < 3){
					console.log(count);
					count++;
					removeImgId = "minusImgId" + count;
					
					$(".fileAddClass > tbody:last").
					append("<tr><td>"+"<img src='${contextPath }/resources/images/minus.png' style='width:30px;height:30px;' class='fileImgBtn' id='removeImgId'></td>"+
							"<td><input type='file' name='uploadFile'></td></tr>");
				}else{
					alert("파일은 3개까지 등록 가능합니다.")
				}
			});
			$("#removeImgId").on("click", function(){
				console.log("나는 찍힌다.");
				$(this).parent().remove();
			}) 
		})
		
		
		
		/* function removeBtn2(){
			$("#minusImgId2").parent().parent().remove();
			count--;
		}
		function removeBtn3(){
			$("#minusImgId3").parent().parent().remove();
			count--;
		} */
		
	</script>
</body>
</html>