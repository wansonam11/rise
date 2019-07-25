<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>read</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
 <script type="text/javascript">
 	$(function(){
 		$('#bt_modify').click(function(){
 			location.href='modify?bno=${boardVO.bno}'});
 		$('#bt_remove').click(function(){
 			location.href='remove?bno=${boardVO.bno}'});
 		$('#bt_list').click(function(){
 			self.location='/board/listAll';
 			
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
  
  <input type="button" value="Modified" id="bt_modify">
  <input type="button" value="Delete" id="bt_remove">
  <input type="button" value="List" id="bt_list">

</body>
</html>