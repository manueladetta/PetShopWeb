<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="it.betacom.DAO.UserDAO"%>   
 <jsp:useBean id="u" class="it.betacom.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int i = UserDAO.update(u);
	response.sendRedirect("dashboard.jsp");
%>

</body>
</html>