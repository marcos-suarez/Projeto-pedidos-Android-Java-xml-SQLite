package com.example.profalexandre.fatecmobile.telas.pedidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerPedido;
import com.example.profalexandre.fatecmobile.modelos.PedidoBean;

import java.util.List;

public class ListPedActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDePedidos;
    List<PedidoBean> pedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ped);
        final ControllerPedido ped = new ControllerPedido(getBaseContext());
        ListaDePedidos = (ListView) findViewById(R.id.listaped);
        pedidos = ped.listarPedidos();
        ArrayAdapter<PedidoBean> adapter = new ArrayAdapter<PedidoBean>(this,android.R.layout.simple_list_item_1,pedidos);
        ListaDePedidos.setAdapter(adapter);
        ListaDePedidos.setOnItemClickListener(this); // Clique no item
        ListaDePedidos.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        PedidoBean p = (PedidoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListPedActivity.this, UptPedActivity.class);
        it.putExtra("Pedido",p);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + p.getIdPed(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        PedidoBean ped = (PedidoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListPedActivity.this, UptPedActivity.class);
        it.putExtra("Pedido",ped);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + ped.getIdPed(),Toast.LENGTH_LONG).show();
    }
}
