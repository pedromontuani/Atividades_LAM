package com.example.alunos.jogodochute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int tentativas = 3, numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView lblTentativas = findViewById(R.id.tentativas);
        lblTentativas.setText(lblTentativas.getText() + Integer.toString(tentativas));
        Random gerador = new Random();
        numero = gerador.nextInt(100)+1;
    }

    public void verificador(){
        EditText entrada = findViewById(R.id.campo);
        if(entrada.)
    }
}
