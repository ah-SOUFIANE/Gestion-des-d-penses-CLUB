package controleur;

import entities.Club;
import service.ClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClubController")
public class ClubController extends HttpServlet {

    private ClubService service;

    @Override
    public void init() {
        service = new ClubService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("liste")) {
            List<Club> clubs = service.findAll();
            req.setAttribute("clubs", clubs);
            req.getRequestDispatcher("listeClubs.jsp").forward(req, resp);
        } else if (action.equals("addForm")) {
            req.getRequestDispatcher("ajouterClub.jsp").forward(req, resp);
        } else if (action.equals("editForm")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Club club = service.findById(id);
            req.setAttribute("club", club);
            req.getRequestDispatcher("modifierClub.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            service.delete(service.findById(id));
            resp.sendRedirect("ClubController");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String nom = req.getParameter("nom");

        if (action.equals("add")) {
            Club c = new Club();
            c.setNom(nom);
            service.create(c);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Club c = service.findById(id);
            c.setNom(nom);
            service.update(c);
        }
        resp.sendRedirect("ClubController");
    }
}
