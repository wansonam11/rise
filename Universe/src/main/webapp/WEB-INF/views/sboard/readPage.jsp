<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/sboard/modifyPage");
		formObj.attr("method", "get");
		formObj.submit();
	});	
		
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/sboard/removePage");
		
		formObj.submit();
	});

	$(".btn-primary").on("click", function(){
		formObj.attr("action", "/sboard/list");
		formObj.attr("method", "get");
		formObj.submit();
	});
});

</script>
  <h3>Reading Page</h3>
  <hr>
  Title: <input type="text" name="title" value="${boardVO.title }" readonly><br>
  Contents: <textarea rows="5" cols="25" readonly>${boardVO.contents }</textarea><br>
  Writer: <input type="text" name="writer" value="${boardVO.writer }"><br>
  
<form role="form" action="modifyPage" method="post">
	<input type="hidden" name="bno" value="${boardVO.bno }">
	<input type="hidden" name="page" value="${cri.page }">
	<input type="hidden" name="perPageNum" value="${cri.perPageNum }">
	<input type="hidden" name="searchType" value="${cri.searchType }">
	<input type="hidden" name="keyword" value="${cri.keyword }">
</form>

    <button type="submit" class="btn btn-warning">Modify</button>
    <button type="submit" class="btn btn-danger">Remove</button>
    <button type="submit" class="btn btn-primary">List </button>


