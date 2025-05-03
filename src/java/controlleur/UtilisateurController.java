package controleur;

import entities.Utilisateur;
import service.UtilisateurService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/UtilisateurController")
public class UtilisateurController extends HttpServlet {

    private UtilisateurService utilisateurService;

    @Override
    public void init() throws ServletException {
        utilisateurService = new UtilisateurService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    if (action == null || action.equals("liste")) {
        List<Utilisateur> utilisateurs = utilisateurService.findAll();
        request.setAttribute("utilisateurs", utilisateurs);
        request.getRequestDispatcher("listeUtilisateurs.jsp").forward(request, response);
    } else if (action.equals("addForm")) {
        request.getRequestDispatcher("ajouterUtilisateur.jsp").forward(request, response);
    } else if (action.equals("editForm")) {
        int id = Integer.parseInt(request.getParameter("id"));
        Utilisateur user = utilisateurService.findById(id);
        request.setAttribute("utilisateur", user);
        request.getRequestDispatcher("modifierUtilisateur.jsp").forward(request, response);
    } else if (action.equals("delete")) {
        int id = Integer.parseInt(request.getParameter("id"));
        utilisateurService.delete(utilisateurService.findById(id));
        response.sendRedirect("UtilisateurController");
    }
}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motdepasse = request.getParameter("motdepasse");
        String role = request.getParameter("role");

        if (action.equals("add")) {
            Utilisateur user = new Utilisateur();
            user.setNom(nom);
            user.setEmail(email);
           user.setMotDePasse(motdepasse);
            user.setRole(role);
            utilisateurService.create(user);
            response.sendRedirect("UtilisateurController");
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Utilisateur user = utilisateurService.findById(id);
            user.setNom(nom);
            user.setEmail(email);
            user.setMotDePasse(motdepasse);
            user.setRole(role);
            utilisateurService.update(user);
            response.sendRedirect("UtilisateurController");
        }
    }
}
