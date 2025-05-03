<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Dépenses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Toutes les Dépenses</h2>
</div>

<div class="container mt-4">
    <c:choose>
        <c:when test="${empty depenses}">
            <div class="alert alert-warning text-center">Aucune dépense enregistrée.</div>
        </c:when>
        <c:otherwise>
            <div class="table-responsive">
                <table class="table table-bordered table-hover shadow-sm">
                    <thead class="table-dark text-center">
                        <tr>
                            <th>Libellé</th>
                            <th>Montant</th>
                            <th>Date</th>
                            <th>Catégorie</th>
                            <th>Club</th>
                            <th>Utilisateur</th>
                        </tr>
                    </thead>
                    <tbody class="text-center">
                        <c:forEach var="d" items="${depenses}">
                            <tr>
                                <td>${d.libelle}</td>
                                <td>${d.montant} DH</td>
                                <td>${d.date}</td>
                                <td>${d.categorie.nom}</td>
                                <td>${d.club.nom}</td>
                                <td>${d.utilisateur.nom} ${d.utilisateur.prenom}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
