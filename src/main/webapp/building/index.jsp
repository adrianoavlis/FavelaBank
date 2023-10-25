<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Favela Bank</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="estilos.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <!-- login !-->
    <!-- TODO: Ver a questão de como será feita a autentificação do login (op1: cpf op2: email) !-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 bg-light p-5">
                <img src="https://media.discordapp.net/attachments/963533169708134463/1166426317890261072/OIG.png" alt="Imagem do Banco" class="img-fluid">
            </div>
            <div class="col-md-6 d-flex align-items-center justify-content-center">
                <div class="w-75 text-center">
                    <img src="https://media.discordapp.net/attachments/963533169708134463/1166479547840090203/OIG.51t5Dx_P0SKgz-removebg-preview.png" alt="Sua Descrição" class="img-fluid mb-3">
                    <h2>Login</h2>
                    <form action="dashboard.jsp" method="post">
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Senha</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Entrar</button>
        </form>
                </div>
            </div>
        </div>
    </div>

    <div id="sobre" class="p-4">
        <div class="row">
            <div class="col-md-6 text-center text-md-left">
                <h2>Sobre o Banco</h2>
                <p>
                    Bem-vindo ao FavelaBank, um inovador banco comunitário que está transformando a forma como as
                    comunidades de baixa renda lidam com suas finanças. Com um compromisso dedicado a promover a inclusão
                    financeira e empoderar indivíduos em favelas e áreas desfavorecidas, o FavelaBank está redefinindo o
                    significado
                    de bancos tradicionais. Nossa missão é criar oportunidades financeiras acessíveis, fomentar o crescimento
                    econômico
                    local e capacitar os residentes de favelas a construir um futuro financeiro mais brilhante. Descubra como o
                    FavelaBank está se tornando um catalisador de mudanças positivas nas comunidades que atendemos e saiba como
                    você
                    pode fazer parte dessa transformação. Junte-se a nós enquanto exploramos as possibilidades de um amanhã
                    financeiro
                    mais igualitário e próspero.
                </p>
                <div class="row mt-4">
                    <div class="col text-center">
                        <a href="cadastro.html" class="btn btn-primary">Abra já a sua conta</a>
                    </div>
                </div>
            </div>
            <!-- TODO: AJUSTAR RESPOSIVIDADE DO CARROSSEL -->
            <div id="carousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://emprestimosim.com.br/wp-content/uploads/2021/04/Blog_imagem_2-3-1024x681.jpg" class="d-block w-100" style="height: 600px" alt="Imagem Sobre 1">
        </div>
        <div class="carousel-item">
            <img src="https://media.discordapp.net/attachments/963533169708134463/1166440462865928232/financas-pessoais.png" class="d-block w-100" style="height: 600px" alt="Imagem Sobre 2">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carousels" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Anterior</span>
    </a>
    <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Próximo</span>
    </a>
        </div>
    </div>
</body>
</html>
