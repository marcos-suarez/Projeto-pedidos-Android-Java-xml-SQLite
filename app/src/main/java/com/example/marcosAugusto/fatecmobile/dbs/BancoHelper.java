package com.example.marcosAugusto.fatecmobile.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author Marcos Augusto
 */
public class BancoHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "RESGATFATEC.db";
    public static final String TABELA1 = "USUARIOS";
    public static final String TABELA2 = "PRODUTOS";
    public static final String TABELA3 = "CLIENTES";
    public static final String TABELA4 = "ESTOQUES";
    public static final String TABELA5 = "PEDIDOS";

    private static final int VERSAO_SCHEMA = 1;
    private final String S_CREATE1, S_CREATE2, S_CREATE3, S_CREATE4,S_CREATE5;


    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATE1 = "CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,LOGIN TEXT,SENHA TEXT,STATUS TEXT,TIPO TEXT);";
        this.S_CREATE2 = "CREATE TABLE PRODUTOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,TIPO TEXT,QTD INT,VALOR FLOAT);";
        this.S_CREATE3 = "CREATE TABLE CLIENTES (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,CPF TEXT,DATANASC TEXT,CIDADE TEXT);";
        this.S_CREATE4 = "CREATE TABLE ESTOQUES (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,CIDADE TEXT,CONTAS FLOAT, ID_PRODUTO TEXT, QTD_PRODUTO TEXT);";
        this.S_CREATE5 = "CREATE TABLE PEDIDOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,ID_CLI TEXT,ID_PROD TEXT, ID_EST TEXT, VALOR FLOAT);";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE1);
        db.execSQL(S_CREATE2);
        db.execSQL(S_CREATE3);
        db.execSQL(S_CREATE4);
        db.execSQL(S_CREATE5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE USUARIOS");
        db.execSQL("DROP TABLE PRODUTOS");
        db.execSQL("DROP TABLE CLIENTES");
        db.execSQL("DROP TABLE ESTOQUES");
        db.execSQL("DROP TABLE PEDIDOS");
        onCreate(db);
    }

}
