package com.androidprojects.mainactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {


    static final int COD_LLAVE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


    }

    public void conLlave(View view) {
        //Si se necesitará pasar información habria que invocar al INTENT
        Intent i = getIntent();
        setResult(RESULT_OK,i);
        finish();



    }

    public void sinLlave(View view) {
        setResult(RESULT_CANCELED);
        finish();

    }


}