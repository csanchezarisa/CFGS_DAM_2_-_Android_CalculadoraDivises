package com.example.calculadoradivises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtInput = (TextView) findViewById(R.id.txtInput);
        TextView txtOutput = (TextView) findViewById(R.id.txtOutput);
        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btnComa = (Button) findViewById(R.id.btnComa);
        Button btnCE= (Button) findViewById(R.id.btnCE);
        Button btnBorrar = (Button) findViewById(R.id.btnBorrar);
        Button btnIgual = (Button) findViewById(R.id.btnIgual);
        final Button btnDollar = (Button) findViewById(R.id.btnDollar);
        final Button btnLliura = (Button) findViewById(R.id.btnLliures);
        final Button btnYen = (Button) findViewById(R.id.btnYen);
        final Button btnYuan = (Button) findViewById(R.id.btnYuan);
        final Button[] botonsDivises = {btnLliura, btnDollar, btnYen, btnYuan};

        final boolean dollarSeted = false;
        boolean lliuraSeted = false;
        boolean yenSeted = false;
        boolean yuanSeted = false;

        btnDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarDivisa(botonsDivises, btnDollar);
            }
        });

        btnYen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarDivisa(botonsDivises, btnYen);
            }
        });

        btnYuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarDivisa(botonsDivises, btnYuan);
            }
        });

        btnLliura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarDivisa(botonsDivises, btnLliura);
            }
        });

    }

    private void seleccionarDivisa(Button[] botons, Button botoSeleccionat) {
        int posicioBoto = 0;

        for (int i = 0; i < botons.length; i++) {
            if (botons[i] != botoSeleccionat) {
                botons[i].setBackgroundColor(Color.WHITE);
            }
            else {
                botons[i].setBackgroundColor(Color.GRAY);
            }

            if (!dollarSeted) {

            }

        }

    }

    private void setejarValor() {

    }
}