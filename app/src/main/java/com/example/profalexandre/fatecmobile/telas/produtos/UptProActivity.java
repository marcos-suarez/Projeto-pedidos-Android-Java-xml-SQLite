package com.example.profalexandre.fatecmobile.telas.produtos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerProduto;
import com.example.profalexandre.fatecmobile.modelos.ProdutoBean;

public class UptProActivity extends AppCompatActivity {

    Button uptProd, delProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_prod);
        final ControllerProduto pr = new ControllerProduto(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nome);
        final EditText tipo = (EditText)findViewById((R.id.tipo));
        final EditText quantidade = (EditText)findViewById(R.id.qtd);
        final EditText valor = (EditText)findViewById(R.id.valor);
        Intent it = getIntent();
        final ProdutoBean recuperado = (ProdutoBean) it.getSerializableExtra("Produto");
        nome.setText(recuperado.getNome());
        tipo.setText(recuperado.getTipo());
        quantidade.setText(recuperado.getQtd());
        valor.setText(recuperado.getValor());

        uptProd = (Button) findViewById(R.id.btalterar);
        uptProd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String tipoString = tipo.getText().toString();
                String quantidadeString = quantidade.getText().toString();
                String valorString = valor.getText().toString();
                recuperado.setNome(nomeString);
                recuperado.setTipo(tipoString);
                recuperado.setQtd(quantidadeString);
                recuperado.setTipo(tipoString);
                String msg = pr.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delProd = (Button) findViewById(R.id.btexcluir);
        delProd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = pr.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}