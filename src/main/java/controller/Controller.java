package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.Correntista;
import model.Transacao;

@WebServlet(urlPatterns = {"/Controller", "/mainAdm","/mainUser", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    DAO dao = new DAO();
    Correntista conta = new Correntista();

    public Controller() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        if (action.equals("/mainAdm")) {
            contas(request, response);
        } else if (action.equals("/mainUser")) {
            minhaConta(request, response);
        } else if (action.equals("/insert")) {
            novaConta(request, response);
        } else if (action.equals("/select")) {
            listarContas(request, response);
        } else if (action.equals("/update")) {
            editarContato(request, response);
        } else if (action.equals("/delete")) {
            deletarContato(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    // Listar Contatos
    protected void contas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Correntista> contas = dao.listarContas();

        // encaminhar lista para area do ADM
        request.setAttribute("contas", contas);
        RequestDispatcher rd = request.getRequestDispatcher("areaAdm.jsp");
        rd.forward(request, response);
    }
     protected void minhaConta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
       
        Correntista conta = new Correntista();
        conta.getUsuario().setId((int) request.getSession().getAttribute("id"));
        
        ArrayList<Transacao> transacoes = dao.listarTransacoes(conta);

        // encaminhar lista para area do ADM
        request.setAttribute("transacoes", transacoes);
        RequestDispatcher rd = request.getRequestDispatcher("areaUsuario.jsp");
        rd.forward(request, response);
    }

    // Novo Contatos
    protected void novaConta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // teste de recebimento dos dados do formulario
        System.out.println(request.getParameter("nome"));

        // Setar contatos JavaBeans
        conta.getUsuario().setNome(request.getParameter("nome"));
        conta.getUsuario().setEmail(request.getParameter("email"));
        conta.getUsuario().setCpf(request.getParameter("cpf"));
        conta.getUsuario().setSenha(request.getParameter("senha"));
        conta.getUsuario().setTelefone(request.getParameter("Telefone"));

        // invocar DAO passando o objeto
        dao.inserirConta(conta);

        // Redirecionar para main.jsp
        response.sendRedirect("main");

    }

    // Editar Contato
    protected void listarContas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // setar JavaBeans
        conta.getUsuario().setId(Integer.parseInt(request.getParameter("id")));

        // executar método selecionar contato (DAO)
        try {
            dao.selecionarConta(conta);
        } catch (SQLException e) {

            System.out.println(e);
        }

        // Setar o conteúdo do form com o objeto
        request.setAttribute("id", conta.getUsuario().getId());
        request.setAttribute("nome", conta.getUsuario().getNome());
        request.setAttribute("email", conta.getUsuario().getEmail());
        request.setAttribute("cpf", conta.getUsuario().getCpf());
        request.setAttribute("telefone", conta.getUsuario().getTelefone());

        // Encaminhar para editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);

    }

    protected void editarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Setar dados do form para o objeto
        conta.getUsuario().setId(Integer.parseInt(request.getParameter("idcon")));
        conta.getUsuario().setNome(request.getParameter("nome"));
        conta.getUsuario().setEmail(request.getParameter("fone"));
        conta.getUsuario().setCpf(request.getParameter("email"));
        conta.getUsuario().setSenha(request.getParameter("senha"));
        conta.getUsuario().setTelefone(request.getParameter("telefone"));
        dao.alterarContato(conta);

        // Redirecionar para o agenda.jsp
        response.sendRedirect("areaAdm.jsp");
    }

    // Remover um Contato
    protected void deletarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Setar Variável id no Objeto
        conta.getUsuario().setId(Integer.parseInt(request.getParameter("id")));
        // Executar o método deletarContato(DAO) passando o objeto
        dao.deletarContato(conta);
        // Redirecionar para o agenda.jsp
        response.sendRedirect("areaAdm.jsp");

    }

}
