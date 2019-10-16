package com.example.marcosAugusto.fatecmobile.telas.estoques;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerEstoque;
import com.example.marcosAugusto.fatecmobile.modelos.EstoqueBean;

import java.util.List;

public class ListEstActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeEstoques;
    List<EstoqueBean> estoques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_est);
        final ControllerEstoque est = new ControllerEstoque(getBaseContext());
        ListaDeEstoques = (ListView) findViewById(R.id.listaest);
        estoques = est.listarEstoques();
        ArrayAdapter<EstoqueBean> adapter = new ArrayAdapter<EstoqueBean>(this,android.R.layout.simple_list_item_1,estoques);
        ListaDeEstoques.setAdapter(adapter);
        ListaDeEstoques.setOnItemClickListener(this); // Clique no item
        ListaDeEstoques.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        EstoqueBean e = (EstoqueBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListEstActivity.this, UptEstActivity.class);
        it.putExtra("Estoque",e);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + e.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        EstoqueBean est = (EstoqueBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListEstActivity.this, UptEstActivity.class);
        it.putExtra("Estoque",est);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + est.getId(),Toast.LENGTH_LONG).show();
    }
}
