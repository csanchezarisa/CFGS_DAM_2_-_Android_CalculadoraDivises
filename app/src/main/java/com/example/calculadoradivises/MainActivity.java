package com.example.calculadoradivises;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
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

    // Revisa quan l'input ha estat inicialitzat
    boolean inputInicialitzat = false;

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

        // .: 1. BOTONS DIVISES :.
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
                reiniciarDivisa("yen");
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
                reiniciarDivisa("yuan");
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
                reiniciarDivisa("pound");
                return true;
            }
        });


        // .: 2. BOTONS CALCULADORA - NUMEROS :.
        // Botó 0
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(0);
            }
        });

        // Botó 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(1);
            }
        });

        // Botó 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(2);
            }
        });

        // Botó 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(3);
            }
        });

        // Botó 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(4);
            }
        });

        // Botó 5
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(5);
            }
        });

        // Botó 6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(6);
            }
        });

        // Botó 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(7);
            }
        });

        // Botó 8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(8);
            }
        });

        // Botó 9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirNumero(9);
            }
        });


        // .: 3. BOTONS CALCULADORA - FUNCIONALITATS :.
        // BOTÓ CE
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netejarInput();
                netejarOutput();
            }
        });

        // BOTO ESBORRAR
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esborrar();
            }
        });

    }


    // Canvia els colors dels botons de divises i marca el que es selecciona
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


    // Obre un cuadre de diàlog per que l'usuari introdueixi un valor
    private void demanarValorDeConversio(String divisa) {
        AlertDialog ad;
        divisa = divisa.toLowerCase();
        final String divisaSeleccionada = divisa;

        // Segons quin botó cridi aquest mètode canviarà la variable que mostrarà el missatge
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

        // Prepàra el quadre de diàlog per que tingui un input i personalitza el missatge que mostra segons els definits en @string
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle(getString(R.string.setValueAlertDialogTitle) + " " + divisa);
        ad.setMessage(getString(R.string.setValueAlertDialogMessage) + " " + divisa);

        final EditText edtValorDivisa = new EditText(this);
        ad.setView(edtValorDivisa);

        // Botó positiu revisarà el valor introdueit. Si es correcte farà les opcions pertinents, sino, mostrarà un misstge d'error
        ad.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.acceptButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Prova a convertir en número el valor introduit
                try {
                    revisarValorConversio = Float.parseFloat(edtValorDivisa.getText().toString());

                    // Si, tot i ser número, el valor introduit és negatiu, llança una excepció fent que "peti" el programa i sorti del try
                    if (revisarValorConversio <= 0) {
                        throw new Exception("Valor negatiu");
                    }

                    // Comprova quina és la divisa seleccionada per fer les operacions sobre una o altre divisa
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

        // Botó negatiu
        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                revisarValorConversio = -1;
            }
        });
        ad.show();
    }


    // Reinicia el valor de la divisa seleccionada
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


    // "Neteja" el TextView Input, per que mostri el missatge predeterminat
    private void netejarInput() {
        txtInput.setText(getString(R.string.txtInputDefault));
        inputInicialitzat = false;
    }


    // "Neteja" el TextView Output, per que mostri el valor 0
    private void netejarOutput() {
        txtOutput.setText("0");
    }


    // Esborra en 1 els valors del Output
    private void esborrar() {
        String textActualInput = txtInput.getText().toString();
        String nouValorInput = "";

        if (textActualInput.length() > 1 && inputInicialitzat) {
            for (int i = 0; i < textActualInput.length() - 1; i++) {
                nouValorInput = nouValorInput + textActualInput.charAt(i);
            }
        }
        else {
            nouValorInput = getString(R.string.txtInputDefault);
            inputInicialitzat = false;
        }

        txtInput.setText(nouValorInput);

    }


    //
    private void introduirNumero(int numero) {
        if (inputInicialitzat) {
            txtInput.setText(txtInput.getText().toString() + numero);
        }
        else {
            txtInput.setText(String.valueOf(numero));
            inputInicialitzat = true;
        }
    }
}