package controleur;

import entities.Utilisateur;
import entities.Depense;
import service.DepenseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MesDepenses", urlPatterns = {"/MesDepenses"})
public class MesDepenses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // ✅ false pour ne pas créer de nouvelle session si inexistante

        if (session == null || session.getAttribute("utilisateur") == null) {
            response.sendRedirect("login.jsp?msg=Veuillez vous connecter");
            return;
        }

        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        // ✅ Appel du service pour récupérer les dépenses de l'utilisateur
        DepenseService depenseService = new DepenseService();
        List<Depense> depenses = depenseService.findByUtilisateur(utilisateur.getId());

        // ✅ Passage des données à la vue
        request.setAttribute("depenses", depenses);
        request.getRequestDispatcher("mesDepenses.jsp").forward(request, response);
    }

}
