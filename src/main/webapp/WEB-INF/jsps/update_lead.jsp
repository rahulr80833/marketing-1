<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Lead</title>
</head>
<body>
   <h2> update lead</h2>
   <form action = "updateLead" method = "post">
   <pre>
   <input type = "hidden" name = "id" value="${lead.id }" />
   First Name <input type = "text" name = "firstName" value= "${lead.firstName }"/>
   Last Name<input type = "text" name = "lastName" value= "${lead.lastName }"/>
   Email<input type = "text" name = "email" value= "${lead.email }"/>
   Mobile<input type = "text" name = "mobile" value= "${lead.mobile }"/>
   <input type = "submit" value = "update"/>    
   
   </pre>
   
   ${msg}
   
   
   </form>
   

</body>
</html>