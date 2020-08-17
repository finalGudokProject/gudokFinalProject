<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- sweetalert시작 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
	<!-- sweetalert끝 -->
</head>
<style>
	.starRv{
		background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
		background-size: auto 100%;
		width: 50px;
		height: 50px;
		display: inline-block;
		text-indent: -9999px;
		cursor: pointer;
	}
	.starRv.on{background-position:0 0;}
	
	div.reviewDC{
	vertical-align: middle;
	}
	#reviewPI{
		margin-top:20px;
		font-size:35px;
	}
	.reviewRC{
		display:inline-block;
	}
	
	.reviewRP{
		text-align:center;
		padding-top:2%;
		font-size:25px;
	}
	
	.starPp{
		line-height:40px;
	}
	
	.starPp #cDate{
		vertical-align:bottom;
	}
	
	#reviewNameTd{
		line-height:62px;
	}
	#reviewNameTd span{
		vertical-align:middle;
	}
	
	#reviewNameTd img{
		align:right;
	}
	
	.reviewImgClass{
		width:25rem;
		height:auto;
		margin-right:1%;
		border:1px solid lightgray !important;
	}
	
	input[type=button]{
	background:#6AAED9;
	color:white;
	border-radius:5px;
	padding:2%;
	width:40%;
	transition:0.5s;
  	position:relative;
  	border:1px solid #6AAED9;
	margin-bottom:2%;
	}
	input[type=button]:hover{
	  background:#11538C;
	  color:#white;
	  border:1px solid #11538C;
	}
</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div style="padding:1% 0 1% 18%;">
			<img src="${contextPath }/resources/images/reviewImg.png" style="width:7%;height:7%;">
			<span style="vertical-align:middle;font-size:50px;"><b>님 상품평 수정</b></span>
		</div>
	<div class="container">
		<div class="row">
		
		<div class="col-12">
			<table align="center" style="width:80%;text-align:center;font-size:30px;border:1px solid lightgray;">
			<c:if test="${empty rv}">
			<div class="col-2"></div>
				<div class="col-8" id="emptyDiv" style="margin-top:2%;border:1px solid lightgray;">
					<div style="text-align:center;width:100%;"><img src="${contextPath }/resources/images/empty.png" style="width:30%;"></div>
					<div style="text-align:center;width:100%;font-size:40px;">해당 카테고리의 상품이 존재하지 않습니다.</div>
				</div>
			<div class="col-2"></div>
			</c:if>
			
			
			<c:if test="${!empty rv}">
			<c:forEach var="r" items="${rv }">
				<tr>
					<td><div style="vertical-align:middle;font-size:50px; text-align:left;margin-left:2%;">평점 : 
						<div class="starRev" style="margin:2% 0 0 0;display:inline-block;">
							<c:choose>
								<c:when test="${r.reviewRate < 1}">
									<span class="starRv">1</span>
									<span class="starRv">2</span>
									<span class="starRv">3</span>
									<span class="starRv">4</span>
									<span class="starRv">5</span>
								</c:when>
								<c:when test="${r.reviewRate < 2 }">
									<span class="starRv on">1</span>
									<span class="starRv">2</span>
									<span class="starRv">3</span>
									<span class="starRv">4</span>
									<span class="starRv">5</span>
								</c:when>
								
								<c:when test="${r.reviewRate < 3 }">
									<span class="starRv on">1</span>
									<span class="starRv on">2</span>
									<span class="starRv">3</span>
									<span class="starRv">4</span>
									<span class="starRv">5</span>
								</c:when>
								
								<c:when test="${r.reviewRate < 4 }">
									<span class="starRv on">1</span>
									<span class="starRv on">2</span>
									<span class="starRv on">3</span>
									<span class="starRv">4</span>
									<span class="starRv">5</span>
								</c:when>
								
								<c:when test="${r.reviewRate < 5 }">
									<span class="starRv on">1</span>
									<span class="starRv on">2</span>
									<span class="starRv on">3</span>
									<span class="starRv on">4</span>
									<span class="starRv">5</span>
								</c:when>
								<c:otherwise>
									<span class="starRv on">1</span>
									<span class="starRv on">2</span>
									<span class="starRv on">3</span>
									<span class="starRv on">4</span>
									<span class="starRv on">5</span>
								</c:otherwise>
							</c:choose>
						</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${!empty r.imageOriginalName }">
							<img src="${contextPath }/resources/iuploadFiles/${r.imageRename}" style="margin:2%;width:40%;">
						</c:if>
						<c:if test="${empty r.imageOriginalName }">
							등록한 사진이 없습니다.
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
						<div style="line-height:50px;vertical-align:middle;"><textarea style="width:96%;">${r.reviewContent }</textarea></div>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" style="vertical-align:middle;width:15%;margin:0 0 2% 0;" value="수정완료">
					</td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
		</div>
		
		</div>
	</div>
	
	<script type="text/javascript">
	    $(document).ready(function(){
	        $(".retouchImgC").tooltip();
	    });
	</script>
	
	<script>
		$(function(){
			$('.starRev .starRv').click(function(){
				$(this).parent().children('span').removeClass('on');
				$(this).addClass('on').prevAll('span').addClass('on');
				switch($(this).text()){
				case "1" : $("input:radio[id=radio1]").prop("checked", true);
					break;
				case "2" : $("input:radio[id=radio2]").prop("checked", true);
					break;
				case "3" : $("input:radio[id=radio3]").prop("checked", true);
					break;
				case "4" : $("input:radio[id=radio4]").prop("checked", true);
					break;
				case "5" : $("input:radio[id=radio5]").prop("checked", true);
					break;
				}
				
			});
		})
		
	</script>
	
	<script>
		$(function(){
			$("div .retouchImgC").on("mouseenter", function(){
				console.log("이미지");
				$(this).attr("src","${contextPath }/resources/images/retouchHover.png").css("cursor","pointer");
			}).on("mouseleave", function(){
				$(this).attr("src","${contextPath }/resources/images/retouch.png");
			}).on("click", function(){
				swal({
					text : "상품평을 수정하시겠습니까?",
					buttons : ["예", "아니오"],
					closeOnEsc : false,
					dangerMode : true,
				}).then((result)=>{
					if(result){
						
					}else{
						swal("","모달창 띄워주기");
					}
				})
			})
		})
	</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>