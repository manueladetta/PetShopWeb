<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.betacom.model.User, java.util.List, it.betacom.DAO.UserDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<%
    User user = (User)session.getAttribute("user");

	List<User> lista = UserDAO.getAllRecords();
	request.setAttribute("list",lista);

%>

<% String successMessage = (String) session.getAttribute("successMessage"); %>
<% String errorMessage = (String) session.getAttribute("errorMessage"); %>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Dashboard</a>
    </nav>
    
    <!-- <% if (successMessage != null && !successMessage.isEmpty()) { %>
		    <div class="alert alert-success">
		        <strong>Operazione avvenuta con successo:</strong> <%= successMessage %>
		    </div>
	<% } %>
	
	<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
		    <div class="alert alert-danger">
		        <strong>Errore:</strong> <%= errorMessage %>
		    </div>
	<% } %> -->

    <div class="container mt-4">
        <h1>Users List</h1>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Date of birth</th>
                    <th>Role</th>
                    <th>Status</th>
                    <c:if test="${user.getRuolo().equals('M')}">
                    	<th>Action</th>
                   	</c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="u">
                    <tr>
                        <td>${u.getId()}</td>
                        <td>${u.getNome()}</td>
                        <td>${u.getCognome()}</td>
                        <td>${u.getUsername()}</td>
                        <td>${u.getEmail()}</td>
                        <td>${u.getCellulare()}</td>
                        <td>${u.getDataDiNascita()}</td>
                        <td>
		   	                <c:if test="${u.getRuolo().equals('M')}">
		   	                	Manager
	                      	</c:if>
	                      	<c:if test="${u.getRuolo().equals('G')}">
		   	                	Ospite
	                      	</c:if>
                        </td>
                        <td>
                        	<c:if test="${u.getStato().equals('A')}">
		   	                	Abilitato
	                      	</c:if>
                        	<c:if test="${u.getStato().equals('D')}">
		   	                	Disabilitato
	                      	</c:if>
						</td>
   	                    <c:if test="${user.getRuolo().equals('M')}">
   	                    	<td>
                            <%-- Bottone per modificare stato e ruolo --%>
                            <c:if test="${u.getRuolo().equals('M') && !u.getStato().equals('D')}">
                                <a href="changeRole.jsp?userId=${u.getId()}">Make Guest</a>
                            </c:if>
                            <c:if test="${u.getRuolo().equals('G') && u.getStato().equals('A')}">
                                <a href="changeRole.jsp?userId=${u.getId()}">Make Manager</a>
                            </c:if>
                            <c:if test="${u.getStato().equals('A')}">
                                <a href="changeStatus.jsp?userId=${u.getId()}">Disable</a>
                            </c:if>
                            <c:if test="${u.getStato().equals('D')}">
                                <a href="changeStatus.jsp?userId=${u.getId()}">Enable</a>
                            </c:if>

                            <%-- Bottone per aprire modifica contatti --%>
                            <c:if test="${!user.getRuolo().equals('G')}">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editContact${user.getId()}">Edit Contact</button>
                            </c:if>

                            <%-- Modale per la modifica dei contatti --%>
                            <div class="modal fade" id="editContact${u.getId()}" tabindex="-1" role="dialog" aria-labelledby="editContactLabel${user.getId()}" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="editContactLabel${u.getId()}">Edit Contact Info</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <%-- Form per la modifica dei contatti --%>
                                            <form action="editContact.jsp" method="post">
                                                <input type="hidden" name="userId" value="${u.getId()}">
                                                <label for="email">Email</label>
                                                <input type="text" name="email" value="${u.getEmail()}"><br>
                                                <label for="phone">Cellulare</label>
                                                <input type="text" name="phone" value="${u.getCellulare()}"><br>
                                                <label for="phone">Data di nascita</label>
                                                <input type="text" name="phone" value="${u.getDataDiNascita()}"><br>
                                                <label for="password">Password</label>
                                                <input type="password" name="password" value=""><br>
                                                <input type="submit" value="Submit">
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
   	                    </c:if>
                        
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	    <c:if test="${user.getRuolo().equals('M')}">
			<br/><a href="adduserform.jsp">Add New User</a>
		</c:if>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
