<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une dépense</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Ajouter une dépense</h2>
</div>

<div class="container mt-4">

    <c:if test="${not empty param.success}">
        <div class="alert alert-success text-center">
             Dépense ajoutée avec succès !
        </div>
    </c:if>

    <c:if test="${not empty param.error}">
        <div class="alert alert-danger text-center">
             Une erreur est survenue. Veuillez réessayer.
        </div>
    </c:if>

    <form action="ajouterDepenseUser" method="post" class="card p-4 shadow-sm needs-validation" novalidate>

        <div class="mb-3">
            <label class="form-label">Libellé</label>
            <input type="text" class="form-control" name="libelle" required>
            <div class="invalid-feedback">Veuillez entrer un libellé.</div>
        </div>

        <div class="mb-3">
            <label class="form-label">Montant</label>
            <input type="number" step="0.01" class="form-control" name="montant" required>
            <div class="invalid-feedback">Veuillez entrer un montant valide.</div>
        </div>

        <div class="mb-3">
            <label class="form-label">Date</label>
            <input type="date" class="form-control" name="date" required>
            <div class="invalid-feedback">Veuillez choisir une date.</div>
        </div>

        <div class="mb-3">
            <label class="form-label">Catégorie</label>
            <select name="categorie" class="form-select" required>
                <option disabled selected value="">-- Sélectionnez une catégorie --</option>
                <c:forEach var="cat" items="${categories}">
                    <option value="${cat.id}">${cat.nom}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">Veuillez sélectionner une catégorie.</div>
        </div>

        <div class="mb-3">
            <label class="form-label">Club</label>
            <select name="club" class="form-select" required>
                <option disabled selected value="">-- Sélectionnez un club --</option>
                <c:forEach var="club" items="${clubs}">
                    <option value="${club.id}">${club.nom}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">Veuillez sélectionner un club.</div>
        </div>

        <button type="submit" class="btn btn-success w-100">Ajouter</button>
    </form>
</div>

<script>
    (function () {
        'use strict';
        const forms = document.querySelectorAll('.needs-validation');
        Array.from(forms).forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>

</body>
</html>
<jsp:include page="footer.jsp" />
