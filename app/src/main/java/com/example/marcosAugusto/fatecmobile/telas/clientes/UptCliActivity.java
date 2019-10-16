package com.example.marcosAugusto.fatecmobile.telas.clientes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerCliente;
import com.example.marcosAugusto.fatecmobile.modelos.ClienteBean;

public class UptCliActivity extends AppCompatActivity {

    Button uptCli, delCli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_cli);
        final ControllerCliente cli = new ControllerCliente(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nomecli);
        final EditText cpf = (EditText)findViewById((R.id.cpf));
        final EditText datanasc = (EditText)findViewById(R.id.datanasc);
        final EditText cidade = (EditText)findViewById(R.id.cidade);
        Intent it = getIntent();
        final ClienteBean recuperado = (ClienteBean) it.getSerializableExtra("Cliente");
        nome.setText(recuperado.getNome());
        cpf.setText(recuperado.getCpf());
        datanasc.setText(recuperado.getDatanasc());
        cidade.setText(recuperado.getCidade());

        uptCli = (Button) findViewById(R.id.btalterar);
        uptCli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String cpfString = cpf.getText().toString();
                String datanascString = datanasc.getText().toString();
                String cidadeString = cidade.getText().toString();
                recuperado.setNome(nomeString);
                recuperado.setCpf(cpfString);
                recuperado.setDatanasc(datanascString);
                recuperado.setCidade(cidadeString);
                String msg = cli.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delCli = (Button) findViewById(R.id.btexcluir);
        delCli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = cli.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}