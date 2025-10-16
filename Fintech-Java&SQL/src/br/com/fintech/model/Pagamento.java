package br.com.fintech.model;

import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private int idConta;
    private String tipoPagamento;
    private double valor;
    private Date dataPagamento;
    private String descricao;
    private String status;

    // Construtor completo (com ID)
    public Pagamento(int idPagamento, int idConta, String tipoPagamento, double valor, Date dataPagamento, String descricao, String status) {
        this.idPagamento = idPagamento;
        this.idConta = idConta;
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.descricao = descricao;
        this.status = status;
    }

    // Getters e Setters
    public int getIdPagamento() { return idPagamento; }
    public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }
    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }
    public String getTipoPagamento() { return tipoPagamento; }
    public void setTipoPagamento(String tipoPagamento) { this.tipoPagamento = tipoPagamento; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public Date getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(Date dataPagamento) { this.dataPagamento = dataPagamento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}