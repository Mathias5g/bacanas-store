package br.com.bacana.store.Servlet;

import br.com.bacana.store.Dao.UsuarioDao;
import br.com.bacana.store.Model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "Admin", value = "/admin")
public class AdminServlet extends HttpServlet {

    private final String INDEX_SITE = "/index.jsp";
    private final String INDEX_ADM = "/admin/index.jsp";
    private RequestDispatcher view;
    private final UsuarioDao usuarioDao;

    public AdminServlet() throws SQLException, ClassNotFoundException {
        super();
        view = null;
        usuarioDao = new UsuarioDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        view = request.getRequestDispatcher(INDEX_ADM);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (request.getParameter("usuario"));
        String password = (request.getParameter("senha"));

        if(Objects.equals(email, "") || Objects.equals(password, "")) {
            view = request.getRequestDispatcher(INDEX_SITE);
            view.forward(request, response);
        }

        try {

            Usuario getUsuario = usuarioDao.ReadUser(email, password);

            if(getUsuario.getId() > 0) {
                view = request.getRequestDispatcher(INDEX_ADM);
            } else {
                view = request.getRequestDispatcher(INDEX_SITE);
            }
            view.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
