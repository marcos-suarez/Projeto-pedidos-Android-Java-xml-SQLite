package com.example.marcosAugusto.fatecmobile.modelos;

import java.io.Serializable;

public class PedidoBean implements Serializable {
    String idPed;
    String idCli;
    String idProd;
    String idEst;
    String valor;

    public String getIdPed() {
        return idPed;
    }

    public void setIdPed(String idPed) {
        this.idPed = idPed;
    }

    public String getIdCli() {
        return idCli;
    }

    public void setIdCli(String idCli) {
        this.idCli = idCli;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIdEst() {
        return idEst;
    }

    public void setIdEst(String idEst) {
        this.idEst = idEst;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPed='" + idPed + '\'' +
                ", idCli='" + idCli + '\'' +
                ", idProd='" + idProd + '\'' +
                ", idEst='" + idEst + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
