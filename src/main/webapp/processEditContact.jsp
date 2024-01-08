<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.betacom.DAO.UserDAO, it.betacom.model.User" %>

<%
// Ottenere i parametri dalla richiesta
String userId = request.getParameter("userId");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String password = request.getParameter("password");

// Effettuare la modifica dei contatti dell'utente
User updatedUser = new User();
updatedUser.setId(Integer.parseInt(userId));
updatedUser.setEmail(email);
updatedUser.setCellulare(phone);

// Eseguire la logica per aggiornare i contatti dell'utente nel database
int success = UserDAO.save(updatedUser);

if (success > 0) {
	// TODO: passare messaggio di successo
    response.sendRedirect("dashboard.jsp");
} else {
    // TODO: passare messaggio di errore
    response.sendRedirect("dashboard.jsp");
}
%>
