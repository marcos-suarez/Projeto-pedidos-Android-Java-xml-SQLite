package com.example.marcosAugusto.fatecmobile.telas.pedidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.modelos.UsuarioBean;

public class MenuPedActivity extends AppCompatActivity {
    Button addPed, listPed, listPedPesq;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ped);

        /*Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado_cli);
        textUsuLogado.setText(usuLogado.getLogin());*/

        listPed =(Button) findViewById(R.id.btlistped);

        listPed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuPedActivity.this, ListPedActivity.class);
                startActivity(it);
            }
        });

        listPedPesq = (Button) findViewById(R.id.btpesquisarped);
        listPedPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuPedActivity.this, ListPedPesqActivity.class);
                startActivity(it);
            }
        });

        addPed = (Button) findViewById(R.id.btnovo_ped);
        addPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuPedActivity.this, AddPedActivity.class);
                startActivity(it);
            }
        });
    }
}