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
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Categoria", value = "/admin/categoria")
public class CategoriaServlet extends HttpServlet {

    private RequestDispatcher view;
    private HttpSession session;
    private CategoriaDao categoriaDao;
    private Categoria categoria;
    private final String INDEX_CATEGORIA = "/admin/categoria/index.jsp";
    private final String EDITAR_CATEGORIA = "/admin/categoria/categoriaForm.jsp";
    private final String EXIBIR_CATEGORIA = "/admin/categoria/categoriaForm.jsp";
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

        if(acao != null) {
            if(acao.equalsIgnoreCase("editar")) {
                int categoriaId = Integer.parseInt(request.getParameter("id"));
                Categoria categoria = categoriaDao.readCategoria(categoriaId);
                request.setAttribute("categoria", categoria);
                forward = EDITAR_CATEGORIA;
            } else if(acao.equalsIgnoreCase("inserir")) {
                forward = EXIBIR_CATEGORIA;
            } else if (acao.equalsIgnoreCase("deletar")) {
                int categoriaId = Integer.parseInt(request.getParameter("id"));
                categoriaDao.deleteCategoria(categoriaId);
                List<Categoria> categorias = categoriaDao.getAllCategoria();
                request.setAttribute("categorias", categorias);
                forward = INDEX_CATEGORIA;
            }
        } else {
            List<Categoria> categorias = categoriaDao.getAllCategoria();
            request.setAttribute("categorias", categorias);
            forward = INDEX_CATEGORIA;
        }

        view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categoria categoria = new Categoria();
        categoria.setCodigo(request.getParameter("codigo"));
        categoria.setCategoria(request.getParameter("categoria"));
        categoria.setLinha(request.getParameter("linha"));
        categoria.setFaixaEtaria(request.getParameter("faixa_etaria"));

        session = request.getSession();
        String checked = (String) session.getAttribute("authenticated");

        if(!Objects.equals(checked, "autenticado")) {
            view = request.getRequestDispatcher(INDEX_SITE);
            view.forward(request, response);
        }

        String categoriaId = request.getParameter("id");

        System.out.println(categoriaId);

        if(categoriaId == null || categoriaId.isEmpty()) {
            categoriaDao.createCategoria(categoria);
        } else {
            categoria.setId(Integer.parseInt(categoriaId));
            categoriaDao.updateCategoria(categoria);
        }

        List<Categoria> categorias = categoriaDao.getAllCategoria();
        request.setAttribute("categorias", categorias);
        view = request.getRequestDispatcher(INDEX_CATEGORIA);
        view.forward(request, response);
    }

}
