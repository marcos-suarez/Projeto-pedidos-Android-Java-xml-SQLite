package com.example.marcosAugusto.fatecmobile.telas.pedidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcosAugusto.fatecmobile.R;
import com.example.marcosAugusto.fatecmobile.dbs.ControllerPedido;
import com.example.marcosAugusto.fatecmobile.modelos.PedidoBean;

public class UptPedActivity extends AppCompatActivity {

    Button uptPed, delPed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_ped);
        final ControllerPedido ped = new ControllerPedido(getBaseContext());
        final EditText idcli = (EditText)findViewById(R.id.idcli);
        final EditText idprod = (EditText)findViewById((R.id.idprod));
        final EditText idest = (EditText)findViewById(R.id.idest);
        final EditText valor = (EditText)findViewById(R.id.idvalorped);

        Intent it = getIntent();
        final PedidoBean recuperado = (PedidoBean) it.getSerializableExtra("Pedido");
        idcli.setText(recuperado.getIdCli());
        idprod.setText(recuperado.getIdProd());
        idest.setText(recuperado.getIdEst());
        valor.setText(recuperado.getValor());


        uptPed = (Button) findViewById(R.id.btalterarped);
        uptPed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String idcliString = idcli.getText().toString();
                String idprodString = idprod.getText().toString();
                String idestString = idest.getText().toString();
                String valorString = valor.getText().toString();

                recuperado.setIdCli(idcliString);
                recuperado.setIdProd(idprodString);
                recuperado.setIdEst(idestString);
                recuperado.setValor(valorString);

                String msg = ped.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delPed = (Button) findViewById(R.id.btexcluirped);
        delPed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ped.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}