<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Usuario" %>
<!DOCTYPE html>
<html lang="pt-br">
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../../style/bootstrap.css"  rel="stylesheet"> 
        <title>Pagina Restrita do Usuário</title>
    </head>
    <body>
        <h1>Área Restrita</h1>
      <div class="container">
            <jsp:include page="../../menu.jsp" />
            <div class="mt-5">

                <h1>Área Restrita</h1>
                <%
                    Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
                    out.println("<h3>Usuário logado com sucesso</h3>");
                    out.println("<h2>Nome: " + usuarioLogado.getNome() + "</h2>");
                    out.println("<h2>CPF: " + usuarioLogado.getCpf()+ "</h2>");
                    out.println("<h2>Endereco: " + usuarioLogado.getTelefone() + "</h2>");
                    
                    
                %>


            </div>
        </div>
                <script src="../../scripts/bootstrap.bundle.min.js"></script>
    </body>
</html>
