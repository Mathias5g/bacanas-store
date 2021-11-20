<jsp:useBean id="categoria" scope="request" type="br.com.bacana.store.Model.Categoria"/>
<jsp:include page="../layout/header.jsp" />
<div class="container d-flex flex-column">
  <form class="d-flex flex-column justify-content-center border border-2 rounded p-2" method="POST" action='CategoriaServlet' name="frmAddUser">
    <img class="w-25 align-self-center border border-2 rounded mb-2" src="https://rihappy.vtexassets.com/arquivos/ids/863509-500-auto?v=637395995789130000&width=500&height=auto&aspect=true" alt="...">
    <div class="input-group mb-3">
      <span class="input-group-text" >ID</span>
      <input type="file" class="form-control" value="${categoria.get()}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" >ID</span>
      <input type="text" class="form-control" value="${categoria.getId()}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="basic-addon3">Categoria</span>
      <input type="text" class="form-control" value="${categoria.getCategoria()}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">Linha</span>
      <input type="text" class="form-control" value="${categoria.getLinha()}">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text">Faixa Etaria</span>
      <input type="text" class="form-control" value="${categoria.getFaixaEtaria()}">
    </div>
    <button type="submit" class="btn btn-primary">SALVAR</button>
  </form>
</div>
<jsp:include page="../layout/footer.jsp" />

