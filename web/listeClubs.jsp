<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Club" %>
<jsp:include page="header.jsp" />

<%
    List<Club> clubs = (List<Club>) request.getAttribute("clubs");
%>

<!-- ✅ Bandeau rouge pleine largeur -->
<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Gestion des Clubs</h2>
</div>

<!-- ✅ Contenu centré avec espacement -->
<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h5 class="mb-0">Liste des clubs enregistrés</h5>
        <a href="ClubController?action=addForm" class="btn btn-success">+ Ajouter</a>
    </div>

    <div class="table-responsive">
        <table class="table table-bordered table-striped shadow-sm">
            <thead class="table-dark text-center">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th style="width: 150px;">Actions</th>
                </tr>
            </thead>
            <tbody class="text-center">
            <%
                if (clubs != null && !clubs.isEmpty()) {
                    for (Club c : clubs) {
            %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getNom() %></td>
                    <td>
                        <a href="ClubController?action=editForm&id=<%= c.getId() %>" class="btn btn-sm btn-warning">Modifier</a>
                        <a href="ClubController?action=delete&id=<%= c.getId() %>" class="btn btn-sm btn-danger" onclick="return confirm('Supprimer ce club ?')">Supprimer</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="3" class="text-center">Aucun club trouvé.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp" />
