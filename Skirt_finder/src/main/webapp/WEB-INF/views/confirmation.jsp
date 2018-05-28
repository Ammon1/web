<!DOCTYPE html>

<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<title>Welcome to Spring Web MVC project</title>
</head>


<body>

<p>List of scirts </p>
<p>Size= ${data.size} </p>
<p>Length = ${data.length} </p>

<table>
<c:forEach items="${prices}" var="prices" varStatus="theCount">
   <tr> <td>Price ${prices}</td><td>${links[theCount.index]}</td></tr>
</c:forEach>

</table>

</body>

</html>







