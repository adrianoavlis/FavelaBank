package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;
import aplicacao.Usuario;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");

        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        RequestDispatcher rd;
        switch (acao) {
            case "Listar":
                try {
                    ArrayList<aplicacao.Usuario> listaUsuarios = usuarioDAO.ListaDeUsuarios();
                    request.setAttribute("msgOperacaoRealizada", "");
                    request.setAttribute("listaUsuarios", listaUsuarios);
                    rd = request.getRequestDispatcher("/view/usuario/listaUsuarios.jsp");
                    rd.forward(request, response);

                } catch (IOException | ServletException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha na query listar usuarios (Usuario) ");
                }
                break;
            case "Alterar":
            case "Excluir":
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    usuario = usuarioDAO.getUsuario(id);
                    usuario.setId(id);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException("Falha em uma query para cadastro de usuario");
                }
                break;

        }
        request.setAttribute("usuario", usuario);
        request.setAttribute("msgError", "");
        request.setAttribute("acao", acao);

        rd = request.getRequestDispatcher("view/usuario/formUsuario.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome_user = request.getParameter("nome");
        String email_user = request.getParameter("email");
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        String telefone_user = request.getParameter("telefone");
        String btEnviar = request.getParameter("btEnviar");

        RequestDispatcher rd;

        if (nome_user.isEmpty() || cpf_user.isEmpty() || email_user.isEmpty() || senha_user.isEmpty()||telefone_user.isEmpty()) {

            Usuario usuario = new Usuario();
            switch (btEnviar) {
                case "Incluir":
                    request.setAttribute("acao", "Incluir");
                    break;
                case "Alterar":
                case "Excluir":
                    try {
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        usuario = usuarioDAO.getUsuario(id);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        throw new RuntimeException("Falha em uma query para cadastro de usuario");
                    }
                    break;
            }

            request.setAttribute("msgError", "É necessário preencher todos os campos");
            request.setAttribute("usuario", usuario);

            rd = request.getRequestDispatcher("/../webapp/view/usuario/formUsuario.jsp");
            rd.forward(request, response);

        } else {

            Usuario usuario = new Usuario();
            usuario.setNome(nome_user);
            usuario.setEmail(email_user);
            usuario.setCpf( cpf_user);
            usuario.setSenha(senha_user);
            usuario.setTelefone(telefone_user);
            usuario.setId(id);

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            try {
                switch (btEnviar) {
                    case "Incluir":
                        usuarioDAO.Inserir(usuario);
                        request.setAttribute("msgOperacaoRealizada", "Inclusão realizada com sucesso");
                        break;
                    case "Alterar":
                        usuarioDAO.Alterar(usuario);
                        request.setAttribute("msgOperacaoRealizada", "Alteração realizada com sucesso");
                        break;
                    case "Excluir":
                        usuarioDAO.Excluir(usuario);
                        request.setAttribute("msgOperacaoRealizada", "Exclusão realizada com sucesso");
                        break;
                }

                ArrayList<aplicacao.Usuario> listaUsuarios = usuarioDAO.ListaDeUsuarios();
                request.setAttribute("listaUsuarios", listaUsuarios);

                rd = request.getRequestDispatcher("/../webapp/view/usuario/#AREARESTRITA_ADM_LISTARUSUARIO.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha em uma query para cadastro de usuario");
            }
        }
    }
}
