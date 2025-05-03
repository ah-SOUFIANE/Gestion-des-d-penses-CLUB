<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mot de passe oublié</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-warning d-flex align-items-center" style="height: 100vh;">

<div class="container">
    <div class="card mx-auto p-4 shadow" style="max-width: 400px;">
        <h3 class="text-center mb-4 text-dark">Réinitialiser le mot de passe</h3>

        <c:choose>
            <c:when test="${param.error == 'notfound'}">
                <div class="alert alert-danger text-center">Adresse email introuvable.</div>
            </c:when>
            <c:when test="${param.error == 'mailfail'}">
                <div class="alert alert-danger text-center">Erreur lors de l'envoi de l'e-mail.</div>
            </c:when>
        </c:choose>

        <form action="ResetPasswordController" method="post">
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>
            <div class="d-grid">
                <button class="btn btn-primary" type="submit">Envoyer</button>
            </div>
            <div class="text-center mt-3">
                <a href="login.jsp">← Retour à la connexion</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
