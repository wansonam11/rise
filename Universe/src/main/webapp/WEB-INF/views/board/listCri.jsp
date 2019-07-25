<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
  <script type="text/javascript">
    var result= '${msg}';
    if(result=='success'){
    	alert('The process is complete!')
    }
  </script>
</head>
<body>
 <h3>ListCri</h3>
 <hr>
 <table border="1" cellpadding="5" cellspacing="0">
 	<tr bgcolor="#99ccff">
 	<th>No</th>
 	<th>Title</th>
 	<th>Writer</th>
 	<th>Date</th>
 	<th style="width: 40px">ViewCnt</th>
 	</tr>
 	<c:forEach items="${list }" var="board">
 	<tr>
 	<td>${board.bno }</td>
 	<td><a href="/board/read?bno=${board.bno }"> ${board.title }</a></td>
 	<td>${board.writer }</td>
 	<td><fmt:formatDate value="${board.regdate }" 
 					pattern="yyyy-MM-dd hh:mm:ss"/></td>
 	<td><span class="badge bg-red">${board.viewcnt }</span></td>
 	</tr>
 	</c:forEach>
</table>
<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a
									href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="listPage${pageMaker.makeQuery(idx)}">${idx}</a>
									<%-- <a href="listPage?page=${idx }&perPageNum=${cri.perPageNum}">${idx}</a> --%>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="listPage${pageMaker.makeQuery(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>
</body>
</html>