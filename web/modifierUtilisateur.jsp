<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Utilisateur" %>
<jsp:include page="header.jsp" />

<%
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>

<!-- ✅ Bandeau rouge pleine largeur sans espace -->
<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Modifier l'utilisateur</h2>
</div>

<!-- ✅ Espace clair entre le titre et le formulaire -->
<div class="container mt-4">
    <div class="card shadow-sm p-4">
        <form action="UtilisateurController" method="post">
            <input type="hidden" name="action" value="edit" />
            <input type="hidden" name="id" value="<%= utilisateur.getId() %>" />

            <div class="mb-3">
                <label class="form-label">Nom complet</label>
                <input type="text" name="nom" class="form-control" value="<%= utilisateur.getNom() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" value="<%= utilisateur.getEmail() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Mot de passe</label>
                <input type="password" name="motdepasse" class="form-control" value="<%= utilisateur.getMotDePasse() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Rôle</label>
                <select name="role" class="form-select" required>
                    <option value="admin" <%= utilisateur.getRole().equals("admin") ? "selected" : "" %>>Administrateur</option>
                    <option value="user" <%= utilisateur.getRole().equals("user") ? "selected" : "" %>>Utilisateur</option>
                </select>
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-warning">Mettre à jour</button>
                <a href="UtilisateurController" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
