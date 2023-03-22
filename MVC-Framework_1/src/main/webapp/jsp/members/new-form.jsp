<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//jsp를 이용한 멤버 받아들임
%>
<html>
<head>
 <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
 username: <input type="text" name="username" />
 age: <input type="text" name="age" />
 <button type="submit">전송</button>
</form>
</body>
</html>
