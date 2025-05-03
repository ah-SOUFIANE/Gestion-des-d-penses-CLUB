package controlleur;

import dao2.UtilisateurDao;
import entities.Utilisateur;
import utils.HashUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Authentification", urlPatterns = {"/Authentification"})
public class Authentification extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String motDePasse = request.getParameter("motDePasse");

            if (email == null || motDePasse == null) {
                response.sendRedirect("login.jsp?msg=Champs manquants");
                return;
            }

            // Hash du mot de passe avec SHA-256
            String hashedPassword = HashUtil.sha256(motDePasse);

            UtilisateurDao dao = new UtilisateurDao();
            Utilisateur user = dao.findByEmailAndPassword(email, hashedPassword); // méthode à créer dans UtilisateurDao

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", user); // attribut commun

                // Redirection selon le rôle
                if ("admin".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect("adminDashboard.jsp");
                } else {
                    response.sendRedirect("userDashboard.jsp");
                }
            } else {
                response.sendRedirect("login.jsp?msg=Mot de passe incorrect ou email invalide");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?msg=Erreur serveur");
        }
    }

    @Override
    public String getServletInfo() {
        return "Contrôleur d'authentification de l'utilisateur";
    }
}
