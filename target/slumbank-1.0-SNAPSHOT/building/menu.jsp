<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Usuario" %>
    <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="container-fluid">
            <a class="navbar-brand text-center ms-2" href="#">
                <img src="https://banco.bradesco/assets/prime/img/home/moeda-estrangeira.png" width="50px">
            </a>


            <a class="nav-link" href="index.html">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">

                    <% // testar se está logado HttpSession sessao=request.getSession(false); if (sessao !=null) {
                        Usuario usuarioLogado=(Usuario) session.getAttribute("usuarioAdm"); if (usuarioLogado !=null) {
                        %>
                        <% if (usuarioLogado!= null){ %>
                            <a class="nav-link" href="index.jsp">Home </a>
                            <a class="nav-link" href="#">A SlumBank</a>
                            <a class="nav-link" href="DashboardController">Dashboard</a>
                            <a class="nav-link" href="UsuarioController?acao=Listar">Usuários</a>
                            <a class="nav-link" href="AutenticaController?acao=Logout">Logout</a>
                            <% } else {%>
                                <a class="nav-link" href="index.jsp">Home </a>
                                <a class="nav-link" href="#">A SlumBank</a>
                                <a class="nav-link" href="DashboardController">Dashboard</a>
                                <a class="nav-link" href="AutenticaController?acao=Logout">Logout</a>
                                
                                    <% } }%>

                </div>
            </div>
        </div>
    </nav>