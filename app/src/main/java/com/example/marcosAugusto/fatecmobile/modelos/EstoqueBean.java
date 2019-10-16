package com.example.marcosAugusto.fatecmobile.modelos;

import java.io.Serializable;

public class EstoqueBean implements Serializable {

    String id;
    String nome;
    String cidade;
    String contas;
    String idProd;
    String qtdProd;


    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getContas() {
        return contas;
    }

    public void setContas(String contas) {
        this.contas = contas;
    }

    public String getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(String qtdProd) {
        this.qtdProd = qtdProd;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", contas='" + contas + '\'' +
                ", idProd='" + idProd + '\'' +
                ", qtdProd='" + qtdProd + '\'' +
                '}';
    }
}
