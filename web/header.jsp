<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Utilisateur" %>
<%
    Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String currentPage = request.getServletPath().substring(1);
%>

<!-- Bootstrap & FontAwesome -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<!-- Style navbar -->
<style>
    .navbar-light .navbar-nav .nav-link {
        font-weight: 500;
        margin-right: 18px;
        color: #000;
        text-transform: uppercase;
        border-bottom: 2px solid transparent;
        padding-bottom: 4px;
        transition: all 0.3s ease;
    }

    .navbar-light .navbar-nav .nav-link.active {
        color: #f7444e !important;
        border-bottom: 2px solid #f7444e !important;
        font-weight: bold;
    }

    .navbar-light .navbar-nav .nav-link:hover {
        color: #f7444e !important;
    }
</style>

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm py-3">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold d-flex align-items-center" href="index.jsp">
            <i class="fa fa-shopping-cart me-2"></i>
            Gestion<span style="color:#f7444e;">Dépenses</span>
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav mx-auto">
                <!-- ✅ Lien dynamique du tableau de bord -->
                <li class="nav-item">
                    <a class="nav-link 
                        <%= currentPage.equals("StatistiquesController") || currentPage.equals("UserDashboardController") ? "active" : "" %>"
                       href="<%= "admin".equals(user.getRole()) ? "StatistiquesController" : "UserDashboardController" %>">
                        Tableau de bord
                    </a>
                </li>

                <% if ("admin".equals(user.getRole())) { %>
                    <li class="nav-item">
                        <a class="nav-link <%= currentPage.equals("ajouterDepense") ? "active" : "" %>" href="ajouterDepense">
                            Ajouter une dépense
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= currentPage.equals("UtilisateurController") ? "active" : "" %>" href="UtilisateurController">
                            Utilisateurs
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= currentPage.equals("CategorieController") ? "active" : "" %>" href="CategorieController">
                            Catégories
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= currentPage.equals("ClubController") ? "active" : "" %>" href="ClubController">
                            Clubs
                        </a>
                    </li>
                <% } else { %>
                    <li class="nav-item">
                        <a class="nav-link <%= currentPage.equals("ajouterDepenseUser") ? "active" : "" %>" href="ajouterDepenseUser">
                            Ajouter une dépense
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%= currentPage.equals("MesDepenses") ? "active" : "" %>" href="MesDepenses">
                            Mes dépenses
                        </a>
                    </li>
                <% } %>
            </ul>

            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="btn btn-outline-danger btn-sm" href="deconnexion.jsp">Se déconnecter</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Script pour activer le lien cliqué -->
<script>
document.addEventListener('DOMContentLoaded', function () {
    const navLinks = document.querySelectorAll('.navbar-light .navbar-nav .nav-link');
    const currentPath = window.location.pathname;

    navLinks.forEach(link => {
        const href = link.getAttribute("href");
        if (currentPath.includes(href)) {
            navLinks.forEach(l => l.classList.remove('active'));
            link.classList.add('active');
        }

        link.addEventListener('click', function () {
            navLinks.forEach(l => l.classList.remove('active'));
            this.classList.add('active');
        });
    });
});
</script>
