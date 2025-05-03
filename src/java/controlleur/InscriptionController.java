package controleur;

import dao2.UtilisateurDao;
import entities.Utilisateur;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class InscriptionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motdepasse = request.getParameter("motdepasse");

        UtilisateurDao dao = new UtilisateurDao();
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setEmail(email);
        user.setMotDePasse(motdepasse); // Tu peux aussi chiffrer ici
        user.setRole("user");

        dao.create(user);

        response.sendRedirect("login.jsp?success=1");
    }
}
