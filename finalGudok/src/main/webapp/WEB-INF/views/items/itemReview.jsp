<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.starP{
		background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
		background-size: auto 100%;
		width: 30px;
		height: 30px;
		display: inline-block;
		text-indent: -9999px;
		cursor: pointer;
	}
	.starP.on{background-position:0 0;}
	
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
</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div style="padding:1% 0 1% 16%;">
			<img src="${contextPath }/resources/images/reviewImg.png" style="width:7%;height:7%;">
			<span style="vertical-align:middle;font-size:50px;"><b>상품명 상품평</b></span>
		</div>
	<div class="container">
		<div class="row">
		<div class="col-12">
		<table style="border:1px solid lightgray;margin:0 0 0 5%;width:80%;">
			<tr>
				<td id="reviewNameTd">
				<div class="row">
					<div class="col-9">
						<span style="font-size:40px;padding-left:2%;">OOO님의 상품평</span>
					</div>
					<div class="col-3" style="text-align:right;padding-right:2%;">
						<img src="resources/images/retouch.png" class="retouchImgC" style="width:3.5rem;border:1px solid lightgray;" title="상품평 수정하기">
					</div>
				</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="starPp" style="padding:0 0 0 2%;">
					  <span class="starP on">별1</span>
					  <span class="starP">별2</span>
					  <span class="starP">별3</span>
					  <span class="starP">별4</span>
					  <span class="starP">별5</span>
					  <span id="cDate">등록일 : 2020/DB/DB</span>
					</div>
				</td>
			</tr>
			<tbody style="padding:2%;">
				<tr>
					<td>
						<div style="padding:2%;border-top:1px dashed lightgray;">
							<img src="resources/images/breadLogo.jpg" class="reviewImgClass">
						</div>
					</td>
				</tr>
				<tr>
					<td style="padding:2%;">
						<div class="reviewText" style="padding:2%;border:1px solid black;font-size:20px;">내용 입력내용 입력내용 입력내용 입력내용 입력내용 입력 가나다라마바사 아자차카타파하</div>
					</td>
				</tr>
			</tbody>
		</table>
		
		<table style="border:1px solid lightgray;margin:0 0 0 5%;width:80%;">
			<tr>
				<td id="reviewNameTd">
				<div class="row">
					<div class="col-9">
						<span style="font-size:40px;padding-left:2%;">OOO님의 상품평</span>
					</div>
					<div class="col-3" style="text-align:right;padding-right:2%;">
						<img src="${contextPath }/resources/images/retouch.png" class="retouchImgC" style="width:3.5rem;border:1px solid lightgray;" title="수정하기">
					</div>
				</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="starPp" style="padding:0 0 0 2%;">
					  <span class="starP on">별1</span>
					  <span class="starP">별2</span>
					  <span class="starP">별3</span>
					  <span class="starP">별4</span>
					  <span class="starP">별5</span>
					  <span id="cDate">등록일 : 2020/DB/DB</span>
					</div>
				</td>
			</tr>
			<tbody style="padding:2%;">
				<tr>
					<td>
						<div style="padding:2%;border-top:1px dashed lightgray;">
							<img src="resources/images/breadLogo.jpg" class="reviewImgClass">
							<img src="resources/images/breadLogo.jpg" class="reviewImgClass">
						</div>
					</td>
				</tr>
				<tr>
					<td style="padding:2%;">
						<div class="reviewText" style="padding:2%;border:1px solid black;font-size:20px;">내용 입력내용 입력내용 입력내용 입력내용 입력내용 입력 가나다라마바사 아자차카타파하</div>
					</td>
				</tr>
			</tbody>
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