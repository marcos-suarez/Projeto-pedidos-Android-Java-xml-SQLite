package com.example.profalexandre.fatecmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.profalexandre.fatecmobile.modelos.PedidoBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerPedido {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerPedido(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(PedidoBean ped) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("ID_CLI", ped.getIdCli());
        valores.put("ID_PROD", ped.getIdProd());
        valores.put("ID_EST", ped.getIdEst());
        valores.put("VALOR", ped.getValor());
        resultado = db.insert(BancoHelper.TABELA5, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(PedidoBean ped) {
        String retorno = "Resgistro Excluido com Sucesso";
        String where = "ID = " + ped.getIdPed();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA5,where,null);
        db.close();
        return retorno;
    }

    public String alterar(PedidoBean ped) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + ped.getIdPed();
        valores = new ContentValues();
        valores.put("ID_CLI", ped.getIdCli());
        valores.put("ID_PROD", ped.getIdProd());
        valores.put("ID_EST", ped.getIdProd());
        valores.put("VALOR", ped.getValor());
        db.update(BancoHelper.TABELA5, valores,where,null);
        db.close();
        return retorno;
    }

    public List<PedidoBean> listarPedidos() {
        List<PedidoBean> pedidos = new ArrayList<PedidoBean>();
        String selectQuery = "SELECT * FROM PEDIDOS";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                PedidoBean ped = new PedidoBean();
                ped.setIdPed(""+cursor.getInt(0));
                ped.setIdCli(cursor.getString(1));
                ped.setIdProd(cursor.getString(2));
                ped.setIdEst(cursor.getString(3));
                ped.setValor(cursor.getString(4));

                pedidos.add(ped);
            } while (cursor.moveToNext());
        }
        return pedidos;
    }

    public List<PedidoBean> listarPedidos(PedidoBean pedEnt) {
        List<PedidoBean> pedidos = new ArrayList<PedidoBean>();
        String parametro = pedEnt.getIdPed();
        String selectQuery = "SELECT ID, ID_CLI, ID_PROD, ID_EST, VALOR FROM PEDIDOS WHERE ID LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                PedidoBean ped = new PedidoBean();
                ped.setIdPed(""+cursor.getInt(0));
                ped.setIdCli(cursor.getString(1));
                ped.setIdProd(cursor.getString(2));
                ped.setIdEst(cursor.getString(3));
                ped.setValor(cursor.getString(4));

                pedidos.add(ped);
            } while (cursor.moveToNext());
        }
        return pedidos;
    }
}
