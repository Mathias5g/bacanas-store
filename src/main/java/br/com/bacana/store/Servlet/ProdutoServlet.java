package br.com.bacana.store.Servlet;

import br.com.bacana.store.Dao.CategoriaDao;
import br.com.bacana.store.Dao.ProdutoDao;
import br.com.bacana.store.Model.Categoria;
import br.com.bacana.store.Model.Produto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Produto", value = "/admin/produto")
public class ProdutoServlet extends HttpServlet {

    private RequestDispatcher view;
    private HttpSession session;
    private final ProdutoDao produtoDao;
    private Produto produto;
    private final String INDEX_PRODUTO = "/admin/produto/index.jsp";
    private final String EDITAR_PRODUTO = "/admin/produto/produtoForm.jsp";
    private final String EXIBIR_PRODUTO = "/admin/produto/produtoForm.jsp";
    private final String INDEX_SITE = "/index.jsp";

    public ProdutoServlet() throws SQLException, ClassNotFoundException {
        super();
        view = null;
        produtoDao = new ProdutoDao();
        produto = new Produto();
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
                int produtoId = Integer.parseInt(request.getParameter("id"));
                Produto produto = produtoDao.readProduto(produtoId);
                request.setAttribute("produto", produto);
                forward = EDITAR_PRODUTO;
            } else if(acao.equalsIgnoreCase("inserir")) {
                forward = EXIBIR_PRODUTO;
            } else if (acao.equalsIgnoreCase("deletar")) {
                int produtoId = Integer.parseInt(request.getParameter("id"));
                produtoDao.deleteProduto(produtoId);
                List<Produto> produtos = produtoDao.getAllProduto();
                request.setAttribute("produtos", produtos);
                forward = INDEX_PRODUTO;
            }
        } else {
            List<Produto> produtos = produtoDao.getAllProduto();
            request.setAttribute("produtos", produtos);
            forward = INDEX_PRODUTO;
        }

        request.setCharacterEncoding("UTF-8");
        view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto();
        produto.setCodigo(request.getParameter("codigo"));
        produto.setProduto(request.getParameter("produto"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setPreco(Double.parseDouble(request.getParameter("preco")));
        produto.setCategoria(Integer.parseInt(request.getParameter("categoria_id")));

        session = request.getSession();
        String checked = (String) session.getAttribute("authenticated");

        if(!Objects.equals(checked, "autenticado")) {
            view = request.getRequestDispatcher(INDEX_SITE);
            view.forward(request, response);
        }

        String produtoId = request.getParameter("id");

        if(produtoId == null || produtoId.isEmpty()) {
            produtoDao.createProduto(produto);
        } else {
            produto.setId(Integer.parseInt(produtoId));
            produtoDao.updateProduto(produto);
        }

        List<Produto> produtos = produtoDao.getAllProduto();
        request.setAttribute("produtos", produtos);
        view = request.getRequestDispatcher(INDEX_PRODUTO);
        view.forward(request, response);
    }

}
