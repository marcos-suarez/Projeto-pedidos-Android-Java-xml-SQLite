package com.example.profalexandre.fatecmobile.telas.pedidos;

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

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.BancoHelper;
import com.example.profalexandre.fatecmobile.dbs.ControllerCliente;
import com.example.profalexandre.fatecmobile.dbs.ControllerEstoque;
import com.example.profalexandre.fatecmobile.dbs.ControllerPedido;
import com.example.profalexandre.fatecmobile.dbs.ControllerProduto;
import com.example.profalexandre.fatecmobile.modelos.EstoqueBean;
import com.example.profalexandre.fatecmobile.modelos.PedidoBean;

import java.util.ArrayList;
import java.util.List;

public class AddPedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    BancoHelper helper;
    Spinner spSpinnerSql;

    List<String> listaClientesSql;
    List<String> listaProdutosSql;
    List<String> listaEstoquesSql;

    ArrayAdapter<String> comboAdapterSql;

    String idCli, nomeCli;
    String idProd, nomeProd;
    String idEst, nomeEst;

    ControllerCliente getCli = null; // CLIENTE = PEDIDO
    ControllerProduto getProd = null; // PRODUTO = PEDIDO
    ControllerEstoque getEst = null; // ESTOQUE = PEDIDO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ped);

        getCli = new ControllerCliente(getBaseContext());
        getProd = new ControllerProduto(getBaseContext());
        getEst = new ControllerEstoque(getBaseContext());

        //SPINNER CLIENTE //
        //Hago referencia al spinner con el id `sp_paises_sql`
        spSpinnerSql = (Spinner) findViewById(R.id.idCliente);
        //Implemento el setOnItemSelectedListener: para realizar acciones cuando se seleccionen los Ã­tems
        spSpinnerSql.setOnItemSelectedListener(this);
        //Convierto la variable List<> en un ArrayList<>()
        listaClientesSql = new ArrayList<>();
        //Almaceno el tamaÃ±o de la lista getAllPaises()

        int sizelistaClientes = getCli.listarClientes().size();
        //Agrego los nombres de los paÃ­ses obtenidos y lo almaceno en  `listaMercadoriasSql`
        for (int i = 0; i < sizelistaClientes; i++) {
            listaClientesSql.add(getCli.listarClientes().get(i).getNome());
        }
        //Implemento el adapter con el contexto, layout, listaMercadoriasSql
        comboAdapterSql = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaClientesSql);
        //Cargo el spinner con los datos
        spSpinnerSql.setAdapter(comboAdapterSql);

        //SPINNER PRODUTO//
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

        //SPINNER ESTOQUE//
        //Hago referencia al spinner con el id `sp_paises_sql`
        spSpinnerSql = (Spinner) findViewById(R.id.idEstoque);
        //Implemento el setOnItemSelectedListener: para realizar acciones cuando se seleccionen los Ã­tems
        spSpinnerSql.setOnItemSelectedListener(this);
        //Convierto la variable List<> en un ArrayList<>()
        listaEstoquesSql = new ArrayList<>();
        //Almaceno el tamaÃ±o de la lista getAllPaises()

        int sizelistaEstoques = getEst.listarEstoques().size();
        //Agrego los nombres de los paÃ­ses obtenidos y lo almaceno en  `listaMercadoriasSql`
        for (int i = 0; i < sizelistaEstoques; i++) {
            listaEstoquesSql.add(getEst.listarEstoques().get(i).getNome());
        }
        //Implemento el adapter con el contexto, layout, listaMercadoriasSql
        comboAdapterSql = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaEstoquesSql);
        //Cargo el spinner con los datos
        spSpinnerSql.setAdapter(comboAdapterSql);

        final ControllerPedido pedi = new ControllerPedido(getBaseContext());
        Button Inserirest = (Button) findViewById(R.id.btinserirped);

        Inserirest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Spinner idClient = (Spinner) findViewById((R.id.idCliente));
                Spinner idProdu = (Spinner) findViewById(R.id.idProduto);
                Spinner idEsto = (Spinner) findViewById(R.id.idEstoque);
                EditText valor = (EditText) findViewById(R.id.valorped);

                String idCliString = idCli;
                String idProduString = idProd;
                String idEstoString = idEst;
                String valorString = valor.getText().toString();

                PedidoBean ped = new PedidoBean();
                ped.setIdPed("");
                ped.setIdCli(idCliString);
                ped.setIdProd(idProduString);
                ped.setIdEst(idEstoString);
                ped.setValor(valorString);

                String msg = pedi.inserir(ped);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                Intent it = new Intent(AddPedActivity.this, ListPedActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){

            case R.id.idCliente:

                idCli = getCli.listarClientes().get(position).getId();
                //Almaceno el nombre del paÃ­s seleccionado
                nomeCli = getCli.listarClientes().get(position).getNome();

                //Toast.makeText(this, "TROCAR fruta: " + nombreFruta, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Id: " + idCli + " - TROCAR: " + nomeCli, Toast.LENGTH_SHORT).show();

                break;

            case R.id.idProduto:

                idProd = getProd.listarProdutos().get(position).getId();
                //Almaceno el nombre del paÃ­s seleccionado
                nomeProd = getProd.listarProdutos().get(position).getNome();

                //Toast.makeText(this, "TROCAR fruta: " + nombreFruta, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Id: " + idProd + " - TROCAR: " + nomeProd, Toast.LENGTH_SHORT).show();

                break;

                case R.id.idEstoque:

                idEst = getEst.listarEstoques().get(position).getId();
                //Almaceno el nombre del paÃ­s seleccionado
                nomeEst = getEst.listarEstoques().get(position).getNome();

                //Toast.makeText(this, "TROCAR fruta: " + nombreFruta, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Id: " + idEst + " - TROCAR: " + nomeEst, Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
};
