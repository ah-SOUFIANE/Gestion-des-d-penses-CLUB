<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Créer un compte</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-warning d-flex align-items-center" style="height: 100vh;">

<div class="container">
    <div class="card mx-auto p-4 shadow" style="max-width: 400px;">
        <h3 class="text-center mb-4">Créer un compte</h3>
        <form action="InscriptionController" method="post">
            <div class="mb-3">
                <label class="form-label">Nom complet</label>
                <input type="text" name="nom" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Mot de passe</label>
                <input type="password" name="motdepasse" class="form-control" required>
            </div>
            <div class="d-grid">
                <button class="btn btn-primary" type="submit">S'inscrire</button>
            </div>
            <div class="text-center mt-3">
                <a href="login.jsp">Déjà un compte ? Se connecter</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
