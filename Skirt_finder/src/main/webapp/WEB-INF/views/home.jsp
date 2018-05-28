<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
        <title>Home</title>
    </head>
    <body>
        <h1>Spódnice</h1>
        
        <form:form method="GET" action="processForm" modelAttribute="web">
        <form:radiobuttons path ="shop" items = "${shop}" /> 
        <form:radiobuttons path="size" items="${size}" />
        <form:radiobuttons path="length" items="${length}" />
		<input type="submit" value="Submit" />
		</form:form>
	
    </body>
</html>
