package com.example.profalexandre.fatecmobile.telas.estoques;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerEstoque;
import com.example.profalexandre.fatecmobile.modelos.EstoqueBean;

public class UptEstActivity extends AppCompatActivity {

    Button uptEst, delEst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_est);
        final ControllerEstoque est = new ControllerEstoque(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nomeestoque);
        final EditText cidade = (EditText)findViewById((R.id.cidadeest));
        final EditText contas = (EditText)findViewById(R.id.contas);
        final EditText idprod = (EditText)findViewById(R.id.idProduto);
        final EditText qtd = (EditText)findViewById(R.id.qtd);

        Intent it = getIntent();
        final EstoqueBean recuperado = (EstoqueBean) it.getSerializableExtra("Estoque");
        nome.setText(recuperado.getNome());
        cidade.setText(recuperado.getCidade());
        contas.setText(recuperado.getContas());
        idprod.setText(recuperado.getIdProd());
        qtd.setText(recuperado.getQtdProd());


        uptEst = (Button) findViewById(R.id.btalterarest);
        uptEst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String cidadeString = cidade.getText().toString();
                String contasString = contas.getText().toString();
                String idProdString = idprod.getText().toString();
                String qtdString = qtd.getText().toString();

                recuperado.setNome(nomeString);
                recuperado.setCidade(cidadeString);
                recuperado.setContas(contasString);
                recuperado.setIdProd(idProdString);
                recuperado.setQtdProd(qtdString);

                String msg = est.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delEst = (Button) findViewById(R.id.btexcluirest);
        delEst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = est.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}