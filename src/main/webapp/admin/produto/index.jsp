<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="produtos" scope="request" type="java.util.List"/>
<jsp:include page="../layout/header.jsp" />
<div class="container d-flex flex-column p-2">
    <a href="${pageContext.request.contextPath}/admin/produto?acao=inserir" class="btn btn-info mb-2 align-self-end" style="width: 20%; color: white">ADICIONAR PRODUTO</a>
    <table class="table table-hover border border-2 rounded">
        <thead>
        <tr>
            <th scope="col">CODIGO</th>
            <th scope="col">PRODUTO</th>
            <th scope="col">PREÇO</th>
            <th scope="col">CATEGORIA</th>
            <th scope="col" lang="pt-br">AÇÕES</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td class="text-uppercase">${produto.getCodigo()}</td>
                <td class="text-capitalize">${produto.getProduto()}</td>
                <td class="text-capitalize">${produto.getPreco()}</td>
                <td class="text-capitalize">${produto.getCategoria()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/produto?acao=exibir&id=${produto.getId()}" class="btn btn-primary"><i class="fas fa-eye"></i></a>
                    <a href="${pageContext.request.contextPath}/admin/produto?acao=editar&id=${produto.getId()}" class="btn btn-warning"><i class="fas fa-pen"></i></a>
                    <a href="${pageContext.request.contextPath}/admin/produto?acao=deletar&id=${produto.getId()}" class="btn btn-danger"><i class="fas fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../layout/footer.jsp" />