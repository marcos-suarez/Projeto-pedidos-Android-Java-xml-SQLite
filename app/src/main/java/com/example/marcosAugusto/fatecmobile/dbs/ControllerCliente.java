package com.example.marcosAugusto.fatecmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.marcosAugusto.fatecmobile.modelos.ClienteBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerCliente {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerCliente(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(ClienteBean cli) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", cli.getNome());
        valores.put("CPF", cli.getCpf());
        valores.put("DATANASC", cli.getDatanasc());
        valores.put("CIDADE", cli.getCidade());
        resultado = db.insert(BancoHelper.TABELA3, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(ClienteBean cli) {
        String retorno = "Resgistro Excluido com Sucesso";
        String where = "ID = " + cli.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA3,where,null);
        db.close();
        return retorno;
    }

    public String alterar(ClienteBean cli) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + cli.getId();
        valores = new ContentValues();
        valores.put("NOME", cli.getNome());
        valores.put("CPF", cli.getCpf());
        valores.put("DATANASC", cli.getDatanasc());
        valores.put("CIDADE", cli.getCidade());
        db.update(BancoHelper.TABELA3, valores,where,null);
        db.close();
        return retorno;
    }

    public List<ClienteBean> listarClientes() {
        List<ClienteBean> clientes = new ArrayList<ClienteBean>();
        String selectQuery = "SELECT * FROM CLIENTES" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ClienteBean cli = new ClienteBean();
                cli.setId(""+cursor.getInt(0));
                cli.setNome(cursor.getString(1));
                cli.setCpf(cursor.getString(2));
                cli.setDatanasc(cursor.getString(3));
                cli.setCidade(cursor.getString(4));
                clientes.add(cli);
            } while (cursor.moveToNext());
        }
        return clientes;
    }

    public List<ClienteBean> listarClientes(ClienteBean cliEnt) {
        List<ClienteBean> clientes = new ArrayList<ClienteBean>();
        String parametro = cliEnt.getNome();
        String selectQuery = "SELECT ID, NOME, CPF, DATANASC, CIDADE FROM CLIENTES WHERE NOME LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                ClienteBean cli = new ClienteBean();
                cli.setId(""+cursor.getInt(0));
                cli.setNome(cursor.getString(1));
                cli.setCpf(cursor.getString(2));
                cli.setDatanasc(cursor.getString(3));
                cli.setCidade(cursor.getString(4));
                clientes.add(cli);
            } while (cursor.moveToNext());
        }
        return clientes;
    }

    public ClienteBean validarClientes(ClienteBean cliEnt) {
        ClienteBean cli = new ClienteBean();
        String NomePar = '"' + cliEnt.getNome().trim() + '"';
        String selectQuery = "SELECT ID, NOME, CPF, DATANASC, CIDADE FROM CLIENTES WHERE NOME = ? " ;
        String[] whereArgs = new String [] {NomePar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        cli.setNome("0 = " + NomePar);
        if (cursor.moveToFirst()) {
            do {
                cli.setId(""+cursor.getInt(0));
                cli.setNome(cursor.getString(1));
                cli.setCpf(cursor.getString(2));
                cli.setDatanasc(cursor.getString(3));
                cli.setCidade(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return cli;
    }

    public List<ClienteBean> listarClientesTeste() {
        List<ClienteBean> clientes = new ArrayList<ClienteBean>();
        for (int i = 0; i < 10; i++ ) {
            ClienteBean cli = new ClienteBean();
            cli.setId(" Id " + i);
            cli.setNome(" Nome " + i);
            cli.setCpf(" Cpf " + i);
            cli.setDatanasc(" DataNasc " + i);
            cli.setCidade(" Cidade " + i);
            clientes.add(cli);
        }
        return clientes;
    }
}
