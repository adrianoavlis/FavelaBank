package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

    /**
     * CRUD CREATE *
     */
    public void inserirConta(Correntista conta) {
        Conexao con = new Conexao();

        try {
            con.conectar();
            PreparedStatement pst = con.getConnection()
                    .prepareStatement("insert into contas (nome, email, cpf, senha, telefone, adm) values (?,?,?,?,?)");
            pst.setString(1, conta.getUsuario().getNome());
            pst.setString(2, conta.getUsuario().getEmail());
            pst.setString(3, conta.getUsuario().getCpf());
            pst.setString(4, conta.getUsuario().getSenha());
            pst.setString(5, conta.getUsuario().getTelefone());
            pst.setBoolean(6, conta.getUsuario().isAdm());
            // executar a query
            pst.executeUpdate();
            // fechar conexão
            con.closeConnection();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * CRUD READ *
     */
    public ArrayList<Correntista> listarContas() {
        ArrayList<Correntista> contas = new ArrayList<Correntista>();
        Conexao con = new Conexao();
        try {
            con.conectar();
            PreparedStatement pst = con.getConnection().prepareStatement("select * from contas order by nome");
            ResultSet retornos = pst.executeQuery();

            // sera executado enquanto houver contatos
            while (retornos.next()) {
                Correntista conta = new Correntista();
                conta.getUsuario().setId(Integer.parseInt(retornos.getString(1)));
                conta.getUsuario().setNome(retornos.getString(2));
                conta.getUsuario().setEmail(retornos.getString(3));
                conta.getUsuario().setCpf(retornos.getString(4));
                conta.getUsuario().setSenha(retornos.getString(5));
                conta.getUsuario().setTelefone(retornos.getString(6));
                conta.getUsuario().setAdm(retornos.getBoolean(7));

                // populando o Array
                contas.add(conta);
            }
            con.closeConnection();
            return contas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    // CRUD UPDATE
    // Selecionar o Contato
    public void selecionarConta(Correntista conta) throws SQLException {
        Conexao con = new Conexao();
        try {
            con.conectar();
            PreparedStatement pst = con.getConnection().prepareStatement("select * from contas where idcon = ?");
            pst.setInt(1, conta.getUsuario().getId());
            ResultSet retorno = pst.executeQuery();
            if (retorno.next()) {

                conta.getUsuario().setId(retorno.getInt(1));
                conta.getUsuario().setNome(retorno.getString(2));
                conta.getUsuario().setEmail(retorno.getString(3));
                conta.getUsuario().setCpf(retorno.getString(4));
                conta.getUsuario().setSenha(retorno.getString(5));
                conta.getUsuario().setTelefone(retorno.getString(6));
                conta.getUsuario().setAdm(retorno.getBoolean(6));

                System.out.println(retorno.getString(1));
            }
            con.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e + " erro na query");

        }

    }

    /**
     * Editar um Contato *
     */
    public void alterarContato(Correntista conta) {
        Conexao con = new Conexao();
        try {
            con.conectar();
            PreparedStatement pst = con.getConnection()
                    .prepareStatement("update contas set nome=?, email=?, cpf=? , senha=? where idcon=?");
            pst.setString(1, conta.getUsuario().getNome());
            pst.setString(2, conta.getUsuario().getEmail());
            pst.setString(3, conta.getUsuario().getCpf());
            pst.setString(4, conta.getUsuario().getSenha());
            pst.setInt(5, conta.getUsuario().getId());
            pst.executeUpdate();
            con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * CRUD DELETE *
     */
    public void deletarContato(Correntista conta) {
        Conexao con = new Conexao();
        try {
            con.conectar();
            PreparedStatement pst = con.getConnection().prepareStatement("delete from contas where idcon=?");
            pst.setInt(1, conta.getUsuario().getId());
            pst.executeUpdate();
            con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
      public ArrayList<Transacao> listarTransacoes(Correntista conta){
         ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
        Conexao con = new Conexao();
        try {
            con.conectar();            
            PreparedStatement pst = con.getConnection().prepareStatement("select * from transacoes where idUder=?");
             pst.setInt(1, conta.getUsuario().getId());
            ResultSet retorno = pst.executeQuery();

            // sera executado enquanto houver contatos
            while (retorno.next()) {
                Correntista account = new Correntista();
                Transacao transacao = new Transacao();
                transacao.setId(retorno.getInt(1));
                transacao.setData(retorno.getString(3));
                transacao.setTipo(retorno.getString(4));
                transacao.setValor(retorno.getDouble(5));
                transacao.setSaldo(retorno.getDouble(6));
              
                // populando o Array
                transacoes.add(transacao);
            }
            con.closeConnection();
            return transacoes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

          
      }
      public Correntista Logar(Correntista conta) throws Exception {
        Conexao con = new Conexao();
        try {
            con.conectar();
            PreparedStatement sql = con.getConnection().prepareStatement("SELECT * FROM contas WHERE cpf=? and senha =? LIMIT 1");
            sql.setString(1, conta.getUsuario().getCpf());
            sql.setString(2, conta.getUsuario().getSenha());
            ResultSet resultado = sql.executeQuery();
          Correntista usuarioObtido = new Correntista();
            if (resultado != null) {
                while (resultado.next()) {
                    usuarioObtido.getUsuario().setId(Integer.parseInt(resultado.getString("ID")));
                    usuarioObtido. getUsuario().setNome(resultado.getString("NOME"));
                    usuarioObtido. getUsuario().setEmail(resultado.getString("EMAIL"));
                    usuarioObtido. getUsuario().setCpf(resultado.getString("CPF"));
                    usuarioObtido. getUsuario().setSenha(resultado.getString("SENHA"));
                    usuarioObtido. getUsuario().setTelefone(resultado.getString("TELEFONE"));
                }
            }
            return usuarioObtido;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            con.closeConnection();
        }
    }

}
