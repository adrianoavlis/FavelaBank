package aplicacao;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private String telefone;
    private boolean adm =false;

    public Usuario(int id_user, String nome, String email, String cpf, String senha, String telefone) {
        this.id = id_user;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.telefone = telefone;
        this.adm = false;
    }

    public Usuario(){}

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public boolean isAdm(){
    return this.adm;
    }

    public void setAdm(boolean adm){
    this.adm = adm;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\''
            + '}';
            }
}
