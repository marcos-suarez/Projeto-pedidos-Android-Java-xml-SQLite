package com.example.profalexandre.fatecmobile.telas.produtos;

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
import com.example.profalexandre.fatecmobile.dbs.ControllerProduto;
import com.example.profalexandre.fatecmobile.modelos.ProdutoBean;

import java.util.List;

public class ListProdPesqActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeProdutos;
    List<ProdutoBean> produtos;
    Button pesqProd;
    ArrayAdapter<ProdutoBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_prod_pesq);
        final Context con = getBaseContext();
        final ControllerProduto pr = new ControllerProduto(con);
        ListaDeProdutos = (ListView) findViewById(R.id.listaprodu);
        ListaDeProdutos.setOnItemClickListener(this); // Clique no item
        ListaDeProdutos.setOnItemLongClickListener(this); //
        final EditText nome = (EditText)findViewById(R.id.nomeprodu);

        pesqProd = (Button) findViewById(R.id.btpesquisarproduto);
        pesqProd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String loginString = nome.getText().toString();
                ProdutoBean prod = new ProdutoBean();
                prod.setNome(loginString);
                produtos = pr.listarProdutos(prod);
                adapter = new ArrayAdapter<ProdutoBean>(con,android.R.layout.simple_list_item_1,produtos);
                ListaDeProdutos.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ProdutoBean pro = (ProdutoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListProdPesqActivity.this, UptProActivity.class);
        it.putExtra("Produto",pro);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + pro.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ProdutoBean pr = (ProdutoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListProdPesqActivity.this, UptProActivity.class);
        it.putExtra("Produto",pr);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + pr.getId(),Toast.LENGTH_LONG).show();
    }
}