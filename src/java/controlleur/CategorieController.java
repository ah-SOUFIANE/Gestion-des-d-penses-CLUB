package controleur;

import entities.Categorie;
import service.CategorieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/CategorieController")
public class CategorieController extends HttpServlet {

    private CategorieService service;

    @Override
    public void init() {
        service = new CategorieService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("liste")) {
            List<Categorie> categories = service.findAll();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("listeCategories.jsp").forward(req, resp);
        } else if (action.equals("addForm")) {
            req.getRequestDispatcher("ajouterCategorie.jsp").forward(req, resp);
        } else if (action.equals("editForm")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Categorie cat = service.findById(id);
            req.setAttribute("categorie", cat);
            req.getRequestDispatcher("modifierCategorie.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            service.delete(service.findById(id));
            resp.sendRedirect("CategorieController");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String nom = req.getParameter("nom");

        if (action.equals("add")) {
            Categorie cat = new Categorie();
            cat.setNom(nom);
            service.create(cat);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Categorie cat = service.findById(id);
            cat.setNom(nom);
            service.update(cat);
        }
        resp.sendRedirect("CategorieController");
    }
}
