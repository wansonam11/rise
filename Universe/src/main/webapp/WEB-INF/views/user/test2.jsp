<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	  <script type="text/javascript" 
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script type="text/javascript">
		$(function(){
			var source= $('#template').html();
		      var template = Handlebars.compile(source);//스타일(text) ---> 스타일템플릿(객체)
		      var data =[  //데이터(JSON)
		           {name:"blackpink", userid:"gildong", addr:"한양"}, 
		           {name:"홍길동2", userid:"gildong", addr:"한양"},
		           {name:"홍길동3", userid:"gildong", addr:"한양"},
		           {name:"홍길동4", userid:"gildong", addr:"한양"},
		           {name:"홍길동5", userid:"gildong", addr:"한양"}
		           ];
		      $('#displayDiv').html(template(data));
		    });
	</script>
<script type="text/x-handlebars-template" id="template">
	<table cellpadding="5">
	  <tr bgcolor="#99ccff">
	     <th>이름</th>
	     <th>아이디</th>
	     <th>주소</th>
	  </tr>
     {{#each .}}
	  <tr>
	     <td>{{name}}</td>
	     <td>{{userid}}</td>
	     <td>{{addr}}</td>
	  </tr>
     {{/each}}
	</table>
  </script>

</head>
<body>
   


   <h3>Handlebars템플릿 테스트</h3>
   <hr>
   <div id="displayDiv"></div>

</body>
</html>