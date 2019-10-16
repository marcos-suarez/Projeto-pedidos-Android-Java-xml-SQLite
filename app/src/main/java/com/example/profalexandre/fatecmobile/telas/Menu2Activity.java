package com.example.profalexandre.fatecmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.modelos.UsuarioBean;
import com.example.profalexandre.fatecmobile.telas.clientes.AddCliActivity;
import com.example.profalexandre.fatecmobile.telas.clientes.ListCliActivity;
import com.example.profalexandre.fatecmobile.telas.clientes.ListCliPesqActivity;
import com.example.profalexandre.fatecmobile.telas.estoques.AddEstActivity;
import com.example.profalexandre.fatecmobile.telas.estoques.ListEstActivity;
import com.example.profalexandre.fatecmobile.telas.estoques.ListEstPesqActivity;
import com.example.profalexandre.fatecmobile.telas.produtos.AddProdActivity;
import com.example.profalexandre.fatecmobile.telas.produtos.ListProdActivity;
import com.example.profalexandre.fatecmobile.telas.produtos.ListProdPesqActivity;
import com.example.profalexandre.fatecmobile.telas.usuarios.AddUsuActivity;
import com.example.profalexandre.fatecmobile.telas.usuarios.ListUsuActivity;
import com.example.profalexandre.fatecmobile.telas.usuarios.ListUsuParamActivity;

public class Menu2Activity extends AppCompatActivity {

    Button addUsu,addProd, addCli, addEst, listUsu, listUsuPar, listProd, listProdPesq, listCli, listCliPesq, listEst, listEstPesq;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        listUsu = (Button) findViewById(R.id.btlistusu);
        listProd = (Button) findViewById(R.id.btlistprod);
        listCli =(Button) findViewById(R.id.btlistcli);
        listEst =(Button) findViewById(R.id.btlistest);
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado_cli);
        textUsuLogado.setText(usuLogado.getLogin());

        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });

        listUsuPar = (Button) findViewById(R.id.btlistusuParam);
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });

        listProd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListProdActivity.class);
                startActivity(it);
            }
        });

        listProdPesq = (Button) findViewById(R.id.btpesquisarprod);
        listProdPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListProdPesqActivity.class);
                startActivity(it);
            }
        });

        listCli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListCliActivity.class);
                startActivity(it);
            }
        });

        listCliPesq = (Button) findViewById(R.id.btpesquisarcliente);
        listCliPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListCliPesqActivity.class);
                startActivity(it);
            }
        });

        listEst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListEstActivity.class);
                startActivity(it);
            }
        });

        listEstPesq = (Button) findViewById(R.id.btpesquisarest);
        listEstPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, ListEstPesqActivity.class);
                startActivity(it);
            }
        });


        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });

        addProd = (Button) findViewById(R.id.btnovo_prod);
        addProd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, AddProdActivity.class);
                startActivity(it);
            }
        });

        addCli = (Button) findViewById(R.id.btnovo_cli);
        addCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, AddCliActivity.class);
                startActivity(it);
            }
        });

        addEst = (Button) findViewById(R.id.btnovo_est);
        addEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu2Activity.this, AddEstActivity.class);
                startActivity(it);
            }
        });
    }

}
