package br.com.bacana.store.Servlet;

import br.com.bacana.store.Utils.SessionCheck;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "ProdutoServlet", value = "/admin/produto")
public class ProdutoServlet extends HttpServlet {

    private RequestDispatcher view;
    private HttpSession session;
    private final String INDEX_SITE = "/index.jsp";
    private final String INDEX_PRODUTO = "/admin/produto/index.jsp";

    public ProdutoServlet() {
        super();
        view = null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();
        String checked = (String) session.getAttribute("authenticated");

        if(!Objects.equals(checked, "autenticado")) {
            view = request.getRequestDispatcher(INDEX_SITE);
            view.forward(request, response);
        }

        view = request.getRequestDispatcher(INDEX_PRODUTO);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
