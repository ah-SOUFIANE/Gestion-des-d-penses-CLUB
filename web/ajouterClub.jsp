<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Ajouter un club</h2>
</div>

<div class="container mt-4">
    <div class="card p-4 shadow-sm">
        <form action="ClubController" method="post">
            <input type="hidden" name="action" value="add" />

            <div class="mb-3">
                <label class="form-label">Nom du club</label>
                <input type="text" name="nom" class="form-control" required>
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-success">Enregistrer</button>
                <a href="ClubController" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
