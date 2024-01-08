<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="it.betacom.DAO.UserDAO"%>
<%@page import="it.betacom.model.User"%>
<!-- <jsp:useBean id="u" class="it.betacom.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u" /> -->

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
	int i = UserDAO.changeRole(utente);
	if(i > 0)
		session.setAttribute("successMessage", "Modifica del ruolo utente avvenuta con successo");
	if(i <= 0)
		session.setAttribute("errorMessage", "Errore durante la modifica del ruolo utente");
	response.sendRedirect("dashboard.jsp");
%>

</body>
</html>