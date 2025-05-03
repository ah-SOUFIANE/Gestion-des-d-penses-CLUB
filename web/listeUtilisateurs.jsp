<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Utilisateur" %>
<jsp:include page="header.jsp" />

<%
    List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("utilisateurs");
%>

<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Gestion des utilisateurs</h2>
</div>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h5 class="mb-0">Liste des utilisateurs enregistrés</h5>
        <a href="UtilisateurController?action=addForm" class="btn btn-success">+ Ajouter</a>
    </div>

    <div class="table-responsive">
        <table class="table table-striped table-bordered shadow-sm text-center">
            <thead class="table-dark">
                <tr>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Rôle</th>
                    <th style="width: 150px;">Actions</th>
                </tr>
            </thead>
            <tbody>
            <%
                if (utilisateurs != null && !utilisateurs.isEmpty()) {
                    for (Utilisateur u : utilisateurs) {
            %>
                <tr>
                    <td><%= u.getNom() %></td>
                    <td><%= u.getEmail() %></td>
                    <td><%= u.getRole() %></td>
                    <td>
                        <a href="UtilisateurController?action=editForm&id=<%= u.getId() %>" class="btn btn-sm btn-warning">Modifier</a>
                        <a href="UtilisateurController?action=delete&id=<%= u.getId() %>" class="btn btn-sm btn-danger" onclick="return confirm('Supprimer cet utilisateur ?')">Supprimer</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4" class="text-center">Aucun utilisateur trouvé.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp" />
