<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Minha Conta</title>
    </head>
    <body>

        <jsp:include page="navbar.html"/>
        <h1>Bank</h1>
        <h2><%= //saldo%></h2><br><br>
        <button type="button" class="btn ms-auto">
            <a href="saque.html"></a>
        </button>
        
        <button type="button" class="btn ms-auto">
                <a class="nav-item nav-link" id="btNav" href="conta.jsp">
                    Acessar
                </a>
            </button>
        
        
        
    </body>
</html>
