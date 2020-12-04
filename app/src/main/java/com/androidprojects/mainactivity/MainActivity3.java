package com.androidprojects.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void malaOpcion(View view) {
        Uri telf = Uri.parse("tel:917407272");

        Intent llamada = new Intent(Intent.ACTION_DIAL,telf);

        if (llamada.resolveActivity(getPackageManager()) != null){
            startActivity(llamada);
        }
    }
}