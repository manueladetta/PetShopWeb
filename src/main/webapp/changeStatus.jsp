<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="it.betacom.DAO.UserDAO"%>
<%@page import="it.betacom.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("userId");
	User utente = UserDAO.getRecordById(Integer.parseInt(id));
	int i = UserDAO.changeStatus(utente);
	if(i > 0)
		session.setAttribute("successMessage", "Modifica dello stato utente avvenuta con successo");
	if(i <= 0)
		session.setAttribute("errorMessage", "Errore durante la modifica dello stato utente");
	response.sendRedirect("dashboard.jsp");
%>

</body>
</html>