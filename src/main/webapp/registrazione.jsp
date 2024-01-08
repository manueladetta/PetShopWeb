<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Registrazione</title>
    <!-- Link ai file CSS di Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

	<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
	
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        Registrazione Utente
                    </div>
                    <div class="card-body">
                    <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
					    <div class="alert alert-danger">
					        <strong>Errore:</strong> <%= errorMessage %>
					    </div>
					<% } %>
                        <form action="ServletRegistrazione" method="post">
                            <div class="form-group">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" id="nome" name="nome" required>
                            </div>
                            <div class="form-group">
                                <label for="cognome">Cognome</label>
                                <input type="text" class="form-control" id="cognome" name="cognome" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="cellulare">Cellulare</label>
                                <input type="text" class="form-control" id="cellulare" name="cellulare" required>
                            </div>
                            <div class="form-group">
                                <label for="data_nascita">Data di Nascita</label>
                                <input type="date" class="form-control" id="data_nascita" name="data_nascita" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Registrati</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Link ai file JavaScript di Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
