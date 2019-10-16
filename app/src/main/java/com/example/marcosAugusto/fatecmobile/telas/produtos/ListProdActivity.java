package com.example.marcosAugusto.fatecmobile.telas.produtos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerProduto;
import com.example.marcosAugusto.fatecmobile.modelos.ProdutoBean;

import java.util.List;

public class ListProdActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeProdutos;
    List<ProdutoBean> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_prod);
        final ControllerProduto pr = new ControllerProduto(getBaseContext());
        ListaDeProdutos = (ListView) findViewById(R.id.listaprod);
        produtos = pr.listarProdutos();
        ArrayAdapter<ProdutoBean> adapter = new ArrayAdapter<ProdutoBean>(this,android.R.layout.simple_list_item_1,produtos);
        ListaDeProdutos.setAdapter(adapter);
        ListaDeProdutos.setOnItemClickListener(this); // Clique no item
        ListaDeProdutos.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ProdutoBean pro = (ProdutoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListProdActivity.this, UptProActivity.class);
        it.putExtra("Produto",pro);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + pro.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ProdutoBean pro = (ProdutoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListProdActivity.this, UptProActivity.class);
        it.putExtra("Produto",pro);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + pro.getId(),Toast.LENGTH_LONG).show();
    }
}
