<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<!-- ✅ Bandeau rouge pleine largeur -->
<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Ajouter une catégorie</h2>
</div>

<!-- ✅ Contenu avec espacement -->
<div class="container mt-4">
    <div class="card p-4 shadow-sm">
        <form action="CategorieController" method="post">
            <input type="hidden" name="action" value="add" />

            <div class="mb-3">
                <label class="form-label">Nom de la catégorie</label>
                <input type="text" name="nom" class="form-control" required>
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-success">Enregistrer</button>
                <a href="CategorieController" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
