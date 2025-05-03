<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Categorie" %>
<jsp:include page="header.jsp" />

<%
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
%>

<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Gestion des Catégories</h2>
</div>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h5 class="mb-0">Liste des catégories enregistrées</h5>
        <a href="CategorieController?action=addForm" class="btn btn-success">+ Ajouter</a>
    </div>

    <div class="table-responsive">
        <table class="table table-bordered table-striped shadow-sm">
            <thead class="table-dark text-center">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th style="width: 180px;">Actions</th>
                </tr>
            </thead>
            <tbody class="text-center">
            <%
                if (categories != null && !categories.isEmpty()) {
                    for (Categorie c : categories) {
            %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getNom() %></td>
                    <td>
                        <a href="CategorieController?action=editForm&id=<%= c.getId() %>" class="btn btn-sm btn-warning">Modifier</a>
                        <a href="CategorieController?action=delete&id=<%= c.getId() %>" class="btn btn-sm btn-danger" onclick="return confirm('Supprimer cette catégorie ?')">Supprimer</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="3" class="text-center">Aucune catégorie trouvée.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp" />
