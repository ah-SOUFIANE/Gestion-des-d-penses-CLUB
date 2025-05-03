package controleur;

import entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Query;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/UserDashboardController")
public class UserDashboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Utilisateur user = (Utilisateur) httpSession.getAttribute("utilisateur");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery(
            "SELECT d.categorie.nom, SUM(d.montant) " +
            "FROM Depense d WHERE d.utilisateur.id = :id " +
            "GROUP BY d.categorie.nom"
        );
        q.setParameter("id", user.getId());

        List<Object[]> result = q.list();
        List<String> labelsUserCat = new ArrayList<>();
        List<Double> dataUserCat = new ArrayList<>();
        for (Object[] row : result) {
            labelsUserCat.add((String) row[0]);
            dataUserCat.add((Double) row[1]);
        }

        session.close();

        request.setAttribute("labelsUserCat", labelsUserCat);
        request.setAttribute("dataUserCat", dataUserCat);

        request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
    }
}
