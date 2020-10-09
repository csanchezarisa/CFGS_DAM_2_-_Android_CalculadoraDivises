package com.example.calculadoradivises;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Vinculació dels elements del view a codi
    TextView txtInput;
    TextView txtOutput;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnComa;
    Button btnCE;
    Button btnBorrar;
    Button btnIgual;
    Button btnDollar;
    Button btnLliura;
    Button btnYen;
    Button btnYuan;
    Button[] botonsDivises;

    // Variables que controlen quan a una divisa se li ha assignat un valor
    boolean dollarSeted = false;
    boolean lliuraSeted = false;
    boolean yenSeted = false;
    boolean yuanSeted = false;

    // Valors de conversio de cada divisa i valor de conversió de la divisa actual
    float valorDollar = 0;
    float valorLliura = 0;
    float valorYen = 0;
    float valorYuan = 0;
    float valorDeConversioSeleccionat = 0;

    // Emmagatzemarà de manera temporal el valor de conversió que introdueix l'usuari
    float revisarValorConversio = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Es vinculen els elements del view a les variables del codi
        txtInput = (TextView) findViewById(R.id.txtInput);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnComa = (Button) findViewById(R.id.btnComa);
        btnCE= (Button) findViewById(R.id.btnCE);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnDollar = (Button) findViewById(R.id.btnDollar);
        btnLliura = (Button) findViewById(R.id.btnLliures);
        btnYen = (Button) findViewById(R.id.btnYen);
        btnYuan = (Button) findViewById(R.id.btnYuan);
        botonsDivises = new Button[]{btnLliura, btnDollar, btnYen, btnYuan};

        // BOTÓ DOLLAR - FUNCIONS
        btnDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dollarSeted) {
                    valorDeConversioSeleccionat = valorDollar;
                    canviarColorBotoDivisa(btnDollar);
                }
                else {
                    demanarValorDeConversio("dollar");
                }

            }
        });

        btnDollar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reiniciarDivisa("dollar");
                return true;
            }
        });


        // BOTÓ YEN - FUNCIONS
        btnYen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (yenSeted) {
                    valorDeConversioSeleccionat = valorYen;
                    canviarColorBotoDivisa(btnYen);
                }
                else {
                    demanarValorDeConversio("yen");
                }

            }
        });

        btnYen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reiniciarDivisa("dollar");
                return true;
            }
        });


        // BOTÓ YUAN - FUNCIONS
        btnYuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (yuanSeted) {
                    valorDeConversioSeleccionat = valorYuan;
                    canviarColorBotoDivisa(btnYuan);
                }
                else {
                    demanarValorDeConversio("yuan");
                }

            }
        });

        btnYuan.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reiniciarDivisa("dollar");
                return true;
            }
        });


        // BOTÓ LLIURA - FUNCIONS
        btnLliura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lliuraSeted) {
                    valorDeConversioSeleccionat = valorLliura;
                    canviarColorBotoDivisa(btnDollar);
                }
                else {
                    demanarValorDeConversio("pound");
                }

            }
        });

        btnLliura.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reiniciarDivisa("dollar");
                return true;
            }
        });

    }

    private void canviarColorBotoDivisa(Button botoSeleccionat) {
        int posicioBoto = 0;

        for (int i = 0; i < botonsDivises.length; i++) {
            if (botonsDivises[i] != botoSeleccionat) {
                botonsDivises[i].setBackgroundColor(Color.WHITE);
            }
            else {
                botonsDivises[i].setBackgroundColor(Color.GRAY);
            }
        }

    }

    private void demanarValorDeConversio(String divisa) {
        AlertDialog ad;
        divisa = divisa.toLowerCase();
        final String divisaSeleccionada = divisa;

        switch (divisa) {

            case "pound": divisa = getString(R.string.btnLliures);
                break;

            case "dollar": divisa = getString(R.string.btnDollar);
                break;

            case "yen": divisa = getString(R.string.btnYen);
                break;

            case "yuan": divisa = getString(R.string.btnYuan);
                break;

            default: divisa = "";
        }

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle(getString(R.string.setValueAlertDialogTitle) + " " + divisa);
        ad.setMessage(getString(R.string.setValueAlertDialogMessage) + " " + divisa);

        final EditText edtValorDivisa = new EditText(this);
        ad.setView(edtValorDivisa);

        ad.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.acceptButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    revisarValorConversio = Float.parseFloat(edtValorDivisa.getText().toString());

                    if (revisarValorConversio <= 0) {
                        throw new Exception("Valor negatiu");
                    }

                    switch (divisaSeleccionada) {
                        case "dollar":
                            valorDollar = revisarValorConversio;
                            valorDeConversioSeleccionat = valorDollar;
                            dollarSeted = true;
                            canviarColorBotoDivisa(btnDollar);
                            break;

                        case "lliura":
                            valorLliura = revisarValorConversio;
                            valorDeConversioSeleccionat = valorLliura;
                            lliuraSeted = true;
                            canviarColorBotoDivisa(btnLliura);
                            break;

                        case "yen":
                            valorYen = revisarValorConversio;
                            valorDeConversioSeleccionat = valorYen;
                            yenSeted = true;
                            canviarColorBotoDivisa(btnYen);
                            break;

                        case "yuan":
                            valorYuan = revisarValorConversio;
                            valorDeConversioSeleccionat = valorYuan;
                            yuanSeted = true;
                            canviarColorBotoDivisa(btnYuan);
                            break;
                    }
                }
                catch (Exception e) {
                    revisarValorConversio = -1;
                    Toast.makeText(getApplicationContext(), getString(R.string.setValueAlertDialogError), Toast.LENGTH_LONG).show();
                }

            }
        });

        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                revisarValorConversio = -1;
            }
        });
        ad.show();
    }

    private void reiniciarDivisa(String divisa) {

        divisa = divisa.toLowerCase();

        switch (divisa) {

            case "pound":
                valorLliura = 0;
                lliuraSeted = false;
                break;

            case "dollar":
                valorDollar = 0;
                dollarSeted = false;
                break;

            case "yen":
                valorYen = 0;
                yenSeted = false;
                break;

            case "yuan":
                valorYuan = 0;
                yuanSeted = false;
                break;
        }

        canviarColorBotoDivisa(null);

    }
}