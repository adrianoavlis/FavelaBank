package controller;

import model.Correntista;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;

@WebServlet(name = "AutenticaController", urlPatterns = {"/AutenticaController"})
public class AutenticaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = (String) request.getParameter("acao");
        RequestDispatcher rd;
        switch (acao) {
            case "Login":  // chama form de login

                rd = request.getRequestDispatcher("/view/formLogin.jsp");
                rd.forward(request, response);

                break;
            case "Logout":
                HttpSession session = request.getSession();
                session.invalidate();
                rd = request.getRequestDispatcher("/view/formLogin.jsp");
                rd.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        // pegando os parâmetros do request
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        if (cpf_user.isEmpty() || senha_user.isEmpty()) {
            // dados não foram preenchidos retorna ao formulário
            request.setAttribute("msgError", "Usuário e/ou senha incorreto");
            rd = request.getRequestDispatcher("/view/formLogin.jsp");
            rd.forward(request, response);

        } else {
            Correntista usuarioObtido;
            Correntista usuario = new Correntista();
            usuario.getUsuario().setCpf(cpf_user);
            usuario.getUsuario().setSenha(senha_user);
            DAO dao = new DAO();
            try {
                usuarioObtido = dao.Logar(usuario);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException("Falha na query para Logar");
            }

            if (usuarioObtido.getUsuario().getId() != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarioObtido.getUsuario().getId());
                if (usuarioObtido.getUsuario().isAdm()) {
                    rd = request.getRequestDispatcher("/mainAdm");
                    rd.forward(request, response);
                }
                rd = request.getRequestDispatcher("/mainUser");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                rd = request.getRequestDispatcher("/view/autenticacao/formLogin.jsp");
                rd.forward(request, response);
            }
        }
    }

}
