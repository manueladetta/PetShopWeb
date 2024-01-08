<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="it.betacom.DAO.UserDAO"%>
<jsp:useBean id="u" class="it.betacom.model.UserDemo"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%@ page import="java.time.LocalDate, java.time.format.DateTimeFormatter" %>

<%
    String dateString = request.getParameter("dataDiNascitaString");
    LocalDate dataDiNascita = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
    session.setAttribute("errorMessage", "");
    session.setAttribute("successMessage", "");
%>

<%
	u.setDataDiNascita(dataDiNascita);
	int i = UserDAO.saveUser(u);
	if (i > 0)
		response.sendRedirect("adduser-success.jsp");
	else
		response.sendRedirect("adduser-error.jsp");
%>
