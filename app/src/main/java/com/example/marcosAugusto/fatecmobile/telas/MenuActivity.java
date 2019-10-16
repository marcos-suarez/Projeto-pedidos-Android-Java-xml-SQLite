package com.example.marcosAugusto.fatecmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.modelos.UsuarioBean;
import com.example.marcosAugusto.fatecmobile.telas.clientes.MenuCliActivity;
import com.example.marcosAugusto.fatecmobile.telas.estoques.MenuEstActivity;
import com.example.marcosAugusto.fatecmobile.telas.pedidos.MenuPedActivity;
import com.example.marcosAugusto.fatecmobile.telas.produtos.MenuProdActivity;
import com.example.marcosAugusto.fatecmobile.telas.usuarios.MenuUsuActivity;

public class MenuActivity extends AppCompatActivity {

    Button Usu, Prod, Cli, Est, Ped;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado_cli);
        textUsuLogado.setText(usuLogado.getLogin());

        Usu = (Button) findViewById(R.id.btusuarios);
        Usu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, MenuUsuActivity.class);
                startActivity(it);
            }
        });

        Prod = (Button) findViewById(R.id.btprodutos);
        Prod.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, MenuProdActivity.class);
                startActivity(it);
            }
        });

        Cli = (Button) findViewById(R.id.btclientes);
        Cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, MenuCliActivity.class);
                startActivity(it);
            }
        });

        Est = (Button) findViewById(R.id.btestoques);
        Est.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, MenuEstActivity.class);
                startActivity(it);
            }
        });

        Ped = (Button) findViewById(R.id.btpedidos);
        Ped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, MenuPedActivity.class);
                startActivity(it);
            }
        });
    }
}
