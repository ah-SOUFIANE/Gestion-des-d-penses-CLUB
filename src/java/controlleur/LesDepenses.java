package controlleur;

import entities.Depense;
import service.DepenseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/LesDepenses")
public class LesDepenses extends HttpServlet {

    private final DepenseService depenseService = new DepenseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Récupérer toutes les dépenses
        List<Depense> depenses = depenseService.findAll();

        // ✅ Les envoyer à la JSP
        request.setAttribute("depenses", depenseService.findAll());
        request.getRequestDispatcher("lesDepenses.jsp").forward(request, response);
    }
}
