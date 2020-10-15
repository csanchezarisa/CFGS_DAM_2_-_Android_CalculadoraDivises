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

import com.example.calculadoradivises.classes.divisa;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;
import java.util.ArrayList;

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
    Button btnDivisa;
    Button btnAfegirDivisa;

    // Llistat que anirà emmagatzemant totes les divises que s'han anat introduint al sistema
    ArrayList<divisa> divisesDisponibles = new ArrayList<divisa>();

    // Valor de conversió de la divisa actual
    float valorDeConversioSeleccionat = -1;

    // Emmagatzemarà de manera temporal el valor de conversió que introdueix l'usuari
    float revisarValorConversio = -1;

    // Revisa quan l'input ha estat inicialitzat
    boolean inputInicialitzat = false;

    // Revisa si s'ha posat la coma i els decimals que s'han introduit
    boolean comaPosada = false;
    int decimalsIntroduits = 0;

    // Emmagatzemarà la posició en l'array que ocupa la divisa amb la que s'està treballant
    int divisaSeleccionada = 0;
    int divisaPerRevisar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Es crida al mètode que inicialitza les 4 primeres divises de manera automàtica
        afegirDivisesInicials();

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
        btnDivisa = (Button) findViewById(R.id.btnDivisa);
        btnAfegirDivisa = (Button) findViewById(R.id.btnAfegirDivisa);

        // Botó que permet mostrar el menú de divises i seleccionar-ne una
        btnDivisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertSeleccionarDivisa();
            }
        });

        // Botó que permet mostrar l'alert que permet introduir una nova divisa
        btnAfegirDivisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertAfegirDivisa();
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

        // Botó coma
        btnComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introduirComa();
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

        // BOTÓ ESBORRAR
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esborrar();
            }
        });

        // BOTÓ IGUAL
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ferConversio();
            }
        });

    }


    // Mètode que s'executa al inici del programa. Declara les dues principals divises, amb els noms que trobem al fitxer strings
    private void afegirDivisesInicials() {

        divisa dollar = new divisa(getString(R.string.btnDollar));
        divisa yen = new divisa(getString(R.string.btnYen));
        divisa lliura = new divisa(getString(R.string.btnLliures));
        divisa yuan = new divisa(getString(R.string.btnYuan));

        divisesDisponibles.add(dollar);
        divisesDisponibles.add(yen);
        divisesDisponibles.add(lliura);
        divisesDisponibles.add(yuan);

    }


    // Obre un cuadre de diàlog per que l'usuari introdueixi un valor
    private void demanarValorDeConversio(int possicioLlistatDivises) {
        AlertDialog ad;
        final int divisa = possicioLlistatDivises;
        final String textDivisaSeleccionada = divisesDisponibles.get(divisa).getNomDivisa();

        // Prepàra el quadre de diàlog per que tingui un input i personalitza el missatge que mostra segons els definits en @string
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle(getString(R.string.setValueAlertDialogTitle) + " " + textDivisaSeleccionada);
        ad.setMessage(getString(R.string.setValueAlertDialogMessage) + " " + textDivisaSeleccionada);

        final EditText edtValorDivisa = new EditText(this);
        ad.setView(edtValorDivisa);


        // Botó positiu revisarà el valor introdueit. Si es correcte farà les opcions pertinents, sino, mostrarà un misstge d'error
        ad.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.acceptButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Prova a convertir en número el valor introduit
                try {
                    revisarValorConversio = Float.parseFloat(treureComaPerPunt(edtValorDivisa.getText().toString()));

                    // Si, tot i ser número, el valor introduit és negatiu, llança una excepció fent que "peti" el programa i sorti del try
                    if (revisarValorConversio <= 0) {
                        throw new Exception("Valor negatiu");
                    }

                    // Comprova quina és la divisa seleccionada per fer les operacions sobre una o altre divisa
                    divisesDisponibles.get(divisa).setValorDivisa(revisarValorConversio);
                    divisesDisponibles.get(divisa).setDivisaInicialitzada(true);
                    valorDeConversioSeleccionat = divisesDisponibles.get(divisa).getValorDivisa();
                    valorDeConversioSeleccionat = revisarValorConversio;
                    divisaSeleccionada = divisaPerRevisar;
                    btnDivisa.setText(divisesDisponibles.get(divisaPerRevisar).getNomDivisa());

                }
                catch (Exception e) {
                    revisarValorConversio = -1;
                    Toast.makeText(getApplicationContext(), getString(R.string.setValueAlertDialogError), Toast.LENGTH_LONG).show();
                }

            }
        });

        // Botó negatiu
        ad.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.cancelButton), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                revisarValorConversio = -1;
            }
        });
        ad.show();
    }


    // "Neteja" el TextView Input, per que mostri el missatge predeterminat
    private void netejarInput() {
        txtInput.setText(getString(R.string.txtInputDefault));
        inputInicialitzat = false;
        comaPosada = false;
        decimalsIntroduits = 0;
    }


    // "Neteja" el TextView Output, per que mostri el valor 0
    private void netejarOutput() {
        txtOutput.setText("0");
    }


    // Esborra en 1 els valors del Output
    private void esborrar() {
        String textActualInput = txtInput.getText().toString();
        String nouValorInput = "";

        if (textActualInput.charAt(textActualInput.length() - 1) == ',')
            comaPosada = false;

        if (decimalsIntroduits > 0)
            decimalsIntroduits--;

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


    // Introdueix un número al darrera dels que ja hi han possats
    private void introduirNumero(int numero) {
        if (inputInicialitzat && decimalsIntroduits < 2) {
            txtInput.setText(txtInput.getText().toString() + numero);

            if (comaPosada)
                decimalsIntroduits++;

        }
        else if (!inputInicialitzat) {
            txtInput.setText(String.valueOf(numero));
            inputInicialitzat = true;
        }
    }


    // Introdueix la coma decimal
    private void introduirComa() {
        if (!comaPosada && inputInicialitzat) {
            txtInput.setText(txtInput.getText().toString() + ',');
            comaPosada = true;
        }
    }


    // Es fa la conversió i es mostra el resultat, tractat, en el txtOutput
    private void ferConversio() {

        // Revisa que l'input hagi estat inicialitzat i hi hagi alguna divisa correctament seleccionada
        if (inputInicialitzat && valorDeConversioSeleccionat >= 0) {

            try {
                // Es defineix el format del decimal
                DecimalFormat df = new DecimalFormat("0.00");

                /* Fa la operació, canviant la coma pel punt del input per poder operar, i canviat el punt per la coma per poder mostrar-ho al output.
                * També s'arrodoneix a dos decimals per l'output */
                float input = Float.parseFloat(treureComaPerPunt(txtInput.getText().toString()));
                float resultat =  input * valorDeConversioSeleccionat;
                txtOutput.setText(treurePuntPerComa(String.valueOf(df.format(resultat))));

            }
            catch (Exception e) {

                Toast.makeText(getApplicationContext(), getString(R.string.doConversionError), Toast.LENGTH_LONG).show();

            }

        }
        else {
            Toast.makeText(getApplicationContext(), getString(R.string.doConversionError), Toast.LENGTH_LONG).show();
        }
    }


    // Analitza un string i el retorna canviant la coma per un punt
    private String treureComaPerPunt(String string) {

        String stringSenseComa = "";

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == ',') {
                stringSenseComa = stringSenseComa + '.';
            }
            else {
                stringSenseComa = stringSenseComa + string.charAt(i);
            }

        }

        return stringSenseComa;

    }


    // Analitza un string i el retorna canviat el punt per una coma
    private String treurePuntPerComa(String string) {

        String stringSensePunt = "";

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == '.') {
                stringSensePunt = stringSensePunt + ',';
            }
            else {
                stringSensePunt = stringSensePunt + string.charAt(i);
            }

        }

        return stringSensePunt;

    }


    // Mostra l'alert per seleccionar una divisa i, si no té valor, assignar-li
    private void alertSeleccionarDivisa() {

        AlertDialog.Builder alertDialogSeleccionarDivisa = new AlertDialog.Builder(MainActivity.this);
        alertDialogSeleccionarDivisa.setTitle(getString(R.string.divisa));

        String[] nomsDivises = new String[divisesDisponibles.size()];
        for (int i = 0; i < divisesDisponibles.size(); i++) {
            nomsDivises[i] = divisesDisponibles.get(i).getNomDivisa();
        }

        alertDialogSeleccionarDivisa.setSingleChoiceItems(nomsDivises, divisaSeleccionada, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                divisaPerRevisar = which;

            }
        });

        alertDialogSeleccionarDivisa.setPositiveButton(getString(R.string.acceptButton), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                if (divisesDisponibles.get(divisaPerRevisar).isDivisaInicialitzada()) {
                    divisaSeleccionada = divisaPerRevisar;
                    valorDeConversioSeleccionat = divisesDisponibles.get(divisaPerRevisar).getValorDivisa();
                    btnDivisa.setText(divisesDisponibles.get(divisaPerRevisar).getNomDivisa());
                }
                else {
                    demanarValorDeConversio(divisaPerRevisar);
                }
            }
        });

        alertDialogSeleccionarDivisa.setNegativeButton(getString(R.string.cancelButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                divisaPerRevisar = divisaSeleccionada;

            }
        });

        alertDialogSeleccionarDivisa.setNeutralButton(getString(R.string.restablecerDivisaButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                divisesDisponibles.get(divisaPerRevisar).setDivisaInicialitzada(false);
                btnDivisa.setText(getString(R.string.divisa));
                divisaPerRevisar = divisaSeleccionada;

            }
        });

        alertDialogSeleccionarDivisa.show();

    }


    // Mostra un alert que permet afegir una divisa nova. Demana el nom d'aquesta
    private void alertAfegirDivisa() {

        AlertDialog alertAfegirdivisa = new AlertDialog.Builder(MainActivity.this).create();
        alertAfegirdivisa.setTitle(getString(R.string.afegirDivisa));

        final EditText edtValor = new EditText(this);
        alertAfegirdivisa.setView(edtValor);

        alertAfegirdivisa.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.acceptButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {

                    if (edtValor.getText().toString().length() >= 1) {

                        divisa divisaNova = new divisa(edtValor.getText().toString());
                        divisesDisponibles.add(divisaNova);

                    }
                    else {
                        throw new Exception("Valor no vàlid");
                    }

                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.setValueAlertDialogError), Toast.LENGTH_LONG).show();
                }

            }
        });

        alertAfegirdivisa.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.cancelButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No fa res
            }
        });

        alertAfegirdivisa.show();

    }

}