package com.example.pedro.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor = findViewById(R.id.texto);
    }

    public void salvar(View v){
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String oValor = valor.getText().toString();

        if(oValor.matches("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Digite algo...", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            SharedPreferences.Editor editor = arquivo.edit();
            editor.putString("valor", oValor);
            editor.commit();
        }
    }

    public void carregar(View v) {
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String oValor = arquivo.getString("valor", "Nada salvo");
        valor.setText(oValor);
    }
}
