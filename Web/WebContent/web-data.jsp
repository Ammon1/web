<%@page import="com.websearch.WebData"%>  
 <%  
WebData data=(WebData)request.getAttribute("data");  
%>  
<p>Web page</p>  <%= data.getAdres()%> 
<p>Word length</p><%= data.getWordNumber()%> 
<p>Alphabet table</p>
<table>
<%int j=0;float[] AB=data.getAB();
for(char ch='a';ch<='z';ch++){
		
		out.println("<tr>");
		out.print("<th style='background-color:orange;'>"+ch+"</th>"+"<th style='background-color:cyan;'>");
		out.println(100*AB[j]);out.println("  "+j);
		out.println("</th>");
		out.println("<tr>");
		
		j++;
		
	} %>