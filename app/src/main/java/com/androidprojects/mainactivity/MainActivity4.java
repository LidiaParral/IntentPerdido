package com.androidprojects.mainactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.androidprojects.mainactivity.MainActivity.CLAVE_NOMBRE;

public class MainActivity4 extends AppCompatActivity {

    static final int COD_LLAVE = 100;
    TextView tvTexto3;
    Button btnAbrirPuerta;
    Button btnCogerLlave;
    Boolean llaves;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        llaves = false;

        tvTexto3 = findViewById(R.id.tvTexto3);
        btnAbrirPuerta = findViewById(R.id.btnAbreLaPuerta);
        btnCogerLlave = findViewById(R.id.btnCogeLaLlave);


        dato = getIntent().getStringExtra(CLAVE_NOMBRE);

        tvTexto3.setText(String.format(getResources().getString(R.string.tv_texto3), dato));



    }

    public void abreLaPuerta(View view) {


        if(llaves) {
            Intent i = new Intent(this, MainActivity6.class);


            startActivity(i);
            Toast.makeText(this,R.string.acceder,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,R.string.no_acceder, Toast.LENGTH_LONG).show();
        }

    }

    public void cogerLlave(View view) {


        if(!llaves) {
            Intent i = new Intent(this, MainActivity5.class);

            //Si se quiere volver al activity origen despues de haber finalizado el activity destino, se utiliza siempre el STARTACTIVITYFORRESULT
           //Si desde el MAINACTIVITY4, se pasa a iniciar el MAINACTIVITY5 y luego se quiere volver al MAINACTVITY4.
            startActivityForResult(i, COD_LLAVE);
        } else {
            Toast.makeText(this,R.string.no_acceder, Toast.LENGTH_LONG).show();
        }



    }

//MÉTODO ONACTIVITYRESULT, después de ser invocado por el método SETRESULT de un MAINDESTINO, al volver al MAINORIGEN almacena la información
    //recogida en el MAINDESTINO y para poder trabajar con ella, se requiere éste método, el cual pide un código para la confirmación que haya un código invocado, y SI es un RESULT_OK, quiere decir que esa
    //operación se puede llevar a cabo  Y SINO se indicara con TOAST
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_LLAVE) {
            if (resultCode == RESULT_OK) {
                llaves = true;
                Toast.makeText(this, getString(R.string.acceder), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, getString(R.string.no_acceder), Toast.LENGTH_LONG).show();
            }
        }

    }

}