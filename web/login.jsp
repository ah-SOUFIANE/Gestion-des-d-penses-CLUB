<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            height: 100vh;
            display: flex;
            margin: 0;
        }

        .left-panel {
            background: linear-gradient(to bottom right, #2f4f4f, #007b7f);
            color: white;
            width: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        .right-panel {
            background-color: #f8c430;
            width: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 350px;
        }

        .form-box h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-box input {
            margin-bottom: 15px;
        }

        .btn-custom {
            background-color: #0d5c63;
            color: white;
        }

        .btn-custom:hover {
            background-color: #08494d;
        }
    </style>
</head>
<body>

<div class="left-panel">
    <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" width="120" alt="Icon utilisateur">
    <h1>Bienvenue !</h1>
    <p>Connectez-vous pour accéder à votre espace</p>
</div>

<div class="right-panel">
    <form class="form-box" action="Authentification" method="post">
        <h2>Connexion</h2>
        <div class="form-group">
            <label for="email">Email :</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="motDePasse">Mot de passe :</label>
            <input type="password" name="motDePasse" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-custom btn-block w-100">Se connecter</button>
        <div class="text-center mt-3">
            <a href="resetPassword.jsp" class="d-block">Mot de passe oublié ?</a>
            <a href="register.jsp" class="d-block">Créer un compte</a>
        </div>
    </form>
</div>

</body>
</html>
