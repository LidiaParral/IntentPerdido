package com.androidprojects.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    static  final int COD_NOMBRE = 1;
    TextView tvTexto2;
    Button btnAtajoCorto;
    Button btnAtajoLargo;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvTexto2 = findViewById(R.id.tvTexto2);
        btnAtajoCorto = findViewById(R.id.btnAtajoCorto);
        btnAtajoLargo = findViewById(R.id.btnAtajoLargo);

        //La información almacenada de la SEGUNDA_ACTIVITY, que proviene de la PRIMERA_ACTIVITY
       dato = getIntent().getStringExtra("NOMBRE");

        tvTexto2.setText(String.format(getResources().getString(R.string.tv_texto2), dato));
    }

    public void atajoCorto(View view) {

        Intent i = new Intent(this, MainActivity4.class);

        i.putExtra(MainActivity.CLAVE_NOMBRE,dato);

        startActivity(i);
        
    }

    public void atajoLargo(View view) {
        Intent i = new Intent(this, MainActivity3.class);

        startActivity(i);
    }
}