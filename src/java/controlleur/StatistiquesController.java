package controleur;

import org.hibernate.Session;
import org.hibernate.Query; // ✅ Hibernate 4
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/StatistiquesController")
public class StatistiquesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // ✅ Requête 1 : Dépenses par catégorie
        Query q1 = session.createQuery("SELECT d.categorie.nom, SUM(d.montant) FROM Depense d GROUP BY d.categorie.nom");
        List<Object[]> resultCat = q1.list();
        List<String> labelsCat = new ArrayList<>();
        List<Double> dataCat = new ArrayList<>();
        for (Object[] row : resultCat) {
            labelsCat.add((String) row[0]);
            dataCat.add((Double) row[1]);
        }

        // ✅ Requête 2 : Dépenses par club
        Query q2 = session.createQuery("SELECT d.club.nom, SUM(d.montant) FROM Depense d GROUP BY d.club.nom");
        List<Object[]> resultClub = q2.list();
        List<String> labelsClub = new ArrayList<>();
        List<Double> dataClub = new ArrayList<>();
        for (Object[] row : resultClub) {
            labelsClub.add((String) row[0]);
            dataClub.add((Double) row[1]);
        }

        // ✅ Requête 3 : Dépenses par utilisateur
        Query q3 = session.createQuery("SELECT d.utilisateur.nom, SUM(d.montant) FROM Depense d GROUP BY d.utilisateur.nom");
        List<Object[]> resultUser = q3.list();
        List<String> labelsUser = new ArrayList<>();
        List<Double> dataUser = new ArrayList<>();
        for (Object[] row : resultUser) {
            labelsUser.add((String) row[0]);
            dataUser.add((Double) row[1]);
        }

        session.close();

        request.setAttribute("labelsCat", labelsCat);
        request.setAttribute("dataCat", dataCat);
        request.setAttribute("labelsClub", labelsClub);
        request.setAttribute("dataClub", dataClub);
        request.setAttribute("labelsUser", labelsUser);
        request.setAttribute("dataUser", dataUser);

        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}
