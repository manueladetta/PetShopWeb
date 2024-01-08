<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.betacom.model.User" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Edit Contact</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Edit Contact</a>
    </nav>

    <div class="container mt-4">
        <h1>Edit Contact</h1>

        <form action="processEditContact.jsp" method="post">
            <label for="email">Username</label>
            <input type="text" name="username" value="${user.getUsername()}"><br>
            <label for="email">Email</label>
            <input type="text" name="email" value="${user.getEmail()}"><br>
            <label for="phone">Phone</label>
            <input type="text" name="cellulare" value="${user.getCellulare()}"><br>
            <label for="password">Password</label>
            <input type="password" name="password"><br>

            <%-- Campo nascosto per l'ID dell'utente --%>
            <input type="hidden" name="userId" value="${user.getId()}">

            <input type="submit" value="Update">
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
