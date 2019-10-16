package com.example.marcosAugusto.fatecmobile.telas.clientes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerCliente;
import com.example.marcosAugusto.fatecmobile.modelos.ClienteBean;

public class AddCliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cli);
        final ControllerCliente cli = new ControllerCliente(getBaseContext());
        Button Inserircli = (Button) findViewById(R.id.btinserircli);

        Inserircli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome  = (EditText) findViewById(R.id.nomecli);
                EditText cpf  = (EditText) findViewById(R.id.cpf);
                EditText datanasc = (EditText) findViewById(R.id.datanasc);
                EditText cidade   = (EditText) findViewById(R.id.cidade);

                String nomeString = nome.getText().toString();
                String cpfString = cpf.getText().toString();
                String datanascString = datanasc.getText().toString();
                String cidadeString = cidade.getText().toString();

                ClienteBean c = new ClienteBean();
                c.setId("");
                c.setNome(nomeString);
                c.setCpf(cpfString);
                c.setDatanasc(datanascString);
                c.setCidade(cidadeString);
                String msg = cli.inserir(c);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}