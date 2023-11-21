<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="model.Correntista"%>
<%@ page import="java.util.ArrayList"%>
<%
    ArrayList<Correntista> lista_contas = (ArrayList<Correntista>) request.getAttribute("contas");
%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Agenda de Contatos</title>
        <link rel="icon" href="imagens/9110984_call_phone_icon.png">
        <link rel="stylesheet" href="style/style.css">
    </head>
    <body>
        <h1>Agenda de Contas</h1>
        <a href="cadastro.html" >Novo Conta</a>

        <table id="tabela">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>CPF</th>
                    <th>Telefone</th>
                    <th>Opcões</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Correntista> correntistas;
                    if (lista_contas != null) {
                        for (int i = 0; i < lista_contas.size(); i++) {
                %>
                <tr>
                    <td><%=lista_contas.get(i).getUsuario().getId()%></td>
                    <td><%=lista_contas.get(i).getUsuario().getNome()%></td>
                    <td><%=lista_contas.get(i).getUsuario().getEmail()%></td>
                    <td><%=lista_contas.get(i).getUsuario().getCpf()%></td>
                    <td><%=lista_contas.get(i).getUsuario().getTelefone()%></td>
                    <td>
                        <a href="select?idcon=<%=lista_contas.get(i).getUsuario().getId()%>">Editar</a> 
                        <a href="javascript: confirmar(<%=lista_contas.get(i).getUsuario().getId()%>)">Excluir</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <script src="scripts/script.js"></script>
    </body>
</html>