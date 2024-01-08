<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Assicurati di avere una connessione Internet per il caricamento di Bootstrap -->
    <style>
        body {
            padding: 50px;
        }
        .form-container {
            max-width: 400px;
            margin: auto;
        }
    </style>
</head>
<body>
	<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <div class="container form-container">
        <h1 class="text-center mb-4">Benvenuto!</h1>
        <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
		    <div class="alert alert-danger">
		        <strong>Errore:</strong> <%= errorMessage %>
		    </div>
		<% } %>
        <form action="ServletLogin" method="post">
            <div class="form-group">
                <label for="username">Username o Email:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Login</button>
        </form>
        <p class="mt-3 text-center">Se non sei registrato, <a href="registrazione.jsp">registrati qui</a>.</p>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
