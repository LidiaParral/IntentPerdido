package com.androidprojects.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTexto1;
    EditText etNombre;
    static  final String CLAVE_NOMBRE = "NOMBRE";
    Button btnBusqueda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTexto1 = findViewById(R.id.tvTexto1);
        etNombre = findViewById(R.id.etNombre);
        btnBusqueda = findViewById(R.id.btnBusqueda);

    }

    public void empezarBusqueda(View view) {
        String dato = etNombre.getText().toString();

        if (dato.isEmpty()){
            Intent i2 = new Intent(this, MainActivity.class);
            Toast.makeText(this,R.string.no_nombre, Toast.LENGTH_LONG).show();

            startActivity(i2);

        } else {

            Intent i = new Intent(this, MainActivity2.class);

            i.putExtra("NOMBRE",dato);

            startActivity(i);
        }


    }
}