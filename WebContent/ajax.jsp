<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "DataServlet" method = "POST">


<input type="submit" value="Submit" />
</form>

<input type="button" onclick="data()" value="call">
<input hidden type="text" id="myField" value="test" />


<ul id="ul"></ul>

<script type="text/javascript" src="ajax1.js"></script>
</body>
</html>