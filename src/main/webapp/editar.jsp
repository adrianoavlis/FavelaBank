<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulário de Cadastro de Correntista</title>
        <link rel="stylesheet" href="style/bootstrap.css">
        <link href="style/style.css" rel="stylesheet">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-ligth bg-ligth">
            <div class="container">
                <a class="navbar-brand text-center ms-2" href="index.html">
                    <img src="https://media.discordapp.net/attachments/963533169708134463/1166479547840090203/OIG.51t5Dx_P0SKgz-removebg-preview.png" width="50px">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="saque.html">Saque</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="transferencia.html">Transferência de Saldo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cadastro.html">Ediatr de Conta</a>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>


        <div class="container">
            <h1 class="text-center">Editar Contato</h1>
            <form name="frmContato" action="update">
                <table>
                    <tr>
                        <td><input type="text" name="idcon" id="caixa3" readonly value="<%out.print(request.getAttribute("id"));%>"></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="email" value="<%out.print(request.getAttribute("email"));%>"></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="cpf" class="caixa1" value="<%out.print(request.getAttribute("cpf"));%>"></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="senha"  value="<%out.print(request.getAttribute("senha"));%>"></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="telefone" value="<%out.print(request.getAttribute("telefone"));%>"></td>
                    </tr>
                </table>
                <input type="button" class="botao1" onclick="validar()" value="Salvar">
            </form>
        </div>

        <div class="footer fixed-bottom text-center">
            &copy; 2023 Sistema Bancário
        </div>

        <script src="scripts/script.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
