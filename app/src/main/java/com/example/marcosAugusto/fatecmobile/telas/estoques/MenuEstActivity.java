package com.example.marcosAugusto.fatecmobile.telas.estoques;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.modelos.UsuarioBean;

public class MenuEstActivity extends AppCompatActivity {
    Button addEst, listEst, listEstPesq;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_est);

        /*Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado_cli);
        textUsuLogado.setText(usuLogado.getLogin());*/

        listEst =(Button) findViewById(R.id.btlistest);

        listEst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuEstActivity.this, ListEstActivity.class);
                startActivity(it);
            }
        });

        listEstPesq = (Button) findViewById(R.id.btpesquisarest);
        listEstPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuEstActivity.this, ListEstPesqActivity.class);
                startActivity(it);
            }
        });

        addEst = (Button) findViewById(R.id.btnovo_est);
        addEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuEstActivity.this, AddEstActivity.class);
                startActivity(it);
            }
        });
    }
}