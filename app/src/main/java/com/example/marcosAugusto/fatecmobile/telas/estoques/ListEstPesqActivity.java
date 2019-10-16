package com.example.marcosAugusto.fatecmobile.telas.estoques;

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
import com.example.marcosAugusto.fatecmobile.dbs.ControllerEstoque;
import com.example.marcosAugusto.fatecmobile.modelos.EstoqueBean;

import java.util.List;

public class ListEstPesqActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeEstoques;
    List<EstoqueBean> estoques;
    Button pesqEst;
    ArrayAdapter<EstoqueBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_est_pesq);
        final Context con = getBaseContext();
        final ControllerEstoque est = new ControllerEstoque(con);
        ListaDeEstoques = (ListView) findViewById(R.id.listaest);
        ListaDeEstoques.setOnItemClickListener(this); // Clique no item
        ListaDeEstoques.setOnItemLongClickListener(this); //
        final EditText nome = (EditText)findViewById(R.id.nomeestoque);

        pesqEst = (Button) findViewById(R.id.btpesquisarestoque);
        pesqEst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String loginString = nome.getText().toString();
                EstoqueBean e = new EstoqueBean();
                e.setNome(loginString);
                estoques = est.listarEstoques(e);
                adapter = new ArrayAdapter<EstoqueBean>(con,android.R.layout.simple_list_item_1,estoques);
                ListaDeEstoques.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        EstoqueBean est = (EstoqueBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListEstPesqActivity.this, UptEstActivity.class);
        it.putExtra("Estoque",est);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + est.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        EstoqueBean est = (EstoqueBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListEstPesqActivity.this, UptEstActivity.class);
        it.putExtra("Estoque",est);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + est.getId(),Toast.LENGTH_LONG).show();
    }
}