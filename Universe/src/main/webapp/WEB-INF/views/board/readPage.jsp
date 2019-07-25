<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>read</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
		
		var formObj = $("form[role='form']");//<form action="/board/removePage">	
		console.log(formObj);
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/board/removePage");
			formObj.submit();
		});
		
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/board/modifyPage");
			formObj.attr("method", "get");		
			formObj.submit();
		});
		
		
		$(".btn-primary").on("click", function(){
			formObj.attr("method", "get");
			formObj.attr("action", "/board/listPage");
			formObj.submit();
		});
		
	});
  </script>
  
</head>


  <h3>Reading Page</h3>
  <hr>
  <body>
 
  
  Title: <input type="text" name="title" value="${boardVO.title }" readonly><br>
  Contents: <textarea rows="5" cols="25" readonly>${boardVO.contents }</textarea><br>
  Writer: <input type="text" name="writer" value="${boardVO.writer }" readonly><br>
  
 <div class="box-footer">
    <button type="submit" class="btn btn-warning">Modify</button>
    <button type="submit" class="btn btn-danger">Remove</button>
    <button type="submit" class="btn btn-primary">List </button>
  </div>
</body>

</html>