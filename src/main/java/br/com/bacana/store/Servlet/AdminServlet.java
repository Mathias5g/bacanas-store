package br.com.bacana.store.Servlet;

import br.com.bacana.store.Model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "Admin", value = "/admin")
public class AdminServlet extends HttpServlet {

    public AdminServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String INDEX_ADM = "/admin/index.jsp";
        RequestDispatcher view = request.getRequestDispatcher(INDEX_ADM);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String INDEX_SITE = "/index.jsp";
        Usuario usuario = new Usuario();
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setPassword(request.getParameter("senha"));

        if(Objects.equals(usuario.getUsuario(), "") || Objects.equals(usuario.getPassword(), "")) {
            RequestDispatcher view = request.getRequestDispatcher(INDEX_SITE);
            view.forward(request, response);
        }

    }
}
