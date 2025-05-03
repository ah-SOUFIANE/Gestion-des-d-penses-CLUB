<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<jsp:include page="header.jsp" />

<%
    List<String> labelsCat = (List<String>) request.getAttribute("labelsCat");
    if (labelsCat == null) labelsCat = new ArrayList<String>();

    List<Double> dataCat = (List<Double>) request.getAttribute("dataCat");
    if (dataCat == null) dataCat = new ArrayList<Double>();

    List<String> labelsClub = (List<String>) request.getAttribute("labelsClub");
    if (labelsClub == null) labelsClub = new ArrayList<String>();

    List<Double> dataClub = (List<Double>) request.getAttribute("dataClub");
    if (dataClub == null) dataClub = new ArrayList<Double>();

    List<String> labelsUser = (List<String>) request.getAttribute("labelsUser");
    if (labelsUser == null) labelsUser = new ArrayList<String>();

    List<Double> dataUser = (List<Double>) request.getAttribute("dataUser");
    if (dataUser == null) dataUser = new ArrayList<Double>();
%>

<!-- ✅ Bandeau rouge plein écran -->
<div style="width: 100vw; margin-left: calc(-50vw + 50%);" class="bg-danger py-4 text-center">
    <h2 class="text-white fw-bold m-0">Tableau de bord</h2>
</div>

<!-- ✅ Graphiques dans une seule rangée -->
<div class="container mt-4">
    <div class="row">
        <!-- Catégorie -->
        <div class="col-md-4 mb-4">
            <div class="card p-3 shadow-sm">
                <h5 class="text-center">Dépenses par catégorie</h5>
                <canvas id="categorieChart" height="200"></canvas>
            </div>
        </div>

        <!-- Club -->
        <div class="col-md-4 mb-4">
            <div class="card p-3 shadow-sm">
                <h5 class="text-center">Dépenses par club</h5>
                <canvas id="clubChart" height="200"></canvas>
            </div>
        </div>

        <!-- Utilisateur -->
        <div class="col-md-4 mb-4">
            <div class="card p-3 shadow-sm">
                <h5 class="text-center">Dépenses par utilisateur</h5>
                <canvas id="userChart" height="200"></canvas>
            </div>
        </div>
    </div>
</div>

<!-- ✅ Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
    const labelsCat = <%= labelsCat.toString().replace("[", "['").replace("]", "']").replace(", ", "', '") %>;
    const dataCat = <%= dataCat.toString() %>;

    const labelsClub = <%= labelsClub.toString().replace("[", "['").replace("]", "']").replace(", ", "', '") %>;
    const dataClub = <%= dataClub.toString() %>;

    const labelsUser = <%= labelsUser.toString().replace("[", "['").replace("]", "']").replace(", ", "', '") %>;
    const dataUser = <%= dataUser.toString() %>;

    new Chart(document.getElementById("categorieChart"), {
        type: 'bar',
        data: {
            labels: labelsCat,
            datasets: [{
                label: 'Montant total',
                data: dataCat,
                backgroundColor: '#0d6efd'
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: { beginAtZero: true }
            }
        }
    });

    new Chart(document.getElementById("clubChart"), {
        type: 'pie',
        data: {
            labels: labelsClub,
            datasets: [{
                label: 'Montant total',
                data: dataClub,
                backgroundColor: ['#f94144', '#f3722c', '#f9c74f', '#90be6d', '#43aa8b']
            }]
        },
        options: {
            responsive: true
        }
    });

    new Chart(document.getElementById("userChart"), {
        type: 'doughnut',
        data: {
            labels: labelsUser,
            datasets: [{
                label: 'Montant total',
                data: dataUser,
                backgroundColor: ['#ff6384', '#36a2eb', '#ffcd56', '#4bc0c0', '#9966ff', '#ff9f40']
            }]
        },
        options: {
            responsive: true
        }
    });
</script>

<jsp:include page="footer.jsp" />
