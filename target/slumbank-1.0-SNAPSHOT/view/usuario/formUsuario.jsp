<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="aplicação.Usuario"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuario</title>
        <link href="../style/bootstrap.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">
            <jsp:include page="/../webapp/building/menu.jsp" />
            <div class="row mt-5">
                <div class="col-sm-4 offset-3">
                    <%
                        Usuario usuario = (Usuario) request.getAttribute("usuario");
                        String acao = (String) request.getAttribute("acao");
                        switch (acao) {
                            case "Incluir":
                                out.println("<h1>Incluir Usuário</h1>");
                                break;
                            case "Alterar":
                                out.println("<h1>Alterar Usuário</h1>");
                                break;
                            case "Excluir":
                                out.println("<h1>Excluir Usuário</h1>");
                                break;
                        }

                        String msgError = (String) request.getAttribute("msgError");
                        if ((msgError != null) && (!msgError.isEmpty())) {%>
                    <div class="alert alert-danger" role="alert">
                        <%= msgError%>
                    </div>
                    <% }%>

                    <form action="UsuarioController" method="POST">
                        <input type="hidden" name="id" value="<%=usuario.getId()%>" class="form-control">
                        <div class="mb-3">
                            <label for="nome" class="form-label">Nome</label>
                            <input type="text" name="nome" <%= acao.equals("Excluir") ? "Readonly" : ""%> value="<%=usuario.getNome()%>" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label" >EMAIL</label>
                            <input type="text" name="email" <%= acao.equals("Excluir") ? "Readonly" : ""%> value="<%=usuario.getEmail()%>" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="cpf" class="form-label" >CPF</label>
                            <input type="text" name="cpf" <%= acao.equals("Excluir") ? "Readonly" : ""%> value="<%=usuario.getCpf()%>" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="senha" class="form-label" >Senha</label>
                            <input type="text" name="senha" <%= acao.equals("Excluir") ? "Readonly" : ""%> value="<%=usuario.getSenha()%>" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="telefone" class="form-label" >Telefone</label>
                            <input type="text" name="telefone" <%= acao.equals("Excluir") ? "Readonly" : ""%> value="<%=usuario.getTelefone()%>" class="form-control">
                        </div>
                        <div>
                            <input type="submit" name="btEnviar" value="<%=acao%>" class="btn btn-primary">
                            <a href="UsuarioController?acao=Listar" class="btn btn-danger">Retornar</a>
                        </div>
                    </form>
                    <div>
                    </div>
                </div>
                <script src="../scripts/bootstrap.bundle.min.js"></script>
                </body>

                </html>