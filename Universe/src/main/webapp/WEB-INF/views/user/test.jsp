<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax Test</title>
<style type="text/css">
	#modDiv{
		width: 300px;
		height: 100px;
		background-color: gray;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-top: -50px;
		margin-left: -150px;
		padding: 10px;
		z-index: 1000;
		opacity: 0.9;
	}

</style>
<script type="text/javascript" 
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	var bno=4;
	function getAllList(){
		$.ajax({
			cache:false,
			url:'replies/all/'+bno, 
			success:function(result){
				console.log(bno+'게시글에 대한 댓글 수==>'+result.length);
				var str='';
				$(result).each(function(){
					str += '<li date-rno='+this.rno+'class="replyLi" data=replytext="'+this.rno+":"+this.replaytext+'<button>수정<button></li>'				
			});
				$('#replies').html(str);
			},
		error:function(xhr){
			if(xhr.status==400){
				alert("댓글이 없습니다!")
				}
			}
		});
	}
	
	$(function(){
		$('#replyAddBtn').click(function(){
			var replyer = $('#newReplyWriter').val();
			var replyertext = $('#newReplyText').val();
			
			$.ajax({
				url:'replies', 
				data:{bno:bno, replyer:replyer, replytext:replytext},
				headers:{"Content-Type" : "application/json"},
				type:'post', 
				processData: false,
				contentType: false,
				success:function(result){
					if(result=='success'){
						alert("등록되었습니다!");
					}
					getPageList(1);
				}
			});
		});
	
		$('#replies').on("click",'.replyLi button', function(){
			var reply = $(this).parent();
			var rno = reply.attr('data-rno');
			var replytext = reply.text();			
			$('.modal-title').html(rno);
			$('#replytext').val(replytext);
			$('#modDiv').show(500);
		});
		
		$('#delBtn').click(function(){
			var rno=$(".modal-title").text()
			consol.log("삭제할 댓글번호: " + rno);
			
			$.ajax({
				url: '/replies/' + rno, 
				type: 'delete', 
				processData: false,
			    contentType: false,
				success:function(result){
					if(result=='success'){
						console.log("삭제성공!!");
						$('#modDiv').hide(500);
						getAllList();
					}
				}
			})
		})
		$('#modBtn').click(function(){
			var rno = $(".modal-title").text();
			var replytext = $("#replytext").val();
			console.log("수정할 댓글번호: " + rno + ", 내용:" + replytext);
			
			$.ajax({
				url:'/replies/'+rno, 
				type:'put',
				processData: false,
			    contentType: false,
				headers:{'Content-Type':'application/json'},
				data:JSON.stringify({replytext:replytext}),
				success:function(result){
					if(result=="success"){
						console.log("수정성공!");
						$('#modDiv').hide(500);
						getAllList();
					}
				}
			})
		})
		
		$('#closeBtn').click(function(){
			$('#modDiv').hide(500);
		});
	
	});
	
	function printPaging(pageMaker){
		var str='';
		if(pageMaker.prev)
			str += '<li><a href="javascript:getPageList('+(pageMaker.startPage-1)+')"> << </a></li>';
		for(var i=pageMaker.startPage; i<=pageMaker.endPage; i++){
			var strClass=(pageMaker.cri.page==i) ? 'class=active':'';
			str += "<li " + strClass + "><a href='javascript:getPageList("+i+")'>"+i+"</a></li>";
		}	
		if(pageMaker.next)
			str+= '<li><a href="javascript:getPageList('+(pageMaker.endPage+1)+')"> >> </a></li>';
	
		$('.pagination').html(str);
	}	
	
	
	
</script>
</head>
<body>
	<h3>AJax Test</h3>
	<ul id="replies"> 데이터 출력</ul>
	<div>
		<div>댓글작성자:<input type="text" id="newReplyWriter"></div>
		<div>댓글내용:<input type="text" id="newReplyText"></div>
			<button id="replyAddBtn">댓글 추가</button>
	</div>
	<div id="moDiv">
		<div class="model-title"></div>
	</div>
	<div>
		<input type="text" id="replytext">
	</div>
	<div>
		<button id="modBtn">Modify</button>
		<button id="delBtn">Delete</button>
		<button id="closeBtn">Close</button>
	</div>
	
</body>
</html>