<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, entities.Depense" %>
<jsp:include page="header.jsp" />
<%
    List<Depense> depenses = (List<Depense>) request.getAttribute("depenses");
%>

<!-- Bandeau rouge pleine largeur -->
<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Mes Dépenses</h2>
</div>

<!-- Espace entre le titre et le contenu -->
<div class="container mt-4">

    <% if (depenses == null || depenses.isEmpty()) { %>
        <div class="alert alert-warning text-center">
            Aucune dépense trouvée pour cet utilisateur.
        </div>
        <div class="text-center mt-3">
            <a href="userDashboard.jsp" class="btn btn-secondary">Retour au tableau de bord</a>
        </div>
    <% } else { %>
        <div class="table-responsive">
            <table class="table table-bordered shadow-sm">
                <thead class="table-dark text-center">
                    <tr>
                        <th>#</th>
                        <th>Libellé</th>
                        <th>Montant</th>
                        <th>Date</th>
                        <th>Catégorie</th>
                        <th>Club</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                    <% int i = 1;
                       for (Depense d : depenses) { %>
                        <tr>
                            <td><%= i++ %></td>
                            <td><%= d.getLibelle() %></td>
                            <td><%= d.getMontant() %> DH</td>
                            <td><%= d.getDate() %></td>
                            <td><%= d.getCategorie().getNom() %></td>
                            <td><%= d.getClub().getNom() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    <% } %>

</div>

<script>
    setTimeout(function () {
        const alert = document.getElementById("successAlert");
        if (alert) {
            alert.style.display = "none";
        }
    }, 3000);
</script>

<jsp:include page="footer.jsp" />
