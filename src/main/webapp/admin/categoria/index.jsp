<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="categorias" scope="request" type="java.util.List"/>
<jsp:include page="../layout/header.jsp" />
<div class="container d-flex flex-column p-2">
    <a href="${pageContext.request.contextPath}/admin/categoria?acao=inserir" class="btn btn-info mb-2 align-self-end" style="width: 20%; color: white">ADICIONAR CATEGORIA</a>
    <table class="table table-hover border border-2 rounded">
        <thead>
        <tr>
            <th scope="col">CODIGO</th>
            <th scope="col">CATEGORIA</th>
            <th scope="col">LINHA</th>
            <th scope="col">FAIXA ETARIA</th>
            <th scope="col">ACOES</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categorias}" var="categoria">
            <tr>
                <td class="text-uppercase">${categoria.getCodigo()}</td>
                <td class="text-capitalize">${categoria.getCategoria()}</td>
                <td class="text-capitalize">${categoria.getLinha()}</td>
                <td class="text-capitalize">${categoria.getFaixaEtaria()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/categoria?acao=exibir&id=${categoria.getId()}" class="btn btn-primary"><i class="fas fa-eye"></i></a>
                    <a href="${pageContext.request.contextPath}/admin/categoria?acao=editar&id=${categoria.getId()}" class="btn btn-warning"><i class="fas fa-pen"></i></a>
                    <a href="${pageContext.request.contextPath}/admin/categoria?acao=deletar&id=${categoria.getId()}" class="btn btn-danger"><i class="fas fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../layout/footer.jsp" />