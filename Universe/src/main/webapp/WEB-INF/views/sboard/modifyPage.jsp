<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify</title>
</head>
<body>
  <h3>Modify</h3>
  <hr>
  <form method="post" action="modifyPage" method="post">
  
  Number: <input type="text" name="bno" value="${boardVO.bno }" readonly><br>
  Title: <input type="text" name="title" value="${boardVO.title }"><br>
  Contents: <textarea rows="5" cols="25" name="contents">${boardVO.contents }</textarea><br>
  Writer: <input type="text" name="writer" value="${boardVO.writer }"><br>
  		
  
  	<button type="submit" class="btn btn-primary">SAVE</button>
	<button type="submit" class="btn btn-warning">CANCEL</button>
 
 </form>
</body>
<script>
	$(document).ready(function(){
		var forObj = $("form[role='form']");
		console.log(formObj);
	
		$(".btn-primary").on("click", function(){
			formObj.submit();
		});
		
		$(".btn-warning").on("click", function(){
			self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
				+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
			
		});
	});

</script>
</html>