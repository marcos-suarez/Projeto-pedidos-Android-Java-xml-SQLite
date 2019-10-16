package com.example.profalexandre.fatecmobile.telas.produtos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerProduto;
import com.example.profalexandre.fatecmobile.modelos.ProdutoBean;

public class AddProdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prod);
        final ControllerProduto pr = new ControllerProduto(getBaseContext());
        Button Inserirp = (Button) findViewById(R.id.btinserirp);

        Inserirp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome  = (EditText) findViewById(R.id.nome);
                EditText tipo  = (EditText) findViewById((R.id.tipo));
                EditText quantidade = (EditText) findViewById(R.id.qtd);
                EditText valor   = (EditText) findViewById(R.id.valor);

                String nomeString = nome.getText().toString();
                String tipoString = tipo.getText().toString();
                String quantidadeString = quantidade.getText().toString();
                String valorString = valor.getText().toString();

                ProdutoBean p = new ProdutoBean();
                p.setId("");
                p.setNome(nomeString);
                p.setTipo(tipoString);
                p.setQtd(quantidadeString);
                p.setValor(valorString);
                String msg = pr.inserir(p);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}