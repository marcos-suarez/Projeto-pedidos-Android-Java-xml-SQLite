package com.example.profalexandre.fatecmobile.telas.clientes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerCliente;
import com.example.profalexandre.fatecmobile.modelos.ClienteBean;

import java.util.List;

public class ListCliActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeClientes;
    List<ClienteBean> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cli);
        final ControllerCliente cli = new ControllerCliente(getBaseContext());
        ListaDeClientes = (ListView) findViewById(R.id.listacli);
        clientes = cli.listarClientes();
        ArrayAdapter<ClienteBean> adapter = new ArrayAdapter<ClienteBean>(this,android.R.layout.simple_list_item_1,clientes);
        ListaDeClientes.setAdapter(adapter);
        ListaDeClientes.setOnItemClickListener(this); // Clique no item
        ListaDeClientes.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ClienteBean cli = (ClienteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListCliActivity.this, UptCliActivity.class);
        it.putExtra("Cliente",cli);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + cli.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ClienteBean cli = (ClienteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListCliActivity.this, UptCliActivity.class);
        it.putExtra("Cliente",cli);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + cli.getId(),Toast.LENGTH_LONG).show();
    }
}
