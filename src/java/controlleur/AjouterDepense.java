package controleur;

import entities.Categorie;
import entities.Club;
import entities.Depense;
import entities.Utilisateur;
import service.CategorieService;
import service.ClubService;
import service.DepenseService;
import service.UtilisateurService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ajouterDepense")
public class AjouterDepense extends HttpServlet {

    private final CategorieService categorieService = new CategorieService();
    private final ClubService clubService = new ClubService();
    private final DepenseService depenseService = new DepenseService();
    private final UtilisateurService utilisateurService = new UtilisateurService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Categorie> categories = categorieService.findAll();
        List<Club> clubs = clubService.findAll();

        request.setAttribute("categories", categories);
        request.setAttribute("clubs", clubs);

        request.getRequestDispatcher("ajouterDepense.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession(false);
            Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateur");

            Utilisateur utilisateur = utilisateurService.findById(utilisateurSession.getId());

            String libelle = request.getParameter("libelle");
            double montant = Double.parseDouble(request.getParameter("montant"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));

            int catId = Integer.parseInt(request.getParameter("categorie"));
            int clubId = Integer.parseInt(request.getParameter("club"));

            Categorie categorie = categorieService.findById(catId);
            Club club = clubService.findById(clubId);

            Depense dep = new Depense();
            dep.setLibelle(libelle);
            dep.setMontant(montant);
            dep.setDate(date);
            dep.setCategorie(categorie);
            dep.setClub(club);
            dep.setUtilisateur(utilisateur);

            boolean ok = depenseService.create(dep);

            if (ok) {
                response.sendRedirect("MesDepenses?success=1");
            } else {
                response.sendRedirect("ajouterDepense.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ajouterDepense.jsp?error=1");
        }
    }
}
