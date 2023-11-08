package aplicacao;

import java.util.ArrayList;

public class Correntista {

    private Usuario usuario;
    private double saldo;
    private ArrayList<Double> transacoes;

    public Correntista() {
    }

    public Correntista(Usuario usuario, double saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
        this.transacoes = new ArrayList();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            setTransacoes(saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    
    public ArrayList <Double> getTransacoes(){
    return this.transacoes;
    }
    
    public void setTransacoes(double valor ){
        this.transacoes.add(valor);
    }
    
            
    @Override
    public String toString() {
        return "Correntista [usuario=" + usuario + ", saldo=" + saldo + "]";
    }
}
