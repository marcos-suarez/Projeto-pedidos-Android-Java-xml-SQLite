package com.example.profalexandre.fatecmobile.telas.pedidos;

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

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerPedido;
import com.example.profalexandre.fatecmobile.modelos.PedidoBean;

import java.util.List;

public class ListPedPesqActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDePedidos;
    List<PedidoBean> pedidos;
    Button pesqPed;
    ArrayAdapter<PedidoBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ped_pesq);
        final Context con = getBaseContext();
        final ControllerPedido ped = new ControllerPedido(con);
        ListaDePedidos = (ListView) findViewById(R.id.listaped);
        ListaDePedidos.setOnItemClickListener(this); // Clique no item
        ListaDePedidos.setOnItemLongClickListener(this); //
        final EditText idped = (EditText)findViewById(R.id.idpedido);

        pesqPed = (Button) findViewById(R.id.btpesquisarpedido);
        pesqPed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String loginString = idped.getText().toString();
                PedidoBean pe = new PedidoBean();
                pe.setIdPed(loginString);
                pedidos = ped.listarPedidos(pe);
                adapter = new ArrayAdapter<PedidoBean>(con,android.R.layout.simple_list_item_1,pedidos);
                ListaDePedidos.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        PedidoBean ped = (PedidoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListPedPesqActivity.this, UptPedActivity.class);
        it.putExtra("Pedido",ped);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + ped.getIdPed(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        PedidoBean ped = (PedidoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListPedPesqActivity.this, UptPedActivity.class);
        it.putExtra("Pedido",ped);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + ped.getIdPed(),Toast.LENGTH_LONG).show();
    }
}