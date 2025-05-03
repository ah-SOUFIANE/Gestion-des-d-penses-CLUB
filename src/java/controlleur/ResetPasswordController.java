package controleur;

import utils.EmailSender;
import dao2.UtilisateurDao;
import entities.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ResetPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        UtilisateurDao dao = new UtilisateurDao();
        Utilisateur user = dao.findByEmail(email);

        if (user != null) {
            // ✅ Génère un mot de passe temporaire sécurisé
            String newPassword = EmailSender.generateTemporaryPassword();
            
            // 🔐 Hacher le mot de passe (optionnel, recommandé)
            // user.setMotDePasse(HashUtil.hashPassword(newPassword));
            user.setMotDePasse(newPassword);

            dao.update(user);

            // ✅ Envoie de l'e-mail
            boolean sent = EmailSender.sendPasswordResetEmail(email, newPassword);

            if (sent) {
                response.sendRedirect("login.jsp?reset=success");
            } else {
                response.sendRedirect("resetPassword.jsp?error=mailfail");
            }

        } else {
            response.sendRedirect("resetPassword.jsp?error=notfound");
        }
    }
}
