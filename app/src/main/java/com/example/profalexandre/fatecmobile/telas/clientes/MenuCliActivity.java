package com.example.profalexandre.fatecmobile.telas.clientes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.modelos.UsuarioBean;

public class MenuCliActivity extends AppCompatActivity {
    Button addCli, listCli, listCliPesq;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cli);

        /*Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado_cli);
        textUsuLogado.setText(usuLogado.getLogin());*/

        listCli =(Button) findViewById(R.id.btlistcli);

        listCli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuCliActivity.this, ListCliActivity.class);
                startActivity(it);
            }
        });

        listCliPesq = (Button) findViewById(R.id.btpesquisarcliente);
        listCliPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuCliActivity.this, ListCliPesqActivity.class);
                startActivity(it);
            }
        });

        addCli = (Button) findViewById(R.id.btnovo_cli);
        addCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuCliActivity.this, AddCliActivity.class);
                startActivity(it);
            }
        });
    }
}
