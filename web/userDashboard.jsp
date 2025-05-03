<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Utilisateur, java.util.List, java.util.ArrayList" %>
<jsp:include page="header.jsp" />

<%
    Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<String> labelsUserCat = (List<String>) request.getAttribute("labelsUserCat");
    if (labelsUserCat == null) labelsUserCat = new ArrayList<String>();

    List<Double> dataUserCat = (List<Double>) request.getAttribute("dataUserCat");
    if (dataUserCat == null) dataUserCat = new ArrayList<Double>();
%>


<!-- ✅ Bandeau rouge en pleine largeur -->
<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Tableau de bord</h2>
</div>

<!-- ✅ Contenu personnalisé -->
<div class="container mt-4">
    <div class="card card-welcome">
        <h4>Bienvenue, <%= user.getNom() %> !</h4>
        <p>Voici un aperçu de vos dépenses personnelles par catégorie.</p>
    </div>

    <div class="card p-3 shadow-sm mb-5">
        <h5 class="text-center">Mes dépenses par catégorie</h5>
        <canvas id="userCatChart" height="200"></canvas>
    </div>
</div>

<!-- ✅ Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    const labelsUserCat = <%= labelsUserCat.toString().replace("[", "['").replace("]", "']").replace(", ", "', '") %>;
    const dataUserCat = <%= dataUserCat.toString() %>;

    new Chart(document.getElementById("userCatChart"), {
        type: 'bar',
        data: {
            labels: labelsUserCat,
            datasets: [{
                label: 'Montant total',
                data: dataUserCat,
                backgroundColor: '#198754'
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: { beginAtZero: true }
            }
        }
    });
</script>

<!-- ✅ Style -->
<style>
    .card-welcome {
        background: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
        margin-bottom: 40px;
        text-align: center;
    }
</style>

<jsp:include page="footer.jsp" />
