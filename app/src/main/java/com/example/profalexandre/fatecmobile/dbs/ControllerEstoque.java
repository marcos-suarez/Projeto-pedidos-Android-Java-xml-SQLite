package com.example.profalexandre.fatecmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.profalexandre.fatecmobile.modelos.EstoqueBean;
import java.util.ArrayList;
import java.util.List;

public class ControllerEstoque {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerEstoque(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(EstoqueBean est) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", est.getNome());
        valores.put("CIDADE", est.getCidade());
        valores.put("CONTAS", est.getContas());
        valores.put("ID_PRODUTO", est.getIdProd());
        valores.put("QTD_PRODUTO", est.getQtdProd());
        resultado = db.insert(BancoHelper.TABELA4, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(EstoqueBean est) {
        String retorno = "Resgistro Excluido com Sucesso";
        String where = "ID = " + est.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA4,where,null);
        db.close();
        return retorno;
    }

    public String alterar(EstoqueBean est) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + est.getId();
        valores = new ContentValues();
        valores.put("NOME", est.getNome());
        valores.put("CIDADE", est.getCidade());
        valores.put("CONTAS", est.getContas());
        valores.put("ID_PRODUTO", est.getIdProd());
        valores.put("QTD_PRODUTO", est.getQtdProd());
        db.update(BancoHelper.TABELA4, valores,where,null);
        db.close();
        return retorno;
    }

    public List<EstoqueBean> listarEstoques() {
        List<EstoqueBean> estoques = new ArrayList<EstoqueBean>();
        String selectQuery = "SELECT * FROM ESTOQUES";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                EstoqueBean est = new EstoqueBean();
                est.setId(""+cursor.getInt(0));
                est.setNome(cursor.getString(1));
                est.setCidade(cursor.getString(2));
                est.setContas(cursor.getString(3));
                est.setIdProd(cursor.getString(4));
                est.setQtdProd(cursor.getString(5));

                estoques.add(est);
            } while (cursor.moveToNext());
        }
        return estoques;
    }

    public List<EstoqueBean> listarEstoques(EstoqueBean estEnt) {
        List<EstoqueBean> estoques = new ArrayList<EstoqueBean>();
        String parametro = estEnt.getNome();
        String selectQuery = "SELECT ID, NOME, CIDADE, CONTAS, ID_PRODUTO, QTD_PRODUTO FROM ESTOQUES WHERE NOME LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                EstoqueBean est = new EstoqueBean();
                est.setId(""+cursor.getInt(0));
                est.setNome(cursor.getString(1));
                est.setCidade(cursor.getString(2));
                est.setContas(cursor.getString(3));
                est.setIdProd(cursor.getString(4));
                est.setQtdProd(cursor.getString(5));

                estoques.add(est);
            } while (cursor.moveToNext());
        }
        return estoques;
    }
}
