package com.example.marcosAugusto.fatecmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.marcosAugusto.fatecmobile.modelos.ProdutoBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerProduto {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerProduto(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(ProdutoBean prod) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", prod.getNome());
        valores.put("TIPO", prod.getTipo());
        valores.put("QTD", prod.getQtd());
        valores.put("VALOR", prod.getValor());
        resultado = db.insert(BancoHelper.TABELA2, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(ProdutoBean prod) {
        String retorno = "Resgistro Excluido com Sucesso";
        String where = "ID = " + prod.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA2,where,null);
        db.close();
        return retorno;
    }

    public String alterar(ProdutoBean prod) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + prod.getId();
        valores = new ContentValues();
        valores.put("NOME", prod.getNome());
        valores.put("TIPO", prod.getTipo());
        valores.put("QTD", prod.getQtd());
        valores.put("VALOR", prod.getValor());
        db.update(BancoHelper.TABELA2, valores,where,null);
        db.close();
        return retorno;
    }

    public List<ProdutoBean> listarProdutos() {
        List<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
        String selectQuery = "SELECT * FROM PRODUTOS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ProdutoBean prod = new ProdutoBean();
                prod.setId(""+cursor.getInt(0));
                prod.setNome(cursor.getString(1));
                prod.setTipo(cursor.getString(2));
                prod.setQtd(cursor.getString(3));
                prod.setValor(cursor.getString(4));
                produtos.add(prod);
            } while (cursor.moveToNext());
        }
        return produtos;
    }

    public List<ProdutoBean> listarProdutos(ProdutoBean prodEnt) {
        List<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
        String parametro = prodEnt.getNome();
        String selectQuery = "SELECT ID, NOME, TIPO, QTD, VALOR FROM PRODUTOS WHERE NOME LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                ProdutoBean pr = new ProdutoBean();
                pr.setId(""+cursor.getInt(0));
                pr.setNome(cursor.getString(1));
                pr.setTipo(cursor.getString(2));
                pr.setQtd(cursor.getString(3));
                pr.setValor(cursor.getString(4));
                produtos.add(pr);
            } while (cursor.moveToNext());
        }
        return produtos;
    }

    public ProdutoBean validarProdutos(ProdutoBean prodEnt) {
        ProdutoBean pr = new ProdutoBean();
        String nomePar = '"' + prodEnt.getNome().trim() + '"';
        String selectQuery = "SELECT ID, NOME, TIPO, QTD, VALOR FROM PRODUTOS WHERE NOME = ? " ;
        String[] whereArgs = new String [] {nomePar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        pr.setId("0 = " + nomePar);
        if (cursor.moveToFirst()) {
            do {
                pr.setId(""+cursor.getInt(0));
                pr.setNome(cursor.getString(1));
                pr.setTipo(cursor.getString(2));
                pr.setQtd(cursor.getString(3));
                pr.setValor(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return pr;
    }

    public List<ProdutoBean> listarProdutosTeste() {
        List<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
        for (int i = 0; i < 10; i++ ) {
            ProdutoBean pr = new ProdutoBean();
            pr.setId(" Id " + i);
            pr.setNome(" Nome " + i);
            pr.setTipo(" Tipo " + i);
            pr.setQtd(" Quantidade " + i);
            pr.setValor(" Valor " + i);
            produtos.add(pr);
        }
        return produtos;
    }
}