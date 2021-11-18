<jsp:include page="../layout/header.jsp" />
<div class="container d-flex flex-column">
    <button type="button" class="btn btn-info mb-2 align-self-end" style="width: 20%; color: white">ADICIONAR USUARIO</button>
    <table class="table table-hover border rounded">
        <thead>
        <tr>
            <th scope="col">USUARIO</th>
            <th scope="col">NOME</th>
            <th scope="col">EMAIL</th>
            <th scope="col">ACOES</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>mathias</td>
            <td>Leandro Mathias</td>
            <td>mathias5g@hotmail.com</td>
            <td>
                <button type="button" class="btn btn-primary"><i class="fas pencil-alt fa-5x"></i></button>
                <button type="button" class="btn btn-warning"><i class="fas trash-alt fa-5x"></i></button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../layout/footer.jsp" />