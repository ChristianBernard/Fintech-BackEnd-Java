package br.com.fintech.model;

import java.util.Date;

public class Conta {
    private int idConta;
    private String tipoConta;
    private double saldo;
    private String status;
    private Date dataAbertura;
    private int usuarioId;

    public Conta(int idConta, String tipoConta, double saldo, String status, Date dataAbertura, int usuarioId) {
        this.idConta = idConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.usuarioId = usuarioId;
    }

    public Conta(String tipoConta, double saldo, String status, Date dataAbertura, int usuarioId) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.usuarioId = usuarioId;
    }

    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }

    public String getTipoConta() { return tipoConta; }
    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(Date dataAbertura) { this.dataAbertura = dataAbertura; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
}