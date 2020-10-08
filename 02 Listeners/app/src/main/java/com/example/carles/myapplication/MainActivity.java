package com.example.carles.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtNumero, edtText;
    Button btnIncrementa, btnMayus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CONNECTAR AMB ELS Views del Layout per poder fer coses....

        edtNumero = (EditText) findViewById(R.id.edtNumero);
        edtText = (EditText) findViewById(R.id.edtTexto);
        btnIncrementa = (Button) findViewById(R.id.btnIncrementa);
        btnMayus = (Button) findViewById(R.id.btnMayus);

        /*
        btnIncrementa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementa();
            }
        });
        btnMayus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mayus();
            }
        });
        */

        //Per posar els Views al SAC del Senyor Listener cal afegir-los!!!

        // btnEsborrar.setOnClickListener(this);
        btnMayus.setOnClickListener(this);
        btnIncrementa.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnIncrementa:  incrementa();  break;
            case R.id.btnMayus:  mayus();   break;
        }

    }

    public void incrementa(){
        int proxValor;

        try {
            proxValor = Integer.parseInt(edtNumero.getText().toString()) + 1;
            edtNumero.setText(String.valueOf(proxValor));
        }
        catch (Exception e) {
            Toast.makeText(this, "T'he demanat un número!!!!!", Toast.LENGTH_LONG).show();
        }

    }

    public void mayus(){
        edtText.setText(edtText.getText().toString().toUpperCase());
    }




}
