<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de Conta</title>
        <link href="style/style.css" rel="stylesheet">
        <link href="style/bootstrap.css" rel="stylesheet">
        <link href="style/all.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="navbar.html" />
            <div class="mt-5">
                <h3>Cadastro</h3>

                <form>
                    <label for="nome">Nome</label><br>
                    <input type="text" id="nome" name="nome" placeholder="Seu nome"><br><br>

                    <label for="email">E-mail:</label><br>
                    <input type="email" id="email" name="email" placeholder="Seu e-mail"><br>

                    <input type="submit" value="Enviar" onclick="validar()">
                </form>




                <jsp:include page="rodape.html" />
                <script src="bootstrap/bootstrap.bundle.min.js"></script>
            </div>
        </div>
    </body>
</html>

