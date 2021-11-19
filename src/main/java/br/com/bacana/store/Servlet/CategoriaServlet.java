package br.com.bacana.store.Servlet;

import br.com.bacana.store.Dao.CategoriaDao;
import br.com.bacana.store.Model.Categoria;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "Categoria", value = "/admin/categoria")
public class CategoriaServlet extends HttpServlet {

    private RequestDispatcher view;
    private HttpSession session;
    private CategoriaDao categoriaDao;
    private Categoria categoria;
    private final String INDEX_CATEGORIA = "/admin/categoria/index.jsp";
    private final String EDITAR_CATEGORIA = "/admin/categoria/index.jsp";
    private final String EXIBIR_CATEGORIA = "/admin/categoria/index.jsp";
    private final String INDEX_SITE = "/index.jsp";

    public CategoriaServlet() throws SQLException, ClassNotFoundException {
        super();
        view = null;
        categoriaDao = new CategoriaDao();
        categoria = new Categoria();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String acao = request.getParameter("acao");

        session = request.getSession();
        String checked = (String) session.getAttribute("authenticated");

        if(!Objects.equals(checked, "autenticado")) {
            view = request.getRequestDispatcher(INDEX_SITE);
            view.forward(request, response);
        }

        if(acao.equalsIgnoreCase("editar")) {
            try {
                categoriaDao.readCategoria(8);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            forward = EDITAR_CATEGORIA;
        } else if(acao.equalsIgnoreCase("exibir")) {
            try {
                categoriaDao.readCategoria(8);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            forward = EXIBIR_CATEGORIA;
        } else {
            forward = INDEX_CATEGORIA;
        }


        view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoria.setCategoria(request.getParameter("categoria"));
        categoria.setLinha(request.getParameter("linha"));
        categoria.setFaixaEtaria(request.getParameter("faixa_etaria"));

        try {
            categoriaDao.createCategoria(categoria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoria.setId(Integer.parseInt(request.getParameter("id")));
        categoria.setCategoria(request.getParameter("categoria"));
        categoria.setLinha(request.getParameter("linha"));
        categoria.setFaixaEtaria(request.getParameter("faixa_etaria"));
        try {
            categoriaDao.updateCategoria(categoria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoria.setId(Integer.parseInt(request.getParameter("id")));
        try {
            categoriaDao.deleteCategoria(categoria.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
