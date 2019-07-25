<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
 <script type="text/javascript">
    var result= '${msg}';
    if(result=='success'){
    	alert('The process is complete!')
    }
 </script>


 <h3>List</h3>
 <hr>
  <div class='box-body'>
 	<select name="searchType" id="searchType">
 		<option value="n"
 		  	<c:out value="${cri.searchType == null?'selected':'' }"/>>---</option>
 		<option value="t"
 			<c:out value="${(cri.searchType eq 't')?'selected':'' }"/>>Title</option>
 		<option value="w"
 			<c:out value="${cri.searchType eq 'w'?'selected':'' }"/>>Writer</option>
 		<option value="c"
 			<c:out value="${cri.searchType eq 'tc'?'selected':'' }"/>>Title or Writer</option>
 	</select>
 	
 	<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }" placeholder="please,Input the keyword">
  	<button type="button" id="searchBtn">Search</button>
  	<button type="button" id="newBtn">New Board</button>
  </div>
 
 <h2></h2>
 <table border="1" cellpadding="5" cellspacing="0">
 	<tr bgcolor="#99ccff">
 	<th>No</th>
 	<th>Title</th>
 	<th>Writer</th>
 	<th>Date</th> 	
 	</tr>
 	<c:forEach items="${list }" var="board">
 	<tr>
 	<td>${board.bno }</td>
 	<td><a href="/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page) 
 				}&bno=${board.bno }"> ${board.title }
 			<strong>[${board.viewcnt }]</strong>
 		</a>
 	</td>
 	<td>${board.writer }</td>
 	<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd hh:mmh"/></td>
 	</tr>
 	</c:forEach>
</table>
<div class="text-center">
	<ul class="pagination">

	 <c:if test="${pageMaker.prev}">
	 <li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
	 </c:if>

	 <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
	 <li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
		 <a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
				<%-- <a href="listPage?page=${idx }&perPageNum=${cri.perPageNum}">${idx}</a> --%>
	 </li>
	 </c:forEach>

	 <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
	 <li><a	href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
     </c:if>
 	 
 	 </ul>
</div>

<script>
	$(document).ready(
			function(){
				$('#searchBtn').on("click", function(event){
					self.location="list"+'${pageMaker.makeQuery(1)}'+"&searchType="
					+$("select option:selected").val()+"&keyword="+encodeURIComponent($('#keywordInput').val());
				});
				
				$('#newBtn').on("click", function(evt){
					self.location="register";
				});
			});

</script>
</html>