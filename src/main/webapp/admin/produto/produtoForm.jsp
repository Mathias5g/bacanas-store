<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/header.jsp" />
<div class="container d-flex flex-column">
  <form class="d-flex flex-column justify-content-center border border-2 rounded p-2" method="POST" action='${pageContext.request.contextPath}/admin/produto'>
    <div class="input-group mb-3">
      <span class="input-group-text">Codigo</span>
      <input type="text" class="form-control" value="<c:out value="${produto.getCodigo()}" />" maxlength="6" name="codigo">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="basic-addon3">Produto</span>
      <input type="text" class="form-control" value="${produto.getProduto()}" name="produto">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">Preço</span>
      <input type="text" class="form-control" value="${categoria.getPreco()}" name="preco">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">Categoria</span>
      <select class="form-select" name="categoria_id">
        <option value="1" selected>${categoria.getCategoria()}</option>
        <option value="2">0 a 12 meses</option>
        <option value="3">1 a 2 anos</option>
      </select>
    </div>
    <textarea class="input-group mb-3" name="descricao"></textarea>
    <input type="hidden" class="form-control" value="${produto.getId()}" name="id">
    <button type="submit" class="btn btn-primary">SALVAR</button>
  </form>
</div>
<jsp:include page="../layout/footer.jsp" />

