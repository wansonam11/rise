<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify</title>
</head>
<body>
  <h3>Modify</h3>
  <hr>
  <form role="form" action="modifyPage" method="post">
  number: <input type="text" name="bno" value="${boardVO.bno }" readonly><br>
  title: <input type="text" name="title" value="${boardVO.title }"><br>
  contents: <textarea rows="5" cols="25" name="contents">${boardVO.contents }</textarea><br>
  writer: <input type="text" name="writer" value="${boardVO.writer }"><br>
  
  	<input type="hidden" name="page" value="${cri.page }">
  	<input type="hidden" name="perPageNum" value="${cri.perPageNum }">
  </form>
</body>


	<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
	</div>

<script>
	$(document).ready(function(){
		var forObj = $("form[role='form']");
		console.log(formObj);
	
		$(".btn-warning").on("click", function(){
			formObj.submit();
		});
		
		$("cancel").on("click", function(){
			self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
			
		});
	});

</script>
</html>