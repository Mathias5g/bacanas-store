<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/header.jsp" />
<div class="container d-flex flex-column">
    <form class="d-flex flex-column justify-content-center border border-2 rounded p-2" method="POST" action='${pageContext.request.contextPath}/admin/categoria'>
        <div class="input-group mb-3">
            <span class="input-group-text">Codigo</span>
            <input type="text" class="form-control" value="<c:out value="${categoria.getCodigo()}" />" maxlength="6" name="codigo">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon3">Categoria</span>
            <input type="text" class="form-control" value="${categoria.getCategoria()}" name="categoria">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Linha</span>
            <input type="text" class="form-control" value="${categoria.getLinha()}" name="linha">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Faixa Etaria</span>
            <select class="form-select" name="faixa_etaria">
                <option value="${categoria.getFaixaEtaria()}" selected>${categoria.getFaixaEtaria()}</option>
                <option value="0 a 12 meses">0 a 12 meses</option>
                <option value="1 a 2 anos">1 a 2 anos</option>
                <option value="3 a 4 anos">3 a 4 anos</option>
                <option value="5 a 6 anos">5 a 6 anos</option>
                <option value="7 a 8 anos">7 a 8 anos</option>
                <option value="9 a 10 anos">9 a 10 anos</option>
                <option value="11 anos ou mais">11 anos ou mais</option>
            </select>
        </div>
        <input type="hidden" class="form-control" value="${categoria.getId()}" name="id">
        <button type="submit" class="btn btn-primary">SALVAR</button>
    </form>
</div>
<jsp:include page="../layout/footer.jsp" />

