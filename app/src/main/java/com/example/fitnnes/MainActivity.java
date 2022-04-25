package com.example.fitnnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btnImc = findViewById(R.id.btn_imc);

        btnImc.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ImcActivity.class);
            startActivity(intent);

        });


    }
}