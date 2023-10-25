<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- ... outros elementos de cabeçalho ... -->
</head>
<body>
<!-- TODO: Usar os servlets nos 'ifs' pq ta feio demais isso kk !-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand text-center ms-2" href="index.jsp">
                <img src="https://media.discordapp.net/attachments/963533169708134463/1166479547840090203/OIG.51t5Dx_P0SKgz-removebg-preview.png" width="50px">
            </a>
            <a class="navbar-brand" href="#sobre">FavelaBank!</a>
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <% 
                       Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
                       String role = (String) session.getAttribute("role");

                       if (isLoggedIn == null || !isLoggedIn) {
                    %>
                        <li class="nav-item">
                            <a class="nav-link" href="cadastro.jsp">Cadastro de Correntista</a>
                        </li>
                    <% } else if ("USER".equals(role)) { %>
                        <li class="nav-item">
                            <a class="nav-link" href="saque.jsp">Saque</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="transferencia.jsp">Transferência de Saldo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout.jsp">Sair</a>
                        </li>
                    <% } else if ("ADMIN".equals(role)) { %>
                        <li class="nav-item">
                            <a class="nav-link" href="usuarios.jsp">Usuários</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="gerenciamento.jsp">Gerenciamento de Transferências</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout.jsp">Sair</a>
                        </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>

    <div class="footer fixed-bottom">
        &copy; 2023 Sistema Bancário
    </div>

</body>
</html>
