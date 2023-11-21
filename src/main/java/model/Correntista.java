package model;

import java.sql.Date;
import model.Usuario;
import java.util.ArrayList;

public class Correntista {

    private Usuario usuario;
    private double saldo;
    private ArrayList<Transacao> transacoes;

    public Correntista() {
        this.usuario = new Usuario();
        this.saldo = saldo;
        this.transacoes = new ArrayList<Transacao>();
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
            Transacao transasao = new Transacao();
            transasao.setTipo("Débito");
            transasao.setValor(valor);
            transasao.setSaldo(saldo);
            this.transacoes.add(transasao);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public ArrayList<Transacao> getTransacoes() {
        return this.transacoes;
    }

    public void setTransacoes(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    @Override
    public String toString() {
        return "Correntista [usuario=" + usuario + ", saldo=" + saldo + "]";
    }
}
