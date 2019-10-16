package com.example.marcosAugusto.fatecmobile.telas.estoques;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.dbs.BancoHelper;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerEstoque;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerProduto;
import com.example.marcosAugusto.fatecmobile.modelos.EstoqueBean;

import java.util.ArrayList;
import java.util.List;

public class AddEstActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    BancoHelper helper;
    Spinner spSpinnerSql;
    List<String> listaProdutosSql;
    ArrayAdapter<String> comboAdapterSql;
    String idProd, nomeProd;

    ControllerProduto getProd = null; // PRODUTO = ESTOQUE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_est);

        getProd = new ControllerProduto(getBaseContext());

        //Hago referencia al spinner con el id `sp_paises_sql`
        spSpinnerSql = (Spinner) findViewById(R.id.idProduto);
        //Implemento el setOnItemSelectedListener: para realizar acciones cuando se seleccionen los Ã­tems
        spSpinnerSql.setOnItemSelectedListener(this);
        //Convierto la variable List<> en un ArrayList<>()
        listaProdutosSql = new ArrayList<>();
        //Almaceno el tamaÃ±o de la lista getAllPaises()

        int sizelistaProdutos = getProd.listarProdutos().size();
        //Agrego los nombres de los paÃ­ses obtenidos y lo almaceno en  `listaMercadoriasSql`
        for (int i = 0; i < sizelistaProdutos; i++) {
            listaProdutosSql.add(getProd.listarProdutos().get(i).getNome());
        }
        //Implemento el adapter con el contexto, layout, listaMercadoriasSql
        comboAdapterSql = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaProdutosSql);
        //Cargo el spinner con los datos
        spSpinnerSql.setAdapter(comboAdapterSql);

        final ControllerEstoque est = new ControllerEstoque(getBaseContext());
        Button Inserirest = (Button) findViewById(R.id.btinserirest);

        Inserirest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Spinner idProdu = (Spinner) findViewById((R.id.idProduto));

                EditText nome = (EditText) findViewById(R.id.nome);
                EditText cidade = (EditText) findViewById((R.id.cidade));
                EditText contas = (EditText) findViewById(R.id.contas);
                EditText qtd = (EditText) findViewById(R.id.qtd);

                String idProduString = idProd;
                String nomeString = nome.getText().toString();
                String cidadeString = cidade.getText().toString();
                String contasString = contas.getText().toString();
                String qtdString = qtd.getText().toString();

                EstoqueBean e = new EstoqueBean();
                e.setId("");
                e.setNome(nomeString);
                e.setCidade(cidadeString);
                e.setContas(contasString);
                e.setIdProd(idProduString);
                e.setQtdProd(qtdString);

                String msg = est.inserir(e);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                Intent it = new Intent(AddEstActivity.this, ListEstActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){

            case R.id.idProduto:

                idProd = getProd.listarProdutos().get(position).getId();
                //Almaceno el nombre del paÃ­s seleccionado
                nomeProd = getProd.listarProdutos().get(position).getNome();

                //Toast.makeText(this, "TROCAR fruta: " + nombreFruta, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Id: " + idProd + " - TROCAR: " + nomeProd, Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
};
