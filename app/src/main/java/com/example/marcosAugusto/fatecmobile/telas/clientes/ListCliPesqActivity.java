package com.example.marcosAugusto.fatecmobile.telas.clientes;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerCliente;
import com.example.marcosAugusto.fatecmobile.modelos.ClienteBean;

import java.util.List;

public class ListCliPesqActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeClientes;
    List<ClienteBean> clientes;
    Button pesqCli;
    ArrayAdapter<ClienteBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cli_pesq);
        final Context con = getBaseContext();
        final ControllerCliente cli = new ControllerCliente(con);
        ListaDeClientes = (ListView) findViewById(R.id.listacli);
        ListaDeClientes.setOnItemClickListener(this); // Clique no item
        ListaDeClientes.setOnItemLongClickListener(this); //
        final EditText nome = (EditText)findViewById(R.id.nomecli);

        pesqCli = (Button) findViewById(R.id.btpesquisarcliente);
        pesqCli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                ClienteBean cl = new ClienteBean();
                cl.setNome(nomeString);
                clientes = cli.listarClientes(cl);
                adapter = new ArrayAdapter<ClienteBean>(con,android.R.layout.simple_list_item_1,clientes);
                ListaDeClientes.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ClienteBean cli = (ClienteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListCliPesqActivity.this, UptCliActivity.class);
        it.putExtra("Cliente",cli);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + cli.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ClienteBean cli = (ClienteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListCliPesqActivity.this, UptCliActivity.class);
        it.putExtra("Cliente", cli);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + cli.getId(),Toast.LENGTH_LONG).show();
    }
}