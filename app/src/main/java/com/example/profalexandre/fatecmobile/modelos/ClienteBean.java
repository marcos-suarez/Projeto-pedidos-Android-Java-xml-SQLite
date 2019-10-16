package com.example.profalexandre.fatecmobile.modelos;

import java.io.Serializable;

public class ClienteBean implements Serializable {

    String id;
    String nome;
    String cpf;
    String datanasc;
    String cidade;



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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", datanasc='" + datanasc + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

}
