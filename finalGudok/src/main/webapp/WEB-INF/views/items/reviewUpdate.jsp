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
	
	.starRv{
  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
  background-size: auto 100%;
  width: 30px;
  height: 30px;
  display: inline-block;
  text-indent: -9999px;
  cursor: pointer;
}
.starRev{
		line-height:40px;
		padding-left:1%;
	}
	.starRev div{
		vertical-align:bottom;
	}
.starRv.on{background-position:0 0;}
</style>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div style="padding:1% 0 1% 18%;">
			<img src="${contextPath }/resources/images/reviewImg.png" style="width:7%;height:7%;">
			<span style="vertical-align:middle;font-size:50px;"><b>상품명 상품평 수정</b></span>
		</div>
	<div class="container">
		<div class="row">
		
		<div class="col-12">
			<table align="center" style="width:80%;text-align:center;font-size:30px;border:1px solid lightgray;">
				<tr>
					<td>
						별점
					</td>
				</tr>
				<tr>
					<td>
						이미지 넣는 곳
					</td>
				</tr>
				<tr>
					<td>
						<textarea style="width:98%;">내용</textarea>
					</td>
				</tr>
				<tr>
					<td>
						<button type="button">수정완료</button>
					</td>
				</tr>
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