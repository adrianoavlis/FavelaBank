package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacao.Usuario;

/*
-- Estrutura da tabela `usuarios`

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `senha` varchar(8) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

 */
public class UsuarioDAO {

    public void Inserir(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO usuarios (nome, email, cpf, senha, telefone)"
                    + " VALUES (?,?,?,?,?)");
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getEmail());
            sql.setString(3, usuario.getCpf());
            sql.setString(4, usuario.getSenha());
            sql.setString(5, usuario.getTelefone());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Usuario getUsuario(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Usuario usuario = new Usuario();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM usuarios WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    usuario.setId(Integer.parseInt(resultado.getString("ID")));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setEmail(resultado.getString("EMAIL"));
                    usuario.setCpf(resultado.getString("CPF"));
                    usuario.setSenha(resultado.getString("SENHA"));
                    usuario.setTelefone(resultado.getString("TELEFONE"));
                }
            }
            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Usuario Usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE usuarios SET nome = ?, email = ?, cpf = ?, senha = ?, telefone = ?  WHERE ID = ? ");
            sql.setString(1, Usuario.getNome());
            sql.setString(2, Usuario.getEmail());
            sql.setString(3, Usuario.getCpf());
            sql.setString(4, Usuario.getSenha());
            sql.setString(5, Usuario.getTelefone());
            sql.setInt(6, Usuario.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Usuario Usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM usuarios WHERE ID = ? ");
            sql.setInt(1, Usuario.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Usuario> ListaDeUsuarios() {
        ArrayList<Usuario> meusUsuarios = new ArrayList<Usuario>();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM usuarios order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                            usuario.setNome(resultado.getString("NOME"));
                            usuario.setNome(resultado.getString("EMAIL"));
                            usuario.setCpf(resultado.getString("CPF"));
                            usuario.setSenha(resultado.getString("SENHA"));
                            usuario.setTelefone(resultado.getString("TELEFONE"));
                    usuario.setId(Integer.parseInt(resultado.getString("id")));
                    meusUsuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeUsuarios) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusUsuarios;
    }

    public Usuario Logar(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM usuarios WHERE cpf=? and senha =? LIMIT 1");
            sql.setString(1, usuario.getCpf());
            sql.setString(2, usuario.getSenha());
            ResultSet resultado = sql.executeQuery();
            Usuario usuarioObtido = new Usuario();
            if (resultado != null) {
                while (resultado.next()) {
                    usuarioObtido.setId(Integer.parseInt(resultado.getString("ID")));
                    usuarioObtido.setNome(resultado.getString("NOME"));
                    usuarioObtido.setEmail(resultado.getString("EMAIL"));
                    usuarioObtido.setCpf(resultado.getString("CPF"));
                    usuarioObtido.setSenha(resultado.getString("SENHA"));
                    usuarioObtido.setSenha(resultado.getString("TELEFONE"));
                }
            }
            return usuarioObtido;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

}
