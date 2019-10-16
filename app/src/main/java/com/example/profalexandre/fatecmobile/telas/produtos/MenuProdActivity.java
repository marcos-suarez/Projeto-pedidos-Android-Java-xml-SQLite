package com.example.profalexandre.fatecmobile.telas.produtos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.modelos.UsuarioBean;
import com.example.profalexandre.fatecmobile.telas.LoginActivity;

public class MenuProdActivity extends AppCompatActivity {
    Button addProd, listProd, listProdPesq;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_prod);

        /*Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado_cli);
        textUsuLogado.setText(usuLogado.getLogin());*/

        listProd =(Button) findViewById(R.id.btlistprod);

        listProd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuProdActivity.this, ListProdActivity.class);
                startActivity(it);
            }
        });

        listProdPesq = (Button) findViewById(R.id.btpesquisarprod);
        listProdPesq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuProdActivity.this, ListProdPesqActivity.class);
                startActivity(it);
            }
        });

        addProd = (Button) findViewById(R.id.btnovo_prod);
        addProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MenuProdActivity.this, AddProdActivity.class);
                startActivity(it);
            }
        });
    }
}